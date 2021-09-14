package com.webmailhostopia.testimpl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailPreferencesPage extends AbstractPageObject{
	
	public static MailPreferencesPageHelper helper = new MailPreferencesPageHelper();

	/**
	 * This method is used to verify preferences tab labels in English language
	 * 
	 */

	
	public boolean labelsLanguageTestInPreferenceTabForNonEnglish() throws Exception{
		Thread.sleep(8000);
		int failCounter=0;
		List<String> lsStr = new ArrayList<String>();

		String[] expectedSideNavBarLabels = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_ADVANCED_ACCOUNT_SECURITY").split(",");
		String[] expectedSideNavBarLabelsOtherVal = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_ADVANCED_ACCOUNT_SECURITY1").split(",");
		
		openPreferencesTab();
		Thread.sleep(5000);
		changeTheLanguage();
		//side navigation bar text validation
		List<WebElement> ls = driver.findElements(By.xpath(elementLocatorProp.getProperty("SIDE_NAV_BAR_ELE_XPATH")));

		Log.info("Side navigation bar labels:");
		/*for(WebElement we:ls){
			String temp = we.getText().trim();
			if( !temp.isEmpty()){
				lsStr.add(temp);
			}
		}*/
		for (int i = 1; i <= ls.size(); i++) {
			String valueElement="(//*[contains(@class,'nav navbar-nav side-nav1')]/li)["+i+"]";
			WebElement elemnt=driver.findElement(By.xpath(valueElement));
			String temp = elemnt.getText().trim();
			if( !temp.isEmpty()){
				lsStr.add(temp);
			}
		}
		Thread.sleep(3000);
		String[] actualSideNavBarLabels = new String[lsStr.size()];
		actualSideNavBarLabels = lsStr.toArray(actualSideNavBarLabels);
		List<WebElement> ls1 = driver.findElements(By.xpath(elementLocatorProp.getProperty("SIDE_NAV_BAR_ELE_XPATH")));
		if (ls1.size()==otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_ADVANCED_ACCOUNT_SECURITY").length()) {
			AbstractPageObject.setOutputTestData("TestCases", 27, 2,"Y");
			if( !Verify.compareMultipleStrings(actualSideNavBarLabels, expectedSideNavBarLabels, locale)){
				failCounter++;
			}
		}
		else{
			AbstractPageObject.setOutputTestData("TestCases", 27, 2,"N");
			if( !Verify.compareMultipleStrings(actualSideNavBarLabels, expectedSideNavBarLabelsOtherVal, locale)){
				failCounter++;
			}
		}		

		/*if( (!Verify.compareMultipleStrings(actualSideNavBarLabels, expectedSideNavBarLabels, locale))||(!Verify.compareMultipleStrings(actualSideNavBarLabels, expectedSideNavBarLabelsOtherVal, locale))){
			failCounter++;
		}*/
		String expected[] = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_FORM_FULLNAME_PROFILE_PICTURE").split(",");
		if( !labelsTestInPreferenceMainActivityPage(expected)){
			failCounter++;
		}
		
		if( !helper.verifyMailViewOptionsValues()){
			failCounter++;
		}
		
		if( !helper.verifyDefaultCompositionViewOptions()){
			failCounter++;
		}
		
		if( !helper.verifyDefaultCompositionModeOptions()){
			failCounter++;
		}
		
		if( !helper.verifyReplyForwardModeOptions()){
			failCounter++;
		}
		
		if( !helper.verifyDefaultFontTypeOptions()){
			failCounter++;
		}
		
		if( !helper.verifyHeader4Labels()){
			failCounter++;
		}

		return (failCounter==0)?true:false;
	}

	public boolean labelsLanguageTestInPreferencesAdvancedTab() throws Exception{

		int failCounter=0;
		Thread.sleep(10000);
		if(!helper.verifyAdvancedHeadingText()){
			failCounter++;
		}
		/*if(!helper.verifyAdvancedFormLabels()){
			failCounter++;
		}*/
		if(!helper.verifyAdvancedMesgSettingsText()){
			failCounter++;
		}
		
		if(!helper.verifyMailfolderConfigDropDownLabels()){
			failCounter++;
		}
		
		if(!helper.verifyMailArrivesDropDownLabels()){
			failCounter++;
		}
		
		if(!helper.verifyAdvancedFormHeadingLabels()){
			failCounter++;
		}
		
		if(!helper.verifyMesgDeletedDropDownLabels()){
			failCounter++;
		}
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesAccountSecurityTab() throws Exception{

		int failCounter=0;
		Thread.sleep(10000);
		if(!helper.verifyAccountSecurityHeadingText()){
			failCounter++;
		}
		if(!helper.verifyASecurityFormHeadingLabels()){
			failCounter++;
		
		if(!helper.verifySecQuesText()){
				failCounter++;
			}
		}
		if(!helper.verifyChangePasswordText()){
			failCounter++;
		}
		if(!helper.verifyCurrentPasswordText()){
			failCounter++;
		}
		
	/*	if(!helper.verifyASecurityAnsInfo()){
			failCounter++;
		}*/
		if(!helper.verifySecQuesDropDownLabels()){
			failCounter++;
		}
		
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesAccountsTab() throws Exception{
		Thread.sleep(5000);
		int failCounter=0;
		if(!helper.verifyAccountsHeadingText()){
			failCounter++;
		}
		if(!helper.verifyAccountsInfoText()){
			failCounter++;
		}
		if(!helper.verifyAddEmailInfoText()){
			failCounter++;
		}
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesSpamTab() throws Exception{
		Thread.sleep(5000);
		int failCounter=0;
		if(!helper.verifySpamsHeadingText()){
			failCounter++;
		}
		if(!helper.verifySpamGenText()){
				failCounter++;
			}
		if(!helper.verifyTrustedPlaceHolderText()){
				failCounter++;
			}
		/*if(!helper.verifyBlacklistPlaceHolderText()){
				failCounter++;
			}*/
		if(!helper.verifySpamFilterLabels()){
				failCounter++;
			}
		if(!helper.verifyStrengthDropDownLabels()){
				failCounter++;
			}
		if(!helper.verifyOutcomeDropDownLabels()){
				failCounter++;
			}
		if(!helper.verifySpamListingLabels()){
				failCounter++;
			}
		return (failCounter==0)?true:false;
	}
	
	
	public boolean labelsLanguageTestInPreferencesAutoRulesTab() throws Exception{

		int failCounter=0;
		Thread.sleep(5000);
		if(!helper.verifyAutoReplyHeadingText()){
			failCounter++;
		}
		if(!helper.verifyAutoLabelText()){
			failCounter++;
		}
		if(!helper.verifyTitleLabelText()){
			failCounter++;
		}
		if(!helper.verifyConditionLabelText()){
			failCounter++;
		}
		if(!helper.verifyMessageLabelText()){
			failCounter++;
		}
		if(!helper.verifyMainLabels()){
			failCounter++;
		}
		if(!helper.verifyDateLabels()){
			failCounter++;
		}
		if(!helper.verifyTimeLabels()){
			failCounter++;
		}
		if(!helper.verifyConditionDropdownLabels()){
			failCounter++;
		}
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesDataUsageTab() throws Exception{
		Thread.sleep(5000);
		int failCounter=0;
		
		if(!helper.verifyDataUsageHeadingText()){
			failCounter++;
		}
		if(!helper.verifyUsageLabelText()){
			failCounter++;
		}
		if(!helper.verifyBreakdownLabelText()){
			failCounter++;
		}
		if(!helper.verifyCoreFoldersLabels()){
			failCounter++;
		}
		
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesMessageFiltersTab() throws Exception{

		int failCounter=0;
		Thread.sleep(5000);
		if(!helper.verifyFiltersHeadingText()){
			failCounter++;
		}
		if(!helper.verifyMessageInfoLabelText()){
			failCounter++;
		}
		if(!helper.verifyCreateLabelText()){
			failCounter++;
		}
		/*if(!helper.verifyDisplayFiltersLabelText()){
			failCounter++;
		}*/
		if(!helper.verifyFilterTitleLabelText()){
			failCounter++;
		}
		if(!helper.verifyCondMetLabelText()){
			failCounter++;
		}
		if(!helper.verifyPerformLabelText()){
			failCounter++;
		}
		if(!helper.verifyAddCondLabelText()){
			failCounter++;
		}
		if(!helper.verifyFilterConditionDropdownLabels()){
			failCounter++;
		}
		
		return (failCounter==0)?true:false;
	}

	public boolean labelsLanguageTestInPreferencesSignaturesTab() throws Exception{

		int failCounter=0;
		Thread.sleep(5000);
		if(!helper.verifySignaturesHeadingText()){
			failCounter++;
		}
		if(!helper.verifyCreateSignLabelText()){
			failCounter++;
		}
		if(!helper.verifySignTitleLabelText()){
			failCounter++;
		}
		if(!helper.verifyListSignsLabelText()){
			failCounter++;
		}
		if(!helper.verifyDefaultSignLabelText()){
			failCounter++;
		}
		if(!helper.verifySignCancelLabelText()){
			failCounter++;
		}
		if(!helper.verifySignAddLabelText()){
			failCounter++;
		}
		if(!helper.verifyFormLabels()){
			failCounter++;
		}
				
		return (failCounter==0)?true:false;
	}

	public boolean labelsLanguageTestInPreferenceshighlightingTab() throws Exception{

		int failCounter=0;
		Thread.sleep(5000);
		if(!helper.verifyHighlightingHeadingText()){
			failCounter++;
		}
		if(!helper.verifyHighlightInfoLabelText()){
			failCounter++;
		}
		if(!helper.verifyNewHighlightLabelText()){
			failCounter++;
		}
		/*if(!helper.verifyListHightlightsLabelText()){
			failCounter++;
		}
		if(!helper.verifyEnableHightlightsLabelText()){
			failCounter++;
		}*/
		if(!helper.verifyHighlightTitleLabelText()){
			failCounter++;
		}
		if(!helper.verifyHighlightCancelButtonText()){
			failCounter++;
		}
		if(!helper.verifyHighlightAddButtonText()){
			failCounter++;
		}
		if(!helper.verifyHighlightColorLabelText()){
			failCounter++;
		}
		if(!helper.verifyHighlightConditionContainsLabelText()){
			failCounter++;
		}
		if(!helper.verifyHighlightConditionIfLabelText()){
			failCounter++;
		}
		if(!helper.verifyIFDropdownLabels()){
			failCounter++;
		}
				
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesImageRulesTab() throws Exception{

		int failCounter=0;
		Thread.sleep(5000);
		if(!helper.verifyImageRulesHeadingText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleInfoLabelText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleSettingsLabelText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleTilteLabelText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleCancelButtonText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleAddButtonText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleCreateRuleLabelText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleListRulesLabelText()){
			failCounter++;
		}
		if(!helper.verifyImgRuleIFsLabelText()){
			failCounter++;
		}
		/*if(!helper.verifySettingsLabels()){
			failCounter++;
		}*/
		if(!helper.verifySourceLabels()){
			failCounter++;
		}
		if(!helper.verifyIFDropDownLabels()){
			failCounter++;
		}
		if(!helper.verifyIFContainsDropDownLabels()){
			failCounter++;
		}
				
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesCalendarGeneralTab() throws Exception{
		Thread.sleep(5000);
		int failCounter=0;
		
		if(!helper.verifyCalGenHeadingText()){
			failCounter++;
		}
		if(!helper.verifyWeekendLabelText()){
			failCounter++;
		}
		if(!helper.verifyWeekendInfoLabelText()){
			failCounter++;
		}
		if(!helper.verifyCustomHoursLabelText()){
			failCounter++;
		}
		if(!helper.verifyCustomHoursInfoLabelText()){
			failCounter++;
		}
		if(!helper.verifyShareCalLabelText()){
			failCounter++;
		}
		if(!helper.verifyCalLinksLabelText()){
			failCounter++;
		}
		if(!helper.verifyCalLinksDescLabelText()){
			failCounter++;
		}
		if(!helper.verifyViewLinkLabelText()){
			failCounter++;
		}
		if(!helper.verifyCALFormLabels()){
			failCounter++;
		}
		if(!helper.verifyCalViewLabels()){
			failCounter++;
		}
		
				
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsLanguageTestInPreferencesMobileGeneralTab() throws Exception{

		int failCounter=0;
		Thread.sleep(5000);
		if(!helper.verifyMobGenHeadingText()){
			failCounter++;
		}
		/*if(!helper.verifyGeneralLabelText()){
			failCounter++;
		}*/
		if(!helper.verifySynSuiteLabelText()){
			failCounter++;
		}
		if(!helper.verifySynSuiteInfoLabelText()){
			failCounter++;
		}
		if(!helper.verifyGenSynSuiteInfoLabelText()){
			failCounter++;
		}
		if(!helper.verifySynSuiteSetUpLabelText()){
			failCounter++;
		}
		if(!helper.verifyOutlookHelpLabelText()){
			failCounter++;
		}
		if(!helper.verifyPageContentLabels()){
			failCounter++;
		}
		if(!helper.verifyTableHeadLabels()){
			failCounter++;
		}
		if(!helper.verifyTableBody1Labels()){
			failCounter++;
		}
		if(!helper.verifyTableBody2Labels()){
			failCounter++;
		}
		if(!helper.verifyOutlookBodyLabels()){
			failCounter++;
		}
		if(!helper.verifyOutlookSynInfoLabels()){
			failCounter++;
		}
		
				
		return (failCounter==0)?true:false;
	}
	

	public static void openPreferencesTab()throws Exception{
		Thread.sleep(3000);
		Log.info("Opening preferences tab...");		
		WebElement preferences = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREFERENCE_BUTTON_XPATH"), 60);
		if( preferences != null){
			preferences.click();
			waitForElementToBeClickable(ByLocator.css, elementLocatorProp.getProperty("PREF_HEADER_BAR"), 30);
			Log.info("Successfully opened preferences tab!!");
		}

	}

	public void changeTheLanguage()throws Exception{
		Log.info("Selecting language to test");
		Thread.sleep(5000);
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_GENERAL_LANGUAGE"))).click();
		//WebElement selectLanguage=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_GENERAL_LANGUAGE_ENGLISH")));
		List<WebElement> selectSpecificLang=driver.findElements(By.xpath(elementLocatorProp.getProperty("SelectLang_General_PreferenceTab")));
		for (WebElement webElement : selectSpecificLang) {
			System.out.println(webElement.getText());
			if (webElement.getText().trim().equalsIgnoreCase(otherLangTestData.getProperty("LANG_SELECT"))) {
				webElement.click();
				break;
			}
		}
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("SAVE_BTN_XPATH"))).click();
		Log.info("changeTheLanguage is success");
		Thread.sleep(10000);
		refreshWebPage();
		Thread.sleep(10000);
	}


	/**
	 * @throws Exception
	 */
	public void changeTheLanguageToEnglish() throws Exception {
		Log.info("Selecting language to test");
		// driver.findElement(By.xpath("//label[@translate='LANG_PREFERENCES_GENERAL_FORM_LANGUAGE']/../div")).click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_GENERAL_LANGUAGE"))).click();
		WebElement selectLanguage=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_GENERAL_LANGUAGE_ENGLISH")));
		/*WebElement lan = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_GENERAL_LANGUAGE_ENGLISH"), 60);
		if (lan != null) {
			Log.info("English language selected successfully!!!");
			lan.click();
		} else {
			Log.error("Language drop down not visible");
		}*/
		List<WebElement> selectSpecificLang=selectLanguage.findElements(By.tagName("div"));
		for (WebElement webElement : selectSpecificLang) {
			if (webElement.getText().equalsIgnoreCase(elementLocatorProp.getProperty("LANG_SELECT"))) {
				webElement.click();
			}
		}
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("SAVE_BTN_XPATH"))).click();
		Thread.sleep(10000);
		refreshWebPage();
		Thread.sleep(10000);
	}

	/**
	 * @param expected
	 * @return
	 * @throws Exception
	 */
	public static boolean labelsTestInPreferenceMainActivityPage(String[] expected)throws Exception{
		boolean stepResult=false;
		Log.info("Verfiying labels in preferences tab...");

		List<String> lsLabelText = new ArrayList<String>();

		List<WebElement> lsLabels = driver.findElements(By.tagName("label"));
		for(WebElement label:lsLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
				System.out.println("labes are :"+label.getText().trim());
			}
		}
		List<WebElement> lsLabels1 = driver.findElements(By.tagName("legend"));
		for(WebElement label:lsLabels1){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
				System.out.println("legends are :"+label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expected,locale)){
			Log.info("labelsTestInPreferenceMainActivityPage is success");
			stepResult=true;
		}
		return stepResult;
	}

	
	/**
	 * @throws Exception 
	 * @Method :labelsLanguageTestInPrefPopImapTab
	 */
	public boolean labelsLanguageTestInPrefPopImapTab() throws Exception{
		int failCount=0;
		Thread.sleep(5000);
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying labels in Preference PopImap Tab...");
		//------POP Imap header test ------------------
		String expectedInPopImapHeader = otherLangTestData.getProperty("PREFERENCES_POP_IMAP_HEADER");		
		WebElement popImapButton = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("PREF_POP_IMAP_XPATH")));
		if (popImapButton == null)
			return false;
		popImapButton.click();
		WebElement popImapHeader=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_POP_IMAP_HEADER_XPATH")));
		String popImapHeaderText=popImapHeader.getText();
		
		if (Verify.compareSingleString(popImapHeaderText, expectedInPopImapHeader, locale)) {
			Log.info("expectedInPopImapHeader is success");
			stepResult = true;

		}
		else{
			stepResult = false;
			failCount++;
			Log.info("expectedInPopImapHeader : expected and actual mismatch");
		}
		//------POP Imap subtitle test ------------------
		String expectedInPopImapHeaderSubTitle = otherLangTestData.getProperty("PREFERENCES_POP_IMAP_SUBTITLE");
		WebElement popImapHeaderSubtle=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_POP_IMAP_SUBTITLE_XPATH")));
		String popImapHeaderSubtleText=popImapHeaderSubtle.getText();
		if (Verify.compareSingleString(popImapHeaderSubtleText, expectedInPopImapHeaderSubTitle, locale)) {
			Log.info("expectedInPopImapHeaderSubTitle is success");
			stepResult = true;

		}
		else{
			stepResult = false;
			failCount++;
			Log.info("expectedInPopImapHeaderSubTitle : expected and actual mismatch");
		}
		//------POP Imap labels test ------------------
		String[] expectedInPopImapLabels = otherLangTestData.getProperty("PREFERENCES_POP_IMAP_LABELS").split(",");
		List<WebElement> popImapPageLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("PREF_POP_IMAP_LABELS_XPATH")));
		for (WebElement label : popImapPageLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInPopImapLabels, locale)) {
			Log.info("expectedInPopImapLabels is success");
			stepResult = true;
		}	
		else{
			stepResult = false;
			failCount++;
			Log.info("expectedInPopImapLabels : expected and actual mismatch");
		}
		
		if (failCount==0) {
			Log.info("labelsLanguageTestInPrefPopImapTab is success");
			stepResult=true;
		}
		else{
			Log.info("labelsLanguageTestInPrefPopImapTab is failed");
			stepResult=false;
		}
		return stepResult;
	}


	/**
	 * @throws Exception 
	 * @Method :labelsLanguageTestInPrefPopImapTab
	 */
	public boolean labelsLanguageTestInPrefPGPKeysTab() throws Exception{
		int failCount=0;
		Thread.sleep(5000);
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying labels in Preference PopImap Tab...");
		//------POP Imap header test ------------------
		String expectedInPGPKEYSHeader = otherLangTestData.getProperty("PREFERENCES_PGP_KEYS_HEADER");		
		WebElement pgpKeysButton = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("PREF_PGP_KEYS_XPATH")));
		if (pgpKeysButton == null)
			return false;
		pgpKeysButton.click();
		//----Header validation
		WebElement pgpKeysHeader=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_PGP_KEYS_HEADER_XPATH")));
		String pgpKeysHeaderText=pgpKeysHeader.getText();
		if (Verify.compareSingleString(pgpKeysHeaderText, expectedInPGPKEYSHeader, locale)) {
			Log.info("pgpKeysHeader is success");
			stepResult = true;
		}
		else{
			stepResult = false;
			failCount++;
			Log.info("pgpKeysHeader : expected and actual mismatch");
		}
		//----subtitle validation
		String expectedInPGPKEYSSubTitle = otherLangTestData.getProperty("PREFERENCES_PGP_KEYS_SUBTITLE");		
		WebElement pgpKeysSubtitle = waitForElementVisibility(
				By.xpath(elementLocatorProp.getProperty("PREF_PGP_KEYS_SUBTITLE_HEADER_XPATH")));
		String pgpKeysSubtitleText = pgpKeysSubtitle.getText();
		if (Verify.compareSingleString(pgpKeysSubtitleText, expectedInPGPKEYSSubTitle, locale)) {
			Log.info("expectedInPGPKEYSSubTitle is success");
			stepResult = true;
		}
		else{
			stepResult = false;
			failCount++;
			Log.info("expectedInPGPKEYSSubTitle : expected and actual mismatch");
		}
		
		//------PGP Keys buttons test ------------------
		String[] expectedInPopImapButtonsText = otherLangTestData.getProperty("PREFERENCES_PGP_KEYS_BUTTONS_TEXT").split(",");
		List<WebElement> popImapPageButtons = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("PREF_PGP_KEYS_BUTTONS_XPATH")));
		for (WebElement label : popImapPageButtons) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInPopImapButtonsText, locale)) {
			Log.info("expectedInPopImapButtonsText is success");
			stepResult = true;
		}
		else{
			stepResult = false;
			failCount++;
			Log.info("expectedInPopImapButtonsText : expected and actual mismatch");
		}
		
		//------PGP Keys Table headers test ------------------
		List<String> lsLabelText1 = new ArrayList<String>();
		String[] expectedInPopImapTableHeaderText = otherLangTestData.getProperty("PREFERENCES_PGP_KEYS_TABLE_HEADER_TEXT")
				.split(",");
		List<WebElement> pgpKeysTableHeaders = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("PREF_PGP_KEYS_TABLE_TH_XPATH")));
		for (WebElement label : pgpKeysTableHeaders) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				System.out.println("table headers :"+label.getText().trim());
				lsLabelText1.add(label.getText().trim());
			}
		}
		String[] actualsValue = new String[lsLabelText1.size()];
		actuals = lsLabelText1.toArray(actualsValue);

		if (Verify.compareMultipleStrings(actualsValue, expectedInPopImapTableHeaderText, locale)) {
			Log.info("expectedInPopImapTableHeaderText is success");
			stepResult = true;
		}
		else{
			stepResult = false;
			failCount++;
			Log.info("expectedInPopImapTableHeaderText : expected and actual mismatch");
		}
		
		if (failCount==0) {
			Log.info("labelsLanguageTestInPrefPGPKeysTab is success");
			stepResult=true;
		}
		else{
			Log.info("labelsLanguageTestInPrefPGPKeysTab is failed");
			stepResult=false;
		}

		return stepResult;

	}




}