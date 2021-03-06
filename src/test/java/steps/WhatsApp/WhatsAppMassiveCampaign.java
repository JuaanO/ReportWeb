package steps.WhatsApp;

import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class WhatsAppMassiveCampaign extends TestBase {

    private static final long TIMEOUT = 5;

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
        }
        whatsAppMassiveCampaignPage.tercerpaso();
    }
}
