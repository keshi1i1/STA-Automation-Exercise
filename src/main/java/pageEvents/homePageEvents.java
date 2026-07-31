package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Dictionary;

import base.BaseTest;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest {

    public void verifyHomePage() {
        logger.info("Verify that home page is visible successfully");
        assertPageIsDisplayed("https://automationexercise.com/");
    }
    
    public void clickSignupLoginTab() {
        logger.info("Click on 'Signup / Login' button");
        click(homePageElements.tabSignupLogin);
    }

    public void clickDeleteAccountTab() {
        logger.info("Click 'Delete Account' button");
        click(homePageElements.tabDeleteAccount);
    }

    public void verifyLoggedInAs(@SuppressWarnings("rawtypes") Dictionary registerDetails) {
        logger.info("Verify that 'Logged in as " + registerDetails.get("name").toString() + "' is visible");
        assertElementIsDisplayed("//a[contains(., 'Logged in as')]/b[text()='" + registerDetails.get("name").toString() + "']");
    }

    public void clickProductsTab() {
        logger.info("Click 'Products' button");
        click(homePageElements.tabProducts);
    }

    public void clickViewProduct(int productIndex) {
        logger.info("Click 'View Product' for product #" + productIndex + " on home page");
        clickViewProduct(homePageElements.productWrapper, homePageElements.btnViewProduct, productIndex);
    }

    public void clickCartTab() {
        logger.info("Click 'Cart' button");
        click(homePageElements.tabCart);
    }

    public void clickLogoutTab() {
        logger.info("Click 'Logout' button");
        click(homePageElements.tabLogout);
    }

    public void clickCategory(String categoryName) {
        logger.info("Click on '" + categoryName + "' category");
        String xpath = homePageElements.linkCategoryPanel.replace("CATEGORY_PANEL", categoryName);
        click(xpath);
    }

    public void clickSubCategory(String categoryName, String subCategoryName) {
        logger.info("Click on '" + subCategoryName + "' sub-category link under '" + categoryName + "' category");
        String xpath = homePageElements.linkSubCategory
                .replace("CATEGORY_PANEL", categoryName)
                .replace("SUBCATEGORY_NAME", subCategoryName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        click(xpath);
    }

    public void verifyCategorySidebarIsVisible() {
        logger.info("Verify that categories are visible on left side bar");
        assertElementIsDisplayed("//div[@class='panel-group category-products']");
    }

    public void verifyRecommendedItemsVisible() {
        logger.info("Verify 'RECOMMENDED ITEMS' are visible");
        assertElementIsDisplayed(homePageElements.txtRecommendedItems);
    }

    public void addRecommendedProductToCart() {
        logger.info("Click 'Add To Cart' on recommended product");
        click(homePageElements.btnAddToCartRecommended);
    }

    public void clickViewCartFromRecommended() {
        logger.info("Click 'View Cart' from recommended items modal");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(homePageElements.btnViewCartRecommended)));
        click(homePageElements.btnViewCartRecommended);
    }

    public void clickScrollUpArrow() {
        logger.info("Click scroll up arrow button");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('scrollUp').click();");
    }

    public void verifyPageScrolledUpWithHeroText() {
        logger.info("Verify page is scrolled up and hero text is visible");
        assertElementIsDisplayed(homePageElements.txtHeroHeader);
    }

    public void clickContactUsTab() {
        logger.info("Click on 'Contact Us' button");
        click(homePageElements.tabContactUs);
    }

    public void clickTestCasesTab() {
        logger.info("Click on 'Test Cases' button");
        click(homePageElements.tabTestCases);
    }

    public void verifySubscriptionHeader() {
        logger.info("Verify text 'SUBSCRIPTION'");
        assertElementIsDisplayed(homePageElements.hdrSubscription);
    }

    public void subscribeWithEmail() {
        logger.info("Enter email address in input and click arrow button");
        clear(homePageElements.txtSubscribeEmail);
        sendKeys(homePageElements.txtSubscribeEmail, "autotest@example.com");
        
        click(homePageElements.btnRightArrow);

        logger.info("Verify success message 'You have been successfully subscribed!' is visible");
        assertElementIsDisplayed(homePageElements.hdrSuccessSubscription);
    }
}
