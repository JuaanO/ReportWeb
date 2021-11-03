package steps.Voice;

import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.TestBase;

import java.io.IOException;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class VoiceMassiveCampaign extends TestBase {

    private final int TIMEOUT = 30;

    @When("^the user choose a (.*?) and select (.*?) of campaign$")
    public void chooseSourceAndType(String source, String type) throws InterruptedException, IOException {
//        sleep(20000);
        voiceMassiveCampaignPage.chooseMassiveCampaign();
        if (source.toLowerCase(Locale.ROOT).trim().contains("group")){
            voiceMassiveCampaignPage.sourceSelect();
            voiceMassiveCampaignPage.chooseGroup();
            voiceMassiveCampaignPage.loadGroup();
        }else if (source.toLowerCase(Locale.ROOT).trim().contains("file")) {
            whatsAppFastCampaignPage.getTemplate(type).click();
            whatsAppMassiveCampaignPage.loadFile();
            voiceMassiveCampaignPage.chooseFileGsmColumn();
        }
        voiceMassiveCampaignPage.goSecondStep();
//        sleep(20000);
    }


    @When("^the user upload a (.*?)$")
    public void fillDataOfCampaign(String message) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        if(message.equals("file record")){
//            voiceFastCampaignPage.createMessage(message);
            voiceMassiveCampaignPage.inputANameForCampaing();
//            whatsAppMassiveCampaignPage.inputANameForCampaing();
            voiceMassiveCampaignPage.createMessage(message);
        }else {
            voiceMassiveCampaignPage.inputANameForCampaing();
            voiceMassiveCampaignPage.createMessage(message);
//            whatsAppMassiveCampaignPage.selectTag();
        }
        voiceMassiveCampaignPage.tercerpaso();

    }
}
