package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ProductTilePage extends BasePage {
    public ProductTilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-title")
    private List<WebElement> productTitle;

    @FindBy(className = "regular-price")
    private List<WebElement> regularPrice;

    public void clickProductTitle(String name){
        for(WebElement productTitle : productTitle){
            if(productTitle.getText().contains(name)){
                click(productTitle);
                break;
            }
        }
    }
}
