package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tokopedia {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tokopedia.com");
        //memperbesar tampilan

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //mencari element untuk input, lalu mengisi data
        WebElement test = driver.findElement(By.xpath("//input[@class='css-1wc186l e110g5pc0']"));
        test.sendKeys("sepatu");
        driver.findElement(By.xpath("//button[@class='css-1czin5k e1v32nag1']")).click();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(5000);
        WebElement produk = driver.findElement(By.xpath("//*[@id=\"zeus-root\"]/div/div[2]/div/div[2]"));
        List<WebElement> rows = produk.findElements(By.className("css-12sieg3"));
        System.out.println("Jumlah produk yg ditampilkan = "+rows.size());
        driver.close();
    }
}
