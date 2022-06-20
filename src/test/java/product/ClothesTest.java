package product;

import base.BaseTest;
import models.ClothesSize;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.MenuPage;
import pages.product.Clothes;
import pages.product.ProductTilePage;

public class ClothesTest extends BaseTest {
    private MenuPage menuPage;
    private ProductTilePage productTilePage;
    private Clothes clothes;

    @BeforeMethod
    public void BeforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.productTilePage = new ProductTilePage(driver);
        this.clothes = new Clothes(driver);
    }

    @Test
    public void selectSize(){
        menuPage.clickMenSubcategory();
        productTilePage.clickProductName("HUMMINGBIRD T-SHIRT");
        clothes.selectClothesSize(ClothesSize.M);
    }

}
