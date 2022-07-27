package form;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.form.ResetPasswordPage;
import pages.SignInPage;
import pages.common.Fields;
import pages.common.MenuPage;

public class ResetPasswordTest extends BaseTest {
    private MenuPage menuPage;
    private SignInPage signInPage;
    private ResetPasswordPage resetPasswordPage;
    private Fields fields;
    private static final String SUCCESS_VALIDATION_MESSAGE = "If this email address has been registered in our shop, you will receive a link to reset your password at %s.";


    @BeforeMethod
    public void beforeMethod() {
        this.menuPage = new MenuPage(driver);
        this.signInPage = new SignInPage(driver);
        this.resetPasswordPage = new ResetPasswordPage(driver);
        this.fields = new Fields(driver);
        driver.get("http://146.59.32.4/index.php?controller=password");
    }

    @Test
    public void shouldResetPassword() {
        //given
        fields.setRandomAddressEmail(signInPage.setRandomAddressEmail());

        //when
        resetPasswordPage.clickSendResetLinkButton();

        //then
        Assert.assertEquals(resetPasswordPage.showAlertSuccess(), String.format(SUCCESS_VALIDATION_MESSAGE, signInPage.setRandomAddressEmail()));
    }
}
