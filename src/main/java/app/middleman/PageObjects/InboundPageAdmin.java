package app.middleman;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboundPageAdmin {

    public static WebDriver driver;

    public InboundPageAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(css = ".grid > div:nth-of-type(1) #btn-delete")
    private WebElement deleteBtn;

    public void alertSuccessSubmitProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert successSubmitProduk = driver.switchTo().alert();
        successSubmitProduk.accept();
    }

    public void inboundPages() {
        driver.findElement(By.xpath("//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-cart']")).click();
    }

    public void verifProductOutInbound() {
        driver.findElement(By.xpath("//h1[@class='font-Roboto font-semibold text-[30px] p-3 text-center md:text-[44px] lg:text-[44px] lg:text-left lg:ml-20 text-black']")).getText();
    }

    public void clickIncrementInbound(String incr) {
        driver.findElement(By.xpath("//h2[text()='" + incr + "']/following-sibling::div//button[@id='increment']")).click();
    }

    public String verifyIncreses() {
        return driver.findElement(By.xpath("//div[@class='grid gap-2 m-2 grid-flow-row auto-rows-max grid-cols-1 md:grid-cols-2 lg:grid-cols-3 justify-center']/div[1]//p[@class='text-center w-20']")).getText();
    }

    public void clickDecrementInbound(String incr) {
        driver.findElement(By.xpath("//h2[text()='" + incr + "']/following-sibling::div//button[@id='decrement']")).click();
    }

    public void btnHistoryProductIn() {
        driver.findElement(By.xpath("//button[@id='to-history-outbound']")).click();
    }

    public void btnDetailHistoryProductIn() {
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 lg:grid-cols-3 my-4']/div[1]/button[@id='to-detail']")).click();
    }

    public String verifyProdctDetail(String productDetail) {
        return driver.findElement(By.xpath("//td[text()='" + productDetail + "']")).getText();
    }

    public void btnSubmit() {
        driver.findElement(By.xpath("//button[@id='btn-submit']")).click();
    }

    public void btnDelete() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1) #btn-delete")));
        deleteBtn.click();
    }

    public void addStock() {
        driver.findElement(By.xpath("//div[@class='grid grid-cols-1 gap-2 m-2 md:grid-cols-2 lg:grid-cols-3']/div[1]//button[@id='btn-add-product-out']"));
    }

}
