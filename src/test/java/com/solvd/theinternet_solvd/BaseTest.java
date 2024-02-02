package com.solvd.theinternet_solvd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupClass(){
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
