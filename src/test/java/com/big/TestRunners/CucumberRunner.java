package com.big.TestRunners;

import org.junit.runner.RunWith;

//import org.junit.runner.RunWith;

import com.big.utils.Utilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features = {"src/test/java/com/big/features"},
glue={"com.big.stepdef"},
monochrome = true, 
//tags = "@qa1",
tags = "@ReassignUnderwriter",
//tags = "@AssignUnderwriter", 
//tags = "@createCase",
dryRun = false
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
	
	
	{
		Utilities util = new Utilities();
		util.extentTestMeta();
    
	}
	
}
