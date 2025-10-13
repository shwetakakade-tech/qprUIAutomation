package com.big.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Edit_Construction_Type_Page extends TestReusables {

	Utilities ut = new Utilities();
	
	@FindBy(xpath = "//input[@class = 'TextInput---text TextInput---align_start TextInput---inEditableGridLayout']")
	List<WebElement> consttype;
	
	@FindBy(xpath = "//span[text() = 'Construction Type']")
	WebElement construction;
	
	@FindBy(xpath = "//span[text() = 'Save Changes']")
	WebElement savebutton;
	
	@FindBy(xpath = "//span[text() = 'Cancel']")
	WebElement cancelbutton;
	
	@FindBy(xpath = "//a[@class = 'GridFooter---add_grid_row_link elements---global_a']")
	WebElement addicon;
 	
	@FindBy (xpath = "//span[text() = 'Edit']")
 	WebElement editbutton;
	
	@FindBy (xpath = "//span[text() = 'Program Filing / Preparation']")
 	WebElement programfilling;
 	
 	@FindBy (xpath = "//a[@class= 'LinkedItem---standalone_richtext_link elements---global_a']")
 	WebElement exportdata;
 	
 	@FindBy (xpath = "//table[@class ='PagingGridLayout---table PagingGridLayout---scrollable PagingGridLayout---striped']/tbody/tr/td/p")
 	List<WebElement> listofconstructions;
 	
 	
 	@FindBy (xpath = "//div[@class= 'FieldLayout---input_below']/div/p/span[@class = 'AccentText---color_accent']")
 	List<WebElement> listofprogrammenu;
 	
 	public void openProgramMenu(String programmenu) throws Exception {
 		Thread.sleep(5000);
 		for (WebElement ProgramMenu : listofprogrammenu) {
            if (ProgramMenu.getText().trim().equalsIgnoreCase(programmenu)) {
                System.out.println("Program Menu Tab: "+ ProgramMenu.getText());
                //Thread.sleep(1000);
                clickUsingJS(ProgramMenu, "Program Side Menu Tab"); 
                break;  
            }
        }
 	}
 	
 	public boolean isRowPresent(String rowName) {
 		
 		String rowpath = "//tr[.//input [@value ='"+ rowName +"']]//following-sibling::td[2]/div/p";
 		int size = driver.findElements(By.xpath(rowpath)).size();
 		return size > 0;
 	}
 	
 	public void deleteExistingRecords(String rowName ) throws Exception{
 		if(isRowPresent(rowName)) {
 			WebElement rowname = driver.findElement(By.xpath("//tr[.//input [@value ='"+ rowName +"']]//following-sibling::td[2]/div/p"));
 			//Assert.assertTrue(rowname.isDisplayed(), "Construction type in sheet is not present in the website list");
 			System.out.println(rowName + " is Present.");
 			Thread.sleep(2000);
 			rowname.click();
 			System.out.println(rowName + " is Deleted.");
 		}
 		else {
 			
 			System.out.println(rowName + " is not found. Skipping deletion.");
 		}
 		
 	}
 	
 	public void addNewConstructionRow(String RowName, String RowValue) throws Exception {
 		
 		if (isRowPresent(RowName)) {
            System.out.println("Row for '" + RowName + "' already exists. Skipping.");
        }
        else {
        	addicon.click();
        	System.out.println("Row Added: " + RowName );
     		Thread.sleep(2000);
     		WebElement rowname = driver.findElement(By.xpath("//tr[last()]/td[1]/div/input"));
     		enterText(rowname, "New Construction Type", RowName);
     		System.out.println("Added " + RowName + ": "+ rowname);
     		
     		WebElement rowvalue = driver.findElement(By.xpath("//tr[last()]/td[2]/div/input"));
     		enterText(rowvalue, "New Construction Value", RowValue);
     		System.out.println("Added " + RowValue + ": "+ rowvalue);
        }
 	}
 	
 	public void clickSaveButton() {
 		
 		savebutton.click();
  	}
 	
 	public void usernavigateToParagraphtabs() throws Exception {
 		
 		Thread.sleep(5000);
 		scrolltoElement(editbutton);
 		click(programfilling, "Program Filing / Preparation");
 
 	}
 	
 	public void validateValues(String ExpectRowName, String ExpectRowValue) {
 		try {
 			Thread.sleep(3000);
 			String actrowpath = "//p[text() = '"+ ExpectRowName+"']";
 		 	String actname  = driver.findElement(By.xpath(actrowpath)).getText();
 		 	System.out.println("Actual row : " +actname);
 		 		if(actname.equalsIgnoreCase(ExpectRowName)) {		
 	 			Assert.assertEquals(actname, ExpectRowName, "The Actual Row and " + ExpectRowName	 + " does not match."); 			
 				}
 			}
 		catch(Exception e){
 			Assert.fail("The row for " + ExpectRowName + " was not found. It may not have been added correctly.");
 			}
 	}
 	
 
}
 