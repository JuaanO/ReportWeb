package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        plugin = { "pretty" ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/report/cucumber/cucumber.json",
                "html:target/report/cucumber/cucumber.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class runTest {

}
