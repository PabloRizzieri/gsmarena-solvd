import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class MainTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Specifying the location of the Chrome Driver
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Close the driver after each test
        driver.quit();
    }
}
