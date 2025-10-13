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
import java.time.temporal.ChronoUnit;
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
		TestReusables tr = new TestReusables();

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
		
		@FindBy(xpath = "//ul[@role = 'listbox']/li[1]/div//span")
		WebElement clientemailid;
		
		@FindBy(xpath = "//ul[@role = 'listbox']/li[2]/div//span")
		WebElement brokeremailid;
		
		
		@FindBy(xpath = "//textarea [@class = 'ParagraphWidget---textarea ParagraphWidget---align_start ParagraphWidget---height_medium ParagraphWidget---inModalDialogLayout']")
		WebElement wordingProposalTextArea;
		
		@FindBy(xpath = "//h1[@class = 'TitleText---page_header']")
		WebElement titletext;
		
		@FindBy(xpath = "//a[@class = 'LinkedItem---standalone_richtext_link elements---global_a']")
		List<WebElement> communicationRecords;
		
		@FindBy(xpath = "//div[@class ='PagingGridLayout---scrollable_content']/table/tbody/tr/td[3]/div/p")
		List<WebElement> emailbody;
		
		
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
		
		public void selectRecipient1(String recipientEmail) {
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
		
		String ClientemailId;
		public void selectRecipient() {
			click(clientemailid, "Select Client Email id from drop down");
			ClientemailId = clientemailid.getText();
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
		
		public void checkVisiblity() {
			scrolltoElement(sendAuthEmailbutton);
			assertTrue("Send Authorization Email button is disabled", sendAuthEmailbutton.isEnabled());
		}
		
		public void clickSendAuthorizationButton() {
		click(sendAuthEmailbutton, "Send Authorization Email");
		System.out.println("Clicked on Send Authorization Email button");
		}
		public void navigatesToAuthorizationSection() throws Exception {
			Thread.sleep(4000);
			click(authorizationresults, "Authorization Results Section");
			System.out.println("Navigates to Authorization Result Section");
		}	
		
		@FindBy(xpath = "//nav[@data-owl-test-label = 'nav']/div[4]/div/div/a/span/span")
		WebElement userinfo;
		
		public void validateAuthorizationEmail1() throws Exception {
			ZoneId uiZone = ZoneId.of("America/New_York"); // change timezone
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a").withZone(uiZone);

			// 2. Get the timestamp string from the web element.
			//String uiTimestampString = latestDateTime.getText();
			String uiTimestampString = latestDateTime.getAttribute("textContent");
			Thread.sleep(3000);
			System.out.println("Print time: "+uiTimestampString);
			
			// 3. Parse the UI string into a ZonedDateTime object.
			ZonedDateTime uiTimestamp = ZonedDateTime.parse(uiTimestampString, formatter);

			// 4. Get the current system time in the same timezone.
			ZonedDateTime systemTimestamp = ZonedDateTime.now(uiZone);

			// 5.  This is the key step.
			// It removes the seconds and nanoseconds, making the comparison fair.
			ZonedDateTime truncatedUiTime = uiTimestamp.truncatedTo(ChronoUnit.MINUTES);

			ZonedDateTime truncatedSystemTime = systemTimestamp.truncatedTo(ChronoUnit.MINUTES);

			System.out.println("UI Time (Truncated to Minute):     " + truncatedUiTime);
			System.out.println("System Time (Truncated to Minute): " + truncatedSystemTime);

			// 6. Assert that the truncated objects are equal.
			// This is more robust than comparing strings.
			Assert.assertEquals(truncatedUiTime, truncatedSystemTime, "The UI timestamp (date, hour, and minute) does not match the current system time.");
			
			
			String expectedTovalue = driver.findElement(By.xpath("//tr[@data-dnd-name ='row 2']/td[3]/p")).getText(); 
			click(userinfo, "User Information" );
			String actualFromvalue = driver.findElement(By.xpath("//span[@class = 'VirtualUserProfileLayout---username']")).getText();
			String expectedFromvalue = driver.findElement(By.xpath("//tr[@data-dnd-name ='row 2']/td[2]/p")).getText();
			
			System.out.println("value1: " + ClientemailId);
			System.out.println("value2: " + expectedTovalue);
			System.out.println("value3: " + actualFromvalue);
			System.out.println("value4: " + expectedFromvalue);
			
			Assert.assertTrue(ClientemailId.equals(expectedTovalue) && actualFromvalue == expectedFromvalue, "One or more values did not match.");
		}
		
		public void validateAuthorizationEmail() throws Exception {
			
			ZoneId istZone = ZoneId.of("Asia/Kolkata");
			ZoneId etZone = ZoneId.of("America/New_York");
			ZonedDateTime nowInIst = ZonedDateTime.now(istZone);
			Thread.sleep(5000);
			String latestdateandtime = latestDateTime.getText();
			ZonedDateTime currentdateandtime = nowInIst.withZoneSameInstant(etZone);
			
			//String latetestDateTime = latestDateTime.getText();
			System.out.println("latest Date and Time: " +latestdateandtime);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a");
			String formattedCurrentTime = currentdateandtime.format(formatter);
			
			System.out.println("Current time: " +formattedCurrentTime.toString());
			//assertTwoTexts(formattedCurrentTime, laterestDateTime);
			boolean condition = (latestdateandtime.compareTo(formattedCurrentTime)>0);
			
			Assert.assertTrue(latestdateandtime.equalsIgnoreCase(formattedCurrentTime) || condition, "Latest date and time is not matching with system date and time");
			
			
			String expectedTovalue = driver.findElement(By.xpath("//tr[@data-dnd-name ='row 2']/td[3]/p")).getText(); 
			String expectedFromvalue = driver.findElement(By.xpath("//tr[@data-dnd-name ='row 2']/td[2]/p")).getText();
			click(userinfo, "User Information" );
			Thread.sleep(2000);
			String actualFromvalue = driver.findElement(By.xpath("//span[@class = 'VirtualUserProfileLayout---username']")).getText();
			Thread.sleep(2000);
			click(latestDateTime, "Date and Time");
			System.out.println("value1: " + ClientemailId);
			System.out.println("value2: " + expectedTovalue);
			System.out.println("value3: " + actualFromvalue);
			System.out.println("value4: " + expectedFromvalue);
			
			Assert.assertTrue(ClientemailId.equals(expectedTovalue) && actualFromvalue.equals(expectedFromvalue), "One or more values did not match.");
		
		}	
		
		public void validateEmailSendInCommunication() {
			
			String actualtext = "Authorization";
			String expectedtext = driver.findElement(By.xpath("//div[@class ='PagingGridLayout---scrollable_content']/table/tbody/tr/td[1]/div/p")).getText();
			
			Assert.assertTrue(expectedtext.contains(actualtext), expectedtext);
			
			
		    String emailtext = driver.findElement(By.xpath("//div[@class ='PagingGridLayout---scrollable_content']/table/tbody/tr/td[3]/div/p")).getText();
		    String actualemailtext = "This is a test wording Proposal";
		    System.out.println(emailtext);
		    
		    Assert.assertTrue(emailtext.contains(actualemailtext) , "Actual text is not found in emailbody");
		    
		
		}

}