package vbs;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.fail;

public class IDscannerWithoutCharacterization {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\spduser\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        WebDriver driverOperator = new ChromeDriver(options);
        WebDriver driverDevice = new ChromeDriver(options);

        //Open operator's browser
        driverOperator.get("https://grtvap03.korrdot.com/korrOperator/login");

        //Fill form and login
        driverOperator.findElement(By.id("username")).sendKeys("mitropoulos");
        driverOperator.findElement(By.id("password")).sendKeys("Geo123456");
        driverOperator.findElement(By.xpath("//button[@type='submit']")).click();

        //Open customer's browser
        driverDevice.get("https://grtvap03.korrdot.com/korrDevice");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driverDevice.findElement(By.xpath("//button[@type='button']")).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Open ID Scanner
        driverOperator.findElement(By.cssSelector("div.vbs-container.container-fluid div.row div.col-4.vbs-leftcol div.leftid-widgets.align-middle:nth-child(2) div.row div.col-12.scanner-widget div.scanner-action div.table-container div.row div.col-6:nth-child(2) label.switch > span.slider.round:nth-child(2)")).click();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Accept scanned document
        driverOperator.findElement(By.xpath("//button[@class='btn btn-default btn-accept btn-block']")).click();

        //Complete scanning
        driverOperator.findElement(By.xpath("//span[contains(text(),'COMPLETE SCANNING')]")).click();


//        driverOperator.findElement(By.xpath("//div[@class='radio-tile-group']//div[1]//div[1]//input[1]")).click();
//        driverOperator.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        //Click X button to close characterization modal
        driverOperator.findElement(By.xpath("//span[@aria-hidden='true']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Assertion
        if(driverOperator.findElement(By.xpath("//div[@title='View file']")).isEnabled()){
            System.out.println("Test PASS.");
        }
        else {
            System.out.println("FAIL");
        }

        //Close browsers
//        driverDevice.close();
//        driverOperator.close();
    }
}