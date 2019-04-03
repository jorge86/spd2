package aps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class GuestCash {
    WebDriver driver;

    @Test
    public void GuestDeiCashHappy(){
        System.out.println("\n STARTING TEST \n");
        //Select account
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click at DEI favorite button
        driver.findElement(By.xpath("//img[@src='assets/transaction-logos/dei.png']")).click();

        //assert DEI payment page
        String expectedURL = driver.getCurrentUrl();
        String actualURL="http://localhost:4200/transactions/dei";
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("DEI payment PASS \n" +expectedURL);

        //Scan barcode
        driver.findElement(By.xpath("//button[@id='btnScanBarcode']//*[@height='45']")).click();

        //assert Barcode scanning page
        String expectedURL1 = driver.getCurrentUrl();
        String actualURL1="http://localhost:4200/barcodeScanning";
        Assert.assertEquals(actualURL1, expectedURL1);
        System.out.println("Barcode PASS \n" +expectedURL1);

        //Type name
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//span[contains(text(),'Α')]")).click();

        //Type phone
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();

        //delete last digit
        driver.findElement(By.xpath("//img[@src='assets/back.png']")).click();

        //Assert SUNEXEIA button is disabled
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedURL2 = driver.getCurrentUrl();
        String actualURL2="http://localhost:4200/transactions/dei";
        Assert.assertEquals(actualURL2, expectedURL2);
        System.out.println("SUNEXEIA disabled PASS \n" +expectedURL2);

        //Insert valid phone
        driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();

        //Submit and assert Summary page
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedURL3 = driver.getCurrentUrl();
        String actualURL3="http://localhost:4200/transactions/dei/summary";
        Assert.assertEquals(actualURL3, expectedURL3);
        System.out.println("Summary PASS \n" +expectedURL3);

        //Click back and forth to the Summary page
        driver.findElement(By.xpath("//div[@class='btntext']")).click();

        String expectedURL4 = driver.getCurrentUrl();
        String actualURL4="http://localhost:4200/transactions/dei";
        Assert.assertEquals(actualURL4, expectedURL4);
        System.out.println("DEI payment (filled) PASS \n" +expectedURL4);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedURL5 = driver.getCurrentUrl();
        String actualURL5="http://localhost:4200/transactions/dei/summary";
        Assert.assertEquals(actualURL5, expectedURL5);
        System.out.println("Summary same as before PASS \n" +expectedURL5);

        //Confirm Summary and assert Transactions
        driver.findElement(By.xpath("//button[contains(text(),'EΠΙΒΕΒΑΙΩΣΗ')]")).click();

        String expectedURL6 = driver.getCurrentUrl();
        String actualURL6="http://localhost:4200/transactions/my-transactions";
        Assert.assertEquals(actualURL6, expectedURL6);
        System.out.println("Transaction PASS \n" +expectedURL6);

        //Pay with cash and confirm payment
        driver.findElement(By.xpath("//div[contains(text(),'ΜΕΤΡΗΤΑ')]")).click();

        String expectedURL7 = driver.getCurrentUrl();
        String actualURL7="http://localhost:4200/transactions/cashPayment";
        Assert.assertEquals(actualURL7, expectedURL7);
        System.out.println("Cash Payment PASS \n" +expectedURL7);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(text(),'Πληρωμή ΔΕΗ')]"), "ΔΕΗ"));

        driver.findElement(By.id("confirmBtn")).click();

        String expectedURL8 = driver.getCurrentUrl();
        String actualURL8="http://localhost:4200/transaction/dei/receipt";
        Assert.assertEquals(actualURL8, expectedURL8);
        System.out.println("Receipt PASS \n" +expectedURL8);

        //Finish payment and click at YES at question screen
        driver.findElement(By.id("btn-finish")).click();
        driver.findElement(By.id("btnYes")).click();
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

        //login as guest
        driver.findElement(By.xpath("//button[@class='btnlogin_actions']")).click();

        //assert login
        String expectedURL = driver.getCurrentUrl();
        String actualURL="http://localhost:4200/transactions";
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("Login PASS \n" +expectedURL);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing test");

        //assertion
        String expectedURL7 = driver.getCurrentUrl();
        String actualURL7="http://localhost:4200/transactions";
        Assert.assertEquals(actualURL7, expectedURL7);
        System.out.println("Return to landing page PASS \n" +expectedURL7);

        driver.close();
    }
}