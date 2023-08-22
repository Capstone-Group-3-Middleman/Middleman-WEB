package app.middleman.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfileUserPage {
    public static WebDriver driver;

    public MyProfileUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//body/div/div/div[1]/div[2]/div[2]/label/div[1]")
    private WebElement accountIcon;
    @FindBy(xpath = "//body/div/div/div[1]/div[2]/div[2]/ul/li[1]/a")
    private WebElement myProfileMenu;
    @FindBy(xpath = "//body/div/div/div[1]/div[2]/div[2]/ul/li[2]/button")
    private WebElement logoutBtn;
    @FindBy(css = "tr:nth-of-type(2) > .text-right")
    private WebElement textEmail;
    @FindBy(css = "tr:nth-of-type(3) > .text-right")
    private WebElement textPhoneNumber;

    @FindBy(css = "#open-modal.btn-primary")
    private WebElement editBtn;

    @FindBy(css = "#open-modal.btn-secondary")
    private WebElement deleteBtn;

    @FindBy(xpath = "//input[@id='input-name']")
    private WebElement shopNameField;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='input-phone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='input-address']")
    private WebElement addressField;

    @FindBy(xpath = "//button[@id='btn-edit']")
    private WebElement editBtnModal;

    @FindBy(xpath = "//label[@id='btn-delete']")
    private WebElement yesBtn;

    @FindBy(xpath = "//body/div/div[3]/div[1]/h1")
    private WebElement textMyProfile;

    @FindBy(xpath = "//button[@id='btn-yes']")
    private WebElement yesLogoutBtn;



    public void clickYesLogoutBtn() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-yes']")));
        yesLogoutBtn.click();
    }

    public void clickMyProfileMenu() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div[1]/div[2]/div[2]/ul/li[1]/a")));
        myProfileMenu.click();
    }
    public void clickAccountIcon() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div[1]/div[2]/div[2]/label/div[1]")));
        accountIcon.click();
    }

    public String getTextEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("tr:nth-of-type(2) > .text-right"), email));
        return textEmail.getText();
    }
    public String getTextPhoneNumber(String phone) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("tr:nth-of-type(3) > .text-right"), phone));
        return textPhoneNumber.getText();
    }

    public void clickEditBtn() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#open-modal.btn-primary")));
        editBtn.click();
    }

    public void setShopNameProfile(String shopName) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-name']")));
        shopNameField.clear();
        shopNameField.sendKeys(shopName);
    }
    public void setEmailProfile(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void setPhoneNumberProfile(String phoneNumber) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
    }
    public void setAddressProfile(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void clickEditBtnModal() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-edit']")));
        editBtnModal.click();
    }

    public void clickDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#open-modal.btn-secondary")));
        deleteBtn.click();
    }

    public void clickYesBtn() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='btn-delete']")));
        yesBtn.click();
    }

    public String getTextMyProfile() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div[3]/div[1]/h1"), "My Profile"));
        return textMyProfile.getText();
    }

    public void clickAlertOK() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void clickLogoutBtn() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div[1]/div[2]/div[2]/ul/li[2]/button")));
        logoutBtn.click();
    }
}
