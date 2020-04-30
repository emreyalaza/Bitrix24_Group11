package automation.tests;


import automation.pages.event.ActivityStreamPageForEvent;
import automation.pages.event.EventPagepPart2;
import automation.pages.login.LoginPage;
import automation.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventTestPart2 extends AbstractTestBase {

    LoginPage login=new LoginPage();
    EventPagepPart2 eventPage=new EventPagepPart2();
    ActivityStreamPageForEvent activityStreamPageForEvent =new ActivityStreamPageForEvent();


    // 6. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.



        @Test
        public void textbarDisplay(){

            login.defaultLogin();
            eventPage.navigateOnTopMenu("Event");
            eventPage.clickVisualEditor();

            Assert.assertTrue(eventPage.toolbar.isDisplayed());



        }

     // 7. User should be able to add Event start and ending date and time, and specify the time zone.

          @Test
         public void timeArrangement(){


        login.defaultLogin();
        eventPage.navigateOnTopMenu("Event");
        eventPage.clickStartDate();
        eventPage.setTimeForm();
        eventPage.specifyZone();
        Assert.assertTrue(eventPage.startDate.isDisplayed());
        Assert.assertTrue(eventPage.timeForm.isDisplayed());
        Assert.assertTrue(eventPage.endDate.isDisplayed());
        Assert.assertTrue(eventPage.endTimeForm.isDisplayed());
        Assert.assertTrue(eventPage.firstSpecifyZone.isDisplayed());
        Assert.assertTrue(eventPage.secondSpecifyZone.isDisplayed());


         }

         /** 8. User should be able to set reminder by entering the timeing. */


         @Test
       public void setReminder(){

             login.defaultLogin();
             eventPage.navigateOnTopMenu("Event");
             eventPage.setReminder();
             eventPage.setReminder();
             eventPage.setTimeForReminder();
           Assert.assertTrue(eventPage.timeForReminder.isEnabled());
           Assert.assertTrue(eventPage.remindType.getText().contains("hours"));

         }


        /**
         9. User should be able to select event location from dropdown.*/

        @Test
    public void eventLocation(){


            login.defaultLogin();
            eventPage.navigateOnTopMenu("Event");
            eventPage.selectEventLocation();
            BrowserUtils.wait(2);
            Assert.assertTrue(eventPage.eventLocation.isDisplayed());



        }



     // 10. User should be able to add attendees by selecting contacts individually or adding groups and departments.
    //  11. User should be able to click on More to specify the event details.


    @Test
        public void addPerson(){


            login.defaultLogin();
            eventPage.navigateOnTopMenu("Event");
            eventPage.addAllEmployeesToEvent();
           eventPage.clickMore();
           Assert.assertTrue(eventPage.addMembersLink.isDisplayed());
           Assert.assertTrue(eventPage.more.isEnabled());


        }

    }


