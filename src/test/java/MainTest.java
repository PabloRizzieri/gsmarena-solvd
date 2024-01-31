import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class MainTest {

    WebDriver driver;

    @BeforeMethod
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setupTest(){
        driver = new ChromeDriver();
    }

    @AfterTest
    void teardown(){
        driver.quit();
    }

    @Test
    void test(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String tittle = driver.getTitle();

        Assert.assertTrue(tittle.contains("Selenium WebDriver"));
    }

}
