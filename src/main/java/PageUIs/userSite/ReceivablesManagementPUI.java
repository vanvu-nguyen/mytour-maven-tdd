package PageUIs.userSite;

public class ReceivablesManagementPUI {
    public static final String RECEIVABLE_REGISTER_BUTTON = "XPATH=//div[@class='page-content']//span[text()='Register']/parent::button";
    public static final String VIEW_PAYER_LIST_BUTTON = "XPATH=//label[text()='Payer number']/ancestor::div[@class='ant-form-item']/following-sibling::button";

    public static final String PAYER_NUMBER_SEARCHBOX_IN_MODAL = "XPATH=//input[@name='payerNo']";
    public static final String PAYER_NAME_COLUMN_PRECEDING_SIBLING = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//div[text()='Payer name']/parent::td/preceding-sibling::td";
    public static final String PAYER_ITEM_WITH_PROVIDED_NAME = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//td[%s and text()='%s']/parent::tr[contains(@class,'dx-data-row')]";
    public static final String ECC_DROPDOWN = "XPATH=//label[text()='E-Collection code']/ancestor::div[contains(@class,'ant-form-item-label')]/following-sibling::div//div[@class='ant-select-selector']";
    public static final String THE_FIRST_ECC_ON_LIST = "XPATH=//div[@class='rc-virtual-list-holder-inner']/div[1]";
    public static final String RECEIVABLE_AMOUNT_TEXTBOX = "XPATH=//input[@id='receivableAmt']";
    public static final String RECEIVABLE_START_DATE_PICKER = "XPATH=//input[@id='startDt']";
    public static final String YEAR_PICKER = "XPATH=//div[not(contains(@class,'ant-picker-dropdown-hidden'))]/div[@class='ant-picker-panel-container']//button[@class='ant-picker-year-btn']";
    public static final String DYNAMIC_YEAR_LOCATOR = "XPATH=//div[text()='%s']/parent::td";
    public static final String MONTH_PICKER = "XPATH=//div[not(contains(@class,'ant-picker-dropdown-hidden'))]/div[@class='ant-picker-panel-container']//button[@class='ant-picker-month-btn']";
    public static final String DYNAMIC_MONTH_LOCATOR = "XPATH=//div[text()='%s']/parent::td";
    public static final String DYNAMIC_DATE_LOCATOR = "XPATH=//div[not(contains(@class,'ant-picker-dropdown-hidden'))]/div[@class='ant-picker-panel-container']//div[text()='%s']/parent::td";
    public static final String RECEIVABLE_DUE_DATE_PICKER = "XPATH=//input[@id='endDt']";
    public static final String REF_ID_TEXTBOX = "XPATH=//input[@id='refId']";
    public static final String BUTTON_SAVE_RECEIVABLE = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//span[text()='Register']/parent::button";
    public static final String PAYER_NUMBER_SEARCHBOX = "XPATH=//input[@id='payerNo' and not(contains(@class,'disabled'))]";
    public static final String SEARCH_BUTTON = "XPATH=//span[text()='Search']/parent::button";
    public static final String REF_ID_PRECEDING_COLUMN = "XPATH=//div[text()='Ref ID']/parent::td/preceding-sibling::td";
    public static final String REF_ID_VALUE_ON_LIST = "XPATH=//tr[contains(@class,'dx-data-row')]//td[%s]";
    public static final String DUE_YEAR_PICKER = "XPATH=//div[not(contains(@class,'hidden'))]/div[@class='ant-picker-panel-container']//button[@class='ant-picker-year-btn']";
    public static final String DUE_MONTH_PICKER = "XPATH=//div[not(contains(@class,'hidden'))]/div[@class='ant-picker-panel-container']//button[@class='ant-picker-month-btn']";
    public static final String TODAY_START_OPTION = "XPATH=//a[text()='Today']";
    public static final String TODAY_DUE_OPTION = "XPATH=//div[not(contains(@class,'ant-picker-dropdown-hidden'))]/div[@class='ant-picker-panel-container']//td[contains(@class,'ant-picker-cell-today')]/div";
}
