package com.big.stepdef;

import com.big.pageObjects.CommonObj;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateCaseBySendingEmail {

	@Given("User send email with attachment")
	public void user_send_email_with_attachment() {
	//	CommonObj.sendEmailWithMultiAttachement();
		System.out.println("Email with attachment sent.");
	}

	@Then("case is being created under Home tab.")
	public void case_is_being_created_under_home_tab() {
		//CommonObj.getFirstRowDatafromWebTable();
	}

	@And("verify case created and add Case ID to Excel")
	public void verify_case_created_and_add_case_id_to_excel() {

	}

}
