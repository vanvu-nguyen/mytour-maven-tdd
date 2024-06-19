package commons;

import PageUIs.adminSite.DashboardPUI;
import PageUIs.adminSite.LoginPUI;
import baseElement.AdminBaseElement;
import baseElement.UserBaseElement;
import org.openqa.selenium.WebDriver;
import pageGenerator.AdminPageGeneratorManager;
import pageGenerator.UserPageGeneratorManager;
import pageObjects.adminSite.*;
import pageObjects.supportPlatform.TempMailPO;
import pageObjects.userSite.EcollectionManagementPO;
import pageObjects.userSite.PayerManagementPO;
import pageObjects.userSite.ReceivablesManagementPO;

public class BaseAction extends BasePage {
    WebDriver driver;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
    }

    public void waitLoadingIconInvisible() {
        waitForListElementInvisible(driver, AdminBaseElement.LOADING_ICON);
    }

    public void goToMenuItemByName(String menuName) {
        waitForElementClickable(driver, AdminBaseElement.DYNAMIC_MENU_BY_NAME, menuName);
        clickToElement(driver, AdminBaseElement.DYNAMIC_MENU_BY_NAME, menuName);

    }

    public DepartmentPO clickToSubmenuDepartmentManagement() {
        waitForElementClickable(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "Department management");
        clickToElement(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "Department management");
        return AdminPageGeneratorManager.getAdminDepartmentPage(driver);
    }

    public UserPO clickToSubmenuUser() {
        waitForElementClickable(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "User management");
        clickToElement(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "User management");
        return AdminPageGeneratorManager.getAdminUserPage(driver);
    }

    public LoginPO logOut() {
        hoverToElement(driver, AdminBaseElement.TOP_RIGHT_DROPDOWN);
        waitForElementClickable(driver, AdminBaseElement.LOG_OUT_BUTTON);
        clickToElement(driver, AdminBaseElement.LOG_OUT_BUTTON);
        waitForElementClickable(driver, AdminBaseElement.LOG_OUT_MODAL_BUTTON);
        clickToElement(driver, AdminBaseElement.LOG_OUT_MODAL_BUTTON);
        return AdminPageGeneratorManager.getAdminLoginPage(driver);
    }

    public TempMailPO switchToTempMailSite(String tempMailTitle) {
        switchToWindowByTitle(driver, tempMailTitle);
        return AdminPageGeneratorManager.getTempMailPage(driver);
    }

    public TempMailPO openTempMailSite() {
        goToTempMailSite(driver);
        return AdminPageGeneratorManager.getTempMailPage(driver);
    }
    public UserPO switchToCmsAdminPage(String siteTitle) {
        switchToWindowByTitle(driver, siteTitle);
        return AdminPageGeneratorManager.getAdminUserPage(driver);
    }

    public LoginPO switchToCmsPage(String cmsTitle) {
        switchToWindowByTitle(driver, cmsTitle);
        return AdminPageGeneratorManager.getAdminLoginPage(driver);
    }

    public DashboardPO superAdminLogin() {
        waitForElementVisible(driver, LoginPUI.USER_ID_TEXTBOX);
        senkeyToElement(driver, LoginPUI.USER_ID_TEXTBOX, GlobalConstants.getGlobalConstants().getAdminUsername());
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, GlobalConstants.getGlobalConstants().getAdminPassword());
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        return AdminPageGeneratorManager.getAdminDashboardPage(driver);
    }

    public boolean isExtendButtonDisplayed() {
        return isElementDisplayed(driver, DashboardPUI.EXTEND_BUTTON);
    }

    public void clickToCloseSaveSuccessModal() {
        waitForElementClickable(driver, UserBaseElement.SUCCESS_MODAL_CLOSE_BUTTON);
        clickToElement(driver, UserBaseElement.SUCCESS_MODAL_CLOSE_BUTTON);
    }

    public CustomerPO clickToSubmenuCustomerManagement() {
        waitForElementClickable(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "Customer management");
        clickToElement(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "Customer management");
        return AdminPageGeneratorManager.getAdminCustomerPage(driver);
    }

    public ContractPO clickToSubmenuContractManagement() {
        waitForElementClickable(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "Contract management");
        clickToElement(driver, AdminBaseElement.DYNAMIC_SUBMENU_BY_NAME, "Contract management");
        return AdminPageGeneratorManager.getAdminContractPage(driver);
    }

    public PayerManagementPO clickToPayerManagementSubmenuOnUserSite() {
        waitForElementClickable(driver, UserBaseElement.PAYER_MANAGEMENT_SUBMENU);
        clickToElement(driver, UserBaseElement.PAYER_MANAGEMENT_SUBMENU);
        return UserPageGeneratorManager.getUserPayerManagementPage(driver);
    }

    public void clickToUserSiteMenuByName(String menuName) {
        waitForElementClickable(driver, UserBaseElement.DYNAMIC_MENU_LOCATOR, menuName);
        clickToElement(driver, UserBaseElement.DYNAMIC_MENU_LOCATOR, menuName);
    }

    public EcollectionManagementPO clickToEcollectionManagementSubmenu() {
        waitForElementClickable(driver, UserBaseElement.ECOLLECTION_MANAGEMENT_SUBMENU);
        clickToElement(driver, UserBaseElement.ECOLLECTION_MANAGEMENT_SUBMENU);
        return UserPageGeneratorManager.getEcollectionManagementPage(driver);
    }

    public void clickToEcollectionMenu() {
        waitForElementClickable(driver, UserBaseElement.DYNAMIC_MENU_LOCATOR, "E-Collection");
        clickToElement(driver, UserBaseElement.DYNAMIC_MENU_LOCATOR, "E-Collection");
    }

    public ReceivablesManagementPO clickToReceivablesManagementSubmenuOnUserSite() {
        waitForElementClickable(driver, UserBaseElement.RECEIVABLES_MANAGEMENT_SUBMENU);
        clickToElement(driver, UserBaseElement.RECEIVABLES_MANAGEMENT_SUBMENU);
        return UserPageGeneratorManager.getReceivablesManagementPage(driver);
    }
}


