package com.big.stepdef;

import com.big.pageObjects.CommonObj;
import com.big.pageObjects.UpfrontAnalysis_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UpfrontAnalysis {
	Utilities ut = new Utilities();
	CommonObj co = new CommonObj();
	UpfrontAnalysis_Actions upfrontanalysis_obj = new UpfrontAnalysis_Actions();
   
   
    
	@And("user select {string} for the UW Guidelines category")
    public void user_select_color_for_the_uw_guidelines_category(String UWColor) throws InterruptedException {
        upfrontanalysis_obj.clickUWGuidelinesColor(UWColor);
    }
   
    @And("user select {string} for the Capacity Retro category")
    public void user_select_color_for_the_capacity_retro_category(String CRColor) throws InterruptedException {
        upfrontanalysis_obj.clickCapacityRetroColor(CRColor);
    }
   
    @And("user select {string} for the Performance category")
    public void user_select_color_for_the_performance_category(String PFColor) throws InterruptedException {
        upfrontanalysis_obj.clickPerformanceColor(PFColor);
    }
    
    @And("user click on Upfront Analysis submit button")
    public void user_click_on_Upfront_Analysis_submit_button() throws InterruptedException {
    	upfrontanalysis_obj.clickupUpfrontAnalysissubmitbutton();
    }
    
    @Then("the upfront analysis should be displayed {string}")
    public void the_upfront_analysis_should_be_submited(String expectedText) throws InterruptedException {
    	upfrontanalysis_obj.verifytheupfrontanalysismessage(expectedText);
    }

	

}