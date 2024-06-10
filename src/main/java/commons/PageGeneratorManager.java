package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.adminSite.DashboardPO;
import pageObjects.adminSite.DepartmentPO;
import pageObjects.adminSite.LoginPO;
import pageObjects.adminSite.UserPO;
import pageObjects.supportPlatform.TempMailPO;

public class PageGeneratorManager {
    public static LoginPO getLoginPage(WebDriver driver) {return new LoginPO(driver);}
    public static DashboardPO getDashboardPage(WebDriver driver) {return new DashboardPO(driver);}
    public static DepartmentPO getDepartmentPage(WebDriver driver) {return new DepartmentPO(driver);}
    public static UserPO getUserPage(WebDriver driver) {return new UserPO(driver);}
    public static TempMailPO getTempMailPage(WebDriver driver) {return new TempMailPO(driver);}
}
