package com.big.stepdef;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;


import com.big.pageObjects.CommonObj;
import com.big.pageObjects.ContractCasePagePreparation_Actions;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class AssignUnderwriterToContractCase {
	Utilities ut = new Utilities();
	CommonObj co = new CommonObj();
	QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
	HomePage_Actions homeActionObj = new HomePage_Actions();
	ContractCasePagePreparation_Actions contractcasePreparationObj = new ContractCasePagePreparation_Actions();

	@When("User opens a contract case from the Home tab {string}")
	public void user_opens_a_contract_case_from_the_home_tab(String testCaseID) throws InterruptedException {
		homeActionObj.searchCaseNumber(ut.getCellValue("TestData_QPR",testCaseID,"Contract_ID"));
		String contractid = ut.getCellValue("TestData_QPR",testCaseID,"Contract_ID");
		System.out.println("contract no "+contractid);
		Thread.sleep(3000);		//homeActionObj.openContractCase(Contract_ID);
		homeActionObj.openContractCase(contractid);
		
	}

	@When("No Underwriter or UW Team is assigned")
	public void no_underwriter_or_uw_team_is_assigned() {

		System.out.println("Validate UnderWriter is Blank "+contractcasePreparationObj.isUnderwriterBlank());
		System.out.println("Validate UnderWriting Team is Blank "+contractcasePreparationObj.isUnderwritingTeamBlank());

		Assertions.assertTrue(contractcasePreparationObj.isUnderwriterBlank(), "Underwriter label should be blank or absent");
		Assertions.assertTrue(contractcasePreparationObj.isUnderwritingTeamBlank(), "Underwriting Team label should be blank or absent");
      

	}

	@When("User clicks on the ASSIGN UNDERWRITER action")
	public void user_clicks_on_the_action() {
		contractcasePreparationObj.clickOnAssignUnderWriter();
	}

	@When("User selects Underwriting Team and Underwriter for {string}")
	public void user_selects_underwriting_data(String testCaseID) throws InterruptedException {

		Thread.sleep(2000);	
		
		Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);

		String team = data.get("UnderwritingTeam");
		String underwriter = data.get("UnderWriter");
        
        System.out.println("team fields text "+team);
        
		contractcasePreparationObj.selectUnderwritingTeam(team);
		
		contractcasePreparationObj.selectUnderwriter(underwriter);
		
	}

	@Then("the {string} stage should turn green")
	public void the_stage_should_turn_green(String stageName) throws InterruptedException {


		Assertions.assertTrue(contractcasePreparationObj.isStageCompleted(stageName),
				"Expected stage '" + stageName + "' to be green, but it is not.");
	}

	@Then("available actions should include:")
	public void available_actions_should_include(List<String> expectedButtons) throws InterruptedException {
		Thread.sleep(5000);
		boolean result = contractcasePreparationObj.areActionButtonsPresent(expectedButtons);
		Assert.assertTrue("One or more expected action buttons are missing", result);
	}


	@Then("the UW Team and Underwriter labels should display assigned values")
	public void the_uw_team_and_underwriter_labels_should_display_assigned_values() {

		boolean isUWTeamBlank = contractcasePreparationObj.isUnderwritingTeamBlank();
		boolean isUnderwriterBlank = contractcasePreparationObj.isUnderwriterBlank();

		if (isUWTeamBlank || isUnderwriterBlank) {
			throw new AssertionError("❌ One or both values are blank: " +
					"\nUnderwriting Team blank? " + isUWTeamBlank +
					"\nUnderwriter blank? " + isUnderwriterBlank);
		}

		System.out.println("Both UW Team and Underwriter labels are populated.");
	}
	
	
	
	@When("User Opens {string} stage under summary")
	public void user_opens_stage_under_summary(String stage) throws InterruptedException {

		contractcasePreparationObj.openStage(stage);
		System.out.println("Opened stage: " + stage);

	}	

	@When("User clicks on the REASSIGN UNDERWRITER action")
	public void user_clicks_on_the_reassign_underwriter_action() {
		contractcasePreparationObj.clickOnReassignUnderWriter();
		System.out.println("Clicked on Reassign Underwriter action");
		
		contractcasePreparationObj.removeUnderwriter();
		

	}

}



