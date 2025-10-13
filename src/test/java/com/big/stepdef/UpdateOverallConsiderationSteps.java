package com.big.stepdef;
import org.junit.runner.RunWith;

import com.big.pageObjects.Negotiation_QuotationTabPO;
import com.big.pageObjects.PricingStructure_Actions;
import com.big.pageObjects.UpdateOverallConsideration_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

public class UpdateOverallConsiderationSteps {
	
	Utilities ut = new Utilities();
	UpdateOverallConsideration_Actions overallConsiderationObj = new UpdateOverallConsideration_Actions();
	Negotiation_QuotationTabPO negotiationQuotationObj = new Negotiation_QuotationTabPO();
	
	
	@Given("^User navigates to \"([^\"]*)\" tab$")
	public void user_navigate_to_stage(String stageName)
	{
		overallConsiderationObj.verify_case_ID();
	}
	
	
	@When("User click UPDATE OVERALL CONSIDERATION in Actions")
    public void user_navigate_to_stage_tab() throws InterruptedException {
		
		negotiationQuotationObj.scroll_to_Actions();
		overallConsiderationObj.scroll_and_click();
    }

    @And("User adds overall consideration values and click submit button")
    public void user_click_in_actions() throws InterruptedException {
    	overallConsiderationObj.enter_descrpn_in_considerations_textarea();
    
    }

    
    @Then("User verifies the values in {string} Tab")
    public void user_sees_stage_completed(String stage) throws InterruptedException {
    	overallConsiderationObj.verify_overall_considerations();
       
    }
}


