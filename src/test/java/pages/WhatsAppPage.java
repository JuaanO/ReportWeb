package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WhatsAppPage {

    private static final long TIMEOUT = 5;
    private final WebDriver driver;
    private final By navMassiveCampaign;
    private final By groupCombobox;
    private final By groupElemnt;
    private final By loadGroupButton;
    private final By nameCampaignInput;
    private final By nextTwoStepButton;

    static Logger logger = LogManager.getLogger();
    private final By selectFileCombobox;

    public WhatsAppPage(WebDriver driver) {
        this.driver = driver;
        navMassiveCampaign = By.xpath("//*[@id='navSendArchive']");
        groupCombobox = By.xpath("//option[normalize-space()='Groups']");
        groupElemnt = By.xpath("//label[@for='exampleCheck1']");
        loadGroupButton = By.xpath("//*[@id='loadAddreseesByGroup']");
        nameCampaignInput = By.xpath("//input[@id='campaignNameInput']");
        nextTwoStepButton = By.xpath("//*[@id='stepOneNextBtn']");
        selectFileCombobox = By.xpath("//input[@type='file']");
    }

    public void chooseMassiveCampaign() {
        driver.findElement(navMassiveCampaign).click();
    }


    public void chooseDataSource() {
        driver.findElement(groupCombobox).click();
    }

    public void chooseGroup() {
        driver.findElement(groupElemnt).click();
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


    public void loadGroup() {
        driver.findElement(loadGroupButton).click();
    }

    public void loadFile() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebElement addFile = driver.findElement(selectFileCombobox);
        ((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
        addFile.sendKeys(props.getProperty("pathForFileCSV"));

    }

    public void chooseFileGsmColumn() {

        driver.findElement(By.xpath("//div[@class='ng-star-inserted']//div[1]//div[1]//select[1]//option[3]")).click();
        driver.findElement(By.xpath("//div[@class='ng-star-inserted']//div[2]//div[1]//select[1]//option[4]")).click();

    }

    public void inputANameForCampaing() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(nameCampaignInput))
                .sendKeys(props.getProperty("nameForMasiveCampaign"));
    }

    public void tercerpaso() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(nextTwoStepButton))
                .click();
    }
}
