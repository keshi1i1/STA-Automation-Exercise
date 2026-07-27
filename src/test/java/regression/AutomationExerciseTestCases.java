package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeoutException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.accountCreatedPageEvents;
import pageEvents.deleteAccountPageEvents;
import pageEvents.homePageEvents;
import pageEvents.signupLoginPageEvents;
import pageEvents.signupPageEvents;

public class AutomationExerciseTestCases extends BaseTest {
    String browser;

    // Add another variable if you want to store another list of data (...registerDetails, anotherVariable;)
    Dictionary<String, String> registerDetails;

    homePageEvents homePage = new homePageEvents();
    signupLoginPageEvents signupLoginPage = new signupLoginPageEvents();
    signupPageEvents signupPage = new signupPageEvents();
    accountCreatedPageEvents accountCreatedPage = new accountCreatedPageEvents();
    deleteAccountPageEvents deleteAccountPage = new deleteAccountPageEvents();

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void prepareReport(@Optional("chrome") String browser) {
        this.browser = browser;
        beforeTestMethod(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method testMethod) throws TimeoutException{
        initializeBrowser(browser, testMethod);
    }

    @Test(priority = 1)
    public void tc_01_registerNewUser() {
        registerDetails = new Hashtable<>();
        registerDetails.put("name", "AutoTest" + generate4Digit());
        registerDetails.put("email", registerDetails.get("name").toLowerCase() + "@example.com");
        registerDetails.put("password", "Password" + generate4Digit());
        registerDetails.put("day", "6");
        registerDetails.put("month", "January");
        registerDetails.put("year", "2005");
        registerDetails.put("firstName", "AutoTest");
        registerDetails.put("lastName", registerDetails.get("name").replaceAll("[^0-9]", ""));
        registerDetails.put("company", "Example Inc.");
        registerDetails.put("address1", "123 Main St");
        registerDetails.put("address2", "Apt 4B");
        registerDetails.put("country", "United States");
        registerDetails.put("state", "New York");
        registerDetails.put("city", "New York");
        registerDetails.put("zipcode", "10001");
        registerDetails.put("mobileNumber", "+1 (555) 019-9941");

        homePage.verifyHomePage();
        homePage.clickSignupLoginTab();
        signupLoginPage.verifyNewUserSignupHeader();
        signupLoginPage.registerNewUser(registerDetails);
        signupPage.verifyEnterAccountInformationHeader();
        signupPage.registerUserInformation(registerDetails);
        accountCreatedPage.verifyAccountCreatedHeader();
        accountCreatedPage.clickContinueButton();
        homePage.verifyLoggedInAs(registerDetails.get("name"));
        homePage.clickDeleteAccountTab();
        deleteAccountPage.verifyAccountDeletedHeader();
        deleteAccountPage.clickContinueButton();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        afterMethod(result, browser);
    }
}
