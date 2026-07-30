package pageObjects;

public interface checkoutPageElements {

    // Address Details section header
    String txtAddressDetailsHeader = "//h2[contains(text(),'Address Details')]";

    // Review Your Order section header
    String txtReviewOrderHeader = "//h2[contains(text(),'Review Your Order')]";

    // Order comment textarea
    String inputOrderComment = "//textarea[@name='message']";

    // Place Order button
    String btnPlaceOrder = "//a[normalize-space()='Place Order']";
}