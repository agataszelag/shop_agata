package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    private static final String HOST_ADDRESS = "http://146.59.32.4";
    private static final String MAIN_PAGE = "/index.php";

    protected WebDriver driver;
    protected ChromeOptions option;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.option = new ChromeOptions();
        option.addArguments("start-maximized");
    }

    @BeforeMethod
    public void setupMethod() {
        driver = new ChromeDriver(option);
        driver.get(HOST_ADDRESS + MAIN_PAGE);
    }

/*
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
*/

}

