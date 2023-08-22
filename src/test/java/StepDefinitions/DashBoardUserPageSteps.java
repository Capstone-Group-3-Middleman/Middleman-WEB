package StepDefinitions;

import app.middleman.PageObjects.DashBoardUserPage;
import app.middleman.PageObjects.LoginUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DashBoardUserPageSteps {

    public DashBoardUserPageSteps(){
        super();
    }
    public WebDriver driver = Hooks.driver;

    LoginUserPage loginUserPage = new LoginUserPage(driver);
    DashBoardUserPage dashBoardUserPage = new DashBoardUserPage(driver);

    @Given("User login with valid email and password")
    public void userLoginWithValidEmailAndPassword() {
        loginUserPage.clickSignInBtn();
        loginUserPage.setEmail("laundry@laun.com");
        loginUserPage.setPassword("qwerty123");
    }

    @And("Product in the dashboard page will appear")
    public void productInTheDashboardPageWillAppear() {
        Assert.assertTrue(dashBoardUserPage.productIsDisplay());
    }

    @Given("User already on the dashboard page")
    public void userAlreadyOnTheDashboardPage() {
        loginUserPage.clickSignInBtn();
        loginUserPage.setEmail("laundry@laun.com");
        loginUserPage.setPassword("qwerty123");
        loginUserPage.clickLoginButton();
        loginUserPage.alertLoginUser();
        Assert.assertEquals("Dashboard", loginUserPage.getDashboardText());
    }

    @When("User input a keyword {string} on the search field")
    public void userInputAKeywordOnTheSearchField(String prodName) {
        dashBoardUserPage.setSearchProduct(prodName);
    }

    @And("User click search icon")
    public void userClickSearchIcon() {
        dashBoardUserPage.clickSearchIconBtn();
    }

    @Then("Product name {string} will appear based on keyword that be inputted")
    public void productWillAppearBasedOnKeywordThatBeInputted(String prodName) {
        Assert.assertEquals(prodName, dashBoardUserPage.getProductText(prodName));
    }

    @Then("Message will appear {string} on dashboard user")
    public void messageWillAppearOnDashboardUser(String message) {
        Assert.assertEquals(message, dashBoardUserPage.getNotFoundText(message));
    }

    @And("Image in the dashboard page will display")
    public void imageInTheDashboardPageWillDisplay() {
        Assert.assertTrue(dashBoardUserPage.imageIsDisplayed());
    }
}
