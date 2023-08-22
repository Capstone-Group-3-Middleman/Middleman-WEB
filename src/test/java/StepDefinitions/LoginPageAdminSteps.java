package StepDefinitions;

import app.middleman.PageObjects.LoginPageAdmin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageAdminSteps {

    public LoginPageAdminSteps(){
        super();
    }

    public WebDriver webDriver = Hooks.driver;

    LoginPageAdmin loginPage = new LoginPageAdmin(webDriver);

    @Given("Admin already on the login page")
    public void adminAlreadyOnTheLoginPage() {
        Assert.assertEquals("SIGN IN", loginPage.getSignInText());
    }

    @And("Admin click sign in button")
    public void adminClickSignInButton() {;
        loginPage.clickSignInBtn();
    }

    @When("Admin input email {string} and password {string}")
    public void adminInputEmailAndPassword(String emil, String pssword) throws InterruptedException {
        Thread.sleep(500);
        loginPage.setLoginButton(emil, pssword);
    }

    @And("Admin Click sign in button")
    public void clickSignInButton() {
        loginPage.clickLoginButton();
    }

    @And("Admin Click alert login")
    public void clickAlertLogin() {
        loginPage.alertSuccessLogin();
    }

    @Then("Admin already on the my product page")
    public void adminAlreadyOnTheMyProductPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("My Product", loginPage.getMyProductText());
    }

    @Then("Admin see error alert {string}")
    public void adminSeeErrorAlert(String errorMsg) throws InterruptedException {
        Assert.assertEquals(""+errorMsg+"", loginPage.textErrorAlert());
        loginPage.textErrorAlert();
        Thread.sleep(2000);
    }
}
