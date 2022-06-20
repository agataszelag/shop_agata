package pages.product;

import models.ClothesSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class Clothes extends BasePage {
    public Clothes(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "form-control-select")
    private List<WebElement> clothesSize;

    public void selectClothesSize(ClothesSize clotheSize){
        clothesSize.get(clotheSize.getIndex()).click();
    }


}
