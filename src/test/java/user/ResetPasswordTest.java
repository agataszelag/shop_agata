package user;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ResetPasswordPage;
import pages.SignInPage;
import pages.common.Fields;
import pages.common.MenuPage;

public class ResetPasswordTest extends BaseTest {
    private MenuPage menuPage;
    private SignInPage signInPage;
    private ResetPasswordPage resetPasswordPage;
    private Fields fields;


    @BeforeMethod
    public void beforeMethod() {
        this.menuPage = new MenuPage(driver);
        this.signInPage = new SignInPage(driver);
        this.resetPasswordPage = new ResetPasswordPage(driver);
        this.fields = new Fields(driver);
    }

    @Test
    public void goToResetPasswordPage() {

        menuPage.goToSignIn();
        signInPage.clickForgotPasswordButton();

        Assert.assertEquals(resetPasswordPage.showResetPasswordPageHeader(), "Forgot your password?");
    }

    @Test
    public void shouldResetPassword() {

        menuPage.goToSignIn();
        signInPage.clickForgotPasswordButton();
        fields.setRandomAddressEmail(signInPage.setRandomAddressEmail());
        resetPasswordPage.clickSendResetLinkButton();

        Assert.assertEquals(resetPasswordPage.showAlertSuccess(), "If this email address has been registered in our shop," +
                " you will receive a link to reset your password at " + signInPage.setRandomAddressEmail() + ".");
    }
}
