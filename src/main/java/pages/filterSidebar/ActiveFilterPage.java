package pages.filterSidebar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class ActiveFilterPage extends BasePage {
    public ActiveFilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".filter-block")
    public WebElement activeFilter;

    public String getActiveFilter(){
        waitToVisibility(activeFilter);
        return activeFilter.getText().replace("\uE5CD", "").replace("\n", "");
    }
}
