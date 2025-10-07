package com.big.testNGscripts;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class TestNGInitiation {
	Utilities util = new Utilities();
	TestReusables tr = new TestReusables();
	@BeforeMethod(alwaysRun = true)
	public void intiateTest() {
		try {
			util.intiateBrowser();
			util.launchwebsite(util.getProeprty("URL"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closedBrowser(ITestResult testResult, ITestContext testContext) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			ExtentTestManager.getTest().addScreenCaptureFromBase64String(tr.takeBase64Screenshot(), "Screenshot");
		}
		util.quitBrowser();
		
	}
	
	@BeforeSuite(alwaysRun = true)
	public void testInfo() {
		util.extentTestMeta();
	}
	
}
