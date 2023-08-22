package app.middleman;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageAdmin {

    public static WebDriver driver;

    public LoginPageAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//button[@id='to-login']")
    private WebElement signInButton;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    @FindBy(xpath = "//body/div/div/h1")
    private WebElement myProductText;



    public void clickSignInBtn(){
        signInButton.click();
    }
    public String getSignInText() {
        return signInButton.getText();
    }

    public void setLoginButton(String emails, String passwords){
        email.sendKeys(emails);
        password.sendKeys(passwords);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getMyProductText() {
        return myProductText.getText();
    }


    public void alertSuccessLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert successLogin = driver.switchTo().alert();
        successLogin.accept();
    }

    public String getAlertText() {
        Alert alertErrorLogin = driver.switchTo().alert();
        String textAlert = alertErrorLogin.getText();
        return textAlert;

    }
    public String textErrorAlert() throws InterruptedException {
        Thread.sleep(2000);
        Alert alertTextError = driver.switchTo().alert();
        alertTextError.getText();
        System.out.println("Alert text: " + alertTextError.getText());
        return alertTextError.getText();
    }
}





