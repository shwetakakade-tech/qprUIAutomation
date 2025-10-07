package com.big.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class UpfrontAnalysis_Actions extends TestReusables {
	Utilities ut = new Utilities();
	private final WebDriverWait wait;

	
	public UpfrontAnalysis_Actions() {
		super();
		this.wait = new WebDriverWait(Utilities.getDriver(), Duration.ofSeconds(10)); // Waits for up to 10 seconds
	
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	@FindBy(xpath ="//body//div[@id='content']//div[@class='RenderInElement---sailcontents appian-context-browser-chrome appian-context-os-windows']//div[@role='presentation']//div[@role='presentation']//div[1]//div[2]//div[2]//div[1]//p[1]//a[1]//span[1]//*[name()='svg']//*[name()='path' and contains(@d,'M256 8C119')]")
	private  WebElement UWGuidelinesGreen;
	
	@FindBy(xpath ="//body//div[@id='content']//div[@role='presentation']//div[@role='presentation']//div[1]//div[2]//div[2]//div[1]//p[1]//a[2]//span[1]//*[name()='svg']//*[name()='path' and contains(@d,'M256 8C119')]")
	private  WebElement UWGuidelinesOrange;
	
	@FindBy(xpath ="//body//div[@id='content']//div[@role='presentation']//div[@role='presentation']//div[1]//div[2]//div[2]//div[1]//p[1]//a[3]//span[1]//*[name()='svg']//*[name()='path' and contains(@d,'M256 8C119')]")
	private  WebElement UWGuidelinesRed;
	
	@FindBy(xpath ="(//*[name()='path'])[34]")
	private  WebElement CapacityRetroGreen;
	
	@FindBy(xpath ="(//*[name()='path'])[35]")
	private  WebElement CapacityRetroOrange;
	
	@FindBy(xpath ="(//*[name()='path'])[36]")
	private  WebElement CapacityRetroRed;
	
	@FindBy(xpath ="(//*[name()='path'])[38]")
	private  WebElement PerformanceGreen;
	
	@FindBy(xpath ="(//*[name()='path'])[39]")
	private  WebElement PerformanceOrange;
	
	@FindBy(xpath ="(//*[name()='path'])[40]")
	private  WebElement PerformanceRed;
	
	@FindBy(xpath ="//span[contains(text(),'Submit')]")
	private  WebElement UpfrontAnalysissubmitbutton;
	
	@FindBy(xpath ="//*[contains(text(), 'Action completed')]")
	private  WebElement UpfrontAnalysissubmitbuttonmessage;
	
	
	
	public void clickUWGuidelinesColor(String UWColor) {
		switch (UWColor.toLowerCase()) {
			case "green":
				waitForElementToBeClickable(UWGuidelinesGreen);
				click(UWGuidelinesGreen, "UW Guidelines Green button");
				break;
			case "orange":
				waitForElementToBeClickable(UWGuidelinesOrange);
				click(UWGuidelinesOrange, "UW Guidelines Orange button");
				break;
			case "red":
				waitForElementToBeClickable(UWGuidelinesRed);
				click(UWGuidelinesRed, "UW Guidelines Red button");
				break;
			default:
				throw new IllegalArgumentException("Invalid color for UW Guidelines: " + UWColor);
		}
	}
	
	
	public void clickCapacityRetroColor(String CRColor) {
		switch (CRColor.toLowerCase()) {
			case "green":
				waitForElementToBeClickable(CapacityRetroGreen);
				click(CapacityRetroGreen, "Capacity/Retro Green button");
				break;
			case "orange":
				waitForElementToBeClickable(CapacityRetroOrange);
				click(CapacityRetroOrange, "Capacity/Retro Orange button");
				break;
			case "red":
				waitForElementToBeClickable(CapacityRetroRed);
				click(CapacityRetroRed, "Capacity/Retro Red button");
				break;
			default:
				throw new IllegalArgumentException("Invalid color for Capacity Retro: " + CRColor);
		}
	}
	
	
	public void clickPerformanceColor(String PFColor) {
		switch (PFColor.toLowerCase()) {
			case "green":
				waitForElementToBeClickable(PerformanceGreen);
				click(PerformanceGreen, "Performance Green button");
				break;
			case "orange":
				waitForElementToBeClickable(PerformanceOrange);
				click(PerformanceOrange, "Performance Orange button");
				break;
			case "red":
				waitForElementToBeClickable(PerformanceRed);
				click(PerformanceRed, "Performance Red button");
				break;
			default:
				throw new IllegalArgumentException("Invalid color for Performance: " + PFColor);
		}
	}
	
	public void clickupUpfrontAnalysissubmitbutton() {
	    click(UpfrontAnalysissubmitbutton, "Upfront Analysis submit button");
	    
	}
	
	public void verifytheupfrontanalysismessage(String expectedText) {
        String actualText = UpfrontAnalysissubmitbuttonmessage.getText();
        assertTwoTexts(expectedText, actualText);
	}
	
	
	
	
}

