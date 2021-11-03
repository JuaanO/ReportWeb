package steps.WhatsApp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import steps.TestBase;

public class WhatsAppFastCampaign extends TestBase {

    @When("^the user select a (.*?)")
    public void userSelectTemplate (String template) {
        whatsAppFastCampaignPage.FastSend(template);
    }

    @And("^selectc template$")
    public void selectcTemplate() {
        driver.findElement(By.xpath("//option[@value='1637']")).click();
    }

}
