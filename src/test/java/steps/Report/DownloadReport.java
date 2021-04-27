package steps.Report;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.TestBase;

public class DownloadReport extends TestBase {
//
//    @Given("^a user logged to Tellit choose a (.*?)$")
//    public void aUserLoggedToTellitChooseASMS(String option) {
//
//        mainPage.chooseOption(option);
//    }
//
//    @When("^the user do a (.*?) campain$")
//    public void theUserDoAValidCampain(String campainType) throws IOException, InterruptedException {
//        smsPage.createMessage(campainType);
//        smsPage.sendMessage();
//
//    }

//    @Given("^a user logged to Tellit choose a \"(.*?)\" option$")
//    public void aUserLoggedToTellitChooseAnOption(String option) {
//        mainPage.chooseOption(option);
//    }

    @Given("^a user logged to Tellit choose a (.*?) option$")
    public void aUserLoggedToTellitChooseAnOption(String option) {
        mainPage.chooseOption(option);
    }

    @When("^the user do a (.*?) campain$")
    public void theUserDoA(String campainType) throws Throwable {
        smsPage.createMessage(campainType);
        smsPage.sendMessage();
    }

    @When("^the user fill the form$")
    public void theUserFillTheForm() {
        detailedReportPage.assertionReportPage();
        detailedReportPage.fillForm("estrella", "Fast Send");
        detailedReportPage.searchReport();
    }

    @When("^the user fill the form detailed$")
    public void theUserFillTheFormDetailed() {
        detailedReportPage.assertionReportPage();
        detailedReportPage.fillForm("estrella", "Fast Send");
        detailedReportPage.searchReport();
        detailedReportPage.openDetailedFilter();
        detailedReportPage.clickIdSend();
    }

    @Then("^the user can download a report$")
    public void theUserCanDownloadAReport() throws Throwable {
        detailedReportPage.downloadReport();
        detailedReportPage.returnMainPage();
        mainPage.downloadReport();
    }

}
