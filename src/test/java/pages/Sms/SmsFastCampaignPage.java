package pages.Sms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import static java.lang.Thread.sleep;

public class SmsFastCampaignPage {

    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By numberInput, messageInput, processButton, sendButton;
    private final By normalShipping, flashShipping, premiumShipping;
    private final By normalSms, flashSms, docSms, premiumSms, rcsSms;

    public SmsFastCampaignPage(WebDriver driver) {
        this.driver = driver;
        numberInput = By.xpath("//*[@id='inputGsmList']");
        messageInput = By.xpath("//*[@id='txtMessage']");
        processButton = By.xpath("//*[@id='buttonProcess']");
        sendButton = By.xpath("//*[@id='buttonSend']");
        normalShipping = By.xpath("//label[normalize-space()='Normal shipping']");
        flashShipping = By.xpath("//label[normalize-space()='Flash shipping']");
        premiumShipping = By.xpath("//label[normalize-space()='Premium shipping']");
        normalSms = By.xpath("//option[normalize-space()='Normal SMS']");
        flashSms = By.xpath("//option[normalize-space()='Flash SMS']");
        docSms = By.xpath("//option[normalize-space()='Attached Doc']");
        rcsSms = By.xpath("//option[normalize-space()='RCS']");
        premiumSms = By.xpath("//option[@value='7']");
    }

    public void createMessage(String type, String status) throws IOException, InterruptedException {

        switch (type.toLowerCase(Locale.ROOT).trim()) {
            case "normal shipping":
                driver.findElement(normalShipping).click();
                inputMessage();
                inputNumber(status.toLowerCase(Locale.ROOT).trim());
                break;
            case "premium shipping":
                driver.findElement(flashShipping).click();
                inputMessage();
                inputNumber(status.toLowerCase(Locale.ROOT).trim());
                break;
            case "flash shipping":
                driver.findElement(premiumShipping).click();
                inputMessage();
                inputNumber(status.toLowerCase(Locale.ROOT).trim());
                break;
        }
    }

    public void inputNumber(String status) throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        if (status.equals("valid")) {
            wait.until(ExpectedConditions.elementToBeClickable(numberInput))
                    .sendKeys(props.getProperty("ValidNumber"));
        } else if (status.equals("invalid")) {
            wait.until(ExpectedConditions.elementToBeClickable(numberInput))
                    .sendKeys(props.getProperty("InvalidNumber"));
        }
    }

    public void inputMessage() throws IOException, InterruptedException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(messageInput))
                .sendKeys(props.getProperty("messageValidToSend"));
    }

    public void sendMessage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(processButton)).click();
        sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

}
