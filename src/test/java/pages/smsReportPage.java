package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class smsReportPage {

    private static final long TIMEOUT = 50;
    private final WebDriver driver;
    private final By menuButton, smsButton, smsDetailedReportButton, typeInput;
    private final By documentsButton, documentsDetailedReportButton, validatorsButton;
    private final By validatorsDetailedReportButton, rcsButton, rcsDetailedReportButton;
    private final By whatsappButton, whatsappDetailedReportButton, referenceInput;
    private final By userDropDown, idSendLink, searchButton, selectAllUsers, searchUserInput;

    public smsReportPage(WebDriver driver){
        this.driver = driver;
        menuButton = By.xpath("//i[@class='fas fa-bars']");
        smsButton = By.xpath("//span[normalize-space()='SMS']");
        smsDetailedReportButton = By.xpath("//ul[@id='SmsSubMenu']//li[2]");
        documentsButton = By.xpath("//a[@aria-controls='#DocsSubMenu']");
        documentsDetailedReportButton = By.xpath("//ul[@id='DocsSubMenu']//li[2]");
        validatorsButton = By.xpath("//a[@aria-controls='#ValidatorsubMenu']");
        validatorsDetailedReportButton = By.xpath("//ul[@id='ValidatorsubMenu']//li[3]//a[1]");
        rcsButton = By.xpath("//a[@aria-controls='#RcssubMenu']");
        rcsDetailedReportButton = By.xpath("//ul[@id='RcssubMenu']//li[2]");
        whatsappButton = By.xpath("//a[@data-target='#WhatsApppSubMenu']");
        whatsappDetailedReportButton = By.xpath("//ul[@id='WhatsApppSubMenu']//li[2]");
        userDropDown = By.xpath("//*[@id='multiSelectUser']/div/div[1]/span");
        idSendLink = By.xpath("//*[contains(@class, 'align-middle name processStatusTooltip')]");
        searchButton = By.xpath("//button[normalize-space()='Search']");
        selectAllUsers = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[1]/div");
        searchUserInput = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[2]/input");
        referenceInput = By.xpath("//input[@placeholder='Reference']");
        typeInput = By.xpath("//*[@id='multiSelectMessageType']/div/div[1]/span");
    }

    public void openMenu(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        }catch (org.openqa.selenium.StaleElementReferenceException ex){
            wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        }
    }

    public void chooseOption(String option) {
        switch (option){
            case "SMS":
                receiver(smsButton);
                break;
            case "Documents":
                receiver(documentsButton);
                break;
            case "Validators":
                receiver(validatorsButton);
                break;
            case "RCS":
                receiver(rcsButton);
                break;
            case "WhatsApp":
                receiver(whatsappButton);
                break;
            }
    }

    public void receiver (By option) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(option)).click();
        wait.until(ExpectedConditions.
                elementToBeClickable(smsDetailedReportButton)).click();
    }

    public void selectUser(String user) {
        driver.findElement(userDropDown).click();
        driver.findElement(selectAllUsers).click();
        driver.findElement(searchUserInput).sendKeys(user);
        driver.findElement(By.xpath("//div[normalize-space()='"+user+"']")).click();
        driver.findElement(userDropDown).click();
    }

    public void inputReference(String reference) {
        driver.findElement(referenceInput).sendKeys(reference);
    }

    public void selectType(String type) {
        driver.findElement(typeInput).click();
        driver.findElement(By.xpath("//div[normalize-space()='"+type+"']")).click();
        driver.findElement(typeInput).click();
    }

    public void pressButtonSearch() {
        driver.findElement(searchButton).click();
    }

    public void seeTypeAndStatus(String type, String status){
        List<WebElement> idSends = driver.findElements(idSendLink);
        if (status.equals("send")){
            for (int i = 1; i <= idSends.size(); i++) {
                Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]")).getText(), type);
                System.out.println("Campaign type: "+driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]")).getText()+
                        " sent message -> "+driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]")).getText());
            }
        } else {
            for (int i = 1; i <= idSends.size(); i++) {
                Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]")).getText(), type);
                System.out.println("Campaign type: "+driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]")).getText()+
                        " failed message -> "+driver.findElement(By.xpath("//tbody/tr["+i+"]/td[7]")).getText());
            }
        }
    }
}
