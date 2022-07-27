package cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cart.CartLeftGridPage;
import pages.cart.PopUpAddToCartPage;
import pages.product.ProductDetailsPage;

public class PopUpAddToCartTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;
    private PopUpAddToCartPage popUpAddToCartPage;
    private CartLeftGridPage cartLeftGridPage;
    private static final String PRODUCT_TITLE = "THE BEST IS YET POSTER";
    private static final String SHOPPING_CART_PAGE_TITLE = "SHOPPING CART";
    private static final String SUCCESS_POPUP_LABEL = "\uE876Product successfully added to your shopping cart";


    @BeforeMethod
    public void beforeMethod(){
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.popUpAddToCartPage= new PopUpAddToCartPage(driver);
        this.cartLeftGridPage = new CartLeftGridPage(driver);
        driver.get("http://146.59.32.4/index.php?id_product=4&id_product_attribute=16&rewrite=the-adventure-begins-framed-poster&controller=product&id_lang=2#/19-dimension-40x60cm");
    }

    @Test
    public void showPopUpAddToCart(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.showLabelInPopUpProductSuccessfullyAddedToCart(), SUCCESS_POPUP_LABEL);
    }

    @Test
    public void comeBackToDetailProductPage(){
        // given & when
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickContinueShoppingButton();

        //then
        Assert.assertEquals(productDetailsPage.getProductTitle(), PRODUCT_TITLE);
    }

    @Test
    public void goToShoppingCart(){
        // given & when
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //then
        Assert.assertEquals(cartLeftGridPage.getShoppingCartTitle(), SHOPPING_CART_PAGE_TITLE);
    }

    @Test
    public void closePopUpFromACross() {
        // given & when
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickCrossButton();

        //then
        Assert.assertTrue(popUpAddToCartPage.getAttributeHiddenPopup());
    }

    @Test
    public void closePopUpByClickingAwayFromWindow(){
        // given & when
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.setQuantityWithArrowUp();

        //then
        Assert.assertTrue(popUpAddToCartPage.getAttributeHiddenPopup());
    }
};
