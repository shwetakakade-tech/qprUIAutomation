package com.big.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;


public class AuthorizationDecision_Actions extends TestReusables {
	
Utilities ut = new Utilities();

	
	public AuthorizationDecision_Actions()
	{
		super();
	}
	
	@FindBy(xpath="//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[2]")
    WebElement clickProceedToNextLevelAuthorization;
	
	@FindBy(xpath="//span[normalize-space()='Program Authorization - Property Cat XoL']/following::input")
	WebElement clickDropdown;
	
	@FindBy(xpath="//ul[@role='listbox']/child::li[1]/descendant::div")
	WebElement selectFromDropdown;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement clickSubmit;
	
	@FindBy(xpath="//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[3]")
    WebElement clickAuthorizationDecision;
	
	@FindBy(xpath="//strong[normalize-space()='Currency:']")
	WebElement clickONANYElement;
	
	@FindBy(xpath="//div[@class='ParagraphWidget---container ParagraphWidget---height_medium']/textarea")
	WebElement enterRemarks;
	
	
	
	public void get_Tab_Name()
	{
		WebElement ele=driver.findElement(By.xpath("(//div[@class='ContentLayout---content_layout ContentLayout---padding_less ContentLayout---margin_above_none'])[5]"));
		
		String Stage = ele.getText();
		System.out.println("Stage: " + Stage);
	}
	
	
	public void click_Action_button()
	{
	
		click(clickProceedToNextLevelAuthorization, "Proceed To Next Level Authorization");
		
	}
	
	public void select_from_dropdown()
	{
		
		
		enterText(clickDropdown,"Select user", "m");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click(selectFromDropdown,"select User");
		
	}
	
	public void click_submit()
	{
		click(clickSubmit,"Submit");
		
	}
	
	public void click_Authorization_Decision()
	{
		click(clickONANYElement,"click anywhere on page to cancel tooltip because its blocking the next button to click");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//this is used when tooltip blocks next element to click so we need to force click
		/*WebElement nextButton = driver.findElement(By.xpath("//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[3]/child::span[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextButton);*/
		
		click(clickAuthorizationDecision,"Authorization Decision");
	}
	
	
	public void get_list_of_buttons(List<String> expectedButtons)
	{
		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button/descendant::span[1]"));
        System.out.println("Total buttons found: " + buttons.size());
        
        List<String> buttonNames = new ArrayList<>();
        for (WebElement btn : buttons) {
            String[] parts = btn.getText().split("\\r?\\n");
            for (String part : parts) {
                if (!part.isBlank()) {
                	buttonNames.add(part.trim());
                }
            }
        }

        System.out.println("Available Buttons:");
        for (String button : buttonNames) {
            System.out.println(button);
        }
        
       Assert.assertTrue(buttonNames.containsAll(expectedButtons),"Some expected buttons are missing!");
        
	}
	
	
	
	public void select_Actions_Approve_Reject(List<String> actions) throws InterruptedException
	{
		enterText(enterRemarks,"Remarks","Approve or Reject");
		
		for (String action : actions) 
		{
            
            WebElement actionBtn = driver.findElement(By.xpath("//button[normalize-space()='" + action + "']"));

            if (actionBtn.isDisplayed() && actionBtn.isEnabled()) {
                System.out.println("Clicking action: " + action);
                actionBtn.click();
            } else {
                throw new RuntimeException("Action not available: " + action);
            }
          
	    }
		
		
		
	}
	
