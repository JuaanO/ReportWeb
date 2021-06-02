package steps.Report;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.TestBase;

public class DownloadReport extends TestBase {

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
        mashUpPage.downloadReport();
    }

}
