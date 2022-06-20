package user;

import base.BaseTest;
import models.SocialTitle;
import org.testng.annotations.BeforeMethod;
import pages.RegistrationPage;
import pages.common.Fields;
import pages.common.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

import java.time.LocalDate;

public class SignInTest extends BaseTest {
    private MenuPage menuPage;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private Fields fields;

    @BeforeMethod
    public void beforeMethod() {
        this.menuPage = new MenuPage(driver);
        this.signInPage = new SignInPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.fields = new Fields(driver);
    }

    @Test
    public void goToSignInPage() {

        menuPage.goToSignIn();

        Assert.assertEquals("Log in to your account", signInPage.getSignUpPageHeader());
    }

    @Test
    public void shouldSignInNewUser() {

        menuPage.goToSignIn();
        registrationPage.goToRegisterForm();
        registrationPage.selectSocialTitle(SocialTitle.MR);
        registrationPage.setFirstName(signInPage.getRandomName());
        registrationPage.setLastName(signInPage.getRandomLastName());
        fields.setRandomAddressEmail(signInPage.setRandomAddressEmail());
        fields.setRandomPassword(signInPage.setRandomPassword());
        registrationPage.setBirthdayDate(LocalDate.of(1997, 05, 25));
        registrationPage.selectCheckboxReceiveOffersFromOurPartners();
        registrationPage.selectCustomerPrivacy();
        registrationPage.selectSignUpForOurNewsletter();
        registrationPage.selectPrivatePolicy();
        registrationPage.clickSaveButton();
        menuPage.clickSignOutButton();
        menuPage.goToSignIn();
        fields.setRandomAddressEmail(signInPage.setRandomAddressEmail());
        fields.setRandomPassword(signInPage.setRandomPassword());
        signInPage.clickSignInButton();

        Assert.assertEquals((signInPage.getRandomName() + " " + signInPage.getRandomLastName()), menuPage.getAccountName());
    }

    @Test
    public void showValidationPopUpForEmail() {

        menuPage.goToSignIn();
        signInPage.clickSignInButton();

        Assert.assertEquals(fields.getValidationMessageFromAddressEmail(), "Wypełnij to pole.");
    }

}
