package com.big.pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Rows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.big.utils.ScenarioContext;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class ProgramStructureObj extends TestReusables {
	ScenarioContext sc = new ScenarioContext();
    static Utilities ut = new Utilities();
    public RemoteWebDriver driver= ut.getDriver();
    public ProgramStructureObj() 
    {
        super();
    }
    private Map<String, String> addRowData;
    private Map<String, String> deleteRowData;
    
    @FindBy(xpath="//div[@class='ColumnLayout---column ColumnLayout---column_padding_sparse ColumnLayout---align_start ColumnLayout---top ColumnLayout---width_narrow ColumnLayout---stack_when_phone ColumnLayout---show_dividers']//span[@class='AccentText---color_accent']")
    List<WebElement> panelOptions;
    
    @FindBy(xpath="//span[text()=\"Edit\"]")
    WebElement editButton;
    
    @FindBy(xpath="(//*[@data-testid=\"SectionLayout2-contentContainer\"])[3]/div/div/div/div[2]/div/div[1]/table/tbody/tr/td[1]")
    List<WebElement> layer;
    
    @FindBy(xpath="(//*[@data-testid=\"SectionLayout2-contentContainer\"])[8]/div/div/div/div[2]/div/div[1]/table/tbody/tr/td[1]")
    List<WebElement> popuplayer;
        
    @FindBy(xpath="(//*[@data-testid=\"SectionLayout2-contentContainer\"])[8]/div/div/div/div[2]/div/div[1]/table/tbody/tr/td[2]")
    List<WebElement> popupProgramType;
    
    @FindBy(xpath="(//*[@data-testid=\"SectionLayout2-contentContainer\"])[3]/div/div/div/div[2]/div/div[1]/table/tbody/tr/td[2]")
    List<WebElement> ProgramType;
    
    @FindBy(xpath="(//span[contains(text(),'Save Changes')])[1]")
    WebElement saveButton;
    
    @FindBy(xpath="//div[@class='MultiColumnLayout---column_layout MultiColumnLayout---margin_below_standard MultiColumnLayout---margin_above_none MultiColumnLayout---stack_when_phone'][1]/div")
    List<WebElement> ParagraphTabs;
        
    @FindBy(xpath="//a[text()=\"Add\"]")
    WebElement addButton;
    
    public void selectPanels(String panels) throws InterruptedException {
         for (WebElement PanelOption : panelOptions) {                
                if (PanelOption.getText().equalsIgnoreCase(panels)) {
                    System.out.println("PanelOption: "+ PanelOption.getText()); 
                    Thread.sleep(1000);
                    scrolltoElement(PanelOption);
                    Thread.sleep(2000);
                    clickUsingJS(PanelOption, "panels"); 
                    break;  
                }
            }
    }
    public void selectPopUpPanels(String panels) throws InterruptedException {
         for (WebElement PanelOption : panelOptions) {                
                if (PanelOption.getText().equalsIgnoreCase(panels)) {
                    System.out.println("PanelOption: "+ PanelOption.getText()); 
                   Thread.sleep(1000);
                    scrolltoElement(PanelOption);
                    Thread.sleep(2000);
                    clickUsingJS(PanelOption, "panels"); 
                    break;  
                }
            }
    }
    public void clickSaveButton() throws InterruptedException {
    	click(saveButton, "saveButton"); 
    	Thread.sleep(2000);
    }
    public void clickeditButton() throws InterruptedException {
    	System.out.println("edit");
    	
    	 // Scroll up by 500 pixels
    	Thread.sleep(1000);
    	clickUsingJS(editButton, "editButton");
    	Thread.sleep(2000);
    }

         public void clickAddButton() {
        	 clickUsingJS(addButton, "addButton");
        	 
         }
         
    public void enterProgramStructureRowData(String Layer, String ProgramType, String Limit, String Retention, String Reinstatement, String SubjectPremium) throws InterruptedException {
             driver.switchTo().activeElement().sendKeys(Layer);
             keybordentry("Tab");
             driver.switchTo().activeElement().sendKeys(ProgramType);
             keybordentry("Tab");
             driver.switchTo().activeElement().sendKeys(Limit);
             keybordentry("Tab");
             driver.switchTo().activeElement().sendKeys(Retention);
             keybordentry("Tab");
             driver.switchTo().activeElement().sendKeys(Reinstatement);
             keybordentry("Tab");
             driver.switchTo().activeElement().sendKeys(SubjectPremium);
             
         }
         
   public Map<String, String> getRowData(String testCaseID) throws InterruptedException {
	    
	 Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
     String expectedLayer = data.get("Layer");
     String expectedProgramType = data.get("Program Type");
     String expectedLimit = data.get("Limit");
     String expectedRetention = data.get("Retention");
     String expectedReinstatement = data.get("Reinstatement");
     String expectedSubjectPremium = data.get("Subject Premium");
    
    List<WebElement> Rows = driver.findElements(By.xpath("//tbody/tr"));
   
	  for (WebElement Row : Rows) {
    try {
    	
    	this.deleteRowData = new HashMap<>();
        String actualLayerpopup = Row.findElement(By.xpath(".//td[1]//div//input")).getAttribute("value");
        String actualProgramTypepopup = Row.findElement(By.xpath(".//td[2]")).getText();
        String actualLimitpopup = Row.findElement(By.xpath(".//td[3]//div//input")).getAttribute("value");
        String actualRetentionpopup = Row.findElement(By.xpath(".//td[4]//div//input")).getAttribute("value");
        String actualReinstatementpopup = Row.findElement(By.xpath(".//td[5]//div//input")).getAttribute("value");
        String actualSubjectPremiumpopup = Row.findElement(By.xpath(".//td[6]//div//input")).getAttribute("value");
        WebElement delete = Row.findElement(By.xpath(".//td[7]"));
        
        deleteRowData.put("layer", actualLayerpopup);
        deleteRowData.put("programType", actualProgramTypepopup);
        deleteRowData.put("limit", actualLimitpopup);
        deleteRowData.put("retention", actualRetentionpopup);
        deleteRowData.put("reinstatement", actualReinstatementpopup);
        deleteRowData.put("subjectPremium", actualSubjectPremiumpopup);
        

        if(actualLayerpopup.equals(expectedLayer) && (actualProgramTypepopup.equals(expectedProgramType) 
        		&& (actualLimitpopup.equals(expectedLimit)
        		&& (actualRetentionpopup.equals(expectedRetention) 
        		&& (actualReinstatementpopup.equals(expectedReinstatement)	
        		&& (actualSubjectPremiumpopup.equals(expectedSubjectPremium))))))) {
       	 Thread.sleep(1000);
       	delete.click();
       	Thread.sleep(2000);
       	click(saveButton, "saveButton");
       	 System.out.println("expectedlayer ="+expectedLayer);
           	System.out.println("actuallayer ="+actualLayerpopup);
           	System.out.println("expectedprogramtype ="+expectedProgramType);
           	System.out.println("actualprogramtype ="+actualProgramTypepopup);
		        } 
  	  }
    
     catch (Exception e) {
       
    	 System.err.println("Could not find the row or its elements.");
   }
	  }
  	  
	 return deleteRowData;
    
    }
   
   public Map<String, String> getRowData() throws InterruptedException {
	   
	   this.addRowData = new HashMap<String, String>();
	   List<WebElement> currentRows = driver.findElements(By.xpath("//tbody/tr"));
	    for (WebElement row : currentRows) {
	        try {
	            String currentLayer = row.findElement(By.xpath(".//td[1]")).getText();
	            String currentProgramType = row.findElement(By.xpath(".//td[2]")).getText();
	            String currentLimit = row.findElement(By.xpath(".//td[3]")).getText();
	            String currentRetention = row.findElement(By.xpath(".//td[4]")).getText();
	            String currentReinstatement = row.findElement(By.xpath(".//td[5]")).getText();
	            String currentSubjectPremium = row.findElement(By.xpath(".//td[6]")).getText();
	   
	        addRowData.put("layer", currentLayer);
	        addRowData.put("programType", currentProgramType);
	        addRowData.put("limit", currentLimit);
	        addRowData.put("retention", currentRetention);
	        addRowData.put("reinstatement", currentReinstatement);
	        addRowData.put("subjectPremium", currentSubjectPremium);
      } 
        
     catch (Exception e) {
       
    	 System.err.println("Could not find the row or its elements.");
   }
	  }
  	  
	 return addRowData;
    
    }
   
    public boolean verifyRowIsDeleted() {
    	 
    // Iterate through the remaining rows to see if the deleted data still exists
         List<WebElement> currentRows = driver.findElements(By.xpath("//tbody/tr"));
    for (WebElement row : currentRows) {
        try {
            String currentLayer = row.findElement(By.xpath(".//td[1]")).getText();
            String currentProgramType = row.findElement(By.xpath(".//td[2]")).getText();
            String currentLimit = row.findElement(By.xpath(".//td[3]")).getText();
            String currentRetention = row.findElement(By.xpath(".//td[4]")).getText();
            String currentReinstatement = row.findElement(By.xpath(".//td[5]")).getText();
            String currentSubjectPremium = row.findElement(By.xpath(".//td[6]")).getText();
            
            System.out.println("current " +currentLayer);
            System.out.println("currentProgramType " +currentProgramType);
            System.out.println("currentLimit " +currentLimit);

            if (currentLayer.equals(deleteRowData.get("layer")) &&
               		currentProgramType.equals(deleteRowData.get("programType")) &&
               		currentLimit.equals(deleteRowData.get("limit")) &&
               		currentRetention.equals(deleteRowData.get("retention")) &&
              		    currentReinstatement.equals(deleteRowData.get("reinstatement")) &&
               		currentSubjectPremium.equals(deleteRowData.get("subjectPremium"))) {
               	
                    System.out.println("Verification failed: The deleted row was still found in the table.");
                    return false;
                }
    }
        catch (Exception e) {
            System.err.println("Error while checking row data.");
        }
      
        }
    System.out.println("deleterowlayer "+deleteRowData.get("layer"));
   	System.out.println("deleterowprogram "+deleteRowData.get("programType"));
   	System.out.println("deleterowlimit "+deleteRowData.get("limit"));
   	System.out.println("if "+deleteRowData.get("retention"));
 System.out.println("Verification successful: The row was successfully deleted from the table.");
	  return true;
     }
	 
   }
   
