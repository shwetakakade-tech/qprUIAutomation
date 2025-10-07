package com.big.stepdef;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.pageObjects.AMS_Actions;
import com.big.pageObjects.CommonObj;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QPRAppainLogin {
	Utilities ut = new Utilities();
	CommonObj co = new CommonObj();
	QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
	HomePage_Actions homeActionObj = new HomePage_Actions();
	
	
	@Given("User login to Appian application as {string}")
	public void login(String role) throws InterruptedException {
		co.appianlogin(ut.getCellValue("Credentials",role,"UserName"),
	    ut.getCellValue("Credentials",role,"Password"));

	}
	
	@Then("User navigates to Home category")
	public void user_navigates_to_home_category() {
		//qprActionObj.verifyHomeText();
		System.out.println("Home Page");
	}

			
	@Then("User should see the Reinsurance text")
	public void user_should_see_the_reinsurance_text() throws InterruptedException {
		homeActionObj.verifyreInsuranceText();

	}

	  
	 
}

