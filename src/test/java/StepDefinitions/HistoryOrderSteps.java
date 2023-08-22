package StepDefinitions;

import app.middleman.PageObjects.HistoryOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class HistoryOrderSteps {

    public HistoryOrderSteps() {
        super();
    }

    public WebDriver webDriver = Hooks.driver;

    HistoryOrderPage historyOrderPage = new HistoryOrderPage(webDriver);

    @When("already on history order")
    public void alreadyOnHistoryOrder() throws InterruptedException {
        Thread.sleep(2000);
        historyOrderPage.HistoryOrderMenu();
    }

    @And("click detail on history product")
    public void clickDetailOnHistoryProduct() throws InterruptedException {
        Thread.sleep(2000);
        historyOrderPage.DetailHistoryOrder();
    }

    @Then("Order information should be displayed")
    public void orderInformationShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        historyOrderPage.HistoryOrderProduct();
    }
}
