package filterSidebar.Clothes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.filterSidebar.ActiveFilterPage;
import pages.filterSidebar.ColorFilterPage;

public class ColorFilterTest extends BaseTest {

    private ColorFilterPage colorFilterPage;
    private ActiveFilterPage activeFilterPage;
    private static final String WHITE_COLOR_CHECKBOX = "Color: White";
    private static final String BLACK_COLOR_CHECKBOX = "Color: Black";

    @BeforeMethod
    private void beforeMethod(){
        this.colorFilterPage = new ColorFilterPage(driver);
        this.activeFilterPage = new ActiveFilterPage(driver);
        driver.get("http://146.59.32.4/index.php?id_category=3&controller=category&id_lang=2");
    }

    @Test
    public void selectWhiteColor(){
        //given & when
        colorFilterPage.selectWhiteColorFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), WHITE_COLOR_CHECKBOX);
    }

    @Test
    public void selectBlackColor(){
        //given & when
        colorFilterPage.selectBlackColorFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), BLACK_COLOR_CHECKBOX);
    }

/*    @Test
    public void selectAllColors(){
        //given & when
        colorFilterPage.selectWhiteColorFilter();
        colorFilterPage.selectBlackColorFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), WHITE_COLOR_CHECKBOX, BLACK_COLOR_CHECKBOX);
    }*/
}
