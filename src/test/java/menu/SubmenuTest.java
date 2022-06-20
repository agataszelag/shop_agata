package menu;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.Fields;
import pages.common.MenuPage;

public class SubmenuTest extends BaseTest {
    private MenuPage menuPage;
    private Fields fields;

    @BeforeMethod
    public void beforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.fields = new Fields(driver);
    }

    @Test
    public void clickMenSubcategory(){
        menuPage.clickMenSubcategory();
        Assert.assertEquals(fields.getCardBlockCategory(), "MEN");
    }

    @Test
    public void clickWomenSubcategory(){
        menuPage.clickWomenSubcategory();
        Assert.assertEquals(fields.getCardBlockCategory(), "WOMEN");
    }

    @Test
    public void clickStationerySubcategory(){
        menuPage.clickStationerySubcategory();
        Assert.assertEquals(fields.getCardBlockCategory(), "STATIONERY");
    }

    @Test
    public void homeAccessoriesStationerySubcategory(){
        menuPage.clickHomeAccessoriesSubcategory();
        Assert.assertEquals(fields.getCardBlockCategory(), "HOME ACCESSORIES");
    }
}
