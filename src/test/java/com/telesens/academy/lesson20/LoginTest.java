package com.telesens.academy.lesson20;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.telesens.academy.demoga.page.MainPage;
import com.telesens.academy.demoga.page.YouAccountPage;
import com.telesens.academy.lesson17.PropertyDemo;
import com.telesens.academy.loginform.ReadFromFileXLS;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) throws Exception {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "D:/Local/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "D:/Local/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            default:
                throw new UnsupportedOperationException("Not supported browser: " + browser);
        }

        baseUrl = PropertyDemo.readProperty("urladdress");//"http://store.demoqa.com"
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test(dataProvider = "positiveLoginProvider", groups = "LoginTrue")
    public void testCorrectLoginTestCase(String login, String password) throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToHome();
        YouAccountPage youAccountPage = mainPage.clickToMyAccount();
        youAccountPage.EnterLogin(login);
        youAccountPage.EnterPwd(password);
        youAccountPage.clickToLogin();
        Assert.assertNotEquals(driver.findElement(By.linkText("(Logout)")), null) ;
        //Assert.assertNotEquals(youAccountPage.ElementIsPresent(), null) ;
        driver.close();
    }
//        public void testCorrectLoginTestCase(String login, String password) throws Exception {
//            String strurl=PropertyDemo.readProperty("urladdress");
//            driver.get(strurl);
//            driver.findElement(By.id("account")).click();
//            driver.findElement(By.id("log")).click();
//            driver.findElement(By.id("log")).clear();
//            driver.findElement(By.id("log")).sendKeys(login);
//            driver.findElement(By.id("pwd")).clear();
//            driver.findElement(By.id("pwd")).sendKeys(password);
//            driver.findElement(By.id("login")).click();
//            Assert.assertNotEquals(driver.findElement(By.linkText("(Logout)")), null) ;
//            //driver.findElement(By.linkText("(Logout)")).click();
//            driver.close();
//        }

    @Test(dataProvider = "negativeLoginProvider", groups = "LoginFalse")
    public void IncorrectLoginTestCase(String login, String password, String errMessage) throws Exception { //if input correct - test failed
        MainPage mainPage = new MainPage(driver);
        mainPage.goToHome();
        YouAccountPage youAccountPage = mainPage.clickToMyAccount();
        youAccountPage.EnterLogin(login);
        youAccountPage.EnterPwd(password);
        youAccountPage.clickToLogin();

        //String errorShow = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")).getText();
        String errorShow = youAccountPage.ErrText();
        //System.out.println(errorShow);
        Assert.assertEquals(errorShow,errMessage);

        driver.close();
    }

//    public void IncorrectLoginTestCase(String login, String password, String errMessage) throws Exception { //if input correct - test failed
//        String strurl=PropertyDemo.readProperty("urladdress");
//        driver.get(strurl);
//        driver.findElement(By.id("account")).click();
//        driver.findElement(By.id("log")).click();
//        driver.findElement(By.id("log")).clear();
//        driver.findElement(By.id("log")).sendKeys(login);
//        driver.findElement(By.id("pwd")).click();
//        driver.findElement(By.id("pwd")).clear();
//        driver.findElement(By.id("pwd")).sendKeys(password);
//        driver.findElement(By.id("login")).click();
//
//        String errorShow = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")).getText();
//        //Assert.assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")).getText(), "ERROR");
//        /*try {
//            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")).getText(), "ERROR");
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }*/
//        //Thread.sleep(3000); // bad practice
//        //WebElement message = (new WebDriverWait(driver, 7))
//         //       .until(ExpectedConditions
//          //              .presenceOfElementLocated(By.className("response")));
//        Assert.assertEquals(errorShow,errMessage);
//
//        driver.close();
//    }


        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

    @DataProvider(name="negativeLoginProvider")
    public Object[][] negativeLoginProvider() {
        Object newobj[][]=null;
        //readFromXLX(start test row, end test row, cells - counts of data for test)
        newobj=ReadFromFileXLS.readFromXLX(2,3,3);
        return newobj;
     /*   return new Object[][]{
               // {"KAV123xc", "Passw0rd!1", "ERROR: Invalid username. Lost your password?"},
                {"KAV123", "Passw0rd!", "ERROR: Invalid username. Lost your password?"}
        };*/
    }

    @DataProvider(name="positiveLoginProvider")
    public Object[][] positiveLoginProvider() {
        Object newobj[][]=null;
        //readFromXLX(start test row, end test row, cells - counts of data for test)
        newobj=ReadFromFileXLS.readFromXLX(1,1,2);
        return newobj;
     /*   return new Object[][]{
               // {"KAV123xc", "Passw0rd!1", "ERROR: Invalid username. Lost your password?"},
                {"KAV123", "Passw0rd!", "ERROR: Invalid username. Lost your password?"}
        };*/
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


