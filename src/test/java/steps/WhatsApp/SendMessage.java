package steps.WhatsApp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class SendMessage extends TestBase {

    private static final long TIMEOUT = 5;
    @When("^chooses a massive whatsapp campaign option$")
    public void theUserChoosesAMassiveSmsCampaignOption() {
        whatsAppPage.chooseMassiveCampaign();
    }

    @When("^the user select a template$")
    public void userSelectTemplate () {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        driver.findElement(By.xpath("//option[@value='1637']")).click();
        driver.findElement(By.xpath("//input[@id='inputGsmList']")).sendKeys("0987288333");
        driver.findElement(By.xpath("//button[@id='buttonProcess']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send']")))
                .click();
    }

    @And("^Selects and chooses recipient (.*?) de ws")
    public void theUserSelectsRecipientSource(String source) throws IOException, InterruptedException {
        if(source.toLowerCase(Locale.ROOT).trim().contains("group")){
            sleep(1000);
            whatsAppPage.chooseDataSource();
            whatsAppPage.chooseGroup();
            whatsAppPage.loadGroup();
        } else if (source.toLowerCase(Locale.ROOT).trim().contains("file")){

            whatsAppPage.loadFile();
            whatsAppPage.chooseFileGsmColumn();
        }
    }


    @And("^selectc template$")
    public void selectcTemplate() {
        driver.findElement(By.xpath("//option[@value='1637']")).click();
    }

    @And("^input a name for campaing$")
    public void inputANameForCampaing() throws IOException  {
        whatsAppPage.inputANameForCampaing();

    }

    @And("^goes to the third step en WS$")
    public void iratercer ()  throws IOException, InterruptedException  {
        whatsAppPage.tercerpaso();
        sleep(5000);
    }

}
