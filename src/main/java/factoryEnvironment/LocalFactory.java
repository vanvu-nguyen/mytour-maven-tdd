package factoryEnvironment;

import commons.BrowserList;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private String browserName;
    private WebDriver driver;
    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }
    public WebDriver createDriver() {
        BrowserList browserName = BrowserList.valueOf(this.browserName.toUpperCase());
        switch (browserName) {
            case CHROME: driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case EDGE: driver = new EdgeDriverManager().getBrowserDriver();
                break;
            case FIREFOX: driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case SAFARI: driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            default: throw new RuntimeException("Browser name is not valid");
        }
        return driver;
    }
}
