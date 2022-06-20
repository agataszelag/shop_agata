package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(css = "#_desktop_user_info>.user-info")
    private WebElement signInButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(css = ".account")
    private WebElement accountName;

    @FindBy(className = "logout")
    private WebElement signOutButton;

    @FindBy(className = "cart-products-count")
    private WebElement amountOfProduct;

    @FindBy(css = "a[href*='category=3']")
    private WebElement clothesMainCategory;

    @FindBy(css = "a[href*='category=6']")
    private WebElement accessoriesMainCategory;

    @FindBy(css = "a[href*='category=9']")
    private WebElement artMainCategory;

    @FindBy(css = "a[href*='category=4']")
    private WebElement menSubcategory;

    @FindBy(css = "a[href*='category=5']")
    private WebElement womenSubcategory;

    @FindBy(css = "a[href*='category=7']")
    private WebElement stationerySubcategory;

    @FindBy(css = "a[href*='category=8']")
    private WebElement homeAccessoriesSubcategory;

    public void goToSignIn() {
        click(signInButton);
    }

    public void goToContactUs() {
        click(contactUsButton);
    }

    public String getAccountName() {
        return accountName.getText();
    }

    public void clickSignOutButton() {
        click(signOutButton);
    }

    public String getAmountOfProduct() {
        return amountOfProduct.getText();
    }

    public void clickCartButton(){
        click(amountOfProduct);
    }

    public void clickClothesCategory(){
        click(clothesMainCategory);
    }

    public void clickAccessoriesCategory(){
        click(accessoriesMainCategory);
    }

    public void clickArtCategory(){
        click(artMainCategory);
    }

    public void clickMenSubcategory(){
        actions.moveToElement(clothesMainCategory).build().perform();
        click(menSubcategory);
    }

    public void clickWomenSubcategory(){
        actions.moveToElement(clothesMainCategory).build().perform();
        click(womenSubcategory);
    }

    public void clickStationerySubcategory(){
        actions.moveToElement(accessoriesMainCategory).build().perform();
        click(stationerySubcategory);
    }

    public void clickHomeAccessoriesSubcategory(){
        actions.moveToElement(accessoriesMainCategory).build().perform();
        click(homeAccessoriesSubcategory);
    }

}
