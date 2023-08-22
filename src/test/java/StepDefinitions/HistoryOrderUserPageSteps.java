package StepDefinitions;

import app.middleman.PageObjects.HistoryOrderUserPage;
import app.middleman.PageObjects.MyCartUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HistoryOrderUserPageSteps {

    public HistoryOrderUserPageSteps(){
        super();
    }

    public WebDriver driver = Hooks.driver;

    MyCartUserPage myCartUserPage = new MyCartUserPage(driver);
    HistoryOrderUserPage historyOrderUserPage = new HistoryOrderUserPage(driver);


    @And("User already order a product")
    public void userAlreadyOrderAProduct() throws InterruptedException {
        myCartUserPage.clickAddBtn();
        myCartUserPage.clickAlertOK();
        myCartUserPage.clickMyCartMenu();
        Assert.assertTrue(myCartUserPage.verifyIsCartEmpty());
    }

    @When("User click history order menu")
    public void userClickHistoryOrderMenu() {
        historyOrderUserPage.clickHistoryOrderMenu();
    }

    @Then("User navigate to the history order page")
    public void userNavigateToTheHistoryOrderPage() {
        Assert.assertEquals("History Order Product", historyOrderUserPage.getTextHistoryOrderProd());
    }

    @And("Product that ordered should be display")
    public void productThatOrderedShouldBeDisplay() {
        Assert.assertTrue(historyOrderUserPage.verifyProdCardIsDisplayed());
    }

    @When("User click detail button on history order page")
    public void userClickDetailButtonOnHistoryOrderPage() {
        historyOrderUserPage.clickDetailBtn();
    }

    @Then("Order information user should be displayed")
    public void orderInformationUserShouldBeDisplayed() {
        Assert.assertTrue(historyOrderUserPage.verifyOrderDetailIsDisplay());
    }
}
