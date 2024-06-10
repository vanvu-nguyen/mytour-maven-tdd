package factoryEnvironment;

import commons.BrowserList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;


public class GridFactory {
    private WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String portNumber;

    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver createDriver() throws MalformedURLException {
        BrowserList browserName = BrowserList.valueOf(this.browserName.toUpperCase());
        switch (browserName) {
            case CHROME:
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), new ChromeOptions());
                break;
            case EDGE:
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), new EdgeOptions());
                break;
            case FIREFOX:
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), new FirefoxOptions());
                break;
            case SAFARI:
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), new SafariOptions());
                break;
            default: throw new RuntimeException("Browser name is not valid");
        }
        return driver;
    }

}
