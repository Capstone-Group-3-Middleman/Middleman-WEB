package app.middleman.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HistoryOrderUserPage {

    public static WebDriver driver;

    public HistoryOrderUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".menu-horizontal #to-history-order")
    private WebElement historyOrderBtnNavbar;

    @FindBy(css = ".gap-4 > div:nth-of-type(1) #to-detail_order")
    private WebElement detailBtn;

    @FindBy(xpath = "//body/div/div/div[5]")
    private WebElement detailOrderContent;

    @FindBy(xpath = "//body/div/div/div[3]/h1")
    private WebElement textHistoryOrderProd;

    @FindBy(css = ".gap-4 > div:nth-of-type(1)")
    private WebElement prodCard;

    public void clickHistoryOrderMenu() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu-horizontal #to-history-order")));
        historyOrderBtnNavbar.click();
    }

    public void clickDetailBtn() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gap-4 > div:nth-of-type(1) #to-detail_order")));
        detailBtn.click();
    }

    public boolean verifyOrderDetailIsDisplay() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div[5]")));
        return detailOrderContent.isDisplayed();
    }

    public String getTextHistoryOrderProd() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div/div[3]/h1"), "History Order Product"));
        return textHistoryOrderProd.getText();
    }

    public boolean verifyProdCardIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gap-4 > div:nth-of-type(1)")));
        return prodCard.isDisplayed();
    }
}
