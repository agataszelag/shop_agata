package pages.form;

import models.Subject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.File;
import java.util.List;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#left-column>.contact-rich>h4")
    private WebElement contactUsPageHeader;
    @FindBy(css = ".form-control-select")
    private List<WebElement> subjectForm;
    @FindBy(css = "input[type='email']")
    private WebElement addressEmail;
    @FindBy(css = "textarea[name='message']")
    private WebElement messagebox;
    @FindBy(css = ".btn-primary")
    private WebElement sendButton;
    @FindBy(css = ".alert-success")
    private WebElement alertSuccess;
    @FindBy(css = ".alert-danger")
    private WebElement alertFailed;
    @FindBy(css = "input[placeholder='your@email.com']")
    private WebElement placeholderAddressEmail;
    @FindBy(css = "textarea[placeholder='How can we help?']")
    private WebElement placeholderMessageBox;

    @FindBy(css = "input[type = 'file']")
    private WebElement inputFile;

    public String getContactUsPageHeader(){
        return contactUsPageHeader.getText();
    }

    public void selectSubject(Subject subject){
        subjectForm.get(subject.getIndex()).click();
    }

    public void setRandomAddressEmail(){
        addressEmail.sendKeys(BasePage.getRandomEmail());
    }

    public void setMessage(String message){
        messagebox.sendKeys(message);
    }

    public void clickSendButton(){
        click(sendButton);
    }

    public String getAlertSuccess(){
        return alertSuccess.getText();
    }

    public String showAlertInvalidAddressEmail(){
        return alertFailed.getText();
    }

    public String showAlertMessageCannotBeBlank(){
        return alertFailed.getText();
    }

    public boolean showPlaceholderEmailField(){
       return placeholderAddressEmail.isDisplayed();
    }

    public boolean showPlaceholderMessageBox(){
        return placeholderMessageBox.isDisplayed();
    }

    public void uploadFile(File file){
        inputFile.sendKeys(file.getAbsolutePath());
    }
}
