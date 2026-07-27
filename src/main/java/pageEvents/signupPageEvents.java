package pageEvents;

import java.util.Dictionary;
import java.util.Random;

import base.BaseTest;
import pageObjects.signupPageElements;

public class signupPageEvents extends BaseTest {

    Random rnd = new Random();
    signupLoginPageEvents signupLoginPage = new signupLoginPageEvents();
    
    public void verifyEnterAccountInformationHeader() {
        logger.info("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        assertElementIsDisplayed(signupPageElements.hdrEnterAccountInformation);
    }

    public void registerUserInformation(@SuppressWarnings("rawtypes") Dictionary registerDetails) {

        // Fill up account information
        logger.info("Fill details: Title, Name, Email, Password, Date of birth");
        int rndTitle = rnd.nextInt(2);
        switch (rndTitle) {
            case 0:
                click(signupPageElements.rdnGenderMale);
                break;
            case 1:
                click(signupPageElements.rdnGenderFemale);
                break;
        }

        clear(signupPageElements.txtName);
        sendKeys(signupPageElements.txtName, registerDetails.get("name").toString());

        clear(signupPageElements.txtPassword);
        sendKeys(signupPageElements.txtPassword, registerDetails.get("password").toString());

        clear(signupPageElements.slcDay);
        sendKeys(signupPageElements.slcDay, registerDetails.get("day").toString());

        clear(signupPageElements.slcMonth);
        sendKeys(signupPageElements.slcMonth, registerDetails.get("month").toString());

        clear(signupPageElements.slcYear);
        sendKeys(signupPageElements.slcYear, registerDetails.get("year").toString());

        // Check newsletter and special offers
        logger.info("Select checkbox 'Sign up for our newsletter!'");
        click(signupPageElements.chkNewsletter);

        logger.info("Select checkbox 'Receive special offers from our partners!'");
        click(signupPageElements.chkSpecialOffers);

        // Fill up address information
        logger.info("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        clear(signupPageElements.txtFirstName);
        sendKeys(signupPageElements.txtFirstName, registerDetails.get("firstName").toString());

        clear(signupPageElements.txtLastName);
        sendKeys(signupPageElements.txtLastName, registerDetails.get("lastName").toString());

        clear(signupPageElements.txtCompany);
        sendKeys(signupPageElements.txtCompany, registerDetails.get("company").toString());

        clear(signupPageElements.txtAddress1);
        sendKeys(signupPageElements.txtAddress1, registerDetails.get("address1").toString());

        clear(signupPageElements.txtAddress2);
        sendKeys(signupPageElements.txtAddress2, registerDetails.get("address2").toString());

        clear(signupPageElements.slcCountry);
        sendKeys(signupPageElements.slcCountry, registerDetails.get("country").toString());

        clear(signupPageElements.txtState);
        sendKeys(signupPageElements.txtState, registerDetails.get("state").toString());

        clear(signupPageElements.txtCity);
        sendKeys(signupPageElements.txtCity, registerDetails.get("city").toString());

        clear(signupPageElements.txtZipcode);
        sendKeys(signupPageElements.txtZipcode, registerDetails.get("zipcode").toString());

        clear(signupPageElements.txtMobileNumber);
        sendKeys(signupPageElements.txtMobileNumber, registerDetails.get("mobileNumber").toString());

        // Click 'Create Account' button
        logger.info("Click 'Create Account' button");
        click(signupPageElements.btnCreateAccount);
    }
}