package com.mygodoc.app.pages;

import com.github.javafaker.Faker;
import com.mygodoc.app.pages.login.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class BasePage {


    @Value("${app.url}")
    private String appUrl;

    @Autowired
    public WebDriver driver;

    @Autowired
    public WebDriverWait wait;

    @Autowired
    public Faker faker;

    @Autowired
    LoginPage loginPage;

    @PostConstruct
    public void init(){
        PageFactory.initElements(driver, this);
    }

    public LoginPage launchApplication(){
        driver.navigate().to(appUrl);
        waitForPageToLoad();
        return loginPage;
    }

    public BasePage closeApplication(){
        waitForPageToLoad();
        driver.close();
        driver.quit();
        return this;
    }

    public BasePage waitForPageToLoad() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until((ExpectedCondition) webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equalsIgnoreCase("complete")
                || ((Boolean) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0")));
        return this;
    }

}
