package com.mygodoc.app.pages.clinic.settings;

import com.github.javafaker.Faker;
import com.mygodoc.app.annotations.Form;
import com.mygodoc.app.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Form
public class BusinessInformationForm extends BasePage {
    @Autowired
    Faker faker;

    @FindBy(name = "businessName")
    WebElement businessName;

    @FindBy(name = "contactName")
    WebElement contactName;

    @FindBy(name = "phoneNumber")
    WebElement phoneNumber;

    @FindBy(name = "billingEmail")
    WebElement billingEmail;

    @FindBy(name = "address1")
    WebElement address1;

    @FindBy(name = "address2")
    WebElement address2;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "zip")
    WebElement zip;

    @FindBy(name = "singleProvider")
    WebElement singleProvider;

    @FindBy(css = "span.MuiButton-label")
    WebElement updateBtn;

    @Step
    public void fillForm(){
        waitForPageToLoad();
        wait.until(visibilityOf(contactName));
        contactName.sendKeys(faker.funnyName().name());
        phoneNumber.click();
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        billingEmail.sendKeys("test@gmail.com");
        address1.sendKeys(faker.address().streetAddress());
        address2.sendKeys(faker.address().secondaryAddress());
        city.sendKeys(faker.address().city());
        state.sendKeys(faker.address().state());
        zip.sendKeys(faker.address().zipCode());
    }

}
