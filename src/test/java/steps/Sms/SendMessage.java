package steps.Sms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.TestBase;
import java.io.IOException;

public class SendMessage extends TestBase {

    @When("^the user chooses a massive sms campaign option$")
    public void theUserChoosesAMassiveSmsCampaignOption() {
        smsPage.chooseMassiveCampaign();
    }

    @And("^the user selects recipient (.*?)$")
    public void theUserSelectsRecipientSource(String source) throws InterruptedException {
        smsPage.chooseDataSource(source);
    }

    @And("^the user selects message (.*?)$")
    public void theUserSelectsMessageType(String type) {
        smsPage.chooseTypeMessage(type);
    }

    @And("the user chooses group")
    public void userChoosesGroup() {
        smsPage.chooseGroup();
        smsPage.loadGroup();
    }

    @And("the user goes to the second step")
    public void userGoSecondStep() {
        smsPage.goSecondStep();
    }

    @And("^the user enter values of second step$")
    public void enterValuesOfSecondStep() {
        smsPage.inputChampaignName();
        smsPage.message("datos");
    }

    @And("^the user goes to the third step")
    public void userGoToThirdStep() {
        smsPage.goToThirdStep();
    }

    @Then("^the user verify data of campaign$")
    public void serVerifyDataCampaign() throws InterruptedException {
        smsPage.verify();
    }

    @And("^el usuario ingresa (.*?) del paso 2$")
    public void elUsuarioIngresaLosDatosDelPaso(String datos) {
        smsPage.message(datos);
    }

    @When("^the user do a (.*?) with (.*?) status$")
    public void theUserOdACampaignWithValidStatus(String type, String status) throws IOException, InterruptedException {
        smsPage.createMessage(type);
        smsPage.sendMessage();
    }
}
