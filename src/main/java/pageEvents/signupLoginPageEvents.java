package pageEvents;

import java.util.Dictionary;

import base.BaseTest;
import pageObjects.signupLoginPageElements;

public class signupLoginPageEvents extends BaseTest {

    homePageEvents homePage = new homePageEvents();
    
    public void verifyNewUserSignupHeader() {
        logger.info("Verify 'New User Signup!' is visible");
        assertElementIsDisplayed(signupLoginPageElements.hdrNewUserSignup);
    }

    public void registerNewUser(@SuppressWarnings("rawtypes") Dictionary registerDetails) {

        // Fill up signup form
        logger.info("Enter name and email address");
        clear(signupLoginPageElements.txtSignupName);
        sendKeys(signupLoginPageElements.txtSignupName, registerDetails.get("name").toString());

        clear(signupLoginPageElements.txtSignupEmail);
        sendKeys(signupLoginPageElements.txtSignupEmail, registerDetails.get("email").toString());

        // Click 'Signup' button
        logger.info("Click 'Signup' button");
        click(signupLoginPageElements.btnSignup);
    }
}