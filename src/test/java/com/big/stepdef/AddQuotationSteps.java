package com.big.stepdef;



import org.junit.runner.RunWith;

import com.big.pageObjects.*;
import com.big.utils.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

public class AddQuotationSteps {
	
	Utilities ut = new Utilities();
	AddQuotation_Actions addQuotActionsObj = new AddQuotation_Actions();
	ActuarialLegalAssignmentobj actuarialLegalobj = new ActuarialLegalAssignmentobj();

   

    @Given("the user navigates to the {string} tab")
    public void the_user_navigates_to_the_tab(String stage) throws InterruptedException {
    	Thread.sleep(4000);
    	addQuotActionsObj.scroll_to_Actions();
    
        
    }

    @When("the user clicks {string} via Action")
    public void the_user_navigates_to_the_named_tab(String Name) throws InterruptedException {
    	
    	addQuotActionsObj.click_add_quotation();
       
    }

    @Then("the user adds quotation values in the {string} section")
    public void the_user_adds_quotation_values_in_the_section(String sectionName) throws InterruptedException {
    	addQuotActionsObj.enter_Values_in_quotation_section();
    	
    	addQuotActionsObj.click_send_button();
    	
    	
        

        
    }

    @And("the user verifies quotation values in the {string} tab")
    public void user_verifies_quotation_values_in_quotation_tab(String tabName) throws InterruptedException {
    	addQuotActionsObj.scroll_and_click();
    	addQuotActionsObj.verify_Quotation_values();
    	

        
    }
}
 