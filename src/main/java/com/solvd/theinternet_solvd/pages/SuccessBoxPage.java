package com.solvd.theinternet_solvd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessBoxPage {
    WebDriver driver;
    By box = By.id("flash");
    public SuccessBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage () {
        return driver.findElement(box).getText();
    }
}
