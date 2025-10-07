package com.big.stepdef;

import com.big.pageObjects.HomePage_Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CaseNumber {
	
	HomePage_Actions homeAtionobj= new HomePage_Actions();
			
	@Given("User selects the case {string} from the list")
	public void user_selects_the_case_from_the_list(String string) {
	   System.out.println("Hello");
	}

	@Given("User navigate to {string} CaseMenu tab")
	public void user_navigate_to_case_menu_tab(String caseMenu) {
		homeAtionobj.usernavigatetoCasemenu(caseMenu);
        System.out.println("Hello1");
		
	}

	@When("User navigate to {string} paragraphtab")
	public void user_navigate_to_paragraphtab(String paragraphTab) throws InterruptedException {
		 Thread.sleep(4000);
		    homeAtionobj.usernavigatetoParagraphtabs(paragraphTab);
		System.out.println("Hello2");
	}

	@When("User selects {string} of case")
	public void user_selects_of_case(String string) {
		System.out.println("Hello3");
	}

	
}
