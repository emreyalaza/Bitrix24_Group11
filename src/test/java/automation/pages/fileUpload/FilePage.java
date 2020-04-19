package automation.pages.fileUpload;

import automation.pages.AbstractPageBase;
import automation.utilities.BrowserUtils;
import automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePage extends AbstractPageBase {




    @FindBy(xpath = "(//span[@class ='menu-popup-item-text'])[1]")
    private WebElement fileTab;

    @FindBy(xpath = "//span[@class ='menu-popup-item-text']")
    private WebElement tabsUnderMore;

    @FindBy(xpath = "//span[contains(@id,'feed-add-post-form-link-text')]")
    private WebElement more;




    public void getTabsOnMore(String tabName) {


        BrowserUtils.waitForPageToLoad(15);
     wait.until(ExpectedConditions.elementToBeClickable(more)).click();
     WebElement element = Driver.getDriver().findElement(By.xpath("(//span[@class ='menu-popup-item-text'])[" + tabName + "]"));

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();


    }

//Method that verifies a file is downloaded.

    public boolean isFileDownloaded(String path, String filename) {

        return Files.exists(Paths.get(path, filename));
    }

    public static File createTempFile(String prefix, String suffix, File directory) {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("hello", ".tmp");
        } catch (IOException e) {

        }
        System.out.println("Temp file On Default Location: " + tempFile.getAbsolutePath());
        try {
            tempFile = File.createTempFile("hello", ".tmp", new File("C:/"));
        } catch (IOException e) {

        }
      return tempFile;
    }}