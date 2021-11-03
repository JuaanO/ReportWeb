package steps.Sms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class SmsMassiveCampaign extends TestBase {

    @When("^chooses a massive sms campaign option$")
    public void theUserChoosesAMassiveSmsCampaignOption() {
        smsMassiveCampaignPage.chooseMassiveCampaign();
    }

    @And("^selects and chooses recipient (.*?)$")
    public void theUserSelectsRecipientSource(String source) throws IOException, InterruptedException {
        if (source.toLowerCase(Locale.ROOT).trim().contains("group")) {
            sleep(1000);
            smsMassiveCampaignPage.chooseDataSource();
            smsMassiveCampaignPage.chooseGroup();
            smsMassiveCampaignPage.loadGroup();
        } else if (source.toLowerCase(Locale.ROOT).trim().contains("file")) {
            smsMassiveCampaignPage.loadFile();
            smsMassiveCampaignPage.chooseFileGsmColumn();
        }
    }

    @And("^selects a message (.*?)$")
    public void theUserSelectsMessageType(String type) throws InterruptedException, IOException {
        smsMassiveCampaignPage.chooseTypeMessage(type);
        userGoSecondStep();
    }

    @And("goes to the second step")
    public void userGoSecondStep() throws IOException, InterruptedException {
        smsMassiveCampaignPage.goSecondStep();
        sleep(5000);
    }

    @Then("^enters name and message for the campaign$")
    public void enterValuesOfSecondStep() throws IOException {
        smsMassiveCampaignPage.inputChampaignName();
        smsMassiveCampaignPage.message();
        userGoToThirdStep();
    }

    @And("^goes to the third step$")
    public void userGoToThirdStep() {
        smsMassiveCampaignPage.goToThirdStep();
    }


    @And("^send a sample campaign$")
    public void theUserChooseSendASample() {
        smsMassiveCampaignPage.sendSample();
    }

}
