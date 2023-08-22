package StepDefinitions;

import app.middleman.PageObjects.MyProductUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyProductUserPageSteps {

    public MyProductUserPageSteps(){
        super();
    }
    public WebDriver driver = Hooks.driver;

    MyProductUserPage myProductUserPage = new MyProductUserPage(driver);
    @When("User click my product menu")
    public void userClickMyProduct() {
        myProductUserPage.clickMyProductMenu();
    }

    @And("User click add product button")
    public void userClickAddProductButton() {
        myProductUserPage.clickAddProductUser();
    }

    @And("User input product name as {string}")
    public void userInputProductNameAs(String prodName) {
        myProductUserPage.setProductName(prodName);
    }

    @And("User input unit as {string}")
    public void userInputUnitAs(String unit) {
        myProductUserPage.setUnit(unit);
    }

    @And("User input stock as {string}")
    public void userInputStockAs(String stock) {
        myProductUserPage.setStock(stock);
    }

    @And("User input price as {string}")
    public void userInputPriceAs(String price) {
        myProductUserPage.setPrice(price);
    }

    @And("User input images {string}")
    public void userInputImages(String image) {
        myProductUserPage.setUploadImage(image);
    }

    @And("User click add button")
    public void userClickAddButton() {
        myProductUserPage.clickAddBtn();
    }

    @Then("Alert my product message will appear {string}")
    public void alertMyProductMessageWillAppear(String message) {
        Assert.assertEquals(message, myProductUserPage.getAlertMyProductText());
    }

    @When("User click ok on alert my product")
    public void userClickOkOnAlertMyProduct() {
        myProductUserPage.clickAlertMyProduct();
    }

    @Then("User Product success created with product name is {string}")
    public void userProductSuccessCreated(String prodName) {
        Assert.assertEquals(prodName, myProductUserPage.getProductTitle(prodName));
    }

    @And("User click edit product user")
    public void userClickEditProductUser() {
        myProductUserPage.clickEditBtn();
    }

    @And("User edit product name as {string}")
    public void userEditProductNameAs(String prodNameEdit) {
        myProductUserPage.setEditProductName(prodNameEdit);
    }

    @And("User edit unit as {string}")
    public void userEditUnitAs(String unitEdit) {
        myProductUserPage.setEditUnit(unitEdit);
    }

    @And("User edit stock as {string}")
    public void userEditStockAs(String stockEdit) {
        myProductUserPage.setEditStock(stockEdit);
    }

    @And("User edit price as {string}")
    public void userEditPriceAs(String priceEdit) {
        myProductUserPage.setEditPrice(priceEdit);
    }

    @And("User edit images {string}")
    public void userEditImages(String imageEdit) {
        myProductUserPage.setEditImage(imageEdit);
    }

    @And("User click edit button")
    public void userClickEditButton() {
        myProductUserPage.clickEditBtnModal();
    }

    @And("User click cancel button on modal product user")
    public void userClickCancelButtonOnModalProductUser() {
        myProductUserPage.clickCancelBtn();
    }

    @Then("User back to my product page")
    public void userBackToMyProductPage() {
        Assert.assertEquals("My Product", myProductUserPage.getTextMyProduct());
    }

    @And("User click delete button")
    public void userClickDeleteButton() {
        myProductUserPage.clickDeleteBtn();
    }

    @And("User click yes button")
    public void userClickYesButton() {
        myProductUserPage.clickYesBtn();
    }

    @Then("Product name {string} already deleted")
    public void productNameAlreadyDeleted(String prodNameDeleted) {
       Assert.assertTrue(myProductUserPage.verifyProductIsDeleted(prodNameDeleted));
    }

    @And("User click no button")
    public void userClickNoButton() {
        myProductUserPage.clickNoBtn();
    }
}
