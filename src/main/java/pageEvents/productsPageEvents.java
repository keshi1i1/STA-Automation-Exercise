package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.productsPageElements;

public class productsPageEvents extends BaseTest {

    public void verifyProductsPage() {
        logger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        assertPageIsDisplayed("products");
    }

    public void hoverAndAddProductToCart(int productIndex) {
        logger.info("Hover over product #" + productIndex + " and click 'Add to cart'");

        String wrapperXpath = productsPageElements.productWrapper + productIndex + "]";
        String addToCartXpath = productsPageElements.btnAddToCart.replace("INDEX", String.valueOf(productIndex));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the product card to be present before hovering
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wrapperXpath)));
        hoverOverElement(wrapperXpath);

        // Wait for the "Add to cart" overlay link to actually be clickable after hover
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addToCartXpath)));
        click(addToCartXpath);

        // Wait for the post-add modal to appear before moving on
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productsPageElements.btnContinueShopping)));
    }

    public void clickContinueShoppingButton() {
        logger.info("Click 'Continue Shopping' button");
        click(productsPageElements.btnContinueShopping);

        // Wait for modal to fully close before next action
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(productsPageElements.btnContinueShopping)));
    }

    public void clickViewCartButton() {
        logger.info("Click 'View Cart' button");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productsPageElements.btnViewCart)));
        click(productsPageElements.btnViewCart);
    }

    public void verifyBrandsSidebarIsVisible() {
        assertElementIsDisplayed(productsPageElements.brandsSidebarHeader);
    }

    public void clickBrandByIndex(int index) {
        // index is 1-based to match your existing convention (see hoverAndAddProductToCart(1))
        click("(" + productsPageElements.lstBrandLinks + ")[" + index + "]");
    }

    public String getBrandNameByIndex(int index) {
        return getText("(" + productsPageElements.lstBrandLinks + ")[" + index + "]").replaceAll("\\s*\\(.*\\)", "").trim();
    }

    public void searchProduct(String productName) {
        logger.info("Search for product: " + productName);
        sendKeys(productsPageElements.inputSearch, productName);
        click(productsPageElements.btnSearch);
    }

    public void verifySearchedProductsHeader() {
        logger.info("Verify 'SEARCHED PRODUCTS' is visible");
        assertElementIsDisplayed(productsPageElements.txtSearchedProductsHeader);
    }

    public void addAllSearchedProductsToCart() {
        logger.info("Add all searched products to cart");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int count = driver.findElements(By.xpath(productsPageElements.lstSearchedProducts)).size();
        for (int i = 1; i <= count; i++) {
            String wrapperXpath = "(" + productsPageElements.lstSearchedProducts + ")[" + i + "]";
            String addToCartXpath = "(" + productsPageElements.lstSearchedProducts + ")[" + i + "]//a[contains(text(),'Add to cart')]";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wrapperXpath)));
            hoverOverElement(wrapperXpath);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addToCartXpath)));
            click(addToCartXpath);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productsPageElements.btnContinueShopping)));
            click(productsPageElements.btnContinueShopping);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(productsPageElements.btnContinueShopping)));
        }
    }

    public void verifySearchedProductsAreDisplayed() {
        logger.info("Verify all the products related to search are visible");
        assertElementIsDisplayed("(" + productsPageElements.lstSearchedProducts + ")[1]");
    }

    public void verifyProductsListIsVisible() {
        logger.info("Verify the products list is visible");
        assertElementsAreVisible(productsPageElements.lstProducts);
    }

    public void clickViewFirstProduct() {
        logger.info("Click on 'View Product' of first product");
        clickViewProduct(productsPageElements.productWrapper, productsPageElements.btnViewProduct, 1);
    }

    public void clickViewProduct(int productIndex) {
        logger.info("Click on 'View Product' button");
        clickViewProduct(productsPageElements.productWrapper, productsPageElements.btnViewProduct, productIndex);
    }
}