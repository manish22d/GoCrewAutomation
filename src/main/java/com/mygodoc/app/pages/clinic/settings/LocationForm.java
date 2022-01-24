package com.mygodoc.app.pages.clinic.settings;

import com.mygodoc.app.annotations.Form;
import com.mygodoc.app.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Form
public class LocationForm extends BasePage {

    @FindBy(name = "name")
    WebElement locationName;

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

    @FindBy(name = "phoneNumber")
    WebElement phoneNumber;

    @FindBy(css = "button[type='submit']")
    WebElement saveLocation;

    @FindBy(css = "button[type='button']")
    WebElement finished;

    public void fillForm() {
        waitForPageToLoad();
        wait.until(visibilityOf(locationName));
        locationName.sendKeys(faker.name().username());
        phoneNumber.click();
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        address1.sendKeys(faker.address().streetAddress());
        address2.sendKeys(faker.address().secondaryAddress());
        city.sendKeys(faker.address().city());
        state.sendKeys(faker.address().state());
        zip.sendKeys(faker.address().zipCode());
    }
}
