import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private WebDriver driver;
    private By columnA= By.id("column-a");//Create the By element of the div left block in screen
    private By columnB= By.id("column-b");//Create the By element of the div right block in screen
    private By pageTitle= By.cssSelector("div>h3");//Create the By element of the title

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveBlockAtoBlockB(){
        //Create the action element to perform the movement of the mouse
        Actions actions =new Actions(driver);
        //Create the web elements of the column-a and column-b div
        WebElement columnAWebElement=driver.findElement(columnA);
        WebElement columnBWebElement=driver.findElement(columnB);
        //Drag Block A and drop it in Block B
        actions.dragAndDrop(columnAWebElement,columnBWebElement);
        //Perform the actions given
        actions.perform();
    }

    public void moveBlockBtoBlockA(){
        //Create the action element to perform the movement of the mouse
        Actions actions =new Actions(driver);
        //Create the web elements of the column-a and column-b div
        WebElement columnAWebElement=driver.findElement(columnA);
        WebElement columnBWebElement=driver.findElement(columnB);
        //Drag Block A and drop it in Block B
        actions.dragAndDrop(columnBWebElement,columnAWebElement);
        //Perform the actions given
        actions.perform();
    }

    //Return the text inside the column-a header
    public String getColumnABlockName(){
        return driver.findElement(columnA).getText();
    }

    //Return the text inside the column-b header
    public String getColumnBBlockName(){
        return driver.findElement(columnB).getText();
    }
    //Return the page tittle
    public String getPageTittle(){
        return driver.findElement(pageTitle).getText();
    }
}
