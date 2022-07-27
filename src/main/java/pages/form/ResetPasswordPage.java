package pages.form;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class ResetPasswordPage extends BasePage {
    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "page-header")
    private WebElement resetPasswordPageHeader;
    @FindBy(className = "hidden-xs-down")
    private WebElement sendResetLinkButton;
    @FindBy(className = "material-icons")
    private WebElement backToLoginButton;
    @FindBy(className = "item")
    private WebElement alertSuccess;


    public String showResetPasswordPageHeader() {
        return resetPasswordPageHeader.getText();
    }

    public String goToResetPasswordForm() {
        return resetPasswordPageHeader.getText();
    }

    public void clickSendResetLinkButton() {
        click(sendResetLinkButton);
    }

    public void clickBackToLoginButton() {
        click(backToLoginButton);
    }

    public String showAlertSuccess() {
        return alertSuccess.getText();
    }
}
