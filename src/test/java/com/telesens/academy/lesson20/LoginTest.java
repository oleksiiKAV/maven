package com.telesens.academy.lesson20;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:/Local/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "D:/Local/geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

        @Test
        public void testCorrectLoginTestCase() throws Exception {
            driver.get("http://store.demoqa.com/");
            driver.findElement(By.id("account")).click();
            driver.findElement(By.id("log")).click();
            driver.findElement(By.id("log")).clear();
            driver.findElement(By.id("log")).sendKeys("KAV123g");
            driver.findElement(By.id("pwd")).clear();
            driver.findElement(By.id("pwd")).sendKeys("Passw0rd!");
            driver.findElement(By.id("login")).click();

            Assert.assertNotEquals(driver.findElement(By.linkText("(Logout)")), null) ;

            //driver.findElement(By.linkText("(Logout)")).click();
            driver.close();
        }

    @Test
    public void IncorrectLoginTestCase() throws Exception { //if input correct - test failed
        driver.get("http://store.demoqa.com/");
        driver.findElement(By.id("account")).click();
        driver.findElement(By.id("log")).click();
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys("KAV123");
        driver.findElement(By.id("pwd")).click();
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("Passw0rd!1");
        driver.findElement(By.id("login")).click();
        //String Error_Show = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")).getText(), "ERROR");
        /*try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")).getText(), "ERROR");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }*/
        driver.close();
    }


        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
}


