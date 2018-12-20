package vbs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class Login {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mitropoulos\\Downloads\\chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        WebDriver driverOperator=new ChromeDriver(options);
        WebDriver driverDevice=new ChromeDriver(options);

        //Open operator's browser
        driverOperator.get("https://grtvap03.korrdot.com/korrOperator/login");

        //Fill form and login
        driverOperator.findElement(By.id("username")).sendKeys("mitropoulos");
        driverOperator.findElement(By.id("password")).sendKeys("Geo123456");
        driverOperator.findElement(By.xpath("//button[@type='submit']")).click();

        //Open customer's browser
        driverDevice.get("https://grtvap03.korrdot.com/korrDevice");

        WebElement element;
        WebDriverWait wait = new WebDriverWait(driverDevice, 10);
        element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']")));

        driverDevice.findElement(By.xpath("//button[@type='button']")).click();

        //Assertion
        String URL = driverOperator.getCurrentUrl();
        Assert.assertEquals(URL, "https://grtvap03.korrdot.com/korrOperator/identification" );
        System.out.println("Test PASS \n" +"User redirected to: "+URL);

        driverDevice.close();
        driverOperator.close();
    }
}
