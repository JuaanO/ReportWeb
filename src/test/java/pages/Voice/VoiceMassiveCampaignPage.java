package pages.Voice;

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

import static java.lang.Thread.sleep;

public class VoiceMassiveCampaignPage {
    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By numberInput, messageInput, processButton, sendButton;
    private final By modalTTS, voicesAvailables, contentTSS, convertTTS;

    private final By massiveCampaignNav, addresseeSourceSelect;
    private final By groupElemnt, nextTwoStepButton;
    private final By loadGroupButton, nextSecondStepButton, nameCampaignInput;

    public VoiceMassiveCampaignPage(WebDriver driver) {
        this.driver = driver;
        numberInput = By.xpath("//*[@id='selectName']");
        messageInput = By.xpath("//*[@id='file-input']");
        nameCampaignInput = By.xpath("//input[@formcontrolname='campaignName']");
        processButton = By.xpath("//*[@data-target='#modalEnviarSMS']");
        sendButton = By.xpath("//*[@id='buttonSend']");
        modalTTS = By.xpath("//*[@data-target='#TTSModal']");
        voicesAvailables = By.xpath("//*[@formcontrolname='selectVoice']/option[4]");
        contentTSS = By.xpath("//*[@id='content']");
        convertTTS = By.xpath("//form[@class='ng-star-inserted ng-dirty ng-touched ng-valid']//button[@type='button'][normalize-space()='Convertir texto en audio']");

        nextTwoStepButton = By.xpath("//button[normalize-space()='Siguiente']");
        nextSecondStepButton = By.xpath("//button[normalize-space()='Siguiente']");
        loadGroupButton = By.xpath("//*[@id='loadAddreseesByGroup']");
        groupElemnt = By.xpath("//label[@for='exampleCheck1']");
        massiveCampaignNav = By.xpath("//*[@id='navSendMassive']");
        addresseeSourceSelect = By.xpath("//option[normalize-space()='Grupos']");
    }

    public void sourceSelect() {
        driver.findElement(addresseeSourceSelect).click();
    }

    public void chooseMassiveCampaign() {
        driver.findElement(massiveCampaignNav).click();
    }

    public void chooseGroup() {
        driver.findElement(groupElemnt).click();
    }

    public void loadGroup() throws InterruptedException {
        driver.findElement(loadGroupButton).click();
//        sleep(3900);
    }

    public void goSecondStep() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(nextSecondStepButton))
                .click();
    }

    public void chooseFileGsmColumn() {
        driver.findElement(By.cssSelector("select[id='fileGsmColumnSelect'] option[value='2']")).click();

    }

    public void createMessage(String message) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 6000);
        if (message.equals("file record")) {
            sleep(6000);
            WebElement addFile = driver.findElement(messageInput);
            ((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
            addFile.sendKeys("./src/test/resources/files/audios/audioVoice.mp3");
            sleep(6000);
        } else {
            sleep(6000);
            driver.findElement(modalTTS).click();
            wait.until(ExpectedConditions.elementToBeClickable(voicesAvailables)).click();
            wait.until(ExpectedConditions.elementToBeClickable(contentTSS)).sendKeys(message);
            wait.until(ExpectedConditions.elementToBeClickable(convertTTS)).click();
        }
//        inputNumer();
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
