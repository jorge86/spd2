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

public class Login {
    WebDriver driver;

    @Test
    public void LoginTest(){
        System.out.println("Starting test");
        //Fill form and login
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

    @BeforeMethod
    public void setUp(){
        System.out.println("Setting up test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mitropoulos\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        driver = new ChromeDriver(options);

        driver.get("https://grtvap03.korrdot.com/korrXenia/login");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing test");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedURL = driver.getCurrentUrl();
        String actualURL="https://grtvap03.korrdot.com/korrXenia/landing";
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("Test PASS \n" +expectedURL);

        driver.close();
    }
}
