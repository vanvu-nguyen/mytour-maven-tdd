package pageObjects.adminSite;

import PageUIs.adminSite.UserPUI;
import commons.BaseAction;
import org.openqa.selenium.WebDriver;

public class UserPO extends BaseAction {
    private WebDriver driver;

    public UserPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserPUI.REGISTER_USER_BUTTON);
        clickToElement(driver, UserPUI.REGISTER_USER_BUTTON);
    }



    public void senkeyToUserID(String userId) {
        waitForElementVisible(driver, UserPUI.USER_ID_TEXTBOX);
        senkeyToElement(driver, UserPUI.USER_ID_TEXTBOX, userId);
    }

    public void senkeyToUserName(String userName) {
        waitForElementVisible(driver, UserPUI.USERNAME_TEXTBOX);
        senkeyToElement(driver, UserPUI.USERNAME_TEXTBOX, userName);
    }

    public void selectUserGroup(String userGroupName) {
        selectItemInCustomDropdown(driver, UserPUI.USER_GROUP_DROPDOWN_PARENT_LOCATOR, UserPUI.USER_GROUP_DROPDOWN_CHILD_LOCATOR, userGroupName);
    }

    public void selectUserDepartment(String userDepartment) {
        waitForElementVisible(driver, UserPUI.DEPARTMENT_DROPDOWN_PARENT_LOCATOR);
        senkeyToElement(driver, UserPUI.DEPARTMENT_DROPDOWN_PARENT_LOCATOR, userDepartment);
        selectItemInCustomDropdownByTitle(driver, UserPUI.DEPARTMENT_DROPDOWN_PARENT_LOCATOR, UserPUI.DEPARTMENT_DROPDOWN_CHILD_LOCATOR, userDepartment);
    }

    public void senkeyToUserMobile(String useMobile) {
        waitForElementVisible(driver, UserPUI.USER_MOBILE_TEXTBOX);
        senkeyToElement(driver, UserPUI.USER_MOBILE_TEXTBOX, useMobile);
    }

    public void senkeyToUserEmail(String userTempMailAddress) {
        waitForElementVisible(driver, UserPUI.USER_EMAIL_TEXTBOX);
        senkeyToElement(driver, UserPUI.USER_EMAIL_TEXTBOX, userTempMailAddress);
    }

    public void senkeyToStaffCode(String staffCode) {
        waitForElementVisible(driver, UserPUI.STAFF_CODE_TEXTBOX);
        senkeyToElement(driver, UserPUI.STAFF_CODE_TEXTBOX, staffCode);
    }

    public void clickToSaveUser() {
        waitForElementClickable(driver, UserPUI.SAVE_USER_BUTTON);
        clickToElement(driver, UserPUI.SAVE_USER_BUTTON);
    }

    public boolean isUserIdListed(String userId) {
        int previousColumnNumber = getListElementSize(driver, UserPUI.USER_ID_PREVIOUS_COLUMN);
        String orderOfUserIdColumn = String.valueOf(previousColumnNumber + 1);
        String actualUserId = getElementText(driver, UserPUI.USER_ID_DATA_LOCATOR, orderOfUserIdColumn);
        return actualUserId.equals(userId);
    }

    public void senkeyToUserIdSearchbox(String userId) {
        waitForElementVisible(driver, UserPUI.USER_ID_SEARCHBOX);
        senkeyToElement(driver, UserPUI.USER_ID_SEARCHBOX, userId);
    }

    public void clickToSearchUserButton() {
        waitForElementClickable(driver, UserPUI.SEARCH_BUTTON);
        clickToElement(driver, UserPUI.SEARCH_BUTTON);
    }
}
