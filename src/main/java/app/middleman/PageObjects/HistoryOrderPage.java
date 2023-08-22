package app.middleman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HistoryOrderPage {
    public static WebDriver driver;

    public HistoryOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void HistoryOrderMenu() {
        driver.findElement(By.xpath("//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-history-order']")).click();
    }

    public void DetailHistoryOrder() {

        driver.findElement(By.cssSelector("tbody:nth-of-type(1) #to-detail-order")).click();
    }

    public void HistoryOrderProduct() {
        String a = driver.findElement(By.xpath("//h1[@class='text-black font-Roboto font-semibold text-[30px] p-9 text-center md:text-[44px] lg:text-[44px] lg:text-left lg:ml-20']")).getText();
        System.out.println(a);
    }


}
