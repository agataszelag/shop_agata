package pages.cart;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class PopUpAddToCartPage extends BasePage {

    public PopUpAddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-name")
    private WebElement productName;
    @FindBy(css = ".col-md-6>.product-price")
    private WebElement productPrice;
    @FindBy(css = "dimension")
    private WebElement dimension;
    @FindBy(css = ".product-quantity > strong")
    private WebElement productQuantity;
    @FindBy(css = ".size > strong")
    private WebElement productSize;
    @FindBy(css = "#myModalLabel")
    private WebElement labelProductAddedToCart;
    @FindBy(css = ".col-md-6 > .color > strong")
    private WebElement colour;
    @FindBy(css = ".cart-content-btn > .btn-primary")
    public WebElement proceedToCheckoutButton;
    @FindBy(css = ".btn-secondary")
    private WebElement continueShoppingButton;
    @FindBy(css = "button > span > i" )
    private WebElement crossButton;
    @FindBy(css = "#blockcart-modal")
    private WebElement hiddenPopup;
    @FindBy(css = ".cart-content>.cart-products-count")
    private WebElement cartProductCountInformation;
    @FindBy(css = ".subtotal")
    private WebElement subtotalValue;
    @FindBy(css = ".shipping")
    private WebElement shippingValue;
    @FindBy(css = ".product-total>.value")
    private WebElement totalValue;
    @FindBy(css = ".product-image")
    private WebElement productImage;


    public String getProductQuantity(){
        waitToVisibility(productQuantity);
        return productQuantity.getText();
    }

    public String getProductSize(){
        waitToVisibility(productSize);
        return productSize.getText();
    }

    public String showLabelInPopUpProductSuccessfullyAddedToCart(){
        waitToVisibility(labelProductAddedToCart);
        return labelProductAddedToCart.getText();
    }
    public String getProductColour(){
        waitToVisibility(colour);
        return colour.getText();
    }

    public void clickProceedToCheckoutButton(){
        waitToVisibility(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
    }

    public void clickContinueShoppingButton(){
        waitToVisibility(continueShoppingButton);
        click(continueShoppingButton);
    }

    public void clickCrossButton(){
        click(crossButton);
    }

    public boolean getAttributeHiddenPopup(){
        waitToAttributeContainsValue(hiddenPopup, "aria-hidden", "true");
        //String aria = hiddenPopup.getAttribute("aria-hidden");
        if(hiddenPopup != null){
            return true;
        } else {
            return false;
        }
    }
    public String getProductName() {
        waitToVisibility(productName);
        return productName.getText();
    }

    public String getProductPrice() {
        waitToVisibility(productPrice);
        return String.valueOf(productPrice.getText().substring(1));
    }

    public String getCartProductCountInformation(){
        waitToVisibility(cartProductCountInformation);
        return cartProductCountInformation.getText();
    }

    public String getSubtotalValue(){
        waitToVisibility(subtotalValue);
        return String.valueOf(subtotalValue.getText().substring(1));
    }

    public String getShippingValue(){
        waitToVisibility(shippingValue);
        return String.valueOf(shippingValue.getText().substring(1));
    }

    public String getTotalValue(){
        waitToVisibility(totalValue);
        return String.valueOf(totalValue.getText().substring(1));
    }

    public String showProductImage() {
        waitToVisibility(productImage);
        return productImage.getAttribute("src");
    }
}
