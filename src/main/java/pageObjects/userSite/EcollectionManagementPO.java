package pageObjects.userSite;

import PageUIs.userSite.EcollectionManagementPUI;
import commons.BaseAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class EcollectionManagementPO extends BaseAction {
    private WebDriver driver;
    private Actions actions;
    public EcollectionManagementPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToMapEccButton() {
        waitForElementClickable(driver, EcollectionManagementPUI.BUTTON_MAP_EC);
        clickToElement(driver, EcollectionManagementPUI.BUTTON_MAP_EC);
    }

    public void clickToViewPayerList() {
        waitForElementClickable(driver, EcollectionManagementPUI.VIEW_PAYER_LIST_BUTTON);
        clickToElement(driver, EcollectionManagementPUI.VIEW_PAYER_LIST_BUTTON);
    }

    public void inputPayerNameToSearchboxInModal(String payerName) {
        waitForElementVisible(driver, EcollectionManagementPUI.PAYER_NAME_SEARCHBOX_IN_MODAL);
        senkeyToElement(driver, EcollectionManagementPUI.PAYER_NAME_SEARCHBOX_IN_MODAL, payerName);
    }

    public void clickToChoosePayer(String payerName) {
        waitForElementClickable(driver, EcollectionManagementPUI.CORRECT_PAYER_ON_LIST, payerName);
        clickToElement(driver, EcollectionManagementPUI.CORRECT_PAYER_ON_LIST, payerName);
    }

    public void clickToViewEccList() {
        waitForElementClickable(driver, EcollectionManagementPUI.VIEW_ECOLLECTION_CODE_LIST_BUTTON);
        clickToElement(driver, EcollectionManagementPUI.VIEW_ECOLLECTION_CODE_LIST_BUTTON);
    }

    public void clickToChooseTheFirstEcc() {
        waitForElementClickable(driver, EcollectionManagementPUI.CHOSEN_ECC_ON_LIST);
        clickToElement(driver, EcollectionManagementPUI.CHOSEN_ECC_ON_LIST);
    }

    public void renameTheChosenEccHoldername() {
        waitForElementVisible(driver, EcollectionManagementPUI.ECC_NAME_TEXTBOX);
        actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND)
                .sendKeys(getElement(driver, EcollectionManagementPUI.ECC_NAME_TEXTBOX),"a")
                .keyUp(Keys.COMMAND)
                .sendKeys("sampleEccHolderName")
                .perform();
    }

    public String getEcCode() {
        waitForElementVisible(driver, EcollectionManagementPUI.ECC_CODE_TEXT);
        return getDefaultAttributeValue(driver, EcollectionManagementPUI.ECC_CODE_TEXT, "value");
    }

    public void clickToSaveMappingEcc() {
        waitForElementClickable(driver, EcollectionManagementPUI.SAVE_MAPPING_BUTTON);
        clickToElement(driver, EcollectionManagementPUI.SAVE_MAPPING_BUTTON);
        //waitForElementInvisible(driver, EcollectionManagementPUI.SAVE_MAPPING_BUTTON);
    }

    public void inputToEccSearchbox(String ecCode) {
        waitForElementVisible(driver, EcollectionManagementPUI.ECC_SEARCHBOX);
        senkeyToElement(driver, EcollectionManagementPUI.ECC_SEARCHBOX, ecCode);
    }

    public void clickToSearchEccButton() {
        waitForElementClickable(driver, EcollectionManagementPUI.ECC_SEARCH_BUTTON);
        clickToElement(driver, EcollectionManagementPUI.ECC_SEARCH_BUTTON);
        waitLoadingIconInvisible();
    }

    public boolean isMappedPayerPhoneNumberList(String expectedPhoneNumber) {
        int precedingColumnOfPhoneNumber = getListElementSize(driver, EcollectionManagementPUI.PHONE_NUMBER_PRECEDING_COLUMN);
        String phoneNumberColumnOrder = String.valueOf(precedingColumnOfPhoneNumber + 1);
        String actualPhoneNumberValue = getElementText(driver, EcollectionManagementPUI.PHONE_NUMBER_COLUMN_VALUE, phoneNumberColumnOrder);
        return actualPhoneNumberValue.equals(expectedPhoneNumber);
    }
}
