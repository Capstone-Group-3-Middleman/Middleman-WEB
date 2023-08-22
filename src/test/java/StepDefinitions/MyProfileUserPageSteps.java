package StepDefinitions;

import app.middleman.PageObjects.LoginUserPage;
import app.middleman.PageObjects.MyProfileUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyProfileUserPageSteps {
    public MyProfileUserPageSteps(){
        super();
    }
    public WebDriver driver = Hooks.driver;

    MyProfileUserPage myProfileUserPage = new MyProfileUserPage(driver);
    LoginUserPage loginUserPage = new LoginUserPage(driver);

    @When("User click account icon")
    public void userClickAccountIcon() {
        myProfileUserPage.clickAccountIcon();
    }

    @And("User click my profile menu")
    public void userClickMyProfileMenu() {
        myProfileUserPage.clickMyProfileMenu();
    }

    @Then("User navigate to my profile page")
    public void userNavigateToMyProfilePage() {
        Assert.assertEquals("My Profile", myProfileUserPage.getTextMyProfile());
    }

    @And("User email {string} is displayed")
    public void userEmailIsDisplayed(String email) {
        Assert.assertEquals(email, myProfileUserPage.getTextEmail(email));
    }

    @And("User phone number {string} is displayed")
    public void userPhoneNumberIsDisplayed(String phoneNumber) {
        Assert.assertEquals(phoneNumber, myProfileUserPage.getTextPhoneNumber(phoneNumber));
    }

    @Given("User already on the my profile page")
    public void userAlreadyOnTheMyProfilePage() {
        loginUserPage.clickSignInBtn();
        loginUserPage.setEmail("laundry@laun.com");
        loginUserPage.setPassword("qwerty123");
        loginUserPage.clickLoginButton();
        loginUserPage.alertLoginUser();
        myProfileUserPage.clickAccountIcon();
        myProfileUserPage.clickMyProfileMenu();
        Assert.assertEquals("My Profile", myProfileUserPage.getTextMyProfile());
    }

    @When("User click edit button on my profile page")
    public void userClickEditButtonOnMyProfilePage() {
        myProfileUserPage.clickEditBtn();
    }

    @And("User input shop name as {string}")
    public void userInputShopNameAs(String shopName) {
        myProfileUserPage.setShopNameProfile(shopName);
    }

    @And("User input email as {string}")
    public void userInputEmailAs(String email) {
        myProfileUserPage.setEmailProfile(email);
    }

    @And("User input phone number as {string}")
    public void userInputPhoneNumberAs(String phoneNum) {
        myProfileUserPage.setPhoneNumberProfile(phoneNum);
    }

    @And("User input address as {string}")
    public void userInputAddressAs(String address) {
        myProfileUserPage.setAddressProfile(address);
    }

    @And("User click edit button on modal profile")
    public void userClickEditButtonOnModalProfile() {
        myProfileUserPage.clickEditBtnModal();
    }

    @Then("Alert my profile message will appear {string}")
    public void alertMyProfileMessageWillAppear(String message) {
        Assert.assertEquals(message, myProfileUserPage.getAlertText());
    }

    @When("User click ok on alert my profile")
    public void userClickOkOnAlertMyProfile() {
        myProfileUserPage.clickAlertOK();
    }

    @Then("Data should be updated")
    public void dataShouldBeUpdated() {
        Assert.assertEquals("081122233345", myProfileUserPage.getTextPhoneNumber("081122233345"));
    }

    @When("User click delete button on my profile page")
    public void userClickDeleteButtonOnMyProfilePage() {
        myProfileUserPage.clickDeleteBtn();
    }

    @And("User click yes button on my profile page")
    public void userClickYesButtonOnMyProfilePage() {
        myProfileUserPage.clickYesBtn();
    }

    @Then("User navigate to website middleman-immersive.vercel.app")
    public void userNavigateToWebsiteMiddlemanImmersiveVercelApp() {
        Assert.assertEquals("SIGN IN", loginUserPage.getSignInText());
    }

    @And("User click logout button")
    public void userClickLogoutButton() {
        myProfileUserPage.clickLogoutBtn();
    }

    @And("User click yes logout")
    public void userClickYesLogout() {
        myProfileUserPage.clickYesLogoutBtn();
    }
}
