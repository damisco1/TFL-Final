package com.bdd.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features =  "src/test/Features", glue =
        "com/bdd/steps/MyStepdefs", plugin = { "pretty", "html:target/LaptopFeatureRunner.html",
        "json:target/LaptopFeatureRunner.json"}, monochrome = true)

public class TestRunner  {

//   extends AbstractTestNGCucumberTests
//    TestNGCucumberRunner testngcucumber =new TestNGCucumberRunner(this.getClass());

}

