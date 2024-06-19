package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.supportPlatform.TempMailPO;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BasePage extends BaseTest {

    public static BasePage getBasePage() {
        return new BasePage();
    }

    // FW for browser
    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public void goToTempMailSite(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.TAB).get("https://temp-mail.org/");
    }

    public String getPageTitle(WebDriver driver) {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String getCurrentPageUrl(WebDriver driver) {
        String pageUrl = driver.getCurrentUrl();
        return pageUrl;
    }

    public String getCurrentPageSource(WebDriver driver) {
        String pageSource = driver.getPageSource();
        return pageSource;
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout()));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void dismissAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keyToSend) {
        waitForAlertPresence(driver).sendKeys(keyToSend);
    }

    public String getWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Cookie> getBrowserCookie(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void delAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void setCookie(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie i : cookies) {
            driver.manage().addCookie(i);
        }
    }

    // FW for web element

    public By getByLocator(String inputLocator) {
        By outputLocator = null;
        if (inputLocator.startsWith("xpath=") || inputLocator.startsWith("Xpath=") || inputLocator.startsWith("XPATH=") || inputLocator.startsWith("xPath=") || inputLocator.startsWith("XPath=")) {
            outputLocator = By.xpath(inputLocator.substring(6));
        } else if (inputLocator.startsWith("class=") || inputLocator.startsWith("CLASS=") || inputLocator.startsWith("Class=")) {
            outputLocator = By.className(inputLocator.substring(6));
        } else if (inputLocator.startsWith("id=") || inputLocator.startsWith("ID=") || inputLocator.startsWith("Id=")) {
            outputLocator = By.id(inputLocator.substring(3));
        } else if (inputLocator.startsWith("css=") || inputLocator.startsWith("CSS=") || inputLocator.startsWith("Css=")) {
            outputLocator = By.cssSelector(inputLocator.substring(4));
        } else if (inputLocator.startsWith("name=") || inputLocator.startsWith("NAME=") || inputLocator.startsWith("Name=")) {
            outputLocator = By.name(inputLocator.substring(5));
        } else if (inputLocator.startsWith("tagname=") || inputLocator.startsWith("TAGNAME=") || inputLocator.startsWith("Tagname=")) {
            outputLocator = By.tagName(inputLocator.substring(8));
        } else throw new RuntimeException("inputLocator is not valid.");
        return outputLocator;
    }

    public String getDynamicLocator(String inputLocator, String... restParams) {
        return String.format(inputLocator, (Object[]) restParams);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }


    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    public void senkeyToElement(WebDriver driver, String locator, String valueToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(valueToSend);
    }

    public void senkeyToElement(WebDriver driver, String locator, String valueToSend, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).clear();
        getElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
        new Select(getElement(driver, locator)).selectByVisibleText(itemValue);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue, String... restParams) {
        new Select(getElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);
        WebDriverWait explicitWait;
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout()));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public void selectItemInCustomDropdownByTitle(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);
        WebDriverWait explicitWait;
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout()));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        for (WebElement item : allItems) {
            if (item.getAttribute("title").trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getDefaultAttributeValue(WebDriver driver, String locator, String key) {
        return getElement(driver, locator).getAttribute(key);
    }

    public String getDefaultAttributeValue(WebDriver driver, String locator, String key, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getAttribute(key);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String key) {
        return getElement(driver, locator).getCssValue(key);
    }

    public String convertRgbaToHexaColor(WebDriver driver, String locator) {
        return Color.fromString(getCssValue(driver, locator, "background-color")).asHex();
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    public int getListElementSize(WebDriver driver, String locator, String... restParams) {
        return getListElement(driver, getDynamicLocator(locator, restParams)).size();
    }

    /**
     * Checking checkbox and radio button
     * @param driver
     * @param locator
     */
    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator, String... restParams) {
        if (!getElement(driver, getDynamicLocator(locator, restParams)).isSelected()) {
            getElement(driver, getDynamicLocator(locator, restParams)).click();
        }
    }

    /**
     * Unchecking checkbox
     * @param driver
     * @param locator
     */
    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        System.out.println("Start time =" + new Date().toString());
        overrideGlobalTimeout(driver,GlobalConstants.getGlobalConstants().getShortTimeout());
        List<WebElement> elements = getListElement(driver, locator);
        overrideGlobalTimeout(driver,GlobalConstants.getGlobalConstants().getLongTimeout());

        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            System.out.println("End time =" + new Date().toString());
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible/displayed");
            System.out.println("End time =" + new Date().toString());
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            return false;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator, String... value) {
        System.out.println("Start time =" + new Date().toString());
        overrideGlobalTimeout(driver,GlobalConstants.getGlobalConstants().getShortTimeout());
        List<WebElement> elements = getListElement(driver, getDynamicLocator(locator, value));
        overrideGlobalTimeout(driver,GlobalConstants.getGlobalConstants().getLongTimeout());

        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            System.out.println("End time =" + new Date().toString());
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible/displayed");
            System.out.println("End time =" + new Date().toString());
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            return false;
        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String dragLocator, String dropLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, dragLocator), getElement(driver, dropLocator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
    }

    // JS executor

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout()));
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.visibilityOfAllElements(getListElement(driver, locator)));
    }

    public boolean waitForElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstants().getShortTimeout())).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void uploadMultipleFile(WebDriver driver, String... filesToUpload) {
        // waitForElementClickable(driver, UploadPageUI.UPLOAD_FILE_ELEMENT);
        // List<String> fileNames = List.of(filesToUpload);
        String fullFileName = "";
        for (String file: filesToUpload) {
            fullFileName = fullFileName + GlobalConstants.getGlobalConstants().getUploadPath() + file + "\n";
        }
        String finalFileName = fullFileName.trim();
        System.out.println(finalFileName);
        getElement(driver, "//input[@id='image']").sendKeys(finalFileName);
    }



}
