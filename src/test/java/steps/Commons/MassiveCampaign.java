package steps.Commons;

import io.cucumber.java.en.Then;
import steps.TestBase;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class MassiveCampaign extends TestBase {

    @Then("^verify data of campaign")
    public void theUserVerifyDataCampaign() throws InterruptedException, IOException {
        commons.verifyDataofCampaign();
        sleep(5000);
    }

}
