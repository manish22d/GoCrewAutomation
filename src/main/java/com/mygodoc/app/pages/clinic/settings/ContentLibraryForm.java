package com.mygodoc.app.pages.clinic.settings;

import com.mygodoc.app.annotations.Form;
import com.mygodoc.app.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Form
public class ContentLibraryForm extends BasePage {

    @FindBy(name = "businessName")
    WebElement businessName;

    public void fillForm() {
    }
}
