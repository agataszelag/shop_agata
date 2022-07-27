package form;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import pages.SignInPage;
import pages.common.Fields;
import pages.common.MenuPage;
import models.SocialTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.form.RegistrationPage;

import java.time.LocalDate;

public class RegistrationTest extends BaseTest {

    private MenuPage menuPage;
    private RegistrationPage registrationPage;
    private Fields fields;
    private SignInPage signInPage;
    private static final String FIRST_NAME_VALIDATION_MESSAGE = "Wypełnij to pole.";
    private static final String LAST_NAME_VALIDATION_MESSAGE = "Wypełnij to pole.";
    private static final String DATA_PRIVACY_VALIDATION_MESSAGE = "Zaznacz to pole, jeśli chcesz kontynuować.";
    private static final String LOG_IN_PAGE_HEADER = "Log in to your account";
    private static final String NEW_USER = "Wiolka Nazwiskowa";


    @BeforeMethod
    public void beforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.fields = new Fields(driver);
        this.signInPage = new SignInPage(driver);
        driver.get("http://146.59.32.4/index.php?controller=authentication&create_account=1");
    }

    @Test
    public void shouldRegisterNewUser() {
        //given
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

        //when
        registrationPage.clickSaveButton();

        //then
        Assert.assertEquals(menuPage.getAccountName(), NEW_USER);
    }

    @Test
    public void showValidationPopUpForFirstName() {
        //given & when
        registrationPage.clickSaveButton();

        //then
        Assert.assertEquals(registrationPage.getValidationMessageForFirstName(), FIRST_NAME_VALIDATION_MESSAGE);
    }

    @Test
    public void showValidationPopUpForLastName(){
        //given
        registrationPage.setFirstName(BasePage.getRandomChar());

        //when
        registrationPage.clickSaveButton();

        //then
        Assert.assertEquals(registrationPage.getValidationMessageForLastName(), LAST_NAME_VALIDATION_MESSAGE);
    }

    @Test
    public void showValidationPopUpForCustomerDataPrivacy(){
        //given
        registrationPage.selectSocialTitle(SocialTitle.MRS);
        registrationPage.setFirstName(BasePage.getRandomChar());
        registrationPage.setLastName(BasePage.getRandomChar());
        fields.setRandomAddressEmail();
        fields.setRandomPassword();
        registrationPage.setBirthdayDate(LocalDate.of(1997, 05, 25));

        //when
        registrationPage.clickSaveButton();

        //then
        Assert.assertEquals(registrationPage.getValidationMessageForCustomerDataPrivacy(), DATA_PRIVACY_VALIDATION_MESSAGE);
    }

    @Test
    public void goToLogInPage(){
        //given & when
        registrationPage.clickLogInInsteadButton();

        //then
        Assert.assertEquals(signInPage.getSignUpPageHeader(), LOG_IN_PAGE_HEADER);
    }
}

