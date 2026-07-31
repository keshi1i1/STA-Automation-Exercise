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
        clear(checkoutPageElements.inputOrderComment);
        sendKeys(checkoutPageElements.inputOrderComment, comment);
    }

    public void clickPlaceOrderButton() {
        logger.info("Click 'Place Order' button");
        click(checkoutPageElements.btnPlaceOrder);
    }

    public void verifyDeliveryAddress(String firstName, String lastName, String address1, String city, String state, String zipcode, String country) {
        logger.info("Verify delivery address matches registration details");
        assertElementIsDisplayed("//ul[@id='address_delivery']//li[contains(text(),'" + address1 + "')]");
        assertElementIsDisplayed("//ul[@id='address_delivery']//li[contains(text(),'" + city + "')]");
        assertElementIsDisplayed("//ul[@id='address_delivery']//li[contains(text(),'" + country + "')]");
    }

    public void verifyBillingAddress(String firstName, String lastName, String address1, String city, String state, String zipcode, String country) {
        logger.info("Verify billing address matches registration details");
        assertElementIsDisplayed("//ul[@id='address_invoice']//li[contains(text(),'" + address1 + "')]");
        assertElementIsDisplayed("//ul[@id='address_invoice']//li[contains(text(),'" + city + "')]");
        assertElementIsDisplayed("//ul[@id='address_invoice']//li[contains(text(),'" + country + "')]");
    }
}