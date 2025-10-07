package com.big.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class UpdateFirmOrderTerms_Actions extends TestReusables {
	
	
	Utilities ut = new Utilities();
	

	public UpdateFirmOrderTerms_Actions() {
		super();
	} 
	
	
	@FindBy(xpath="//div[@class='FullOverlay---billboard_content FullOverlay---full_height FullOverlay---content_align_end FullOverlay---hide_overflow_y']/parent::div/following-sibling::div/descendant::h2[2]")
	WebElement scrollToAssignedProg;
	
	@FindBy(xpath="//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[4]")
	WebElement clickUpdateFirmOrderButton;
	
	@FindBy(xpath="//span[normalize-space()='Negotiation & Quotation']")
	WebElement clickNegotiationQuotation;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/tbody/descendant::div[1]/input")
	WebElement enterROLInField1;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/tbody/child::tr[2]/descendant::div[1]/input")
	WebElement enterROLInField2;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/child::tbody/descendant::td[1]/descendant::input")
	WebElement enterRateInField1;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/child::tbody/descendant::td[3]/descendant::input")
	WebElement enterRateInField2;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/child::tbody/descendant::td[2]/descendant::input")
	WebElement enterPremiumInField1;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/child::tbody/descendant::td[4]/descendant::input")
	WebElement enterPremiumInField2;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
	WebElement clickSumbitButton;
	
	@FindBy(xpath="(//strong[@class='StrongText---richtext_strong'][normalize-space()='Firm Order Terms'])[1]/parent::p")
	WebElement clickFirmOrderButton;
	
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---outline Button---small appian-context-first-in-list appian-context-last-in-list Button---icon_start']")
	WebElement clickFOTEmailButton;
	
	@FindBy(xpath="//div[@class='CardLayout---card_item CardLayout---margin_below_standard CardLayout---margin_above_none CardLayout---border_visible CardLayout---height_auto CardLayout---width_fit CardLayout---transparent appian-context-last-in-list']//div[@class='ContentLayout---content_layout ContentLayout---padding_less ContentLayout---margin_above_none']")
	WebElement verifyFOTEmail;
	
	@FindBy(xpath="//div[@class='FieldLayout---field_layout FieldLayout---margin_below_standard FieldLayout---margin_above_standard']/descendant::strong")
	WebElement ScrollToActions;
	
	
	public void scroll_to_Actions()
	{
		scrolltoElement(ScrollToActions);
    }
	
			
	public void scroll_down_page()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		scrolltoElement(scrollToAssignedProg);
    }
	
	public void verify_caseId() throws InterruptedException
	{
		
		WebElement ele = driver.findElement(By.xpath("//h1[normalize-space()='#133572 | Property Cat XoL | C619']"));
		String actual = ele.getText();
		String expected = "#133572 | Property Cat XoL | C619";
		assertTwoTexts(expected, actual);
	}	
	
	public void click_negotation_quotation_tab() throws InterruptedException
	{
		
		
		click(clickNegotiationQuotation,"Negotiation Quotation");
		
	}
	
	public void click_update_firm_order_button() throws InterruptedException
	{
		Thread.sleep(3000);
		click(clickUpdateFirmOrderButton, "Update Firm Order Terms");
	}
	
	public void enter_firm_order_terms_values()
	{
		enterROLInField1.clear();
		enterText(enterROLInField1, "enter ROL", "2");
		enterROLInField2.clear();
		enterText(enterROLInField2, "enter ROL", "3");
		enterRateInField1.clear();
		enterText(enterRateInField1, "enter Rate", "5");
		enterRateInField2.clear();
		enterText(enterRateInField2, "enter Rate", "5");
		enterPremiumInField1.clear();
		enterText(enterPremiumInField1, "enter Premium", "5");
		enterPremiumInField2.clear();
		enterText(enterPremiumInField2, "enter Premium", "5");		
		
	}
	
	public void click_submit_button()
	{
		click(clickSumbitButton, "Sumbit Button");
	}
	
	public void scroll_and_click() throws InterruptedException
	{
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//strong[@class='StrongText---richtext_strong'][normalize-space()='Firm Order Terms'])[1]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("(//strong[@class='StrongText---richtext_strong'][normalize-space()='Firm Order Terms'])[1]")).click(); */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(5000);
		click(clickFirmOrderButton,"Firm Order Terms");	
		js.executeScript("window.scrollBy(0,400)");
		
			
	}
	
	public void verify_firm_order_details()
	{
		WebElement table = driver.findElement(By.xpath("(//table[@class='PagingGridLayout---table PagingGridLayout---scrollable PagingGridLayout---striped'])[3]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        
        List<List<String>> actualTable = new ArrayList<>();
        for (WebElement row : rows) {
            List<String> rowData = new ArrayList<>();
            List<WebElement> cols = row.findElements(By.xpath("./th|./td")); // include headers
            for (WebElement col : cols) {
                rowData.add(col.getText().trim());
            }
            actualTable.add(rowData);
        }
        
        List<List<String>> expectedTable = Arrays.asList(
            Arrays.asList("ROL", "Rate", "Premium"),
            Arrays.asList("2",    "5",      "5"),
            Arrays.asList("3",    "5",      "5")
        );
    
        Assert.assertEquals(expectedTable, actualTable);
        writeintoReport(actualTable + " text matches expected text", "Pass");
        
        System.out.println("----- Actual Table -----");
        for (List<String> row : actualTable) {
            System.out.println(String.join(" | ", row));
        }
       
        System.out.println("----- Expected Table -----");
        for (List<String> row : expectedTable) {
            System.out.println(String.join(" | ", row));
        }
        
	}
	
	public void click_FOT_email_button()
	{
		boolean flag=false;
		click(clickFOTEmailButton, "FOT Email Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");
		WebElement emailField = driver.findElement(By.xpath("(//p[@class='ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p'][contains(text(),'Hi')])[1]")); 
		String acutualBody = emailField.getText();
		
		if(acutualBody.contains("FOT email"))
			flag=true;
			
		else
		{
			flag=false;
		}
		
		System.out.println("flag value" + flag);
		
		//String emailRegex = "^[A-zA-Z0-9+_.-]+@[A-zA-Z0-9.-]+\\.[a-zA-Z]+$";
       // boolean isValid = Pattern.matches(emailRegex, emailText);
		
        
		//assertTwoTexts(expected, emailText);
		Assert.assertEquals(flag,true);
	}
		
		
		
		


	
	
	

}
