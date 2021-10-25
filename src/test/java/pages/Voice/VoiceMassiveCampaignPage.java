package pages.Voice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VoiceMassiveCampaignPage {
    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By numberInput, messageInput, processButton, sendButton;
    private final By modalTTS, voicesAvailables, contentTSS, convertTTS;

    public VoiceMassiveCampaignPage(WebDriver driver) {
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

}
