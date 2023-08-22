package StepDefinitions;

import app.middleman.PageObjects.RegisterUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterUserPageSteps {

    public RegisterUserPageSteps(){
        super();
    }

    public WebDriver driver = Hooks.driver;

    RegisterUserPage registerUserPage = new RegisterUserPage(driver);
    
    @When("User click sign up button")
    public void userClickSignUpButton() {
        registerUserPage.clickSignUpBtn();
    }

    @Then("User already on the register page")
    public void userAlreadyOnTheRegisterPage() {
        Assert.assertEquals("Create a new account", registerUserPage.getRegisterText());
    }

    @When("User input shop name {string}")
    public void userInputShopName(String shopName) {
        registerUserPage.setShopName(shopName);
    }

    @And("User input email {string}")
    public void userInputEmail(String email) {
        registerUserPage.setEmail(email);
    }

    @And("User input phone number {string}")
    public void userInputPhoneNumber(String phone) {
        registerUserPage.setPhone(phone);
    }

    @And("User input password {string}")
    public void userInputPassword(String password) {
        registerUserPage.setPassword(password);
    }

    @And("User input address {string}")
    public void userInputAddress(String address) {
        registerUserPage.setAddress(address);
    }

    @And("User click register button")
    public void userClickRegisterButton() {
        registerUserPage.clickSignUpBtn();
    }

    @Then("Alert register user message will appear {string}")
    public void alertRegisterUserMessageWillAppear(String message) {
        Assert.assertEquals(message, registerUserPage.getAlertRegisterText());
    }

    @When("User click ok on alert register")
    public void userClickOkOnAlertRegister() {
        registerUserPage.alertRegisterOK();
    }

    @Then("User navigate to the login page")
    public void userNavigateToTheLoginPage() {
        Assert.assertEquals("Welcome!", registerUserPage.getWelcomeText());
    }



}
