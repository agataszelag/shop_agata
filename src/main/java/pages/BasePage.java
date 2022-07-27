package pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.WindowAdapter;
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

    //private String locator;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_TIME));
    }

    public void click(WebElement element){
        waitToBeClickable(element);
        element.click();
    }

    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException");
            }
            attempts++;
        }
        return result;
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
    public void waitToAttributeContainsValue(WebElement element, String attribute, String value){
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }
    public void sendKeysWithClear(WebElement element){
        element.clear();
    }

    public void waitToVisibilityElementLocated(String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }
}
