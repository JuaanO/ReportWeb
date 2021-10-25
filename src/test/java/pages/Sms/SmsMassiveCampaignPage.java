package pages.Sms;

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

public class SmsMassiveCampaignPage {

    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By nextTwoStepButton, nextSecondStepButton, selectFileCombobox, columnGsmCombobox,navMassiveCampaign;
    private final By openModalButton, selectTypeSampleCombobox, selectNumberToSendInput, sendSampleButton;
    private final By groupElemnt, loadGroupButton, nameCampaignInput, contentCampaignInput,groupCombobox;
//    private final By normalShipping, flashShipping, premiumShipping ;
//    private final By normalSms, flashSms, docSms, premiumSms, rcsSms ;
//    private final By numberInput, messageInput, processButton, sendButton;
//    private final By closeModal, reportOption, reportSmsOption;

    public SmsMassiveCampaignPage(WebDriver driver) {
        this.driver = driver;
        groupCombobox = By.xpath("//option[normalize-space()='Groups']");
        groupElemnt = By.xpath("//label[@for='exampleCheck1']");
        nameCampaignInput = By.xpath("//input[@id='campaignNameInput']");
        loadGroupButton = By.xpath("//*[@id='loadAddreseesByGroup']");
        contentCampaignInput = By.xpath("//*[@id='campaignContent']");
        nextTwoStepButton = By.xpath("//*[@id='stepTwoNextBtn']");
        selectFileCombobox = By.xpath("//input[@type='file']");
        columnGsmCombobox = By.xpath("//select[@id='fileGsmColumnSelect']//option[@value='2']");
        nextSecondStepButton = By.xpath("//button[normalize-space()='Next']");
        openModalButton = By.xpath("//*[@id='goToSample']");
        selectNumberToSendInput = By.xpath("//*[@id='receiverSMSSample']");
        selectTypeSampleCombobox = By.xpath("//*[@id='typeSample']/option[2]");
        sendSampleButton = By.xpath("//*[@id='goToSendSamples']");
        navMassiveCampaign = By.xpath("//*[@id='navSendArchive']");
//        flashShipping = By.xpath("//label[normalize-space()='Flash shipping']");
//        premiumShipping = By.xpath("//label[normalize-space()='Premium shipping']");
//        normalSms = By.xpath("//option[normalize-space()='Normal SMS']");
//        flashSms = By.xpath("//option[normalize-space()='Flash SMS']");
//        docSms = By.xpath("//option[normalize-space()='Attached Doc']");
//        rcsSms = By.xpath("//option[normalize-space()='RCS']");
//        premiumSms = By.xpath("//option[@value='7']");
//        numberInput = By.xpath("//*[@id='inputGsmList']");
//        messageInput = By.xpath("//*[@id='txtMessage']");
//        processButton = By.xpath("//*[@id='buttonProcess']");
//        sendButton = By.xpath("//*[@id='buttonSend']");
//        closeModal = By.xpath("//*[@id='buttonClose']");
//        reportOption = By.xpath("//a[@data-target='#Reportes']");
//        reportSmsOption = By.xpath("//ul[@id='Reportes']//li[2]//a[1]");
//        normalShipping = By.xpath("//label[normalize-space()='Normal shipping']");

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

    public void inputChampaignName() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(nameCampaignInput))
                .sendKeys(props.getProperty("nameForMasiveCampaign"));
    }


    public void message() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(contentCampaignInput)).
                sendKeys(props.getProperty("messageForMasiveCampaign") + ": " + Helpers.generateDate());
    }

    public void goToThirdStep() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(nextTwoStepButton))
                .click();
    }

    public void verify() throws InterruptedException {
        sleep(500);
        //TENGO QUE HACRE AUN LA VALIDACION DE LA INFORMACION !!
    }
    public void goSecondStep() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(nextSecondStepButton))
                .click();
    }

    public void loadFile() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebElement addFile = driver.findElement(selectFileCombobox);
        ((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
        addFile.sendKeys(props.getProperty("pathForFileCSV"));
    }

    public void chooseFileGsmColumn() {
        WebElement selectPhones = driver.findElement(columnGsmCombobox);
        selectPhones.click();
    }

    public void sendSample() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(openModalButton))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(selectTypeSampleCombobox))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(selectNumberToSendInput))
                .sendKeys("400");
        wait.until(ExpectedConditions.elementToBeClickable(sendSampleButton)).click();
    }
}
