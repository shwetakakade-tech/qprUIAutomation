package com.big.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class PricingStructure_Actions extends TestReusables{
	Utilities ut = new Utilities();
	
	public PricingStructure_Actions()
	{
		super();
	}
	
	@FindBy(xpath="(//span[contains(text(),'Pricing Structure Overview')])[1]")
	WebElement scroltoPricingStructure;
	
	@FindBy(xpath="//span[normalize-space()='In-depth Analysis']")
	WebElement clickInDepthAnalysis;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[2]/child::td[5]/div/input")
	WebElement enterInTechnicalRate1;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[3]/child::td[5]/div/input")
	WebElement enterInTechnicalRate2;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[2]/child::td[8]/div/input")
	WebElement enterInBrokerageFree1;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[3]/child::td[8]/div/input")
	WebElement enterInBrokerageFree2;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[2]/child::td[11]/div/input")
	WebElement enterInMField1;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[3]/child::td[11]/div/input")
	WebElement enterInMField2;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[2]/child::td[12]/div/input")
	WebElement enterInDField1;
	
	@FindBy(xpath="//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/descendant::tr[3]/child::td[12]/div/input")
	WebElement enterInDField2;
	
	@FindBy(xpath="//span[contains(text(),'Submit')]/ancestor::button")
	WebElement clickSubmit;
	
	@FindBy(xpath="//strong[normalize-space()='Structure & Technical Pricing']")
	WebElement clickStructuralTechnicalPricing;
	
			
	public void verify_case_ID()
	{
		WebElement ele = driver.findElement(By.xpath("//div[@class='ColumnArrayLayout---column_layout ColumnArrayLayout---standard_spacing ColumnArrayLayout---minHeight_buttonSmall appian-context-last-in-list']/descendant::h1"));
		String actual = ele.getText();
		
		Assert.assertTrue("Case Id mismatch!", actual.contains("#"));
		
	}
	
	public void click_update_pricing_button() throws InterruptedException
	{
	        Thread.sleep(5000);			
            click(scroltoPricingStructure, "Pricing Structure Overview");
		
	}
	
	
	public void enter_values_in_firm_window()
	{
		enterInTechnicalRate1.clear();
		enterText(enterInTechnicalRate1,"Technical Rate", "2");
		enterInTechnicalRate2.clear();
		enterText(enterInTechnicalRate2,"Technical Rate", "3");
		enterInBrokerageFree1.clear();
		enterText(enterInBrokerageFree1,"Brokerage Free", "2");
		enterInBrokerageFree2.clear();
		enterText(enterInBrokerageFree2,"Brokerage Free", "4");
		enterInMField1.clear();
		enterText(enterInMField1,"M%", "2");
		enterInMField2.clear();
		enterText(enterInMField2,"M%", "2");
		enterInDField1.clear();
		enterText(enterInDField1,"D%", "3");
		enterInDField2.clear();
		enterText(enterInDField2,"D%", "5");
		
	}
	
	public void click_submit_button()
	{
		click(clickSubmit, "Submit");
		
	}
	
	public void click_structural_pricing_tab()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);");
		click(clickStructuralTechnicalPricing, "Structural & Technical Pricing");		
	    js.executeScript("window.scrollBy(0, 300);"); 
		/*WebElement element = driver.findElement(By.xpath("//strong[normalize-space()='Structure & Technical Pricing']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);*/
	}
	
	public void verify_structure_and_pricing() throws InterruptedException
	{
		Thread.sleep(3000);

        


        WebElement table = driver.findElement(By.xpath("//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']"));
       // WebElement table = driver.findElement(By.xpath("//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        //  Store actual table values in List<List<String>>
        List<List<String>> actualTable = new ArrayList<>();

        for (WebElement row : rows) {
            List<String> rowData = new ArrayList<>();
            List<WebElement> cols = row.findElements(By.xpath("./th|./td")); // include headers
            for (WebElement col : cols) {
                rowData.add(col.getText().trim());
            }
            actualTable.add(rowData);
        }

        //  Expected table values
        List<List<String>> expectedTable = Arrays.asList(
        		Arrays.asList("Layer","Limit","Retention","RI","AAL","Technical Rate","ROL","Gross RI Premium","Brokerage Fee","Brokerage Amount","Net RI Premium", "M %","D %","M & D Premium"),
        		Arrays.asList("1st Layer","16111212","9000000","1@100%","32,222,424.00","2%","4.354382%","3,700,000.00","2%","74,000.00","3,626,000.00","2%","3%","74,000.00\n111,000.00"),
        		Arrays.asList("2nd Layer","40000000","25111212","1@100%","80,000,000.00","3%","7.207207%","5,550,000.00","4%","222,000.00","5,328,000.00","2%","5%","111,000.00\n277,500.00")
        );

        //  Assertion: Compare both tables
        Assert.assertEquals(expectedTable, actualTable);
        writeintoReport(actualTable + " text matches expected text", "Pass");

        //  Print table 
        System.out.println("----- Actual Table -----");
        for (List<String> row : actualTable) {
            System.out.println(String.join(" | ", row));
        }
        
       System.out.println("----- Expected Table -----");
        for (List<String> row : expectedTable) {
            System.out.println(String.join(" | ", row));
        }

        driver.quit();
    }
}


