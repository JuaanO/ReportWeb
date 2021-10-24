package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class VoicePage {
    
    private final WebDriver driver;
    private final int TIMEOUT = 30;

    private final By numberInput, messageInput, processButton, sendButton;

    public VoicePage(WebDriver driver) {
        this.driver = driver;
        numberInput = By.xpath("//*[@id='selectName']");
        messageInput = By.xpath("//*[@id='file-input']");
        processButton = By.xpath("//*[@data-target='#modalEnviarSMS']");
        sendButton = By.xpath("//*[@id='buttonSend']");
    }

    public void createMessage() throws InterruptedException {
        sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, 6000);

//        new WebDriverWait(driver, 6000).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        wait.until(ExpectedConditions.presenceOfElementLocated(numberInput)).sendKeys("1234");

        WebElement addFile = driver.findElement(messageInput);
        ((RemoteWebElement)addFile).setFileDetector(new LocalFileDetector());
        addFile.sendKeys("./src/test/resources/files/audios/audioVoice.mp3");
        wait.until(ExpectedConditions.elementToBeClickable(numberInput)).sendKeys("400");

    }

    public void sendMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 6000);
        wait.until(ExpectedConditions.elementToBeClickable(processButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }
}
