package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class SafariDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        if (!IS_OS_MAC) {
            throw new RuntimeException("Safari is not supported on" + System.getProperty("os.name"));
        }
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability("safari.cleanSession", true);
        return new SafariDriver(safariOptions);
    }
}
