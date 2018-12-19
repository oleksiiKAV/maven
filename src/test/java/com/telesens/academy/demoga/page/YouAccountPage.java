package com.telesens.academy.demoga.page;

import com.telesens.academy.lesson17.PropertyDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouAccountPage extends BasePage{
    //private WebDriver driver;
   // String strurl= PropertyDemo.readProperty("urladdress");
    @FindBy(id="log")
    private WebElement myLog;
    @FindBy(id="pwd")
    private WebElement myPwd;
    @FindBy(id="login")
    private WebElement myLoginBtn;
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Your Account'])[1]/following::strong[1]")
    private WebElement ErrText;

    //@FindBy(linkText="(Logout)")
    private WebElement myElement;

    public YouAccountPage(WebDriver driver) {
        super(driver);
    }
    public YouAccountPage EnterLogin(String login){
        input(myLog,login);
        return this;
    }
    public YouAccountPage EnterPwd(String pwd){
        input(myPwd,pwd);
        return this;
    }
    //driver.findElement(By.id("login")).click();

    public LoginOKPage clickToLogin(){ //return Page after access enable
        myLoginBtn.click();
        LoginOKPage loginOKPage = new LoginOKPage(driver);
        return loginOKPage;
    }
//
//    public Object ElementIsPresent(){
//        return myElement.findElement(By.linkText("(Logout)"));
//    }

    public String ErrText(){
        return ErrText.getText();
    }

}
