package Framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions
        (
                features = "@target/Failed_Scenario/failedscenarios.txt",
                glue = {"Framework.stepDef", "Framework.hooks"},
                monochrome = true,
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "rerun:target/Failed_Scenario/failedscenarios.txt"}
        )
@RunWith(Cucumber.class)
public class Failed_Runner { }