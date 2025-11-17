package com.big.pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.big.utils.ScenarioContext;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class BuildingObj extends TestReusables{

	ScenarioContext sc = new ScenarioContext();
    static Utilities ut = new Utilities();
    public RemoteWebDriver driver= ut.getDriver();
    public BuildingObj() 
    {
        super();
    }
    private Map<String, String> addBuildingRowData;
    private Map<String, String> deleteBuildingRowData;
    
    @FindBy(xpath="//a[text()=\"Add\"]")
    WebElement addButton;
    
    @FindBy(xpath="(//span[contains(text(),'Save Changes')])[1]")
    WebElement saveButton;
    
    @FindBy(xpath="//span[text()=\"Edit\"]")
    WebElement editButton;
    
    public void againclickeditButton() throws InterruptedException {
    	Thread.sleep(1000);
    	clickUsingJS(editButton, "editButton");
    	Thread.sleep(2000);
    }
    
    public void enterBuildingyearValues(String Year, String Buildings) throws InterruptedException {
        driver.switchTo().activeElement().sendKeys(Year);
        keybordentry("Tab");
        driver.switchTo().activeElement().sendKeys(Buildings);
       
    }
    public Map<String, String> getBuildingRowData() throws InterruptedException {
 	   
    	 scrolltoElement(addButton);
    	 
 	   this.addBuildingRowData = new HashMap<String, String>();
 	   List<WebElement> currentRows = driver.findElements(By.xpath("//tbody/tr"));
 	    for (WebElement row : currentRows) {
 	        try {
 	            String currentYear = row.findElement(By.xpath(".//td[1]//div//input")).getAttribute("value");
 	            String currentBuildings = row.findElement(By.xpath(".//td[2]//div//input")).getAttribute("value");
 	   
 	           addBuildingRowData.put("year", currentYear);
 	          addBuildingRowData.put("buildings", currentBuildings);
 	        
 	        } 
      catch (Exception e) {
        
     	 System.err.println("Could not find the row or its elements.");
    }
 	  }
   	  
 	 return addBuildingRowData;
     
     }
    public Map<String, String> getBuildingRowData(String testCaseID) throws InterruptedException {
    	
    	scrolltoElement(addButton);
    	 Thread.sleep(1000);
    	 Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
         String expectedYear = data.get("BuildingYear");
         String expectedBuildings = data.get("Buildings");
   	   
       List<WebElement> Rows = driver.findElements(By.xpath("//tbody/tr"));
       
   	  for (WebElement Row : Rows) {
       try {
       	
       	this.deleteBuildingRowData = new HashMap<>();
           String actualYearpopup = Row.findElement(By.xpath(".//td[1]//div//input")).getAttribute("value");
           String actualBuildingspopup = Row.findElement(By.xpath(".//td[2]//div//input")).getAttribute("value");
           WebElement delete = Row.findElement(By.xpath(".//td[3]"));
           
           deleteBuildingRowData.put("year", actualYearpopup);
           deleteBuildingRowData.put("buildings", actualBuildingspopup);
                 	
           if(actualYearpopup.equals(expectedYear) && (actualBuildingspopup.equals(expectedBuildings))) {
          	 Thread.sleep(2000);   
          	delete.click();
          	Thread.sleep(2000);
          	click(saveButton, "saveButton");	
          
       
          	 System.out.println("expectedyear ="+expectedYear);
              	System.out.println("actualyear ="+actualYearpopup);
              	System.out.println("expectedbuildings ="+expectedBuildings);
              	System.out.println("actualbuildings ="+actualBuildingspopup);
   		        } 
     	  }
           
        catch (Exception e) {
          
       	 System.err.println("Could not find the row or its elements.");
      }
   	  }
     	  
   	 return deleteBuildingRowData;
       
       }
    public boolean verifyRowIsDeleted() {
   	 
    	scrolltoElement(addButton);
        // Iterate through the remaining rows to see if the deleted data still exists
    	 List<WebElement> currentRows = driver.findElements(By.xpath("//tbody/tr"));
  	    for (WebElement row : currentRows) {
  	        try {
  	            String currentYear = row.findElement(By.xpath(".//td[1]//div//input")).getAttribute("value");
  	            String currentBuildings = row.findElement(By.xpath(".//td[2]//div//input")).getAttribute("value");
  	   
                System.out.println("currentYear " +currentYear);
                System.out.println("currentBuildings " +currentBuildings);
                

                if (currentYear.equals(deleteBuildingRowData.get("year")) &&
                		currentBuildings.equals(deleteBuildingRowData.get("buildings")))
                   		
                   		 {
                   	
                   	System.out.println("if "+deleteBuildingRowData.get("year"));
                   	System.out.println("if "+deleteBuildingRowData.get("buildings"));
                   	    System.out.println("Verification failed: The deleted row was still found in the table.");
                        return false;
                    }
        }
            catch (Exception e) {
                System.err.println("Error while checking row data.");
            }
          
            }
        System.out.println("deleterowyear "+deleteBuildingRowData.get("year"));
       	System.out.println("deleterowbuildings "+deleteBuildingRowData.get("buildings"));
     System.out.println("Verification successful: The row was successfully deleted from the table.");
    	  return true;
         }
    	 
       }
      

