package user;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewsletterForm;
import pages.common.Fields;

public class NewsletterTest extends BaseTest {

    @Test
    public void shouldSingInNewsletter(){
        NewsletterForm newsletterForm = new NewsletterForm(driver);
        Fields fields = new Fields(driver);

        fields.setRandomAddressEmail();
        newsletterForm.clickSubscribeButton();

        Assert.assertEquals(newsletterForm.showSucceedAlertAfterSendForm(),"You have successfully subscribed to this newsletter.");
    }

    @Test
    public void showValidationPopUp(){
        NewsletterForm newsletterForm = new NewsletterForm(driver);
        Fields fields = new Fields(driver);

        newsletterForm.clickSubscribeButton();

        Assert.assertEquals(fields.getValidationMessageFromAddressEmail(), "Wypełnij to pole." );
    }

    @Test
    public void showNewsletterPlaceholder(){
        NewsletterForm newsletterForm = new NewsletterForm(driver);
        Assert.assertTrue(newsletterForm.placeholderIsDisplayed());
    }

    @Test
    public void newsletterIsVisibleOfMainPage(){
        NewsletterForm newsletterForm = new NewsletterForm(driver);
        Assert.assertTrue(newsletterForm.getNewsletterLabelInformation());
    }
}

