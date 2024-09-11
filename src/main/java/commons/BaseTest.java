package commons;

import factoryEnvironment.GridFactory;
import factoryEnvironment.LocalFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    protected final Logger log;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String browser, String envName, String server, String ipAddress, String portNumber, String subSystem) {
        BrowserList browserName = BrowserList.valueOf(browser.toUpperCase());
        try {
            switch (server) {
                case "local": this.driver.set(new LocalFactory(browser).createDriver());
                    break;
                case "grid": this.driver.set(new GridFactory(browser, ipAddress, portNumber).createDriver());
                    break;
            /*case "browserStack":
                break;
            case "saucelab":
                break;
            case "crossBrowser":
                break;
            case "lambda":
                break;*/
                default: this.driver.set(new LocalFactory(browser).createDriver());
            }
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstants().getLongTimeout()));
            switch (subSystem) {
                case "admin": driver.get().get(getUrlWithGivenServerOnAdmin(envName));
                    break;
                case "user": driver.get().get(getUrlWithGivenServerOnUser(envName));
                    break;
                default: driver.get().get(getUrlWithGivenServerOnAdmin(envName));
            }
            driver.get().manage().window().maximize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver.get();
    }

    protected String getUrlWithGivenServerOnAdmin(String server) {
        String url;
        EnvironmentList serverName = EnvironmentList.valueOf(server.toUpperCase());
        switch (serverName) {
            case DEV: {url = "https://devbidv-admin.infocms.com.vn/";
                break;}
            case TEST: {url = "https://uat-bidv-admin.infocms.com.vn/";
                break;}
            case STAGING: {url = "";
                break;}
            default: throw new RuntimeException("Wrong environment name");
        }
        return url;
    }

    protected String getUrlWithGivenServerOnUser(String server) {
        String url;
        EnvironmentList serverName = EnvironmentList.valueOf(server.toUpperCase());
        switch (serverName) {
            case DEV: {url = "https://devbidv.infocms.com.vn/account/login";
                break;}
            case TEST: {url = "https://uat-bidv.infocms.com.vn/account/login";
                break;}
            case STAGING: {url = "";
                break;}
            default: throw new RuntimeException("Wrong environment name");
        }
        return url;
    }

    protected WebDriver getBrowserDriver(String browser, String url) {
        Path path = null;
        File extensionFilePath = null;
        BrowserList browserName = BrowserList.valueOf(browser.toUpperCase());
        switch (browserName) {
            case CHROME:
                driver.set(new ChromeDriver());
                break;
            case EDGE:
                driver.set(new EdgeDriver());
                break;
            case FIREFOX:
                driver.set(new FirefoxDriver());
                break;
            case SAFARI:
                driver.set(new SafariDriver());
                break;
            default: throw new RuntimeException("Browser name is not valid");
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstants().getLongTimeout()));
        driver.get().get(url);
        driver.get().manage().window().maximize();
        return driver.get();
    }

    protected String getEmailAddress() {
        Random randNum = new Random();
        return "vuke" + randNum.nextInt(99999) + "@gmail.com";
    }

    protected void closeBrowser(WebDriver driver) {
        String cmd = null;
        try {
            String osName = GlobalConstants.getGlobalConstants().getOsName().toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            log.info("Command line = " + cmd);

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------------------------- PASSED ----------------------------");
        } catch (Throwable e) {
            pass = false;
            log.info("---------------------------- FAILED ----------------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("---------------------------- PASSED ----------------------------");
        } catch (Throwable e) {
            log.info("---------------------------- FAILED ----------------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------------------------- PASSED ----------------------------");
        } catch (Throwable e) {
            log.info("---------------------------- FAILED ----------------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-results");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.getGlobalConstants().getRelativeProjectPath() + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void sleepInSecond (long timeInSecond) {
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
