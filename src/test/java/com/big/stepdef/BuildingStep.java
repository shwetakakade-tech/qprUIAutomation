package com.big.stepdef;

import java.awt.Window;
import java.lang.annotation.Documented;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.big.pageObjects.BuildingObj;
import com.big.pageObjects.ProgramStructureObj;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;
import com.intuit.karate.Actions;
import com.intuit.karate.driver.Keys;
 

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuildingStep {

	Utilities ut = new Utilities();
	ProgramStructureObj Probj = new ProgramStructureObj();
	public  RemoteWebDriver driver= ut.getDriver();
	BuildingObj buildingObjct= new BuildingObj();
	TestReusables ts = new TestReusables();
	 
	
	@Then("User again clicks on Edit button on top right corner")
	public void user_again_clicks_on_edit_button_on_top_right_corner() throws InterruptedException {
		Thread.sleep(1000);
		buildingObjct.againclickeditButton();
		Thread.sleep(2000);
	}
	
	@Then("User selects again the panels displayed below the Case Details {string} under edit Pop-up")
	public void user_selects_again_the_panels_displayed_below_the_case_details_under_edit_pop_up(String panels) throws InterruptedException {
       // Thread.sleep(2000);
		Probj.selectPopUpPanels(panels);
		 Thread.sleep(2000);
	}

@Then("User perform {string} building panel record with {string} from edit pop-up panels displayed below the Case Details")
public void user_perform_building_panel_record_with_from_edit_pop_up_panels_displayed_below_the_case_details(String ActionsPerformed, String testCaseID) throws InterruptedException {
	
	if(ActionsPerformed.equals("added")) {
		
		Probj.clickAddButton();
		Thread.sleep(1000);
		 Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
	     String year = data.get("BuildingYear");
	     String buildings = data.get("Buildings");
	  
	     System.out.println("Year : " + year);
	     System.out.println("buildings : " + buildings);
	    
	     Thread.sleep(2000);
	     buildingObjct.enterBuildingyearValues(year, buildings);
	     
	     Thread.sleep(2000);
	    Probj.clickSaveButton();
	    Thread.sleep(6000);
	    driver.executeScript("window.scrollTo(0, 0);");
	   	
	}
	else if (ActionsPerformed.equalsIgnoreCase("deleted")) {
		
		Thread.sleep(1000);
		buildingObjct.getBuildingRowData(testCaseID);
		  Thread.sleep(6000);
		driver.executeScript("window.scrollTo(0, 0);");
	}
	
}

@When("User verifies {string} building panel new data from {string} table and {string} under edit pop-up")
public void user_verifies_building_panel_new_data_from_table_and_under_edit_pop_up(String ActionsPerformed,String panels, String testCaseID) throws InterruptedException {
	 Thread.sleep(1000);
	 Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
     String addedepectedyear = data.get("BuildingYear");
     String addedexpectedbuildings = data.get("Buildings");
     if(ActionsPerformed.equals("added")) {
try {
	
	Map<String, String>actualPopupRowData = buildingObjct.getBuildingRowData();
            String popupActualYear = actualPopupRowData.get("year");
            String popupActualBuildings = actualPopupRowData.get("buildings");
            
            Assert.assertEquals(popupActualYear, addedepectedyear, "Layer value does not match.");
            Assert.assertEquals(popupActualBuildings, addedexpectedbuildings, "ProgramType value does not match.");
           
            
            System.out.println("popupActualYear "+popupActualYear);
            System.out.println("popupActualBuildings "+popupActualBuildings);
        System.out.println("✅ All values for the new entry were verified successfully.");
            
}
           
  catch (org.openqa.selenium.NoSuchElementException e) {
        Assert.fail("Verification failed: Could not find the Actual ProgramStructure row. The row may not have been created or saved successfully.  " + e.getMessage());
    }

}
	 else if (ActionsPerformed.equalsIgnoreCase("deleted")) { 
		 Thread.sleep(1000);
		 boolean isDeleted = buildingObjct.verifyRowIsDeleted();
		 
	        Assert.assertTrue(isDeleted, "The row was not successfully deleted.");
	        Thread.sleep(2000);
	        
	        System.out.println("✅ Row was successfully deleted and verified.");
	 }
}
}



