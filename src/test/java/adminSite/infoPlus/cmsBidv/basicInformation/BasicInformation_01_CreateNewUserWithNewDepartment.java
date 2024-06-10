package adminSite.infoPlus.cmsBidv.basicInformation;

import PageUIs.adminSite.LoginPUI;
import com.github.javafaker.Faker;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.adminSite.DashboardPO;
import pageObjects.adminSite.DepartmentPO;
import pageObjects.adminSite.LoginPO;
import pageObjects.adminSite.UserPO;

import pageObjects.supportPlatform.TempMailPO;
import pojoData.DepartmentInfo;
import pojoData.UserInfo;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Locale;


public class BasicInformation_01_CreateNewUserWithNewDepartment extends BaseTest {
    private WebDriver driver;
    private String browser;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private DepartmentPO departmentPage;
    private UserPO userPage;
    private Faker faker = new Faker(new Locale("vi"));
    private String departmentCode;
    private String departmentName;
    private DepartmentInfo departmentInfo;
    private String cmsTitle;
    private TempMailPO tempMailPage;
    private String tempMailTitle;
    private String userTempMailAddress;
    private UserInfo userInfo;
    private String userId;
    private String originUserPassword;


    @Parameters({"browser", "envName", "server", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("") String browser,@Optional("") String envName,@Optional("") String server,@Optional("") String ipAddress,@Optional("") String portNumber) {
        driver = getBrowserDriver(browser, envName, server, ipAddress, portNumber);
        cmsTitle = driver.getTitle();
        this.browser = browser;
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.selectItemInCustomDropdown(driver, LoginPUI.LANGUAGE_DROPDOWN_PARENT_LOCATOR, LoginPUI.LANGUAGE_DROPDOWN_CHILD_LOCATOR, "English");
    }

    @Test
    public void CreateNewUserWithNewDepartment_01_SuperAdminLogin(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "SuperAdminLogin");
        dashboardPage = loginPage.SuperAdminLogin();
    }

    @Test
    public void CreateNewUserWithNewDepartment_02_CreateNewDepartment(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "CreateNewDepartment");
        dashboardPage.clickToMenuItemByName("Basic Information");
        departmentPage = dashboardPage.clickToSubmenuDepartment();
        departmentInfo = DepartmentInfo.getDepartmentInfo();
        departmentInfo.setDepartmentCode(String.valueOf(faker.number().randomNumber(5, true)));
        departmentCode = departmentInfo.getDepartmentCode();
        departmentPage.sendkeyToDepartmentCode(departmentCode);
        departmentInfo.setDepartmentName(String.valueOf(faker.team().name()));
        departmentName = departmentInfo.getDepartmentName();
        departmentPage.sendkeyToDepartmentName(departmentName);
        departmentPage.clickToSaveDepartment();
        departmentPage.clickToCloseSaveSuccessModal();
        //Verify
        departmentPage.senkeyToDepartmentCodeSearchbox(departmentCode);
        departmentPage.clickToSearchButton();
        Assert.assertTrue(departmentPage.isDepartmentInfoListed(departmentCode));
    }

    @Test
    public void CreateNewUserWithNewDepartment_03_CreateNewUser(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "CreateNewUser");
        userPage = departmentPage.clickToSubmenuUser();
        userPage.clickToRegisterButton();
        tempMailPage = userPage.openTempMailSite();
        tempMailTitle = tempMailPage.getCurrentPageTitle();
        tempMailPage.waitForLoadingIconInvisible();
        userTempMailAddress = tempMailPage.getGeneratedMailAddress();
        userPage = tempMailPage.switchToCmsAdminPage(cmsTitle);
        userInfo = UserInfo.getUserInfo();
        userInfo.setUserID(faker.idNumber().valid());
        userInfo.setUserName(faker.name().fullName());
        userInfo.setUserMobile("09" + faker.number().randomNumber(8, true));
        userInfo.setStaffCode(String.valueOf(faker.number().randomNumber(6, true)));
        userId = userInfo.getUserID();
        userPage.senkeyToUserID(userId);
        userPage.senkeyToUserName(userInfo.getUserName());
        userPage.selectUserGroup("Department Master");
        userPage.selectUserDepartment(departmentName);
        userPage.senkeyToUserMobile(userInfo.getUserMobile().trim().replace(" ", ""));
        userPage.senkeyToUserEmail(userTempMailAddress);
        userPage.senkeyToStaffCode(userInfo.getStaffCode());
        userPage.clickToSaveUser();
        userPage.clickToCloseSaveSuccessModal();
        //Verify
        userPage.senkeyToUserIdSearchbox(userId);
        userPage.clickToSearchButton();
        Assert.assertTrue(userPage.isUserIdListed(userId));
    }

    @Test
    public void CreateNewUserWithNewDepartment_04_NewUserLogin(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run on " + browser.toUpperCase(), "NewUserLogin");
        loginPage = userPage.logOut();
        tempMailPage = loginPage.switchToTempSite(tempMailTitle);
        tempMailPage.openLatestMail();
        originUserPassword = tempMailPage.getPasswordInfo();
        loginPage = tempMailPage.switchToCmsLoginPage(cmsTitle);
        loginPage.userLogin(userId, originUserPassword);
        dashboardPage = loginPage.resetPassword();
        //Verify
        Assert.assertTrue(dashboardPage.isExtendButtonDisplayed());
    }

    //@AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowser(driver);
    }

}
