package PageUIs.userSite;

public class PayerManagementPUI {
    public static final String PAGE_TITLE = "XPATH=//h3[text()='Payer Management']";
    public static final String BUTTON_REGISTER_PAYER = "XPATH=//span[text()='Register']/parent::button";
    public static final String PAYER_NAME_TEXTBOX = "XPATH=//div[@class='regis-card']//input[@id='control-hooks_payerNm']";
    public static final String PHONE_NUMBER_TEXTBOX = "XPATH=//div[@class='regis-card']//input[@id='control-hooks_payerTel']";
    public static final String AUTOMAP_DROPDOWN = "XPATH=//div[contains(@class,'regis-card-content')]//span[text()='Automap']/parent::div/following-sibling::div[1]//div[@class='ant-select-selector']";
    public static final String NO_AUTOMAP_OPTION = "XPATH=//div[@class='ant-select-item-option-content' and text()='No']";
    public static final String BUTTON_SAVE_PAYER = "XPATH=//span[text()='Save']/parent::button";
    public static final String BUTTON_CLOSE_SUCCESSFUL_MODAL = "XPATH=//span[text()='Close']/parent::button";
    public static final String PHONE_NUMBER_SEARCHBOX = "XPATH=//div[contains(@class,'search-group')]//input[@id='control-hooks_payerTel']";
    public static final String BUTTON_SEARCH = "XPATH=//span[text()='Search']/parent::button";
    public static final String PAYER_NAME_PRECEDING_COLUMNS = "XPATH=//div[text()='Payer name']/parent::td[@role='columnheader']/preceding-sibling::td";
    public static final String PAYER_NAME_COLUMN_VALUES = "XPATH=//tr[contains(@class,'dx-data-row')]/td[%s]";
    public static final String PAYER_NUMBER_PRECEDING_COLUMN = "XPATH=//td[@aria-label='Column Payer number']/preceding-sibling::td";
    public static final String PAYER_NUMBER_VALUE_ON_LIST = "XPATH=//div[contains(@class,'dx-datagrid-rowsview')]//tr[not(contains(@class,'invisible'))]//td[%s]";


}
