package com.big.stepdef;

import org.junit.runner.RunWith;

import com.big.pageObjects.AddQuotation_Actions;

import com.big.pageObjects.PricingStructure_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class PricingStructureSteps {
	Utilities ut = new Utilities();
	
	PricingStructure_Actions pricingStructureObj = new PricingStructure_Actions();
	AddQuotation_Actions addQuotActionsObj = new AddQuotation_Actions();
	
	@Given("User navigate to {string} tab and click PRICING STRUCTURE OVERVIEW")
	public void user_click_pricing_structure_button(String stageName) throws InterruptedException
	{
		pricingStructureObj.verify_case_ID();
		addQuotActionsObj.scroll_to_Actions();
		pricingStructureObj.click_update_pricing_button();
	
	}
	
	@And("User adds values and click submit button")
	public void user_add_values_and_submit()
	{
		pricingStructureObj.enter_values_in_firm_window();
		pricingStructureObj.click_submit_button();
	}
	
	@Then("User see {string} turns green and completed")
	public void user_see_stage_color_green(String StageColorGreen) throws InterruptedException
	{
		pricingStructureObj.click_structural_pricing_tab();
		pricingStructureObj.verify_structure_and_pricing();
	}

}
