package product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.MenuPage;
import pages.product.CartPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductTilePage;

public class CartTest extends BaseTest {
    private ProductTilePage productTilePage;
    private ProductDetailsPage productDetailsPage;
    private MenuPage menuPage;
    private CartPage cartPage;


    @BeforeMethod
    public void beforeMethod(){
        this.productTilePage = new ProductTilePage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.menuPage = new MenuPage(driver);
        this.cartPage = new CartPage(driver);
    }


    @Test
    public void addToCart(){

        productTilePage.clickProductName("HUMMINGBIRD SWEATER");
        productDetailsPage.setQuantity();
        productDetailsPage.clickAddToCartButton();

        Assert.assertEquals(productDetailsPage.showLabelInPopUpProductSuccessfullyAddedToCart(), "\uE876Product successfully added to your shopping cart");
    }

    @Test
    public void buttonCartIsEmpty(){

        Assert.assertEquals(menuPage.getAmountOfProduct(), "(0)");
    }

    @Test
    public void comeBackToContinueShoppingFormPopUp(){

        productTilePage.clickProductName("THE BEST IS YET POSTER");
        productDetailsPage.setQuantity();
        productDetailsPage.clickAddToCartButton();
        cartPage.clickContinueShoppingButton();

        Assert.assertEquals(productDetailsPage.getProductTitle(), "THE BEST IS YET POSTER");
    }

    @Test
    public void goToShoppingCart(){

        productTilePage.clickProductName("THE BEST IS YET POSTER");
        productDetailsPage.clickAddToCartButton();
        cartPage.clickProceedToCheckoutButton();

        Assert.assertEquals(menuPage.getAmountOfProduct(), "(1)");
    }

    @Test
    public void removeFromCart(){

        productTilePage.clickProductName("THE BEST IS YET POSTER");
        productDetailsPage.clickAddToCartButton();
        cartPage.clickProceedToCheckoutButton();
        cartPage.removeFromCart();

        Assert.assertEquals(cartPage.showEmptyCartInformation(), "There are no more items in your cart");
    }
}
