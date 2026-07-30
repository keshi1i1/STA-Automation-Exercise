package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.productDetailPageElements;

public class productDetailPageEvents extends BaseTest {

    public void verifyProductDetailIsVisible() {
        logger.info("Verify product detail page is opened");
        assertElementIsDisplayed(productDetailPageElements.txtProductInformation);
    }

    public void setProductQuantity(int quantity) {
        logger.info("Increase quantity to " + quantity);
        clear(productDetailPageElements.inputQuantity);
        sendKeys(productDetailPageElements.inputQuantity, String.valueOf(quantity));
    }

    public void clickAddToCartButton() {
        logger.info("Click 'Add to cart' button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productDetailPageElements.btnAddToCart)));
        click(productDetailPageElements.btnAddToCart);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productDetailPageElements.btnViewCart)));
    }

    public void clickViewCartButton() {
        logger.info("Click 'View Cart' button");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productDetailPageElements.btnViewCart)));
        click(productDetailPageElements.btnViewCart);
    }
}