package pageObjects.adminSite;

import PageUIs.adminSite.DashboardPUI;
import commons.BaseAction;
import org.openqa.selenium.WebDriver;

public class DashboardPO extends BaseAction {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToMenuItemByName(String menuName) {
        goToMenuItemByName(menuName);
    }

    public boolean isExtendButtonDisplayed() {
        return isElementDisplayed(driver, DashboardPUI.EXTEND_BUTTON);
    }
}
