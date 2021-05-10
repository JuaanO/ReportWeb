package pages;

import helpers.Helpers;
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

public class SmsPage {

    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By numberInput, messageInput, processButton, sendButton;
    private final By closeModal, reportOption, reportSmsOption;
    private final By normalShipping, flashShipping, premiumShipping;
    private final By normalSms, flashSms, docSms, premiumSms, navMassiveCampaign;

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
        navMassiveCampaign = By.xpath("//*[@id='navSendArchive']");

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
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(processButton)).click();
        sleep(800);
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public void chooseMassiveCampaign() {
        driver.findElement(navMassiveCampaign).click();
    }

    public void chooseDataSource(String source) throws InterruptedException {
        if (source.equals("grupos")) {
            driver.findElement(By.xpath("//option[normalize-space()='Groups']")).click();
        } else if (source.equals("archivo")) {
            WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
            ((RemoteWebElement)addFile).setFileDetector(new LocalFileDetector());
            addFile.sendKeys("src/test/resources/files/csv/phoneNumbers.csv");

            WebElement selectPhones = driver.findElement(By.xpath("//select[@id='fileGsmColumnSelect']//option[@value='2']"));
            selectPhones.click();
        } else  {
            System.out.println("Source not found!!");
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

    public void inputChampaignName() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='campaignNameInput']")))
                .sendKeys(props.getProperty("nameForMasiveCampaign"));
    }

    public void message(String datos) throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignContent']"))).sendKeys(props.getProperty("messageForMasiveCampaign") + ": " + Helpers.generateDate());
    }

    public void goToThirdStep() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='stepTwoNextBtn']")))
                .click();
    }

    public void verify() throws InterruptedException {
        sleep(500);

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
