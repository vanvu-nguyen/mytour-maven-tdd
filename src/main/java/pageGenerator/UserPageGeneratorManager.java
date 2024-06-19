package pageGenerator;

import pageObjects.userSite.DashboardPO;
import org.openqa.selenium.WebDriver;
import pageObjects.userSite.*;

public class UserPageGeneratorManager {
    public static LoginPO getUserLoginPage(WebDriver driver) {return new LoginPO(driver);}
    public static DashboardPO getUserDashboardPage(WebDriver driver) {return new DashboardPO(driver);}
    public static PayerManagementPO getUserPayerManagementPage(WebDriver driver) {return new PayerManagementPO(driver);}
    public static EcollectionManagementPO getEcollectionManagementPage(WebDriver driver) {return new EcollectionManagementPO(driver);}
    public static ReceivablesManagementPO getReceivablesManagementPage(WebDriver driver) {return new ReceivablesManagementPO(driver);}
}
