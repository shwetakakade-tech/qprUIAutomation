package com.big.stepdef;

import java.util.List;
import java.util.Map;

import com.big.pageObjects.Edit_TotalSumInsuredPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Edit_TotalSumInsuredStepDef {
	
	
	Edit_TotalSumInsuredPage tsiObj = new Edit_TotalSumInsuredPage();
	
	String rowname;
	String rowvalue;
	String rowvalue2;
	
// Get data and insert test data from data table//
	
	@When("User add new multiples row:")
	public void addMultipleRows(DataTable dataTable) throws Exception {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            this.rowname = row.get("RowName");
            this.rowvalue = row.get("RowValue");
            this.rowvalue2 = row.get("RowValue2");
            tsiObj.addNewConstructionRow(this.rowname, this.rowvalue, this.rowvalue2);
        }
        
	}   
 

        @Then("User validates the added row and its values")
    	public void validateaddedrowandavlue() throws Exception  {
    		System.out.println("Row Name is: " + rowname);
    		System.out.println("Row Value is: " + rowvalue);
    		System.out.println("Row Value is: " + rowvalue2);
    		
    		tsiObj.validateValues(rowname, rowvalue, rowvalue2);
    		
    		
    	}
        

		
		
	

}
