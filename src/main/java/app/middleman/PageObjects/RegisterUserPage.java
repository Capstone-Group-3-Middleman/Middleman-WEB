package app.middleman.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserPage {

    public static WebDriver driver;

    public RegisterUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@id='to-register']")
    private WebElement signUpBtn;
    @FindBy(xpath = "//input[@id='input-name']")
    private WebElement shopNameField;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='input-phone']")
    private WebElement phoneField;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='input-address']")
    private WebElement addressField;
    @FindBy(xpath = "//body/div/div[1]/div[2]/div[1]/h4")
    private WebElement createNewAccountText;
    @FindBy(xpath = "//body/div/div[1]/div[2]/div[1]/h1")
    private WebElement welcomeText;


    public void clickSignUpBtn() {
        signUpBtn.click();
    }

    public void setShopName(String shopName) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-name']")));
        shopNameField.sendKeys(shopName);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void setAddress(String address) {
        addressField.sendKeys(address);
    }

    public String getAlertRegisterText() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String getAlertMessage = alert.getText();

        return  getAlertMessage;
    }

    public void alertRegisterOK() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getRegisterText() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div[1]/div[2]/div[1]/h4")));
        String text = createNewAccountText.getText();

        return text;
    }

    public String getWelcomeText() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //body/div/div[1]/div[2]/div[1]/h1")));
        String text = welcomeText.getText();

        return text;
    }
}
