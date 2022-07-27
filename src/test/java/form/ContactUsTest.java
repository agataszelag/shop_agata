package form;

import base.BaseTest;
import models.Subject;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.common.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.form.ContactUsPage;

import java.io.File;

public class ContactUsTest extends BaseTest {
    private MenuPage menuPage;
    private ContactUsPage contactUsPage;
    private static final String ALERT_SUCCESS = "Your message has been successfully sent to our team.";
    private static final String INVALID_ADDRESS_EMAIL_VALIDATION = "Invalid email address.";
    private static final String EMPTY_MESSAGE_VALIDATION = "The message cannot be blank.";

    @BeforeMethod
    public void beforeMethod() {
        this.menuPage = new MenuPage(driver);
        this.contactUsPage = new ContactUsPage(driver);
        driver.get("http://146.59.32.4/index.php?controller=contact");
    }

    @Test
    public void shouldSendContactForm() {
        File file = new File("src/main/resources/file.txt");

        // given
        contactUsPage.selectSubject(Subject.CUSTOMER_SERVICE);
        contactUsPage.setRandomAddressEmail();
        contactUsPage.uploadFile(file);
        contactUsPage.setMessage(BasePage.getRandomChar());

        //when
        contactUsPage.clickSendButton();

        //then
        Assert.assertEquals(contactUsPage.getAlertSuccess(), ALERT_SUCCESS);
    }

    @Test
    public void showValidationInformationInvalidMessage() {
        //given & when
        this.contactUsPage.clickSendButton();

        //then
        Assert.assertEquals(contactUsPage.showAlertInvalidAddressEmail(), INVALID_ADDRESS_EMAIL_VALIDATION);
    }

    @Test
    public void showValidationInformationMessageCannotBeBlank() {
        //given
        this.contactUsPage.setRandomAddressEmail();

        //when
        this.contactUsPage.clickSendButton();

        //then
        Assert.assertEquals(contactUsPage.showAlertMessageCannotBeBlank(), EMPTY_MESSAGE_VALIDATION);
    }

    @Test
    public void showPlaceholderEmailField() {
        //given & when & then
        Assert.assertTrue(contactUsPage.showPlaceholderEmailField());
    }

    @Test
    public void showPlaceholderMessageBox() {
        //given & when & then
        Assert.assertTrue(contactUsPage.showPlaceholderMessageBox());
    }
}
