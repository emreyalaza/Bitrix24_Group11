package automation.tests;


import automation.pages.AbstractPageBase;
import automation.pages.event.ActivityStreamPageForEvent;
import automation.pages.event.EventPage;
import automation.pages.login.LoginPage;
import automation.tests.AbstractTestBase;
import automation.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventTestPart2 extends AbstractTestBase {



        /**
         * 6. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.

         Test steps:
         1- Login page
         2- click "event" under activity stream
         3- click visual editor "A"
         */

        @Test
        public void textbarDisplay(){
            LoginPage login=new LoginPage();
            EventPage eventPage=new EventPage();
            ActivityStreamPageForEvent activityStreamPageForEvent =new ActivityStreamPageForEvent();
            login.defaultLogin();
            eventPage.navigateOnTopMenu("Event");
            eventPage.clickVisualEditor();

        }


    /**
     * 7. User should be able to add Event start and ending date and time, and specify the time zone.
     *
     *          Test steps:
     *          1- Login page
     *          2- click "event" under activity stream
     *          3- click "Event will start on"
     */
          @Test
         public void timeArrangement(){

        LoginPage login=new LoginPage();
        EventPage eventPage=new EventPage();
        ActivityStreamPageForEvent activityStreamPageForEvent =new ActivityStreamPageForEvent();
        login.defaultLogin();
        eventPage.navigateOnTopMenu("Event");
        eventPage.clickStartDate();
        eventPage.setTimeForm();
        eventPage.specifyZone();


         }

         /** 8. User should be able to set reminder by entering the timeing. */


         @Test
       public void setReminder(){

             LoginPage login=new LoginPage();
             EventPage eventPage=new EventPage();
             ActivityStreamPageForEvent activityStreamPageForEvent =new ActivityStreamPageForEvent();
             login.defaultLogin();
             eventPage.navigateOnTopMenu("Event");
             eventPage.setReminder();
             eventPage.setReminder();
             eventPage.setTimeForReminder();
             eventPage.setRemindType();

         }


        /**
         9. User should be able to select event location from dropdown.*/

        @Test
    public void eventLocation(){

            LoginPage login=new LoginPage();
            EventPage eventPage=new EventPage();
            ActivityStreamPageForEvent activityStreamPageForEvent =new ActivityStreamPageForEvent();
            login.defaultLogin();
            eventPage.navigateOnTopMenu("Event");

            eventPage.selectEventLocation();




        }



     // 10. User should be able to add attendees by selecting contacts individually or adding groups and departments.
    //  11. User should be able to click on More to specify the event details.


    @Test
        public void addPerson(){

            LoginPage login=new LoginPage();
            EventPage eventPage=new EventPage();
            ActivityStreamPageForEvent activityStreamPageForEvent =new ActivityStreamPageForEvent();
            login.defaultLogin();
            eventPage.navigateOnTopMenu("Event");
            eventPage.addAllEmployeesToEvent();
           eventPage.clickMore();


        }

    }


