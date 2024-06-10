package commons;

public class BaseElement {
    public static final String LOADING_ICON = "XPATH=//div[contains(@class,'ant-spin-show-text')]";
    public static final String DYNAMIC_MENU_BY_NAME = "XPATH=//span[@class='ant-menu-title-content' and text()='%s']/parent::div";
    public static final String DEPARTMENT_SUBMENU = "XPATH=//div[@class='info-sidebar-content']//span[text()='Department management']/parent::li";
    public static final String USER_SUBMENU = "XPATH=//div[@class='info-sidebar-content']//span[text()='User management']/parent::li";
    public static final String TOP_RIGHT_DROPDOWN = "XPATH=//span[@aria-label='caret-down']";
    public static final String LOG_OUT_BUTTON = "XPATH=//span[text()='Logout']/ancestor::li";
    public static final String LOG_OUT_MODAL_BUTTON = "XPATH=//span[text()='Logout']/parent::button";
}
