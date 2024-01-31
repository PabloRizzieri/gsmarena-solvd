import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class DragAndDropTest {

    WebDriver driver;

    @BeforeMethod
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setupTest(){
        driver = new ChromeDriver();
        //Accessing the page to test
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }

    @Test
    public void getPageTitle(){
        DragAndDropPage dragAndDropPage=new DragAndDropPage(driver);
        Assert.assertEquals(dragAndDropPage.getPageTittle(),"Drag and Drop"
                ,"Wrong page title name");
    }

    @Test(description = "Drag block A in screen and drop into block B position",priority = 1)
    public void moveBlockAtoBlockB(){
        //Creating a new Drag and drop page objects to use method in the class
        DragAndDropPage dragAndDropPage=new DragAndDropPage(driver);
        //Using the method to click and drag block A in screen and drop into block B position
        dragAndDropPage.moveBlockAtoBlockB();
        //Check if the block name has changed in the column-a element(left block)
        Assert.assertEquals(dragAndDropPage.getColumnABlockName(),"B"
                ,"Some error occurred during drag and drop expected 'B'");
        //Check if the block name has changed in the column-b element(right block)
        Assert.assertEquals(dragAndDropPage.getColumnBBlockName(),"A"
                ,"Some error occurred during drag and drop, expected 'A'");
        System.out.println();
    }

    @Test(description = "Drag block B in screen and drop into block A position", priority = 2)
    public void moveBlockBtoBlockA(){
        //Creating a new Drag and drop page objects to use method in the class
        DragAndDropPage dragAndDropPage=new DragAndDropPage(driver);
        //Using the method to click and drag block B in screen and drop into block A position
        dragAndDropPage.moveBlockBtoBlockA();
        //Check if the block name has changed in the column-b element(right block)
        Assert.assertEquals(dragAndDropPage.getColumnBBlockName(),"B"
                ,"Some error occurred during drag and drop expected 'B'");
        //Check if the block name has changed in the column-a element(left block)
        Assert.assertEquals(dragAndDropPage.getColumnABlockName(),"A"
                ,"Some error occurred during drag and drop, expected 'A'");
    }

}
