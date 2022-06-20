package user;

import base.BaseTest;
import models.Subject;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.common.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {
    private MenuPage menuPage;
    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void beforeMethod() {
        this.menuPage = new MenuPage(driver);
        this.contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void goToContactUsPage() {
        this.menuPage.goToContactUs();

        Assert.assertEquals("STORE INFORMATION", contactUsPage.getContactUsPageHeader());
    }

    @Test
    public void shouldSendContactForm() {

        this.menuPage.goToContactUs();
        this.contactUsPage.selectSubject(Subject.CUSTOMER_SERVICE);
        this.contactUsPage.setRandomAddressEmail();
        this.contactUsPage.setMessage(BasePage.getRandomChar());
        this.contactUsPage.clickSendButton();

        Assert.assertEquals(contactUsPage.getAlertSuccess(), "Your message has been successfully sent to our team.");
    }

    @Test
    public void showValidationInformationInvalidMessage() {

        this.menuPage.goToContactUs();
        this.contactUsPage.clickSendButton();

        Assert.assertEquals(contactUsPage.showAlertInvalidAddressEmail(), "Invalid email address.");
    }

    @Test
    public void showValidationInformationMessageCannotBeBlank() {

        this.menuPage.goToContactUs();
        this.contactUsPage.setRandomAddressEmail();
        this.contactUsPage.clickSendButton();

        Assert.assertEquals(contactUsPage.showAlertMessageCannotBeBlank(), "The message cannot be blank.");
    }

    @Test
    public void showPlaceholderEmailField() {

        this.menuPage.goToContactUs();

        Assert.assertTrue(contactUsPage.showPlaceholderEmailField());
    }

    @Test
    public void showPlaceholderMessageBox() {

        this.menuPage.goToContactUs();

        Assert.assertTrue(contactUsPage.showPlaceholderMessageBox());
    }
}
