package steps.WhatsApp;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.TestBase;

public class SendMessage extends TestBase {

    private static final long TIMEOUT = 5;
    @When("^the user select a template$")
    public void userSelectTemplate () {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        driver.findElement(By.xpath("//option[@value='1637']")).click();
        driver.findElement(By.xpath("//input[@id='inputGsmList']")).sendKeys("0987288333");
        driver.findElement(By.xpath("//button[@id='buttonProcess']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send']")))
                .click();

    }
}
