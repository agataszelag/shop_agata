package filterSidebar.Clothes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.filterSidebar.ActiveFilterPage;
import pages.filterSidebar.PropertyFilterPage;

public class PropertyFilterTest extends BaseTest {

    private PropertyFilterPage propertyFilterPage;
    private ActiveFilterPage activeFilterPage;
    private static final String LONG_SLEEVES_CHECKBOX = "Property: Long sleeves";
    private static final String SHORT_SLEEVES_CHECKBOX = "Property: Short sleeves";

    @BeforeMethod
    private void beforeMethod(){
        this.propertyFilterPage = new PropertyFilterPage(driver);
        this.activeFilterPage = new ActiveFilterPage(driver);
        driver.get("http://146.59.32.4/index.php?id_category=3&controller=category&id_lang=2");
    }

    @Test
    public void selectLongSleevesProperty(){
        //given & when
        propertyFilterPage.selectLongSleevesFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), LONG_SLEEVES_CHECKBOX);
    }

    @Test
    public void selectShortSleevesProperty(){
        //given & when
        propertyFilterPage.selectShortSleevesFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), SHORT_SLEEVES_CHECKBOX);
    }

/*    @Test
    public void selectAllColors(){
        //given & when
        propertyFilterPage.selectLongSleevesFilter();
        propertyFilterPage.selectShortSleevesFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), LONG_SLEEVES_CHECKBOX, SHORT_SLEEVES_CHECKBOX);
    }*/
}
