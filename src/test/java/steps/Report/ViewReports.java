package steps.Report;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import steps.TestBase;

public class ViewReports extends TestBase {

    @Given("^the user select a (.*?) report option$")
    public void aUserLoggedToTellitChooseAnOption(String option) throws InterruptedException {
        smsReportPage.openMenu();
        smsReportPage.chooseOption(option);
    }

    @And("^the user fill the form with: ([^\"]*), ([^\"]*) & ([^\"]*)$")
    public void theUserFillTheFormWith(String user, String reference, String type) {
        smsReportPage.selectUser(user);
        smsReportPage.inputReference(reference);
        smsReportPage.selectType(type);
    }

    @And("^press the button of search report$")
    public void presstheButtonOfSearchReport() {
        smsReportPage.pressButtonSearch();
    }

    @Then("^the user only can see records of type (.*?) with status (.*?) in the reports table$")
    public void theUserOnlyCanSeeReportsWithStatus(String type, String status) {
        smsReportPage.seeTypeAndStatus(type,status);
    }

}
