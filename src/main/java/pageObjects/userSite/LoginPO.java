package pageObjects.userSite;

import PageUIs.userSite.LoginPUI;
import commons.BaseAction;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageGenerator.UserPageGeneratorManager;

public class LoginPO extends BaseAction {
    private WebDriver driver;
    public LoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectEnglishLanguage() {
        //selectItemInCustomDropdown(driver, LoginPUI.LANGUAGE_DROPDOWN, LoginPUI.LANGUAGE_OPTION, "English");
        waitForElementClickable(driver, LoginPUI.LANGUAGE_DROPDOWN);
        clickToElement(driver, LoginPUI.LANGUAGE_DROPDOWN);
        waitForElementClickable(driver, LoginPUI.LANGUAGE_OPTION);
        clickToElement(driver, LoginPUI.LANGUAGE_OPTION);
    }

    public void inputUsername() {
        waitForElementVisible(driver, LoginPUI.USER_NAME_TEXTBOX);
        senkeyToElement(driver, LoginPUI.USER_NAME_TEXTBOX, GlobalConstants.getGlobalConstants().getUserUsername());
    }

    public void inputPassword() {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, GlobalConstants.getGlobalConstants().getUserPassword());
    }

    public DashboardPO clickLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        return UserPageGeneratorManager.getUserDashboardPage(driver);
    }

    public boolean hasLanguageAlreadyChanged() {
        return isElementDisplayed(driver, LoginPUI.USER_NAME_LABEL);
    }
}
