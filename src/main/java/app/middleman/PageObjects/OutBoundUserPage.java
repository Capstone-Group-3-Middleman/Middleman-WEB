package app.middleman.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutBoundUserPage {
    public static WebDriver driver;

    public OutBoundUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".menu-horizontal #to-outbound")
    private WebElement outboundMenuNavbar;

    @FindBy(xpath = "//button[@id='to-history-outbound']")
    private WebElement historyProdOutBtn;

    @FindBy(xpath = "//button[@id='btn-submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//body/div/div/div[3]/h1")
    private WebElement textOutBoundProd;

    @FindBy(xpath = "//body/div/div/div[5]")
    private WebElement textAddYourOutbound;

    @FindBy(xpath = "//body/div/div[3]/h1")
    private WebElement textHisOutProd;

    @FindBy(css = ".grid > div:nth-of-type(1) > #to-detail")
    private WebElement detailBtn;

    @FindBy(xpath = "//body/div/div[3]/div[1]/h1")
    private WebElement textDetailProdOut;

    @FindBy(xpath = "//body/div/div[3]/div[2]/table")
    private WebElement tableDetailProdOut;

    @FindBy(css = ".grid > div:nth-of-type(1) > .card-body")
    private WebElement prodCard;

    @FindBy(css = ".grid > div:nth-of-type(1) #btn-delete")
    private WebElement deleteBtn;


    public void clickOutboundMenu() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu-horizontal #to-outbound")));
        outboundMenuNavbar.click();
    }

    public void clickHistoryProdOutBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='to-history-outbound']")));
        historyProdOutBtn.click();
    }

    public void clickSubmitBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-submit']")));
        submitBtn.click();
    }

    public String getTextOutBoundProd() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div/div[3]/h1"), "Outbound Product"));
        return textOutBoundProd.getText();
    }

    public String getTextAddYourOutbound() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div/div[5]"), "Add your outbound"));
        return textAddYourOutbound.getText();
    }

    public boolean isProductOutEmpty() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  //body/div/div/div[5]")));
        if (textAddYourOutbound.isDisplayed()) {
            return true;
        } else {
            return false;
        }
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
        String text = alert.getText();
        return text;
    }

    public String getTextHisOutProd() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div[3]/h1"), "History Product Out"));
        return textHisOutProd.getText();
    }

    public void clickDetailBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) > #to-detail")));
        detailBtn.click();
    }

    public String getTextDetailProdOut() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div[3]/div[1]/h1"), "Detail Product Out"));
        return textDetailProdOut.getText();
    }

    public boolean verifyDetailProdOutIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div[3]/div[2]/table")));
        return tableDetailProdOut.isDisplayed();
    }

    public boolean verifyOutBoundNotEmpty() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) > .card-body")));
        return prodCard.isDisplayed();
    }

    public void clickDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) #btn-delete")));
        deleteBtn.click();
    }
}
