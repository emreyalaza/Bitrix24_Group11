package automation.pages;

import automation.utilities.BrowserUtils;
import automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public abstract class AbstractPageBase {

    protected WebDriver driver= Driver.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driver, 20);


    @FindBy(xpath = "//span[@class='user-name']")
    protected WebElement currentUser;

    @FindBy(className = "header-search-input")
    protected WebElement searchBar;






    public AbstractPageBase(){

        PageFactory.initElements(driver,this);
    }


    public void navigateTo(String moduleName){

        String moduleXpath="//span[@class='menu-item-link-text'  and contains(text(),'" + moduleName + "')]";

        WebElement module= driver.findElement(By.xpath(moduleXpath));

        // it is for hidden modules under more
        if(moduleName.equals("Applications") || moduleName.equals("Workflows")){
            WebElement more=driver.findElement(By.xpath("//span[@class='menu-favorites-more-text']"));
            more.click();
            wait.until(ExpectedConditions.elementToBeClickable(module)).click();


        }else{
            module.click();
        }

    }

    //to  navigate modules under Activity Stream
    public void navigateToTab(String tabName) {
        if (tabName.equals("File") || tabName.equals("Appreciation") ||
                tabName.equals("Announcement") || tabName.equals("Workflow")) {
            WebElement more = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text' and contains(text(),'More')]"));
            more.click();
            BrowserUtils.wait(3);
            WebElement subModule=driver.findElement(By.xpath("//span[@class='menu-popup-item-text' and contains(text(),'"+tabName+"')]"));
            subModule.click();
        } else {
            String tabXpath = "//span[@class='feed-add-post-form-link']//span[text()='" + tabName + "']";
            WebElement tab = driver.findElement(By.xpath(tabXpath));

            tab.click();
        }
    }








    public String pageSubtitle() {
            WebElement subtitle = Driver.getDriver().findElement(By.id("pagetitle"));
            wait.until(ExpectedConditions.visibilityOf(subtitle));

            String subTitleText = subtitle.getText();
            return subTitleText;


        }
        public String getCurrentUserName () {
            BrowserUtils.waitForPageToLoad(10);
            wait.until(ExpectedConditions.visibilityOf(currentUser));
            return currentUser.getText().trim();
        }
        public void searchBar (String searchText){

            BrowserUtils.waitForPageToLoad(10);
            wait.until(ExpectedConditions.visibilityOf(searchBar));
            searchBar.sendKeys(searchText);
            searchBar.click();

        }
        public void more (String moreOption){
            BrowserUtils.waitForPageToLoad(10);
            WebElement more = driver.findElement(By.xpath(moreOption));
            wait.until(ExpectedConditions.elementToBeClickable(more));
            more.click();

        }

        public void navigateOnTopMenu (String tabName){
            String tabXpath = "//div[@id='feed-add-post-form-tab']//span[text()='" + tabName + "']";
            WebElement tabElement = driver.findElement(By.xpath(tabXpath));
            wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();
        }


    }

