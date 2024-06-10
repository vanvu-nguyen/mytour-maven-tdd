package PageUIs.adminSite;

public class DepartmentPUI {
    public static final String DEPARTMENT_CODE_TEXTBOX = "xpath=//div[@class='insert edit-department']//label[text()='Department code']/parent::div/following-sibling::div//input";
    public static final String DEPARTMENT_NAME_TEXTBOX = "xpath=//div[@class='insert edit-department']//label[text()='Department name']/parent::div/following-sibling::div//input";
    public static final String SAVE_DEPARTMENT_BUTTON = "xpath=//span[text()='Save']/parent::button";
    public static final String SUCCESS_NOTI_CLOSE_BUTTON = "xpath=//div[contains(@class,'ant-modal-confirm-success')]//span[text()='Close']/parent::button";
    public static final String DEPARTMENT_CODE_SEARCHBOX = "XPATH=(//label[text()='Department code']/parent::div/following-sibling::div/input)[1]";
    public static final String DEPARTMENT_SEARCH_BUTTON = "XPATH=//span[text()='Search']/parent::button";
    public static final String DEPARTMENT_CODE_PREVIOUS_COLUMN = "XPATH=//div[text()='Department code']/parent::td/preceding-sibling::td";
    public static final String DEPARTMENT_CODE_DATA_LOCATOR = "XPATH=//div[@class='dx-datagrid-content']//tr[contains(@class,'dx-data-row')]/td[%s]";

}
