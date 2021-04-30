package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class SmsPage {

    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By numberInput, messageInput, processButton, sendButton;
    private final By closeModal, reportOption, reportSmsOption;
    private final By normalShipping, flashShipping, premiumShipping;
    private final By normalSms, flashSms, docSms, premiumSms;

    public SmsPage(WebDriver driver) {
        this.driver = driver;
        numberInput = By.xpath("//*[@id='inputGsmList']");
        messageInput = By.xpath("//*[@id='txtMessage']");
        processButton = By.xpath("//*[@id='buttonProcess']");
        sendButton = By.xpath("//*[@id='buttonSend']");
        closeModal = By.xpath("//*[@id='buttonClose']");
        reportOption = By.xpath("//a[@data-target='#Reportes']");
        reportSmsOption = By.xpath("//ul[@id='Reportes']//li[2]//a[1]");
        normalShipping = By.xpath("//label[normalize-space()='Normal shipping']");
        flashShipping = By.xpath("//label[normalize-space()='Flash shipping']");
        premiumShipping = By.xpath("//label[normalize-space()='Premium shipping']");
        normalSms = By.xpath("//option[normalize-space()='Normal SMS']");
        flashSms = By.xpath("//option[normalize-space()='Flash SMS']");
        docSms = By.xpath("//option[normalize-space()='Attached Doc']");
        premiumSms = By.xpath("//option[@value='7']");

    }

    public void inputNumber() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(numberInput))
                .sendKeys(props.getProperty("ValidNumber"));
    }

    public void inputMessage() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(messageInput))
                .sendKeys(props.getProperty("messageValidToSend"));
    }

    public void sendMessage() throws InterruptedException {
        driver.findElement(processButton).click();
        sleep(1000);
        driver.findElement(sendButton).click();
        sleep(1000);
    }

    public void chooseMassiveCampaign() {
        driver.findElement(By.xpath("//*[@id='navSendArchive']")).click();
    }

    public void chooseDataSource(String source) throws InterruptedException {

        if (source.equals("grupos")) {
            driver.findElement(By.xpath("//option[normalize-space()='Groups']")).click();
        } else {
            driver.findElement(By.xpath(""));
        }
    }

    public void chooseTypeMessage(String type) {
        switch (type) {
            case "Normal SMS":
                driver.findElement(normalSms).click();
                break;
            case "Flash SMS":
                driver.findElement(flashSms).click();
                break;
            case "Attached Doc":
                driver.findElement(docSms).click();
                break;
            case "Premium SMS":
                driver.findElement(premiumSms).click();
                break;
        }
    }

    public void chooseGroup() {

        driver.findElement(By.xpath("//label[@for='exampleCheck1']")).click();
    }

    public void loadGroup() {

        driver.findElement(By.xpath("//button[normalize-space()='Cargar']")).click();
    }

    public void inputChampaignName() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='campaignNameInput']")).sendKeys("prueba campana");

    }

    public void message(String datos) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='campaignContent']")).sendKeys("Texto de prueba");
    }

    public void goToThirdStep() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='stepTwoNextBtn']")))
                .click();
    }

    public void verify() throws InterruptedException {
        sleep(4000);

    }

    public void createMessage(String type) throws IOException {
        switch (type) {
            case "Normal shipping":
                driver.findElement(normalShipping).click();
                inputMessage();
                inputNumber();
                break;
            case "Premium shipping":
                driver.findElement(flashShipping).click();
                inputMessage();
                inputNumber();
                break;
            case "Flash shipping":
                driver.findElement(premiumShipping).click();
                inputMessage();
                inputNumber();
                break;
        }
    }

    public void goSecondStep() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")))
                .click();
    }
}
