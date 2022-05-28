package pages.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#_desktop_user_info>.user-info")
    private WebElement signInButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(css = ".account")
    private WebElement accountName;

    @FindBy(className = "logout")
    private WebElement signOutButton;

    @FindBy(className = "cart-products-count")
    private WebElement amountOfProduct;

    public void goToSignIn(){
        click(signInButton);
    }

    public void goToContactUs(){
        click(contactUsButton);
    }

    public String getAccountName(){
        return accountName.getText();
    }

    public void clickSignOutButton(){
        click(signOutButton);
    }

    public String getAmountOfProduct(){
        return amountOfProduct.getText();
    }
}
