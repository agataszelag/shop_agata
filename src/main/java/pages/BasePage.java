package pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class BasePage {
    public static final int MAX_WAIT_TIME = 15;
    private static final int MAX_INT_GENERATED =  1000;
    public static final int NUMBER_OF_CHARACTERS = 8;
    public static final int MAX_INT_VALUE = 5;
    public WebDriver driver;
    static Random random = new Random();
    public WebDriverWait wait;


    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_TIME));
    }

    public void click(WebElement element){
        waitToBeClickable(element);
        element.click();
    }

    public static String getRandomEmail(){
        int randomInt = random.nextInt(MAX_INT_GENERATED);
        return "username" + getRandomChar() + randomInt + "@test.pl";
    }

    public static String getRandomChar(){
        return RandomStringUtils.randomAlphabetic(NUMBER_OF_CHARACTERS);
    }

    public static int getRandomIntValue(){
        return random.nextInt(MAX_INT_VALUE);
    }

    public void waitToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sendKeysWithClear(WebElement element){
        element.clear();
    }

}
