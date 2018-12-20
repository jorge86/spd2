package aps;

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
        //Browse to Withdraw page
        driver.findElement(By.xpath("//a[contains(text(),'Ανάληψη')]")).click();

        //Fill out amount and deposit
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Setting up test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\spduser\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        driver = new ChromeDriver(options);

        driver.get("https://grtvap03.korrdot.com/korrXenia/login");

        driver.findElement(By.xpath("//label[@for='username']")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'a')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'n')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'i')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'m')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'a')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'l')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'s')]")).click();

        driver.findElement(By.xpath("//label[@for='inputPassword']")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'a')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'n')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'i')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'m')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'a')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'l')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'s')]")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing test");
    }
}
