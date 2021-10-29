package steps.Commons;

import io.cucumber.java.en.When;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class FastCampaign extends TestBase {

    @When("^the user do a (.*?) with a (.*?)$")
    public void theUserDoACampaign(String type, String attached) throws IOException, InterruptedException {
        switch (type.toLowerCase(Locale.ROOT).trim()) {
            case "normal shipping":
            case "premium shipping":
            case "flash shipping":
                smsFastCampaignPage.createMessage(type, attached);
                smsFastCampaignPage.sendMessage();
                break;
            case "voice fast camping":
                voiceFastCampaignPage.createMessage(attached);
//                voiceFastCampaignPage.sendMessage();
                sleep(9999);
                break;
            case "whatsapp fast campaign":
                whatsAppFastCampaignPage.FastSend(attached);
                sleep(9999);
                break;
        }
    }
}