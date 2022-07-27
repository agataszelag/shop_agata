package pages.filterSidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SizeFilterPage extends BasePage {
    public SizeFilterPage(WebDriver driver) {
        super(driver);
    }

/*    @FindBy(css = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:first-of-type")
    public WebElement sizeSCategoryCheckbox;

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(2)")
    public WebElement sizeMCategoryCheckbox;

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(3)")
    public WebElement sizeLCategoryCheckbox;

    @FindBy(css = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(4)")
    public WebElement sizeXLCategoryCheckbox;*/

    private String sizeSLocator = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:first-of-type";
    private String sizeMLocator = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(2)";
    private String sizeLLocator = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(3)";
    private String sizeXLLocator = "#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(4)";

    public void selectSizeSFilter(){
        WebElement sizeFilterS = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:first-of-type"));
        waitToVisibilityElementLocated(sizeSLocator);
        sizeFilterS = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:first-of-type"));
        sizeFilterS.click();
    }

    public void selectSizeMFilter(){
        WebElement sizeFilterM = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(2)"));
        waitToVisibilityElementLocated(sizeMLocator);
        sizeFilterM = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(2)"));
        boolean retry = true;
        while(retry){
            try{
                sizeFilterM.click();
                break;
            } catch (StaleElementReferenceException e){
                System.out.println("exception!");
            }
        }
    }

    public void selectSizeLFilter(){
        WebElement sizeFilterL = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(3)"));
        waitToVisibilityElementLocated(sizeLLocator);
        sizeFilterL = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(3)"));
        //sizeFilterL.click();
    }

    public void selectSizeXlFilter(){
        WebElement sizeFilterXL = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(4)"));
        waitToVisibilityElementLocated(sizeXLLocator);
        sizeFilterXL = driver.findElement(By.cssSelector("#search_filters>.clearfix:nth-of-type(2)>.collapse>li:nth-of-type(4)"));
        //sizeFilterXL.click();
    }
}
