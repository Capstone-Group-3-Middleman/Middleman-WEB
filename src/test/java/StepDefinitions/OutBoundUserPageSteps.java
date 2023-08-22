package StepDefinitions;

import app.middleman.PageObjects.LoginUserPage;
import app.middleman.PageObjects.MyProductUserPage;
import app.middleman.PageObjects.OutBoundUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class OutBoundUserPageSteps {

    public OutBoundUserPageSteps(){
        super();
    }
    public WebDriver driver = Hooks.driver;

    MyProductUserPage myProductUserPage = new MyProductUserPage(driver);
    OutBoundUserPage outBoundUserPage = new OutBoundUserPage(driver);
    LoginUserPage loginUserPage = new LoginUserPage(driver);

    @And("User click plus icon")
    public void userClickPlusIcon() {
        myProductUserPage.clickPlusIcon();
    }

    @When("User click outbound menu")
    public void userClickOutboundMenu() {
        outBoundUserPage.clickOutboundMenu();
    }

    @Then("User navigate to the outbound page")
    public void userNavigateToTheOutboundPage() {
        Assert.assertEquals("Outbound Product", outBoundUserPage.getTextOutBoundProd());
    }

    @And("Product that added should be appear")
    public void productThatAddedShouldBeAppear() {
        Assert.assertTrue(outBoundUserPage.verifyOutBoundNotEmpty());
    }

    @Given("User already added product to outbound")
    public void userAlreadyAddedProductToOutbound() throws InterruptedException {
        loginUserPage.clickSignInBtn();
        loginUserPage.setEmail("laundry@laun.com");
        loginUserPage.setPassword("qwerty123");
        loginUserPage.clickLoginButton();
        loginUserPage.alertLoginUser();
        myProductUserPage.clickMyProductMenu();
        myProductUserPage.clickPlusIcon();
        Assert.assertEquals("success creating a cart", myProductUserPage.getAlertMyProductText());
        myProductUserPage.clickAlertMyProduct();
        Thread.sleep(3000);
    }

    @And("User already on the outbound page")
    public void userAlreadyOnTheOutboundPage() {
        loginUserPage.clickSignInBtn();
        loginUserPage.setEmail("laundry@laun.com");
        loginUserPage.setPassword("qwerty123");
        loginUserPage.clickLoginButton();
        loginUserPage.alertLoginUser();
        outBoundUserPage.clickOutboundMenu();
        Assert.assertEquals("Outbound Product", outBoundUserPage.getTextOutBoundProd());
    }

    @When("User click submit button on outbound user")
    public void userClickSubmitButtonOnOutboundUser() {
        outBoundUserPage.clickSubmitBtn();
    }

    @Then("User navigate to the my product user page")
    public void userNavigateToMyProductPage() {
        Assert.assertEquals("My Product", myProductUserPage.getTextMyProduct());
    }

    @When("User click history product out button")
    public void userClickHistoryProductOutButton() {
        outBoundUserPage.clickHistoryProdOutBtn();
    }

    @Then("User navigate to the history product out page")
    public void userNavigateToTheHistoryProductOutPage() {
        Assert.assertEquals("History Product Out", outBoundUserPage.getTextHisOutProd());
    }

    @When("User click detail button")
    public void userClickDetailButton() {
        outBoundUserPage.clickDetailBtn();
    }

    @Then("User navigate to detail product out page")
    public void userNavigateToDetailProductOutPage() {
        Assert.assertEquals("Detail Product Out", outBoundUserPage.getTextDetailProdOut());
    }

    @And("Information about product should be displayed")
    public void informationAboutProductShouldBeDisplayed() {
        Assert.assertTrue(outBoundUserPage.verifyDetailProdOutIsDisplayed());
    }

    @When("User click delete button on the outbound page")
    public void userClickDeleteButtonOnTheOutboundPage() {
        outBoundUserPage.clickDeleteBtn();
    }

    @Then("Alert outbound message will appear {string}")
    public void alertOutboundMessageWillAppear(String message) {
        Assert.assertEquals(message, outBoundUserPage.getAlertText());
    }

    @When("User click ok on alert outbound")
    public void userClickOkOnAlertOutbound() {
        outBoundUserPage.clickAlertOK();
    }

    @Then("Product should be removed")
    public void productShouldBeRemoved() {
        Assert.assertTrue(outBoundUserPage.isProductOutEmpty());
    }
}
