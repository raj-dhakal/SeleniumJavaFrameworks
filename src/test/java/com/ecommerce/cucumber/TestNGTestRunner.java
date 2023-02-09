package com.ecommerce.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/com/ecommerce/cucumber",glue="com/ecommerce/stepdefinitions",
monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
