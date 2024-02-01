package com.solvd.theinternet_solvd.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the upload button.
     */
    public void clickUploadButton() {
        this.driver.findElement(uploadButton).click();
    }

    /**
     * Uploads a file by providing its absolute path.
     *
     * @param absolutePathOfFile The absolute path of the file to upload.
     */
    public void uploadFile(String absolutePathOfFile) {
        this.driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    /**
     * Gets the text of the uploaded files section.
     * @return The text of the uploaded files section.
     */
    public String getUploadedFiles() {
        return this.driver.findElement(uploadFiles).getText();
    }
}

