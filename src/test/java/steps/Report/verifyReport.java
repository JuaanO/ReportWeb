package steps.Report;

import io.cucumber.java.en.When;
import steps.TestBase;

public class verifyReport extends TestBase {

    @When("^the user selected a detailed report of SMS$")
    public void theUserFillTheForm() {
        detailedReportPage.openMenu();

    }
}
