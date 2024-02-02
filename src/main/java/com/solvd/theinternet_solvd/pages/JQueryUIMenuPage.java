package com.solvd.theinternet_solvd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryUIMenuPage {
    
    private WebDriver driver;
    private By title = By.cssSelector(".example h3");
    private By enabledOption = By.id("ui-id-3");
    private By backToJQueryUiOption = By.id("ui-id-8");

    public JQueryUIMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    /**
     * Navigate in the JQuery menu from the "Enabled" to "Back to JQuery UI" button and perform the action
     */
    public JQueryUIPage clickBackToJQueryUI() {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        WebElement enabledOptionElement = driver.findElement(enabledOption);
        WebElement backToJQueryUiOptionElement = driver.findElement(backToJQueryUiOption);

        actions.moveToElement(enabledOptionElement)
                .build()
                .perform();
        wait.until(ExpectedConditions.visibilityOf(backToJQueryUiOptionElement));
        wait.until(ExpectedConditions.elementToBeClickable(backToJQueryUiOptionElement));
        actions.moveToElement(backToJQueryUiOptionElement)
                .click()
                .build()
                .perform();

        return new JQueryUIPage(driver);
    }
}
