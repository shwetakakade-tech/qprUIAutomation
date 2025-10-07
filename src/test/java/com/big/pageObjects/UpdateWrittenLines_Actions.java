package com.big.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.ScenarioContext;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import junit.framework.Assert;

public class UpdateWrittenLines_Actions extends TestReusables {

	
	 ScenarioContext sc = new ScenarioContext();
	    static Utilities ut = new Utilities();
	    public static RemoteWebDriver driver= ut.getDriver();
	    String testCaseID = "TC_007";
	    public UpdateWrittenLines_Actions() 
	    {
	        super();
	    }
	    
	   
	    @FindBy(xpath ="//tr[@data-dnd-name='row 2']//input")
		private  WebElement Wriitenline1;
		
		@FindBy(xpath ="//tr[@data-dnd-name='row 3']//input")
		private  WebElement Wriitenline2;
		
		@FindBy(xpath ="//span[contains(text(),'Save')]")
		private  WebElement save; 
		
		@FindBy(xpath ="//tbody/tr[1]/td[10]")
		private  WebElement UpdatedWriitenline1; 
		
		@FindBy(xpath ="//tbody/tr[2]/td[10]")
		private  WebElement UpdatedWriitenline2; 
		
		public void updateWrittenLine1(String Str) {
			click(Wriitenline1, "Update Written Line1");
			Wriitenline1.clear();
			enterText(Wriitenline1, testCaseID,Str);
		}
		   
		
		public void updateWrittenLine2(String Str1) {
			click(Wriitenline1, "Update Written Line1");
			Wriitenline2.clear();
			enterText(Wriitenline2, testCaseID,Str1);
		}
		
		public void clickupsavebutton() {
		    click(save, "Save button Update WrittenLines");
		    
		}
		
		public void verifyWrittenLines(String testCaseID) throws InterruptedException
		{
			Thread.sleep(3000);
			String ActualResult = UpdatedWriitenline1.getText();
			System.out.print("Actual Updated Written Line 1 is "+ActualResult);
			Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
	        String expected = data.get("WrittenLine_1");
			Assert.assertEquals(expected, ActualResult);
			
			String ActualResult1 = UpdatedWriitenline2.getText();
			System.out.print("Actual Updated Written Line 2 is "+ActualResult);
			Map<String, String> data1 = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
	        String expected1 = data1.get("WrittenLine_2");
			Assert.assertEquals(expected1, ActualResult1);
			
		}
		
		
}