package pages.filterSidebar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ColorFilterPage extends BasePage {
    public ColorFilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(3)>.collapse>li:first-of-type")
    public WebElement whiteColorCheckbox;

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(3)>.collapse>li:nth-of-type(2)")
    public WebElement blackColorCheckbox;

    private String whiteCheckboxLocator = "#search_filters>.clearfix:nth-of-type(3)>.collapse>li:first-of-type";
    private String blackCheckboxLocator = "#search_filters>.clearfix:nth-of-type(3)>.collapse>li:nth-of-type(2)";


    public void selectWhiteColorFilter(){
        waitToVisibilityElementLocated(whiteCheckboxLocator);
        click(whiteColorCheckbox);
    }
    public void selectBlackColorFilter(){
        waitToVisibilityElementLocated(blackCheckboxLocator);
        click(blackColorCheckbox);
    }
}
