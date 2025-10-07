package com.big.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class QPRLogin_Actions extends TestReusables {
	Utilities ut = new Utilities();

	public QPRLogin_Actions() {
		super();
	}


	@FindBy(xpath ="//a[@class='VirtualNavigationMenuTab_MERCURY_TOPBAR---nav_tab_clickable_container elements---global_a elements---inDarkBackground appian-context-ux-mouse-focus']//span[@class='VirtualNavigationMenuTab_MERCURY_TOPBAR---nav_label_text_wrapper'][normalize-space()='Home']")
	private  WebElement homeText;

	@FindBy(xpath ="(//input[@placeholder='Search Programs'])[1]")//(//input[@placeholder='Search Programs'])[1]
	private  WebElement searchBox;

	@FindBy(xpath ="(//span[text()='Search'])[1]")
	private  WebElement searchButton;


	@FindBy(xpath = "//strong[normalize-space()='REINSURANCE']")
	private  WebElement reInsuranceText;

	@FindBy (xpath = "(//div[@class='PagingGridLayout---scrollable_content'])[1]//table//tbody//tr//td//div//p//a")
	private WebElement firstCaseNumber;


	public void verifyreInsuranceText() {
		verifyElement(reInsuranceText, "REINSURANCE");
		System.out.println("Verified text");
	}

	public void verifyHomeText() {

		verifyElementUntilLocated(homeText, "Home");
		System.out.println("Verified text");
	}

	public void SelectFirstCaseNumber() {
		clickUsingJS(firstCaseNumber, "First Case Number");

		String raw = getText(firstCaseNumber);
		String number = "";
		if (raw.startsWith("#")) {
			number = raw.substring(1);
		} else {
			number = raw;
		}
		System.out.println("Case Number is: "+ number );


	}



}
