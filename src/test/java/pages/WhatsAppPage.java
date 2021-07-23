package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    public WhatsAppPage(WebDriver driver) {
        this.driver = driver;
        navMassiveCampaign = By.xpath("//*[@id='navSendArchive']");
        groupCombobox = By.xpath("//option[normalize-space()='Groups']");
        groupElemnt = By.xpath("//label[@for='exampleCheck1']");
        loadGroupButton = By.xpath("//*[@id='loadAddreseesByGroup']");
        nameCampaignInput = By.xpath("//input[@id='campaignNameInput']");
        nextTwoStepButton = By.xpath("//*[@id='stepOneNextBtn']");



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


    public void loadGroup() {
        driver.findElement(loadGroupButton).click();
    }

    public void loadFile() {
    }

    public void chooseFileGsmColumn() {
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
