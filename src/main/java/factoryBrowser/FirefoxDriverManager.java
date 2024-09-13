package factoryBrowser;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Collections;
import java.util.HashMap;

public class FirefoxDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE, GlobalConstants.BROWSER_LOG_FOLDER);
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_PATH);
        firefoxOptions.addPreference("browser.download.useDownloadDir", true);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html, text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
        firefoxOptions.addPreference("pdfjs.disable",true);
        firefoxOptions.addArguments("-private");
        firefoxOptions.addPreference("intl.accept_languages", "en-us, en");
        return new FirefoxDriver(firefoxOptions);
    }
}
