package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features={"src/test/resources/AppFeatures/AddToCart.feature"},
		glue= {"StepDefinitions"},
		monochrome=true
		)
public class AddToCart extends AbstractTestNGCucumberTests{

}
