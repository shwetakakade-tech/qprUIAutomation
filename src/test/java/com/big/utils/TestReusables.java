package com.big.utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.common.base.Predicate;

public class TestReusables {
	
	public static RemoteWebDriver driver;
	public static String testType;
	/*
	 * Map<String, String> mobileEmulation = new HashMap<>(); ChromeOptions
	 * chromeOptions = new ChromeOptions(); protected static
	 * ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	 */
    public TestReusables() {
    	this.driver = Utilities.getDriver();
    	PageFactory.initElements(driver, this);
    	try {
    		Utilities utils = new Utilities();
			testType = utils.getProeprty("Execution-Type");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public void closeBrowser() {
		try {
		 driver.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterText(WebElement ele, String eleName, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(text);
			writeintoReport("Entered text: '"+text+ "' in "+eleName+" field", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Text: '"+text+"' not entered in "+eleName+" field","Fail");
		}
	}

	public void click(WebElement ele, String eleName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			writeintoReport("Clicked on "+eleName, "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Not clicked on " +eleName, "Fail");
		}
	}
	
	public void selectByValue(WebElement ele, String eleName, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select select = new Select(ele);
			select.selectByValue(value);
			writeintoReport("Option at "+value+" value selected from "+eleName+" Dropdown", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Option at "+value+" value not selected from "+eleName+" Dropdown", "Fail");
		}
	}
	
	public void selectByText(WebElement ele, String eleName, String option) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(2000);
		Select select = new Select(ele);
		select.selectByVisibleText(option);
		writeintoReport("Option "+option+" selected from "+eleName+" Dropdown", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Option "+option+" not selected from "+eleName+" Dropdown", "Fail");
		
		}
	}
	
	public void selectByIndex(WebElement ele, String eleName, int index) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		Select select = new Select(ele);
		select.selectByIndex(index);
		writeintoReport("Option at "+index+" index selected from "+eleName+" Dropdown", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Option at"+index+" index not selected from "+eleName+" Dropdown", "Fail");
		
		}
	}
	
	public boolean verifyElement(WebElement ele, String eleName) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.visibilityOf(ele));
		writeintoReport(eleName+ " is displayed on the page", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport(eleName+ " is not displayed on the page", "Fail");
		}
		return ele.isDisplayed();
	}
	
	
	public boolean verifyElementUntilLocated(WebElement ele, String eleName) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By) ele));
		writeintoReport(eleName+ " is displayed on the page", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport(eleName+ " is not displayed on the page", "Fail");
		}
		return ele.isDisplayed();
	}
	
	
	
	public String getText(WebElement ele) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ele.getText();
	}
	
	public String getAttributeValue(WebElement ele, String attribute) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ele.getAttribute(attribute);
	}
	
	public void acceptAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			writeintoReport("Clicked OK on alert" +getAlertText() , "Pass");
		}
		catch(Exception e) {
			e.printStackTrace();
			writeintoReport("Alert not accepted" , "Fail");
		}
	}
	
	public void dismissAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			writeintoReport("Clicked cancel on alert" +getAlertText() , "Pass");
		}
		catch(Exception e) {
			e.printStackTrace();
			writeintoReport("Alert not dismissed" , "Fail");
		}
	}
	
	public String getAlertText() {
		String alertText = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return alertText;
	}
	
	public void keybordentry(String key) {
		try {

			
			Robot rb = new Robot();
			if(key.equalsIgnoreCase("Enter")) {
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			}
			if(key.equalsIgnoreCase("Tab")) {
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
				}
			if(key.equalsIgnoreCase("Down")) {
				rb.keyPress(KeyEvent.VK_DOWN);
				rb.keyRelease(KeyEvent.VK_DOWN);
				}
			if(key.equalsIgnoreCase("Up")) {
				rb.keyPress(KeyEvent.VK_UP);
				rb.keyRelease(KeyEvent.VK_UP);
				}
			if(key.equalsIgnoreCase("Right")) {
				rb.keyPress(KeyEvent.VK_RIGHT);
				rb.keyRelease(KeyEvent.VK_RIGHT);
				}
			if(key.equalsIgnoreCase("Left")) {
				rb.keyPress(KeyEvent.VK_LEFT);
				rb.keyRelease(KeyEvent.VK_LEFT);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PressSpecialKey(WebElement ele, String key) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		if(key.equalsIgnoreCase("Enter"))
		ele.sendKeys(Keys.ENTER);
		if(key.equalsIgnoreCase("Tab"))
			ele.sendKeys(Keys.TAB);
		if(key.equalsIgnoreCase("Down"))
			ele.sendKeys(Keys.DOWN);
		if(key.equalsIgnoreCase("Up"))
			ele.sendKeys(Keys.UP);
		if(key.equalsIgnoreCase("Left"))
			ele.sendKeys(Keys.LEFT);
		if(key.equalsIgnoreCase("Right"))
			ele.sendKeys(Keys.RIGHT);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public byte[] getByteScreenshot() throws IOException 
	{	byte[] fileContent = null;
	    try {
		File src = driver.getScreenshotAs(OutputType.FILE);
	    fileContent = FileUtils.readFileToByteArray(src);
	    return fileContent;
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return fileContent;
	}
	
	public String takeScreenshot(String name) {
		 try { 
			 String screenshotpath = ""+System.getProperty("user.dir")+"\\test-output\\screenshot";
			 File src = driver.getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(src, new File(screenshotpath+"\\"+name+".jpg"));
		     return screenshotpath+"\\"+name+".jpg";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	
	public String takeBase64Screenshot() {
		String screenShotpath = null;
		try {
			screenShotpath = "data:image/png;base64," + driver.getScreenshotAs(OutputType.BASE64);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return screenShotpath;
	}
	
	public void navigateBack() {
		try {
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		writeintoReport("Navigated to previous page on the browser", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Exception while navigating back on browser", "Fail");
		}
	}
	
	public void clickUsingJS(WebElement ele, String eleName) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		driver.executeScript("arguments[0].click();", ele);
		writeintoReport("Clicked on "+eleName, "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Not clicked on " +eleName, "Fail");
		}
	}
	
	public void enterTextUnsingJS(WebElement ele, String eleName, String eleText) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		String script = String.format("arguments[0].value='%s';", eleText);
		driver.executeScript(script, ele);
		writeintoReport("Entered text: '"+eleText+ "' in "+eleName+" field", "Pass");
		}
		catch (Exception e) {
			e.printStackTrace();
			writeintoReport("Text: '"+eleText+"' not entered in "+eleName+" field","Fail");
		}
	}
	
	public void dragAndDrop(WebElement ele1, WebElement ele2) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele1));
		wait.until(ExpectedConditions.visibilityOf(ele2));
		Actions action = new Actions(driver);
		action.dragAndDrop(ele1, ele2).build().perform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void movetoElement(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void assertTwoTexts(String expected, String actual) {
		try {
			
			Assert.assertEquals(actual, expected);
			writeintoReport(actual + " text matches expected text", "Pass");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			writeintoReport(actual + " text not matches expected text", "Fail");
		}
	}
	
	public void scrolltoElement(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ele));
			driver.executeScript("arguments[0].scrollIntoView();", ele);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scrolltoElements (List<WebElement> ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElements(ele));
			driver.executeScript("arguments[0].scrollIntoView();", ele);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Set<String> getWindowHandles() {
		Set<String> handles = new HashSet<String>();
		try {
			handles = driver.getWindowHandles();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return handles;
	}
	
	public String getWindowHandle() {
		String handle = null;
		try {
			handle = driver.getWindowHandle();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return handle;
	}
	
	public void switchToWindow(String winHandle) {
		try {
			driver.switchTo().window(winHandle);
			writeintoReport("Focus switched to "+winHandle, "Pass");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			writeintoReport("Error while switching focus to "+winHandle, "Fail");
		}
	}
	
	public void switchToDefaultWindow(){
		try {
			driver.switchTo().defaultContent();
			writeintoReport("Focus switched to Main window", "Pass");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			writeintoReport("Error while switching focus to main window", "Fail");
		}
	}
	
	public void switchToFrame(WebElement frame) {
		try {
			driver.switchTo().frame(frame);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToDefaultContent(){
		try {
			driver.switchTo().defaultContent();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToDefaultByClosingChilds() {
		try {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		int i=0;
		for(String window : windows) {
			if(i!=0) {
				driver.switchTo().window(window).close();
			}
			i++;
		}
		driver.switchTo().window(windows.get(0));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void keyboardActions(WebElement ele, Keys key) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void keyboardActionsusingRobot(WebElement ele, int key) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		Robot rb = new Robot();
		rb.keyPress(key);
		rb.keyRelease(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void deleteAllCookies() {
		try {
			driver.manage().deleteAllCookies();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeintoReport(String text, String status) {
		try {
		if(testType.equalsIgnoreCase("Cucumber")) {
			if(status.equalsIgnoreCase("Pass"))
			ExtentCucumberAdapter.addTestStepLog(text);
			else {
				ExtentCucumberAdapter.getCurrentStep().fail(text);
				ExtentCucumberAdapter.getCurrentStep().addScreenCaptureFromPath(takeScreenshot("Failed_sh"));
			}
		}
		else {
			if(status.equalsIgnoreCase("Pass"))
				ExtentTestManager.getTest().log(Status.PASS, text);
			else
				ExtentTestManager.getTest().log(Status.FAIL, text);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public static void waitForPageToLoad(WebDriver driver, By elementLocator, int timeoutInSeconds) {
        try {
            // Create WebDriverWait instance with the specified timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            
            // Wait for the element to be visible (or present, depending on your needs)
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            
            // Optionally, you can print out or log the element to confirm it was found
            System.out.println("Page loaded, found element: " + element.getText());
        } catch (Exception e) {
            // Handle exception if the element doesn't load within the timeout period
            System.out.println("Page did not load within the specified time.");
            e.printStackTrace();
        }
    }
	
	
	
	public void selectCustomDropdownValue(By dropdownValueLocator,
            By optionsContainerLocator,
            String valueToSelect) {
// 1. Click to open the dropdown
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownValueLocator));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		 dropdown.click();

// 2. Wait for options container to be visible
		 List<WebElement> options = wait.until(
				 ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsContainerLocator)
				 );

// 3. Loop through options and click the one with matching visible text
		 for (WebElement option : options) {
			 if (option.getText().trim().equalsIgnoreCase(valueToSelect)) {
				 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
				 option.click();
				 return;
}
}
}
	
	
}
	
	
   

