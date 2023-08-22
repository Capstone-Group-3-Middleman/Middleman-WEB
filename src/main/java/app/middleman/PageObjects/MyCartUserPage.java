package app.middleman.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyCartUserPage {
    public static WebDriver driver;

    public MyCartUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".grid > div:nth-of-type(2) #to-mycart")
    private WebElement addProductBtn;
    @FindBy(css = ".menu-horizontal #to-cart")
    private WebElement myCartMenuNavbar;
    @FindBy(xpath = "//body/div/div/div[5]")
    private WebElement textAddToCart;

    public void clickAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(2) #to-mycart")));
        addProductBtn.click();
    }

    public void clickMyCartMenu() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu-horizontal #to-cart")));
        myCartMenuNavbar.click();
    }

    public String getAddToCartText() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div/div[5]"), "Add your cart"));
        return textAddToCart.getText();
    }

    public void clickAlertOK() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        return text;
    }

    public boolean verifyIsCartEmpty() {
        if (textAddToCart.isDisplayed()) {
            System.out.println("Product Is Empty");
            return false;
        } else {
            return true;
        }
    }
}
