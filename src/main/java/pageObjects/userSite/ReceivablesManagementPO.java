package pageObjects.userSite;

import PageUIs.userSite.ReceivablesManagementPUI;
import commons.BaseAction;
import org.openqa.selenium.WebDriver;

public class ReceivablesManagementPO extends BaseAction {
    private WebDriver driver;
    public ReceivablesManagementPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToRegisterReceivableButton() {
        waitForElementClickable(driver, ReceivablesManagementPUI.RECEIVABLE_REGISTER_BUTTON);
        clickToElement(driver, ReceivablesManagementPUI.RECEIVABLE_REGISTER_BUTTON);
    }


    public void clickToViewPayerList() {
        waitForElementClickable(driver, ReceivablesManagementPUI.VIEW_PAYER_LIST_BUTTON);
        clickToElement(driver, ReceivablesManagementPUI.VIEW_PAYER_LIST_BUTTON);
    }

    public void inputThePayerNumberToSearchboxInModal(String payerName) {
        waitForElementVisible(driver, ReceivablesManagementPUI.PAYER_NUMBER_SEARCHBOX_IN_MODAL);
        senkeyToElement(driver, ReceivablesManagementPUI.PAYER_NUMBER_SEARCHBOX_IN_MODAL, payerName);
    }

    public void clickToChooseThePayerOnResultList(String payerName) {
        int payerNamePrecedingColumn = getListElementSize(driver, ReceivablesManagementPUI.PAYER_NAME_COLUMN_PRECEDING_SIBLING);
        String payerNameColumnOrder = String.valueOf(payerNamePrecedingColumn + 1);
        waitForElementClickable(driver, ReceivablesManagementPUI.PAYER_ITEM_WITH_PROVIDED_NAME, payerNameColumnOrder, payerName);
        clickToElement(driver, ReceivablesManagementPUI.PAYER_ITEM_WITH_PROVIDED_NAME, payerNameColumnOrder, payerName);
    }

    public void selectTheEccAtTop() {
        waitForElementClickable(driver, ReceivablesManagementPUI.ECC_DROPDOWN);
        clickToElement(driver, ReceivablesManagementPUI.ECC_DROPDOWN);
        waitForElementClickable(driver, ReceivablesManagementPUI.THE_FIRST_ECC_ON_LIST);
        clickToElement(driver, ReceivablesManagementPUI.THE_FIRST_ECC_ON_LIST);
    }

    public void inputTheReceivableAmount() {
        waitForElementVisible(driver, ReceivablesManagementPUI.RECEIVABLE_AMOUNT_TEXTBOX);
        senkeyToElement(driver, ReceivablesManagementPUI.RECEIVABLE_AMOUNT_TEXTBOX, "1504000");
    }

    public void selectTheStartDate() {
        waitForElementClickable(driver, ReceivablesManagementPUI.RECEIVABLE_START_DATE_PICKER);
        clickToElement(driver, ReceivablesManagementPUI.RECEIVABLE_START_DATE_PICKER);
        waitForElementClickable(driver, ReceivablesManagementPUI.YEAR_PICKER);
        clickToElement(driver, ReceivablesManagementPUI.YEAR_PICKER);
        waitForElementClickable(driver, ReceivablesManagementPUI.DYNAMIC_YEAR_LOCATOR, "2024");
        clickToElement(driver, ReceivablesManagementPUI.DYNAMIC_YEAR_LOCATOR, "2024");
        waitForElementClickable(driver, ReceivablesManagementPUI.MONTH_PICKER);
        clickToElement(driver, ReceivablesManagementPUI.MONTH_PICKER);
        waitForElementClickable(driver, ReceivablesManagementPUI.DYNAMIC_MONTH_LOCATOR, "Aug");
        clickToElement(driver, ReceivablesManagementPUI.DYNAMIC_MONTH_LOCATOR, "Aug");
        waitForElementClickable(driver, ReceivablesManagementPUI.DYNAMIC_DATE_LOCATOR, "18");
        clickToElement(driver, ReceivablesManagementPUI.DYNAMIC_DATE_LOCATOR, "18");
    }

    public void selectTheDueDate() {
        waitForElementClickable(driver, ReceivablesManagementPUI.RECEIVABLE_DUE_DATE_PICKER);
        clickToElement(driver, ReceivablesManagementPUI.RECEIVABLE_DUE_DATE_PICKER);
        waitForElementClickable(driver, ReceivablesManagementPUI.DUE_YEAR_PICKER);
        clickToElement(driver, ReceivablesManagementPUI.DUE_YEAR_PICKER);
        waitForElementClickable(driver, ReceivablesManagementPUI.DYNAMIC_YEAR_LOCATOR, "2024");
        clickToElement(driver, ReceivablesManagementPUI.DYNAMIC_YEAR_LOCATOR, "2024");
        waitForElementClickable(driver, ReceivablesManagementPUI.DUE_MONTH_PICKER);
        clickToElement(driver, ReceivablesManagementPUI.DUE_MONTH_PICKER);
        waitForElementClickable(driver, ReceivablesManagementPUI.DYNAMIC_MONTH_LOCATOR, "Aug");
        clickToElement(driver, ReceivablesManagementPUI.DYNAMIC_MONTH_LOCATOR, "Aug");
        waitForElementClickable(driver, ReceivablesManagementPUI.DYNAMIC_DATE_LOCATOR, "28");
        clickToElement(driver, ReceivablesManagementPUI.DYNAMIC_DATE_LOCATOR, "28");
    }

    public void inputToRefId(String refId) {
        waitForElementVisible(driver, ReceivablesManagementPUI.REF_ID_TEXTBOX);
        senkeyToElement(driver, ReceivablesManagementPUI.REF_ID_TEXTBOX, refId);
    }

    public void clickToRegisterReceivable() {
        waitForElementClickable(driver, ReceivablesManagementPUI.BUTTON_SAVE_RECEIVABLE);
        clickToElement(driver, ReceivablesManagementPUI.BUTTON_SAVE_RECEIVABLE);
    }

    public void inputToPayerNumberSearchbox(String payerNumber) {
        waitForElementVisible(driver, ReceivablesManagementPUI.PAYER_NUMBER_SEARCHBOX);
        senkeyToElement(driver, ReceivablesManagementPUI.PAYER_NUMBER_SEARCHBOX, payerNumber);
    }

    public void clickToSearchReceivableButton() {
        waitForElementClickable(driver, ReceivablesManagementPUI.SEARCH_BUTTON);
        clickToElement(driver, ReceivablesManagementPUI.SEARCH_BUTTON);
    }

    public boolean isReceivableCreated(String refId) {
        int refIdPrecedingColumn = getListElementSize(driver, ReceivablesManagementPUI.REF_ID_PRECEDING_COLUMN);
        String refIdOrderColumn = String.valueOf(refIdPrecedingColumn + 1);
        String actualRefId = getElementText(driver, ReceivablesManagementPUI.REF_ID_VALUE_ON_LIST, refIdOrderColumn);
        System.out.println("expect: " + refId);
        System.out.println("actual: " + actualRefId);
        return actualRefId.equals(refId);
    }
}
