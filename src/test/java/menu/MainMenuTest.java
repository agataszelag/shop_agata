package menu;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.Fields;
import pages.common.MenuPage;

public class MainMenuTest extends BaseTest {
    private MenuPage menuPage;
    private Fields fields;

    @BeforeMethod
    public void beforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.fields = new Fields(driver);
    }

    @Test
    public void clickClothesTab(){
        menuPage.clickClothesCategory();
        Assert.assertEquals(fields.getCardBlockCategory(), "CLOTHES");
    }

    @Test
    public void clickAccessoriesTab(){
        menuPage.clickAccessoriesCategory();
        Assert.assertEquals(fields.getCardBlockCategory(), "ACCESSORIES");
    }

    @Test
    public void clickArtTab(){
        menuPage.clickArtCategory();
        Assert.assertEquals(fields.getCardBlockCategory(), "ART");
    }
}
