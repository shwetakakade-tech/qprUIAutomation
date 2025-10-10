package com.big.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class UpdateOverallConsideration_Actions extends TestReusables {
	
Utilities ut = new Utilities();
	
	public UpdateOverallConsideration_Actions()
	{
		super();
	}
	
	@FindBy(xpath="//div[@class='RecordActionWidget---button_layout_inner_wrapper']/descendant::button[1]")
	WebElement updateOverallConsideration;
	
	@FindBy(xpath="(//iframe[contains(@src, 'richTextFieldWithTables/index.html')])[2]")
	WebElement iframeToEnterEmailBody;
	
	@FindBy(xpath="//div[@class='ColumnArrayLayout---column_layout ColumnArrayLayout---standard_spacing']/descendant::span[contains(text(),'SAVE')]")
	WebElement clickSave;
	
	@FindBy(xpath="//div[contains(@class,'note-editable')]")
	WebElement enterDescription;
	
	@FindBy(xpath="//div[@class='ColumnArrayLayout---column_layout ColumnArrayLayout---standard_spacing ColumnArrayLayout---minHeight_buttonSmall appian-context-last-in-list']/descendant::h1")
	WebElement verifyCaseId;
	
	@FindBy(xpath="//div[@class='FieldLayout---field_layout FieldLayout---margin_below_none FieldLayout---margin_above_none FieldLayout---inLightBackground appian-context-last-in-list']//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']")
	WebElement getProgramTypeSEPPML;
	
	@FindBy(xpath="(//table[@class='PagingGridLayout---table PagingGridLayout---scrollable PagingGridLayout---striped'])[1]")
	WebElement table;
	
	@FindBy(xpath="//div[@class='FieldLayout---field_layout FieldLayout---margin_below_standard FieldLayout---margin_above_none FieldLayout---inColumnArrayLayout'][1]")
	WebElement consierationText;
	
	@FindBy(xpath="//iframe[contains(@src,'richTextFieldWithTables/index.html')]")
	WebElement iframeConsiderationText;
	
	@FindBy(xpath="//div[contains(@id,'summernote')]")
	WebElement getConsiderationText;
	
	
	
	public void verify_case_ID()
	{
		
		String actual = verifyCaseId.getText();
		System.out.println(actual);
		
        try {
			
			Assert.assertTrue("Case Id mismatch!", actual.contains("#"));
			writeintoReport(actual + " text matches expected text", "Pass");
			
		    }
		catch (Exception e)
		{
			e.printStackTrace();
			writeintoReport(actual + " text not matches expected text", "Fail");
		}
				
	}
	
	
	public void scroll_and_click() throws InterruptedException
	{
		Thread.sleep(3000);
		//scrolltoElement(updateOverallConsideration);
		click(updateOverallConsideration, "Update Overall Consideration");
	}
	
	
	
	public void enter_descrpn_in_considerations_textarea() throws InterruptedException
	{
	
        switchToFrame(iframeToEnterEmailBody);
        System.out.println("We are in the iframe!");
        click(enterDescription,"Updated Considerations");
        enterDescription.clear();        
        enterText(enterDescription,"Considertaions", "New Considerations Updated");       
        switchToDefaultContent();        
        Thread.sleep(5000);
        scrolltoElement(clickSave);
        click(clickSave, "Save");
   
	}
	
	public void verify_overall_considerations() throws InterruptedException
	{
		Thread.sleep(4000);
		
		
		System.out.println(consierationText.getText());
		switchToFrame(iframeConsiderationText);
		String actual = getConsiderationText.getText();
		System.out.println(actual);
		String expected = "New Considerations Updated";
		assertTwoTexts(actual,expected);
		
		switchToDefaultContent();
		String actual1 = getProgramTypeSEPPML.getText();
		String expected1 = "Program Type: Property Cat XoL\nSEP/PML: 185000000\nCurrency: USD";
		assertTwoTexts(actual1,expected1);
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
        		Arrays.asList("Layer","Limit","","Retention","RI","AAL","Technical ROL","Non-binding ROL","FOT ROL","Written Line","Premium", "Liability"),
        		Arrays.asList("1st Layer","16111212","xs.","9000000","1@100%","32,222,424.00","4.354382%","1.741753%","2","6%","555,000.00","966,673.00"),
        		Arrays.asList("2nd Layer","40000000","xs.","25111212","1@100%","80,000,000.00","7.207207%","2.702703%","3","7%","1,036,000.00","2,800,000.00")
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

        
		
	}

}
