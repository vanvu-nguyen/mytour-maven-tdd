package PageUIs.adminSite;

public class CustomerPUI {
    public static final String CUSTOMER_REGISTER_BUTTON = "XPATH=//span[text()='Register']/parent::button";
    public static final String SERVICE_ID_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='customerNo']";
    public static final String MERCHANT_ID_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='merchantId']";
    public static final String MASTER_ID_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='masterId']";
    public static final String DISPLAY_NAME_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='userNm']";
    public static final String EMAIL_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='email']";
    public static final String PHONE_NUMBER_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='telNo']";
    public static final String BUSINESS_NUMBER_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='bizNo']";
    public static final String CUSTOMER_NAME_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='customerNm']";
    public static final String ISSUED_PLACE_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='issuedPlace']";
    public static final String ISSUED_DATE_PICKER = "XPATH=//div[@class='insert add-department']//input[@id='issuedDt']";
    public static final String PICK_YEAR_BUTTON = "XPATH=//button[@class='ant-picker-year-btn']";
    public static final String DYNAMIC_YEAR_LOCATOR_2020_2029 = "XPATH=//div[@class='ant-picker-cell-inner' and text()='%s']";
    public static final String PICK_MONTH_BUTTON = "XPATH=//button[@class='ant-picker-month-btn']";
    public static final String DYNAMIC_MONTH_LOCATOR = "XPATH=//div[@class='ant-picker-cell-inner' and text()='%s']";
    public static final String DYNAMIC_DATE_LOCATOR = "XPATH=//div[@class='ant-picker-cell-inner' and text()='%s']";
    public static final String COMPANY_ADDRESS_TEXTBOX = "XPATH=//div[@class='insert add-department']//input[@id='customerAddr']";
    public static final String BRANCH_NAME_PARENT_LOCATOR = "XPATH=//div[@class='insert add-department']//input[@id='branchCd']";
    public static final String BRANCH_NAME_CHILD_LOCATOR = "XPATH=//div[@class='ant-select-item-option-content']";
    public static final String REMARKS_TEXTBOX = "XPATH=//textarea[@id='remarks']";
    public static final String COMPANY_LOGO_UPLOAD = "XPATH=//input[@id='image']";
    public static final String SAVE_CUSTOMER_BUTTON = "XPATH=//span[text()='Save']/parent::button";
    public static final String SERVICE_ID_SEARCHBOX = "XPATH=//div[@class='page-content-template']//input[@id='customerNo']";
    public static final String SEARCH_CUSTOMER_BUTTON = "XPATH=//span[text()='Search']/parent::button";
    public static final String SERVICE_ID_PREVIOUS_COLUMN = "XPATH=//div[text()='Service ID']/parent::td/preceding-sibling::td";
    public static final String SERVICE_ID_DATA_LOCATOR = "XPATH=//div[contains(@class,'dx-datagrid-rowsview')]//td[%s]";

}
