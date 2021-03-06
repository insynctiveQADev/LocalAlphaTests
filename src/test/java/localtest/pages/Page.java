package localtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class Page {

    public static final int SELENIUM_TIMEOUT_SEC = 10;
    public WebDriver driver;
    public String PAGE_URL;
    public String PAGE_TITLE;
    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean exists(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException ignored) {
            return false;
        }
    }



    public String getPageUrl() {
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public void loadPage() {
        driver.get(getPageUrl());
        //Assert.assertEquals(driver.getTitle(), getPageTitle());
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void setElementText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void getElementText(WebElement element, String text) {
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void checkIfElementVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "element isn't found");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void waitUntilIsLoaded(WebElement element) throws IOException, InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }

    public void selectValueInDropdown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public boolean isElementPresent(WebElement element) {
        try{
            element.getTagName();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public boolean isElementExisting(WebElement we) {
        try {
            we.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void turnOffImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    protected void turnOnImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected boolean isElementHiddenNow(String locator) {
        turnOffImplicitWaits();
        boolean result = false;
        try {
            result = ExpectedConditions.invisibilityOfElementLocated(By.id(locator)).apply(driver);
        } finally {
            turnOnImplicitWaits();
        }
        return result;
    }

    public boolean isElementPresentbySize(String locator) {
        return driver.findElements(By.id(locator)).size() > 0;
    }


    public boolean isElementDisplayedNowOLD(WebElement element) {
        turnOffImplicitWaits();
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } finally {
            turnOnImplicitWaits();
        }
    }

}