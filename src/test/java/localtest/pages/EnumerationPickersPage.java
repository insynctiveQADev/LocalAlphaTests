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
    public static final String TYPE_OF_EMPLOYMENT_BLOCK_SEL = "popover750437";
    public static final String EMPLOYMENT_CANCEL_Sel = "employmentCancel";
    public static final String PAYMENT_UNIT_BLOCK_SEL = "popover855230";
    public static final String PAYMENT_SHEDULE_BLOCK_SEL = "popover79215";
    public static final String FLSA_BLOCK_SEL = "popover477242";
    private static final String FTPT_BLOCK_SEL = "popover891224";

    // Type Of Employment Picker
    @FindBy(id = TYPE_OF_EMPLOYMENT_KEY_Sel)
    WebElement typeOfEmploymentLink;
    @FindBy(id = TYPE_OF_EMPLOYMENT_BLOCK_SEL)
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
    @FindBy(id = PAYMENT_UNIT_BLOCK_SEL)
    WebElement paymentUnitBlock;
    @FindBy(id = "paymentUnitCancel")
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
    @FindBy(id = PAYMENT_SHEDULE_BLOCK_SEL)
    WebElement paymentScheduleBlock;
    @FindBy(id = "paymentScheduleCancel")
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

    @FindBy(id = FLSA_BLOCK_SEL)
    WebElement flsaBlock;

    @FindBy(id = "flsaCancel")
    WebElement flsaCloseImg;

    @FindBy(xpath = "//div[@id='popoverFLSAContent']/div[@data-key='1']")
    WebElement flsaExemptOption;
    @FindBy(xpath = "//div[@id='popoverFLSAContent']/div[@data-key='2']")
    WebElement flsaNonExemptOption;

    //Full time/Part time Picker
    @FindBy(id = "fTimePTimeKey")
    WebElement fTimePTimeLink;

    @FindBy(id = FTPT_BLOCK_SEL)
    WebElement ftptBlock;

    @FindBy(id = "ftptCancel")
    WebElement fTimePTimeCloseImg;

    // Constructor
    public EnumerationPickersPage(WebDriver driver) {

        super(driver);

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        this.PAGE_URL = "https://alphaex.insynctiveapps.com/Insynctive.Components/Pickers/Enumeration";
        this.PAGE_TITLE = "";
    }
//user actions

    //open window
    public void openTOEPickerWindow() {
        clickElement(typeOfEmploymentLink);
    }

    public void openPaymentUnitPickerWindow() {
        clickElement(paymentUnitLink);
    }
    public void openPaymentSchedulePickerWindow() {
        clickElement(paymentScheduleLink);
    }

    public void openFlsaPickerWindow() {
        clickElement(flsaLink);
    }

    public void openFtptPickerWindow() {
        clickElement(fTimePTimeLink);
    }

    //close window
    public void closeTOEPickerWindow() {
        clickElement(typeOfEmploymentCloseImg);
    }

    public void closePaymentUnitPickerWindow() {
        clickElement(paymentUnitCloseImg);
    }

    public void closePaymentSchedulePickerWindow() {
        clickElement(paymentScheduleCloseImg);
    }

    public void closeFlsaPickerWindow() {
        clickElement(flsaCloseImg);
    }

    public void closeFtptPickerWindow() {
        clickElement(fTimePTimeCloseImg);
    }


    //Assertions
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

    //isPopUpClosed
    public boolean isTypeOfEmploymentBlockHidden() {
        return isElementHiddenNow(TYPE_OF_EMPLOYMENT_BLOCK_SEL);
    }

    public boolean isPaymentScheduletBlockHidden() {
        return isElementHiddenNow(PAYMENT_SHEDULE_BLOCK_SEL);
    }

    public boolean isPaymentUnitBlockHidden() {
        return isElementHiddenNow(PAYMENT_UNIT_BLOCK_SEL);
    }

    public boolean isFLSAPickerBlockHidden() {
        return isElementHiddenNow(FLSA_BLOCK_SEL);
    }

    public boolean isFTPTBlockHidden() {
        return isElementHiddenNow(FTPT_BLOCK_SEL);
    }

    //isPopUpOpened
    public boolean isTOEBlockOpened() {
        return isElementPresentbySize(TYPE_OF_EMPLOYMENT_BLOCK_SEL);
    }

    public boolean isPaymentUnitBlockOpened() {
        return isElementPresentbySize(PAYMENT_UNIT_BLOCK_SEL);
    }

    public boolean isPaymentSheduleBlockOpened() {
        return isElementPresentbySize(PAYMENT_SHEDULE_BLOCK_SEL);
    }

    public boolean isFLSAPickerBlockOpened() {
        return isElementPresentbySize(FLSA_BLOCK_SEL);
    }


    public boolean isFTPTBlockOpened() {
        return isElementPresentbySize(FTPT_BLOCK_SEL);
    }

    //pick elements
    public void pickTypeOfEmploymentEmployeeOption() {
        clickElement(typeOfEmploymentEmployeeOption);
    }

    public void pickTypeOfEmploymentContractorOption() {
        clickElement(typeOfEmploymentContractorOption);
    }

    public void pickPaymentUnitHourOption() {
        clickElement(paymentUnitHourOption);
    }

    public void pickPaymentUnitWeekOption() {
        clickElement(paymentUnitWeekOption);
    }

    public void pickPaymentUnitMonthOption() {
        clickElement(paymentUnitMonthOption);
    }

    public void pickPaymentUnitYearOption() {
        clickElement(paymentUnitYearOption);
    }


    public void pickPaymentScheduleMonthlyOption() {
        clickElement(paymentScheduleMonthlyOption);
    }

    public void pickPaymentScheduleTwiceAMonthOption() {
        clickElement(paymentScheduleTwiceAMonthOption);
    }

    public void pickPaymentScheduleWeeklyOption() {
        clickElement(paymentScheduleWeeklyOption);
    }
}
