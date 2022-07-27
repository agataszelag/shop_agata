package cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cart.CartLeftGridPage;
import pages.cart.CartPage;
import pages.cart.PopUpAddToCartPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductTilePage;

public class CartLeftGridTest extends BaseTest {

    private CartLeftGridPage cartLeftGridPage;
    private ProductTilePage productTilePage;
    private ProductDetailsPage productDetailsPage;
    private PopUpAddToCartPage popUpAddToCartPage;
    private CartPage cartPage;
    private static final String CART_LEFT_GRID_HEADER = "SHOPPING CART";
    private static final String EMPTY_CART_INFORMATION = "There are no more items in your cart";

    @BeforeMethod
    public void beforeMethod(){
        this.cartLeftGridPage = new CartLeftGridPage(driver);
        this.productTilePage = new ProductTilePage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.popUpAddToCartPage = new PopUpAddToCartPage(driver);
        this.cartPage = new CartPage(driver);

    };

    @Test
    public void showShoppingCartHeader(){
        //given & when
        productTilePage.clickProductTitle("HUMMINGBIRD SWEATER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //then
        Assert.assertEquals(cartLeftGridPage.getShoppingCartTitle(), CART_LEFT_GRID_HEADER);
    }

    @Test
    public void showOneProductInCartGrid(){
        //given & when
        productTilePage.clickProductTitle("HUMMINGBIRD SWEATER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //then
        Assert.assertTrue(cartLeftGridPage.productLineGridIsDisplayed());
    }

    @Test
    public void showTwoDifferentProductInCartGrid(){
        //given & when
        productTilePage.clickProductTitle("HUMMINGBIRD SWEATER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();
        cartPage.goToMainPage();
        productTilePage.clickProductTitle("THE ADVENTURE POSTER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //then
        Assert.assertEquals(cartLeftGridPage.getListOfProductLine(), 2);
    }

    @Test
    public void showThreeDifferentProductsInCartGrid(){
        //given & when
        productTilePage.clickProductTitle("HUMMINGBIRD SWEATER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();
        cartPage.goToMainPage();
        productTilePage.clickProductTitle("THE ADVENTURE POSTER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();
        cartPage.goToMainPage();
        productTilePage.clickProductTitle("MUG TODAY IS A GOOD DAY");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //then
        Assert.assertEquals(cartLeftGridPage.getListOfProductLine(), 3);
    }

    @Test
    public void addingTheSameProductShowOneLineOfProduct(){
        //given & when
        productTilePage.clickProductTitle("TODAY POSTER");
        productDetailsPage.setQuantity();
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();
        cartPage.goToMainPage();
        productTilePage.clickProductTitle("TODAY POSTER");
        productDetailsPage.setQuantity();
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //then
        Assert.assertEquals(cartLeftGridPage.getListOfProductLine(), 1);
    }

    @Test
    public void addingTheSameProductChangeQuantity() {
        //given & when
        productTilePage.clickProductTitle("TODAY POSTER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();
        cartPage.goToMainPage();
        productTilePage.clickProductTitle("TODAY POSTER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //then
        Assert.assertEquals(cartLeftGridPage.getQuantity(), Integer.toString(2));
    }

    @Test
    public void removeProductFromCart(){
        //given
        productTilePage.clickProductTitle("TODAY POSTER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //when
        cartLeftGridPage.removeFromCart();

        //then
        Assert.assertEquals(cartLeftGridPage.getEmptyCartInformation(), EMPTY_CART_INFORMATION);
    }

    @Test
    public void RemoveAllProductsFromCart(){
        //given & when
        productTilePage.clickProductTitle("HUMMINGBIRD SWEATER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();
        cartPage.goToMainPage();
        productTilePage.clickProductTitle("THE ADVENTURE POSTER");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();
        cartPage.goToMainPage();
        productTilePage.clickProductTitle("MUG TODAY IS A GOOD DAY");
        productDetailsPage.clickAddToCartButton();
        popUpAddToCartPage.clickProceedToCheckoutButton();

        //when
        cartLeftGridPage.deleteAllProducts();

        //then
        Assert.assertEquals(cartLeftGridPage.getEmptyCartInformation(), EMPTY_CART_INFORMATION);
    }
}
