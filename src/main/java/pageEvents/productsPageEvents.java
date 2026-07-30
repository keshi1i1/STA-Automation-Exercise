package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.productsPageElements;

public class productsPageEvents extends BaseTest {

    public void verifyAllProductsHeader() {
        logger.info("Verify 'All Products' header is visible");
        assertElementIsDisplayed(productsPageElements.txtAllProductsHeader);
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
}