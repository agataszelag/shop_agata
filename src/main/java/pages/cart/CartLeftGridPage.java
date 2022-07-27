package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CartLeftGridPage extends BasePage {
    public CartLeftGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card-block > h1")
    private WebElement shoppingCartTitle;
    @FindBy(css = ".product-line-grid")
    private WebElement productLineGrid;
    @FindBy(css = ".form-control")
    private WebElement quantity;
    @FindBy(css = ".cart-item")
    public List<WebElement> listOfProductLine;
    @FindBy(css = ".remove-from-cart>.float-xs-left")
    public WebElement removeIcon;
    @FindBy(css = ".remove-from-cart>.float-xs-left")
    public List<WebElement> removeIcons;
    @FindBy(css = ".no-items")
    public WebElement emptyCartInformation;


    public String getShoppingCartTitle(){
        return shoppingCartTitle.getText();
    }

    public boolean productLineGridIsDisplayed(){
        if(productLineGrid.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

    public int getListOfProductLine(){
        for(WebElement element : listOfProductLine){}
        return listOfProductLine.size();
    }

    public String getQuantity(){
        return quantity.getAttribute("value");
    }

    public void removeFromCart(){
        click(removeIcon);
    }

    public String getEmptyCartInformation(){
        waitToVisibility(emptyCartInformation);
        return emptyCartInformation.getText();
    }

    public void deleteAllProducts(){
        for(WebElement element : removeIcons){
            click(element);
        }
    }
}
