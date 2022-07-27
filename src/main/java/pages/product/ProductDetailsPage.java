package pages.product;

import models.ClothesSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;
    @FindBy(css = "#quantity_wanted")
    private WebElement quantity;
    @FindBy(css = ".h1")
    private WebElement productTitle;
    @FindBy(css = ".current-price > [itemprop='price']")
    private WebElement price;
    @FindBy(css = ".touchspin-up")
    private WebElement quantityArrowUp;
    @FindBy(css = ".touchspin-down")
    private WebElement quantityArrowDown;
    @FindBy(css = "input[title='Black']")
    private WebElement blackColour;
    @FindBy(css = "input[title='White']")
    private WebElement whiteColour;
    @FindBy(css = ".form-control-select")
    private WebElement clotheSize;
    @FindBy(css = ".input-color")
    private WebElement colour;


    public void clickAddToCartButton(){
        click(addToCartButton);
    }

    public void setQuantity(){
        sendKeysWithClear(quantity);
        quantity.sendKeys(String.valueOf(getRandomIntValue()));
    }

    public void setQuantityWithArrowUp(){
        actions.doubleClick(quantityArrowUp).doubleClick(quantityArrowUp).perform();
    }

    public void setQuantityWithArrowDown(){
        actions.doubleClick(quantityArrowDown).perform();
    }


    public String getProductTitle(){
        return productTitle.getText();
    }

    public void setBlackColour() {
        blackColour.click();
    }

    public void setWhiteColour() {
        whiteColour.click();
    }

    public String getWhiteColour() {
        return colour.getAttribute("title");
    }

    public String getPrice(){
        return String.valueOf(price.getText().substring(1));
    }

    public String getQuantity() {
        return quantity.getAttribute("value");
    }

    public void selectSizeOfProduct(ClothesSize clothesSize){
        Select select = new Select(clotheSize);
        switch (clothesSize){
            case S:
                select.selectByIndex(0);
                break;
            case M:
                select.selectByIndex(1);
                break;
            case L:
                select.selectByIndex(2);
                break;
            case XL:
                select.selectByIndex(3);
                break;
        }
    }
    public String selectedSize(){
        Select select = new Select(clotheSize);
        return select.getFirstSelectedOption().getText();
    }
}
