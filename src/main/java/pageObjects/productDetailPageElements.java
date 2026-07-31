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

    // Review section
    String txtWriteYourReview = "//a[normalize-space()='Write Your Review']";
    String inputReviewName = "//input[@id='name']";
    String inputReviewEmail = "//input[@id='email']";
    String inputReviewText = "//textarea[@id='review']";
    String btnSubmitReview = "//button[@id='button-review']";
    String txtReviewSuccessMessage = "//div[@class='alert-success alert']//span[contains(text(),'Thank you for your review.')]";

}