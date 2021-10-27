package pages.Voice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.Thread.sleep;

public class VoiceFastCampaignPage {

    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By numberInput, messageInput, processButton, sendButton;
    private final By modalTTS, voicesAvailables, contentTSS, convertTTS;

    public VoiceFastCampaignPage(WebDriver driver) {
        this.driver = driver;
        numberInput = By.xpath("//*[@id='selectName']");
        messageInput = By.xpath("//*[@id='file-input']");
        processButton = By.xpath("//*[@data-target='#modalEnviarSMS']");
        sendButton = By.xpath("//*[@id='buttonSend']");
        modalTTS = By.xpath("//*[@data-target='#TTSModal']");
        voicesAvailables = By.xpath("//*[@formcontrolname='selectVoice']/option[4]");
        contentTSS = By.xpath("//*[@id='content']");
        convertTTS = By.xpath("//*[@id='TTSModal']/div/div/form/div/div[2]/button");
    }
    public void inputNumer() {
        WebDriverWait wait = new WebDriverWait(driver, 6000);
        wait.until(ExpectedConditions.elementToBeClickable(numberInput)).sendKeys("400");
    }

    public void createMessage(String attached) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 6000);
        if (attached.equals("file record")) {
            sleep(6000);
            WebElement addFile = driver.findElement(messageInput);
            ((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
            addFile.sendKeys("./src/test/resources/files/audios/audioVoice.mp3");
        } else {
            sleep(6000);
            driver.findElement(modalTTS).click();
            wait.until(ExpectedConditions.elementToBeClickable(voicesAvailables)).click();
            wait.until(ExpectedConditions.elementToBeClickable(contentTSS)).sendKeys(attached);
            wait.until(ExpectedConditions.elementToBeClickable(convertTTS)).click();
        }
        inputNumer();
    }

    public void sendMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 6000);
        wait.until(ExpectedConditions.elementToBeClickable(processButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }
}
