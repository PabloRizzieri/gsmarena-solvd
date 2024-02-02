package com.solvd.theinternet_solvd.loginFormTest;

import com.solvd.theinternet_solvd.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginFormTests extends BaseTest {

    Properties prop = new Properties();

    /*
     * This block loads the propesties from config.properties file
     * */
    {
        try (InputStream inputStream = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUpTest(){
        driver.get("https://the-internet.herokuapp.com/login");
    }



}
