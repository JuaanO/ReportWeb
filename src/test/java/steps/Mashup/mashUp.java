package steps.Mashup;

import io.cucumber.java.en.Given;
import steps.TestBase;

public class mashUp extends TestBase {

    @Given("^a user logged to Tellit choose a (.*?)$")
    public void aUserLoggedToTellitChooseAnOption(String option) {
        mashUpPage.chooseOption(option);
    }
}
