package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.paymentPageElements;

public class paymentPageEvents extends BaseTest {

    public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        logger.info("Enter payment details - Name on Card: " + nameOnCard + ", Card Number: " + cardNumber
                + ", CVC: " + cvc + ", Expiry: " + expiryMonth + "/" + expiryYear);
        sendKeys(paymentPageElements.inputNameOnCard, nameOnCard);
        sendKeys(paymentPageElements.inputCardNumber, cardNumber);
        sendKeys(paymentPageElements.inputCVC, cvc);
        sendKeys(paymentPageElements.inputExpiryMonth, expiryMonth);
        sendKeys(paymentPageElements.inputExpiryYear, expiryYear);
    }

    public void clickPayAndConfirmOrderButton() {
        logger.info("Click 'Pay and Confirm Order' button");
        click(paymentPageElements.btnPayAndConfirmOrder);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentPageElements.txtOrderPlacedSuccessMessage)));
    }

    public void verifyOrderPlacedSuccessMessage() {
        logger.info("Verify success message 'Your order has been placed successfully!'");
        assertElementIsDisplayed(paymentPageElements.txtOrderPlacedSuccessMessage);
    }

    public void clickDownloadInvoiceButton() {
        logger.info("Click 'Download Invoice' button");
        click(paymentPageElements.btnDownloadInvoice);
    }

    public void verifyInvoiceDownloaded() {
        logger.info("Verify invoice is downloaded successfully");
        java.io.File downloadDir = new java.io.File(System.getProperty("user.home") + "\\Downloads");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> java.util.Arrays.stream(downloadDir.listFiles())
                .anyMatch(f -> f.getName().startsWith("invoice") && f.getName().endsWith(".txt")));
        boolean invoiceExists = java.util.Arrays.stream(downloadDir.listFiles())
                .anyMatch(f -> f.getName().startsWith("invoice") && f.getName().endsWith(".txt"));
        org.testng.Assert.assertTrue(invoiceExists, "Invoice file was not downloaded");
    }

    public void clickContinueButton() {
        logger.info("Click 'Continue' button");
        click(paymentPageElements.btnContinue);
    }
}