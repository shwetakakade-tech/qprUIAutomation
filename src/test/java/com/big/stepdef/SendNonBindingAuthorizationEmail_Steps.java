package com.big.stepdef;

import org.junit.runner.RunWith;

import com.big.pageObjects.Negotiation_QuotationTabPO;
import com.big.pageObjects.SendNonBindingAuthorizationEmail_Actions;
import com.big.pageObjects.UpdateOverallConsideration_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class SendNonBindingAuthorizationEmail_Steps {
	
	
	Utilities ut = new Utilities();
	SendNonBindingAuthorizationEmail_Actions sendAuthorizationEmailObj = new SendNonBindingAuthorizationEmail_Actions();
	UpdateOverallConsideration_Actions overallConsiderationObj = new UpdateOverallConsideration_Actions();
	Negotiation_QuotationTabPO negotiationQuotationObj = new Negotiation_QuotationTabPO();
	
	
	@Given("User navigates to the {string} tabmenu")
    public void user_navigates_to_the_stage_tab(String stage) throws InterruptedException {
		
		overallConsiderationObj.verify_case_ID();
		//sendAuthorizationEmailObj.scroll_to_Actions();
		sendAuthorizationEmailObj.click_authorization_email_button();  	
    	    
    }

    @When("User clicks {string} button in Actions")
    public void user_clicks_in_actions(String actionName)  {
    	negotiationQuotationObj.select_recipient_to();
    	sendAuthorizationEmailObj.click_acknowledge_Checbox();
    	
    	
    }

    @And("User enters all details in Non Binding email window screen")
    public void user_sends_the_non_binding_refusal_email_via_action() throws InterruptedException {
    	
    	sendAuthorizationEmailObj.enter_texts_in_wordingProposal();
    	sendAuthorizationEmailObj.click_save();
        
    }
    
    @Then("User verifies authorization email in {string} tab")
    public void the_user_verifies_the_email_in_the_tab(String tabName) throws InterruptedException
    {
    	sendAuthorizationEmailObj.click_negotaition_results_tab();
    	sendAuthorizationEmailObj.verify_authorization_email();
    }

}
