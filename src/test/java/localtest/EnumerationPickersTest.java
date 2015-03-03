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
        enumerationPickersPage.loadPage();
    }


    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }


    @Test(groups = "checkBlockOpen")
    public void checkIfPaymentUnitPopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentUnitPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isPaymentUnitBlockOpened());
    }

    @Test(groups = "checkBlockOpen")
    public void checkIfPaymentSchedulePopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentSchedulePickerWindow();
        Assert.assertTrue(enumerationPickersPage.isPaymentSheduleBlockOpened());
    }

    @Test(groups = "checkBlockOpen")
    public void checkIfTOEPopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openTOEPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isTOEBlockOpened());
    }

    @Test(groups = "checkBlockOpen")
    public void checkIfFlsaPopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openFlsaPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isTOEBlockOpened());
    }

    @Test(groups = "checkBlockOpen")
    public void checkIfFTPTPopUpOpenTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openFtptPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isFTPTBlockOpened());
    }

    //test if pop up is closed TODO ASAP correct PopUp closing tests!!!!!
    @Test(groups = "checkBlockClosed")
    public void checkIfTOEPopUpClosedTest() throws Exception {
        enumerationPickersPage.refreshPage();
        enumerationPickersPage.openTOEPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isTOEBlockOpened());
    }

    @Test(groups = "checkBlockClosed")
    public void checkIfPaymentUnitPopUpClosedTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentUnitPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isPaymentUnitBlockHidden());
    }

    @Test(groups = "checkBlockClosed")
    public void checkIfFTPTPopUpClosedTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openFtptPickerWindow();
        Assert.assertTrue(enumerationPickersPage.isFTPTBlockHidden());
    }

    @Test(groups = "checkBlockClosed")
    public void checkIfPaymentSchedulePopUpClosedTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentSchedulePickerWindow();
        Assert.assertTrue(enumerationPickersPage.isPaymentScheduletBlockHidden());
    }

    @Test(groups = "checkBlockClosed")
    public void checkIfFLSAPopUpClosedTest() throws Exception {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.isFLSAPickerBlockHidden();
        Assert.assertTrue(enumerationPickersPage.isFLSAPickerBlockHidden());
    }

    @Test(groups = "checkTypeOfEmployeeOption")
    public void pickEmployeeFromTOEPickerTest() {
        enumerationPickersPage.loadPage();
        enumerationPickersPage.openTOEPickerWindow();
        enumerationPickersPage.pickTypeOfEmploymentEmployeeOption();
        enumerationPickersPage.checkTypeOfEmploymentPicked("Employee (W2)");
}

    @Test(groups = "checkTypeOfEmployeeOption")
    public void pickContractorFromTOEPickerTest() {
        // enumerationPickersPage.loadPage();
        enumerationPickersPage.openTOEPickerWindow();
        enumerationPickersPage.pickTypeOfEmploymentContractorOption();
        enumerationPickersPage.checkTypeOfEmploymentPicked("Contractor (1099)");
    }


    @Test(groups = "checkPaymentUnitOption")
    public void pickHourFromPaymentUnitPickerTest() {
        // enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentUnitPickerWindow();
        enumerationPickersPage.pickPaymentUnitHourOption();
        enumerationPickersPage.checkPaymentUnitPicked("Hour");
    }

    @Test(groups = "checkPaymentUnitOption")
    public void pickWeekFromPaymentUnitPickerTest() {
        // enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentUnitPickerWindow();
        enumerationPickersPage.pickPaymentUnitWeekOption();
        enumerationPickersPage.checkPaymentUnitPicked("Week");
    }

    @Test(groups = "checkPaymentUnitOption")
    public void pickMonthFromPaymentUnitPickerTest() {
        //enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentUnitPickerWindow();
        enumerationPickersPage.pickPaymentUnitMonthOption();
        enumerationPickersPage.checkPaymentUnitPicked("Month");
    }

    @Test(groups = "checkPaymentUnitOption")
    public void pickYearFromPaymentUnitPickerTest() {
        //enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentUnitPickerWindow();
        enumerationPickersPage.pickPaymentUnitYearOption();
        enumerationPickersPage.checkPaymentUnitPicked("Year");
    }

    @Test(groups = "checkPaymentScheduleOption")
    public void pickWeeklyFromPaymentSchedulePickerTest() {
        //enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentSchedulePickerWindow();
        enumerationPickersPage.pickPaymentScheduleWeeklyOption();
        enumerationPickersPage.checkPaymentSchedulePicked("Weekly");
    }

    @Test(groups = "checkPaymentScheduleOption")
    public void pickMonthlyFromPaymentSchedulePickerTest() {
        //enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentSchedulePickerWindow();
        enumerationPickersPage.pickPaymentScheduleMonthlyOption();
        enumerationPickersPage.checkPaymentSchedulePicked("Monthly");
    }

    @Test(groups = "checkPaymentScheduleOption")
    public void pickTwiceAMonthFromPaymentSchedulePickerTest() {
        //enumerationPickersPage.loadPage();
        enumerationPickersPage.openPaymentSchedulePickerWindow();
        enumerationPickersPage.pickPaymentScheduleTwiceAMonthOption();
        enumerationPickersPage.checkPaymentSchedulePicked("Twice a Month");
    }

}