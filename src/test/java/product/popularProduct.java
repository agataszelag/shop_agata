package product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.product.PopularProduct;
import pages.product.ProductTile;

public class popularProduct extends BaseTest {


    @Test
    public void popularProductTitleIsDisplayedOnMainPage(){
        PopularProduct popularProduct = new PopularProduct(driver);

        popularProduct.popularProductTitleIsDisplayed();

        Assert.assertEquals(popularProduct.popularProductTitleIsDisplayed(), "POPULAR PRODUCTS");
    }

    @Test
    public void showTextFromProduct(){
/*
        ProductTile productTile = new ProductTile(driver);

        System.out.println(productTile.getTextFromProductTitle());
*/

    }
}
