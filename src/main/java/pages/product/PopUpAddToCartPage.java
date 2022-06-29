package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class PopUpAddToCartPage extends BasePage {

    public PopUpAddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-quantity > strong")
    private WebElement productQuantity;

    public String getProductQuantity(){
        waitToVisibility(productQuantity);
        return productQuantity.getText();
    }
}
