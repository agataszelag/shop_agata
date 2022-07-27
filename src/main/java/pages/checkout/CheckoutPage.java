package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-item>.active")
    public WebElement personalInformationHeader;

    public String getOrderAsAGuestsHeader(){
        return personalInformationHeader.getText();
    }
}
