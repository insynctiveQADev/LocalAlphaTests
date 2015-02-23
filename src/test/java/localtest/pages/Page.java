package localtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class Page {

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

    public String getPageUrl() {
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public void loadPage() {
        driver.get(getPageUrl());
        assertEquals(getTitle(), getPageTitle());
    }

    public void setElementText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
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

    public boolean verifyElementIsPresent(WebElement element){
        try{
            element.getTagName();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

}