	public void select_Action(List<String> actions) throws InterruptedException
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    for (String action : actions) {
	        if (action.equalsIgnoreCase("APPROVE")) {
	            // Enter remarks and click Approve
	            enterText(enterRemarks, "Remarks", "Approve");
	            driver.findElement(By.xpath(
	                "//div[@class='ColumnArrayLayout---column_layout ColumnArrayLayout---standard_spacing']/descendant::button[2]/child::span"
	            )).click();

	            Thread.sleep(5000);
	            js.executeScript("window.scrollBy(0, 350);");

	            WebElement actual = driver.findElement(By.xpath(
	                "//div[@class='FieldLayout---field_layout FieldLayout---margin_below_standard FieldLayout---margin_above_none FieldLayout---inColumnArrayLayout'][3]"
	            ));

	            String actualResult = actual.getText();
	            String expected = "Approval / Rejection Remarks\nApprove";
	            System.out.println("✅ Approve - Actual: " + actualResult);
	            System.out.println("✅ Approve - Expected: " + expected);
	            assertTwoTexts(actualResult, expected);

	            Thread.sleep(4000);
	            js.executeScript("window.scrollBy(0, -400);");

	            // cancel popup before moving to next action
	            click(clickONANYElement, "Click Element to cancel Popup");
	            click(clickAuthorizationDecision, "Authorization Decision");
	        } 
	        else if (action.equalsIgnoreCase("REJECT")) {
	            // Enter remarks and click Reject
	            enterText(enterRemarks, "Remarks", "Reject");
	            driver.findElement(By.xpath(
	                "//div[@class='ColumnArrayLayout---column_layout ColumnArrayLayout---standard_spacing']/descendant::button[3]/child::span"
	            )).click();

	            Thread.sleep(5000);
	            js.executeScript("window.scrollBy(0, 400);");

	            WebElement actual1 = driver.findElement(By.xpath(
	                "//div[@class='ColumnLayout---column ColumnLayout---column_padding_standard ColumnLayout---align_start ColumnLayout---top ColumnLayout---width_auto ColumnLayout---stack_when_phone appian-context-last-in-list']//div[5]"
	            ));

	            String actualResult1 = actual1.getText();
	            String expected1 = "Authorization Status\nAuthorization Request Rejected";
	            System.out.println("✅ Reject - Actual: " + actualResult1);
	            System.out.println("✅ Reject - Expected: " + expected1);
	            assertTwoTexts(actualResult1, expected1);
	        } 
	        else {
	            throw new IllegalArgumentException("Unknown action: " + action);
	        }
	    }
	}
	
	public void select_action_approve_reject() throws InterruptedException
	{
		enterText(enterRemarks,"Remarks","Approve");
		driver.findElement(By.xpath("//div[@class='ColumnArrayLayout---column_layout ColumnArrayLayout---standard_spacing']/descendant::button[2]/child::span")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 350);");
		WebElement actual=driver.findElement(By.xpath("//div[@class='FieldLayout---field_layout FieldLayout---margin_below_standard FieldLayout---margin_above_none FieldLayout---inColumnArrayLayout'][3]"));
		
		String actualResult = actual.getText();
	    System.out.println("Actual Result: "+actualResult);
	    String expected = "Approval / Rejection Remarks\nApprove";
	    System.out.println("Expected Result: "+expected);
	    assertTwoTexts(actualResult,expected);
	    Thread.sleep(4000);
	    js.executeScript("window.scrollBy(0, -400);");
	    click(clickONANYElement,"click Element to cancel Popup");
	    click(clickAuthorizationDecision,"Authorization Decision");
	    enterText(enterRemarks,"Remarks","Reject");
	    driver.findElement(By.xpath("//div[@class='ColumnArrayLayout---column_layout ColumnArrayLayout---standard_spacing']/descendant::button[3]/child::span")).click();
	    Thread.sleep(5000);
	    js.executeScript("window.scrollBy(0, 400);");
	    WebElement actual1= driver.findElement(By.xpath("//div[@class='ColumnLayout---column ColumnLayout---column_padding_standard ColumnLayout---align_start ColumnLayout---top ColumnLayout---width_auto ColumnLayout---stack_when_phone appian-context-last-in-list']//div[5]"));
	    String actualResult1 = actual1.getText();
	    System.out.println("Actual Result: "+actualResult1);
	    String expected1 = "Authorization Status\nAuthorization Request Rejected";
	    System.out.println("Expected Result: "+expected1);
	    assertTwoTexts(actualResult1,expected1);
	}
	
	
		
	
}
