package steps.Wrapper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;
import static java.lang.Thread.sleep;

public class SendMessage extends TestBase {

    @When("^chooses a massive sms campaign option$")
    public void theUserChoosesAMassiveSmsCampaignOption() {
        smsPage.chooseMassiveCampaign();
    }

    @And("^selects and chooses recipient (.*?)$")
    public void theUserSelectsRecipientSource(String source) throws IOException, InterruptedException {
        if(source.toLowerCase(Locale.ROOT).trim().contains("group")){
            sleep(1000);
            smsPage.chooseDataSource();
            smsPage.chooseGroup();
            smsPage.loadGroup();
        } else if (source.toLowerCase(Locale.ROOT).trim().contains("file")){
            smsPage.loadFile();
            smsPage.chooseFileGsmColumn();
        }
    }

    @And("^selects a message (.*?)$")
    public void theUserSelectsMessageType(String type) throws InterruptedException {
        smsPage.chooseTypeMessage(type);
    }

    @And("goes to the second step")
    public void userGoSecondStep() throws IOException, InterruptedException  {
        smsPage.goSecondStep();
        sleep(5000);
    }

    @Then("^enters name and message for the campaign$")
    public void enterValuesOfSecondStep() throws IOException {
        smsPage.inputChampaignName();
        smsPage.message();
    }

    @And("^goes to the third step$")
    public void userGoToThirdStep() {
        smsPage.goToThirdStep();
    }

    @Then("^verify data of campaign$")
    public void theUserVerifyDataCampaign() throws InterruptedException {
        smsPage.verify();
    }

    @When("^the user do a (.*?) with (.*?)$")
    public void theUserDoACampaign (String type, String status) throws IOException, InterruptedException {
        switch (type.toLowerCase(Locale.ROOT).trim()) {
            case "normal shipping":
            case "premium shipping":
            case "flash shipping":
                smsPage.createMessage(type, status);
                smsPage.sendMessage();
                break;
            case "voice camping":
                logger.warn("ingreso a VOZ");
                voicePage.createMessage();
                voicePage.sendMessage();
                break;
            case "whatsapp":

                System.out.println("5");
                break;
        }
    }

    @And("^send a sample campaign$")
    public void theUserChooseSendASample() {
        smsPage.sendSample();
    }
}