import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/features",
                glue = {"steps"},
                tags = {"@p1, @p2"},
                plugin = {
                "pretty","html:target/cucumber-report",
                "json:target/cucumber-report/cucumber.json"
                })
public class Run extends AbstractTestNGCucumberTests{
}
