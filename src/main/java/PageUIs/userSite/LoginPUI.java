package PageUIs.userSite;

public class LoginPUI {
    public static final String LANGUAGE_DROPDOWN = "XPATH=//div[@class='ant-select-selector']";
    public static final String LANGUAGE_OPTION = "XPATH=//span[text()='English']/ancestor::div[@aria-selected='false']";
    public static final String USER_NAME_LABEL = "XPATH=//p[text()='Username']";
    public static final String USER_NAME_TEXTBOX = "XPATH=//input[@id='login-form_userId']";
    public static final String PASSWORD_TEXTBOX = "XPATH=//input[@id='login-form_password']";
    public static final String LOGIN_BUTTON = "XPATH=//span[text()='Login']/parent::button";
}
