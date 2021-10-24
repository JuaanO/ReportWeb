package steps.Commons;

import io.cucumber.java.en.When;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;

public class FastCampaign extends TestBase {

    @When("^the user do a (.*?) with a (.*?)$")
    public void theUserDoACampaign(String type, String status) throws IOException, InterruptedException {
        switch (type.toLowerCase(Locale.ROOT).trim()) {
            case "normal shipping":
            case "premium shipping":
            case "flash shipping":
                logger.info("-------> Entry to Sms!!");
                smsPage.createMessage(type, status);
                smsPage.sendMessage();
                break;
            case "voice fast camping":
                logger.info("-------> Entry to Voz!!");
                voicePage.createMessage();
                voicePage.sendMessage();
                break;
            case "whatsapp fast campaign":
                logger.info("-------> Entry to WhatsApp!!");
                whatsAppPage.FastSend(status);
                break;
        }
    }
}