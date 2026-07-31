package pageObjects;

public interface signupLoginPageElements {
    
    // Header 
    String hdrNewUserSignup = "//h2[normalize-space()='New User Signup!']";
    String hdrLoginToYourAccount = "//h2[normalize-space()='Login to your account']";
    String hdrInvalidEmailOrPassword = "//p[normalize-space()='Your email or password is incorrect!']";
    String hdrEmailAlreadyExists = "//p[normalize-space()='Email Address already exist!']";

    // Signup Form
    String txtSignupName = "//input[@placeholder='Name']";
    String txtSignupEmail = "//input[@data-qa='signup-email']";
    String btnSignup = "//button[normalize-space()='Signup']";

    // Login Form
    String txtLoginEmail = "//input[@data-qa='login-email']";
    String txtLoginPassword = "//input[@data-qa='login-password']";
    String btnLogin = "//button[normalize-space()='Login']";
}
