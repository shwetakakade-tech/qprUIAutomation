package com.big.stepdef;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.Map;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.big.pageObjects.CommonObj;
import com.big.pageObjects.EditProgramDetails;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class EditProgramDetailsStep  {
	
	 	static Utilities ut = new Utilities();
	    public static RemoteWebDriver driver= Utilities.getDriver();
	    EditProgramDetails  editPage= new EditProgramDetails();
	    @And("User click on Edit button")
		public void clickonEditbutton() {
	    	editPage.clickonEditButton();
		}   
	    
    @And("the user updates client information:")
    public void updateClientInformation(DataTable clientInfo) {
    			    		
        for (Map<String, String> row : clientInfo.asMaps(String.class, String.class)) {
        		String clientField = row.get("Field");
            String clientValue = row.get("Value");
          
           if(clientField.equals("Name"))
        	   	editPage.updateClientName(clientValue);
       
           if(clientField.equals("Address"))
       	   	editPage.updateClientAddress(clientValue);
        }
    }

    @And("the user updates broker information:")
    public void updateBrokerInformation(DataTable brokerInfo) throws Exception {
        for (Map<String, String> row : brokerInfo.asMaps(String.class, String.class)) {
            String field = row.get("Field");
            String value = row.get("Value");
            if(field.equals("Name"))
        	   	editPage.selectAndUpdateBroker(value);
       
           if(field.equals("Address"))
       	   	editPage.updateBrokerAddress(value);
        }
    }

    @And("the user selects {string} as the primary correspondence method")
    public void selectCorrespondenceMethod(String method) {
        // Logic to select correspondence method
    }

    @And("the user sets remuneration contribution to {string}")
    public void setRemunerationContribution(String contribution) {
        // Logic to set contribution percentage
    }

    @And("the user updates client contact details:")
    public void updateClientContactDetails(DataTable contactInfo) throws Exception {
        for (Map<String, String> row : contactInfo.asMaps(String.class, String.class)) {
            String field = row.get("Field");
            String value = row.get("Value");
            if(field.equals("Name"))
        	   	editPage.updateClientContactName(value);
            if(field.equals("Phone"))
            	editPage.updateClientPhone(value);
            	if(field.equals("Email"))
            		editPage.updateClientEmail(value);
            	if(field.equals("Designation"))
            		editPage.updateClientDesignation(value);
            		
        }
    }

    @And("the user updates broker contact details:")
    public void updateBrokerContactDetails(DataTable contactInfo) {
        for (Map<String, String> row : contactInfo.asMaps(String.class, String.class)) {
            String field = row.get("Field");
            String value = row.get("Value");
            if(field.equals("Name"))
        	   	editPage.updateBrokerContactName(value);
            if(field.equals("Phone"))
            	editPage.updateBrokerContactPhone(value);
            	if(field.equals("Email"))
            		editPage.updateBrokerContactEmail(value);
            	if(field.equals("Designation"))
            		editPage.updateBrokerContactDesignation(value);
        }
    }

    @And("the user updates program type {string} with the following details:")
    public void updateProgramTypeDetails(String programType, DataTable programDetails) {
    	String catBusinesstype = null,catStartdate=null,catExpirydate=null, catDeadline=null, catSeppml=null;
    //	editPage.updateCatXolProgramType(catBusinesstype, catStartdate, catExpirydate, catDeadline, catSeppml);
   // 	editPage.updateCatXolProgramType();
        for (Map<String, String> row : programDetails.asMaps(String.class, String.class)) {
            String field = row.get("Field");
            String value = row.get("Value");
            if(field.equals("Business Type"))
            		catBusinesstype=row.get("Value");
          		
            if(field.equals("Start Date"))
            	catStartdate=row.get("Value");
            	if(field.equals("Expiry Date"))
            		catExpirydate=row.get("Value");
            	if(field.equals("Deadline"))
            		catDeadline=row.get("Value");
             	if(field.equals("SER/VAL"))
             		catSeppml=row.get("Value");
        }
    	editPage.updateCatXolProgramType(catBusinesstype, catStartdate, catExpirydate, catDeadline, catSeppml);
    	editPage.updateTestNewProgramType(catBusinesstype, catStartdate, catExpirydate, catDeadline, catSeppml);
    }

    @Then("the user clicks {string}")
    public void clickButton(String buttonLabel) {
    		//editPage.saveButton();
    }

    @Then("the user verifies that the changes are saved successfully")
    public void verifyChangesSaved() throws Exception{
    		//editPage.verifyClientName(String clientName);
    	}
}
