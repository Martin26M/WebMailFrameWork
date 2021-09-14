package com.webmailhostopia.tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.webmailhostopia.common.utils.ExtentManager;
import com.webmailhostopia.common.utils.ExtentTestManager;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Logs;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;
import com.webmailhostopia.testimpl.MailBriefCaseSection;
import com.webmailhostopia.testimpl.MailCalendarSection;
import com.webmailhostopia.testimpl.MailContactsPage;
import com.webmailhostopia.testimpl.MailForgotPasswordSection;
import com.webmailhostopia.testimpl.MailHomePage;
import com.webmailhostopia.testimpl.MailInboxPage;
import com.webmailhostopia.testimpl.MailLoginPage;
import com.webmailhostopia.testimpl.MailLogoutPage;
import com.webmailhostopia.testimpl.MailPreferencesPage;
import com.webmailhostopia.testimpl.MailTaskPage;


public class WebMailHostpiaRegressionTests{

	public static MailLoginPage login;
	public static MailHomePage homepage;
	public static MailInboxPage inboxPage;
	public static MailCalendarSection calpage;
	public static MailLogoutPage logoutpage;
	public static MailContactsPage contactpage;
	public static MailTaskPage taskpage;
	private ExtentReports extent;
	private ExtentTest test;
	public MailPreferencesPage prefpage;
	public MailForgotPasswordSection forgot;
	public MailBriefCaseSection briefcase;
	public ITestResult result=null;
	

