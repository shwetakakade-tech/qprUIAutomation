package com.big.pageObjects;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

import junit.framework.Assert;

public class Negotiation_QuotationTabPO extends TestReusables {
	
	Utilities ut = new Utilities();

	public Negotiation_QuotationTabPO() {
		super();
	}
	
		
	@FindBy(xpath="//div[@class='FullOverlay---billboard_content FullOverlay---full_height FullOverlay---content_align_end FullOverlay---hide_overflow_y']/parent::div/following-sibling::div/descendant::h2[2]")
	WebElement scrollToAssignedProg;
	
	@FindBy(xpath="//span[text()='Assigned Programs']/parent::h2/following-sibling::div/descendant::input")
	WebElement searchCaseId;
	
	@FindBy(xpath="//span[text()='Assigned Programs']/parent::h2/following-sibling::div/descendant::button[@class='Button---btn Button---default_direction Button---small appian-context-first-in-list appian-context-last-in-list Button---inSideBySide Button---search Button---icon_start']")
	WebElement clickSearchBtn;
	
	@FindBy(xpath="a[href='https://bigappmarket-dev.appiancloud.com/suite/sites/demo-qpr-underwriting-workbench/page/home/record/lUB66Q0EwjHQrpszO9iixrrCO3sOOCoJoJdnpaqqg9Ct7RRpG8cmUMYdFEdQzIE3S1Skty3co1FV4pHWp_1T9Im0R7UhU4Hii6mxAjz5BpY8inqMrfH/view/summary']")
	WebElement ClickCaseId;
	
	@FindBy(xpath="//div[@class='FieldLayout---field_layout FieldLayout---margin_below_standard FieldLayout---margin_above_standard']/descendant::strong")
	WebElement ScrollToActions;
	
	@FindBy(xpath="//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[3]")
	WebElement clickSendRefusalEmail;
	
	@FindBy(xpath="//div[@class='ContentLayout---content_layout ContentLayout---margin_above_none']/descendant::div[11]")
	WebElement clickDropdown;
	
	@FindBy(xpath="//li[@role='option']/div[1]")
	WebElement selectRecipientTo;
	
	@FindBy(xpath="//textarea[@class='ParagraphWidget---textarea ParagraphWidget---align_start ParagraphWidget---height_short ParagraphWidget---inModalDialogLayout']")
	WebElement enterAdditionalRecipientTo;
	
	@FindBy(xpath="//div[contains(text(),'Communication')]")
	WebElement clickCommunicationTab;
		
	@FindBy(xpath="//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start'][1]")
	WebElement clickSendBtn;
	
	@FindBy(xpath="//p[@class='ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p'])[1]")
	WebElement ExpectedText;
	
	
	
	
	public void click_send_button() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		click(clickSendBtn,"SendBtnClick");
    }
	
	public void scroll_up_page_and_clickCommunication() throws InterruptedException
	{
		
		Thread.sleep(7000);
		WebElement scrol = driver.findElement(By.xpath("//div[contains(text(),'Communication')]"));
        new Actions(driver).scrollToElement(scrol).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Communication')]")).click();
		Thread.sleep(3000);
		click(clickCommunicationTab,"clickCommunication");
    }
	
	public void scroll_down_page()
	{
		scrolltoElement(scrollToAssignedProg);
    }
	
	public void scroll_to_Actions()
	{
		scrolltoElement(ScrollToActions);
    }
	
	public void enter_descrpn_in_email()
	{
		
		WebElement iframe = driver.findElement(By.xpath("//div[@class='CertifiedSAILExtension---sail_extension CertifiedSAILExtension---wrapping_div CertifiedSAILExtension---height_auto']/child::iframe"));
        
        driver.switchTo().frame(iframe);
        WebElement emailE = driver.findElement(By.xpath("//div[@class='ql-editor']"));
        emailE.clear();
        emailE.sendKeys("Lorem ipsum dolor sit amet");
        driver.switchTo().defaultContent();

	}
	
	public void click_nonBinding_refusal_email()
	{
		
		click(clickSendRefusalEmail,"refusalEmailClick");
		click(clickDropdown,"dropdownClick");
		click(selectRecipientTo,"recipentToClick");
		enterText(enterAdditionalRecipientTo, "additionalRecipient","namita.sharma@bitsinglass.com");
		
	}
	
	public void VerifyCommunicationtab()
	{
		WebElement actual= driver.findElement(By.xpath("(//td)[2]"));
		String ActualResult = actual.getText();
		System.out.print(ActualResult);
		String expected = "prashant.todmal@bitsinglass.com";
		Assert.assertEquals(expected, ActualResult);
		
	}
//(//p[@data-testid='ParagraphText-paragraph'][normalize-space()='namita.sharma@bitsinglass.com'])[1]


}


	
	
	
	
	


