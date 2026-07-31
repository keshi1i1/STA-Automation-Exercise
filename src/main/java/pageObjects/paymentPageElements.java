package pageObjects;

public interface paymentPageElements {

    // Payment form fields
    String inputNameOnCard = "//input[@name='name_on_card']";
    String inputCardNumber = "//input[@name='card_number']";
    String inputCVC = "//input[@name='cvc']";
    String inputExpiryMonth = "//input[@name='expiry_month']";
    String inputExpiryYear = "//input[@name='expiry_year']";

    // Pay and Confirm Order button
    String btnPayAndConfirmOrder = "//button[@id='submit']";

    // Order placed success message
    String txtOrderPlacedSuccessMessage = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]";

    // Download Invoice button
    String btnDownloadInvoice = "//a[contains(text(),'Download Invoice')]";

    // Continue button after order
    String btnContinue = "//a[normalize-space()='Continue']";
}