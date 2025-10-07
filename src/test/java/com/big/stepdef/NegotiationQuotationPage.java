package com.big.stepdef;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.big.pageObjects.*;
import com.big.utils.Utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

public class NegotiationQuotationPage {
	
	
	Utilities ut = new Utilities();
	Negotiation_QuotationTabPO negotiationQuotationObj = new Negotiation_QuotationTabPO();
	ActuarialLegalAssignmentobj actuarialLegalobj = new ActuarialLegalAssignmentobj();

    @Given("User navigates to the {string} tab")
    public void user_navigates_to_the_stage_tab(String stage) throws InterruptedException {
    	Thread.sleep(3000);
    	negotiationQuotationObj.scroll_to_Actions();    	
    	    
    }

    @When("User clicks {string} in Actions")
    public void user_clicks_in_actions(String actionName)  {
    	negotiationQuotationObj.click_nonBinding_refusal_email();
    	
    }

    @Then("User sends the non-binding refusal email via Action")
    public void user_sends_the_non_binding_refusal_email_via_action() throws InterruptedException {
    	
    	negotiationQuotationObj.enter_descrpn_in_email();
    	negotiationQuotationObj.click_send_button();
        
    }
    
    @And("User verifies the email in {string} tab")
    public void the_user_verifies_the_email_in_the_tab(String tabName) throws InterruptedException
    {
    	negotiationQuotationObj.scroll_up_page_and_clickCommunication();
    	
    	negotiationQuotationObj.VerifyCommunicationtab();
    	System.out.println();
    }
   
	}

		


