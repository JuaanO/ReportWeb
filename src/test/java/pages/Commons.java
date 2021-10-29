package pages;

import helpers.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Commons {

    static Logger logger = LogManager.getLogger();
    private final WebDriver driver;
    private final By totalRecipients;
    private final int TIMEOUT = 30;
    public Commons(WebDriver driver) {
        this.driver = driver;
        totalRecipients = By.xpath("//p[@class='m-0 pl-3 number bold flex-nowrap']");
    }


    public int getTotalRecipients (By element){
        return Integer.parseInt(driver.findElement(element).getText());
    }

    public void verifyDataofCampaign() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        Properties props = new Properties();
        props.load(new FileReader("src/test/resources/config.properties"));
        wait.until(ExpectedConditions.presenceOfElementLocated(totalRecipients));
        Assert.assertTrue(getTotalRecipients(totalRecipients) >= 1);

//        WebElement referemcia = driver.findElement(By.xpath("//p[normalize-space()='"+ props.getProperty("messageForMasiveCampaign") + ": " + Helpers.generateDate() + "']"));
//        Assert.assertNotNull(referemcia);

        WebElement nombrecamp =driver.findElement(By.xpath("//p[normalize-space()='"+ props.getProperty("nameForMasiveCampaign") +"']"));
        Assert.assertNotNull(driver.findElement(By.xpath("//p[normalize-space()='"+ props.getProperty("nameForMasiveCampaign") +"']")));

//        Assert.assertArrayEquals( "2", referemcia, "d");
        Assert.assertEquals(nombrecamp.getText(), "Selenium Massive Campaign");

    }
//
//    public WebElement getTemplate (String template){
//        WebElement tem = driver.findElement(By.xpath("//option[normalize-space()='"+template+"']"));
//        return tem;
//    }
//
//    public boolean isElementVisible(String cssLocator){
//        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
//    }
//
//    public boolean isElementPresent(String locatorKey) {
//        try {
//            getTemplate(locatorKey);
////            driver.findElement(By.xpath("//option[normalize-space()='"+locatorKey+"']"));
////            driver.findElement(By.xpath(locatorKey));
////            logger.error("esta en el true"+locatorKey);
//            System.out.println("esta en el true"+locatorKey);
//            return true;
//        } catch (org.openqa.selenium.NoSuchElementException e) {
////            logger.error("esta en el false"+locatorKey);
//            System.out.println("esta en el false"+locatorKey);
//            return false;
//        }
//    }

}
