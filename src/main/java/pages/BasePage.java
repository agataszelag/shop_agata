package pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class BasePage {

    public WebDriver driver;
    static Random random = new Random();
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void click(WebElement element){
       // waitToBeClickable(element);
        element.click();
    }

    public static String getRandomEmail(){
        int randomInt = random.nextInt(1000);
        return "username" + getRandomChar() + randomInt + "@test.pl";
    }

    public static String getRandomChar(){
        return RandomStringUtils.randomAlphabetic(8);
    }

    public void waitToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
