package StepDefinitions;

import app.middleman.PageObjects.MyCartUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class MyCartUserPageSteps {

    public MyCartUserPageSteps(){
        super();
    }

    public WebDriver driver = Hooks.driver;

    MyCartUserPage myCartUserPage = new MyCartUserPage(driver);

    @When("User click add button on product dashboard")
    public void userClickAddButtonOnProductDashboard() {
        myCartUserPage.clickAddBtn();
    }

    @Then("Alert my cart message will appear {string}")
    public void alertMyCartMessageWillAppear(String message) {
        Assert.assertEquals(message, myCartUserPage.getAlertText());
    }

    @When("User click ok on alert my cart")
    public void userClickOkOnAlertMyCart() {
        myCartUserPage.clickAlertOK();
    }

    @And("User click my cart menu")
    public void userClickMyCart() {
        myCartUserPage.clickMyCartMenu();
    }

    @Then("User navigate to my cart page")
    public void userNavigateToMyCartPage() {
        Assert.assertEquals("Add your cart", myCartUserPage.getAddToCartText());
    }

    @And("Product that adding should be appear")
    public void productThatAddingShouldBeAppear() {
       Assert.assertTrue(myCartUserPage.verifyIsCartEmpty());
    }
}
