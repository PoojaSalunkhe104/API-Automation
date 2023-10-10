package RunnerFile;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src\\test\\java\\features",
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","json:target/jsonReports/cucumber-report.json"},
        glue = "StepDefination" ,
     tags = {"@Regression"}
)
public class TestRunner {

}
