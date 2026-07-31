package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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

    public void verifyLoggedInAs(String name) {
        logger.info("Verify that 'Logged in as " + name + "' is visible");
        assertElementIsDisplayed("//a[contains(., 'Logged in as')]/b[text()='" + name + "']");
    }

    public void clickProductsTab() {
        logger.info("Click 'Products' button");
        click(homePageElements.tabProducts);
    }

    public void clickViewProduct(int productIndex) {
        logger.info("Click 'View Product' for product #" + productIndex + " on home page");

        String wrapperXpath = homePageElements.productWrapper + productIndex + "]";
        String viewProductXpath = homePageElements.btnViewProduct.replace("INDEX", String.valueOf(productIndex));

        java.time.Duration timeout = java.time.Duration.ofSeconds(10);
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, timeout);

        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath(wrapperXpath)));
        hoverOverElement(wrapperXpath);

        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(org.openqa.selenium.By.xpath(viewProductXpath)));
        click(viewProductXpath);
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
}