	@BeforeClass
	public void setup(){
		extent = ExtentManager.getReporter();
		login = new MailLoginPage();
		homepage = new MailHomePage();
		inboxPage = new MailInboxPage();
		calpage = new MailCalendarSection();
		contactpage = new MailContactsPage();
		taskpage = new MailTaskPage();
		prefpage=new MailPreferencesPage();
		logoutpage=new MailLogoutPage();
		forgot=new MailForgotPasswordSection();
		briefcase = new MailBriefCaseSection();
	}

	
	@Test(priority=0,description="This is webmail login test with valid username and password",groups="Regression",testName = "WebMail Valid Login Test")
	public void webMailLoginTest() throws Exception {
		String testRun=AbstractPageObject.getInputTestData("TestCases", 1, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			Log.info("Inside webmail login test method");
			Logs.info("This is webmail login test with valid username and password");
			boolean expected = true;
			boolean testResult=login.loginToWebMail();
			if(testResult){
				AbstractPageObject.setOutputTestData("TestCases", 1, 3, "PASS");
				Assert.assertEquals(testResult, expected);		
			}
			else{
				AbstractPageObject.setOutputTestData("TestCases", 1, 3, "FAIL");
			}
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 1, 3, "SKIP");
			  throw new SkipException("Skipped test case :webMailLoginTest");
		} 
	}
	
	@Test(priority=1, description="This is webmail Socail Page Section Verification method", groups="Regression")
	public void verifySocialSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 2, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Assert.assertEquals(inboxPage.SocialMailSection(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 2, 3, "SKIP");
			 throw new SkipException("Skipped test case :verifySocialSectionLabels");
		} 		
	}
	
	
	@Test(priority=2, description="This is webmail BriefCase Page Section Verification method", groups="Regression")
	public void verifyBriefCaseSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 3, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside verify labels text in BriefCase section page method");
			Assert.assertEquals(briefcase.BreifCaseSectionLabels(), expected);
			
		}
		else {
			  AbstractPageObject.setOutputTestData("TestCases", 3, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyBriefCaseSectionLabels");
		} 

	}
	
	
	@Test(priority=3, description="This is webmail HomePage Section Verification method", groups="Regression")
	public void verifyMailSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 4, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside verify labels text in mail section page method");
			Assert.assertEquals(homepage.verifyLabelsLangugaeInMailHomePage(), expected);			
		}
		else {
			  AbstractPageObject.setOutputTestData("TestCases", 4, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyMailSectionLabels");
		} 
				
	}
		
	@Test(priority=4, description="This is webmail CalendarPage Section Verification method", groups="Regression")
	public void verifyCalSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 5, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(10000);
			Log.info("Inside verify labels text in Calendar section page method");
			//boolean testResult=calpage.verifyLabelsLanguageInCalendarHomePage();
			Assert.assertEquals(calpage.verifyLabelsLanguageInCalendarHomePage(), expected);
			
		}
		else {
			  AbstractPageObject.setOutputTestData("TestCases", 5, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyCalSectionLabels");
		} 
		
	}
	
	@Test(priority=5, description="This is webmail CalendarPage Section Verification method and this is depends on verifyCalSectionLabels", groups="Regression")
	public void verifyCalSectionEventCreationLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 6, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(10000);
			Log.info("Inside verify labels text in CreateEvent section page method");
			Assert.assertEquals(calpage.verifyLabelIsLanguageInCreateEventPage(), expected);
			}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 6, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyCalSectionEventCreationLabels");
		} 
	}
	
	@Test(priority=6, description="This is webmail CalendarPage Section Verification method", groups="Regression")
	public void verifyCalSectionRepeatEventCreationLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 7, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(10000);
			Log.info("Inside verify labels text in Repeat Event section page method");
			Assert.assertEquals(calpage.verifyLabelIsLanguageInRepeatEventPage(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 7, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyCalSectionRepeatEventCreationLabels");
		} 		
		
	}
	
	
	@Test(priority=7, description="This is Task Page Section Verification method", groups="Regression")
	public void verifyTaskpageSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 8, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside verify labels text in Task section page method");
			Assert.assertEquals(taskpage.verifyLabelsLanguageInTaskPage(), expected);
			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 8, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyTaskpageSectionLabels");
		} 	
		
	}
	
	@Test(priority=8, description="This is Task Page Section Verification method", groups="Regression")
	public void verifyTaskCreationpageSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 9, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside verify labels text in New Task Creation section page method");
			Assert.assertEquals(taskpage.verifyLabelsLanguageInCreateTaskPage(), expected);
			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 9, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyTaskCreationpageSectionLabels");
		} 
				
	}
	
	@Test(priority=9, description="This is Conatct Page Section Verification method", groups="Regression")
	public void verifyContactSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 10, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Log.info("Inside verify labels text in Contact section page method");
			Assert.assertEquals(contactpage.labelsTestInContactsPage(), expected);
			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 10, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyContactSectionLabels");
		}
				
	}
	
	@Test(priority=10, description="This is Create Contact Page Section Verification method", groups="Regression")
	public void verifyCreateContactSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 11, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Log.info("Inside verify labels text in Create Contact section page method");
			Assert.assertEquals(contactpage.labelsTestInCreateContactPage(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 11, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyCreateContactSectionLabels");
		}
		
	}
	
	@Test(priority=11, description="This is Create New AddressBook Page Section Verification method", groups="Regression")
	public void verifyCreateAddressBookSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 12, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Log.info("Inside verify labels text in Create AddressBook section page method");
			Assert.assertEquals(contactpage.labelsTestInAddAdressBookPage(), expected);
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 12, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyCreateAddressBookSectionLabels");
		}		
	}
	
	@Test(priority=12, description="This is Subscribe AddressBook Page Section Verification method", groups="Regression")
	public void verifySubscribeAddressBookSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 13, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Log.info("Inside verify labels text in Subscribe AddressBook section page method");
			Assert.assertEquals(contactpage.labelsTestInSubsAdressBookPage(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 13, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifySubscribeAddressBookSectionLabels");
		}
		
	}
	@Test(priority=13, description="This is New Create Group Page Section Verification method", groups="Regression")
	public void verifyNewGroupSectionLabels() throws Exception{	
		String testRun=AbstractPageObject.getInputTestData("TestCases", 14, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Log.info("Inside verify labels text in New Group section page method");
			Assert.assertEquals(contactpage.labelsTestInGroupPage(), expected);		
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 14, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyNewGroupSectionLabels");
		}	
		
	}
		
	@Test(priority=14, groups="Regression")
	public void labelsLanguageTestInPreferenceGeneralTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 15, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Log.info("Inside labelsLanguageTestInPreferenceTab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferenceTabForNonEnglish(), expected);		
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 15, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceGeneralTab");
		}
		
	}
	
	
	@Test(priority=15,  groups="Regression")
	public void labelsLanguageTestInPreferenceAdvancedTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 16, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Advanced Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesAdvancedTab(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 16, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceAdvancedTab");
		}
	
	}
	
	
	@Test(priority=16,  groups="Regression")
	public void labelsLanguageTestInPreferenceACcountSecurityTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 17, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences AccountSecurity Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesAccountSecurityTab(), expected);
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 17, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceACcountSecurityTab");
		}
		
	}
	
	@Test(priority=17,  groups="Regression")
	public void labelsLanguageTestInPreferenceAccountsTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 18, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Accounts Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesAccountsTab(), expected);
			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 18, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceAccountsTab");
		}
	
	}
	
	@Test(priority=18,  groups="Regression")
	public void labelsLanguageTestInPreferenceSpamTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 19, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Spam Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesSpamTab(), expected);
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 19, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceSpamTab");
		}
	
	}
	
	@Test(priority=19,  groups="Regression")
	public void labelsLanguageTestInPreferenceAutoRulesTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 20, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Auto Rules Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesAutoRulesTab(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 20, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceAutoRulesTab");
		}	
		
	}
	
	@Test(priority=20,  groups="Regression")
	public void labelsLanguageTestInPreferenceMessageFilterTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 21, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences MessageFilter Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesMessageFiltersTab(), expected);
			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 21, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceMessageFilterTab");
		}
		
	}
	
	@Test(priority=21,  groups="Regression")
	public void labelsLanguageTestInPreferenceSignaturesTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 22, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Signatures Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesSignaturesTab(), expected);
			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 22, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceSignaturesTab");
		}
		
	}
	
	@Test(priority=22,  groups="Regression")
	public void labelsLanguageTestInPreferenceHighlightingTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 23, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Highlighting Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferenceshighlightingTab(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 23, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceHighlightingTab");
		}
			
	}
	
	@Test(priority=23,  groups="Regression")
	public void labelsLanguageTestInPreferenceImageRulesTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 24, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Image Rules Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesImageRulesTab(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 24, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceImageRulesTab");
		}
		
	}
	
	@Test(priority=24,  groups="Regression")
	public void labelsLanguageTestInPreferenceDataUsageTab() throws Exception {		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 25, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences DataUsage Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesDataUsageTab(), expected);
			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 25, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceDataUsageTab");
		}
		
	}
	
	@Test(priority=25,  groups="Regression")
	public void labelsLanguageTestInPreferenceCalendarGeneralTab() throws Exception {	
		String testRun=AbstractPageObject.getInputTestData("TestCases", 26, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Calendar General Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesCalendarGeneralTab(), expected);	
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 26, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceCalendarGeneralTab");
		}
	
	}
	
	@Test(priority=26,  groups="Regression")
	public void labelsLanguageTestInPreferenceMobileGeneralTab() throws Exception {	
		String testRun=AbstractPageObject.getInputTestData("TestCases", 27, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Mobile General Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPreferencesMobileGeneralTab(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 27, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceMobileGeneralTab");
		}
		
	}
	
	@Test(priority=27,  groups="Regression")
	public void labelsLanguageTestInPreferencePopImapTab() throws Exception {				
		String testRun=AbstractPageObject.getInputTestData("TestCases", 28, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Mobile General Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPrefPopImapTab(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 28, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceMobileGeneralTab");
		}
		
	}
	
	@Test(priority=28,  groups="Regression")
	public void labelsLanguageTestInPreferencePGPKeysTab() throws Exception {				
		String testRun=AbstractPageObject.getInputTestData("TestCases", 29, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside labelsLanguageTestInPreferences Mobile General Tab method");
			Assert.assertEquals(prefpage.labelsLanguageTestInPrefPGPKeysTab(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 29, 3, "SKIP");
			  throw new SkipException("Skipped test case : labelsLanguageTestInPreferenceMobileGeneralTab");
		}
		
	}
	
	@Test(priority=29, description="This is Logout Section Verification method", groups="Regression")
	public void verifylougtnloginSectionLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 30, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Thread.sleep(5000);
			Log.info("Inside verify labels text in Login section page method");
			Assert.assertEquals(logoutpage.verifyLabelsLangugaeInMailLoginPage(), expected);			
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 30, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifylougtnloginSectionLabels");
		}	
		
	}
	
	@Test(priority=30, description="This is Login Section Verification method", groups="Regression")
	public void verifyLoginPageMessageLabels() throws Exception{		
		String testRun=AbstractPageObject.getInputTestData("TestCases", 31, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside verify labels text in Login section page method");
			Assert.assertEquals(login.verifyLabelsLanguageInLoginPage(), expected);		
		}
		else {
			AbstractPageObject.setOutputTestData("TestCases", 31, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyLoginPageMessageLabels");
		}		
	}
	
	@Test(priority=31, description="This is Forgot Section Verification method", groups="Regression")
	public void verifyForgotPageSectionLabels() throws Exception{
		String testRun=AbstractPageObject.getInputTestData("TestCases", 32, 2);
		if (testRun.equalsIgnoreCase("Y")) {
			boolean expected = true;
			Log.info("Inside verify labels text in Forgot section page method");
			Assert.assertEquals(forgot.verifyLabelsLangugaeInMailForgotPage(), expected);			
		}
		else {
			  AbstractPageObject.setOutputTestData("TestCases", 32, 3, "SKIP");
			  throw new SkipException("Skipped test case : verifyForgotPageSectionLabels");
		}
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException{
		Thread.sleep(5000);
		login.quit();

	}
}