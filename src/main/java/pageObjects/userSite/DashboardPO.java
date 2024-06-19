package pageObjects.userSite;

import PageUIs.userSite.DashboardPUI;
import commons.BaseAction;
import org.openqa.selenium.WebDriver;

public class DashboardPO extends BaseAction {
    private WebDriver driver;
    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isLogOutButtonDisplayedOnUserSite() {
        return isElementDisplayed(driver, DashboardPUI.LOG_OUT_BUTTON);
    }
}
