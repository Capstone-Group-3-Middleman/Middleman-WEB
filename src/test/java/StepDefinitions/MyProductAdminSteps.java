package StepDefinitions;


import app.middleman.PageObjects.InboundPageAdmin;
import app.middleman.PageObjects.LoginPageAdmin;
import app.middleman.PageObjects.MyProductPageAdmin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class MyProductAdminSteps {

    public MyProductAdminSteps() {
        super();
    }

    public WebDriver webDriver = Hooks.driver;

    LoginPageAdmin loginPage = new LoginPageAdmin(webDriver);
    MyProductPageAdmin myProductPage = new MyProductPageAdmin(webDriver);
    InboundPageAdmin inboundPage = new InboundPageAdmin(webDriver);

    @Given("Admin already login")
    public void adminAlreadyLogin() throws InterruptedException {
        loginPage.clickSignInBtn();
        Thread.sleep(500);
        loginPage.setLoginButton("admin.middleman@gmail.com", "Admin123$");
        loginPage.clickLoginButton();
        loginPage.alertSuccessLogin();
        Thread.sleep(2000);
    }

    @Then("Admin already on my product page")
    public void adminAlreadyOnMyProductPage() {
        Assert.assertEquals("My Product", myProductPage.getMyProductText());
    }


    @When("Admin click add product")
    public void adminClickAddProduct() throws InterruptedException {
        myProductPage.clickButtonAddProduct();
        Thread.sleep(1000);
    }


    @And("Admin input Product Name {string} Unit {string} Stock {string} Price {string}")
    public void adminChooseProductAndInput(String name, String unit, String stock, String price) {
        myProductPage.setInputAddProduct(name, unit, stock, price);
    }

    @And("Admin choose image product {string}")
    public void adminChooseProduct(String jpg) throws InterruptedException {
        myProductPage.inputProductImage(jpg);
        Thread.sleep(500);
    }

    @And("Admin click add on form modal add product")
    public void adminClickAddOnFormModalAddProduct() throws InterruptedException {
        myProductPage.clickButtonAdd();
        Thread.sleep(1000);
    }

    @And("Click alert add product")
    public void clickAlertAddProduct() {
        myProductPage.alertSuccessAddProduct();
    }

    @Then("verify product {string}")
    public void verifyProduct(String productAdd) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("i19 ", myProductPage.getProductText(productAdd));
    }

    @When("Admin click edit on {string} card body")
    public void adminClickEditOnCardBody(String editProduct) throws InterruptedException {
        Thread.sleep(1000);
        myProductPage.clickBtnEditProduct(editProduct);
    }

    @And("Admin edit {string} field image {string} Product Name {string} Unit {string} Stock {string} Price {string}")
    public void adminEditFieldProductNameUnitStockPrice(String nm, String img, String name, String unit, String stock, String price) {
        myProductPage.editProduct(nm, img, name, unit, stock, price);
    }

    @When("Admin click delete product {string}")
    public void adminClickDeleteProduct(String dltProd) {
        myProductPage.clickBtnDeleteProduct(dltProd);
    }

    @And("verify functional button Yes and No in modal {string}")
    public void verifyFunctionalButtonYesAndNo(String dltProd) throws InterruptedException {
        myProductPage.btnNoMdldelete();
        Thread.sleep(1000);
        myProductPage.clickBtnDeleteProduct(dltProd);
        Thread.sleep(1000);
        myProductPage.btnYesMdldelete();
        Thread.sleep(1000);
        myProductPage.alertSuccessDelet();
        Thread.sleep(2000);
    }

    @When("Admin type product to search {string}")
    public void adminTypeProductToSearch(String srchPrdct) {
        myProductPage.searchProduct(srchPrdct);
    }

    @And("Admin click button to search")
    public void adminClickButtonToSearch() {
        myProductPage.btnSearchProduct();
    }

    @Then("Product {string} is displayed")
    public void productIsDisplayed(String src) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals("" + src + "", myProductPage.getMyProductSearch());
    }

    @When("Admin click button add product out {string}")
    public void adminClickButtonAddProductOut(String add) throws InterruptedException {
        myProductPage.addProductOut(add);
        Thread.sleep(2000);
    }

    @And("Accept alert add product")
    public void acceptAlertAddProduct() {
        inboundPage.alertSuccessSubmitProduct();
    }

    @And("Admin go to inbound to verify product")
    public void adminGoToInboundToVerifyProduct() {
        inboundPage.inboundPages();
    }

    @Then("Product is displayed on inbound")
    public void productIsDisplayedOnInbound() {
        inboundPage.verifProductOutInbound();
    }

    @Then("Admin click button yes")
    public void adminClickButtonYes() throws InterruptedException {
        myProductPage.btnYesMdlEdit();
        Thread.sleep(1000);
        myProductPage.alertSuccessAddProduct();
        Thread.sleep(2000);
    }

    @And("Admin click button edit")
    public void adminClickButtonEdit() {
        myProductPage.btnYesMdlEdit();
    }

    @And("Clear field edit product {string}")
    public void clearFieldEditProduct(String names) throws InterruptedException {
        myProductPage.clearField(names);
        Thread.sleep(500);
    }

}
