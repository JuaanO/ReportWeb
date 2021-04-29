package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public SmsPage(WebDriver driver){
        this.driver = driver;
        numberInput = By.xpath("//*[@id='inputGsmList']");
        messageInput = By.xpath("//*[@id='txtMessage']");
        processButton = By.xpath("//*[@id='buttonProcess']");
        sendButton = By.xpath("//*[@id='buttonSend']");
        closeModal = By.xpath("//*[@id='buttonClose']");
        reportOption = By.xpath("//a[@data-target='#Reportes']");
        reportSmsOption = By.xpath("//ul[@id='Reportes']//li[2]//a[1]");

    }

    public void createMessage(String type) throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        if (type.equals("valid")){
            driver.findElement(numberInput).sendKeys(props.getProperty("ValidNumber"));
            wait.until(ExpectedConditions.presenceOfElementLocated(messageInput))
                    .sendKeys(props.getProperty("messageValidToSend"));
        } else {
            driver.findElement(numberInput).sendKeys(props.getProperty("InvalidNumber"));
            wait.until(ExpectedConditions.presenceOfElementLocated(messageInput))
                    .sendKeys(props.getProperty("messageInvalidToSend"));
        }
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

    public void chooseDataSource(String fuente) throws InterruptedException{

        if(fuente.equals("grupos")){
//            driver.findElement(By.xpath("//select[@id='addresseeSourceSelect']")).click();
//            sleep(3000);
            driver.findElement(By.xpath("//option[normalize-space()='Groups']")).click();
            sleep(3000);
        }else {
            driver.findElement(By.xpath(""));
        }
    }

    public void chooseTypeMessage(String tipo) {
        switch (tipo){
            case "Normal SMS":
                driver.findElement(By.xpath("//option[normalize-space()='Normal SMS']")).click();
                break;
            case "Flash SMS":
                driver.findElement(By.xpath("//option[normalize-space()='Flash SMS']")).click();
                break;
            case "Attached Doc":
                driver.findElement(By.xpath("//option[normalize-space()='Attached Doc']")).click();
                break;
            case "Premium SMS":
                driver.findElement(By.xpath("//option[@value='7']")).click();
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
        driver.findElement(By.xpath("//input[@id='campaignNameInput']")).sendKeys("prueba campana");

    }

    public void message(String datos) {
        driver.findElement(By.xpath("//*[@id='campaignContent']")).sendKeys("Texto de prueba");
        //*[@id="campaignContent"]
    }

    public void nextStep() {
        driver.findElement(By.xpath("//*[@id='stepTwoNextBtn']")).click();
    }
}
