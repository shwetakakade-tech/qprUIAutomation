package com.big.stepdef;

import com.big.pageObjects.Authorization_SendAuthorizationEmailPage;
import com.big.pageObjects.CommonObj;
import com.big.pageObjects.ContractCasePagePreparation_Actions;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;
import io.cucumber.java.en.*;

	public class Authorizatoin_SendAuthorizationEmailAction {

		Utilities ut = new Utilities();
		CommonObj co = new CommonObj();
		QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
		HomePage_Actions homeActionObj = new HomePage_Actions();
		ContractCasePagePreparation_Actions contractcasePreparationObj = new ContractCasePagePreparation_Actions();
		Authorization_SendAuthorizationEmailPage at = new Authorization_SendAuthorizationEmailPage();
		TestReusables tr = new TestReusables();
		String testCaseID = "TC_004" ;
		
		@Then("User click on the Send Auth Email action")
		public void clickSendAuth(){
			at.sendauth();
		}
			
		@And("User verify Authorization Email text")
		public void AuthEmailTextCompare(){
			at.verifyAuthEmailTitle();
		}
		
		@When("User open the recipient drop down")
		public void selectRecipientAuthEmail() {
			at.clickRecipientDropdown();	
		}
		
		@And("User select the recipient {string} from the drop down")
		public void selectRecipientFromList(String recipientemail) { 
		String recipientemailvalue = ut.getCellValue("TestData_QPR", testCaseID, recipientemail);
		at.selectRecipient(recipientemailvalue);  
		}
		 
		
		@Then("User check the Acknowledge checkbox button")
		public void authAckCheckBox() {
			at.authacknowledgeCheckBox();
		}
		
		@And("User enter Wording Proposal text from {string}")
		public void wordingProposal(String wordingText) {
			String wordingtext = ut.getCellValue("TestData_QPR", testCaseID, wordingText);
			at.wordingProposalText(wordingtext);
		}
		
		@And("User check and click on Send Authorization Email button")
		public void checkAndClickSendAuthEmailButton() {
			at.visiblityAndClicksendAuthEmailButton();
		}
		
		@Then("User navigate to authorization Results section {string}")
		public void navigatestoauthorizationresultsection(String resultsection)throws Exception {
			String sectionname = ut.getCellValue("TestData_QPR", testCaseID, resultsection);
			at.navigatesToAuthorizationSection(sectionname);
		}
		
		@And("User validate the authorization email in sections")
		public void validateauthorizationemail() throws Exception {
			at.validateAuthorizationEmail();
		}
		
		@Then("User navigate to communication tab using {string}")
		public void navigateCommunicationTab(String casetab) {
			String casetabname = ut.getCellValue("TestData_QPR", testCaseID, casetab);
			at.clickOnCummination(casetabname);
		}
		
		@And("User validate authorization email is sent {string}")
		public void validateAuthEmailSend(String authemail) {
			String expEmailtype = ut.getCellValue("TestData_QPR", testCaseID, authemail);
			at.validateEmailSendInCommunication(expEmailtype);
		}
		
		
	}

		
