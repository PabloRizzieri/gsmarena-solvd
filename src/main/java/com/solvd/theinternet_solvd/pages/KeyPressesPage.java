package com.solvd.theinternet_solvd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeyPressesPage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@id='target']")
    private WebElement input;

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement getInput(){
        return input;
    }

    public void clickInput(){
        input.click();
    }

    public void randomWord(){
        input.sendKeys("r","a","n","d","o","m");
    }

    public String getInputText(){
        return input.getAttribute("value");
    }

}
