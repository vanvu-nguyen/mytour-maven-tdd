package pageObjects.adminSite;

import PageUIs.adminSite.DepartmentPUI;
import commons.BaseAction;
import org.openqa.selenium.WebDriver;

public class DepartmentPO extends BaseAction {
    private WebDriver driver;

    public DepartmentPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendkeyToDepartmentCodeInput(String keyToSend) {
        waitForElementClickable(driver, DepartmentPUI.DEPARTMENT_CODE_TEXTBOX);
        senkeyToElement(driver, DepartmentPUI.DEPARTMENT_CODE_TEXTBOX, keyToSend);
    }

    public void sendkeyToDepartmentNameInput(String keyToSend) {
        waitForElementClickable(driver, DepartmentPUI.DEPARTMENT_NAME_TEXTBOX);
        senkeyToElement(driver, DepartmentPUI.DEPARTMENT_NAME_TEXTBOX, keyToSend);
    }

    public void clickToSaveDepartment() {
        waitForElementClickable(driver, DepartmentPUI.SAVE_DEPARTMENT_BUTTON);
        clickToElement(driver, DepartmentPUI.SAVE_DEPARTMENT_BUTTON);
    }



    public void senkeyToDepartmentCodeSearchbox(String keyToSend) {
        waitForElementClickable(driver, DepartmentPUI.DEPARTMENT_CODE_SEARCHBOX);
        senkeyToElement(driver, DepartmentPUI.DEPARTMENT_CODE_SEARCHBOX, keyToSend);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, DepartmentPUI.DEPARTMENT_SEARCH_BUTTON);
        clickToElement(driver, DepartmentPUI.DEPARTMENT_SEARCH_BUTTON);
        waitLoadingIconInvisible();
    }

    public boolean isDepartmentInfoListed(String departmentCode) {
        int previousColumnNumber = getListElementSize(driver, DepartmentPUI.DEPARTMENT_CODE_PREVIOUS_COLUMN);
        String orderOfDepartmentCodeColumn = String.valueOf(previousColumnNumber + 1);
        String actualDepartmentCode = getElementText(driver, DepartmentPUI.DEPARTMENT_CODE_DATA_LOCATOR, orderOfDepartmentCodeColumn);
        return actualDepartmentCode.equals(departmentCode);
    }
}
