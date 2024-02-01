package com.solvd.theinternet_solvd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage {
    private WebDriver driver;

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement getInput(){
        return driver.findElement(By.xpath("//input[@id='target']"));
    }

    public void clickInput(){
        WebElement input = getInput();
        input.click();
    }

    public void randomWord(){
        WebElement input = getInput();
        input.sendKeys("r");

        input.sendKeys("a");
        input.sendKeys("n");
        input.sendKeys("d");
        input.sendKeys("o");
        input.sendKeys("m");
    }

    public String getInputText(){
        WebElement input = getInput();
        return input.getAttribute("value");
    }

}
