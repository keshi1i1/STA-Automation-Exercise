package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeoutException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.accountCreatedPageEvents;
import pageEvents.cartPageEvents;
import pageEvents.deleteAccountPageEvents;
import pageEvents.homePageEvents;
import pageEvents.signupLoginPageEvents;
import pageEvents.signupPageEvents;
import pageEvents.productsPageEvents;
import pageEvents.productDetailPageEvents;
import pageEvents.checkoutPageEvents;
import pageEvents.paymentPageEvents;
import pageEvents.categoryPageEvents;


public class AutomationExerciseTestCases extends BaseTest {
    String browser;

    // Add another variable if you want to store another list of data (...registerDetails, anotherVariable;)
    Dictionary<String, String> registerDetails;

    homePageEvents homePage = new homePageEvents();
    signupLoginPageEvents signupLoginPage = new signupLoginPageEvents();
    signupPageEvents signupPage = new signupPageEvents();
    accountCreatedPageEvents accountCreatedPage = new accountCreatedPageEvents();
    deleteAccountPageEvents deleteAccountPage = new deleteAccountPageEvents();
    cartPageEvents cartPage = new cartPageEvents();
    productsPageEvents productsPage = new productsPageEvents();
    productDetailPageEvents productDetailPage = new productDetailPageEvents();
    checkoutPageEvents checkoutPage = new checkoutPageEvents();
    paymentPageEvents paymentPage = new paymentPageEvents();
    categoryPageEvents categoryPage = new categoryPageEvents();

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void prepareReport(@Optional("chrome") String browser) {
        this.browser = browser;
        beforeTestMethod(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method testMethod) throws TimeoutException{
        initializeBrowser(browser, testMethod);
    }

    @Test(priority = 1)
    public void tc_01_registerNewUser() {
        registerDetails = new Hashtable<>();
        registerDetails.put("name", "AutoTest" + generate4Digit());
        registerDetails.put("email", registerDetails.get("name").toLowerCase() + "@example.com");
        registerDetails.put("password", "Password" + generate4Digit());
        registerDetails.put("day", "6");
        registerDetails.put("month", "January");
        registerDetails.put("year", "2005");
        registerDetails.put("firstName", "AutoTest");
        registerDetails.put("lastName", registerDetails.get("name").replaceAll("[^0-9]", ""));
        registerDetails.put("company", "Example Inc.");
        registerDetails.put("address1", "123 Main St");
        registerDetails.put("address2", "Apt 4B");
        registerDetails.put("country", "United States");
        registerDetails.put("state", "New York");
        registerDetails.put("city", "New York");
        registerDetails.put("zipcode", "10001");
        registerDetails.put("mobileNumber", "+1 (555) 019-9941");

        homePage.verifyHomePage();
        homePage.clickSignupLoginTab();
        signupLoginPage.verifyNewUserSignupHeader();
        signupLoginPage.registerNewUser(registerDetails);
        signupPage.verifyEnterAccountInformationHeader();
        signupPage.registerUserInformation(registerDetails);
        accountCreatedPage.verifyAccountCreatedHeader();
        accountCreatedPage.clickContinueButton();
        homePage.verifyLoggedInAs(registerDetails.get("name"));
        homePage.clickDeleteAccountTab();
        deleteAccountPage.verifyAccountDeletedHeader();
        deleteAccountPage.clickContinueButton();
    }

    @Test(priority = 11)
    public void tc_11_verifySubscriptionInCartPage() {
        homePage.verifyHomePage();
        cartPage.scrollToFooter();
        cartPage.verifySubscriptionText();
        cartPage.enterSubscriptionEmail("autotest" + generate4Digit() + "@example.com");
        cartPage.clickSubscribeArrowButton();
        cartPage.verifySubscriptionSuccessMessage();
    }

    @Test(priority = 12)
    public void tc_12_addProductsInCart() {
        homePage.verifyHomePage();
        homePage.clickProductsTab();
        productsPage.verifyAllProductsHeader();
        productsPage.hoverAndAddProductToCart(1);
        productsPage.clickContinueShoppingButton();
        productsPage.hoverAndAddProductToCart(2);
        productsPage.clickViewCartButton();
        cartPage.verifyProductInCart(1, "Blue Top");
        cartPage.verifyProductInCart(2, "Men Tshirt");
        cartPage.verifyPriceQuantityAndTotal(1);
        cartPage.verifyPriceQuantityAndTotal(2);
    }

    @Test(priority = 13)
    public void tc_13_verifyProductQuantityInCart() {
        homePage.verifyHomePage();
        homePage.clickViewProduct(1);

        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.setProductQuantity(4);
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();

        cartPage.verifyProductQuantityInCart(1, 4);
    }

    @Test(priority = 14)
    public void tc_14_placeOrderRegisterWhileCheckout() {
        registerDetails = new Hashtable<>();
        registerDetails.put("name", "AutoTest" + generate4Digit());
        registerDetails.put("email", registerDetails.get("name").toLowerCase() + "@example.com");
        registerDetails.put("password", "Password" + generate4Digit());
        registerDetails.put("day", "6");
        registerDetails.put("month", "January");
        registerDetails.put("year", "2005");
        registerDetails.put("firstName", "AutoTest");
        registerDetails.put("lastName", registerDetails.get("name").replaceAll("[^0-9]", ""));
        registerDetails.put("company", "Example Inc.");
        registerDetails.put("address1", "123 Main St");
        registerDetails.put("address2", "Apt 4B");
        registerDetails.put("country", "United States");
        registerDetails.put("state", "New York");
        registerDetails.put("city", "New York");
        registerDetails.put("zipcode", "10001");
        registerDetails.put("mobileNumber", "+1 (555) 019-9941");

        homePage.verifyHomePage();
        homePage.clickViewProduct(1); // reuse hover, or swap for a home-page add-to-cart if you prefer
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();

        cartPage.verifyCartPageIsDisplayed();

        cartPage.clickProceedToCheckout();
        cartPage.clickRegisterLoginLink();

        signupLoginPage.verifyNewUserSignupHeader();
        signupLoginPage.registerNewUser(registerDetails);
        signupPage.verifyEnterAccountInformationHeader();
        signupPage.registerUserInformation(registerDetails);

        accountCreatedPage.verifyAccountCreatedHeader();
        accountCreatedPage.clickContinueButton();

        homePage.verifyLoggedInAs(registerDetails.get("name"));

        homePage.clickCartTab();
        cartPage.verifyCartPageIsDisplayed();
        cartPage.clickProceedToCheckout();

        checkoutPage.verifyAddressDetailsIsVisible();
        checkoutPage.verifyReviewOrderIsVisible();

        checkoutPage.enterOrderComment("Please deliver in the morning if possible.");
        checkoutPage.clickPlaceOrderButton();

        paymentPage.enterPaymentDetails("AutoTest Tester", "4111111111111111", "123", "12", "2028");
        paymentPage.clickPayAndConfirmOrderButton();

        paymentPage.verifyOrderPlacedSuccessMessage();

        homePage.clickDeleteAccountTab();
        deleteAccountPage.verifyAccountDeletedHeader();
        deleteAccountPage.clickContinueButton();
    }

    @Test(priority = 15)
    public void tc_15_placeOrderRegisterBeforeCheckout() {
        registerDetails = new Hashtable<>();
        registerDetails.put("name", "AutoTest" + generate4Digit());
        registerDetails.put("email", registerDetails.get("name").toLowerCase() + "@example.com");
        registerDetails.put("password", "Password" + generate4Digit());
        registerDetails.put("day", "6");
        registerDetails.put("month", "January");
        registerDetails.put("year", "2005");
        registerDetails.put("firstName", "AutoTest");
        registerDetails.put("lastName", registerDetails.get("name").replaceAll("[^0-9]", ""));
        registerDetails.put("company", "Example Inc.");
        registerDetails.put("address1", "123 Main St");
        registerDetails.put("address2", "Apt 4B");
        registerDetails.put("country", "United States");
        registerDetails.put("state", "New York");
        registerDetails.put("city", "New York");
        registerDetails.put("zipcode", "10001");
        registerDetails.put("mobileNumber", "+1 (555) 019-9941");

        homePage.verifyHomePage();

        homePage.clickSignupLoginTab();
        signupLoginPage.verifyNewUserSignupHeader();
        signupLoginPage.registerNewUser(registerDetails);
        signupPage.verifyEnterAccountInformationHeader();
        signupPage.registerUserInformation(registerDetails);

        accountCreatedPage.verifyAccountCreatedHeader();
        accountCreatedPage.clickContinueButton();

        homePage.verifyLoggedInAs(registerDetails.get("name"));

        homePage.clickViewProduct(1);
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();

        cartPage.verifyCartPageIsDisplayed();

        cartPage.clickProceedToCheckout();

        checkoutPage.verifyAddressDetailsIsVisible();
        checkoutPage.verifyReviewOrderIsVisible();

        checkoutPage.enterOrderComment("Please deliver in the morning if possible.");
        checkoutPage.clickPlaceOrderButton();

        paymentPage.enterPaymentDetails("AutoTest Tester", "4111111111111111", "123", "12", "2028");
        paymentPage.clickPayAndConfirmOrderButton();

        paymentPage.verifyOrderPlacedSuccessMessage();

        homePage.clickDeleteAccountTab();
        deleteAccountPage.verifyAccountDeletedHeader();
        deleteAccountPage.clickContinueButton();
    }

    @Test(priority = 16)
    public void tc_16_placeOrderLoginBeforeCheckout() {
        registerDetails = new Hashtable<>();
        registerDetails.put("name", "AutoTest" + generate4Digit());
        registerDetails.put("email", registerDetails.get("name").toLowerCase() + "@example.com");
        registerDetails.put("password", "Password" + generate4Digit());
        registerDetails.put("day", "6");
        registerDetails.put("month", "January");
        registerDetails.put("year", "2005");
        registerDetails.put("firstName", "AutoTest");
        registerDetails.put("lastName", registerDetails.get("name").replaceAll("[^0-9]", ""));
        registerDetails.put("company", "Example Inc.");
        registerDetails.put("address1", "123 Main St");
        registerDetails.put("address2", "Apt 4B");
        registerDetails.put("country", "United States");
        registerDetails.put("state", "New York");
        registerDetails.put("city", "New York");
        registerDetails.put("zipcode", "10001");
        registerDetails.put("mobileNumber", "+1 (555) 019-9941");

        homePage.verifyHomePage();
        homePage.clickSignupLoginTab();
        signupLoginPage.verifyNewUserSignupHeader();
        signupLoginPage.registerNewUser(registerDetails);
        signupPage.verifyEnterAccountInformationHeader();
        signupPage.registerUserInformation(registerDetails);
        accountCreatedPage.verifyAccountCreatedHeader();
        accountCreatedPage.clickContinueButton();
        homePage.clickLogoutTab();

        homePage.verifyHomePage();

        homePage.clickSignupLoginTab();
        signupLoginPage.loginUser(registerDetails.get("email").toString(), registerDetails.get("password").toString());

        homePage.verifyLoggedInAs(registerDetails.get("name"));

        homePage.clickViewProduct(1);
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();

        cartPage.verifyCartPageIsDisplayed();

        cartPage.clickProceedToCheckout();

        checkoutPage.verifyAddressDetailsIsVisible();
        checkoutPage.verifyReviewOrderIsVisible();

        checkoutPage.enterOrderComment("Please deliver in the morning if possible.");
        checkoutPage.clickPlaceOrderButton();

        paymentPage.enterPaymentDetails("AutoTest Tester", "4111111111111111", "123", "12", "2028");
        paymentPage.clickPayAndConfirmOrderButton();

        paymentPage.verifyOrderPlacedSuccessMessage();

        homePage.clickDeleteAccountTab();
        deleteAccountPage.verifyAccountDeletedHeader();
        deleteAccountPage.clickContinueButton();
    }

    @Test(priority = 17)
    public void tc_17_removeProductsFromCart() {
        homePage.verifyHomePage();

        homePage.clickViewProduct(1);
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();

        cartPage.verifyCartPageIsDisplayed();

        cartPage.removeProductFromCart(1);

        cartPage.verifyProductRemovedFromCart(1);
    }

    @Test(priority = 18)
    public void tc_18_viewCategoryProducts() {
        homePage.verifyHomePage();
        homePage.verifyCategorySidebarIsVisible();

        homePage.clickCategory("Women");
        homePage.clickSubCategory("Women", "Tops");

        categoryPage.verifyCategoryPageTitle("WOMEN - TOPS PRODUCTS");

        homePage.clickCategory("Men");
        homePage.clickSubCategory("Men", "Tshirts");

        categoryPage.verifyCategoryPageTitle("MEN - TSHIRTS PRODUCTS");
    }

    @Test(priority = 19)
    public void tc_19_viewAndCartBrandProducts() {
        homePage.verifyHomePage();
        logger.info("Verified home page is displayed");

        homePage.clickProductsTab();
        logger.info("Clicked on 'Products' button");

        productsPage.verifyAllProductsHeader();
        logger.info("Verified navigation to All Products page");

        productsPage.verifyBrandsSidebarIsVisible();
        logger.info("Verified Brands are visible on left side bar");

        String firstBrand = productsPage.getBrandNameByIndex(1);
        productsPage.clickBrandByIndex(1);
        logger.info("Clicked on brand: " + firstBrand);

        categoryPage.verifyBrandPageTitle(firstBrand);
        categoryPage.verifyProductsAreDisplayed();
        logger.info("Verified navigation to " + firstBrand + " brand page and products are displayed");

        String secondBrand = productsPage.getBrandNameByIndex(2);
        productsPage.clickBrandByIndex(2);
        logger.info("Clicked on brand: " + secondBrand);

        categoryPage.verifyBrandPageTitle(secondBrand);
        categoryPage.verifyProductsAreDisplayed();
        logger.info("Verified navigation to " + secondBrand + " brand page and products are displayed");
    }

    @Test(priority = 20)
    public void tc_20_searchProductsAndVerifyCartAfterLogin() {
        homePage.verifyHomePage();

        homePage.clickProductsTab();
        productsPage.verifyAllProductsHeader();

        productsPage.searchProduct("Top");
        productsPage.verifySearchedProductsHeader();
        productsPage.verifySearchedProductsAreDisplayed();

        productsPage.addAllSearchedProductsToCart();

        homePage.clickCartTab();
        cartPage.verifyCartPageIsDisplayed();
        cartPage.verifyProductsInCart();

        homePage.clickSignupLoginTab();
        signupLoginPage.loginUser("autotest@example.com", "Password1234");

        homePage.clickCartTab();
        cartPage.verifyCartPageIsDisplayed();
        cartPage.verifyProductsInCart();
    }


    @Test(priority = 21)
    public void tc_21_addReviewOnProduct() {
        homePage.verifyHomePage();

        homePage.clickProductsTab();
        productsPage.verifyAllProductsHeader();

        homePage.clickViewProduct(1);
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.verifyWriteYourReviewIsVisible();

        productDetailPage.submitReview("AutoTest", "autotest@example.com", "Great product!");
        productDetailPage.verifyReviewSuccessMessage();
    }

    @Test(priority = 22)
    public void tc_22_addToCartFromRecommendedItems() {
        homePage.verifyHomePage();

        homePage.scrollToFooter();
        homePage.verifyRecommendedItemsVisible();

        homePage.addRecommendedProductToCart();
        homePage.clickViewCartFromRecommended();

        cartPage.verifyCartPageIsDisplayed();
        cartPage.verifyProductsInCart();
    }

    @Test(priority = 23)
    public void tc_23_verifyAddressDetailsInCheckoutPage() {
        registerDetails = new Hashtable<>();
        registerDetails.put("name", "AutoTest" + generate4Digit());
        registerDetails.put("email", registerDetails.get("name").toLowerCase() + "@example.com");
        registerDetails.put("password", "Password" + generate4Digit());
        registerDetails.put("day", "6");
        registerDetails.put("month", "January");
        registerDetails.put("year", "2005");
        registerDetails.put("firstName", "AutoTest");
        registerDetails.put("lastName", registerDetails.get("name").replaceAll("[^0-9]", ""));
        registerDetails.put("company", "Example Inc.");
        registerDetails.put("address1", "123 Main St");
        registerDetails.put("address2", "Apt 4B");
        registerDetails.put("country", "United States");
        registerDetails.put("state", "New York");
        registerDetails.put("city", "New York");
        registerDetails.put("zipcode", "10001");
        registerDetails.put("mobileNumber", "+1 (555) 019-9941");

        homePage.verifyHomePage();

        homePage.clickSignupLoginTab();
        signupLoginPage.verifyNewUserSignupHeader();
        signupLoginPage.registerNewUser(registerDetails);
        signupPage.verifyEnterAccountInformationHeader();
        signupPage.registerUserInformation(registerDetails);
        accountCreatedPage.verifyAccountCreatedHeader();
        accountCreatedPage.clickContinueButton();

        homePage.verifyLoggedInAs(registerDetails.get("name"));

        homePage.clickViewProduct(1);
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();

        cartPage.verifyCartPageIsDisplayed();
        cartPage.clickProceedToCheckout();

        checkoutPage.verifyDeliveryAddress(
            registerDetails.get("firstName"),
            registerDetails.get("lastName"),
            registerDetails.get("address1"),
            registerDetails.get("city"),
            registerDetails.get("state"),
            registerDetails.get("zipcode"),
            registerDetails.get("country")
        );
        checkoutPage.verifyBillingAddress(
            registerDetails.get("firstName"),
            registerDetails.get("lastName"),
            registerDetails.get("address1"),
            registerDetails.get("city"),
            registerDetails.get("state"),
            registerDetails.get("zipcode"),
            registerDetails.get("country")
        );

        homePage.clickDeleteAccountTab();
        deleteAccountPage.verifyAccountDeletedHeader();
        deleteAccountPage.clickContinueButton();
    }

    @Test(priority = 24)
    public void tc_24_downloadInvoiceAfterPurchase() {
        registerDetails = new Hashtable<>();
        registerDetails.put("name", "AutoTest" + generate4Digit());
        registerDetails.put("email", registerDetails.get("name").toLowerCase() + "@example.com");
        registerDetails.put("password", "Password" + generate4Digit());
        registerDetails.put("day", "6");
        registerDetails.put("month", "January");
        registerDetails.put("year", "2005");
        registerDetails.put("firstName", "AutoTest");
        registerDetails.put("lastName", registerDetails.get("name").replaceAll("[^0-9]", ""));
        registerDetails.put("company", "Example Inc.");
        registerDetails.put("address1", "123 Main St");
        registerDetails.put("address2", "Apt 4B");
        registerDetails.put("country", "United States");
        registerDetails.put("state", "New York");
        registerDetails.put("city", "New York");
        registerDetails.put("zipcode", "10001");
        registerDetails.put("mobileNumber", "+1 (555) 019-9941");

        homePage.verifyHomePage();

        homePage.clickViewProduct(1);
        productDetailPage.verifyProductDetailIsVisible();
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickViewCartButton();

        cartPage.verifyCartPageIsDisplayed();
        cartPage.clickProceedToCheckout();
        cartPage.clickRegisterLoginLink();

        signupLoginPage.verifyNewUserSignupHeader();
        signupLoginPage.registerNewUser(registerDetails);
        signupPage.verifyEnterAccountInformationHeader();
        signupPage.registerUserInformation(registerDetails);
        accountCreatedPage.verifyAccountCreatedHeader();
        accountCreatedPage.clickContinueButton();

        homePage.verifyLoggedInAs(registerDetails.get("name"));

        homePage.clickCartTab();
        cartPage.verifyCartPageIsDisplayed();
        cartPage.clickProceedToCheckout();

        checkoutPage.verifyAddressDetailsIsVisible();
        checkoutPage.verifyReviewOrderIsVisible();

        checkoutPage.enterOrderComment("Please deliver in the morning if possible.");
        checkoutPage.clickPlaceOrderButton();

        paymentPage.enterPaymentDetails("AutoTest Tester", "4111111111111111", "123", "12", "2028");
        paymentPage.clickPayAndConfirmOrderButton();
        paymentPage.verifyOrderPlacedSuccessMessage();

        paymentPage.clickDownloadInvoiceButton();
        paymentPage.verifyInvoiceDownloaded();

        paymentPage.clickContinueButton();

        homePage.clickDeleteAccountTab();
        deleteAccountPage.verifyAccountDeletedHeader();
        deleteAccountPage.clickContinueButton();
    }

    @Test(priority = 25)
    public void tc_25_verifyScrollUpArrowAndScrollDown() {
        homePage.verifyHomePage();

        homePage.scrollToFooter();
        cartPage.verifySubscriptionText();

        homePage.clickScrollUpArrow();
        homePage.verifyPageScrolledUpWithHeroText();
    }

    @Test(priority = 26)
    public void tc_26_verifyScrollUpWithoutArrowButton() {
        homePage.verifyHomePage();

        homePage.scrollToFooter();
        cartPage.verifySubscriptionText();

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        homePage.verifyPageScrolledUpWithHeroText();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        afterMethod(result, browser);
    }
}
