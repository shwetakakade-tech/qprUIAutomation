package com.big.stepdef;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.big.pageObjects.ActuarialLegalAssignmentobj;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.Negotiation_QuotationTabPO;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActuarialLegalAssignmentStep {

	 
	Utilities ut = new Utilities();
	HomePage_Actions homeAtionobj= new HomePage_Actions();
	ActuarialLegalAssignmentobj actuarialLegalobj = new ActuarialLegalAssignmentobj();
	Negotiation_QuotationTabPO negotiationQuotationObj = new Negotiation_QuotationTabPO();
	TestReusables tR=new  TestReusables();
	public  RemoteWebDriver driver= ut.getDriver();
	
	@When("User opens a contract case from the Assigned Programs {string}")
	public void user_opens_a_contract_case_from_the_assigned_programs(String testCaseID) throws InterruptedException {
		negotiationQuotationObj.scroll_down_page();
	   actuarialLegalobj.searchCaseNumberForAssignedProgram(ut.getCellValue("TestData_QPR",testCaseID,"Contract_ID"));
	String contractid = ut.getCellValue("TestData_QPR",testCaseID,"Contract_ID");
	System.out.println("contract no :"+contractid);
	actuarialLegalobj.openContractCaseForAssignedProgram(contractid);
	Thread.sleep(2000);
	}

	 @When("User selects the action section from {string}")
     public void user_selects_the_action_section_from(String actions) throws InterruptedException {
         Thread.sleep(2000);
       actuarialLegalobj.selectActions(actions);   
      
     }

          @When("User selects from Assign Program - {string} popup {string}")
          public void user_selects_from_assign_program_popup(String Actions, String testCaseID) throws InterruptedException {
        	  if(Actions.equals("Actuarial Analysis")) {
         	 Thread.sleep(2000);
         	 actuarialLegalobj.selectActuarialAnalysis(ut.getCellValue("TestData_QPR",testCaseID,"ActuarialAnalysis"));
         	 Thread.sleep(2000);
         	 WebElement holders = driver.findElement(By.xpath("//strong[text()='Stakeholders']"));
         	 tR.scrolltoElement(holders);
        	  }
        	  else if (Actions.equalsIgnoreCase("Legal Analysis")) {
        		  Thread.sleep(2000);
        		  actuarialLegalobj.selectLegalAnalysis(ut.getCellValue("TestData_QPR",testCaseID,"LegalAnalysis"));
        		  Thread.sleep(2000);
              	 WebElement holders = driver.findElement(By.xpath("//strong[text()='Stakeholders']"));
              	 tR.scrolltoElement(holders);
        	  }
          }
     
     @Then("{string} labels should display assigned values {string}")
     public void labels_should_display_assigned_values(String Actions, String testCaseID) throws InterruptedException {
    	
    	 if(Actions.equals("Actuarial Analysis")) {
    		 
    	 Thread.sleep(1000);
       String actuariallabelfromUI = actuarialLegalobj.ActuarialAnalystlabel();
       String actuariallabelfromTestData = ut.getCellValue("TestData_QPR",testCaseID,"ActuarialAnalysis");
       Thread.sleep(3000);
       Assertions.assertEquals(actuariallabelfromUI, actuariallabelfromTestData);
       System.out.println(actuariallabelfromUI);
    	 }
    	 else if (Actions.equalsIgnoreCase("Legal Analysis")) {
    		 
       String legallabelfromUI = actuarialLegalobj.LegalAnalystlabel();
	   String legallabelfromTestData = ut.getCellValue("TestData_QPR",testCaseID,"LegalAnalysis");
       Thread.sleep(3000);
        Assertions.assertEquals(legallabelfromUI, legallabelfromTestData);
             System.out.println(legallabelfromUI);
    	 }
     }

}




