package pages.cart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".label > .material-icons")
    public WebElement continueShoppingButton;

    @FindBy(css = ".text-sm-center>a[href *= 'controller=order']")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = ".disabled")
    public WebElement disabledProceedToCheckoutButton;

    public void goToMainPage(){
        click(continueShoppingButton);
    }

    public void goToCheckout(){
        click(proceedToCheckoutButton);
    }

}
