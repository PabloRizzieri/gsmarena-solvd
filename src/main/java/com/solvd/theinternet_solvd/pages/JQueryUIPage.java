package com.solvd.theinternet_solvd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JQueryUIPage {
    
    private WebDriver driver;
    private By title = By.cssSelector(".example h3");
    private By menuLink = By.linkText("Menu");

    public JQueryUIPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    /**
     * Navigate to the JQuery UI Menu page
     */
    public JQueryUIMenuPage clickJQueryUIMenu() {
        driver.findElement(menuLink).click();
        return new JQueryUIMenuPage(driver);
    }
}
