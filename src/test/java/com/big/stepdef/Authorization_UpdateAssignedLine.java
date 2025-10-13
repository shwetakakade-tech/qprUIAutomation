package com.big.stepdef;

import com.big.pageObjects.Authorization_UpdateAssignedLinePage;
import com.big.pageObjects.CommonObj;
import com.big.pageObjects.ContractCasePagePreparation_Actions;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;
import io.cucumber.java.en.*;


public class Authorization_UpdateAssignedLine {

	
	Utilities ut = new Utilities();
	CommonObj co = new CommonObj();
	QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
	HomePage_Actions homeActionObj = new HomePage_Actions();
	ContractCasePagePreparation_Actions contractcasePreparationObj = new ContractCasePagePreparation_Actions();
	Authorization_UpdateAssignedLinePage ual = new Authorization_UpdateAssignedLinePage();
	TestReusables tr = new TestReusables();

	
	
	@And("User verify update singed line pop up")
	public void verifySignedLinePopupTitle() {
		ual.verifyUpdateLinePopupTitle();
	}
	
	@Then("User enter layer1 and layer2 values from {string}")
	public void insertValuesSignedLine(String testCaseID) throws Exception {
		String layer1value = ut.getCellValue("TestData_QPR",testCaseID, "Layer1_Value" );
		String layer2value = ut.getCellValue("TestData_QPR", testCaseID, "Layer2_Value");
		ual.insertSignedlinesvalues(layer1value, layer2value);
	}
	
	@And("User click on submit button")
	public void signedValuesSubmit() {
		ual.signedSubmit();
	}
	
	@Then("User navigate to Signed Lines and Signing Page tab")
	public void signedLineAndSigningPageTab() throws Throwable {
		ual.clickonSingedLineandSingingPage();
	}
	
	@And("User validates the layer1 and layer2 values from {string}")
	public void verifySignedLinevalues(String testCaseID) {
		String layer1values = ut.getCellValue("TestData_QPR",testCaseID, "Layer1_Value" );
		String layer2values = ut.getCellValue("TestData_QPR", testCaseID, "Layer2_Value");
		ual.verifySingnedLinesValues(layer1values, layer2values);
	}

}
