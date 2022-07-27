package pages.filterSidebar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AvailabilityFilterPage extends BasePage {
    public AvailabilityFilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(5)>.collapse>li:first-of-type")
    public WebElement availableCheckbox;

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(5)>.collapse>li:nth-of-type(2)")
    public WebElement inStockCheckbox;

    private String availableLocator = "#search_filters>.clearfix:nth-of-type(5)>.collapse>li:first-of-type";
    private String inStockLocator = "#search_filters>.clearfix:nth-of-type(5)>.collapse>li:nth-of-type(2)";


    public void selectAvailableFilter(){
        waitToVisibilityElementLocated(availableLocator);
        click(availableCheckbox);
    }
    public void selectInStockFilter(){
        waitToVisibilityElementLocated(inStockLocator);
        click(inStockCheckbox);
    }
}
