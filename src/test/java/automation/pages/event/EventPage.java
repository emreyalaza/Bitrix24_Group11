package automation.pages.event;

import automation.pages.AbstractPageBase;
import automation.utilities.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class EventPage extends AbstractPageBase {

    @FindBy(css = "[placeholder='Event name']")
    private WebElement eventNameField;
    @FindBy(css = "#bx-html-editor-area-cnt-oCalEditorcal_3Jcl>div>iframe" )
    private WebElement textAreaFrame;
    @FindBy(tagName = "body")
    private WebElement textArea;
    @FindBy(css = "[id='bx-b-link-blogPostForm_calendar']>span")
    private WebElement addLink;


    @FindBy(css = "#bx-b-video-blogPostForm_calendar>span")
    private WebElement insertVideo;
    @FindBy(id="video_oCalEditorcal_3Jcl-source")
    private WebElement videoSourceField;
    @FindBy(id = "video_oCalEditorcal_3Jcl-title")
    private WebElement videoTitle;
    @FindBy(id = "undefined")
    private WebElement saveButton;


    @FindBy(id = "linkoCalEditorcal_3Jcl-text")
    private WebElement linkTextField;
    @FindBy(id = "linkoCalEditorcal_3Jcl-href")
    private WebElement linkURLField;
    @FindBy(id="blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(xpath = "//span[@id='lhe_button_editor_blogPostForm_calendar']")
    private WebElement visualEditor;


    @FindBy(xpath = "//input[@id='feed-cal-event-fromcal_3Jcl']")
    private WebElement startDate;
    @FindBy(xpath = "//input[contains(@name,'TIME_FROM_')]")
    private WebElement timeForm;
    @FindBy(xpath = "//input[@value='Set Time']")
    private WebElement setTime;
    @FindBy(xpath = "    //input[@id='feed-cal-event-tocal_3Jcl']")
    private WebElement endDate;
    @FindBy(xpath = "//input[@name='TIME_TO_']")
    private WebElement endTimeForm;
    @FindBy(xpath = "/html[1]/body[1]/div[8]/div[2]/input[1]")
    private WebElement endSetTime;
    @FindBy(xpath = "//input[contains(@name,'EVENT_FULL_DAY')]")
    private WebElement allDay;
    @FindBy(xpath = "//span[@class='feed-ev-tz-open']")
    private WebElement specifyTimeZone;
    @FindBy(id = "feed-cal-tz-fromcal_3Jcl")
    private WebElement firstSpecifyZone;
    @FindBy(id= "feed-cal-tz-tocal_3Jcl")
    private WebElement secondSpecifyZone;

    @FindBy(xpath = "//input[@class='feed-event-rem-ch']")
    private WebElement setReminder;
    @FindBy(xpath = "//input[@class='calendar-inp']")
    private WebElement timeForReminder;
    @FindBy(xpath = "//select[@class='calendar-select']")
    private WebElement remindType;

    @FindBy(xpath = "//input[@class='calendar-inp calendar-inp-time calendar-inp-loc']")
    private WebElement eventLocation;

    @FindBy(xpath = "//label[@for='event-locationcal_3Jcl'][contains(.,'Event location')]")
    private WebElement evenLocationPopUp;


    @FindBy(xpath = "//div[@class='bxecpl-loc-popup calendar-inp calendar-inp-time calendar-inp-loc']")
    private  WebElement room;


    @FindBy(id="feed-event-dest-add-link")
    private WebElement addMembersLink;
    @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name'][contains(.,'To all employees')]")
    private WebElement allEmployees;
    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    private WebElement popupClose;

    @FindBy( xpath = "//span[@class='feed-event-more-link-text']")
    private WebElement more;




    public void addAllEmployeesToEvent(){
        BrowserUtils.wait(3);

        addMembersLink.click();
        BrowserUtils.wait(3);
        allEmployees.click();
        BrowserUtils.wait(3);
        popupClose.click();
    }


    public void clickMore(){
        BrowserUtils.wait(3);
          more.click();
        BrowserUtils.wait(3);

    }





      public void selectEventLocation(){
          BrowserUtils.wait(2);
          eventLocation.click();
            BrowserUtils.wait(2);
          List<WebElement> dropdownList= driver.findElements(By.xpath("//div[@class='bxecpl-loc-popup calendar-inp calendar-inp-time calendar-inp-loc']"));
          for (WebElement room : dropdownList) {
              if (room.getText().equalsIgnoreCase("East Meeting Room")){
                  room.click();
              }
              BrowserUtils.wait(4);
              evenLocationPopUp.click();
              BrowserUtils.wait(2);



          }
      }


        public void setReminder(){

        BrowserUtils.wait(2);
        setReminder.click();
        BrowserUtils.wait(2);


    }
        public void setTimeForReminder(){

        BrowserUtils.wait(2);
        timeForReminder.clear();
        BrowserUtils.wait(2);
        timeForReminder.sendKeys("1");
        BrowserUtils.wait(2);


}

    public void setRemindType(){

    BrowserUtils.wait(2);
    Select type=new Select(remindType);
       type.selectByVisibleText("hours");
}

    public void specifyZone(){
        specifyTimeZone.click();
        BrowserUtils.wait(2);
        wait.until(ExpectedConditions.visibilityOf(firstSpecifyZone)) .click();
        BrowserUtils.wait(2);
        wait.until(ExpectedConditions.visibilityOf(secondSpecifyZone)).click();
        BrowserUtils.wait(2);

    }


       public void clickAllDay(){

        allDay.click();
       }


    public void clickStartDate() {
          wait.until(ExpectedConditions.visibilityOf(startDate)).isSelected();

               BrowserUtils.wait(2);

              startDate.click();
          }

          public void setTimeForm(){
              timeForm.click();
              BrowserUtils.wait(2);
              setTime.click();
              BrowserUtils.wait(2);
              endDate.click();
              BrowserUtils.wait(2);
              endTimeForm.click();
              BrowserUtils.wait(2);
               endSetTime.click();
              BrowserUtils.wait(2);


          }


    public void clickVisualEditor(){
        wait.until(ExpectedConditions.visibilityOf(visualEditor)).click();
        BrowserUtils.wait(4);
    }




    public void setEventName(String eventName){
        wait.until(ExpectedConditions.visibilityOf(eventNameField)).sendKeys(eventName);
    }

    public void setEventText(String text){
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(textAreaFrame));
        driver.switchTo().frame(textAreaFrame);
        textArea.sendKeys(text);
        driver.switchTo().parentFrame();
    }

    public void addLinkToEvent(String linkText, String linkURL){
        wait.until(ExpectedConditions.elementToBeClickable(addLink)).click();
        wait.until(ExpectedConditions.visibilityOf(linkTextField));
        linkTextField.sendKeys(linkText);
        linkURLField.sendKeys(linkURL+ Keys.ENTER);
    }

    public void insertVideoToEvent(String videoURL){
        wait.until(ExpectedConditions.elementToBeClickable(insertVideo)).click();
        wait.until(ExpectedConditions.visibilityOf(videoSourceField)).sendKeys(videoURL);
        //wait.until(ExpectedConditions.visibilityOf(videoTitle));
        saveButton.click();

    }

    public void saveEvent(){

        sendButton.click();
    }



}
