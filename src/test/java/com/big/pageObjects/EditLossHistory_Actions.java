package com.big.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class EditLossHistory_Actions extends TestReusables {
    Utilities ut = new Utilities();
    String testCaseID = "TC_011";

    private Map<String, String> deletedRowData;

    public EditLossHistory_Actions() {
        super();
    }

    @FindBy(xpath = "//button[@class='Button---btn Button---default_direction Button---small appian-context-first-in-list Button---icon_start']")
    private WebElement EditButton;

    @FindBy(xpath = "//a[normalize-space()='Add']")
    private WebElement AddButton;

    @FindBy(xpath = "//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inModalDialogLayout Button---icon_start']")
    private WebElement SaveButton;

   
    private int initialRowCount;
    
    public void clickeditbutton() {
        click(EditButton, "Edit button");
    }

    public void clickAddbutton() {
        click(AddButton, "Add button");
    }

    public void enteryear(String LossHistoryYear, String LossHistoryDescription, String LossHistoryLossAmount) throws InterruptedException {
        driver.switchTo().activeElement().sendKeys(LossHistoryYear);
        keybordentry("Tab");
        driver.switchTo().activeElement().sendKeys(LossHistoryDescription);
        keybordentry("Tab");
        driver.switchTo().activeElement().sendKeys(LossHistoryLossAmount);
    }

    public void clicksavebutton() {
        click(SaveButton, "Save button");
    }

    public void deleteRandomRow() {
        try {
            List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

            // Capture the initial count before the deletion
            this.initialRowCount = rows.size(); 

            if (rows.isEmpty()) {
                System.out.println("No rows to delete. The table is empty.");
                return;
            }

            // Generate a random index to select a row
            Random random = new Random();
            int randomIndex = random.nextInt(rows.size());
            
            // to delete random value user random Index
            WebElement rowToDelete = rows.get(randomIndex);

            
            // to delete 1 row 
            //WebElement rowToDelete = rows.get(1);


            // Capture the data before deleting
            this.deletedRowData = new HashMap<>();
            String year = rowToDelete.findElement(By.xpath(".//td[1]//input")).getAttribute("value");
            String description = rowToDelete.findElement(By.xpath(".//td[2]//input")).getAttribute("value");
            String lossAmount = rowToDelete.findElement(By.xpath(".//td[3]//input")).getAttribute("value");
            
            deletedRowData.put("year", year);
            deletedRowData.put("description", description);
            deletedRowData.put("lossAmount", lossAmount);
            
         // Print the data that is about to be deleted
            System.out.println("--- Deleting the following row ---");
            System.out.println("Year: " + deletedRowData.get("year"));
            System.out.println("Description: " + deletedRowData.get("description"));
            System.out.println("Loss Amount: " + deletedRowData.get("lossAmount"));
            System.out.println("----------------------------------");
            
            // Find and click the delete icon within the specific row
            WebElement deleteIcon = rowToDelete.findElement(By.xpath(".//span[contains(@class, 'IconWidget---color_negative')]"));
            click(deleteIcon, "Delete icon for a random row at index " + randomIndex);

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Could not find the delete icon on the randomly selected row.");
        }
    }

    //--------------------------------------------------------------------------------------------------
    // VERIFICATION METHODS
    //--------------------------------------------------------------------------------------------------

    public Map<String, String> getLastRowData() {
        Map<String, String> rowData = new HashMap<>();
        try {
            WebElement lastRow = driver.findElement(By.xpath("//tbody/tr[last()]"));
            
            String actualYear = lastRow.findElement(By.xpath(".//td[1]//input")).getAttribute("value");
            String actualDescription = lastRow.findElement(By.xpath(".//td[2]//input")).getAttribute("value");
            String actualLossAmount = lastRow.findElement(By.xpath(".//td[3]//input")).getAttribute("value");
            
            rowData.put("year", actualYear);
            rowData.put("description", actualDescription);
            rowData.put("lossAmount", actualLossAmount);
            
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Could not find the last row or its elements.");
        }
        return rowData;
    }

    public boolean verifyRowIsDeleted() {
        // Check if any data was stored
        if (this.deletedRowData == null || this.deletedRowData.isEmpty()) {
            System.err.println("No row data was stored to verify deletion.");
            return false;
        }
        
        List<WebElement> currentRows = driver.findElements(By.xpath("//tbody/tr"));
        
        // Check if the row count has decreased by one
        if (currentRows.size() != this.initialRowCount - 1) {
            System.err.println("Verification failed: The row count did not decrease as expected. Expected: " + (this.initialRowCount - 1) + ", Found: " + currentRows.size());
            return false;
        }
        
        // Iterate through the remaining rows to see if the deleted data still exists
        for (WebElement row : currentRows) {
            try {
                String currentYear = row.findElement(By.xpath(".//td[1]//input")).getAttribute("value");
                String currentDescription = row.findElement(By.xpath(".//td[2]//input")).getAttribute("value");
                String currentLossAmount = row.findElement(By.xpath(".//td[3]//input")).getAttribute("value");

                // If a match is found, the deletion failed
                if (currentYear.equals(deletedRowData.get("year")) &&
                    currentDescription.equals(deletedRowData.get("description")) &&
                    currentLossAmount.equals(deletedRowData.get("lossAmount"))) {
                    System.out.println("Verification failed: The deleted row was still found in the table.");
                    return false;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.err.println("Error while checking row data.");
            }
            System.out.println("Verification successful: The row count is correct and the row was deleted.");
            return true;
        }
        
        System.out.println("Verification successful: The row was successfully deleted from the table.");
        return true;
    }
}