package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarouselSlider extends BasePage{
    public CarouselSlider(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".text-uppercase")
    private WebElement textUppercase;

    public String getTextUppercase(){
        return textUppercase.getText();
    }

}
