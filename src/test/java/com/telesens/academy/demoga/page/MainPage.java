package com.telesens.academy.demoga.page;

import com.telesens.academy.lesson17.PropertyDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{
    @ FindBy (id="account")
    private WebElement myAccountLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToHome(){
        driver.get(strurl);
        return this;
    }
    public YouAccountPage clickToMyAccount(){
        myAccountLink.click();
        YouAccountPage youAccountPage = new YouAccountPage(driver);
        return youAccountPage;
    }
}
