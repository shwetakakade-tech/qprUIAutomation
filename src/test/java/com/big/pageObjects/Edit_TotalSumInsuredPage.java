package com.big.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.big.utils.TestReusables;

public class Edit_TotalSumInsuredPage extends TestReusables{
	
	@FindBy(xpath = "//a[@aria-label = 'Next page']")
	WebElement next;
	
	@FindBy(xpath = "//a[@class = 'GridFooter---add_grid_row_link elements---global_a']")
	WebElement addicon;
	
	@FindBy (xpath = "//a[@aria-label = 'Next page']")
	WebElement nextbutton;
	
// Condition to check the record we try to delete/add is present in application or not //
	
	public boolean isRowPresent(String rowName) {
 		
 		String rowpath = "//tr[.//input [@value ='"+ rowName +"']]//following-sibling::td[2]/div/p";
 		int size = driver.findElements(By.xpath(rowpath)).size();
 		return size > 0;
	}
	
// Insert data after checking the condition if record is already present of not ///
	
	public void addNewConstructionRow(String RowName, String RowValue, String RowValue2) throws Exception {
 		
 		if (isRowPresent(RowName)) {
            System.out.println("Row for '" + RowName + "' already exists. Skipping.");
        }
        else {
        	addicon.click();
        	System.out.println("Row Added: " + RowName );
     		Thread.sleep(2000);
     		WebElement rowname = driver.findElement(By.xpath("//tr[last()]/td[1]//input"));
     		enterText(rowname, "New Type", RowName);
     		System.out.println("Added " + RowName + ": "+ rowname);
     		
     		WebElement rowvalue = driver.findElement(By.xpath("//tr[last()]/td[2]//input"));
     		enterText(rowvalue, "New Value", RowValue);
     		System.out.println("Added " + RowValue + ": "+ rowvalue);
     		
     		WebElement rowvalue2 = driver.findElement(By.xpath("//tr[last()]/td[3]//input"));
     		enterText(rowvalue2, "New Value2", RowValue2);
     		System.out.println("Added " + RowValue2 + ": "+ rowvalue);
        }
 	}

// Validate the added records are showing in application// 	
	
 	public void validateValues(String ExpectRowName, String ExpectRowValue, String ExpectRowValue2) throws Exception {
 		boolean rowfound = false;
 		Thread.sleep(3000);
 		while(rowfound == false) {
 			List<WebElement> actrowpath = driver.findElements(By.xpath("//div[@class = 'PagingGridLayout---scrollable_content']//tr/td[1]/p"));
 			for(int i = 0; i<actrowpath.size() ; i++) {
 				String actname = actrowpath.get(i).getText();
 				if(actname.equalsIgnoreCase(ExpectRowName)) {
 	 				Assert.assertEquals(actname, ExpectRowName, "The Actual Row and " + ExpectRowName	 + " does not match.");
 	 				System.out.println("Actual value: " + actname +" is matching with Expected value" + ExpectRowName  );
 	 				rowfound = true;
 	 				break;
 	 			}
 	 			
 			}
 			click(nextbutton, "Next Button");
 			Thread.sleep(3000);
 		}
 	}
}

