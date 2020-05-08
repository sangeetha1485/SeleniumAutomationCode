package CucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",//path of feature file
		glue={"stepDefinition"},//path of step definition file
		format= {"pretty","html:test-output","json:json_output/cucumber.json","junit:jnuit_xml/cucumber.xml"}//to generate different types of reporting
		//monochrome=true,//display the console output in proper readable format
		//strict=true,//it will check if any step is not defined in step definition file
		//dryRun=true//to check mapping is proper between feature file and step def file
		)

public class TestRunner {

}