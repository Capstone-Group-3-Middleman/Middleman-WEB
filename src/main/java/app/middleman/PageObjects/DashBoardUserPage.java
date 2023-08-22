package app.middleman.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardUserPage {
    public static WebDriver driver;

    public DashBoardUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".grid > div:nth-of-type(1)")
    private WebElement firstProduct;

    @FindBy(xpath = "//input[@id='input-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='btn-search']")
    private WebElement searchIconBtn;

    @FindBy(xpath = "//body/div/div/div[3]/div[1]/div[1]/div[1]/h1")
    private WebElement textProduct;

    @FindBy(xpath = "//body/div/div/div[3]/div[1]")
    private WebElement textNotFound;

    @FindBy(xpath = "//body/div/div/div[3]/div[1]/div[1]/img")
    private WebElement prodImage;

    public boolean productIsDisplay() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-of-type(1)")));
        return firstProduct.isDisplayed();
    }

    public void setSearchProduct(String product) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-search']")));
        searchField.sendKeys(product);
    }

    public void clickSearchIconBtn() {
        searchIconBtn.click();
    }

    public String getProductText(String prodName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div/div[3]/div[1]/div[1]/div[1]/h1"), prodName));
        String text = textProduct.getText();
        return text;
    }

    public String getNotFoundText(String message) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body/div/div/div[3]/div[1]"), message));
        String text = textNotFound.getText();
        return text;
    }

    public boolean imageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div[3]/div[1]/div[1]/img")));
        if (!prodImage.getAttribute("src").equals("https://via.placeholder.com/150x192?text=no+image")) {
            return true;
        } else {
            return false;
        }
    }
}
