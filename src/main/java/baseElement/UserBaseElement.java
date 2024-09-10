package baseElement;

public class UserBaseElement {
    public static final String PAYER_MANAGEMENT_SUBMENU = "XPATH=//span[text()='Payer management']/parent::li";
    public static final String DYNAMIC_MENU_LOCATOR = "XPATH=//span[text()='%s']/parent::div";
    public static final String ECOLLECTION_MANAGEMENT_SUBMENU = "XPATH=//span[text()='E-Collection Management']/parent::li";
    public static final String SUCCESS_MODAL = "XPATH=//div[@class='ant-modal-confirm-body-wrapper']";
    public static final String SUCCESS_MODAL_CLOSE_BUTTON = "XPATH=//div[@class='ant-modal-mask']/following-sibling::div[@class='ant-modal-wrap']//span[text()='Close']/parent::button";
    public static final String RECEIVABLES_MANAGEMENT_SUBMENU = "XPATH=//span[text()='Receivables Management']/parent::li[@role='menuitem']";
}
