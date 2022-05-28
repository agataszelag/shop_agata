package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class PopularProduct extends BasePage {
    public PopularProduct(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "products-section-title")
    private WebElement popularProductsTitle;

    public String popularProductTitleIsDisplayed(){
       return popularProductsTitle.getText();
    };

}
