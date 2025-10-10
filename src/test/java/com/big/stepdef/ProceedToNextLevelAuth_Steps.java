package com.big.stepdef;

import java.util.List;

import org.junit.runner.RunWith;


import com.big.pageObjects.AuthorizationDecision_Actions;
import com.big.pageObjects.ProceedToNextLevelAuth_Actions;
import com.big.utils.Utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class ProceedToNextLevelAuth_Steps {
	
	Utilities ut = new Utilities();
	

	ProceedToNextLevelAuth_Actions ProceedTONextLevelAuthObj = new ProceedToNextLevelAuth_Actions();


    @Given("User navigates to {string} paragraphtab")
    public void user_navigate_to_paragraph_tab(String paragraphTab) {
    	System.out.println("User is on Authorization/Refusal Tab");
    	
        
    }

    @And("User selects action from {string}")
    public void user_selects_action(String actionTab) {
    	ProceedTONextLevelAuthObj.click_Action_button();
    	//ProceedTONextLevelAuthObj.click_cross_icon();
    	
        
    }

    @And("User selects Program Authorization from dropdown")
    public void user_selects_program_authorization() {
    	
    	ProceedTONextLevelAuthObj.select_from_dropdown();
    	ProceedTONextLevelAuthObj.click_submit();
        
    }

    @Then("User should have Authorization Status as Pending Authorization Decision")
    public void user_should_have_status_pending() throws InterruptedException {
    	ProceedTONextLevelAuthObj.verify_authorization_status();
        
    }
}

