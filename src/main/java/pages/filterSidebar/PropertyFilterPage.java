package pages.filterSidebar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class PropertyFilterPage extends BasePage {
    public PropertyFilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(4)>.collapse>li:first-of-type")
    public WebElement longSleevesCheckbox;

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(4)>.collapse>li:nth-of-type(2)")
    public WebElement shortSleevesCheckbox;

    private String longSleevesLocator = "#search_filters>.clearfix:nth-of-type(3)>.collapse>li:first-of-type";
    private String shortSleevesLocator = "#search_filters>.clearfix:nth-of-type(3)>.collapse>li:nth-of-type(2)";


    public void selectLongSleevesFilter(){
        waitToVisibilityElementLocated(longSleevesLocator);
        click(longSleevesCheckbox);
    }
    public void selectShortSleevesFilter(){
        waitToVisibilityElementLocated(shortSleevesLocator);
        click(shortSleevesCheckbox);
    }
}
