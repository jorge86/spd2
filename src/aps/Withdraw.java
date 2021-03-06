package aps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Withdraw {
    WebDriver driver;

    @Test
    public void WithdrawTest(){
        System.out.println("Starting test");
        //Select account
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//div[@id='slick-slide00']//div[@class='selectbtn'][contains(text(),'Επιλογή')]")).click();

        //Click at Withdraw
        driver.findElement(By.xpath("//div[@class='general-withdraw general-icon']")).click();

        //Type amount
        driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();

        //Clear amount
        driver.findElement(By.id("btnClear")).click();

        //type new amount
        driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'3')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();

        //delete last digit
        driver.findElement(By.xpath("//img[@src='assets/back.png']")).click();

        //Assert latest value
        String latestValue= driver.findElement(By.xpath("//input[@id='amount']")).getAttribute("value");
        Assert.assertEquals(latestValue, "53");

        //Return to account
        driver.findElement(By.xpath("//a[@class='home']")).click();

        //Click at Withdraw
        driver.findElement(By.xpath("//div[@class='general-withdraw general-icon']")).click();

        //Type amount
        driver.findElement(By.xpath("//span[contains(text(),'8')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'2')]")).click();

        //Click at withdraw
        driver.findElement(By.id("btnAmount")).click();

        //Assert successful withdraw

    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Setting up test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mitropoulos\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        driver = new ChromeDriver(options);

        driver.get("http://localhost:4200/login");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//label[@for='username']")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'a')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'n')]")).click();

        driver.findElement(By.xpath("//label[@for='inputPassword']")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'d')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'e')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'m')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'o')]")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing test");

        //pending assertion
    }
}
