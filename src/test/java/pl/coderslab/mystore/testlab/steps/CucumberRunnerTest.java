package pl.coderslab.mystore.testlab.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/pl/coderslab/mystore/testlab/features/",
        glue = "pl.coderslab.mystore.testlab.steps")

public class CucumberRunnerTest {
}
