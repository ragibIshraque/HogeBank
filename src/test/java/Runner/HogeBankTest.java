package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/", //the path of the feature files
        glue = {"org.anymindgroup.ragib"}, //the path of the step definition files
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false //to check the mapping is proper between feature file and step def file
        //tags = { "~@RegressionTest", "~@End2End"}
)

public class HogeBankTest {

}