package adminSite.infoPlus.cmsBidv.basicInformation;

import com.github.javafaker.Faker;
import commons.BaseTest;
import pageGenerator.AdminPageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.adminSite.ContractPO;
import pageObjects.adminSite.CustomerPO;
import pageObjects.adminSite.DashboardPO;
import pageObjects.adminSite.LoginPO;
import pojoData.adminSite.ContractInfo;
import pojoData.adminSite.CustomerInfo;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Locale;


public class ContractManagement_01_CreateNewContractWithNewCustomer extends BaseTest {
    private WebDriver driver;
    private String browser;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private CustomerPO customerPage;
    private ContractPO contractPage;
    private CustomerInfo customerInfo;
    private Faker faker = new Faker(new Locale("vi"));
    private String serviceId;
    private String masterId;
    private String contractNumber;
    private String eccPrefix;
    private String accountNumber;
    private ContractInfo contractInfo;

    @Parameters({"browser", "envName", "server", "ipAddress", "portNumber", "subSystem"})
    @BeforeClass
    public void beforeClass(@Optional("") String browser,@Optional("") String envName,@Optional("") String server,@Optional("") String ipAddress,@Optional("") String portNumber,@Optional("") String subSystem) {
        driver = getBrowserDriver(browser, envName, server, ipAddress, portNumber, subSystem);
        this.browser = browser;
        loginPage = AdminPageGeneratorManager.getAdminLoginPage(driver);
        loginPage.selectEnglishLanguage();
    }

    @Test
    public void CreateNewContractWithNewCustomer_01_SuperAdminLogin(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "SuperAdminLogin");
        dashboardPage = loginPage.superAdminLogin();
        Assert.assertTrue(dashboardPage.isExtendButtonDisplayed());
    }

    @Test
    public void CreateNewContractWithNewCustomer_02_CreateNewCustomer(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "CreateNewCustomer");
        dashboardPage.clickToMenuContractManagement();
        customerPage = dashboardPage.clickToSubmenuCustomerManagement();
        customerPage.clickToRegisterButton();
        customerInfo = CustomerInfo.getCustomerInfo();
        customerInfo.setServiceId(String.valueOf(faker.number().randomNumber(6, true)));
        serviceId = customerInfo.getServiceId();
        customerPage.sendkeyToServiceId(serviceId);
        customerInfo.setMerchantId(faker.random().hex());
        customerPage.sendkeyToMerchantId(customerInfo.getMerchantId());
        customerInfo.setMasterId("testUser" + String.valueOf(faker.number().randomNumber(5, true)));
        masterId = customerInfo.getMasterId();
        customerPage.sendkeyToMasterId(masterId);
        customerInfo.setDisplayName(faker.company().name());
        customerPage.sendkeyToDisplayName(customerInfo.getDisplayName());
        customerInfo.setEmail(masterId + "@abc.com");
        customerPage.sendkeyToEmail(customerInfo.getEmail());
        customerInfo.setPhoneNumber("09" + String.valueOf(faker.number().randomNumber(8, true)));
        customerPage.sendkeyToPhoneNumber(customerInfo.getPhoneNumber());
        customerInfo.setBusinessNumber(String.valueOf(faker.number().randomNumber(10, true)));
        customerPage.sendkeyToBusinessNumber(customerInfo.getBusinessNumber());
        customerInfo.setCompanyName(faker.company().name() + faker.number().randomNumber(5, true));
        customerPage.sendkeyToCompanyName(customerInfo.getCompanyName());
        customerInfo.setIssuedPlace(faker.nation().nationality());
        customerPage.sendkeyToIssuedPlace(customerInfo.getIssuedPlace());
        customerPage.selectIssuedDate();
        customerInfo.setCompanyAddress(faker.address().fullAddress());
        customerPage.sendkeyToCompanyAddress(customerInfo.getCompanyAddress());
        customerPage.selectManagementBranchName();
        customerInfo.setRemarks(faker.lordOfTheRings().character());
        customerPage.sendkeyToRemarks(customerInfo.getRemarks());
        customerPage.uploadFileToCompanyLogo("SpaceX-Logo.jpg");
        customerPage.clickToSaveCustomer();
        customerPage.clickToCloseSaveSuccessModal();
        customerPage.sendkeyToServiceIdSearchbox(serviceId);
        customerPage.clickToSearchButton();
        Assert.assertTrue(customerPage.isCustomerListed(serviceId));
    }

    @Test
    public void CreateNewContractWithNewCustomer_03_CreateNewContract(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "CreateNewContract");
        contractPage = customerPage.clickToSubmenuContractManagement();
        contractPage.clickToRegisterContractButton();
        contractPage.clickToSelectServiceIdButton();
        contractPage.sendkeyToServiceIdSearchboxInModal(serviceId);
        
        contractPage.clickToChooseCustomer(serviceId);
        contractPage.clickToSelectCustomer();
        contractPage.selectToDepartment();
        contractPage.clickToSelectStaffCodeButton();
        contractPage.clickToChooseStaff();
        contractPage.clickToSelectStaff();
        contractInfo = ContractInfo.getContractInfo();
        contractInfo.setContractNumber(String.valueOf(faker.number().randomNumber(10, true)));
        contractNumber = contractInfo.getContractNumber();
        contractPage.sendkeyToContractNumber(contractNumber);
        contractPage.sendkeyToContractDate();
        contractInfo.setEccPrefix(faker.letterify("????"));
        eccPrefix = contractInfo.getEccPrefix();
        contractPage.sendkeyToEccPrefix(eccPrefix);
        contractPage.clickToEcollectionTabServiceFee();
        contractPage.clickToAddAccount();
        contractInfo.setAccountNumber(String.valueOf(faker.number().randomNumber(12, true)));
        accountNumber = contractInfo.getContractNumber();
        contractPage.sendkeyToAccountNumber(accountNumber);
        contractPage.clickToUseService();
        contractPage.clickToSaveContractButton();
        contractPage.clickToCloseSaveSuccessModal();
        contractPage.sendkeyToContractNumberSearchbox(contractNumber);
        Assert.assertTrue(contractPage.isContractListed(contractNumber));
    }

    //@AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowser(driver);
    }
}
