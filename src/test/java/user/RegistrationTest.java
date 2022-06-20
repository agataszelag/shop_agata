package user;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import pages.SignInPage;
import pages.common.Fields;
import pages.common.MenuPage;
import models.SocialTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;

import java.time.LocalDate;

public class RegistrationTest extends BaseTest {

    private MenuPage menuPage;
    private RegistrationPage registrationPage;
    private Fields fields;
    private SignInPage signInPage;


    @BeforeMethod
    public void beforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.fields = new Fields(driver);
        this.signInPage = new SignInPage(driver);
    }


    @Test
    public void goToAnRegistrationForm() {

        menuPage.goToSignIn();
        registrationPage.goToRegisterForm();

        Assert.assertEquals(registrationPage.getAccountPageHeader(), "Create an account");
    }

    @Test
    public void shouldRegisterNewUser() {

        menuPage.goToSignIn();
        registrationPage.goToRegisterForm();
        registrationPage.selectSocialTitle(SocialTitle.MR);
        registrationPage.setFirstName("Wiolka");
        registrationPage.setLastName("Nazwiskowa");
        fields.setRandomAddressEmail();
        fields.setRandomPassword();
        registrationPage.setBirthdayDate(LocalDate.of(1997, 05, 25));
        registrationPage.selectCheckboxReceiveOffersFromOurPartners();
        registrationPage.selectCustomerPrivacy();
        registrationPage.selectSignUpForOurNewsletter();
        registrationPage.selectPrivatePolicy();
        registrationPage.clickSaveButton();

        Assert.assertEquals(menuPage.getAccountName(), "Wiolka Nazwiskowa");
    }

    @Test
    public void showValidationPopUpForFirstName() {

        menuPage.goToSignIn();
        registrationPage.goToRegisterForm();
        registrationPage.clickSaveButton();
        registrationPage.getValidationMessageForFirstName();

        Assert.assertEquals(registrationPage.getValidationMessageForFirstName(), "Wypełnij to pole.");
    }

    @Test
    public void showValidationPopUpForLastName(){

        menuPage.goToSignIn();
        registrationPage.goToRegisterForm();
        registrationPage.setFirstName(BasePage.getRandomChar());
        registrationPage.clickSaveButton();

        Assert.assertEquals(registrationPage.getValidationMessageForLastName(), "Wypełnij to pole.");
    }

    @Test
    public void showValidationPopUpForCustomerDataPrivacy(){

        menuPage.goToSignIn();
        registrationPage.goToRegisterForm();
        registrationPage.selectSocialTitle(SocialTitle.MRS);
        registrationPage.setFirstName(BasePage.getRandomChar());
        registrationPage.setLastName(BasePage.getRandomChar());
        fields.setRandomAddressEmail();
        fields.setRandomPassword();
        registrationPage.setBirthdayDate(LocalDate.of(1997, 05, 25));
        registrationPage.clickSaveButton();

        Assert.assertEquals(registrationPage.getValidationMessageForCustomerDataPrivacy(), "Zaznacz to pole, jeśli chcesz kontynuować.");
    }

    @Test
    public void shouldComeBackToLogIn(){

        menuPage.goToSignIn();
        registrationPage.goToRegisterForm();
        registrationPage.clickLogInInsteadButton();

        Assert.assertEquals(signInPage.getSignUpPageHeader(), "Log in to your account");
    }
}

