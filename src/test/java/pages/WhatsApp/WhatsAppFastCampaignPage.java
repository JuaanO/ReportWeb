package pages.WhatsApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Commons;

public class WhatsAppFastCampaignPage {
    private static final long TIMEOUT = 5;
    private final WebDriver driver;
    static Logger logger = LogManager.getLogger();
    private final By selectFileCombobox,inputnumber;
//            template;

    public WhatsAppFastCampaignPage(WebDriver driver) {
        this.driver = driver;
        selectFileCombobox = By.xpath("//input[@type='file']");
        inputnumber = By.xpath("//input[@id='inputGsmList']");
//        template = By.xpath("//option[normalize-space()='Template SeleniumWhatsApp']");
    }

    public WebElement getTemplate (String template){
        WebElement tem = driver.findElement(By.xpath("//option[normalize-space()='"+template+"']"));
        return tem;
    }


    public boolean isElementPresent(String locatorKey) {
        try {
            getTemplate(locatorKey);
//            driver.findElement(By.xpath("//option[normalize-space()='"+locatorKey+"']"));
//            driver.findElement(By.xpath(locatorKey));
//            logger.error("esta en el true"+locatorKey);
            System.out.println("esta en el true"+locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
//            logger.error("esta en el false"+locatorKey);
            System.out.println("esta en el false"+locatorKey);
            return false;
        }
    }

    public boolean isElementVisible(String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
    }


    public void inputNumber(){
        driver.findElement(inputnumber).sendKeys("0987288333");

    }

    public void sendMessage(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        driver.findElement(By.xpath("//button[@id='buttonProcess']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send']")))
                .click();
    }

    public void FastSend(String attached) {

//        logger.error(attached);
//        driver.findElement(By.xpath(getTemplate(attached))).click();
//        driver.findElement(By.xpath(getTemplate(attached))).click();
//        Commons commons = new Commons(driver);
//        commons.getTemplate(attached);
        getTemplate(attached).click();
//        commons

//        logger.error(isElementPresent(String.valueOf(getTemplate(attached))));
//        logger.error(isElementPresent());

//        getTemplate(attached).click();
//        isElementPresent(getTemplate(attached));
//        Assert.assertFalse(isElementPresent(getTemplate(attached)));
//        isElementPresent("");
        inputNumber();
        sendMessage();
//        Assert.assertFalse();
//        driver.findElement(By.xpath("//button[@id='buttonProcess']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send']")))
//                .click();
    }

}
