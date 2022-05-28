package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#main>.page-header>h1")
    private WebElement signUpPageHeader;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(css = "a[href*='password']")
    private WebElement forgotPasswordButton;

    String randomEmail = BasePage.getRandomEmail();
    String randomPassword = BasePage.getRandomChar();
    String randomName = BasePage.getRandomChar();
    String randomLastName = BasePage.getRandomChar();


    public String getSignUpPageHeader(){
        return signUpPageHeader.getText();
    }

    public void clickSignInButton(){
        click(signInButton);
    }

    public String setRandomPassword(){
        return randomPassword;
    }

    public String setRandomAddressEmail(){
        return randomEmail;
    }

    public String getRandomName(){
        return randomName;
    }

    public String getRandomLastName(){
        return randomLastName;
    }

    public void clickForgotPasswordButton(){
        click(forgotPasswordButton);
    }
}
