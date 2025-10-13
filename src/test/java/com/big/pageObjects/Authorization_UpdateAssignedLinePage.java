package com.big.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;


public class Authorization_UpdateAssignedLinePage extends TestReusables {

	Utilities ut = new Utilities();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	CommonObj co = new CommonObj();
	HomePage_Actions hpa = new HomePage_Actions();

	public Authorization_UpdateAssignedLinePage() {
		super();
	}
	
	@FindBy(xpath = "(//span[text() = 'Update Signed Lines'])[1]")
	WebElement updatesignedlinebutton;
	
	@FindBy(xpath = "//strong[text() = 'Signed Lines and Signing Page']")
	WebElement signedLinesandSigningPage;
	
	@FindBy(xpath = "(//span[contains(text() , 'Update Signed Lines')])[4]")
	WebElement actUpdateLineheading;
	
	@FindBy(xpath = "(//input [@class = 'TextInput---text TextInput---align_start TextInput---inEditableGridLayout'])[1]")
	WebElement layer1signedvalue;

	@FindBy(xpath = "(//input [@class ='TextInput---text TextInput---align_start TextInput---inEditableGridLayout'])[2]")
	WebElement layer2signedvalue;
	
	@FindBy(xpath = "(//strong [text() = 'Currency:'])[2]")
	WebElement currencytext;
	
	@FindBy(xpath = "//span[text()= 'Submit']")
	WebElement signedSubmitbutton;
	
	@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---center elements---global_p'])[7]")
	WebElement actlayer1;
	
	@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---center elements---global_p'])[14]")
	WebElement actlayer2;
	
	
	public void verifyUpdateLinePopupTitle(){
		
		String actheading = actUpdateLineheading.getText();
		System.out.println(actUpdateLineheading);				
		String expheading = "Update Signed Lines";
		Assert.assertTrue(actheading.contains(expheading), "The element's text does not contain 'Update Signed Lines'.");
		}
	
	public void insertSignedlinesvalues(String layer1, String layer2 ) {
		enterText(layer1signedvalue, "Enter Layer1 Value" , layer1);
		click(currencytext, "currency text");
		enterText(layer2signedvalue, "Enter layer2 value", layer2);
		System.out.println("Enter Layer1 value: " + layer1 +"");
		System.out.println("Enter Layer2 value: " + layer2 +"");
	}
	
	public void signedSubmit() {
		click(signedSubmitbutton, "Signed Submit button");
		System.out.println("Clicked on Save button");
	}
	
	public void clickonSingedLineandSingingPage() throws Throwable {
		Thread.sleep(5000);
		click(signedLinesandSigningPage, "Signed Lines and Signing Page");
	}

	public void verifySingnedLinesValues(String layer1values, String layer2values) {
		String actlayer1value = actlayer1.getText();
		String actlayer2value = actlayer2.getText();
		assertTwoTexts(actlayer1value, layer1values);
		assertTwoTexts(actlayer2value, layer2values);
	}
	
}
