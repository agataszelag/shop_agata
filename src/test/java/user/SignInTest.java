package user;

import base.BaseTest;
import models.SocialTitle;
import pages.RegistrationPage;
import pages.common.Fields;
import pages.common.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

import java.time.LocalDate;

public class SignInTest extends BaseTest {

    @Test
    public void goToSignInPage(){
        MenuPage menuPage = new MenuPage(driver);
        SignInPage signInPage = new SignInPage(driver);

        menuPage.goToSignIn();

        Assert.assertEquals("Log in to your account", signInPage.getSignUpPageHeader());
    }

    @Test
    public void shouldSignInNewUser(){
        SignInPage signInPage = new SignInPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Fields fields = new Fields(driver);

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

        Assert.assertEquals((signInPage.getRandomName()+ " " + signInPage.getRandomLastName()), menuPage.getAccountName());
    }

    @Test
    public void showValidationPopUpForEmail(){
        MenuPage menuPage = new MenuPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        Fields fields = new Fields(driver);

        menuPage.goToSignIn();
        signInPage.clickSignInButton();

        Assert.assertEquals(fields.getValidationMessageFromAddressEmail(), "Wypełnij to pole.");
    }

}
