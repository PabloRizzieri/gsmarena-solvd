package com.solvd.theinternet_solvd.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.xpath("//button[@type=\"submit\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public SuccessBoxPage fulfillFormAndClickSubmit (String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);

        driver.findElement(submit).click();
        return new SuccessBoxPage(driver);
    }

    public SuccessBoxPage fulfillFormAndPressEnter (String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass + Keys.ENTER);

        return new SuccessBoxPage(driver);
    }



}