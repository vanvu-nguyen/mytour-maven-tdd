package PageUIs.userSite;

public class EcollectionManagementPUI {
    public static final String BUTTON_MAP_EC = "XPATH=//div[@class='page-content']//span[text()='Map EC']/parent::button";
    public static final String VIEW_PAYER_LIST_BUTTON = "XPATH=//form[@id='formSubmit']//label[text()='Payer number']//ancestor::div[@class='ant-form-item']/following-sibling::button";
    public static final String PAYER_NAME_SEARCHBOX_IN_MODAL = "XPATH=//input[@name='payerNm']";
    public static final String CORRECT_PAYER_ON_LIST = "XPATH=//div[@class='data']//td[3 and text()='%s']/parent::tr";
    public static final String VIEW_ECOLLECTION_CODE_LIST_BUTTON = "XPATH=//form[@id='formSubmit']//label[text()='E-Collection code']//ancestor::div[@class='ant-form-item']/following-sibling::button";
    public static final String CHOSEN_ECC_ON_LIST = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//div[contains(@class,'dx-datagrid-rowsview')]//tr[1]";
    public static final String ECC_NAME_TEXTBOX = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//input[@id='ecolInfoNm']";
    public static final String SAVE_MAPPING_BUTTON = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//span[text()='Map EC']/parent::button";
    public static final String ECC_SEARCHBOX = "XPATH=//input[@id='control-hooks_ecolCd']";
    public static final String ECC_SEARCH_BUTTON = "XPATH=//span[text()='Search']/parent::button";
    public static final String PHONE_NUMBER_PRECEDING_COLUMN = "XPATH=//td[@aria-label='Column Phone number' and contains(@class,'dx-datagrid-action')]/preceding-sibling::td";
    public static final String PHONE_NUMBER_COLUMN_VALUE = "XPATH=//tr[contains(@class,'dx-data-row')]//td[%s]";
    public static final String ECC_CODE_TEXT = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//input[@id='ecolCd']";








}
