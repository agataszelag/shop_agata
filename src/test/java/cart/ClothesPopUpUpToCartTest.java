package cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cart.CartPage;
import pages.cart.PopUpAddToCartPage;
import pages.product.ProductDetailsPage;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ClothesPopUpUpToCartTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private PopUpAddToCartPage popUpAddToCartPage;
    private static final String CART_PRODUCT_COUNT_INFORMATION = "There is 1 item in your cart.";
    private static final Double SHIPPING_VALUE = 7.00D;
    private static final Double SUBTOTAL_VALUE = 19.12D;

    private static final String IMAGE_URL = "http://146.59.32.4/img/p/2/2-home_default.jpg";
    

    @BeforeMethod
    public void beforeMethod(){
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.cartPage = new CartPage(driver);
        this.popUpAddToCartPage= new PopUpAddToCartPage(driver);
        driver.get("http://146.59.32.4/index.php?id_product=1&id_product_attribute=1&rewrite=hummingbird-printed-t-shirt&controller=product&id_lang=2#/1-size-s/8-color-white");
    }

    @Test
    public void showTitleInformation(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getProductName(), productDetailsPage.getProductTitle());
    }

    @Test
    public void showProductPriceInformation(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getProductPrice(), productDetailsPage.getPrice());
    }

    @Test
    public void showSizeInformation(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getProductSize(), productDetailsPage.selectedSize());
    }

    @Test
    public void showColorInformation(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getProductColour(), productDetailsPage.getWhiteColour());
    }

    @Test
    public void showQuantityInformation(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getProductQuantity(), productDetailsPage.getQuantity());
    }

    @Test
    public void showInformationAboutNumberOFItems(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getCartProductCountInformation(), CART_PRODUCT_COUNT_INFORMATION);
    }

    @Test
    public void showInformationAboutSubtotalPrice(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getSubtotalValue(), productDetailsPage.getPrice());
    }

    @Test
    public void showInformationAboutShippingValue(){
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("##0.00", decimalFormatSymbols);

        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getShippingValue(),decimalFormat.format(SHIPPING_VALUE));
    }

    @Test
    public void showInformationAboutTotalPrice(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.getTotalValue(), Double.toString(SUBTOTAL_VALUE + SHIPPING_VALUE));

    }

    @Test
    public void showProductImage(){
        // given & when
        productDetailsPage.clickAddToCartButton();

        //then
        Assert.assertEquals(popUpAddToCartPage.showProductImage(), IMAGE_URL);
    }
}
