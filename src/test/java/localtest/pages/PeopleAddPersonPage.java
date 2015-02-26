package localtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by Iakov Volf on 2/16/2015.
 */
public class PeopleAddPersonPage extends Page {


    //Fields
    @FindBy(id = "body_body_popupAddPerson_txtFirstName_I")
    WebElement peopAddPersonFirstNameField;

    @FindBy(id = "body_body_popupAddPerson_txtLastName_I")
    WebElement peopAddPersonLastNameField;

    @FindBy(id = "body_body_popupAddPerson_txtEmail_I")
    WebElement peopAddPersonEmailField;


    @FindBy(id = "body_body_popupAddPerson_chkUnlist_S_D")
    WebElement peopAddPersonDoNotListChekBox;

    @FindBy(id = "body_body_popupAddPerson_chkInvite_S_D")
    WebElement peopAddPersonInviteChekBox;

    //Buttons
    @FindBy(id = "body_body_popupAddPerson_btnAddHRAdmin_CD")
    WebElement peopAddPersonSaveButton;

    @FindBy(id = "body_body_popupAddPerson_ASPxButton1_CD")
    WebElement peopAddPersonCancelButton;

    //Messages TODO


    public PeopleAddPersonPage(WebDriver driver) {

        super(driver);

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        //this.PAGE_URL = "https://alphaex.insynctiveapps.com/Insynctive.Hub/Protected/Invitations.aspx";
        // this.PAGE_TITLE = "Invitations";
    }


    public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }

    public void fillFirstName(String text) {
        setElementText(peopAddPersonFirstNameField, text);
    }


}
