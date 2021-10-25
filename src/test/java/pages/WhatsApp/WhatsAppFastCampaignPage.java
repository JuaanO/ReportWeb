package pages.WhatsApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatsAppFastCampaignPage {
    private static final long TIMEOUT = 5;
    private final WebDriver driver;
    static Logger logger = LogManager.getLogger();
    private final By selectFileCombobox;

//    private final By navMassiveCampaign;
//    private final By groupCombobox;
//    private final By groupElemnt;
//    private final By loadGroupButton;
//    private final By nameCampaignInput;
//    private final By nextTwoStepButton;

    public WhatsAppFastCampaignPage(WebDriver driver) {
        this.driver = driver;
        selectFileCombobox = By.xpath("//input[@type='file']");
//        navMassiveCampaign = By.xpath("//*[@id='navSendArchive']");
//        groupCombobox = By.xpath("//option[normalize-space()='Groups']");
//        groupElemnt = By.xpath("//label[@for='exampleCheck1']");
//        loadGroupButton = By.xpath("//*[@id='loadAddreseesByGroup']");
//        nameCampaignInput = By.xpath("//input[@id='campaignNameInput']");
//        nextTwoStepButton = By.xpath("//*[@id='stepOneNextBtn']");
    }

    public void FastSend(String template) {

        logger.error(template);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        driver.findElement(By.xpath("//option[@value='1637']")).click();
        driver.findElement(By.xpath("//input[@id='inputGsmList']")).sendKeys("0987288333");
        driver.findElement(By.xpath("//button[@id='buttonProcess']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send']")))
                .click();
    }

}
