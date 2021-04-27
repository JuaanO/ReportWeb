package pages;


import helpers.Helpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

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
    private final By languageDropDownES;
    private final By languageDropDownEN;

    public MainPage(WebDriver driver){
        this.driver = driver;
        administratorButton = By.xpath("//h2[normalize-space()='Corporative Administrator.']");
        documentsButton = By.xpath("//h2[contains(text(),'Digitize your extracts, letters')]");
        reportButton = By.xpath("//h2[contains(text(),'Sent campaign report with')]");
        smsButton = By.xpath("//h1[contains(text(),'Enhance communications with')]");
        voiceButton = By.xpath("//h1[contains(text(),'Sending the same audio or a')]");
        emailButton = By.xpath("//h1[contains(text(),'Make strategic E-mail Marketing')]");
        languageDropDownEN = By.xpath("//span[normalize-space()='En']");
        languageDropDownES = By.xpath("//span[normalize-space()='Es']");
        notificationButton = By.xpath("/html/body/app-root/div[2]/app-navbar/header/nav/div[3]/div/ul/li[1]/a/span");
        downloadFileButton = By.xpath("//body//app-root//li[@class='dropdown drop-custom notifications-menu show']//li//li[1]//div[2]//div[1]//a[2]//i[1]");
        assertionMain = By.xpath("//h2[normalize-space()='Products']");
    }

    public void chooseOption(String option){
            assertionMain();
            switch (option){
                case "Administrator":
                    driver.findElement(administratorButton).click();
                    break;
                case "Documents":
                    driver.findElement(documentsButton).click();
                    break;
                case "Reports":
                    driver.findElement(reportButton).click();
                    break;
                case "SMS":
                    driver.findElement(smsButton).click();
                    break;
                case "Voice":
                    driver.findElement(voiceButton).click();
                    break;
                case "Email":
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
