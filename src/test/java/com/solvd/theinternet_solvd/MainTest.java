package com.solvd.theinternet_solvd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public abstract class MainTest {

    WebDriver driver;

    @BeforeClass
    void setupClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    abstract void setupTest();

    @AfterTest
    void tearDown(){
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
