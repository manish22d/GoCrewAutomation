package com.mygodoc.app.listener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mygodoc.app.report.ExtentManager;
import com.mygodoc.app.report.ExtentTestManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener implements ITestListener {
    @Autowired
    private WebDriver webDriver;
    private TestStatus testStatus;
//    private ResultSender rs= new ResultSender();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
//        ExtentTestManager.startTest(iTestContext.getName(), "");
        iTestContext.setAttribute("WebDriver", this.webDriver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        this.testStatus = new TestStatus();
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        this.sendStatus(iTestResult,"PASS");
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            if (this.webDriver != null) {
                //        this.sendStatus(iTestResult,"FAIL");
                saveScreenshotPNG();
                System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
                Object testClass = iTestResult.getInstance();

                String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).
                        getScreenshotAs(OutputType.BASE64);
                ExtentTestManager.getTest().log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
//        this.sendStatus(iTestResult,"SKIP");
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "0", type = "text/plain")
    public static String saveTextLogs(String message) {
        return message;
    }
//    private void sendStatus(ITestResult iTestResult, String status){
//        this.testStatus.setTestClass(iTestResult.getTestClass().getName());
//        this.testStatus.setDescription(iTestResult.getMethod().getDescription());
//        this.testStatus.setStatus(status);
//        this.testStatus.setExecutionDate(LocalDateTime.now().toString());
//        rs.send(this.testStatus);
//    }
}
