package StepDefinitions;

import app.middleman.PageObjects.InboundPageAdmin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class InboundAdminSteps {

    public InboundAdminSteps() {
        super();
    }

    public WebDriver webDriver = Hooks.driver;

    InboundPageAdmin inboundPage = new InboundPageAdmin(webDriver);

    @When("Admin already on Inbound page")
    public void adminGoToInboundPage() throws InterruptedException {
        Thread.sleep(2000);
        inboundPage.inboundPages();
    }

    @And("Admin click button plus {string}")
    public void adminClickButtonPlus(String incr) throws InterruptedException {
        Thread.sleep(2000);
        inboundPage.clickIncrementInbound(incr);
    }

    @Then("Amount increases {string}")
    public void amountIncreases(String incr) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(""+incr+"", inboundPage.verifyIncreses());
    }

    @When("Admin click button min {string}")
    public void adminClickButtonMin(String dcrement) throws InterruptedException {
        Thread.sleep(3000);
        inboundPage.clickDecrementInbound(dcrement);
    }

    @Then("Number decreased {string}")
    public void numberDecreased(String dcrement) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(""+dcrement+"", inboundPage.verifyIncreses());
    }

    @And("Admin click button history product in")
    public void adminClickButtonHistoryProductIn() {
        inboundPage.btnHistoryProductIn();
    }

    @And("Admin click button detail")
    public void adminClickButtonDetail() throws InterruptedException {
        Thread.sleep(2000);
        inboundPage.btnDetailHistoryProductIn();
    }

    @Then("Verify detail product {string}")
    public void verifyDetailProduct(String a) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(""+a+"", inboundPage.verifyProdctDetail(a));
    }

    @When("Admin click button submit to")
    public void adminClickButtonSubmitTo() {
        inboundPage.btnSubmit();
    }

    @When("Delete product from inbound")
    public void deleteProductFromInbound() {
        inboundPage.btnDelete();
    }

    @And("click alert delete")
    public void clickAlertDelete() {
        inboundPage.alertSuccessSubmitProduct();
    }

    @And("Admin click button add product stock")
    public void adminClickButtonAddProductStock() {
        inboundPage.addStock();
    }
}
