package commons;

import com.mysql.cj.xdevapi.DocResultImpl;
import org.openqa.selenium.WebDriver;
import pageObjects.adminSite.DepartmentPO;
import pageObjects.adminSite.LoginPO;
import pageObjects.adminSite.UserPO;
import pageObjects.supportPlatform.TempMailPO;

public class BaseAction extends BasePage {
    WebDriver driver;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
    }

    public void waitLoadingIconInvisible() {
        waitForListElementInvisible(driver, BaseElement.LOADING_ICON);
    }

    public void goToMenuItemByName(String menuName) {
        waitForElementClickable(driver, BaseElement.DYNAMIC_MENU_BY_NAME, menuName);
        clickToElement(driver, BaseElement.DYNAMIC_MENU_BY_NAME, menuName);

    }

    public DepartmentPO clickToSubmenuDepartment() {
        waitForElementClickable(driver, BaseElement.DEPARTMENT_SUBMENU);
        clickToElement(driver, BaseElement.DEPARTMENT_SUBMENU);
        return PageGeneratorManager.getDepartmentPage(driver);
    }

    public UserPO clickToSubmenuUser() {
        waitForElementClickable(driver, BaseElement.USER_SUBMENU);
        clickToElement(driver, BaseElement.USER_SUBMENU);
        return PageGeneratorManager.getUserPage(driver);
    }

    public LoginPO logOut() {
        hoverToElement(driver, BaseElement.TOP_RIGHT_DROPDOWN);
        waitForElementClickable(driver, BaseElement.LOG_OUT_BUTTON);
        clickToElement(driver, BaseElement.LOG_OUT_BUTTON);
        waitForElementClickable(driver, BaseElement.LOG_OUT_MODAL_BUTTON);
        clickToElement(driver, BaseElement.LOG_OUT_MODAL_BUTTON);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public TempMailPO switchToTempSite(String tempMailTitle) {
        switchToWindowByTitle(driver, tempMailTitle);
        return PageGeneratorManager.getTempMailPage(driver);
    }

}


