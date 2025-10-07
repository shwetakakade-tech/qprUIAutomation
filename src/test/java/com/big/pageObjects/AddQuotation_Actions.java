package com.big.pageObjects;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import junit.framework.Assert;

public class AddQuotation_Actions extends TestReusables {
	
	//WebDriver driver;
	Utilities ut = new Utilities();
	
	
	public AddQuotation_Actions()
	{
		super();
	}
	
	@FindBy(xpath="//strong[normalize-space()='REINSURANCE']")
	WebElement HomeText;
	
	@FindBy(xpath="//div[@class='FullOverlay---billboard_content FullOverlay---full_height FullOverlay---content_align_end FullOverlay---hide_overflow_y']/parent::div/following-sibling::div/descendant::h2[2]")
	WebElement scrollToAssignedProg;
	
	@FindBy(xpath="//span[text()='Assigned Programs']/parent::h2/following-sibling::div/descendant::input")
	WebElement enterCaseId;
	
	@FindBy(xpath="a[href='https://bigappmarket-dev.appiancloud.com/suite/sites/demo-qpr-underwriting-workbench/page/home/record/lUB66Q0EwjHQrpszO9iixrrCO3sOOCoJoJdnpaqqg9Ct7RRpG8cmUMYdFEdQzIE3S1Skty3co1FV4pHWp_1T9Im0R7UhU4Hii6mxAjz5BpY8inqMrfH/view/summary']")
	WebElement ClickCaseId;	
	
	@FindBy(xpath="//span[text()='Assigned Programs']/parent::h2/following-sibling::div/descendant::button[@class='Button---btn Button---default_direction Button---small appian-context-first-in-list appian-context-last-in-list Button---inSideBySide Button---search Button---icon_start']")
	WebElement clickSearchBtn;
	
	@FindBy(xpath="//h1[normalize-space()='#133572 | Property Cat XoL | C619']")
	WebElement verifyCaseNumber;
	
	@FindBy(xpath="(//div[@class='ContentLayout---content_layout ContentLayout---padding_less ContentLayout---margin_above_none'])[4]")
	WebElement clickNegotiationQuotation;
	
	@FindBy(xpath="//div[@class='FieldLayout---field_layout FieldLayout---margin_below_standard FieldLayout---margin_above_standard']/descendant::strong")
	WebElement scrollToActions;
	
	@FindBy(xpath="//span[contains(text(),'Add Quotation') and @class ='Button---accessibilityhidden']/parent::button")
	WebElement clickAddQuotation;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/tbody/descendant::div[1]/input")
	WebElement enterQuoteRateIn1st;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/tbody/child::tr[2]/descendant::div[1]/input")
	WebElement enterQuoteRateIn2nd;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/child::tbody/descendant::td[3]/descendant::input")
	WebElement enterValueInWrittenLine1stField;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/child::tbody/tr[2]/descendant::div[4]/input")
	WebElement enterValueInWrittenLine2ndField;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement clickSendButton;
	
	@FindBy(xpath="//strong[normalize-space()='Non - Binding Quotation']")
	WebElement NonBindingQuotation;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']")
	WebElement verifyActualValues;
	
	@FindBy(xpath="(//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable'])[1]")
	WebElement verifyExpectedValues;
	
	
	
	
	public void verify_HomePage()
	{
		assertTwoTexts("HomeText", "REINSURANCE");
	}
	
	public void scroll_down_page()
	{
		scrolltoElement(scrollToAssignedProg);
    }
	
	public void searchCaseNumber(String searchCaseID) 
	{
	       enterText(enterCaseId, "caseNumber",searchCaseID);
	       click(clickSearchBtn, "buttonclick");
	}      
	
	public void openContractCase(String caseId) {
        WebElement caseNumber = driver.findElement(By.xpath("//a[text()='#" + caseId + "']"));
        click(caseNumber,"Contract Case");
        
        }
	
	public void verify_caseId() throws InterruptedException
	{
		WebElement ele = driver.findElement(By.xpath("//h1[normalize-space()='#133604 | Property Cat XoL | C683']"));
		String actual = ele.getText();
		String expected = "#133604 | Property Cat XoL | C683";
		assertTwoTexts(expected, actual);
		
		
	}
	
	
	public void scroll_to_Actions() throws InterruptedException
	{
	    
		scrolltoElement(scrollToActions);
    }
	
		
	public void click_add_quotation()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click(clickAddQuotation, "Add Quotation");
	}
	
	
	 public void enter_Values_in_quotation_section()
	 {
		 enterQuoteRateIn1st.clear();
		 enterText(enterQuoteRateIn1st, "Quote Rate1", "5");
		 enterValueInWrittenLine1stField.clear();
		 enterText(enterValueInWrittenLine1stField, "Written Line 1", "6");
		 enterQuoteRateIn2nd.clear();
		 enterText(enterQuoteRateIn2nd, "Quote Rate2", "8");
		 enterValueInWrittenLine2ndField.clear();
		 enterText(enterValueInWrittenLine2ndField, "Written Line 2", "7");
		 
		 
		 Actions actions = new Actions(driver);
		 actions.moveByOffset(0, 0).click().perform();
		/* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 String Actualvalue= verifyActualValues.getText();
		 System.out.print(Actualvalue);*/
		 
	 }
	 
	 
	 
	 public void click_send_button()
	 {
		 
		 click(clickSendButton,"Send Button");
	 }
	 
	 public void scroll_and_click() throws InterruptedException
	 {
		 
		// scrolltoElement(NonBindingQuotation);
		// Thread.sleep(6000);
		// click(NonBindingQuotation,"Non-Binding Quotation");
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)");
		 Thread.sleep(5000);
		 click(NonBindingQuotation,"Non-Binding Quotation");	
		 
		 js.executeScript("window.scrollBy(0,300)");  
			
			
			
	 }   
	 
	 public void verify_Quotation_values()
	 {
		 
		
		         WebElement table = driver.findElement(By.xpath("//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']"));
		         List<WebElement> rows = table.findElements(By.tagName("tr"));

		         //  Store actual table values in List<List<String>>
		         List<List<String>> actualTable = new ArrayList<>();

		         for (WebElement row : rows) {
		             List<String> rowData = new ArrayList<>();
		             List<WebElement> cols = row.findElements(By.xpath("./th|./td")); // include headers
		             for (WebElement col : cols) {
		                 rowData.add(col.getText().trim());
		             }
		             actualTable.add(rowData);
		         }

		         //  Expected table values
		         List<List<String>> expectedTable = Arrays.asList(
		             Arrays.asList("Quoted Rate", "ROL", "Gross Premium", "Written Line", "Premium Reinsurer", "Liability"),
		             Arrays.asList("5%", "1.741753%", "9,250,000.00", "6%", "555,000.00", "966,673.00"),
		             Arrays.asList("8%", "2.702703%", "14,800,000.00", "7%", "1,036,000.00", "2,800,000.00")
		         );

		         //  Assertion: Compare both tables
		         Assert.assertEquals(expectedTable, actualTable);
		         writeintoReport(actualTable + " text matches expected text", "Pass");

		         //  Print table 
		         System.out.println("----- Actual Table -----");
		         for (List<String> row : actualTable) {
		             System.out.println(String.join(" | ", row));
		         }
		         
		         System.out.println("----- Expected Table -----");
		         for (List<String> row : expectedTable) {
		             System.out.println(String.join(" | ", row));
		         }

		         driver.quit();
		     }
		 }

	 
		      
			
		 
	     
	    
	    	 
	     
		
		 
		 
		 
	 

