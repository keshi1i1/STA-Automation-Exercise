package pageEvents;

import base.BaseTest;
import pageObjects.checkoutPageElements;

public class checkoutPageEvents extends BaseTest {

    public void verifyAddressDetailsIsVisible() {
        logger.info("Verify Address Details is visible");
        assertElementIsDisplayed(checkoutPageElements.txtAddressDetailsHeader);
    }

    public void verifyReviewOrderIsVisible() {
        logger.info("Verify Review Your Order is visible");
        assertElementIsDisplayed(checkoutPageElements.txtReviewOrderHeader);
    }

    public void enterOrderComment(String comment) {
        logger.info("Enter description '" + comment + "' in comment text area");
        sendKeys(checkoutPageElements.inputOrderComment, comment);
    }

    public void clickPlaceOrderButton() {
        logger.info("Click 'Place Order' button");
        click(checkoutPageElements.btnPlaceOrder);
    }
}