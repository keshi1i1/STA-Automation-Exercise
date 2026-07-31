package pageObjects;

public interface homePageElements {
    
    // Signup/Login Tab
    String tabSignupLogin = "//a[normalize-space()='Signup / Login']";

    // Delete Account Tab
    String tabDeleteAccount = "//a[normalize-space()='Delete Account']";

    // Products Tab
    String tabProducts = "//a[@href='/products']";

    // Product card wrapper on home page - insert index
    String productWrapper = "(//div[@class='product-image-wrapper'])[";

    // View Product
    String btnViewProduct = "(//div[@class='product-image-wrapper'])[INDEX]//a[contains(text(),'View Product')]";

    // Cart Tab (nav bar)
    String tabCart = "//a[@href='/view_cart']";

    // Logout Tab
    String tabLogout = "//a[@href='/logout']";

    // Category panel header
    String linkCategoryPanel = "//div[@class='panel-group category-products']//a[@href='#CATEGORY_PANEL']";

    // Sub-category link (expanded category panel)
    String linkSubCategory = "//div[@id='CATEGORY_PANEL']//a[normalize-space()='SUBCATEGORY_NAME']";

    // Recommended items
    String txtRecommendedItems = "//h2[normalize-space()='recommended items']";
    String btnAddToCartRecommended = "(//div[@class='recommended_items']//a[contains(@class,'add-to-cart')])[1]";
    String btnViewCartRecommended = "//u[normalize-space()='View Cart']";

    // Scroll up arrow button
    String btnScrollUp = "//div[@id='scrollUp']";

    // Hero text visible after scroll up
    String txtHeroHeader = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]";
}