package com.telesens.academy.demoga.page;

import com.telesens.academy.lesson17.PropertyDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    //private WebDriver driver;
    protected String strurl= PropertyDemo.readProperty("urladdress");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    protected void input(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}
