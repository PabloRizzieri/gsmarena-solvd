package com.solvd.theinternet_solvd.loginFormTest;

import com.solvd.theinternet_solvd.BaseTest;
import com.solvd.theinternet_solvd.pages.LoginPage;
import com.solvd.theinternet_solvd.pages.SuccessBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

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

    /*
    * Data Provider: picks data from prop
    * It contains the {username, password, typeOfError}
    * */
    @DataProvider(name = "provider")
    public Object[][] provider() {
        return new Object[][]{
                {prop.getProperty("WUSER01"), prop.getProperty("WPASS01"), "bothWrong"},
                {prop.getProperty("WUSER02"), prop.getProperty("WPASS02"), "bothWrong"},
                {prop.getProperty("GUSER01"), prop.getProperty("WPASS03"), "passWrong"},
                {prop.getProperty("WUSER02"), prop.getProperty("GPASS01"), "userWrong"}
        };
    }

    @Test(description = "This test will try to login with the correct credentials")
    public void correctCredentialsLoginTest() {
        LoginPage login = new LoginPage(driver);
        SuccessBoxPage success = login.fulfillFormAndClickSubmit(prop.getProperty("GUSER01"), prop.getProperty("GPASS01"));
        //This eliminates the child's text content
        String correctedText = success.getMessage().split("\n")[0];
        assertEquals(correctedText, "You logged into a secure area!");
    }

    @Test(description = "This test will try to login with the correct credentials and without clicking submit button but pressing ENTER key")
    public void correctCredentialsLoginTestButPressingEnter() {
        LoginPage login = new LoginPage(driver);
        SuccessBoxPage success = login.fulfillFormAndPressEnter(prop.getProperty("GUSER01"), prop.getProperty("GPASS01"));
        //This eliminates the child's text content
        String correctedText = success.getMessage().split("\n")[0];
        assertEquals(correctedText, "You logged into a secure area!");
    }

    @Test(description = "This text will use correct credentials but in capital letters")
    public void correctCredentialsAndLogOut() {
        LoginPage login = new LoginPage(driver);
        SuccessBoxPage success = login.fulfillFormAndPressEnter(prop.getProperty("GUSER01"), prop.getProperty("GPASS01"));
        success.logOut();
       
        //This eliminates the child's text content
        String correctedText = success.getMessage().split("\n")[0];
        assertEquals(correctedText, "You logged out of the secure area!");
    }
    @Test(description = "This text will use correct credentials but in capital letters")
    public void uppercaseCheckingTest() {
        LoginPage login = new LoginPage(driver);
        SuccessBoxPage successMessage = login.fulfillFormAndClickSubmit(prop.getProperty("GUSER01").toUpperCase(), prop.getProperty("GPASS01").toUpperCase());
        String correctedText = successMessage.getMessage().split("\n")[0];
        assertEquals(correctedText, "Your username is invalid!");
    }

    @Test(description = "This test will try to login with wrong credentials", dataProvider = "provider")
    public void incorrectCredentialsLoginTest(String user, String pass, String caseType) {
        LoginPage login = new LoginPage(driver);
        SuccessBoxPage successMessage = login.fulfillFormAndClickSubmit(user, pass);
        //This eliminates the child's text content
        String correctedText = successMessage.getMessage().split("\n")[0];
        switch (caseType) {
            case "bothWrong", "userWrong":
                assertEquals(correctedText, "Your username is invalid!");
                break;
            case "passWrong":
                assertEquals(correctedText, "Your password is invalid!");
                break;
        }
    }
}
