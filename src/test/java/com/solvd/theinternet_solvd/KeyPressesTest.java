package com.solvd.theinternet_solvd;

import com.solvd.theinternet_solvd.pages.KeyPressesPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyPressesTest extends MainTest{
    private KeyPressesPage keyPressesPage;
    @Override
    public void setupTest(){
        driver.get("https://the-internet.herokuapp.com/key_presses");
        keyPressesPage = new KeyPressesPage(driver);
    }

    @Test
    public void successfulRandomTest(){
        keyPressesPage.clickInput();
        keyPressesPage.randomWord();
        String inputText = keyPressesPage.getInputText();
        Assert.assertEquals(inputText, "random");
    }
}
