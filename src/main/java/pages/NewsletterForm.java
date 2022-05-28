package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterForm extends BasePage {
    public NewsletterForm(WebDriver driver) {
        super(driver);
    }


    @FindBy(name = "submitNewsletter")
    private WebElement subscribeButton;

    @FindBy(className = "block_newsletter_alert")
    private WebElement succeesAlert;

    @FindBy(css = "input[placeholder='Your email address']")
    private WebElement placeholder;

    @FindBy(id = "block-newsletter-label")
    private WebElement newsletterLabelInformation;


    public void clickSubscribeButton(){
        click(subscribeButton);
    }

    public String showSucceedAlertAfterSendForm(){
        waitToVisibility(succeesAlert);
        return succeesAlert.getText();
    }

    public boolean placeholderIsDisplayed(){
        return placeholder.isDisplayed();
    }

    public boolean getNewsletterLabelInformation(){
        return newsletterLabelInformation.isDisplayed();
    }
}
