package pages.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class PopularProducts extends BasePage {
    public PopularProducts(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".products-section-title")
    private WebElement popularProductsHeader;

    public String popularProductTitleIsDisplayed(){
        return popularProductsHeader.getText();
    };

}
