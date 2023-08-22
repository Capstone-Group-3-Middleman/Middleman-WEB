package app.middleman.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProductUserPage {
    public static WebDriver driver;

    public MyProductUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String imagePath = System.getProperty("user.dir") + "/src/test/resources/Images/";

    @FindBy(xpath = "//body/div/div/div[1]/div[2]/div[1]/ul/li[1]/a")
    private WebElement myProductNavbar;
    @FindBy(xpath = "//button[@id='btn-add-modal']")
    private WebElement addProductBtn;
    @FindBy(css = "#form-add > #input-name")
    private WebElement productNameField;
    @FindBy(css = "#form-add > #input-unit")
    private WebElement unitField;
    @FindBy(css = "#form-add #input-stock")
    private WebElement stockField;
    @FindBy(css = "#form-add #input-price")
    private WebElement priceField;
    @FindBy(css = "[accept='image/png, image/jpeg']")
    private WebElement uploadImage;
    @FindBy(xpath = "//button[@id='btn-add']")
    private WebElement addBtn;
    @FindBy(css = ".grid > div:nth-of-type(1)")
    private WebElement verifyProdCreated;
    @FindBy(css = ".grid > div:nth-of-type(1) .card-title")
    private WebElement verifyTitleProduct;

    @FindBy(css = ".grid > div:nth-of-type(1) #btn-edit-modal")
    private WebElement editBtn;
    @FindBy(css = ".grid > div:nth-of-type(2) #input-name")
    private WebElement editProdNameField;
    @FindBy(css = ".grid > div:nth-of-type(2) #input-unit")
    private WebElement editUnitField;
    @FindBy(css = ".grid > div:nth-of-type(2) #input-stock")
    private WebElement editStockField;
    @FindBy(css = ".grid > div:nth-of-type(2) #input-price")
    private WebElement editPriceField;
    @FindBy(css = ".grid > div:nth-of-type(2) #input-image")
    private WebElement editImageField;
    @FindBy(css = ".grid > div:nth-of-type(2) #btn-edit")
    private WebElement editBtnModal;
    @FindBy(css = ".grid > div:nth-of-type(2) #btn-cancel")
    private WebElement cancelBtn;
    @FindBy(xpath = "//body/div/div[3]/h1")
    private WebElement textMyProduct;

    @FindBy(css = ".grid > div:nth-of-type(1) #btn-delete-modal")
    private WebElement deleteBtn;
    @FindBy(css = ".grid > div:nth-of-type(2) #btn-delete")
    private WebElement yesDeleteBtn;
    @FindBy(css = ".grid > div:nth-of-type(2) #btn-no")
    private WebElement noDeleteBtn;

    @FindBy(css = ".grid > div:nth-of-type(1) [stroke='currentColor']")
    private WebElement plusIcon;


    public void clickPlusIcon() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) [stroke='currentColor']")));
        plusIcon.click();
    }
    public void clickMyProductMenu() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div[1]/div[2]/div[1]/ul/li[1]/a")));
        myProductNavbar.click();
    }
    public void clickAddProductUser() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-add-modal']")));
        addProductBtn.click();
    }
    public void setProductName(String prodName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#form-add > #input-name")));
        productNameField.sendKeys(prodName);
    }
    public void setUnit(String unit) {
        unitField.sendKeys(unit);
    }
    public void setStock(String stock) {
        stockField.sendKeys(stock);
    }
    public void setPrice(String price) {
        priceField.sendKeys(price);
    }
    public void setUploadImage(String imageName) {
        uploadImage.sendKeys(imagePath + ""+imageName+"");
    }

    public void clickAddBtn() {
        addBtn.click();
    }

    public void clickAlertMyProduct() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getAlertMyProductText() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        return text;
    }

    public String getProductTitle(String prodName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".grid > div:nth-of-type(1) .card-title"), prodName));
        return verifyTitleProduct.getText();
    }

    public void clickEditBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) #btn-edit-modal")));
        editBtn.click();
    }

    public void setEditProductName(String prodNameEdit) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(2) #input-name")));
        editProdNameField.clear();
        editProdNameField.sendKeys(prodNameEdit);
    }

    public void setEditUnit(String unitEdit) {
        editUnitField.clear();
        editUnitField.sendKeys(unitEdit);
    }

    public void setEditStock(String stockEdit) {
        editStockField.clear();
        editStockField.sendKeys(stockEdit);
    }

    public void setEditPrice(String priceEdit) {
        editPriceField.clear();
        editPriceField.sendKeys(priceEdit);
    }

    public void setEditImage(String imageName) {
        editImageField.sendKeys(imagePath + ""+imageName+"");
    }

    public void clickEditBtnModal() {
        editBtnModal.click();
    }

    public void clickCancelBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(2) #btn-cancel")));
        cancelBtn.click();
    }

    public String getTextMyProduct() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div[3]/h1"), "My Product"));
        return textMyProduct.getText();
    }

    public void clickDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) #btn-delete-modal")));
        deleteBtn.click();
    }

    public void clickYesBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(2) #btn-delete")));
        yesDeleteBtn.click();
    }

    public void clickNoBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(2) #btn-no")));
        noDeleteBtn.click();
    }
    public boolean verifyProductIsDeleted(String prodNameDeleted) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) .card-title")));
        if (!verifyTitleProduct.getText().equals(prodNameDeleted)) {
            return true;
        } else {
            return false;
        }
    }
}
