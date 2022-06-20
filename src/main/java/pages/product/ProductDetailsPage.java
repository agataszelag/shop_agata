package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    @FindBy(id = "quantity_wanted")
    private WebElement quantity;

    @FindBy(id = "myModalLabel")
    private WebElement labelProductAddedToCart;

    @FindBy(css = ".h1")
    private WebElement productTitle;


    public void clickAddToCartButton(){
        click(addToCartButton);
    }

    public void setQuantity(){
        sendKeysWithClear(quantity);
        quantity.sendKeys(String.valueOf(getRandomIntValue()));
    }

    public String showLabelInPopUpProductSuccessfullyAddedToCart(){
        waitToVisibility(labelProductAddedToCart);
        return labelProductAddedToCart.getText();
    }

    public String getProductTitle(){
        return productTitle.getText();
    }
}