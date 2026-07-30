package pageObjects;

public interface productDetailPageElements {

    // Product Information section
    String txtProductInformation = "//div[@class='product-information']";

    // Quantity input field
    String inputQuantity = "//input[@id='quantity']";

    // Add to cart button
    String btnAddToCart = "//button[contains(@class,'cart') and contains(.,'Add to cart')]";

    // View Cart
    String btnViewCart = "//u[normalize-space()='View Cart']";
}