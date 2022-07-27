package menu;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarouselSlider;
import pages.form.ContactUsPage;
import pages.SearchResultPage;
import pages.SignInPage;
import pages.common.Fields;
import pages.common.MenuPage;

public class MainMenuTest extends BaseTest {
    private MenuPage menuPage;
    private Fields fields;
    private ContactUsPage contactUsPage;
    private SignInPage signInPage;
    private SearchResultPage searchResultPage;
    private CarouselSlider carouselSlider;
    private static final String CLOTHES_MAIN_CATEGORY_TITLE = "CLOTHES";
    private static final String ACCESSORIES_MAIN_CATEGORY_TITLE = "ACCESSORIES";
    private static final String ART_MAIN_CATEGORY_TITLE = "ART";
    private static final String CONTACT_US_PAGE_TITLE = "STORE INFORMATION";
    private static final String SIGN_UP_PAGE_TITLE = "Log in to your account";
    private static final String PAGE_RESULTS_TITLE = "SEARCH RESULTS";
    private static final String TEXT_IN_THE_FIRST_SLIDER = "SAMPLE 1";

    @BeforeMethod
    public void beforeMethod(){
        this.menuPage = new MenuPage(driver);
        this.fields = new Fields(driver);
        this.contactUsPage = new ContactUsPage(driver);
        this.signInPage = new SignInPage(driver);
        this.searchResultPage = new SearchResultPage(driver);
        this.carouselSlider = new CarouselSlider(driver);
    }

    @Test
    public void goToClothesSubcategory(){
        // given & when
        menuPage.clickClothesCategory();

        // then
        Assert.assertEquals(fields.getCardBlockCategory(), CLOTHES_MAIN_CATEGORY_TITLE);
    }

    @Test
    public void goToAccessoriesSubcategory(){
        // given & when
        menuPage.clickAccessoriesCategory();

        // then
        Assert.assertEquals(fields.getCardBlockCategory(), ACCESSORIES_MAIN_CATEGORY_TITLE);
    }

    @Test
    public void goToArtSubcategory(){
        // given & when
        menuPage.clickArtCategory();

        // then
        Assert.assertEquals(fields.getCardBlockCategory(), ART_MAIN_CATEGORY_TITLE);
    }

    @Test
    public void goToContactUsPage() {
        // given & when
        this.menuPage.goToContactUs();

        //then
        Assert.assertEquals(contactUsPage.getContactUsPageHeader(), CONTACT_US_PAGE_TITLE);
    }

    @Test
    public void goToSignInPage() {
        // given & when
        menuPage.goToSignIn();

        //then
        Assert.assertEquals(signInPage.getSignUpPageHeader(), SIGN_UP_PAGE_TITLE);
    }

    @Test
    public void goToSearchResultsPage(){
        // given & when
        menuPage.clickSearchIcon();

        //then
        Assert.assertEquals(searchResultPage.getSearchHeader(), PAGE_RESULTS_TITLE);
    }

    @Test
    public void goToMainPage(){
        // given & when
        menuPage.clickSearchIcon();
        menuPage.clickLogoMyStore();

        //then
        Assert.assertEquals(carouselSlider.getTextUppercase(), TEXT_IN_THE_FIRST_SLIDER);
    }
}
