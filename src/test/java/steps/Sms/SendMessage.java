package steps.Sms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.TestBase;
import java.io.IOException;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class SendMessage extends TestBase {

    private static final long TIMEOUT = 5;

    @When("^the user chooses a massive sms campaign option$")
    public void theUserChoosesAMassiveSmsCampaignOption() {
        smsPage.chooseMassiveCampaign();
    }

    @And("^the user selects and chooses recipient (.*?)$")
    public void theUserSelectsRecipientSource(String source) throws InterruptedException {
        if(source.toLowerCase(Locale.ROOT).trim().equals("grupos")){
            smsPage.chooseDataSource();
            smsPage.chooseGroup();
            smsPage.loadGroup();
        } else if (source.toLowerCase(Locale.ROOT).trim().equals("archivo")){
            WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
            ((RemoteWebElement)addFile).setFileDetector(new LocalFileDetector());
            addFile.sendKeys("src/test/resources/files/csv/fileColombia8001Contacs.csv");
            WebElement selectPhones = driver.findElement(By.xpath("//select[@id='fileGsmColumnSelect']//option[@value='2']"));
            selectPhones.click();
        }
    }

    @And("^the user selects message (.*?)$")
    public void theUserSelectsMessageType(String type) throws InterruptedException {
        smsPage.chooseTypeMessage(type);
        sleep(500);
    }

    @And("the user goes to the second step")
    public void userGoSecondStep() {
        smsPage.goSecondStep();
    }

    @And("^the user enters name and message for the campaign$")
    public void enterValuesOfSecondStep() throws IOException {
        smsPage.inputChampaignName();
        smsPage.message();
    }

    @And("^the user goes to the third step")
    public void userGoToThirdStep() {
        smsPage.goToThirdStep();
    }

    @Then("^the user verify data of campaign$")
    public void serVerifyDataCampaign() throws InterruptedException {
        smsPage.verify();
    }

    @When("^the user do a (.*?) with (.*?) status$")
    public void theUserOdACampaignWithValidStatus(String type, String status) throws IOException, InterruptedException {
        smsPage.createMessage(type, status);
        smsPage.sendMessage();
    }

    @And("^the user choose send a sample$")
    public void theUserChooseSendASample() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='goToSample']")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='typeSample']/option[2]")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='receiverSMSSample']")))
                .sendKeys("400");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='goToSendSamples']"))).click();
    }
}
