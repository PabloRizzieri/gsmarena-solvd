package com.solvd.theinternet_solvd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public abstract class MainTest {

   protected WebDriver driver;

    @BeforeClass
    protected void setupClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    protected abstract void setupTest();

    @AfterTest
    protected void tearDown(){
        driver.quit();
    }

//    @Test
//    void test(){
//        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
//        String tittle = driver.getTitle();
//
//        Assert.assertTrue(tittle.contains("Selenium WebDriver"));
//    }

}
