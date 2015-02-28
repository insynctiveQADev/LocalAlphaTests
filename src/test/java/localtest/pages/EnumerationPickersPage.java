package localtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

/**
 * Created by Iakov Volf on 2/26/2015.
 */

public class EnumerationPickersPage extends Page {


    public static final String TYPE_OF_EMPLOYMENT_KEY_Sel = "typeOfEmploymentKey";
    public static final String typeOfEmploymentBlock_Sel = "popover750437";
    public static final String EMPLOYMENT_CANCEL_Sel = "employmentCancel";
    // Type Of Employment Picker
    @FindBy(id = TYPE_OF_EMPLOYMENT_KEY_Sel)
    WebElement typeOfEmploymentLink;
    @FindBy(id = typeOfEmploymentBlock_Sel)
    WebElement typeOfEmploymentBlock;
    @FindBy(id = EMPLOYMENT_CANCEL_Sel)
    WebElement typeOfEmploymentCloseImg;
    @FindBy(xpath = "//div[@id='popoverEmploymentContent']/div[@data-key='1']")
    WebElement typeOfEmploymentEmployeeOption;
    @FindBy(xpath = "//div[@id='popoverEmploymentContent']/div[@data-key='2']")
    WebElement typeOfEmploymentContractorOption;

    // Payment Unit Picker
    @FindBy(id = "paymentUnitKey")
    WebElement paymentUnitLink;
    @FindBy(id = "popover855230")
    WebElement paymentUnitBlock;
    @FindBy(id = "id=paymentUnitCancel")
    WebElement paymentUnitCloseImg;
    @FindBy(xpath = "//div[@id='popoverPaymentUnitContent']/div[@data-key='1']")
    WebElement paymentUnitHourOption;
    @FindBy(xpath = "//div[@id='popoverPaymentUnitContent']/div[@data-key='2']")
    WebElement paymentUnitWeekOption;
    @FindBy(xpath = "//div[@id='popoverPaymentUnitContent']/div[@data-key='3']")
    WebElement paymentUnitMonthOption;
    @FindBy(xpath = "//div[@id='popoverPaymentUnitContent']/div[@data-key='4']")
    WebElement paymentUnitYearOption;

    // Payment Schedule Picker
    @FindBy(id = "paymentScheduleKey")
    WebElement paymentScheduleLink;
    @FindBy(id = "popover79215")
    WebElement paymentScheduleBlock;
    @FindBy(id = "id=paymentScheduleCancel")
    WebElement paymentScheduleCloseImg;
    @FindBy(xpath = "//div[@id='popoverPaymentScheduleContent']/div[@data-key='1']")
    WebElement paymentScheduleWeeklyOption;
    @FindBy(xpath = "//div[@id='popoverPaymentScheduleContent']/div[@data-key='2']")
    WebElement paymentScheduleTwiceAMonthOption;
    @FindBy(xpath = "//div[@id='popoverPaymentScheduleContent']/div[@data-key='3']")
    WebElement paymentScheduleMonthlyOption;


    // Flsa Picker
    @FindBy(id = "flsaKey")
    WebElement flsaLink;

    //Full time/Part time Picker
    @FindBy(id = "fTimePTimeKey")
    WebElement fTimePTimeLink;


    public EnumerationPickersPage(WebDriver driver) {

        super(driver);

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        this.PAGE_URL = "https://alphaex.insynctiveapps.com/Insynctive.Components/Pickers/Enumeration";
        this.PAGE_TITLE = "";
    }


    public void checkTypeOfEmploymentPicked(String text) {
        assertEquals(text, typeOfEmploymentLink.getText());
    }

    public void checkPaymentUnitPicked(String text) {
        assertEquals(text, paymentUnitLink.getText());
    }

    public void checkFLSAPicked(String text) {
        assertEquals(text, flsaLink.getText());
    }

    public void checkFTPTPicked(String text) {
        assertEquals(text, fTimePTimeLink.getText());
    }

    public void checkPaymentSchedulePicked(String text) {
        assertEquals(text, paymentScheduleLink.getText());
    }
    /*public PersonPickerPage navigateTo(WebDriver driver) {
        driver.get(PAGE_URL);
        assertEquals(PAGE_TITLE, driver.getTitle());
        return PageFactory.initElements(driver,
                PersonPickerPage.class);

    }*/

    public void openPickerWindow() {
        clickElement(typeOfEmploymentLink);
    }


}
