package pages.filterSidebar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CategoriesFilterPage extends BasePage {
    public CategoriesFilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search_filters>.clearfix:first-of-type>.collapse>li:first-of-type")
    public WebElement menCategoryCheckbox;

    @FindBy(css = "#search_filters>.clearfix:first-of-type>.collapse>li:nth-of-type(2)")
    public WebElement womanCategoryCheckbox;

    private String menCheckboxLocator = "#search_filters>.clearfix:first-of-type>.collapse>li:first-of-type";
    private String womanCheckboxLocator = "#search_filters>.clearfix:first-of-type>.collapse>li:nth-of-type(2)";

    public void selectMenCategoryFilter(){
        waitToVisibilityElementLocated(menCheckboxLocator);
        click(menCategoryCheckbox);
    }

    public void selectWomanCategoryFilter(){
        waitToVisibilityElementLocated(womanCheckboxLocator);
        click(womanCategoryCheckbox);
    }
}
