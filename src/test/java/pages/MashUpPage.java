package pages;

import helpers.Helpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class MashUpPage {

    private final WebDriver driver;
    private final By smsButton;
    private final By notificationButton;
    private final By downloadFileButton;
    private final By assertionMain;
    private final By reportButton;
    private final By administratorButton;
    private final By documentsButton;
    private final By voiceButton;
    private final By emailButton;
    private final By whatsAppButton;
    private final By languageDropDownES;
    private final By languageDropDownEN;

    public MashUpPage(WebDriver driver){
        this.driver = driver;
        administratorButton = By.xpath("//h2[normalize-space()='Corporative Administrator.']");
        documentsButton = By.xpath("//h2[contains(text(),'Digitize your extracts, letters')]");
        reportButton = By.xpath("//h2[contains(text(),'Sent campaign report with')]");
        smsButton = By.xpath("//h1[contains(text(),'Enhance communications with')]");
        voiceButton = By.xpath("//h1[contains(text(),'Sending the same audio or a')]");
        emailButton = By.xpath("//h1[contains(text(),'Make strategic E-mail Marketing')]");
        whatsAppButton = By.xpath("//h1[contains(text(),'Ensure effective interaction with your')]");
        languageDropDownEN = By.xpath("//span[normalize-space()='En']");
        languageDropDownES = By.xpath("//span[normalize-space()='Es']");
        notificationButton = By.xpath("/html/body/app-root/div[2]/app-navbar/header/nav/div[3]/div/ul/li[1]/a/span");
        downloadFileButton = By.xpath("//body//app-root//li[@class='dropdown drop-custom notifications-menu show']//li//li[1]//div[2]//div[1]//a[2]//i[1]");
        assertionMain = By.xpath("//h2[normalize-space()='Products']");
    }

    public void chooseOption(String option){
        assertionMain();
        switch (option.toLowerCase(Locale.ROOT).trim()){
            case "administrator":
                driver.findElement(administratorButton).click();
                break;
            case "documents":
                driver.findElement(documentsButton).click();
                break;
            case "reports":
                driver.findElement(reportButton).click();
                break;
            case "sms":
                driver.findElement(smsButton).click();
                break;
            case "voice":
                driver.findElement(voiceButton).click();
                break;
            case "whatsapp":
                driver.findElement(whatsAppButton).click();
                break;
            case "email":
                driver.findElement(emailButton).click();
                break;
        }
    }

    public void downloadReport() {
        Helpers helpers = new Helpers();
        driver.findElement(notificationButton).click();
        helpers.sleepSeconds(5);
        driver.findElement(downloadFileButton).click();
        helpers.sleepSeconds(3);
    }

    public void assertionMain(){
        Assert.assertTrue(driver.findElement(assertionMain).getText().contains("Products"));
    }
}
