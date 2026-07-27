package pageEvents;

import base.BaseTest;
import pageObjects.accountCreatedPageElements;

public class accountCreatedPageEvents extends BaseTest {

    public void verifyAccountCreatedHeader() {
        logger.info("Verify that 'ACCOUNT CREATED!' is visible");
        assertElementIsDisplayed(accountCreatedPageElements.hdrAccountCreated);
    }
    
    public void clickContinueButton() {
        logger.info("Click 'Continue' button");
        click(accountCreatedPageElements.btnContinue);
    }
}