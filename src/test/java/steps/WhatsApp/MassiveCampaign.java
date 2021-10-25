package steps.WhatsApp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class MassiveCampaign extends TestBase {

    private static final long TIMEOUT = 5;
    @When("^chooses a massive whatsapp campaign option$")
    public void theUserChoosesAMassiveSmsCampaignOption() {
        whatsAppMassiveCampaignPage.chooseMassiveCampaign();
    }

    @And("^Selects and chooses recipient (.*?) de ws")
    public void theUserSelectsRecipientSource(String source) throws IOException, InterruptedException {
        if(source.toLowerCase(Locale.ROOT).trim().contains("group")){
            sleep(1000);
            whatsAppMassiveCampaignPage.chooseDataSource();
            whatsAppMassiveCampaignPage.chooseGroup();
            whatsAppMassiveCampaignPage.loadGroup();
        } else if (source.toLowerCase(Locale.ROOT).trim().contains("file")){

            whatsAppMassiveCampaignPage.loadFile();
            whatsAppMassiveCampaignPage.chooseFileGsmColumn();
        }
    }

    @And("^input a name for campaing$")
    public void inputANameForCampaing() throws IOException  {
        whatsAppMassiveCampaignPage.inputANameForCampaing();
    }

    @And("^goes to the third step en WS$")
    public void iratercer ()  throws IOException, InterruptedException  {
        whatsAppMassiveCampaignPage.tercerpaso();
        sleep(5000);
    }

}
