package steps.WhatsApp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class MassiveCampaign extends TestBase {

    private static final long TIMEOUT = 5;
    @When("^the user choose a (.*?) without (.*?)$")
    public void theUserChoosesAMassiveSms (String template, String parameter) {
//        whatsAppMassiveCampaignPage.chooseMassiveCampaign();
    }

    @And("^the user choose a (.*?) and select a (.*?)$")
    public void theUserSelectsRecipientSource(String template, String source) throws IOException, InterruptedException {
        whatsAppMassiveCampaignPage.chooseMassiveCampaign();
        if(source.toLowerCase(Locale.ROOT).trim().contains("group")){
            sleep(1000);
            whatsAppMassiveCampaignPage.chooseDataSource();
            whatsAppMassiveCampaignPage.chooseGroup();
            whatsAppMassiveCampaignPage.loadGroup();
            whatsAppFastCampaignPage.getTemplate(template).click();
        } else if (source.toLowerCase(Locale.ROOT).trim().contains("file")){
            sleep(1000);
//            whatsAppMassiveCampaignPage.chooseDataSource();
            whatsAppFastCampaignPage.getTemplate(template).click();
            whatsAppMassiveCampaignPage.loadFile();
            whatsAppMassiveCampaignPage.chooseFileGsmColumn();
        }
        smsMassiveCampaignPage.goSecondStep();
    }

    @And("^the user fill up the necessary (.*?) in second step$")
    public void dataNecesary(String params) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        if(params.equals("without tags")){
            whatsAppMassiveCampaignPage.inputANameForCampaing();
        }else {
            whatsAppMassiveCampaignPage.inputANameForCampaing();
            whatsAppMassiveCampaignPage.selectTag();
//            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='multiselect-dropdown']")))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@class='item2']//li[1]")))).click();

        }
    }

    @And("^input a name for campaing$")
    public void inputANameForCampaing(String params) throws IOException, InterruptedException {
        if(params.equals("")){

            whatsAppMassiveCampaignPage.inputANameForCampaing();
        }else {
            whatsAppMassiveCampaignPage.inputANameForCampaing();
//            whatsAppMassiveCampaignPage.selectTag();
        }
    }

    @And("^goes to the third step en WS$")
    public void iratercer ()  throws IOException, InterruptedException  {
//        sleep(5000);
        whatsAppMassiveCampaignPage.tercerpaso();

    }

}
