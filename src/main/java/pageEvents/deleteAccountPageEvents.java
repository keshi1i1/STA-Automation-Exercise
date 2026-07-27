package pageEvents;

import base.BaseTest;
import pageObjects.deleteAccountPageElements;

public class deleteAccountPageEvents extends BaseTest {

    public void verifyAccountDeletedHeader() {
        logger.info("Verify that 'ACCOUNT DELETED!' is visible");
        assertElementIsDisplayed(deleteAccountPageElements.hdrAccountDeleted);
    }
    
    public void clickContinueButton() {
        logger.info("Click 'Continue' button");
        click(deleteAccountPageElements.btnContinue);
    }
}