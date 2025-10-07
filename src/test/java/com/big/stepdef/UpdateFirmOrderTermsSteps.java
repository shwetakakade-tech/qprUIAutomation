package com.big.stepdef;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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

public class UpdateFirmOrderTermsSteps   {
	
	Utilities ut = new Utilities();
	UpdateFirmOrderTerms_Actions updateFirmOrdersObj = new UpdateFirmOrderTerms_Actions();
	
    

	@Given("the user is on {string} tab and clicks {string} in Actions")
    public void the_user_clicks_in_actions(String stageName,String actionName) throws InterruptedException {
		
		updateFirmOrdersObj.verify_caseId();
		updateFirmOrdersObj.click_negotation_quotation_tab();
		
		updateFirmOrdersObj.scroll_to_Actions();
		
		updateFirmOrdersObj.click_update_firm_order_button();
		
        
    }

    @And("the user adds values in the {string} section")
    public void the_user_adds_values_in_the_section(String sectionName) {
    	updateFirmOrdersObj.enter_firm_order_terms_values();
    	updateFirmOrdersObj.click_submit_button();
    	
       
    }

    @Then("the user navigates to Firm Order details in the {string} tab")
    public void the_user_verifies_the_firm_order_details_in_the_tab(String tabName) throws InterruptedException {
    	updateFirmOrdersObj.scroll_and_click();
        
    }
    
    @And("the user verifies {string} and {string}")
    public void the_user_verifies_firm_order_details_and_fot_email(String values, String email)
    {
    	updateFirmOrdersObj.verify_firm_order_details();
    	updateFirmOrdersObj.click_FOT_email_button();
	     }

    

    @Then("the {string} tab turns green")
    public void the_tab_status_turns_green(String stage) {
        
    }
}