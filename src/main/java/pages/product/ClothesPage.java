package pages.product;

import models.ClothesSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class ClothesPage extends BasePage {
    public ClothesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "form-control-select")
    private WebElement clotheSize;


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
