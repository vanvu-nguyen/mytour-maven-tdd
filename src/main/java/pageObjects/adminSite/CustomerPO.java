package pageObjects.adminSite;

import PageUIs.adminSite.CustomerPUI;
import PageUIs.adminSite.UserPUI;
import commons.BaseAction;
import commons.GlobalConstants;
import commons.MonthList;
import org.openqa.selenium.WebDriver;

public class CustomerPO extends BaseAction {
    private WebDriver driver;
    public CustomerPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, CustomerPUI.CUSTOMER_REGISTER_BUTTON);
        clickToElement(driver, CustomerPUI.CUSTOMER_REGISTER_BUTTON);
    }

    public void selectIssuedDate() {
        waitForElementClickable(driver, CustomerPUI.ISSUED_DATE_PICKER);
        clickToElement(driver, CustomerPUI.ISSUED_DATE_PICKER);
        waitForElementClickable(driver, CustomerPUI.PICK_YEAR_BUTTON);
        clickToElement(driver, CustomerPUI.PICK_YEAR_BUTTON);
        waitForElementClickable(driver, CustomerPUI.DYNAMIC_YEAR_LOCATOR_2020_2029, "2020");
        clickToElement(driver, CustomerPUI.DYNAMIC_YEAR_LOCATOR_2020_2029, "2020");
        waitForElementClickable(driver, CustomerPUI.PICK_MONTH_BUTTON);
        clickToElement(driver, CustomerPUI.PICK_MONTH_BUTTON);
        waitForElementClickable(driver, CustomerPUI.DYNAMIC_MONTH_LOCATOR, String.valueOf(MonthList.Jul));
        clickToElement(driver, CustomerPUI.DYNAMIC_MONTH_LOCATOR, String.valueOf(MonthList.Jul));
        waitForElementClickable(driver, CustomerPUI.DYNAMIC_DATE_LOCATOR, "18");
        clickToElement(driver, CustomerPUI.DYNAMIC_DATE_LOCATOR, "18");
    }

    public void sendkeyToServiceId(String serviceId) {
        waitForElementVisible(driver, CustomerPUI.SERVICE_ID_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.SERVICE_ID_TEXTBOX, serviceId);
    }

    public void sendkeyToMerchantId(String merchantId) {
        waitForElementVisible(driver, CustomerPUI.MERCHANT_ID_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.MERCHANT_ID_TEXTBOX, merchantId);
    }

    public void sendkeyToMasterId(String masterId) {
        waitForElementVisible(driver, CustomerPUI.MASTER_ID_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.MASTER_ID_TEXTBOX, masterId);
    }

    public void sendkeyToDisplayName(String displayName) {
        waitForElementVisible(driver, CustomerPUI.DISPLAY_NAME_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.DISPLAY_NAME_TEXTBOX, displayName);
    }

    public void sendkeyToEmail(String email) {
        waitForElementVisible(driver, CustomerPUI.EMAIL_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.EMAIL_TEXTBOX, email);
    }

    public void sendkeyToPhoneNumber(String phoneNumber) {
        waitForElementVisible(driver, CustomerPUI.PHONE_NUMBER_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void sendkeyToBusinessNumber(String businessNumber) {
        waitForElementVisible(driver, CustomerPUI.BUSINESS_NUMBER_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.BUSINESS_NUMBER_TEXTBOX, businessNumber);
    }

    public void sendkeyToCompanyName(String companyName) {
        waitForElementVisible(driver, CustomerPUI.CUSTOMER_NAME_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.CUSTOMER_NAME_TEXTBOX, companyName);
    }

    public void sendkeyToIssuedPlace(String issuedPlace) {
        waitForElementVisible(driver, CustomerPUI.ISSUED_PLACE_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.ISSUED_PLACE_TEXTBOX, issuedPlace);
    }

    public void sendkeyToCompanyAddress(String companyAddress) {
        waitForElementVisible(driver, CustomerPUI.COMPANY_ADDRESS_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.COMPANY_ADDRESS_TEXTBOX, companyAddress);
    }

    public void selectManagementBranchName() {
        selectItemInCustomDropdown(driver, CustomerPUI.BRANCH_NAME_PARENT_LOCATOR, CustomerPUI.BRANCH_NAME_CHILD_LOCATOR, "CN NHĐT PT Bắc Hà");
    }

    public void sendkeyToRemarks(String remarks) {
        waitForElementVisible(driver, CustomerPUI.REMARKS_TEXTBOX);
        senkeyToElement(driver, CustomerPUI.REMARKS_TEXTBOX, remarks);
    }

    public void uploadFileToCompanyLogo(String fileToUpload) {
        waitForElementClickable(driver, CustomerPUI.COMPANY_LOGO_UPLOAD);
        String filePath = GlobalConstants.getGlobalConstants().getUploadPath() + fileToUpload;
        System.out.println("before up:" + filePath);
        senkeyToElement(driver, CustomerPUI.COMPANY_LOGO_UPLOAD, filePath);
    }

    public void clickToSaveCustomer() {
        waitForElementClickable(driver, CustomerPUI.SAVE_CUSTOMER_BUTTON);
        clickToElement(driver, CustomerPUI.SAVE_CUSTOMER_BUTTON);
        waitLoadingIconInvisible();
    }

    public void sendkeyToServiceIdSearchbox(String serviceId) {
        waitForElementVisible(driver, CustomerPUI.SERVICE_ID_SEARCHBOX);
        senkeyToElement(driver, CustomerPUI.SERVICE_ID_SEARCHBOX, serviceId);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, CustomerPUI.SEARCH_CUSTOMER_BUTTON);
        clickToElement(driver, CustomerPUI.SEARCH_CUSTOMER_BUTTON);
        waitLoadingIconInvisible();
    }

    public boolean isCustomerListed(String serviceId) {
        int previousColumnNumber = getListElementSize(driver, CustomerPUI.SERVICE_ID_PREVIOUS_COLUMN);
        String orderOfServiceIdColumn = String.valueOf(previousColumnNumber + 1);
        String actualServiceId = getElementText(driver, CustomerPUI.SERVICE_ID_DATA_LOCATOR, orderOfServiceIdColumn);
        return actualServiceId.equals(serviceId);
    }
}
