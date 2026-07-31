package pageEvents;

import java.util.Dictionary;

import base.BaseTest;
import pageObjects.contactUsPageElements;

public class contactUsPageEvents extends BaseTest {
    
    public void verifyGetInTouchHeader() {
        logger.info("Verify 'GET IN TOUCH' is visible");
        assertElementIsDisplayed(contactUsPageElements.hdrGetInTouch);
    }

    public void fillContactUsForm(@SuppressWarnings("rawtypes") Dictionary contactDetails) {

        // Fill up contact us form
        logger.info("Enter name, email, subject and message");
        clear(contactUsPageElements.txtContactName);
        sendKeys(contactUsPageElements.txtContactName, contactDetails.get("contactName").toString());

        clear(contactUsPageElements.txtContactEmail);
        sendKeys(contactUsPageElements.txtContactEmail, contactDetails.get("contactEmail").toString());

        clear(contactUsPageElements.txtContactSubject);
        sendKeys(contactUsPageElements.txtContactSubject, contactDetails.get("contactSubject").toString());

        clear(contactUsPageElements.txtContactMessage);
        sendKeys(contactUsPageElements.txtContactMessage, contactDetails.get("contactMessage").toString());

        // Upload test file
        logger.info("Upload file");
        uploadTestFile(contactUsPageElements.btnUploadFile);

        // Click 'Submit' button
        logger.info("Click 'Submit' button");
        click(contactUsPageElements.btnSubmit);

        // Click 'OK' on alert
        logger.info("Click 'OK' button");
        acceptAlert();
    }

    public void verifySuccessMessage() {
        logger.info("Verify success message 'Success! Your details have been submitted successfully.' is visible");
        assertElementIsDisplayed(contactUsPageElements.hdrSuccessMessage);
    }

    public void clickHomeTab() {
        logger.info("Click 'Home' button and verify that landed to home page successfully");
        click(contactUsPageElements.tabHome);
        assertPageIsDisplayed("https://automationexercise.com/");
    }
}
