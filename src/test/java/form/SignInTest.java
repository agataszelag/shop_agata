package form;

import base.BaseTest;
import models.SocialTitle;
import org.testng.annotations.BeforeMethod;
import pages.form.RegistrationPage;
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
    private static final String SUCCESS_VALIDATION_MESSAGE = "Wypełnij to pole.";

    @BeforeMethod
    public void beforeMethod() {
        this.menuPage = new MenuPage(driver);
        this.signInPage = new SignInPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.fields = new Fields(driver);
    }

    @Test
    public void shouldSignInNewUser() {
        //given
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

        //when
        fields.setRandomAddressEmail(signInPage.setRandomAddressEmail());
        fields.setRandomPassword(signInPage.setRandomPassword());
        signInPage.clickSignInButton();

        //then
        Assert.assertEquals((signInPage.getRandomName() + " " + signInPage.getRandomLastName()), menuPage.getAccountName());
    }

    @Test
    public void showValidationPopUpForEmail() {
        //given
        menuPage.goToSignIn();
        //when

        signInPage.clickSignInButton();

        //then
        Assert.assertEquals(fields.getValidationMessageFromAddressEmail(), SUCCESS_VALIDATION_MESSAGE);
    }
}
