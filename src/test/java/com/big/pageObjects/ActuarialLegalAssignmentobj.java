package com.big.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.ScenarioContext;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class ActuarialLegalAssignmentobj extends TestReusables {

	
	 ScenarioContext sc = new ScenarioContext();
	    static Utilities ut = new Utilities();
	    public RemoteWebDriver driver= ut.getDriver();
	    public ActuarialLegalAssignmentobj() 
	    {
	        super();
	    }
	    
	    @FindBy(xpath="//div[@class=\"RecordActionWidget---button_layout_wrapper RecordActionWidget---align_start\"]//div[1]//div//button//span//span[2]")
	    List<WebElement> actionsTabs;
	    
	    @FindBy(xpath="//input[@class=\"PickerWidget---picker_input PickerWidget---placeholder\"]")
	    WebElement actuarialUser;
	    
	    @FindBy(xpath="//input[@class=\"PickerWidget---picker_input PickerWidget---placeholder\"]")
	    WebElement legalUser;
	    
	    @FindBy(xpath="//span[text()=\"Submit\"]")
	    WebElement submitButton;
	    
	    @FindBy(xpath="//strong[contains(text(),'Actuarial Analyst')]/parent::p")
	    WebElement actuarialAnalyst;
	    
	    @FindBy(xpath="//strong[contains(text(),'Legal Analyst')]/parent::p")
	    WebElement legalAnalyst;
	    
	    @FindBy(xpath="//span[text()='Assigned Programs']/parent::h2/following-sibling::div/descendant::input")
		WebElement searchCaseId;
	    
	    @FindBy(xpath="//span[text()='Assigned Programs']/parent::h2/following-sibling::div/descendant::button[@class='Button---btn Button---default_direction Button---small appian-context-first-in-list appian-context-last-in-list Button---inSideBySide Button---search Button---icon_start']")
		WebElement clickSearchBtn;
	    
	    @FindBy(xpath="(//td)[81]")
		WebElement caseNumber;
	    
	    @FindBy(xpath="(//span[@class='SizedText---medium_plus SizedText---predefined'])[2]")
		WebElement Actions;
	    
	    public void searchCaseNumberForAssignedProgram(String searchCaseID) throws InterruptedException {
	    	
		       enterText(searchCaseId, "TC_002",searchCaseID);
		       click(clickSearchBtn, "buttonclick"); 
		          	       Thread.sleep(3000);
		}
	    
	    public void openContractCaseForAssignedProgram(String Contract_ID) throws InterruptedException {
	    	    
	         Wait<RemoteWebDriver> fluentWait = new FluentWait<>(driver)
	                 .withTimeout(Duration.ofSeconds(30))
	                 .pollingEvery(Duration.ofSeconds(2))
	                 .ignoring(NoSuchElementException.class);
	           scrolltoElement(caseNumber); 
	           click(caseNumber, "caseNumber"); 
	               
	             System.out.println("Print Case Number "+caseNumber.getText());
	    	
		}
	    public void selectActions(String actions) throws InterruptedException {
	        
	         for (WebElement ActionsTab : actionsTabs) {                
	                if (ActionsTab.getText().equalsIgnoreCase(actions)) {
	                    System.out.println("ActionsTab: "+ ActionsTab.getText()); 
	                    Thread.sleep(1000);
	                    scrolltoElement(Actions);
	                    Thread.sleep(2000);
	                    clickUsingJS(ActionsTab, "actions"); 
	                    break;  
	                }
	            }
	    }
	    public void selectActuarialAnalysis(String str1) throws InterruptedException {
	      enterText(actuarialUser,"TC_002", str1);
	      Thread.sleep(2000);
	      keybordentry("Enter");
	      Thread.sleep(2000);
	      click(submitButton, "confirm_btn"); 
	      }
	    
	    public void selectLegalAnalysis(String str2) throws InterruptedException {
		      
		      enterText(legalUser,"TC_002", str2);
		      Thread.sleep(2000);
		      keybordentry("Enter");
		      Thread.sleep(2000);
		      click(submitButton, "confirm_btn"); 
		      }
	    public String ActuarialAnalystlabel() throws InterruptedException 
	    {
	Thread.sleep(3000);
	        String actuariallabel = actuarialAnalyst.getText().replace("Actuarial Analyst", "").trim();
	        return actuariallabel;
	        
	    }
	    public String LegalAnalystlabel() throws InterruptedException 
	    {
	Thread.sleep(3000);
	 String legallabel = legalAnalyst.getText().replace("Legal Analyst", "").trim();
   return legallabel;
	        
	    }
	}
