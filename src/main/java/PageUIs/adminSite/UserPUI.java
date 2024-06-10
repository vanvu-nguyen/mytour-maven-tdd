package PageUIs.adminSite;

public class UserPUI {
    public static final String REGISTER_USER_BUTTON = "XPATH=//span[text()='Register']/parent::button";
    public static final String USER_ID_TEXTBOX = "XPATH=//input[@id='userId']";
    public static final String USERNAME_TEXTBOX = "XPATH=//input[@id='userNm']";
    public static final String USER_GROUP_DROPDOWN_PARENT_LOCATOR = "XPATH=//input[@id='authCd']";
    public static final String USER_GROUP_DROPDOWN_CHILD_LOCATOR = "XPATH=//div[@class='ant-select-item-option-content']";
    public static final String DEPARTMENT_DROPDOWN_PARENT_LOCATOR = "XPATH=//input[@id='deptCd']";
    public static final String DEPARTMENT_DROPDOWN_CHILD_LOCATOR = "XPATH=//div[contains(@class,'ant-select-item-option')]";
    public static final String USER_MOBILE_TEXTBOX = "XPATH=//input[@id='telNo']";
    public static final String USER_EMAIL_TEXTBOX = "XPATH=//input[@id='email']";
    public static final String STAFF_CODE_TEXTBOX = "XPATH=//input[@id='staffCd']";
    public static final String SAVE_USER_BUTTON = "XPATH=//span[text()='Save']/parent::button";
    public static final String SUCCESS_NOTI_CLOSE_BUTTON = "XPATH=//span[text()='Close']/parent::button";
    public static final String USER_ID_SEARCHBOX = "XPATH=//label[text()='User ID']/parent::div/following-sibling::div[1]/input";
    public static final String SEARCH_BUTTON = "XPATH=//span[text()='Search']/parent::button";
    public static final String USER_ID_PREVIOUS_COLUMN = "XPATH=//div[text()='User ID']/parent::td/preceding-sibling::td";
    public static final String USER_ID_DATA_LOCATOR = "XPATH=//div[contains(@class,'dx-datagrid-rowsview')]//td[%s]";
}
