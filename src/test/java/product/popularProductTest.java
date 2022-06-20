package product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.product.PopularProductPage;

public class popularProductTest extends BaseTest {
    private PopularProductPage popularProductPage;

    @BeforeMethod
    public void beforeMethod(){
        this.popularProductPage = new PopularProductPage(driver);
    }

    @Test
    public void popularProductTitleIsDisplayedOnMainPage(){

        popularProductPage.popularProductTitleIsDisplayed();
        Assert.assertEquals(popularProductPage.popularProductTitleIsDisplayed(), "POPULAR PRODUCTS");
    }

    @Test
    public void showTextFromProduct(){
/*
        ProductTile productTile = new ProductTile(driver);

        System.out.println(productTile.getTextFromProductTitle());
*/
    }
}
