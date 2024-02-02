package com.solvd.theinternet_solvd.keyPresses;

import com.solvd.theinternet_solvd.BaseTest;
import com.solvd.theinternet_solvd.pages.KeyPressesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyPressesTest extends BaseTest {
    private KeyPressesPage keyPressesPage;

    @BeforeMethod
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
        keyPressesPage.clearInput();
    }

    @Test
    public void successfulRandomTest2(){
        keyPressesPage.clickInput();
        keyPressesPage.randomWord();
        String inputText = keyPressesPage.getInputText();
        Assert.assertEquals(inputText, "random");
        keyPressesPage.clearInput();
    }
}
