package com.big.stepdef;

import java.util.List;

import org.junit.runner.RunWith;


import com.big.pageObjects.AuthorizationDecision_Actions;

import com.big.utils.Utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class AuthorizationDecisionApprove_Steps {
	
	Utilities ut = new Utilities();
	//Negotiation_QuotationTabPO negotiationQuotationObj = new Negotiation_QuotationTabPO();

	AuthorizationDecision_Actions DecisionApproveObj = new AuthorizationDecision_Actions();
	
	
	
	
	@Given("^the user navigates to \"([^\"]*)\" tab$")
    public void user_navigates_to_stage_tab(String stage) throws InterruptedException {
		
	     DecisionApproveObj.get_Tab_Name();
        
    }

    

    @When("the user clicks AUTHORIZATION DECISION in Actions")
    public void click_authorization_decision()
    {
    	DecisionApproveObj.click_Authorization_Decision();
    
    }
    
    
    @Then("the user selects Actions:")
    public void the_user_selects_actions_as(DataTable dataTable) throws InterruptedException {
    	List<String> actions = dataTable.asList();
    	
    	DecisionApproveObj.select_Action(actions);
        
            }
  
}


