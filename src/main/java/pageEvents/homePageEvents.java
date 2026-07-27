package pageEvents;

import base.BaseTest;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest {

    public void verifyHomePage() {
        logger.info("Verify that home page is visible successfully");
        assertPageIsDisplayed("https://automationexercise.com/");
    }
    
    public void clickSignupLoginTab() {
        logger.info("Click on 'Signup / Login' button");
        click(homePageElements.tabSignupLogin);
    }

    public void clickDeleteAccountTab() {
        logger.info("Click 'Delete Account' button");
        click(homePageElements.tabDeleteAccount);
    }

    public void verifyLoggedInAs(String name) {
        logger.info("Verify that 'Logged in as " + name + "' is visible");
        assertElementIsDisplayed("//a[contains(., 'Logged in as')]/b[text()='" + name + "']");
    }
}
