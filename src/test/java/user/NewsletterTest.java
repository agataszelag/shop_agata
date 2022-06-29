package user;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewsletterForm;
import pages.common.Fields;


public class NewsletterTest extends BaseTest {
    private NewsletterForm newsletterForm;
    private Fields fields;

    @BeforeMethod
    public void beforeMethod() {
        this.newsletterForm = new NewsletterForm(driver);
        this.fields = new Fields(driver);

    }

    @Test
    public void shouldSingInNewsletter() {

        fields.setRandomAddressEmail();
        newsletterForm.clickSubscribeButton();

        Assert.assertEquals(newsletterForm.showSucceedAlertAfterSendForm(), "You have successfully subscribed to this newsletter.");
    }

    @Test
    public void showValidationPopUp() {

        newsletterForm.clickSubscribeButton();

        Assert.assertEquals(fields.getValidationMessageFromAddressEmail(), "Please fill out this field.");
    }

    @Test
    public void showNewsletterPlaceholder() {
        Assert.assertTrue(newsletterForm.placeholderIsDisplayed());
    }

    @Test
    public void newsletterIsVisibleOfMainPage() {
        Assert.assertTrue(newsletterForm.getNewsletterLabelInformation());
    }
}

