package app.middleman;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProductPageAdmin {

    public static WebDriver driver;

    public static final String DIR = System.getProperty("user.dir");
    public static String IMAGE_FOLDER = DIR + "/src/test/resources/ImageAdmin/";

    public MyProductPageAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary modal-button text-white font-Roboto']")
    private WebElement btnAddProduct;

    @FindBy(xpath = "//h3[.='Add Product']")
    private WebElement titleModalAddProduct;

    @FindBy(xpath = "//button[.='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-name']")
    private WebElement fieldProductName;

    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-unit']")
    private WebElement fieldProductUnit;

    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-stock']")
    private WebElement fieldProductStock;

    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-price']")
    private WebElement fieldProductPrice;

    @FindBy(xpath = "//h1[@class='text-black font-Roboto font-semibold text-4xl']")
    private WebElement myProductText;

    @FindBy(xpath = "//input[@id='input-search']")
    private WebElement fieldSearch;

    @FindBy(css = ".grid > div:nth-of-type(1) [stroke='currentColor']")
    private WebElement btnAddProductStock;

    @FindBy(css = ".grid > div:nth-of-type(1) #btn-delete-modal")
    private WebElement btnDeleteProduct;

    @FindBy(xpath = "//button[@id='btn-no']")
    private WebElement btnNoModalDelete;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement btnYesModalDelete;

    @FindBy(xpath = "//input[@id='input-search']")
    private WebElement fieldSearchProduct;

    @FindBy(xpath = "//button[@id='btn-search']")
    private WebElement btnSearchProduct;


    public void clickButtonAddProduct() {
        btnAddProduct.click();
    }

    public void clickButtonAdd() {
        btnAdd.click();
    }

    public void setInputAddProduct(String productName, String productUnit, String productStock, String productPrice) {
        fieldProductName.sendKeys(productName);
        fieldProductUnit.sendKeys(productUnit);
        fieldProductStock.sendKeys(productStock);
        fieldProductPrice.sendKeys(productPrice);
    }

    public String getTitleModal() {
        return titleModalAddProduct.getText();
    }

    public String getMyProductText() {
        return myProductText.getText();
    }

    public void inputProductImage(String imge) {
        WebElement element = driver.switchTo().activeElement().findElement(By.xpath("//div[@id='__next']/div[@class='modal']//input[@id='input-image']"));
        element.sendKeys(IMAGE_FOLDER + imge);
    }

    public void alertSuccessAddProduct() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert successAddProduk = driver.switchTo().alert();
        successAddProduk.accept();
    }

    public String getProductText(String addProd) {
        return driver.findElement(By.xpath("//h2[text()='" + addProd + "']")).getText();
    }

    public void clickBtnEditProduct(String editProd) {
        driver.findElement(By.xpath("//h2[text()='" + editProd + "']/parent::div/following-sibling::div[@class='card-actions justify-start font-Roboto']/button[@title='Edit Product']")).click();
    }

    public void clickBtnDeleteProduct(String deleteProd) {
        driver.findElement(By.xpath("//h2[text()='" + deleteProd + "']/parent::div/following-sibling::div[@class='card-actions justify-start font-Roboto']/label[@title='Delete Product']")).click();
    }



    public void clearField(String names){
        driver.findElement(By.xpath("//input[@value='"+names+"']")).clear();
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-unit']")).clear();
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-stock']")).clear();
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-price']")).clear();
    }

    public void editProduct(String names, String imageFileName, String editName, String editUnit, String editStock, String editPrice) {
        WebElement imageInput = driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[4]//input[@id='input-image']"));
        imageInput.sendKeys(IMAGE_FOLDER + imageFileName);
        driver.findElement(By.xpath("//input[@value='"+names+"']")).sendKeys(editName);
//        String msg = driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[4]//input[@id='input-name']")).getAttribute("validationMessage");
//        System.out.println(msg);
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-unit']")).sendKeys(editUnit);
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-unit']")).getAttribute("validationMessage");
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-stock']")).sendKeys(editStock);
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-stock']")).getAttribute("validaionMessage");
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-price']")).sendKeys(editPrice);
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//input[@id='input-price']")).getAttribute("validaionMessage");
    }

    public void btnNoMdldelete() {
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']//button[@id='btn-no']")).click();
    }

    public void btnNoMdlEdit() {
        driver.findElement(By.xpath("//button[@id='btn-cancel']/ancestor::div[@class='modal-box']")).click();
    }

    public void btnYesMdldelete() {
        driver.findElement(By.xpath("//button[@id='btn-delete']")).click();
    }

    public void btnYesMdlEdit() {
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[2]//button[@id='btn-edit']")).click();
    }

    public void alertSuccessDelet() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert successDeleteProduct = driver.switchTo().alert();
        successDeleteProduct.accept();
    }

    public void searchProduct(String typeSearch) {
        fieldSearchProduct.sendKeys(typeSearch);
    }

    public void btnSearchProduct() {
        btnSearchProduct.click();
    }

    public String getMyProductSearch() {
        return driver.findElement(By.xpath("//h2[@class='card-title text-base']")).getText();
    }

    public void addProductOut(String titleProductAdd) {
        driver.findElement(By.xpath("//h2[text()='" + titleProductAdd + "']/ancestor::div[@class='card card-side bg-white shadow-lg m-2 text-black']//button[@id='btn-add-product-out']")).click();
    }

    public void alertSuccessAddProductOut() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert successAddProdukOut = driver.switchTo().alert();
        successAddProdukOut.accept();
    }
}
