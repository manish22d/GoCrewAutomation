package com.mygodoc.app.pages.clinic;

import com.mygodoc.app.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
public class PatientManagementPage extends BasePage {

    @FindBy(xpath = "//*[@class='topRoundedRegion'][.//h4[contains(text(),'All patients')]]/div/div/div/div/span[1]")
    List<WebElement> patients;

    @FindBy(xpath="//*[@class='topRoundedRegion'][.//h4[contains(text(),'Patient details')]]/div[2]/div/div/h4")
    WebElement patientName;

    @FindBy(xpath=".//h5[contains(text(),'Phone')]/following-sibling::h5[1]")
    WebElement patientPhoneNumber;

    @FindBy(xpath=".//h5[contains(text(),'Email')]/following-sibling::h5[1]")
    WebElement patientEmail;

    @FindBy(xpath = "//h4[contains(text(),'All patients')]/following-sibling::button")
    WebElement addPatientBtn;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "phone")
    WebElement phone;

    @FindBy(name = "email")
    WebElement email;

    public List<String> getPatientList() {
        wait.until(visibilityOfAllElements(patients));
        return patients.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public PatientManagementPage selectPatient(String patientName){
        wait.until(visibilityOfAllElements(patients));
        patients.stream().filter(patient->patientName.equalsIgnoreCase(patient.getText())).findFirst().orElseThrow(null).click();
        waitForPageToLoad();
        return this;
    }

    public String getPatientName(){
        wait.until(visibilityOf(patientName));
        return patientName.getText();
    }

    public PatientManagementPage addPatient(){
        wait.until(visibilityOf(addPatientBtn));
        addPatientBtn.click();
        wait.until(visibilityOf(firstName));
        String name = faker.funnyName().name();
        firstName.sendKeys(name.split(" ")[0]);
        lastName.sendKeys(name.split(" ")[1]);
        phone.click();
        phone.sendKeys(faker.phoneNumber().cellPhone());
        email.sendKeys("abc@gmail.com");
        waitForPageToLoad();
        return this;
    }
}
