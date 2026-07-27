package pageObjects;

public interface signupLoginPageElements {
    
    // Header 
    String hdrNewUserSignup = "//h2[normalize-space()='New User Signup!']";

    // Signup Form
    String txtSignupName = "//input[@placeholder='Name']";
    String txtSignupEmail = "//input[@data-qa='signup-email']";
    String btnSignup = "//button[normalize-space()='Signup']";
}
