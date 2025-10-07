package com.big.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class EditProgramDetails extends TestReusables {

	public static RemoteWebDriver driver = Utilities.getDriver();

	public EditProgramDetails() {
		super();
	}

	// Locators (example placeholders)
	@FindBy(xpath = "//span[text() = 'Edit']")
	WebElement editbutton;

	@FindBy(xpath = "(//div[text() = 'Case Details'])[2]")
	WebElement casedetailstitle;

	@FindBy(xpath = "(//input[@placeholder= 'Name'])[1]")
	WebElement clientname;

	@FindBy(xpath = "(//textarea[@placeholder= 'Address'])[1]")
	WebElement clientaddress;

	@FindBy(xpath = "(//input[@placeholder= 'Name'])[2]")
	WebElement clientcontactname;

	@FindBy(xpath = "(//input [@placeholder= 'Phone'])[1]")
	WebElement clientphone;

	@FindBy(xpath = "(//input [@placeholder= 'Email'])[1]")
	WebElement clientemail;

	@FindBy(xpath = "(//input [@placeholder= 'Designation'])[1]")
	WebElement clientdesignation;

	@FindBy(xpath = "//strong [text() = 'Broker']")
	WebElement brokerdropdown;

	@FindBy(xpath = "//li[@class ='MenuWidgetItem---default_direction MenuWidgetItem---inDropdownWidget']")
	List<WebElement> brokerdropdownvalues;

	@FindBy(xpath = "(//input[@placeholder= 'Name'])[3]")
	WebElement brokercontactname;

	@FindBy(xpath = "(//textarea[@placeholder= 'Address'])[2]")
	WebElement brokeraddess;

	@FindBy(xpath = "(//input [@placeholder= 'Phone'])[2]")
	WebElement brokerphone;

	@FindBy(xpath = "(//input [@placeholder= 'Email'])[2]")
	WebElement brokeremail;

	@FindBy(xpath = "(//input [@placeholder= 'Designation'])[2]")
	WebElement brokerdesignation;

	@FindBy(xpath = "//input [@placeholder = 'Contribution Ex. 1200']")
	WebElement reinsurancecontribution;

	@FindBy(xpath = "(//div [@class = 'DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout'])[1]")
	WebElement catxolbusinesstype;

	@FindBy(xpath = "//ul[@role = 'listbox']/li")
	WebElement businesstypevaluedrop;

	@FindBy(xpath = "(//div [@class = 'DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout'])[2]")
	WebElement testnewxolbusinesstype;

	@FindBy(xpath = "(//input[@placeholder = 'mm/dd/yyyy'])[1]")
	WebElement catxoleffectivestartdate;

	@FindBy(xpath = "(//input[@placeholder = 'mm/dd/yyyy'])[4]")
	WebElement testnewxoleffectivestartdate;

	@FindBy(xpath = "(//input[@placeholder = 'mm/dd/yyyy'])[2]")
	WebElement catxoleffectiveexpirydate;

	@FindBy(xpath = "(//input[@placeholder = 'mm/dd/yyyy'])[5]")
	WebElement testnewxoleffectiveexpirydate;

	@FindBy(xpath = "(//input[@placeholder = 'mm/dd/yyyy'])[3]")
	WebElement catxoldeadlinedate;

	@FindBy(xpath = "(//input[@placeholder = 'mm/dd/yyyy'])[6]")
	WebElement testnewxoldeadlinedate;

	@FindBy(xpath = "(//input[@class = 'TextInput---text TextInput---align_start TextInput---inEditableGridLayout'])[2]")
	WebElement catxolsepandpml;

	@FindBy(xpath = "(//input[@class = 'TextInput---text TextInput---align_start TextInput---inEditableGridLayout'])[4]")
	WebElement testnewxolsepandpml;

	@FindBy(xpath = "//span[text() = 'Save Changes']")
	WebElement savechangesbutton;

	@FindBy(xpath = "(//button [@class='DatePickerWidget---calendar_btn'])[1]")
	WebElement opnclndr1;

	@FindBy(xpath = "(//button [@class='DatePickerWidget---calendar_btn'])[2]")
	WebElement opnclndr2;

	@FindBy(xpath = "(//button [@class='DatePickerWidget---calendar_btn'])[3]")
	WebElement opnclndr3;

	@FindBy(xpath = "(//button [@class='DatePickerWidget---calendar_btn'])[4]")
	WebElement opnclndr4;

	@FindBy(xpath = "(//button [@class='DatePickerWidget---calendar_btn'])[5]")
	WebElement opnclndr5;

	@FindBy(xpath = "(//button [@class='DatePickerWidget---calendar_btn'])[6]")
	WebElement opnclndr6;

	@FindBy(xpath = "//span[text() = 'Clear']")
	WebElement clrclndr;

	@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p'])[5]")
	WebElement clientName;

	@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p'])[6]")
	WebElement clientEmail;

	@FindBy(xpath = "(//p[@class = 'ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p'])[8]")
	WebElement brokerEmail;

	@FindBy(xpath = "//div [@title = 'Case Details']")
	WebElement casedetials;

	// =============================================================//
	@FindBy(xpath = "(//input[@placeholder= 'Name'])[1]")
	WebElement clientNameField;

	@FindBy(xpath = "(//textarea[@placeholder= 'Address'])[1]")
	WebElement clientAddressField;

	@FindBy(id = "brokerName")
	WebElement brokerNameField;

	@FindBy(id = "brokerAddress")
	WebElement brokerAddressField;

	@FindBy(id = "correspondenceMethod")
	WebElement correspondenceDropdown;

	@FindBy(id = "remunerationContribution")
	WebElement contributionField;

	@FindBy(id = "saveChangesButton")
	WebElement saveChangesButton;

	// Generic method to update a text field
	public void updateTextField(WebElement field, String value) {
		field.clear();
		field.sendKeys(value);
	}

	public void clickonEditButton() {
		click(editbutton, "Edit Button");
	}

	public void updateClientAddress(String clientAddress) {
		enterText(clientaddress, "Client Address", clientAddress);
	}

	public void updateClientName(String clientName) {
		enterText(clientname, "Client Name", clientName);
	}

	public void selectAndUpdateBroker(String Broker) throws Exception {
		driver.switchTo().defaultContent();
		scrolltoElement(brokerdropdown);
		By brokerdrop = By
				.xpath("(//div[@class = 'DropdownWidget---dropdown_value DropdownWidget---inSideBySideItem'])[1]");
		By brokerdropvalues = By
				.xpath("//li[@class ='MenuWidgetItem---default_direction MenuWidgetItem---inDropdownWidget']/div");
		selectCustomDropdownValue(brokerdrop, brokerdropvalues, Broker);
		Thread.sleep(2000);
	}

	public void updateBrokerAddress(String BrokerAddress) {
		enterText(brokeraddess, "Broker Address", BrokerAddress);

	}

	public void updateClientContactName(String ClientContactName) {
		enterText(clientcontactname, "Client Contact Name", ClientContactName);
	}

	public void updateClientEmail(String ClientEmail) {
		enterText(clientemail, "Client Email", ClientEmail);
	}

	public void updateClientPhone(String ClientPhone) {
		enterText(clientphone, "Client Phone Number", ClientPhone);
	}

	public void updateClientAdd(String ClientContactName) {
		enterText(clientcontactname, "Client Contact Name", ClientContactName);
	}

	public void updateClientDesignation(String ClientDesignation) {
		enterText(clientdesignation, "Client Designation", ClientDesignation);
	}



	public void selectCorrespondenceMethod(String method) {
		Select dropdown = new Select(correspondenceDropdown);
		dropdown.selectByVisibleText(method);
	}

	public void setContribution(String percentage) {
		updateTextField(contributionField, percentage);
	}



	public void updateBrokerContactName(String BrokerContactName) {
		enterText(brokercontactname, "Broker Contact Name", BrokerContactName);
	}

	public void updateBrokerContactPhone(String BrokerPhone) {
		enterText(brokerphone, "Broker Phone", BrokerPhone);
	}

	public void updateBrokerContactEmail(String BrokerEmail) {
		enterText(brokeremail, "Broker Email", BrokerEmail);

	}

	public void updateBrokerContactDesignation(String BrokerDesignation) {
		enterText(brokerdesignation, "Broker Designation", BrokerDesignation);
	}

	public void updateCatXolProgramType(String CatBusinessType, String CatStartDate, String CatExpiryDate,
			String CatDeadLine, String CatSEPPML) {

		By catbusinessdrop = By
				.xpath("(//div [@class = 'DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout'])[1]");
		By catbusinessvalues = By.xpath("//ul[@role = 'listbox']/li");

		selectCustomDropdownValue(catbusinessdrop, catbusinessvalues, CatBusinessType);

		opnclndr1.click();
		clrclndr.click();
		catxoleffectivestartdate.sendKeys(CatStartDate);

		opnclndr2.click();
		clrclndr.click();
		catxoleffectiveexpirydate.sendKeys(CatExpiryDate);

		opnclndr3.click();
		clrclndr.click();
		catxoldeadlinedate.sendKeys(CatDeadLine);

		enterText(catxolsepandpml, "Cat Xol SEP/PML", CatSEPPML);

	}

	public void updateTestNewProgramType(String testnewBusinessType, String testnewStartDate, String testnewExpiryDate,
			String testnewDeadLine, String testnewSEPPML) {

		By testnewbusinessdrop = By
				.xpath("(//div [@class = 'DropdownWidget---dropdown_value DropdownWidget---inEditableGridLayout'])[2]");
		By testnewbusinessvalues = By.xpath("//ul[@role = 'listbox']/li");
		selectCustomDropdownValue(testnewbusinessdrop, testnewbusinessvalues, testnewBusinessType);

		opnclndr4.click();
		clrclndr.click();
		testnewxoleffectivestartdate.sendKeys(testnewStartDate);
		opnclndr5.click();
		clrclndr.click();
		testnewxoleffectiveexpirydate.sendKeys(testnewExpiryDate);
		opnclndr6.click();
		clrclndr.click();
		testnewxoldeadlinedate.sendKeys(testnewDeadLine);

		enterText(testnewxolsepandpml, "Cat Xol SEP/PML", testnewSEPPML);
	}

	public void saveButton() {

		savechangesbutton.click();
	}

	public void verifyElementTextContains(WebElement element, String expectedText, String fieldName) throws Exception {
		Thread.sleep(4000); // Consider replacing with explicit waits for better practice
		scrolltoElement(element);

		System.out.println("Expected " + fieldName + ": " + expectedText);

		String actualText = element.getText();
		System.out.println("Actual " + fieldName + ": " + actualText);

		Assert.assertTrue(actualText.contains(expectedText), fieldName + " does not match.");
	}

	public void verifyClientName(String clientName) throws Exception {
		verifyElementTextContains(this.clientName, clientName, "Client Name");
	}

	public void verifyClientEmail(String clientEmail) throws Exception {

		verifyElementTextContains(this.clientEmail, clientEmail, "Client Email");
	}

	public void verifyBrokerEmail(String brokerEmail) throws Exception {

		verifyElementTextContains(this.brokerEmail, brokerEmail, "Broker Email");
	}


	public void clickSaveChanges() {
		saveChangesButton.click();
	}

	public boolean verifyChangesSaved() {
		// Add logic to verify success message or updated values
		return driver.getPageSource().contains("Changes saved successfully");
	}
}
