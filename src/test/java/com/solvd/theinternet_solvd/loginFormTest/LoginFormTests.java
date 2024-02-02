package com.solvd.theinternet_solvd.loginFormTest;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.solvd.theinternet_solvd.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginFormTests extends BaseTest {

    Properties prop = new Properties();


    {
        try (InputStream inputStream = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
