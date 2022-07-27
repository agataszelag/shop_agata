package form;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.form.NewsletterForm;
import pages.common.Fields;


public class NewsletterTest extends BaseTest {
    private NewsletterForm newsletterForm;
    private Fields fields;
    private static final String SEND_NEWSLETTER_SUCCESS_ALERT = "You have successfully subscribed to this newsletter.";
    private static final String EMAIL_VALIDATION_MESSAGE = "Wypełnij to pole.";

    @BeforeMethod
    public void beforeMethod() {
        this.newsletterForm = new NewsletterForm(driver);
        this.fields = new Fields(driver);
    }

    @Test
    public void shouldSingInNewsletter() {
        //given
        fields.setRandomAddressEmail();

        //when
        newsletterForm.clickSubscribeButton();

        //then
        Assert.assertEquals(newsletterForm.showSucceedAlertAfterSendForm(), SEND_NEWSLETTER_SUCCESS_ALERT);
    }

    @Test
    public void showValidationPopUp() {
        //given & when
        newsletterForm.clickSubscribeButton();

        //then
        Assert.assertEquals(fields.getValidationMessageFromAddressEmail(), EMAIL_VALIDATION_MESSAGE);
    }

    @Test
    public void showNewsletterPlaceholder() {
        //given & when & then
        Assert.assertTrue(newsletterForm.placeholderIsDisplayed());
    }

    @Test
    public void newsletterIsVisibleOfMainPage() {
        //given & when & then
        Assert.assertTrue(newsletterForm.getNewsletterLabelInformation());
    }
}

