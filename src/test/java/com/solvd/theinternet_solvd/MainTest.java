package com.solvd.theinternet_solvd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public abstract class MainTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setupTest();
    }

    @BeforeTest
    abstract void setupTest();

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
