package app.middleman.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUserPage {

    public static WebDriver driver;

    public LoginUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@id='to-login']")
    private WebElement signInButton;

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    @FindBy(xpath = "//body/div/div/div[3]/h1")
    private WebElement dashboardText;



    public void clickSignInBtn(){
        signInButton.click();
    }
    public String getSignInText() {
        return signInButton.getText();
    }

    public void setEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        this.email.sendKeys(email);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getDashboardText() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div[3]/h1")));
        return dashboardText.getText();
    }

    public void alertLoginUser() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert loginUser = driver.switchTo().alert();
        loginUser.accept();
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertErrorLogin = driver.switchTo().alert();
        String textAlert = alertErrorLogin.getText();

        return textAlert;
    }
}
