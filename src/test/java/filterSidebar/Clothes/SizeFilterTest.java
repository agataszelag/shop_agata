package filterSidebar.Clothes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.filterSidebar.ActiveFilterPage;
import pages.filterSidebar.SizeFilterPage;

public class SizeFilterTest extends BaseTest {

    private SizeFilterPage sizeFilterPage;
    private ActiveFilterPage activeFilterPage;
    private static final String SIZE_S_CHECKBOX = "Size: S";
    private static final String SIZE_M_CHECKBOX = "Size: M";
    private static final String SIZE_L_CHECKBOX = "Size: L";
    private static final String SIZE_XL_CHECKBOX = "Size: XL";

    @BeforeMethod
    private void beforeMethod(){
        this.sizeFilterPage = new SizeFilterPage(driver);
        this.activeFilterPage = new ActiveFilterPage(driver);
        driver.get("http://146.59.32.4/index.php?id_category=3&controller=category&id_lang=2");
    }

    @Test
    public void selectSizeS(){
        //given & when
        sizeFilterPage.selectSizeSFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), SIZE_S_CHECKBOX);
    }

    @Test
    public void selectSizeM(){
        //given & when
        sizeFilterPage.selectSizeMFilter();

        ////then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), SIZE_M_CHECKBOX);
    }

    @Test
    public void selectSizeL(){
        //given & when
        sizeFilterPage.selectSizeLFilter();

        ////then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), SIZE_L_CHECKBOX);
    }

    @Test
    public void selectSizeXL(){
        //given & when
        sizeFilterPage.selectSizeXlFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), SIZE_XL_CHECKBOX);
    }

    @Test
    public void selectAllSize(){
        //given & when
        sizeFilterPage.selectSizeSFilter();
        sizeFilterPage.selectSizeMFilter();
        sizeFilterPage.selectSizeLFilter();
        sizeFilterPage.selectSizeXlFilter();

    }
}
