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

    // Delivery address fields
    String txtDeliveryFirstLastName = "//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']";
    String txtDeliveryAddress1 = "(//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[1]";
    String txtDeliveryCity = "//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']";
    String txtDeliveryCountry = "//ul[@id='address_delivery']//li[@class='address_country_name']";

    // Billing address fields
    String txtBillingFirstLastName = "//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']";
    String txtBillingAddress1 = "(//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[1]";
    String txtBillingCity = "//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']";
    String txtBillingCountry = "//ul[@id='address_invoice']//li[@class='address_country_name']";
}