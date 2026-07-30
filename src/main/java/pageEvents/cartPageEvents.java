package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import base.BaseTest;
import pageObjects.cartPageElements;

public class cartPageEvents extends BaseTest {

    public void scrollToFooter() {
        logger.info("Scroll down to footer");
        super.scrollToFooter();
    }

    public void verifySubscriptionText() {
        logger.info("Verify text 'SUBSCRIPTION'");
        assertElementIsDisplayed(cartPageElements.txtSubscriptionHeader);
    }

    public void enterSubscriptionEmail(String email) {
        logger.info("Enter email address '" + email + "' in input and click arrow button");
        sendKeys(cartPageElements.inputSubscribeEmail, email);
    }

    public void clickSubscribeArrowButton() {
        click(cartPageElements.btnSubscribeArrow);
    }

    public void verifySubscriptionSuccessMessage() {
        logger.info("Verify success message 'You have been successfully subscribed!' is visible");
        assertElementIsDisplayed(cartPageElements.txtSubscriptionSuccessMessage);
    }

    public void verifyProductInCart(int rowIndex, String expectedName) {
        logger.info("Verify product '" + expectedName + "' is present in cart row " + rowIndex);
        String nameXpath = cartPageElements.cartRow + rowIndex + "]//td[@class='cart_description']//h4/a";
        assertElementIsDisplayed(nameXpath);
        String actualName = getText(nameXpath);
        org.testng.Assert.assertTrue(actualName.trim().equalsIgnoreCase(expectedName.trim()),
                "Expected product name '" + expectedName + "' but found '" + actualName + "'");
    }

    public void verifyPriceQuantityAndTotal(int rowIndex) {
        String priceXpath = cartPageElements.cartRow + rowIndex + "]//td[@class='cart_price']/p";
        String quantityXpath = cartPageElements.cartRow + rowIndex + "]//td[@class='cart_quantity']//button";
        String totalXpath = cartPageElements.cartRow + rowIndex + "]//td[@class='cart_total']/p";

        int price = Integer.parseInt(getText(priceXpath).replaceAll("[^0-9]", ""));
        int quantity = Integer.parseInt(getText(quantityXpath).replaceAll("[^0-9]", ""));
        int total = Integer.parseInt(getText(totalXpath).replaceAll("[^0-9]", ""));

        logger.info("Row " + rowIndex + " -> Price: " + price + ", Quantity: " + quantity + ", Total: " + total);

        org.testng.Assert.assertEquals(total, price * quantity,
                "Total price does not match Price x Quantity for row " + rowIndex);
    }

    public void verifyProductQuantityInCart(int rowIndex, int expectedQuantity) {
        logger.info("Verify product quantity in cart row " + rowIndex + " is " + expectedQuantity);
        String quantityXpath = cartPageElements.cartRow + rowIndex + "]//td[@class='cart_quantity']//button";
        assertElementIsDisplayed(quantityXpath);
        int actualQuantity = Integer.parseInt(getText(quantityXpath).replaceAll("[^0-9]", ""));
        org.testng.Assert.assertEquals(actualQuantity, expectedQuantity,
                "Expected quantity " + expectedQuantity + " but found " + actualQuantity + " in cart row " + rowIndex);
    }

    public void verifyCartPageIsDisplayed() {
        logger.info("Verify that cart page is displayed");
        assertPageIsDisplayed("/view_cart");
    }

    public void clickProceedToCheckout() {
        logger.info("Click 'Proceed To Checkout'");
        click(cartPageElements.btnProceedToCheckout);
    }

    public void clickRegisterLoginLink() {
        logger.info("Click 'Register / Login' button");
        click(cartPageElements.linkRegisterLogin);
    }

    public void removeProductFromCart(int rowIndex) {
        logger.info("Click 'X' button to remove product in cart row " + rowIndex);
        String removeXpath = cartPageElements.cartRow + rowIndex + "]//a[@class='cart_quantity_delete']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(removeXpath)));
        click(removeXpath);
    }

    public void verifyProductRemovedFromCart(int rowIndex) {
        logger.info("Verify product is removed from cart");
        String rowXpath = cartPageElements.cartRow + rowIndex + "]";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(rowXpath)));
    }
}