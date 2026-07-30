package pageObjects;

public interface cartPageElements {

    // Subscription Header Text
    String txtSubscriptionHeader = "//h2[normalize-space()='Subscription']";

    // Subscription Email Input
    String inputSubscribeEmail = "//input[@id='susbscribe_email']";

    // Subscribe Arrow Button
    String btnSubscribeArrow = "//button[@id='subscribe']";

    // Subscription Success Message
    String txtSubscriptionSuccessMessage = "//div[@id='success-subscribe']//div[contains(@class,'alert-success')]";

    // Cart table row - insert index
    String cartRow = "(//tbody/tr)[";

    // Proceed To Checkout button
    String btnProceedToCheckout = "//a[normalize-space()='Proceed To Checkout']";

    // Register or Login
    String linkRegisterLogin = "//div[@class='modal-content']//a[normalize-space()='Register / Login']";

    // Remove ("X") button
    String btnRemoveProduct = "//a[@class='cart_quantity_delete']";
}