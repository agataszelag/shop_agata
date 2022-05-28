package user;

import base.BaseTest;
import models.Subject;
import pages.BasePage;
import pages.common.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    @Test
    public void goToContactUsPage(){
        MenuPage menuPage = new MenuPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        menuPage.goToContactUs();

        Assert.assertEquals("STORE INFORMATION", contactUsPage.getContactUsPageHeader());
    }

    @Test
    public void shouldSendContactForm(){
        MenuPage menuPage = new MenuPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        menuPage.goToContactUs();
        contactUsPage.selectSubject(Subject.CUSTOMER_SERVICE);
        contactUsPage.setRandomAddressEmail();
        contactUsPage.setMessage(BasePage.getRandomChar());
        contactUsPage.clickSendButton();

        Assert.assertEquals(contactUsPage.getAlertSuccess(), "Your message has been successfully sent to our team.");
    }

    @Test
    public void showValidationInformationInvalidMessage(){
        MenuPage menuPage = new MenuPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        menuPage.goToContactUs();
        contactUsPage.clickSendButton();

        Assert.assertEquals(contactUsPage.showAlertInvalidAddressEmail(), "Invalid email address.");
    }

    @Test
    public void showValidationInformationMessageCannotBeBlank(){
        MenuPage menuPage = new MenuPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        menuPage.goToContactUs();
        contactUsPage.setRandomAddressEmail();
        contactUsPage.clickSendButton();

        Assert.assertEquals(contactUsPage.showAlertMessageCannotBeBlank(), "The message cannot be blank.");
    }

    @Test
    public void showPlaceholderEmailField(){
        MenuPage menuPage = new MenuPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        menuPage.goToContactUs();

        Assert.assertTrue(contactUsPage.showPlaceholderEmailField());
    }

    @Test
    public void showPlaceholderMessageBox(){
        MenuPage menuPage = new MenuPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        menuPage.goToContactUs();

        Assert.assertTrue(contactUsPage.showPlaceholderMessageBox());
    }
}
