package com.mygodoc.app.pages.clinic;

import com.mygodoc.app.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
public class TriageDashboardPage extends BasePage {
    @FindBy(xpath= "//div[@class='topRoundedCard'][./h4[contains(text(),'Waiting')]]")
    WebElement waitingSection;

    @FindBy(xpath= "//div[@class='topRoundedCard'][./h4[contains(text(),'Active')]]")
    WebElement activeSection;

    public boolean isWaitingSectionDisplayed(){
        wait.until(visibilityOf(waitingSection));
        return waitingSection.isDisplayed();
    }

    public boolean isActiveSectionDisplayed(){
        wait.until(visibilityOf(activeSection));
        return activeSection.isDisplayed();
    }
}
