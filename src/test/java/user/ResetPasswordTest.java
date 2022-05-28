package user;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ResetPasswordPage;
import pages.SignInPage;
import pages.common.Fields;
import pages.common.MenuPage;

public class ResetPasswordTest extends BaseTest {

    @Test
    public void goToResetPasswordPage(){
        MenuPage menuPage = new MenuPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);

        menuPage.goToSignIn();
        signInPage.clickForgotPasswordButton();

        Assert.assertEquals(resetPasswordPage.showResetPasswordPageHeader(), "Forgot your password?");
    }

    @Test
    public void shouldResetPassword(){
        MenuPage menuPage = new MenuPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        Fields fields = new Fields(driver);
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);

        menuPage.goToSignIn();
        signInPage.clickForgotPasswordButton();
        fields.setRandomAddressEmail(signInPage.setRandomAddressEmail());
        resetPasswordPage.clickSendResetLinkButton();

        Assert.assertEquals(resetPasswordPage.showAlertSuccess(), "If this email address has been registered in our shop," +
                " you will receive a link to reset your password at " + signInPage.setRandomAddressEmail()+ ".");
    }
}
