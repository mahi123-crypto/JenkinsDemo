package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features={"src/test/resources/AppFeatures/Login.feature"},
		glue= {"StepDefinitions"},	
		monochrome=true
		)
public class LoginTest extends AbstractTestNGCucumberTests{

}
