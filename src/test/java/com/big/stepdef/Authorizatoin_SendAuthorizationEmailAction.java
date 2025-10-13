package com.big.stepdef;

import com.big.pageObjects.Authorization_SendAuthorizationEmailPage;
import com.big.pageObjects.CommonObj;
import com.big.pageObjects.ContractCasePagePreparation_Actions;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.testNGscripts.TestNGInitiation;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;
import io.cucumber.java.en.*;

	public class Authorizatoin_SendAuthorizationEmailAction {

		Utilities ut = new Utilities();
		CommonObj co = new CommonObj();
		QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
		HomePage_Actions homeActionObj = new HomePage_Actions();
		Authorization_SendAuthorizationEmailPage at = new Authorization_SendAuthorizationEmailPage();
		TestReusables tr = new TestReusables();
		
			
			
		@And("User verify Heading as Authorization Email text")
		public void AuthEmailTextCompare(){
			at.verifyAuthEmailTitle();
		}
		
		@When("User open the recipient drop down")
		public void selectRecipientAuthEmail() {
			at.clickRecipientDropdown();	
		}
		
		@And("User select the Recipient email from dropdown as Recipient TO")
		public void selectRecipientFromList() { 
		at.selectRecipient();  
		}
		 
		
		@Then("User check the Acknowledge checkbox")
		public void authAckCheckBox() {
			at.authacknowledgeCheckBox();
		}
		
		@And("User enter Wording Proposal text from {string}")
		public void wordingProposal(String testCaseID) {
			String wordingtext = ut.getCellValue("TestData_QPR", testCaseID, "Wording_Text");
			at.wordingProposalText(wordingtext);
		}
		
		@And("User check visibility of Send Authorization Email button")
		public void checkvisibility() {
			at.checkVisiblity();
		}
		
		@And("User click on Send Authorization Email button")
		public void ClickSendAuthEmailButton() {
			at.clickSendAuthorizationButton();
		}
		
		@Then("User navigate to authorization Results section")
		public void navigatestoauthorizationresultsection()throws Exception {
			at.navigatesToAuthorizationSection();
		}
		
		@And("User validate the authorization email in section")
		public void validateauthorizationemail() throws Exception {
			at.validateAuthorizationEmail();
		}
		
		
		@And("User validate authorization email is being sent")
		public void validateAuthEmailSend() {
			
			at.validateEmailSendInCommunication();
		}
		
	}

	