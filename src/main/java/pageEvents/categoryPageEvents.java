package pageEvents;

import base.BaseTest;

public class categoryPageEvents extends BaseTest {

    public void verifyCategoryPageTitle(String expectedTitle) {
        logger.info("Verify category page is displayed with text '" + expectedTitle + "'");
        String upperTitle = expectedTitle.toUpperCase();
        String xpath = "//h2[contains(translate(., 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), '"
                + upperTitle + "')]";
        assertElementIsDisplayed(xpath);
    }

    public void verifyBrandPageTitle(String brandName) {
        String upperBrand = ("Brand - " + brandName + " Products").toUpperCase();
        String xpath = "//h2[contains(translate(., 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), '"
                + upperBrand + "')]";
        assertElementIsDisplayed(xpath);
    }

    public void verifyProductsAreDisplayed() {
        assertElementIsDisplayed("//div[@class='features_items']//div[@class='product-image-wrapper']");
    }

}