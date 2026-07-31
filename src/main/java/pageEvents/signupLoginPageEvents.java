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

    public void verifyEmailAlreadyExistsError() {
        logger.info("Verify error 'Email Address already exist!' is visible");
        assertElementIsDisplayed(signupLoginPageElements.hdrEmailAlreadyExists);
    }

    public void verifyLoginToYourAccountHeader() {
        logger.info("Verify 'Login to your account' is visible");
        assertElementIsDisplayed(signupLoginPageElements.hdrLoginToYourAccount);
    }

    public void loginUser(@SuppressWarnings("rawtypes") Dictionary loginDetails) {

        // Fill up login form
        logger.info("Enter correct email address and password");
        clear(signupLoginPageElements.txtLoginEmail);
        sendKeys(signupLoginPageElements.txtLoginEmail, loginDetails.get("email").toString());

        clear(signupLoginPageElements.txtLoginPassword);
        sendKeys(signupLoginPageElements.txtLoginPassword, loginDetails.get("password").toString());

        // Click 'Login' button
        logger.info("Click 'Login' button");
        click(signupLoginPageElements.btnLogin);
    }

    public void loginUserWithInvalidCredentials() {

        // Fill up login form
        logger.info("Enter incorrect email address and password");
        clear(signupLoginPageElements.txtLoginEmail);
        sendKeys(signupLoginPageElements.txtLoginEmail, "invalidemail@example.com");

        clear(signupLoginPageElements.txtLoginPassword);
        sendKeys(signupLoginPageElements.txtLoginPassword, "InvalidPassword");

        // Click 'Login' button
        logger.info("Click 'Login' button");
        click(signupLoginPageElements.btnLogin);

        // Verify error message is displayed
        logger.info("Verify error 'Your email or password is incorrect!' is visible");
        assertElementIsDisplayed(signupLoginPageElements.hdrInvalidEmailOrPassword);
    }
}