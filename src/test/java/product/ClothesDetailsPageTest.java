package product;

import base.BaseTest;
import models.ClothesSize;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cart.PopUpAddToCartPage;
import pages.product.ProductDetailsPage;

public class ClothesDetailsPageTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;
    private PopUpAddToCartPage popUpAddToCartPage;
    private static final String SIZE_S = "S";
    private static final String SIZE_M = "M";
    private static final String SIZE_L = "L";
    private static final String SIZE_XL = "XL";
    private static final String WHITE_COLOUR = "White";
    private static final String BLACK_COLOUR = "Black";


    @BeforeMethod
    public void beforeMethod(){
        this.productDetailsPage= new ProductDetailsPage(driver);
        this.popUpAddToCartPage = new PopUpAddToCartPage(driver);
        driver.get("http://146.59.32.4/index.php?id_product=1&id_product_attribute=1&rewrite=hummingbird-printed-t-shirt&controller=product&id_lang=2#/1-size-s/8-color-white");
    }

    @Test
    public void selectSizeXL(){
        // given & when
        productDetailsPage.selectSizeOfProduct(ClothesSize.XL);
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductSize(), SIZE_XL);
    }

    @Test
    public void selectSizeL(){
        // given & when
        productDetailsPage.selectSizeOfProduct(ClothesSize.L);
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductSize(), SIZE_L);
    }

    @Test
    public void selectSizeM(){
        // given & when
        productDetailsPage.selectSizeOfProduct(ClothesSize.M);
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductSize(), SIZE_M);
    }

    @Test
    public void selectSizeS(){
        // given & when
        productDetailsPage.selectSizeOfProduct(ClothesSize.S);
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductSize(), SIZE_S);
    }

    @Test
    public void setQuantityUpByArrow(){
        // given & when
        productDetailsPage.setQuantityWithArrowUp();
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductQuantity(), "5");
    }

    @Test
    public void setQuantityDownByArrow(){
        // given & when
        productDetailsPage.setQuantityWithArrowUp();
        productDetailsPage.setQuantityWithArrowDown();
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductQuantity(), "3");
    }
    @Test
    public void selectBlackColour() {
        // given & when
        productDetailsPage.setBlackColour();
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductColour(), BLACK_COLOUR);
    }

    @Test
    public void selectWhiteColour() {
        // given & when
        productDetailsPage.setWhiteColour();
        productDetailsPage.clickAddToCartButton();

        // then
        Assert.assertEquals(popUpAddToCartPage.getProductColour(), WHITE_COLOUR);
    }

}
