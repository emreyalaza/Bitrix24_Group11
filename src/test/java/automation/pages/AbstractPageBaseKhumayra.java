package automation.pages;

import automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class will be extended by page classess
 * All common webElements/Locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicgtaed page class to store
 * elements form that menu
 */
public class AbstractPageBaseKhumayra {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);
    protected Actions actions;
    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;


    public AbstractPageBaseKhumayra(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void navigateTo (String tabName ){
        String tabXpath = String.format("//span[text()='%s']",tabName);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath))).click();
    }

}
