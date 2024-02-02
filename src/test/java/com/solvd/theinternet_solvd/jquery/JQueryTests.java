package com.solvd.theinternet_solvd.jquery;

import com.solvd.theinternet_solvd.BaseTest;
import com.solvd.theinternet_solvd.pages.JQueryUIMenuPage;
import com.solvd.theinternet_solvd.pages.JQueryUIPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryTests extends BaseTest {

    @BeforeMethod
    public void setupTest() {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
    }

    @Test(description = "Verify if the 'Back to JQuery UI' link on the JQuery UI Menu correctly navigates back to the main JQuery UI page")
    public void testBackToJQueryUiPage() {
        JQueryUIMenuPage jQueryUIMenuPage = new JQueryUIMenuPage(driver);
        String titleJQueryUIMenu = jQueryUIMenuPage.getTitle();
        JQueryUIPage jQueryUIPage = jQueryUIMenuPage.clickBackToJQueryUI();
        String titleJQueryUI = jQueryUIPage.getTitle();

        Assert.assertEquals(titleJQueryUIMenu,
                "JQueryUI - Menu",
                "Title incorrect");
        Assert.assertEquals(titleJQueryUI,
                "JQuery UI",
                "Title incorrect");
    }
}
