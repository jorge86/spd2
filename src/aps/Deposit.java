package aps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Deposit {

    WebDriver driver;

    @Test
    public void DepositTest(){
        System.out.println("Starting test");
        //Select account
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//div[@id='slick-slide00']//div[@class='selectbtn'][contains(text(),'Επιλογή')]")).click();

        //Click at Deposit
        driver.findElement(By.xpath("//div[@class='general-deposit general-icon']")).click();

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
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'i')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'m')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'a')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'l')]")).click();
        driver.findElement(By.xpath("//div[@class='hg-button hg-standardBtn']//span[contains(text(),'s')]")).click();

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
    }
}
