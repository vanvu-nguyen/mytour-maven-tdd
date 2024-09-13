package commons;

import org.openqa.selenium.WebDriver;

public class BaseAction extends BasePage {
    WebDriver driver;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
    }


}


