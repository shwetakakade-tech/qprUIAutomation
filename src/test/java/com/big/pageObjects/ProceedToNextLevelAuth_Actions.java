package com.big.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.big.utils.TestReusables;

public class ProceedToNextLevelAuth_Actions extends TestReusables {
	
	public ProceedToNextLevelAuth_Actions()
	{
		super();
	}
	
	@FindBy(xpath="//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[2]")
    WebElement clickProceedToNextLevelAuthorization;
	
	@FindBy(xpath="//span[normalize-space()='Program Authorization - Property Cat XoL']/following::input")
	WebElement clickDropdown;
	
	@FindBy(xpath="//ul[@role='listbox']/child::li[3]/descendant::div")
	WebElement selectFromDropdown;
	
	@FindBy(xpath="//a[@class='PickerTokenWidget---remove elements---global_a']")
	WebElement clickCrossIcon;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement clickSubmit;
	
	
	public void click_Action_button()
	{
	
		click(clickProceedToNextLevelAuthorization, "Proceed To Next Level Authorization");
		
	}
	
	public void click_cross_icon()
	{
		click(clickCrossIcon,"Cross Icon");
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
	
	public void verify_authorization_status() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 400);");
	    WebElement actual = driver.findElement(By.xpath("//div[@class='ColumnLayout---column ColumnLayout---column_padding_standard ColumnLayout---align_start ColumnLayout---top ColumnLayout---width_auto ColumnLayout---stack_when_phone appian-context-last-in-list']//div[5]"));
	    String actualResult = actual.getText();
	    System.out.println("Actual Result: "+actualResult);
	    String expected = "Authorization Status\nPending Authorization Decision";
	    System.out.println("Expected Result: "+expected);
	    assertTwoTexts(actualResult,expected);
	}

}
