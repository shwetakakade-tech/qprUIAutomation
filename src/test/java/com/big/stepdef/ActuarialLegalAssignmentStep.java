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
	Thread.sleep(3000);
	actuarialLegalobj.openContractCaseForAssignedProgram(contractid);

	}

	 @When("User selects the action section from {string}")
     public void user_selects_the_action_section_from(String actions) throws InterruptedException {
         Thread.sleep(2000);
       actuarialLegalobj.selectActions(actions);          
     }

     @When("User selects from Assign Program - Actuarial and Legal Analysis popup {string}")
     public void user_selects_from_assign_program_actuarial_and_legal_analysis_popup(String testCaseID) throws InterruptedException {
    	 Thread.sleep(3000);
    	 actuarialLegalobj.selectActuarialAnalysis(ut.getCellValue("TestData_QPR",testCaseID,"ActuarialAnalysis"));
    	 Thread.sleep(3000);
    	 WebElement Actions = driver.findElement(By.xpath("(//span[@class='SizedText---medium_plus SizedText---predefined'])[2]"));
    	 tR.scrolltoElement(Actions);
    	 WebElement LegalAnalyst = driver.findElement(By.xpath("//button[@type='button']//span//span[contains(text(),'Legal Assignment')]"));
    	 LegalAnalyst.click();
    	 actuarialLegalobj.selectLegalAnalysis(ut.getCellValue("TestData_QPR",testCaseID,"LegalAnalysis"));
     }
     
     @Then("Actuarial and Legal labels should display assigned values {string}")
     public void actuarial_and_legal_labels_should_display_assigned_values(String testCaseID) throws InterruptedException {
    	 Thread.sleep(3000);
       String actuariallabelfromUI = actuarialLegalobj.ActuarialAnalystlabel();
       String actuariallabelfromTestData = ut.getCellValue("TestData_QPR",testCaseID,"ActuarialAnalysis");
       String legallabelfromUI = actuarialLegalobj.LegalAnalystlabel();
	   String legallabelfromTestData = ut.getCellValue("TestData_QPR",testCaseID,"LegalAnalysis");
       Thread.sleep(4000);
             Assertions.assertEquals(actuariallabelfromUI, actuariallabelfromTestData);
             System.out.println(actuariallabelfromUI);
             Thread.sleep(3000);
             Assertions.assertEquals(legallabelfromUI, legallabelfromTestData);
             System.out.println(legallabelfromUI);
      
     }

     @Then("Legal labels should display assigned values {string}")
     public void legal_labels_should_display_assigned_values(String testCaseID) throws InterruptedException {
    	 Thread.sleep(4000);
    	 String legallabelfromUI = actuarialLegalobj.LegalAnalystlabel();
    	   String legallabelfromTestData = ut.getCellValue("TestData_QPR",testCaseID,"LegalAnalysis");
         Thread.sleep(5000);
         Assertions.assertEquals(legallabelfromUI, legallabelfromTestData);
         System.out.println(legallabelfromUI);
   }
}




