package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class Fields extends BasePage {
    public Fields(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement addressEmail;

    @FindBy(name = "password")
    private WebElement password;


    public void setRandomAddressEmail(){
        addressEmail.sendKeys(BasePage.getRandomEmail());
    }

    public void setRandomAddressEmail(String email){
        addressEmail.sendKeys(email);
    }

    public String getValidationMessageFromAddressEmail(){
        return addressEmail.getAttribute("validationMessage");
    }

    public void setRandomPassword(String passwords){
        password.sendKeys(passwords);
    }

    public void setRandomPassword(){
        password.sendKeys(BasePage.getRandomChar());
    }

    /*
    public void setAddressEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid address email. Try again.");
        }
        addressEmail.sendKeys(email);
    }
*/
}
