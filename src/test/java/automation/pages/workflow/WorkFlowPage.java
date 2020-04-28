package automation.pages.workflow;

import automation.pages.AbstractPageBase;
import automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WorkFlowPage extends AbstractPageBase {


    @FindBy(className = "webform-small-button webform-button-cancel")
    private WebElement closePopUp;

    @FindBy(name = "PROPERTY_86[n0][VALUE]")
    private WebElement startDate;

    @FindBy(xpath = "//table[@class='bx-lists-table-content']//tr[2]//span[@class='bx-lists-calendar-icon']")
    private WebElement clickStartDate;

    @FindBy (name = "PROPERTY_87[n0][VALUE]")
    private WebElement endDate;

    @FindBy(xpath = "//table[@class='bx-lists-table-content']//tr[3]//span[@class='bx-lists-calendar-icon']\n")
    private WebElement clickEndDate;

    @FindBy(xpath = "//select[@name='PROPERTY_88']")
    private WebElement absenceType;

    @FindBy(name = "PREVIEW_TEXT")
    private WebElement reasonForLeaveText;


    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(id = "blog-submit-button-cancel")
    private WebElement cancelButton;

    @FindBy(className = "bx-lists-iblock-description")
    private WebElement blockDescription;

    @FindBy(className = "bx-lists-table-td-title")
    private WebElement leaveApprovalTitle;

    @FindBy(className = "bx-lists-block-errors")
    private WebElement errorMessage;

    public void navigateToSubModule(String workflowModule) {
        BrowserUtils.wait(2);
        String subModuleXPath = "//span[@class='menu-popup-item-text' and contains(text(),'" + workflowModule + "')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(subModuleXPath))).click();
    }


    public void ClosePopUp() {
        BrowserUtils.wait(4);
        closePopUp.click();
        BrowserUtils.wait(2);

    }

    public void clickstartDate() {
        BrowserUtils.wait(2);
       startDate.click();
        BrowserUtils.wait(2);
        clickStartDate.click();
        BrowserUtils.wait(2);


    }

    public void clickendDate() {
        BrowserUtils.wait(2);
        endDate.click();
        BrowserUtils.wait(2);
        clickEndDate.click();
    }

    public void chooseAbsenceType() {
        BrowserUtils.wait(2);
        Select chooseAbsenceType = new Select((WebElement) absenceType);
        chooseAbsenceType.selectByIndex(90);


    }

    public void reasonForLeaveText() {
        BrowserUtils.wait(2);
        reasonForLeaveText.sendKeys("covid19", Keys.ENTER);
    }

    public void clickSenButton() {
        sendButton.click();
        BrowserUtils.wait(2);
    }


    public String errorMessage() {
        BrowserUtils.wait(2);
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();

    }


}