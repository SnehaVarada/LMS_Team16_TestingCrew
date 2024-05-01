
package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions (features={ "src/test/resources/FeaturesFile/1_Login.feature" }, 
glue= {"com.StepDefinitions","com.PageObject"},
monochrome=true,
dryRun=false,
plugin= {"pretty",
		"html:target/htmlReports/report.html",
		//"json:target/jsonReports/report.json",
     // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
      //  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
     //  "timeline:target/timeline"
         })
public class TestRunner extends AbstractTestNGCucumberTests {
}



