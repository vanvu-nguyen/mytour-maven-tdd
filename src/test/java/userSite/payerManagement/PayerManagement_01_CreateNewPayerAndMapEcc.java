package userSite.payerManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pageObjects.userSite.*;
import com.github.javafaker.Faker;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageGenerator.UserPageGeneratorManager;
import pojoData.userSite.PayerInfo;
import pojoData.userSite.ReceivableInfo;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Locale;


public class PayerManagement_01_CreateNewPayerAndMapEcc extends BaseTest {
    private WebDriver driver;
    private String browser;
    private Faker faker = new Faker(new Locale("vi"));
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private PayerManagementPO payerManagementPage;
    private PayerInfo payerInfo;
    private String payerName;
    private String payerPhoneNumber;
    private EcollectionManagementPO ecollectionManagementPage;
    private Actions actions;
    private String ecCode;
    private ReceivablesManagementPO receivablesManagementPage;
    private String payerNumber;
    private ReceivableInfo receivableInfo;
    private String refId;


    @Parameters({"browser", "envName", "server", "ipAddress", "portNumber", "subSystem"})
    @BeforeClass
    public void beforeClass(@Optional("") String browser,@Optional("") String envName,@Optional("") String server,@Optional("") String ipAddress,@Optional("") String portNumber,@Optional("") String subSystem) {
        driver = getBrowserDriver(browser, envName, server, ipAddress, portNumber, subSystem);
        this.browser = browser;
        loginPage = UserPageGeneratorManager.getUserLoginPage(driver);
        loginPage.selectEnglishLanguage();
        Assert.assertTrue(loginPage.hasLanguageAlreadyChanged());
    }

    @Test
    public void CreateNewPayerAndMapEcc_01_UserLogin(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "UserLogin");
        loginPage.inputUsername();
        loginPage.inputPassword();
        dashboardPage = loginPage.clickLoginButton();
        Assert.assertTrue(dashboardPage.isLogOutButtonDisplayedOnUserSite());
    }

    @Test
    public void CreateNewPayerAndMapEcc_02_CreateNewPayer(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "CreateNewPayer");
        payerManagementPage = dashboardPage.clickToPayerManagementSubmenuOnUserSite();
        //Verify
        Assert.assertTrue(payerManagementPage.hasPayerManagementPageLoaded());

        payerManagementPage.clickToRegisterPayer();
        payerInfo = PayerInfo.getPayerInfo();
        payerInfo.setPayerName(faker.name().fullName());
        payerName = payerInfo.getPayerName();
        payerManagementPage.inputPayerName(payerName);
        payerInfo.setPayerPhoneNumber(String.valueOf("09" + faker.number().randomNumber(8, true)));
        payerPhoneNumber = payerInfo.getPayerPhoneNumber();
        payerManagementPage.inputPhoneNumber(payerPhoneNumber);
        payerManagementPage.selectNotAutoMap();
        payerManagementPage.clickToSavePayerButton();
        payerManagementPage.closeSaveSuccessfulModal();
        //Verify
        payerManagementPage.inputPhoneNumberSearchbox(payerPhoneNumber);
        payerManagementPage.clickToSearchButton();
        Assert.assertTrue(payerManagementPage.isCreatedPayerListed(payerName));
        payerNumber = payerManagementPage.getPayerNumber();
    }

    @Test
    public void CreateNewPayerAndMapEcc_03_MapPayerWithEcc(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "MapPayerWithEcc");
        payerManagementPage.clickToEcollectionMenu();
        ecollectionManagementPage = payerManagementPage.clickToEcollectionManagementSubmenu();
        ecollectionManagementPage.clickToMapEccButton();
        ecollectionManagementPage.clickToViewPayerList();
        ecollectionManagementPage.inputPayerNameToSearchboxInModal(payerName);
        actions = new Actions(driver);
        actions.keyDown(Keys.RETURN).release().perform();
        ecollectionManagementPage.clickToChoosePayer(payerName);
        ecollectionManagementPage.clickToViewEccList();
        ecollectionManagementPage.clickToChooseTheFirstEcc();
        ecCode = ecollectionManagementPage.getEcCode();
        ecollectionManagementPage.renameTheChosenEccHoldername();
        ecollectionManagementPage.clickToSaveMappingEcc();
        ecollectionManagementPage.clickToCloseSaveSuccessModal();
        //Verify
        ecollectionManagementPage.inputToEccSearchbox(ecCode);
        ecollectionManagementPage.clickToSearchEccButton();
        Assert.assertTrue(ecollectionManagementPage.isMappedPayerPhoneNumberList(payerPhoneNumber));
    }

    @Test
    public void CreateNewPayerAndMapEcc_04_CreateNewReceivable(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "CreateNewReceivable");
        receivablesManagementPage = ecollectionManagementPage.clickToReceivablesManagementSubmenuOnUserSite();
        receivablesManagementPage.clickToRegisterReceivableButton();
        receivablesManagementPage.clickToViewPayerList();
        receivablesManagementPage.inputThePayerNumberToSearchboxInModal(payerNumber);
        actions.keyDown(Keys.RETURN).release().perform();
        receivablesManagementPage.clickToChooseThePayerOnResultList(payerName);
        receivablesManagementPage.selectTheEccAtTop();
        receivablesManagementPage.inputTheReceivableAmount();
        receivablesManagementPage.selectTheStartDate();
        receivablesManagementPage.selectTheDueDate();
        receivableInfo = ReceivableInfo.getReceivableInfo();
        receivableInfo.setRefId(faker.letterify("????") + String.valueOf(faker.number().randomNumber(4, true)));
        refId = receivableInfo.getRefId();
        receivablesManagementPage.inputToRefId(refId);
        receivablesManagementPage.clickToRegisterReceivable();
        receivablesManagementPage.clickToCloseSaveSuccessModal();
        //Verify
        receivablesManagementPage.inputToPayerNumberSearchbox(payerNumber);
        receivablesManagementPage.clickToSearchReceivableButton();
        Assert.assertTrue(receivablesManagementPage.isReceivableCreated(refId));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowser(driver);
    }
}
