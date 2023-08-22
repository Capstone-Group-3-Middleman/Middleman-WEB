package StepDefinitions;

import app.middleman.PageObjects.LoginUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginUserPageSteps {

    public LoginUserPageSteps(){
        super();
    }

    public WebDriver driver = Hooks.driver;

    LoginUserPage loginUserPage = new LoginUserPage(driver);

    @Given("User already on the website")
    public void userAlreadyOnTheLoginPage() {
        Assert.assertEquals("SIGN IN", loginUserPage.getSignInText());
    }

    @And("User click sign in button")
    public void userClickSignInButton() {
        loginUserPage.clickSignInBtn();
    }

    @When("User input email {string} and password {string}")
    public void userInputEmailAndPassword(String email, String password) {
        loginUserPage.setEmail(email);
        loginUserPage.setPassword(password);
    }

    @And("User click login button")
    public void clickLogInButton() {
        loginUserPage.clickLoginButton();
    }

    @And("User click ok on alert login")
    public void clickAlertLogin() {
        loginUserPage.alertLoginUser();
    }

    @Then("User navigate on the dashboard page")
    public void userNavigateOnTheDashboardPage() {
        Assert.assertEquals("Dashboard", loginUserPage.getDashboardText());
    }

    @Then("Alert login message will appear {string}")
    public void alertMessageWillAppear(String errorMessage) {
        Assert.assertEquals(errorMessage, loginUserPage.getAlertText());
    }

}
