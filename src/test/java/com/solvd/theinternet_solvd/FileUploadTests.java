package com.solvd.theinternet_solvd;
import com.solvd.theinternet_solvd.pages.FileUploadPage;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.testng.Assert.assertEquals;

public class FileUploadTests extends MainTest {
    private FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setupTest() {
        // Set up Chrome WebDriver
        driver.get("https://the-internet.herokuapp.com/upload");
        fileUploadPage = new FileUploadPage(driver);
    }

    /**
     * Test to verify file upload functionality.
     * @throws IOException If an I/O error occurs when loading properties.
     */
    @Test(description = "Verify file upload functionality")
    public void verifyFileUploadValidTest() {
        // Load the properties file
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            // Get the file path from the properties file
            String workingDir = System.getProperty("user.dir");
            String filePath = workingDir + prop.getProperty("file.path");
            String fileExpected = prop.getProperty("file.expected");
            // Perform file upload
            //fileUploadPage = new FileUploadPage(driver);
            fileUploadPage.uploadFile(filePath);
            // Verify uploaded file
            assertEquals(fileUploadPage.getUploadedFiles(),
                    fileExpected,
                    "Uploaded files incorrect!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Test to verify that no file uploaded results in an error message.
     */
    @Test(description = "Verify error message when no file uploaded")
    public void verifyFileUploadInvalidTest() {
        // Perform upload without selecting any file
        //this.fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.clickUploadButton();
        // Verify error message when no file uploaded
        assertEquals(driver.getTitle(),
                "",
                "File is not upload");

    }
}