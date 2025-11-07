package com.big.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import junit.framework.Assert;

public class SendNonBindingAuthorizationEmail_Actions extends TestReusables {
	
	
	Utilities ut = new Utilities();
	
	
	public SendNonBindingAuthorizationEmail_Actions()
	{
		super();
	}
	
	@FindBy(xpath="//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[2]")
	WebElement clickSendAuthorizationEmailButton;
	
	@FindBy(xpath="//div[@class='FieldLayout---field_layout FieldLayout---margin_below_standard FieldLayout---margin_above_standard']/descendant::strong")
	WebElement ScrollToActions;
	
	@FindBy(xpath="//div[@class='CheckboxGroup---choice_pair']")
	WebElement clickCheckbox;
	
	@FindBy(xpath="//div[@class='ParagraphWidget---container ParagraphWidget---height_medium']/child::textarea")
	WebElement enterTexts;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement clickSave;
	
	@FindBy(xpath="//strong[normalize-space()='Negotiation Results']")
	WebElement clickNegotiationResultsTab;
	
	
	public void scroll_to_Actions()
	{
		scrolltoElement(ScrollToActions);
    }
	
	public void click_authorization_email_button() throws InterruptedException
	{
		Thread.sleep(3000);
		click(clickSendAuthorizationEmailButton,"Send Non Binding Authorization Email");
	}

	public void click_acknowledge_Checbox()
	{
		click(clickCheckbox, "Clicked CheckBox");
	}
	
	public void enter_texts_in_wordingProposal() 
	{
		enterText(enterTexts,"Wording Proposal","Added Wording proposal In Email");
	}
	
	public void click_save()
	{
		click(clickSave,"Save Button");
	}
	
	
	public void click_negotaition_results_tab() throws InterruptedException
	{
		Thread.sleep(4000);
		click(clickNegotiationResultsTab,"Negotiation Results");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 200);");
	}
	
	
	public void verify_authorization_email()
	{
		
		WebElement row = driver.findElement(By.xpath("//table[@class='PagingGridLayout---table PagingGridLayout---scrollable PagingGridLayout---striped PagingGridLayout---distribute']//tbody/tr[1]"));

		// Get the text of the row
		String actualRowText = row.getText();
		System.out.println(actualRowText);

		// Define the expected text
		String expectedSubstring = "New Test Insurance";
		assertTrue(actualRowText.contains(expectedSubstring));
		writeintoReport(actualRowText + " text matches expected text", "Pass");

    }

	    
}	
	

	
	