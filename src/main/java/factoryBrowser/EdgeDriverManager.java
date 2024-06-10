package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class EdgeDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        if (!IS_OS_WINDOWS || !IS_OS_MAC) {
            throw new RuntimeException("Edge is not supported on" + System.getProperty("os.name"));
        }
        EdgeOptions edgeOptions = new EdgeOptions();
        return new EdgeDriver(edgeOptions);
    }
}
