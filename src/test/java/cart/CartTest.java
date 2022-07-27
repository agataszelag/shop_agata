package cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.checkout.CheckoutPage;
import pages.cart.CartPage;
import pages.cart.PopUpAddToCartPage;
import pages.mainPage.PopularProducts;
import pages.product.ProductDetailsPage;
import pages.product.ProductTilePage;

public class CartTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private PopUpAddToCartPage popUpAddToCartPage;
    private PopularProducts popularProducts;
    private CheckoutPage checkoutPage;
    private static final String POPULAR_PRODUCT_HEADER = "POPULAR PRODUCTS";
    private static final String ORDER_AS_A_GUESTS_INFORMATION = "Order as a guest";


    @BeforeMethod
    public void beforeMethod(){
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.cartPage = new CartPage(driver);
        this.popUpAddToCartPage= new PopUpAddToCartPage(driver);
        this.popularProducts = new PopularProducts(driver);
        this.checkoutPage = new CheckoutPage(driver);
        driver.get("http://146.59.32.4/index.php?id_product=4&id_product_attribute=16&rewrite=the-adventure-begins-framed-poster&controller=product&id_lang=2#/19-dimension-40x60cm");
    }

    @Test
    public void goToMainPage(){
        //given
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //when
        cartPage.goToMainPage();

        //then
        Assert.assertEquals(popularProducts.popularProductTitleIsDisplayed(), POPULAR_PRODUCT_HEADER);
    }

    @Test
    public void goToCheckout(){
        //given
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //when
        cartPage.goToCheckout();

        //then
        Assert.assertEquals(checkoutPage.getOrderAsAGuestsHeader(), ORDER_AS_A_GUESTS_INFORMATION);
    }
}
