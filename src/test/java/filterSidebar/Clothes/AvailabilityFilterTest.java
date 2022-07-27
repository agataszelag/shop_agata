package filterSidebar.Clothes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.filterSidebar.ActiveFilterPage;
import pages.filterSidebar.AvailabilityFilterPage;

public class AvailabilityFilterTest extends BaseTest {

    private AvailabilityFilterPage availabilityFilterPage;
    private ActiveFilterPage activeFilterPage;
    private static final String AVAILABLE_CHECKBOX = "Availability: Available";
    private static final String IN_STOCK_CHECKBOX = "Availability: In stock";

    @BeforeMethod
    private void beforeMethod(){
        this.availabilityFilterPage = new AvailabilityFilterPage(driver);
        this.activeFilterPage = new ActiveFilterPage(driver);
        driver.get("http://146.59.32.4/index.php?id_category=3&controller=category&id_lang=2");
    }

    @Test
    public void selectAvailableCheckbox(){
        //given & when
        availabilityFilterPage.selectAvailableFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), AVAILABLE_CHECKBOX);
    }

    @Test
    public void selectInStockCheckbox(){
        //given & when
        availabilityFilterPage.selectInStockFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), IN_STOCK_CHECKBOX);
    }

    @Test
    public void selectAllColors(){
        //given & when
        availabilityFilterPage.selectAvailableFilter();
        availabilityFilterPage.selectInStockFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), AVAILABLE_CHECKBOX, IN_STOCK_CHECKBOX);
    }
}
