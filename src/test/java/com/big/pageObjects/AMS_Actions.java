package com.big.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class AMS_Actions extends TestReusables{
	Utilities ut = new Utilities();
	public AMS_Actions(){
		super();
	}
	
@FindBy(xpath=".//a[@data-test-id='202203300135520890667']")
WebElement lnkAddAsset;

@FindBy(xpath=".//*[@id='cc108b5b']")
WebElement ddnOrg;

@FindBy(xpath=".//*[@id='1399ce02']")
WebElement ddnDivision;

@FindBy(xpath=".//*[@id='f5e282ed']")
WebElement ddnUnit;

@FindBy(xpath=".//*[@id='2cdc6628']")
WebElement txtAssetType;

@FindBy(xpath=".//div[@id='po0']//div[@id='gridBody_right']//div[@class='cellIn']/span/span")
WebElement optAssetType;

@FindBy(xpath=".//*[@id='5e59a106']")
WebElement txtAssetName;

@FindBy(xpath=".//*[@id='fdf489fb']")
WebElement txtSpecifications;

@FindBy(xpath=".//*[@id='ed6e44b8']")
WebElement ddnInUse;

@FindBy(xpath=".//*[@id='54653782']")
WebElement txtAddress;

@FindBy(xpath=".//*[text()=\"Submit\"]")
WebElement btnSubmit;

@FindBy(xpath=".//div[@class='content-item content-sub_section item-2 flex flex-row']//a[@id='pui_filter'])")
WebElement filtAsset;

@FindBy(xpath=".//*[@data-test-id='2015012615503109611417']")
WebElement msgAssetSuccess;


public void verifyAssetsection() {
	verifyElement(lnkAddAsset, "Add Asset section");
}


public void createAsset(){
	try {
	click(lnkAddAsset,"AddAsset");
	selectByText(ddnOrg, "Organization",ut.getCellValue("TestData", "AddAsset", "Organization"));
	selectByText(ddnDivision, "Division", ut.getCellValue("TestData", "AddAsset", "Division"));
	selectByText(ddnUnit, "Unit", ut.getCellValue("TestData", "AddAsset", "Unit"));
	enterText(txtAssetType, "AssetType", ut.getCellValue("TestData", "AddAsset", "AssetType"));
	click(optAssetType,"Asset Type Option");
	enterText(txtAssetName, "AssetName", ut.getCellValue("TestData", "AddAsset", "AssetName"));
	enterText(txtSpecifications, "Specifications", ut.getCellValue("TestData", "AddAsset", "Specifications"));
	Thread.sleep(2000);
	selectByText(ddnInUse, "In Use", ut.getCellValue("TestData", "AddAsset", "InUse"));
	enterText(txtAddress, "Address", ut.getCellValue("TestData", "AddAsset", "Address"));
	click(btnSubmit, "Submit");
	}
	catch(Exception e) {
		e.printStackTrace();
	}

}

public void asset_created_message_verify() {
	assertTwoTexts("The Case has been Resolved successfully", getText(msgAssetSuccess));
	}

}
