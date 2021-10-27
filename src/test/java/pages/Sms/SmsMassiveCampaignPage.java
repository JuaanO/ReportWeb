package pages.Sms;

import helpers.Helpers;
import io.cucumber.java.bs.A;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class SmsMassiveCampaignPage {
    static Logger logger = LogManager.getLogger();
    private final WebDriver driver;
    private final int TIMEOUT = 30;
    private final By nextTwoStepButton, nextSecondStepButton, selectFileCombobox, columnGsmCombobox,navMassiveCampaign;
    private final By openModalButton, selectTypeSampleCombobox, selectNumberToSendInput, sendSampleButton;
    private final By groupElemnt, loadGroupButton, nameCampaignInput, contentCampaignInput,groupCombobox;
    private final By normalSms, flashSms, docSms, premiumSms, rcsSms, totalRecipients;

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
        normalSms = By.xpath("//option[normalize-space()='Normal SMS']");
        flashSms = By.xpath("//option[normalize-space()='Flash SMS']");
        docSms = By.xpath("//option[normalize-space()='Attached Doc']");
        rcsSms = By.xpath("//option[normalize-space()='RCS']");
        premiumSms = By.xpath("//option[@value='7']");
        totalRecipients = By.xpath("//p[@class='m-0 pl-3 number bold flex-nowrap']");
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
//
//    public int getTotalRecipients (By element){
//        return Integer.parseInt(driver.findElement(element).getText());
//    }
//
//    public void verifyTotalRecipients() throws InterruptedException, IOException {
//        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
//
//        Properties props = new Properties();
//        props.load(new FileReader("src/test/resources/config.properties"));
//        wait.until(ExpectedConditions.presenceOfElementLocated(totalRecipients));
//        Assert.assertTrue(getTotalRecipients(totalRecipients) >= 1);
//
//        WebElement referemcia = driver.findElement(By.xpath("//p[normalize-space()='"+ props.getProperty("messageForMasiveCampaign") + ": " + Helpers.generateDate() + "']"));
////        Assert.assertNotNull();
//
//        WebElement nombrecamp =driver.findElement(By.xpath("//p[normalize-space()='"+ props.getProperty("nameForMasiveCampaign") +"']"));
//        Assert.assertNotNull(driver.findElement(By.xpath("//p[normalize-space()='"+ props.getProperty("nameForMasiveCampaign") +"']")));
//
////        Assert.assertArrayEquals( "2", referemcia, "d");
//        Assert.assertEquals(nombrecamp.getText(), "Selenium Massive Campaign");
//
////        WebElement a = ;
//        logger.error(driver.findElement(By.xpath("//p[normalize-space()='"+ props.getProperty("nameForMasiveCampaign") +"']")));
//
////        sendKeys();
//
//
////        logger.error("getText: " + getTotal(totalRecipients));
////        logger.error("getText: " + driver.findElement(totalRecipients).getText());
////        logger.error("getAttribute: " + driver.findElement(totalRecipients).getAttribute("innerHTML").toString());
//
////        Assert.assertTrue(driver.findElement(totalRecipients).getText().contains("Products"));
////        try {
////            Assert.assertTrue(driver.findElement(totalRecipients).getText().contains("Products"));
////        }        catch (NoSuchElementException e){
//////            logger.error("El elemento no esta presente!! " + assetionMainPage);
////        }
//
//    }
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
