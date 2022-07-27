package product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mainPage.PopularProducts;

public class PopularProductTest extends BaseTest {
    private PopularProducts popularProductPage;

    @BeforeMethod
    public void beforeMethod(){
        this.popularProductPage = new PopularProducts(driver);
    }

    @Test
    public void popularProductTitleIsDisplayedOnMainPage(){
        popularProductPage.popularProductTitleIsDisplayed();
        Assert.assertEquals(popularProductPage.popularProductTitleIsDisplayed(), "POPULAR PRODUCTS");
    }

}
