package com.big.pageObjects;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.util.Properties;
import javax.activation.*;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.ScenarioContext;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;
import com.big.utils.Variables;
import com.oracle.truffle.js.builtins.JavaBuiltins.Java;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonObj extends TestReusables {
	ScenarioContext sc = new ScenarioContext();
	static Utilities ut = new Utilities();
	public static RemoteWebDriver driver = ut.getDriver();

	public CommonObj() {
		super();
	}
	// Below code is for Common objects of Login page

	@FindBy(xpath = "//input[@id='txtUserID']")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"un\"]")
	WebElement appianusername;

	@FindBy(xpath = "//*[@id=\"pw\"]")
	WebElement appianpassword;

	@FindBy(xpath = "//input[@value='Sign In']")
	WebElement appian_Login_btn;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;

	@FindBy(xpath = "//button[@id='sub']")
	WebElement Login_btn;

	@FindBy(xpath = "//a[@id='forgotPasswordLink']")
	WebElement forgt_pswd;

	@FindBy(xpath = "//input[@id='username']")
	WebElement forgt_pswd_txt;

	// Left Widgets Element pega applications

	@FindBy(xpath = ".//*[@class='menu-item-title']")
	List<WebElement> Left_widgets_list;

	@FindBy(xpath = "(//li[@title='Monitoring'])[2]")
	List<WebElement> menu_category_list;

	// Filter Element

	/*
	 * @FindBy(xpath="//a[@id='pui_filter']") List<WebElement> Filter_list;
	 */
	@FindBy(xpath = "")
	List<WebElement> Filter_col_appian;

	@FindBy(xpath = "//a[@id='pui_filter']//parent::span//parent::div//div//child::div[@class='cellIn ']")
	List<WebElement> Filter_col;

	@FindBy(xpath = "//label[@class=' cb_standard']//preceding-sibling::input[@type='checkbox']//ancestor::td//following-sibling::td//label[@tabindex='-1']")
	List<WebElement> Filter_List;

	@FindBy(xpath = "//label[@class=' cb_standard']//preceding-sibling::input[@type='checkbox']")
	List<WebElement> Filter_checkbox;

	@FindBy(xpath = "//button[@data-test-id='px-opr-image-ctrl']")
	WebElement profile_link;

	@FindBy(xpath = "//span[text()='Log off']")
	WebElement btnLogoff;

	@FindBy(xpath = "//span[text()='Notification preferences']")
	WebElement Notification_pref;

	@FindBy(xpath = "//span[text()='About this application']")
	WebElement About_app;

	@FindBy(xpath = "//Button[text()='Apply']")
	WebElement btn_Apply;

	@FindBy(xpath = "//a[text()='Trouble logging in?']")
	WebElement forgot_password;

	@FindBy(xpath = "//h2[text()='Add/Update Assets']//ancestor::div[@id='HARNESS_CONTENT']//child::table[@id='gridLayoutTable']")
	List<WebElement> Search_rec;

	@FindBy(xpath = ".//input[@data-test-id='201411181100280377101613']")
	WebElement inpFilter_Search;

	@FindBy(xpath = "(//li[@title='Cases'])[2]")
	WebElement Cases;

	@FindBy(xpath = "//div[@class='VirtualNavigationHeaderLayout_MERCURY---tabs_wrapper']//ul//li//a//div//span")
	List<WebElement> categoryLinks;

	@FindBy(xpath = "//tbody//tr//td//div//p//a")
	List<WebElement> CaseIDlinks;

	@FindBy(xpath = "//div[@class='TabButtonGroup---tab_button_group TabButtonGroup---margin_above_none']//ul//li//a")
	List<WebElement> CaseMenuOptions;

	@FindBy(xpath = "//div[@class='MultiColumnLayout---column_layout MultiColumnLayout---margin_below_standard MultiColumnLayout---margin_above_none MultiColumnLayout---stack_when_phone']//p[@class='ParagraphText---richtext_paragraph ParagraphText---default_direction ParagraphText---align_start elements---global_p']")
	List<WebElement> ParagraphTabs;

	@FindBy(xpath = "//div[@class='ColumnLayout---column ColumnLayout---column_padding_sparse ColumnLayout---align_start ColumnLayout---top ColumnLayout---width_narrow ColumnLayout---stack_when_phone ColumnLayout---show_dividers']//span[@class='AccentText---color_accent']")
	List<WebElement> paragraphtypes;

	@FindBy(xpath = "(//div[@class='FieldLayout---input_below']//span[@class='AccentText---color_accent'])[3]")
	WebElement ParagraphType1;

	@FindBy(xpath = "(//button[@type='button'])[5]")
	WebElement CreateUser;

	@FindBy(xpath = "(//label[@class='CardStyleRadioSelects---choice_label'])[1]")
	WebElement CheckboxYes;

	@FindBy(xpath = "(//label[@class='CardStyleRadioSelects---choice_label'])[2]")
	WebElement CheckboxNo;

	@FindBy(xpath = "//span[contains(text(),'Create Chart')]")
	WebElement clickcreatechart;

	@FindBy(xpath = "(//span[contains(text(),'Close')])[1]")
	WebElement closechart;

	@FindBy(xpath = "//a[@class='LinkedItem---standalone_richtext_link LinkedItem---inStrongText LinkedItem---inColorStyledText elements---global_a']")
	WebElement pdfdownlaod;

	/*
	 * @FindBy(xpath=
	 * "//a[@id='pui_filter']//ancestor::div[@class='oflowDiv']//div/div[1]")
	 * List<WebElement> filclmnHeadings;
	 * 
	 * @FindBy(xpath= "//a[@id='pui_filter']") List<WebElement> filIcon;
	 */

	public void login(String str1, String str2) {
		enterText(username, "username", str1);
		enterText(password, "password", str2);
		click(Login_btn, "Login_btn");
	}

	public void forgot_pswd(String str1, String str2) {
		click(forgot_password, "Forgot Password");
	}

	public void application_profile(String action) throws InterruptedException {
		profile_link.click();
		switch (action) {
		case "Log Off":
			Thread.sleep(2000);
			click(btnLogoff, "Log off");
			break;
		case "Notification_pref":
			Thread.sleep(2000);
			click(Notification_pref, "Notification_pref");
			break;
		case "About Application":
			Thread.sleep(2000);
			click(About_app, "Notification_pref");
			break;
		}
	}

	// just pass name of widget u want to play with
	public void navMenu(String WidgetName) {
		for (WebElement element : Left_widgets_list) {
			if (element.getText().equalsIgnoreCase(WidgetName)) {
				click(element, WidgetName);
				break;
			}
		}
	}

	// just pass name of filter and options u want to select
	// Filter name is name of column on which u want to apply filter
	// List of dropdown options are the options u have in drop down
	public void filter_By_Selection(String FilterName, HashSet<String> options) throws InterruptedException {
		HashSet<String> result = new HashSet<String>();
		List<WebElement> filterResult = null;
		for (WebElement filCol : Filter_col) {
			if (filCol.getText().equalsIgnoreCase(FilterName)) {
				driver.findElement(
						By.xpath("//div[text()='" + FilterName + "']//parent::div//following-sibling::span/a")).click();
				Thread.sleep(4000);
				for (String option : options) {

					for (WebElement listItem : Filter_List) {
						// System.out.println("Ele "+ ele +" options "+ element2.getText());
						if (listItem.getText().equalsIgnoreCase(option)) {
							Thread.sleep(1000);
							click(listItem, "Drpdown_options");
							break;
						}
					}
				}
				btn_Apply.click();// clicking apply button
				Thread.sleep(2000);
				filterResult = driver.findElements(
						By.xpath(".//div[text()='" + FilterName + "']//ancestor::tbody//tbody//tbody/tr/td[1]//a"));
				break;
			}
		}
		for (WebElement filter_res : filterResult) {
			result.add(filter_res.getText());
		}
		if (result.equals(options))
			writeintoReport("The Filtered record(s) displayed", "Pass");
		else
			writeintoReport("The Filtered record(s) not displayed", "Fail");
	}

	public void filter_record_by_Search(String filterName, String searchText) {
		List<WebElement> filterResult = null;
		try {
			for (WebElement filCol : Filter_col) {
				if (filCol.getText().equalsIgnoreCase(filterName)) {
					driver.findElement(
							By.xpath("//div[text()='" + filterName + "']//parent::div//following-sibling::span/a"))
							.click();
					Thread.sleep(4000);
					break;
				}
			}
			enterText(inpFilter_Search, "Filter Search", searchText);
			btn_Apply.click();
			Thread.sleep(2000);
			filterResult = driver.findElements(
					By.xpath(".//div[text()='" + filterName + "']//ancestor::tbody//tbody//tbody/tr/td[1]//a"));
			int unMatchedRecCount = 0;
			for (WebElement filter_res : filterResult) {
				if (!filter_res.getText().equals(searchText))
					unMatchedRecCount++;
			}
			if (unMatchedRecCount == 0)
				writeintoReport("The Filtered record(s) displayed", "Pass");
			else
				writeintoReport("The Filtered record(s) not displayed correctly", "Fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean search_record(String FilterName, String colname, String search_text) {
		boolean bool = false;
		int count = 0;
		try {
			// this line is to get the total no of pages
			String no_of_pages = driver.findElement(By.xpath(
					" ncestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//button[@title='Next Page']//parent::nobr//parent::td//preceding-sibling::td[1]//label"))
					.getText();
			int i = Integer.parseInt(no_of_pages);
			// System.out.println("pages "+i);

			// this loop iterate thru total no of pages times
			for (int j = 1; j <= i; j++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				List<WebElement> item_searched = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//table[@id='gridLayoutTable']//tr//td[@data-attribute-name='" + colname
								+ "']//span")));
				for (int k = 0; k < item_searched.size(); k++) {

					// System.out.println(item_searched.get(k).getText());
					if (item_searched.get(k).getText().equalsIgnoreCase(search_text)) {
						bool = true;
						count = count + 1;
						// System.out.println(item_searched.get(k).getText());
					}
				}
				WebElement nxt_button1 = driver.findElement(By.xpath("//h2[contains(text(),'" + FilterName
						+ "')]//ancestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//button[@title='Next Page']"));
				click(nxt_button1, "Next Button");
				Thread.sleep(3000);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public void appianlogin(String str1, String str2) throws InterruptedException {
		enterText(appianusername, "username", str1);
		enterText(appianpassword, "password", str2);
		click(appian_Login_btn, "Login_btn");
		Thread.sleep(4000);
	}

	// just pass name of category u want to play with
	public void appiannavigationmenu(String category) throws InterruptedException {
		driver.findElement(By.xpath("(//li[@title='" + category + "'])[2]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		waitForPageToLoad(driver, null, 30);
	}

	public void appiannavigationoptions(String option) throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(text(),'" + option + "')]")).click();
		Thread.sleep(5000);
		waitForPageToLoad(driver, null, 30);
	}

	public void appiancasesearch(String filterName, String searchText) {
		List<WebElement> filterResult = null;
		try {
			for (WebElement filCol : Filter_col_appian) {
				if (filCol.getText().equalsIgnoreCase(filterName)) {
					driver.findElement(
							By.xpath("//div[text()='" + filterName + "']//parent::div//following-sibling::span/a"))
							.click();
					Thread.sleep(4000);
					break;
				}
			}
			enterText(inpFilter_Search, "Filter Search", searchText);
			btn_Apply.click();
			Thread.sleep(2000);
			filterResult = driver.findElements(
					By.xpath(".//div[text()='" + filterName + "']//ancestor::tbody//tbody//tbody/tr/td[1]//a"));
			int unMatchedRecCount = 0;
			for (WebElement filter_res : filterResult) {
				if (!filter_res.getText().equals(searchText))
					unMatchedRecCount++;
			}
			if (unMatchedRecCount == 0)
				writeintoReport("The Filtered record(s) displayed", "Pass");
			else
				writeintoReport("The Filtered record(s) not displayed correctly", "Fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectcase() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id=\"sitesBody\"]/div/div/div[2]/div[1]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]/div/p/a"))
				.click();
		// waitForPageToLoad(driver, null, 50);
		Thread.sleep(5000);

	}

	public void user_navigates_to_category(String category) throws InterruptedException {

		for (WebElement link : categoryLinks) {

			if (link.getText().equalsIgnoreCase(category)) {
				System.out.println("Category is: " + link.getText());
				click(link, "category");
				String currenturl = driver.getCurrentUrl();
				System.out.println("Current URL is:" + currenturl);
				break;
			}
		}

	}

	public void user_should_see_the_page(String category) throws InterruptedException {
		String ActualTitle = driver.getTitle();
		Thread.sleep(3000);
		String ExpectedTitle = category + "- Demo - QPR- Underwriting Workbench";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		// Home[ ]- Demo - QPR- Underw...
		// Home[]- Demo - QPR- Underw
	}

	public void user_selects_case_from_list(String caseID) {
		for (WebElement caseid : CaseIDlinks) {

			if (caseid.getText().equalsIgnoreCase(caseID)) {
				System.out.println("CaseID: " + caseid.getText());
				click(caseid, "caseID");
				break;
			}
		}
	}

	public void user_navigate_to_casemenu(String caseMenu) {
		for (WebElement casemenu : CaseMenuOptions) {
			if (casemenu.getText().equalsIgnoreCase(caseMenu)) {
				System.out.println("CaseMenu: " + casemenu.getText());
				click(casemenu, "caseMenu");
				break;
			}
		}
	}

	public void user_navigate_to_paragraphtabs(String paragraphTab) {
		for (WebElement ParagraphTab : ParagraphTabs) {
			if (ParagraphTab.getText().equalsIgnoreCase(paragraphTab)) {
				System.out.println("paragraphTab: " + ParagraphTab.getText());
				click(ParagraphTab, "paragraphTab");
				break;
			}
		}
	}

	public void user_navigate_to_programType(String programType) throws InterruptedException {
		System.out.println(" size:" + paragraphtypes.size());
		//commented driver.navigate().refresh(); by Rucha Joshi 
		//driver.navigate().refresh();
		Thread.sleep(3000);
		for (WebElement ParagraphType : paragraphtypes) {

			if (ParagraphType.getText().equalsIgnoreCase(programType)) {
				System.out.println("paragraphType2: " + ParagraphType.getText());
				scrolltoElement(ParagraphType);

				click(ParagraphType, "paragraphType");
				break;

			}

		}

	}

	public void clicksonuserbutton() throws InterruptedException {
		Thread.sleep(3000);
		click(CreateUser, "CreateUserButton");
		System.out.println("Successfully clicked on CreateUser Button");
	}

	public void ExistingAppianusers(String action) throws InterruptedException {

		switch (action) {
		case "Yes":
			Thread.sleep(2000);
			click(CheckboxYes, "Yes");
			break;
		case "No":
			Thread.sleep(2000);
			click(CheckboxNo, "No");
			break;

		}
	}

	public void CreateChart() throws InterruptedException {
		click(clickcreatechart, "CreateChart");
		click(closechart, "Close");
	}

	public void PDFDownloadExample() {

		ChromeOptions options = new ChromeOptions();
		String downloadFilePath = "C:\\Users\\prashant.todmal_bits\\Desktop\\PDFDownlaod";

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_settings.popups", 0);
		// prefs.put("download.default_directory", downloadFilePath);

		options.setExperimentalOption("prefs", prefs);

		// Create a new instance of ChromeDriver with the options
		// WebDriver driver = new ChromeDriver(options);

		try {
			// Navigate to the page with the PDF link
			// driver.get("https://example.com/path/to/pdf");

			// Locate the PDF download link and click it (update the selector as needed)
			// For example, if the link has a specific ID
			// driver.findElement(By.id("downloadButton")).click();
			click(pdfdownlaod, "pdfdownlaod"); // Wait for the file to download (optional)
			Thread.sleep(5000); // Wait for 5 seconds to ensure the download completes

		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}
	// Generic Function to sendEmail using JAVAMAil

	public static void sendEmailWithMultiAttachement() {
		// Sender's email and app password
		final String senderEmail = "bigqapune@gmail.com";
		final String senderPassword = "ybdr luvl diqr iocx";

		// Recipient's email
		String recipientEmail = "processmodeluuid0002eb38-0226-8000-1f40-7f0000014e7a@bigappmarket-dev.appiancloud.com";
		// String recipientEmail = "shweta.kakade@bitsinglass.com";

		// SMTP server settings for Gmail
		String host = "smtp.gmail.com";

		// Setup mail server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");

		// Authenticate session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		try {
			// Create email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject("Test Email with Attachment");

			// Create message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Hi,\n\nPlease find the attached file.\n\nRegards,\nJavaMail");

			// Create multipart for message and attachment
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Attachment part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			MimeBodyPart attachmentPart1 = new MimeBodyPart();
			MimeBodyPart attachmentPart2 = new MimeBodyPart();
			String userDirectory = System.getProperty("user.dir");
			String fileName1 = "QPR_Reinsurance_Bordereau_Report.pdf";
			String fileName2 = "QPR_Submission_Example_Current_year.xlsx"; // Replace with your file name
			String fileName3 = "Reinsurance_Contract_Example_Insurance.docx"; // Replace with your file name// Replace
																				// with your file name

			String filePath1 = userDirectory + File.separator + File.separator + fileName1; // Adjust "path" if your
																							// file is in a subdirectory
			String filePath2 = userDirectory + File.separator + File.separator + fileName2;
			String filePath3 = userDirectory + File.separator + File.separator + fileName3;
			// String filePath = "C:\\Users\\shweta.kakade_bitsin\\Documents\\Automation
			// Training\\AppainFeature.txt"; // Change file path
			String FilePath1 = filePath1;
			String FilePath2 = filePath2;
			String FilePath3 = filePath3;
			// DataSource source = new FileDataSource(filePath);
			DataSource source = new FileDataSource(FilePath1);
			attachmentPart.setDataHandler(new DataHandler(source));
			attachmentPart.setFileName(source.getName());

			DataSource source1 = new FileDataSource(filePath2);
			attachmentPart1.setDataHandler(new DataHandler(source1));
			attachmentPart1.setFileName(source1.getName());

			DataSource source2 = new FileDataSource(filePath3);
			attachmentPart2.setDataHandler(new DataHandler(source2));
			attachmentPart2.setFileName(source2.getName());

			multipart.addBodyPart(attachmentPart);
			multipart.addBodyPart(attachmentPart1);
			multipart.addBodyPart(attachmentPart2);
			// Set content to message
			message.setContent(multipart);

			// Send the message
			Transport.send(message);

			System.out.println("Email sent successfully with attachment!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void getFirstRowDatafromWebTable() {
		// Wait for table to load (use WebDriverWait in production)
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Locate all rows using the data-dnd-id attribute pattern
		List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@data-dnd-id, '_')]"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
				
			for (int i = 0; i < cells.size(); i++) {
				WebElement cell = cells.get(i);
				System.out.println("Cell " + i + ": " + cell.getText().trim());
			}

			System.out.println();

		}

	}

}
