package com.mygodoc.app.tests;

import com.mygodoc.app.listener.TestListener;
import com.mygodoc.app.pages.BasePage;
import com.mygodoc.app.pages.admin.AdminDashboardPage;
import com.mygodoc.app.pages.login.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    LoginPage loginPage;

    @Autowired
    AdminDashboardPage dashboardPage;

    @BeforeSuite(alwaysRun = true)
    protected void setupWebDriver() throws Exception {
        super.springTestContextPrepareTestInstance();
        dashboardPage = loginPage.launchApplication().login();
        logger.info("****** Before Suite Setup ******");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        loginPage.closeApplication();
        logger.info("****** Tear Down Setup ******");
        logger.info("****** Suite Tear Down ******");
    }




}
