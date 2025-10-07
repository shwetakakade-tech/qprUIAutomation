package com.big.pageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;


	public class Authorization_SendAuthorizationEmailPage extends TestReusables {
		
		
		Utilities ut = new Utilities();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		CommonObj co = new CommonObj();

		public Authorization_SendAuthorizationEmailPage() {
			super();
		}
		
		@FindBy (xpath = "(//span[text() = 'Send Authorization Email'])[1]") 
		WebElement sendAuth ;
		
		@FindBy(xpath = "//span [text() = 'Authorization Email']")
		WebElement authTitle;
		
		@FindBy (xpath = "//span [@class = 'MultipleDropdownWidget---value_display']")
		WebElement authRecipient;
		
		@FindBy(xpath = "//label[@class = 'CheckboxGroup---choice_label']")
		WebElement authAcknowledgeCheckbox;
		
		@FindBy(xpath = "//button[@class = 'Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
		WebElement sendAuthEmailbutton;
		
		@FindBy(xpath = "//ul[@role = 'listbox']/li")
		List<WebElement> allRecipients;
		
		@FindBy(xpath = "//textarea [@class = 'ParagraphWidget---textarea ParagraphWidget---align_start ParagraphWidget---height_medium ParagraphWidget---inModalDialogLayout']")
		WebElement wordingProposalTextArea;
		
		@FindBy(xpath = "//h1[@class = 'TitleText---page_header']")
		WebElement titletext;
		
		@FindBy(xpath = "//a[@class = 'LinkedItem---standalone_richtext_link elements---global_a']")
		List<WebElement> communicationRecords;
		
		@FindBy(xpath = "//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p']")
		List<WebElement> communicationAllRecords;
		
		@FindBy(xpath = "//strong [text() = 'Authorization Results']")
		WebElement authorizationresults;
		
		@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p'])[10]")
		WebElement latestDateTime;
		
		public void sendauth(){
			click(sendAuth, "Send Authorization Email");
			System.out.println("Clciked on Send Authorization Email Action Button");
		}
		
		public void verifyAuthEmailTitle(){
			String actAuthTitle = authTitle.getText();
			System.out.println(actAuthTitle);				
			String expAuthTitle = "Authorization Email";
			assertTwoTexts(expAuthTitle, actAuthTitle);
			
			System.out.println("Verified Authorization Email pop-up Heading");
			}
			
		public void clickRecipientDropdown() {
			click(authRecipient, "Recipient DropDown");
		}	
		
		public void selectRecipient(String recipientEmail) {
			for (WebElement RecipientEmail : allRecipients) {
				 System.out.println(RecipientEmail);		 
				 String actemail = RecipientEmail.getText();
				 if (actemail.equalsIgnoreCase(recipientEmail)) {
		            	System.out.println("RecipientEmail: "+ actemail);
		            	click(RecipientEmail, "RecipientEmail"); 
		            	break;
		            }
				 assertTwoTexts(actemail, recipientEmail);    
			}
			System.out.println("Email Recipient Selected");
		}
		
		public void authacknowledgeCheckBox() {
			assertFalse(authAcknowledgeCheckbox.isSelected(), "Acknowledge checkbox is checked");
		}
		
		public void wordingProposalText(String wordingText) {
			click(authAcknowledgeCheckbox, "Acknowledge CheckBox");
			wordingProposalTextArea.clear();
			wordingProposalTextArea.sendKeys(wordingText);
			System.out.println("Wording text is entered:" + wordingText);
		}
		
		public void visiblityAndClicksendAuthEmailButton() {
			assertTrue("Send Authorization Email button is disabled", sendAuthEmailbutton.isEnabled());
			click(sendAuthEmailbutton, "Send Authorization Email");
			System.out.println("Clicked on Send Authorization Email button");
		}
		
		public void navigatesToAuthorizationSection(String string) throws Exception {
			Thread.sleep(5000);
			click(authorizationresults, "Authorization Results Section");
			System.out.println("Navigates to Authorization Result Section");
		}	
		
		public void validateAuthorizationEmail() throws Exception {
			
			ZoneId istZone = ZoneId.of("Asia/Kolkata");
			ZoneId etZone = ZoneId.of("America/New_York");
			ZonedDateTime nowInIst = ZonedDateTime.now(istZone);
			Thread.sleep(5000);
			String latestdateandtime = latestDateTime.getText();
			ZonedDateTime currentdateandtime = nowInIst.withZoneSameInstant(etZone);
			
			String laterestDateTime = latestDateTime.getText();
			System.out.println("latest Date and TIme:" +latestdateandtime);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a");
			String formattedCurrentTime = currentdateandtime.format(formatter);
			
			System.out.println("Current time:" +formattedCurrentTime.toString());
			assertTwoTexts(formattedCurrentTime, laterestDateTime);
		}
		
		public void clickOnCummination(String string) {
			//Thread.sleep(5000);
			scrolltoElement(titletext);
			co.user_navigate_to_casemenu(string);
		}	
		
		public void validateEmailSendInCommunication(String authemail) {
			boolean emailFound = false;
		    for (WebElement authEmail : communicationRecords) {
		        if (authEmail.getText().contains(authemail)) {
		            emailFound = true;
		            break;
		        }
		    }
		    System.out.println("email found with text:" + authemail );
		    Assert.assertTrue(emailFound, "Authorization Email '" + authemail + "' was not found in the communication.");
		}
		
		

}