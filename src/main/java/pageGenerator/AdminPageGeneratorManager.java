package pageGenerator;

import org.openqa.selenium.WebDriver;
import pageObjects.adminSite.*;
import pageObjects.supportPlatform.TempMailPO;

public class AdminPageGeneratorManager {
    public static LoginPO getAdminLoginPage(WebDriver driver) {return new LoginPO(driver);}
    public static DashboardPO getAdminDashboardPage(WebDriver driver) {return new DashboardPO(driver);}
    public static DepartmentPO getAdminDepartmentPage(WebDriver driver) {return new DepartmentPO(driver);}
    public static UserPO getAdminUserPage(WebDriver driver) {return new UserPO(driver);}
    public static TempMailPO getTempMailPage(WebDriver driver) {return new TempMailPO(driver);}
    public static CustomerPO getAdminCustomerPage(WebDriver driver) {return new CustomerPO(driver);}
    public static ContractPO getAdminContractPage(WebDriver driver) {return new ContractPO(driver);}
}
