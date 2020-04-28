package automation.tests;

import automation.pages.workflow.WorkFlowPage;
import automation.pages.login.LoginPage;
import org.testng.annotations.Test;

public class WorkflowTest extends AbstractTestBase {

    /**
     * 8. As a user, I should be able to create
     * and send workflows by selecting different workflows
     * from "More" tab under Activity Stream.
     */

    /**
     * Test steps:
     * 1- Login with Marketing credential
     * 2- Click to more
     * 3- Click to Workflow
     * 4-
     */


    @Test
    public void workFlowTest() {


        LoginPage loginPage = new LoginPage();
      //  loginPage.login("");

        WorkFlowPage work=new WorkFlowPage();

      //   work.navigateToTab("Workflow");
      //  work.navigateToSubModule("Leave Approval");
       //  work.ClosePopUp();

        // work.clickstartDate();
        // work.clickendDate();
        // work.chooseAbsenceType();
       //  work.reasonForLeaveText();
        // work.clickSenButton();












    }
}
