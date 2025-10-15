package com.big.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.big.pageObjects.ProgramStructureObj;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramStructureStep {

	
	Utilities ut = new Utilities();
	ProgramStructureObj Probj = new ProgramStructureObj();
	public  RemoteWebDriver driver= ut.getDriver();
	TestReusables ts = new TestReusables();
	 private Map<String, String> getRowData;
		@Then("User clicks on Edit button on top right corner")
		public void user_clicks_on_edit_button_on_top_right_corner() throws InterruptedException {
			Thread.sleep(1000);
			Probj.clickeditButton();
			 Thread.sleep(2000);
		}
		
		@Then("User selects the panels displayed below the Case Details {string} under edit Pop-up")
		public void user_selects_the_panels_displayed_below_the_case_details_under_edit_pop_up(String panels) throws InterruptedException {
	        Thread.sleep(1000);
			Probj.selectPopUpPanels(panels);
			   Thread.sleep(2000);
		}
		
		@Then("User {string} record with {string} from edit pop-up panels displayed below the Case Details")
		public void user_record_with_from_edit_pop_up_panels_displayed_below_the_case_details(String ActionsPerformed, String testCaseID) throws InterruptedException {
			
			if(ActionsPerformed.equals("added")) {
			Probj.clickAddButton();
			Thread.sleep(1000);
	        Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
	        String layer = data.get("Layer");
	        String programType = data.get("Program Type");
	        String limit = data.get("Limit");
	        String retention = data.get("Retention");
	        String reinstatement = data.get("Reinstatement");
	        String subjectPremium = data.get("Subject Premium");
	        
	        System.out.println("layer : " + layer);
	        System.out.println("programType : " + programType);
	        System.out.println("limit : " + limit);
	        System.out.println("retention : " + retention);
	        System.out.println("reinstatement : " + reinstatement);
	        System.out.println("subjectPremium : " + subjectPremium);
	        Thread.sleep(2000);
	        Probj.enterProgramStructureRowData(layer, programType, limit, retention, reinstatement, subjectPremium);
	        Thread.sleep(3000);
	        Probj.clickSaveButton();
	       
	        Thread.sleep(6000);
	        driver.executeScript("window.scrollTo(0, 0);");

	    }
			else if (ActionsPerformed.equalsIgnoreCase("deleted")) {

		        Thread.sleep(1000);
		        Probj.getRowData(testCaseID);
		        Thread.sleep(6000);
		        driver.executeScript("window.scrollTo(0, 0);");
			}
		}
		
		@When("User verifies {string} new data from {string} table and {string} under Program Filling and Preparation")
		public void user_verifies_new_data_from_table_and_under_program_filling_and_preparation(String ActionsPerformed, String panels, String testCaseID) throws InterruptedException {
			Thread.sleep(2000);
			Probj.selectPanels(panels);
			Thread.sleep(2000);
			Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
	        String Epectedlayer = data.get("Layer");
	        String ExpectedprogramType = data.get("Program Type");
	        String Expectedlimit = data.get("Limit");
	        String Expectedretention = data.get("Retention");
	        String Expectedreinstatement = data.get("Reinstatement");
	        String ExpectedsubjectPremium = data.get("Subject Premium");
	        if(ActionsPerformed.equals("added")) {
	try {
			Map<String, String>actualPopupRowData = Probj.getRowData();
		            String ActualLayer = actualPopupRowData.get("layer");
		            String ActualProgramType = actualPopupRowData.get("programType");
		            String ActualLimit = actualPopupRowData.get("limit");
		            String ActualRetention = actualPopupRowData.get("retention");
		            String ActualReinstatement = actualPopupRowData.get("reinstatement");
		            String ActualSubjectPremium = actualPopupRowData.get("subjectPremium");
		            
		            Assert.assertEquals(ActualLayer, Epectedlayer, "Layer value does not match.");
		            Assert.assertEquals(ActualProgramType, ExpectedprogramType, "ProgramType value does not match.");
		            Assert.assertEquals(ActualLimit, Expectedlimit, "Limit value does not match.");
		            Assert.assertEquals(ActualRetention, Expectedretention, "Retention value does not match.");
		            Assert.assertEquals(ActualReinstatement, Expectedreinstatement, "Reinstatement value does not match.");
		            Assert.assertEquals(ActualSubjectPremium, ExpectedsubjectPremium, "SubjectPremium value does not match.");
		            
		            System.out.println("Epectedlayer "+Epectedlayer);
			        System.out.println("ActualLayer "+ActualLayer);
			        System.out.println("Expectedretention "+Expectedretention);
		            System.out.println("ActualRetention "+ActualRetention);
		        System.out.println("✅ All values for the new entry were verified successfully.");
		            
	}
		           
		  catch (org.openqa.selenium.NoSuchElementException e) {
	            Assert.fail("Verification failed: Could not find the Actual ProgramStructure row. The row may not have been created or saved successfully.  " + e.getMessage());
	        }
	        }
	        else if (ActionsPerformed.equalsIgnoreCase("deleted")) { 
	        	Thread.sleep(1000);
				Probj.selectPanels(panels);
				Thread.sleep(2000);
			
				 boolean isDeleted = Probj.verifyRowIsDeleted();
				 
			        Assert.assertTrue(isDeleted, "The row was not successfully deleted.");
			        Thread.sleep(1000);
			        
			        System.out.println("✅ Row was successfully deleted and verified.");
	        }
		}
}



	
