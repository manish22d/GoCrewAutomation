package com.mygodoc.app.pages.login;

import com.mygodoc.app.pages.BasePage;
import com.mygodoc.app.pages.admin.AdminDashboardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginPage extends BasePage {

    @Value("${userId}")
    private String email;

    @Value("${pwd}")
    private String pwd;

    @Autowired
    AdminDashboardPage dashboardPage;

    @FindBy(name = "email")
    WebElement emailTextbox;

    @FindBy(name = "password")
    WebElement passwordTextbox;

    @FindBy(css = "button.MuiButton-contained")
    WebElement loginBtn;

    public AdminDashboardPage login(){
        wait.until(elementToBeClickable(emailTextbox));
        wait.until(visibilityOf(emailTextbox));
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(pwd);
        loginBtn.click();
        waitForPageToLoad();
        return dashboardPage;
    }
}
