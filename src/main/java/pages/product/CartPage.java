package pages.product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-content-btn > .btn-primary")
    public WebElement proceedToCheckoutButton;

    @FindBy(className = "btn-secondary")
    private WebElement continueShoppingButton;

    @FindBy(css = ".card-block > h1")
    private WebElement shoppingCartTitle;

    @FindBy(className = "remove-from-cart")
    public WebElement removeIcon;

    @FindBy(css = ".no-items")
    public WebElement emptyCartInformation;

    public void clickProceedToCheckoutButton(){
        waitToVisibility(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
    }

    public void clickContinueShoppingButton(){
        waitToVisibility(continueShoppingButton);
        click(continueShoppingButton);
    }

    public String showShoppingCartTitle(){
        return shoppingCartTitle.getText();
    }

    public void removeFromCart(){
        click(removeIcon);
    }

    public String showEmptyCartInformation(){
        waitToVisibility(emptyCartInformation);
        return emptyCartInformation.getText();
    }
}
