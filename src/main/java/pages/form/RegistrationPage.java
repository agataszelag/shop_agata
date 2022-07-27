package pages.form;

import models.SocialTitle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "no-account")
    public WebElement createAccountButton;
    @FindBy(css = ".page-header>h1")
    public WebElement accountPageHeader;
    @FindBy(name = "id_gender")
    public List<WebElement> socialTitles;
    @FindBy(name = "firstname")
    public WebElement firstName;
    @FindBy(name = "lastname")
    public WebElement lastName;
    @FindBy(name = "birthday")
    public WebElement birthday;
    @FindBy(name = "optin")
    public WebElement checkboxReceiveOffersFromOurPartners;
    @FindBy(name = "customer_privacy")
    public WebElement checkboxCustomerPrivacy;
    @FindBy(name = "newsletter")
    public WebElement checkboxSignUpForOurNewsletter;
    @FindBy(name = "psgdpr")
    public WebElement checkBoxPrivatePolicy;
    @FindBy(className = "btn-primary")
    public WebElement saveButton;
    @FindBy(css = "a[href*='authentication']")
    public WebElement logInInsteadButton;

    public void goToRegisterForm() {
        click(createAccountButton);
    }

    public String getAccountPageHeader() {
        return accountPageHeader.getText();
    }

    public void selectSocialTitle(SocialTitle socialTitle) {
        socialTitles.get(socialTitle.getIndex()).click();
    }

    public void setFirstName(String firstNames){
        firstName.sendKeys(firstNames);
    }

    public void setLastName(String lastNames){
        lastName.sendKeys(lastNames);
    }

    public void setBirthdayDate(LocalDate birthdayDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String birthdayDateToString = birthdayDate.format(formatter);
        birthday.sendKeys(birthdayDateToString);
    }

    public void selectCheckboxReceiveOffersFromOurPartners(){
        checkboxReceiveOffersFromOurPartners.click();
    }

    public void selectCustomerPrivacy(){
        checkboxCustomerPrivacy.click();
    }

    public void selectSignUpForOurNewsletter(){
        checkboxSignUpForOurNewsletter.click();
    }

    public void selectPrivatePolicy(){
        checkBoxPrivatePolicy.click();
    }

    public void clickSaveButton(){
        click(saveButton);
    }

    public String getValidationMessageForFirstName(){
        return firstName.getAttribute("validationMessage");
    }

    public String getValidationMessageForLastName(){
        return lastName.getAttribute("validationMessage");
    }

    public String getValidationMessageForCustomerDataPrivacy(){
        return checkboxCustomerPrivacy.getAttribute("validationMessage");
    }

    public void clickLogInInsteadButton(){
        click(logInInsteadButton);
    }
}
