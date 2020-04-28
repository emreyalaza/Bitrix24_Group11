package automation.tests;


import automation.pages.login.LoginPage;
import automation.utilities.BrowserUtils;
import automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestBase {

    static WebDriver driver  = Driver.getDriver();
    LoginPage loginPage = new LoginPage();


    @Test
    public void loginTest1() {

        test=report.createTest("login");

    loginPage.defaultLogin();
      BrowserUtils.wait(3);
       // loginPage.navigateTo("Activity Stream");
      //  System.out.println(loginPage.pageSubtitle());
      //  System.out.println("Current user: " + loginPage.getCurrentUserName());
        loginPage.searchBar("Contact info");

    }
}
