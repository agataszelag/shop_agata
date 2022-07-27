package filterSidebar.Clothes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.filterSidebar.ActiveFilterPage;
import pages.filterSidebar.CategoriesFilterPage;

public class CategoriesFilterTest extends BaseTest {

    private CategoriesFilterPage categoriesFilterPage;
    private ActiveFilterPage activeFilterPage;
    private static final String MEN_CATEGORIES_CHECKBOX = "Categories: Men";
    private static final String WOMEN_CATEGORIES_CHECKBOX = "Categories: Women";


    @BeforeMethod
    private void beforeMethod(){
        this.categoriesFilterPage = new CategoriesFilterPage(driver);
        this.activeFilterPage = new ActiveFilterPage(driver);
        driver.get("http://146.59.32.4/index.php?id_category=3&controller=category&id_lang=2");
    }

    @Test
    public void selectMenCategory(){
        //given & when
        categoriesFilterPage.selectMenCategoryFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), MEN_CATEGORIES_CHECKBOX);
    }

    @Test
    public void selectWomanCategory(){
        //given & when
        categoriesFilterPage.selectWomanCategoryFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), WOMEN_CATEGORIES_CHECKBOX);
    }

/*    @Test
    public void selectAllCategories(){
        //given & when
        categoriesFilterPage.selectMenCategoryFilter();
        categoriesFilterPage.selectWomanCategoryFilter();

        //then
        Assert.assertEquals(activeFilterPage.getActiveFilter(), MEN_CATEGORIES_CHECKBOX, WOMEN_CATEGORIES_CHECKBOX);
    }*/
}
