package com.big.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class ContractCasePagePreparation_Actions extends TestReusables {
	Utilities ut = new Utilities();

	public ContractCasePagePreparation_Actions() {
		super();
	}


	@FindBy(xpath ="\"(//div[contains(@class,'MultiColumnLayout')])[2]//div[contains(@class,'has_bar_bottom')]")
	private  WebElement activeElement;

	@FindBy (xpath = "(//div[contains(@class,'MultiColumnLayout')])[2]//div[contains(@class,'CardLayout---card_item CardLayout')]")
	private List<WebElement> stages;

	@FindBy (xpath = "//div[contains(@class,'has_bar_bottom')]")
	private WebElement focusedElement;

	@FindBy (xpath = "//strong[contains(text(),'Underwriter')]/parent::p")
	private WebElement underwriter;

	@FindBy (xpath = "//strong[contains(text(),'Underwriting Team')]/parent::p")
	private WebElement underwritingTeam;

	@FindBy (xpath = "(//span[text()='Assign Underwriter'])[1]")
	private WebElement assignUnderWriterButton;

	@FindBy (xpath = "(//div[contains(@class,'DropdownWidget')])[1]//div//div") // //div[contains(@class,'DropdownWidget---placeholder')]
	private WebElement underWritingTeamDropdown;

	@FindBy (xpath = "//input[contains(@class, 'PickerWidget---picker_input')]")
	private WebElement underWriterTextBox;

	@FindBy (xpath = "//ul[@role='listbox']//li")
	private List<WebElement> underWriterTeams;

	@FindBy (xpath = "//ul[contains(@id,'b32460aa326310566deaac15db7cdf79_suggestions')]//li")
	private List<WebElement> underWriterMemebers;

	@FindBy (xpath = "//button[contains(@type,'button')]//span[text()='Assign']")
	private WebElement assignButton;


	@FindBy (xpath = "(//div[contains(@class,'MultiColumnLayout---column_layout Multi')])[2]//div[contains(@class,'ColumnLayout')]")
	private List<WebElement> caseStages;

	@FindBy (xpath = "//div[contains(@class,'RecordActionWidget---button_layout_inner_wrapper')]//div[@data-testid='virtualButtonLayout-div']//button//span//span[2]")
	private List<WebElement> upfrontActionsButtons;  

	@FindBy (xpath = "//strong[text()='Actions']")
	private WebElement actionsModule;
	
	@FindBy (xpath = "(//button[contains(@type,'button')]//span[text()='Reassign Underwriter'])[1]")
	private WebElement reassignUnderWriterButton;


	@FindBy (xpath = "//div[contains(@class,'DropdownWidget---dropdown')]//span")
	private WebElement reassignUnderWriterTeam;

	@FindBy (xpath = "//a[contains(@class,'PickerTokenWidget---remove elements---global')]")
	//class="PickerTokenWidget---remove elements---global_a"
	private WebElement removeUnderWriter;



	/**
	 * Checks if the specified stage is completed by verifying its background color.
	 * 
	 * @param stageName Name of the stage to check
	 * @return true if the stage is completed, false otherwise
	 * @throws InterruptedException if thread sleep is interrupted
	 * @author Dhanesh Bhor
	 */

	public boolean isStageCompleted(String stageName) throws InterruptedException 
	{

		for (WebElement stage : caseStages) {
			System.out.println("Stage123456789: " + stage.getText().trim());
			if (stage.getText().trim().equalsIgnoreCase(stageName)) 
			{
				Thread.sleep(2000);
				String color = stage.getCssValue("background-color");
				System.out.println(color);
				return color.contains("28, 193, 1") || color.equals("rgba(0, 0, 0, 0)");
			}
		}
		return false;	
	}

	/** checks if the Underwriter label is blank or absent.
	 * 
	 * @author Dhanesh Bhor
	 * @date August 6, 2025
	 */

	public boolean isUnderwriterBlank() 
	{

		String text = underwriter.getText().replace("Underwriter", "").trim();
		return text.isEmpty();
	}


	/** checks if the Underwriting Team label is blank or absent.
	 * 
	 * @author Dhanesh Bhor
	 * @date August 6, 2025
	 */


	public boolean isUnderwritingTeamBlank()
	{

		String text = underwritingTeam.getText().replace("Underwriting Team", "").trim();
		return text.isEmpty();
	}

	/**
	 * Clicks the Assign Underwriter button to open the assignment dialog.
	 * 
	 * @author Dhanesh Bhor
	 * @date August 6, 2025
	 */

	public void clickOnAssignUnderWriter() 
	{
		clickUsingJS(assignUnderWriterButton,"Assign Underwriter Button");

	}
	
	public void clickOnReassignUnderWriter() 
	{
		waitForPageToLoad(driver, By.xpath("(//button[contains(@type,'button')]//span[text()='Reassign Underwriter'])[1]"),20);
		clickUsingJS(reassignUnderWriterButton,"Clicked On Reassign Underwriter Button");
		waitForPageToLoad(driver, By.xpath("//span[contains(@class,'PickerTokenWidget---label')]"),20);

	}


	/**
	 * Selects the Underwriting Team and Underwriter based on provided names.
	 * 
	 * @param teamName        Name of the underwriting team to select
	 * @param underwriterName Name of the underwriter to assign
	 * @throws InterruptedException if thread sleep is interrupted
	 * @author Dhanesh Bhor
	 */

	public void selectUnderwritingTeam(String teamName) throws InterruptedException 
	{
		clickUsingJS(underWritingTeamDropdown,"UnderWriting Team");
		System.out.println(" Number of teams found: " + underWriterTeams.size());
		boolean teamFound  = false;
		for (WebElement underWriterTeam : underWriterTeams) { 
			String actualText = underWriterTeam.getText().trim();
			String expectedText = teamName.trim();
			System.out.println("Validate Actual UnderWriting Team " + actualText);
			System.out.println("Validate Expected UnderWriting Team " +expectedText);

			if (actualText.equalsIgnoreCase(expectedText)) 
			{
				System.out.println("Validate Option selected" + actualText);
				Thread.sleep(3000); 
				click(underWriterTeam, "underWriterTeam");
				teamFound = true;
				break;
			}

		}
		if (!teamFound) {
			throw new RuntimeException("❌ Underwriting Team not found: " + teamName);
		}
	}


	public void selectUnderwriter(String underwriterName)throws InterruptedException  {

		clickUsingJS(underWriterTextBox,"UnderWriter");
		underWriterTextBox.clear();   
		enterText(underWriterTextBox,"UnderWriter TextBox",underwriterName);
		Thread.sleep(2000);
		keybordentry("Enter");
		Thread.sleep(2000);
		movetoElement(assignButton); // Ensure the button is in view
		clickUsingJS(assignButton,"ASSIGN BUTTON");

	}
	

	/**
	 * Checks if the specified stage is currently focused.
	 * 
	 * @param stageName Name of the stage to check
	 * @return true if the stage is focused, false otherwise
	 * @author Dhanesh Bhor
	 */

	public boolean areActionButtonsPresent(List<String> expectedButtons) 
	{
		scrolltoElement(actionsModule);  // Scroll into view

		// Extract button texts manually (without streams)
		List<String> actualTexts = new ArrayList<>();
		for (WebElement button : upfrontActionsButtons) {
			actualTexts.add(button.getText().trim().toLowerCase());
		}

		System.out.println("Actual buttons found on UI: " + actualTexts);
		boolean allPresent = true;

		// Loop through expected values and verify presence
		for (String expected : expectedButtons) {
			String expectedLower = expected.trim().toLowerCase();
			boolean matchFound = false;

			// Manually check if any actual text contains the expected (case-insensitive, partial match)
			for (String actual : actualTexts) {
				if (actual.contains(expectedLower)) {
					matchFound = true;
					break;
				}
			}

			if (!matchFound) {
				System.out.println("❌ Missing or unmatched button: " + expected);
				allPresent = false;
			} else {
				System.out.println("✅ Found button: " + expected);
			}
		}

		return allPresent;
	}
	
	
	public void openStage(String stage) throws InterruptedException {
		// TODO Auto-generated method stub
		
		waitForPageToLoad(driver, By.xpath("//strong[text()='Stakeholders']"),20);
		for (WebElement stageElement : stages) {

			System.out.println("Actual Stage: " + stageElement.getText().trim());
			System.out.println("Expected Stage: " + stage.trim());
			if (stageElement.getText().trim().equalsIgnoreCase(stage.trim())) {
				click(stageElement, "asdfdsaasdStage: " + stage);
				Thread.sleep(3000);
				break;
			}
		}

	}
	
     // to remove underwriter
	public void removeUnderwriter()
	{
		click(removeUnderWriter,"Removed existing underwriter");
		waitForPageToLoad(driver, By.xpath("//div[contains(@class,'margin_above_none')]//input[contains(@class, 'PickerWidget---picker_input')]"),20);

	}
 
	





}
