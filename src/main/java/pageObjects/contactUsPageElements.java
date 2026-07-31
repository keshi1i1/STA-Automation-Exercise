package pageObjects;

public interface contactUsPageElements {
    
    // Header
    String hdrGetInTouch = "//h2[normalize-space()='Get In Touch']";
    String hdrSuccessMessage = "//div[@class='status alert alert-success']";

    // Contact Us Form
    String txtContactName = "//input[@placeholder='Name']";
    String txtContactEmail = "//input[@placeholder='Email']";
    String txtContactSubject = "//input[@placeholder='Subject']";
    String txtContactMessage = "//textarea[@id='message']";
    String btnSubmit = "//input[@name='submit']";

    // Upload File Input
    String btnUploadFile = "//input[@name='upload_file']";

    // Home Tab
    String tabHome = "//a[contains(text(),'Home')]";
}
