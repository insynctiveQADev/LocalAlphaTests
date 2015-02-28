package localtest;

/**
 * Created by Iakov Volf on 2/8/2015.
 */


import localtest.pages.EnumerationPickersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class EnumerationPickersTest {
    public WebDriver driver;
    public WebDriverWait wait;
    EnumerationPickersPage enumerationPickersPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        enumerationPickersPage = PageFactory.initElements(driver, EnumerationPickersPage.class);
    }


    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }

    @Test
    public void checkIfPaymentUnitPopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentUnitPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isPaymentUnitBlockOpened());
    }

    @Test
    public void checkIfPaymentSchedulePopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentSchedulePickerWindow();
        Assert.assertTrue(enumerationPickersPage.isPaymentSheduleBlockOpened());
    }

    @Test
    public void checkIfTOEPopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openTOEPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isTOEBlockOpened());
    }

    @Test
    public void checkIfFlsaPopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openFlsaPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isTOEBlockOpened());
    }
//TODO test for popup closing with cross


}
