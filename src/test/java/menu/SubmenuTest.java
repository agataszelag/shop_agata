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
    private static final String MEN_SUBCATEGORY_TITLE = "MEN";
    private static final String WOMEN_SUBCATEGORY_TITLE = "WOMEN";
    private static final String STATIONERY_SUBCATEGORY_TITLE = "STATIONERY";
    private static final String HOME_ACCESSORIES_SUBCATEGORY_TITLE = "HOME ACCESSORIES";


    @BeforeMethod
    public void beforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.fields = new Fields(driver);
    }

    @Test
    public void goToMenSubcategory(){
        // given & when
        menuPage.clickMenSubcategory();

        //then
        Assert.assertEquals(fields.getCardBlockCategory(), MEN_SUBCATEGORY_TITLE);
    }

    @Test
    public void goToWomenSubcategory(){
        // given & when
        menuPage.clickWomenSubcategory();

        //then
        Assert.assertEquals(fields.getCardBlockCategory(), WOMEN_SUBCATEGORY_TITLE);
    }

    @Test
    public void goToStationerySubcategory(){
        // given & when
        menuPage.clickStationerySubcategory();

        //then
        Assert.assertEquals(fields.getCardBlockCategory(), STATIONERY_SUBCATEGORY_TITLE);
    }

    @Test
    public void goToHomeAccessoriesSubcategory(){
        // given & when
        menuPage.clickHomeAccessoriesSubcategory();

        //then
        Assert.assertEquals(fields.getCardBlockCategory(), HOME_ACCESSORIES_SUBCATEGORY_TITLE);
    }
}
