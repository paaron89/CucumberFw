package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src\\test\\java\\BackendFeatures",
            glue = "stepDefinitions"
            //tags = {"@DeletePlace"}
    )
    public class CucumberRunnerBeTests {
}
