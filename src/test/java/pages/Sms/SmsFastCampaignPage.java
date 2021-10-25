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
    private final By numberInput, messageInput, processButton, sendButton, sendSampleButton;
    private final By normalShipping, flashShipping, premiumShipping, groupCombobox;
    private final By normalSms, flashSms, docSms, premiumSms, rcsSms, navMassiveCampaign;
//    private final By closeModal, reportOption, reportSmsOption;
//    private final By nextTwoStepButton, nextSecondStepButton, selectFileCombobox, columnGsmCombobox;
//    private final By openModalButton, selectTypeSampleCombobox, selectNumberToSendInput;
//    private final By groupElemnt, loadGroupButton, nameCampaignInput, contentCampaignInput;

    public SmsFastCampaignPage(WebDriver driver) {
        this.driver = driver;
        numberInput = By.xpath("//*[@id='inputGsmList']");
        messageInput = By.xpath("//*[@id='txtMessage']");
        processButton = By.xpath("//*[@id='buttonProcess']");
        sendButton = By.xpath("//*[@id='buttonSend']");
        normalShipping = By.xpath("//label[normalize-space()='Normal shipping']");
        groupCombobox = By.xpath("//option[normalize-space()='Groups']");
        sendSampleButton = By.xpath("//*[@id='goToSendSamples']");
        flashShipping = By.xpath("//label[normalize-space()='Flash shipping']");
        premiumShipping = By.xpath("//label[normalize-space()='Premium shipping']");
        normalSms = By.xpath("//option[normalize-space()='Normal SMS']");
        flashSms = By.xpath("//option[normalize-space()='Flash SMS']");
        docSms = By.xpath("//option[normalize-space()='Attached Doc']");
        rcsSms = By.xpath("//option[normalize-space()='RCS']");
        premiumSms = By.xpath("//option[@value='7']");
        navMassiveCampaign = By.xpath("//*[@id='navSendArchive']");
//        closeModal = By.xpath("//*[@id='buttonClose']");
//        reportOption = By.xpath("//a[@data-target='#Reportes']");
//        reportSmsOption = By.xpath("//ul[@id='Reportes']//li[2]//a[1]");
//        groupElemnt = By.xpath("//label[@for='exampleCheck1']");
//        nameCampaignInput = By.xpath("//input[@id='campaignNameInput']");
//        loadGroupButton = By.xpath("//*[@id='loadAddreseesByGroup']");
//        contentCampaignInput = By.xpath("//*[@id='campaignContent']");
//        nextTwoStepButton = By.xpath("//*[@id='stepTwoNextBtn']");
//        selectFileCombobox = By.xpath("//input[@type='file']");
//        columnGsmCombobox = By.xpath("//select[@id='fileGsmColumnSelect']//option[@value='2']");
//        nextSecondStepButton = By.xpath("//button[normalize-space()='Next']");
//        openModalButton = By.xpath("//*[@id='goToSample']");
//        selectNumberToSendInput = By.xpath("//*[@id='receiverSMSSample']");
//        selectTypeSampleCombobox = By.xpath("//*[@id='typeSample']/option[2]");

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

    public void chooseTypeMessage(String type) throws InterruptedException {
        switch (type.toLowerCase(Locale.ROOT).trim()) {
            case "normal sms":
                driver.findElement(normalSms).click();
                sleep(500);
                break;
            case "flash sms":
                driver.findElement(flashSms).click();
                sleep(500);
                break;
            case "attached doc":
                driver.findElement(docSms).click();
                sleep(500);
                break;
            case "premium sms":
                driver.findElement(premiumSms).click();
                sleep(500);
                break;
            case "rcs":
                driver.findElement(rcsSms).click();
                sleep(500);
                break;
        }
    }
}
