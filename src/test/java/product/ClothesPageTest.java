package product;

import base.BaseTest;
import models.ClothesSize;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.MenuPage;
import pages.product.ClothesPage;
import pages.product.PopUpAddToCartPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductTilePage;

public class ClothesPageTest extends BaseTest {
    private MenuPage menuPage;
    private ProductTilePage productTilePage;
    private ClothesPage clothesPage;
    private ProductDetailsPage productDetailsPage;
    private PopUpAddToCartPage popUpAddToCartPage;

    @BeforeMethod
    public void BeforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.productTilePage = new ProductTilePage(driver);
        this.clothesPage = new ClothesPage(driver);
        this.productDetailsPage= new ProductDetailsPage(driver);
        this.popUpAddToCartPage = new PopUpAddToCartPage(driver);

    }

    @Test
    public void selectSizeXL(){
        menuPage.clickMenSubcategory();
        productTilePage.clickProductName("HUMMINGBIRD T-SHIRT");
        clothesPage.selectSizeOfProduct(ClothesSize.XL);

        Assert.assertEquals(clothesPage.selectedSize(), "XL");
    }

    @Test
    public void selectSizeL(){
        menuPage.clickMenSubcategory();
        productTilePage.clickProductName("HUMMINGBIRD T-SHIRT");
        clothesPage.selectSizeOfProduct(ClothesSize.L);

        Assert.assertEquals(clothesPage.selectedSize(), "L");
    }

    @Test
    public void selectSizeM(){
        menuPage.clickMenSubcategory();
        productTilePage.clickProductName("HUMMINGBIRD T-SHIRT");
        clothesPage.selectSizeOfProduct(ClothesSize.M);

        Assert.assertEquals(clothesPage.selectedSize(), "M");
    }

    @Test
    public void selectSizeS(){
        menuPage.clickMenSubcategory();
        productTilePage.clickProductName("HUMMINGBIRD T-SHIRT");
        clothesPage.selectSizeOfProduct(ClothesSize.S);

        Assert.assertEquals(clothesPage.selectedSize(), "S");
    }

    @Test
    public void setQuantityUpByArrow(){
        menuPage.clickMenSubcategory();
        productTilePage.clickProductName("HUMMINGBIRD T-SHIRT");
        productDetailsPage.setQuantityWithArrowUp();
        productDetailsPage.clickAddToCartButton();

        Assert.assertEquals(popUpAddToCartPage.getProductQuantity(), "5");
    }

    @Test
    public void setQuantityDownByArrow(){
        menuPage.clickMenSubcategory();
        productTilePage.clickProductName("HUMMINGBIRD T-SHIRT");
        productDetailsPage.setQuantityWithArrowUp();
        productDetailsPage.setQuantityWithArrowDown();
        productDetailsPage.clickAddToCartButton();

        Assert.assertEquals(popUpAddToCartPage.getProductQuantity(), "3");
    }


}
