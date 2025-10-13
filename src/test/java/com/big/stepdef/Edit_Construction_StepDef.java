package com.big.stepdef;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.big.pageObjects.CommonObj;
import com.big.pageObjects.Edit_Construction_Type_Page;
import com.big.pageObjects.HomePage_Actions;
import com.big.pageObjects.QPRLogin_Actions;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Edit_Construction_StepDef {

	public static String rowname;
	public static String rowvalue;
	
	Edit_Construction_Type_Page editConstObj = new Edit_Construction_Type_Page();
	
	Utilities ut = new Utilities();
	CommonObj co = new CommonObj();
	QPRLogin_Actions qprActionObj = new QPRLogin_Actions();
	HomePage_Actions homeActionObj = new HomePage_Actions();
	TestReusables tr = new TestReusables();

	@Then("User click on {string} Program Menu Tab")
	public void openprogramMenutab(String programmenu) throws Exception {
		Thread.sleep(3000);
		editConstObj.openProgramMenu(programmenu);
	}

	@When ("User delete existing records:")
	public void deleteExistingrecord(DataTable dataTable) throws Throwable {
		
		List<String> rowsToDelete = dataTable.asList(String.class);
        for (String rowName : rowsToDelete) {
        	editConstObj.deleteExistingRecords(rowName);
        	Thread.sleep(1000);   	
        }
	}
	
	@Then ("User verify the deleted row from {string}") 
	public void theRowShouldDeleted(String testCaseID) throws Exception {
	  
	  Thread.sleep(1000); 
	  String deleterow = ut.getCellValue("TestData_QPR", testCaseID, "Delete_Row"); 
	  editConstObj.isRowPresent(deleterow); 
	  
	}
	 
	@When("User add new multiple row:")
	public void addMultipleRows(DataTable dataTable) throws Exception {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            this.rowname = row.get("RowName");
            this.rowvalue = row.get("RowValue");
            editConstObj.addNewConstructionRow(this.rowname, this.rowvalue);
        }
    }
	
	@When ("User add the new records from {string}")
	public void addNewRow(String testCaseID) throws Exception {
		
		String addnewrow = ut.getCellValue("TestData_QPR", testCaseID, "Add_New_Row");
		String addnewrowvalue = ut.getCellValue("TestData_QPR", testCaseID, "Add_New_Row_Value");
		
		editConstObj.addNewConstructionRow(addnewrow, addnewrowvalue);
	}
	
	
	@When("User navigate to Program Filing Preparation paragraphtab")
	public void userNavigateToparagraphtabs() throws Exception {
		
		editConstObj.usernavigateToParagraphtabs();
	} 
	
	@Then("User validate the added row and its values")
	public void validateaddedrowandavlue() throws Exception  {
		System.out.println("Row Name is: " + rowname);
		System.out.println("Row Value is: " + rowvalue);
		Thread.sleep(4000);
		editConstObj.validateValues(rowname, rowvalue);
		
	}
}
