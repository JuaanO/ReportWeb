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

//    public void createMessageType(String type) throws IOException {
//        switch (type){
//        case "Valid":
//            createMessage(1);
//            break;
//        case "Invalid":
//            createMessage(2);
//            break;
//        }
//    }

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

    public void proccessMessage() throws InterruptedException {
        driver.findElement(processButton).click();
        sleep(1000);
    }

    public void sendMessage() throws InterruptedException {
        driver.findElement(processButton).click();
        sleep(1000);
        driver.findElement(sendButton).click();
        sleep(1000);
    }

    public void closeModal(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(closeModal));
        elemento.click();
    }

    public void chooseOption(){
        driver.findElement(reportOption).click();
        driver.findElement(reportSmsOption).click();
    }

    public void assertionSms(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Reporte Detallados']")).getText().contains("Reporte Detallados"));
    }
}
