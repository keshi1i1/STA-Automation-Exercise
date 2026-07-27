package pageObjects;

public interface signupPageElements {
    
    // Header
    String hdrEnterAccountInformation = "//b[normalize-space()='Enter Account Information']";

    // Account Information
    String rdnGenderMale = "//input[@id='id_gender1']";
    String rdnGenderFemale = "//input[@id='id_gender2']";
    String txtName = "//input[@id='name']";
    String txtPassword = "//input[@id='password']";
    String slcDay = "//select[@id='days']";
    String slcMonth = "//select[@id='months']";
    String slcYear = "//select[@id='years']";
    String chkNewsletter = "//input[@id='newsletter']";
    String chkSpecialOffers = "//input[@id='optin']";

    // Address Information
    String txtFirstName = "//input[@id='first_name']";
    String txtLastName = "//input[@id='last_name']";
    String txtCompany = "//input[@id='company']";
    String txtAddress1 = "//input[@id='address1']";
    String txtAddress2 = "//input[@id='address2']";
    String slcCountry = "//select[@id='country']";
    String txtState = "//input[@id='state']";
    String txtCity = "//input[@id='city']";
    String txtZipcode = "//input[@id='zipcode']";
    String txtMobileNumber = "//input[@id='mobile_number']";
    String btnCreateAccount = "//button[normalize-space()='Create Account']";
}
