package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#js-product-list-header")
    private WebElement searchHeader;

    public String getSearchHeader(){
        return searchHeader.getText();
    }

}
