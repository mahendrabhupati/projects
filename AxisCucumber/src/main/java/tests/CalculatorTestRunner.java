package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features = {"src/main/java/feature/demo.feature"}, 
		glue= {"helpers", "stepDefinition"},  		
		plugin = {"pretty", "html:reports/cucumber-html-report"},
		monochrome = true
		//strict = true
		//dryRun=true
		)
public class CalculatorTestRunner {
}
