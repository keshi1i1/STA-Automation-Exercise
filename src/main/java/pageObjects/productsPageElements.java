package pageObjects;

public interface productsPageElements {

    // All Products page header
    String txtAllProductsHeader = "//h2[normalize-space()='All Products']";

    // Product card wrapper
    String productWrapper = "(//div[@class='product-image-wrapper'])[";

    // Add to cart
    String btnAddToCart = "(//div[@class='product-image-wrapper'])[INDEX]//a[contains(text(),'Add to cart')]";

    // Modal shown (Add to cart)
    String btnContinueShopping = "//button[normalize-space()='Continue Shopping']";
    String btnViewCart = "//u[normalize-space()='View Cart']";
}