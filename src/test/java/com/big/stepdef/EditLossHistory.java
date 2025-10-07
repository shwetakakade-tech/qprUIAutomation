package com.big.stepdef;

import java.util.Map;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import com.big.pageObjects.CommonObj;
import com.big.pageObjects.EditLossHistory_Actions;
import com.big.pageObjects.UpfrontAnalysis_Actions;
import com.big.utils.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLossHistory {
    CommonObj co = new CommonObj();
    static Utilities ut = new Utilities();
    public static RemoteWebDriver driver = ut.getDriver();

    UpfrontAnalysis_Actions upfrontanalysis_obj = new UpfrontAnalysis_Actions();
    EditLossHistory_Actions Edit_loss_History = new EditLossHistory_Actions();

    @When("User clicks on Edit button")
    public void user_click_on_edit_button() throws InterruptedException {
        Thread.sleep(3000);
        Edit_loss_History.clickeditbutton();
        Thread.sleep(3000);
    }

    @When("User Navigates to Program type {string}")
    public void user_navigates_to_program_type(String ProgramType) throws InterruptedException {
        co.user_navigate_to_programType(ProgramType);
        Thread.sleep(3000);
    }

    @When("Use click on Add button")
    public void user_click_on_Add_button() throws InterruptedException {
        Edit_loss_History.clickAddbutton();
        Thread.sleep(3000);
    }

    @When("User Enter Loss history Details from {string}")
    public void user_enter_loss_history_details(String testCaseID) throws InterruptedException {
        System.out.println("Expecting Year :2025");
        Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
        String year = data.get("Edit_LossHistory_Year");
        String description = data.get("Edit_LossHistory_Description");
        String lossAmount = data.get("Edit_LossHistory_LossAmount");
        
        System.out.println("Year : " + year);
        System.out.println("Description : " + description);
        System.out.println("Loss Amount : " + lossAmount);
        
        Edit_loss_History.enteryear(year, description, lossAmount);
    }

    @When("Use click on save button")
    public void user_click_on_save_button() throws InterruptedException {
        Thread.sleep(3000);
        Edit_loss_History.clicksavebutton();
        Thread.sleep(5000);
    }

    @Then("User verify loss history details {string} and {string}")
    public void User_verify_losshistory_details(String testCaseID, String ProgramType) throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        Edit_loss_History.clickeditbutton();
        Thread.sleep(2000);
        co.user_navigate_to_programType(ProgramType);
        Thread.sleep(2000);
        Map<String, String> data = ut.getTestDataAsMap("TestData.xlsx", "TestData_QPR", testCaseID);
        String expectedYear = data.get("Edit_LossHistory_Year");
        String expectedDescription = data.get("Edit_LossHistory_Description");
        String expectedLossAmountString = data.get("Edit_LossHistory_LossAmount");
        
        try {
            Map<String, String> actualData = Edit_loss_History.getLastRowData();
            String actualYear = actualData.get("year");
            String actualDescription = actualData.get("description");
            String actualLossAmountString = actualData.get("lossAmount");
            
            Assert.assertEquals(actualYear, expectedYear, "Year value does not match.");
            Assert.assertEquals(actualDescription, expectedDescription, "Description value does not match.");
            
            String wholeNumberExpected = expectedLossAmountString.split("\\.")[0];
            String cleanedActualLossAmount = actualLossAmountString.replaceAll("[$,\\s]", "");
            String wholeNumberActual = cleanedActualLossAmount.split("\\.")[0];

            Assert.assertEquals(wholeNumberActual, wholeNumberExpected, "Loss amount value does not match before the decimal point.");
            System.out.println("✅ All values for the new entry were verified successfully.");
            
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.fail("Verification failed: Could not find the expected loss history row. The row may not have been created or saved successfully.  " + e.getMessage());
        }
    }
    
    @When("User deletes a random row")
    public void user_deletes_a_random_row() throws InterruptedException {
        Thread.sleep(2000);
        Edit_loss_History.deleteRandomRow();
        Thread.sleep(2000);
        Edit_loss_History.clicksavebutton();
        Thread.sleep(5000);
    }
    
    @Then("User verify previously deleted row is no longer present {string}")
    public void the_previously_deleted_row_is_no_longer_present(String ProgramType) throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        Edit_loss_History.clickeditbutton();
        Thread.sleep(2000);
        co.user_navigate_to_programType(ProgramType);
        Thread.sleep(2000);
        
        boolean isDeleted = Edit_loss_History.verifyRowIsDeleted();
        Assert.assertTrue(isDeleted, "The row was not successfully deleted.");
        
        Thread.sleep(5000);
        
        System.out.println("✅ Row was successfully deleted and verified.");
    }
}