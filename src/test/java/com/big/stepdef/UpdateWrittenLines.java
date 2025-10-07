package com.big.stepdef;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.big.pageObjects.Authorization_SendAuthorizationEmailPage;

import com.big.pageObjects.ActuarialLegalAssignmentobj;
import com.big.pageObjects.CommonObj;
import com.big.pageObjects.ContractCasePagePreparation_Actions;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.Negotiation_QuotationTabPO;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.pageObjects.UpdateWrittenLines_Actions;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateWrittenLines {

	 
	Utilities ut = new Utilities();
	HomePage_Actions homeAtionobj= new HomePage_Actions();
	TestReusables tR=new  TestReusables();
	UpdateWrittenLines_Actions writtenLine = new UpdateWrittenLines_Actions();
	CommonObj co = new CommonObj();
	QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
	HomePage_Actions homeActionObj = new HomePage_Actions();
	ContractCasePagePreparation_Actions contractcasePreparationObj = new ContractCasePagePreparation_Actions();
	public  RemoteWebDriver driver= ut.getDriver();
	    
	
	
	
	@And("User Enter first Written line from {string}")
	public void firstWriitenLine(String testCaseID) throws InterruptedException {

		
	     Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);

	        String WrittenLine_1 = data.get("WrittenLine_1");
	        writtenLine.updateWrittenLine1(WrittenLine_1);
	        
	        System.out.println("Entered First Wrriten Line is"+WrittenLine_1 );
	       
	
	
	
	
}
	
	@And("User Enter Second Written line from {string}")
	public void secondWriitenLine(String testCaseID) throws InterruptedException {
		
	     Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);

	        String WrittenLine_2 = data.get("WrittenLine_2");
	        writtenLine.updateWrittenLine2(WrittenLine_2);
	        System.out.println("Entered Second Wrriten Line is "+WrittenLine_2);
	
	        
	        
}
	
	 @And("User click on Save button")
	    public void user_click_on_Save_button() throws InterruptedException {
		 writtenLine.clickupsavebutton();
	    }
	 
	 @Then("Written lines should be updated {string}")
	    public void the_upfront_analysis_should_be_submited(String testCaseID) throws InterruptedException {
		 Thread.sleep(3000);
		 writtenLine.verifyWrittenLines(testCaseID);
	    }
 
}