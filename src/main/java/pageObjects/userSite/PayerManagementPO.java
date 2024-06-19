package pageObjects.userSite;

import PageUIs.userSite.PayerManagementPUI;
import commons.BaseAction;
import org.openqa.selenium.WebDriver;

public class PayerManagementPO extends BaseAction {
    private WebDriver driver;
    public PayerManagementPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean hasPayerManagementPageLoaded() {
        return isElementDisplayed(driver, PayerManagementPUI.PAGE_TITLE);
    }

    public void clickToRegisterPayer() {
        waitForElementClickable(driver, PayerManagementPUI.BUTTON_REGISTER_PAYER);
        clickToElement(driver, PayerManagementPUI.BUTTON_REGISTER_PAYER);
    }

    public void inputPayerName(String payerName) {
        waitForElementVisible(driver, PayerManagementPUI.PAYER_NAME_TEXTBOX);
        senkeyToElement(driver, PayerManagementPUI.PAYER_NAME_TEXTBOX, payerName);
    }

    public void inputPhoneNumber(String payerPhoneNumber) {
        waitForElementVisible(driver, PayerManagementPUI.PHONE_NUMBER_TEXTBOX);
        senkeyToElement(driver, PayerManagementPUI. PHONE_NUMBER_TEXTBOX, payerPhoneNumber);
    }

    public void selectNotAutoMap() {
        waitForElementClickable(driver, PayerManagementPUI.AUTOMAP_DROPDOWN);
        clickToElement(driver, PayerManagementPUI.AUTOMAP_DROPDOWN);
        waitForElementClickable(driver, PayerManagementPUI.NO_AUTOMAP_OPTION);
        clickToElement(driver, PayerManagementPUI.NO_AUTOMAP_OPTION);
    }

    public void clickToSavePayerButton() {
        waitForElementClickable(driver, PayerManagementPUI.BUTTON_SAVE_PAYER);
        clickToElement(driver, PayerManagementPUI.BUTTON_SAVE_PAYER);
    }

    public void inputPhoneNumberSearchbox(String payerPhoneNumber) {
        waitForElementVisible(driver, PayerManagementPUI.PHONE_NUMBER_SEARCHBOX);
        senkeyToElement(driver, PayerManagementPUI.PHONE_NUMBER_SEARCHBOX, payerPhoneNumber);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, PayerManagementPUI.BUTTON_SEARCH);
        clickToElement(driver, PayerManagementPUI.BUTTON_SEARCH);
    }

    public boolean isCreatedPayerListed(String expectedPayerName) {
        int payerNamePrecedingColumn = getListElementSize(driver, PayerManagementPUI.PAYER_NAME_PRECEDING_COLUMNS);
        String payerNameColumnOrder = String.valueOf(payerNamePrecedingColumn + 1);
        String actualPayerName = getElementText(driver, PayerManagementPUI.PAYER_NAME_COLUMN_VALUES, payerNameColumnOrder);
        return actualPayerName.equals(expectedPayerName);
    }

    public void closeSaveSuccessfulModal() {
        waitForElementClickable(driver, PayerManagementPUI.BUTTON_CLOSE_SUCCESSFUL_MODAL);
        clickToElement(driver, PayerManagementPUI.BUTTON_CLOSE_SUCCESSFUL_MODAL);
    }

    public String getPayerNumber() {
        int payerNumberPrecedingColumn = getListElementSize(driver, PayerManagementPUI.PAYER_NUMBER_PRECEDING_COLUMN);
        String payerNumberOrderColumn = String.valueOf(payerNumberPrecedingColumn + 1);
        return getElementText(driver, PayerManagementPUI.PAYER_NUMBER_VALUE_ON_LIST, payerNumberOrderColumn);
    }
}
