package com.webmailhostopia.testimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailPreferencesPageHelper extends AbstractPageObject{

	public boolean verifyOtherLabelOptions(String xpath, String[] expectedData)throws Exception{

		List<String> viewOptions = new ArrayList<String>();
		List<WebElement> mailBoxViewOptions = driver.findElements(By.xpath(xpath));

		for(WebElement label:mailBoxViewOptions){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				viewOptions.add(label.getText().trim());
			}
		}

		String[] actuals = new String[viewOptions.size()];
		actuals = viewOptions.toArray(actuals);

		return Verify.compareMultipleStrings(actuals, expectedData, locale);

	}

	/*
	 * method to verify mail view options options in preferences tab
	 */
	public boolean verifyMailViewOptionsValues()throws Exception{

		boolean stepResult = true;
		String[] expectedMailViewOptions = null;
		Log.info("Verifying Mail View Options Label Names...");

		//xpath of mail view options dropdown
		String mailViewOptionsXpath = elementLocatorProp.getProperty("MAIL_BOX_VIEW_DROPDOWN_XPATH");
		expectedMailViewOptions = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_FORM_MAILBOXVIEWMODE_OPTIONS").split(";");
		
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_BOX_VIEW"))).click();
		if( !verifyOtherLabelOptions(mailViewOptionsXpath, expectedMailViewOptions)){
			Log.info("verifyMailViewOptionsValues not success");
			stepResult = false;
		}
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_BOX_VIEW"))).click();
		return stepResult;
	}

	/*
	 * method to verify default composition mode options options in preferences tab
	 */
	public boolean verifyDefaultCompositionModeOptions()throws Exception{

		boolean stepResult = true;
		String[] expectedDefaultCompOptions=null;

		Log.info("Verifying Default Composition Mode Options Label Names...");

		//xpath of mail view options dropdown
		String defaultCompOptionsXpath = elementLocatorProp.getProperty("DEFAULT_COMP_MODE_DROPDOWN_OPTIONS_XPATH");
		expectedDefaultCompOptions = otherLangTestData.getProperty("LANG_PREFERENCES_ADVANCED_FORM_COMPOSEMODE_OPTIONS").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DEFAULT_COMP_MODE_XPATH"))).click();
	
		if( !verifyOtherLabelOptions(defaultCompOptionsXpath, expectedDefaultCompOptions)){
			Log.info("verifyDefaultCompositionModeOptions not success");
			stepResult = false;
		}
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DEFAULT_COMP_MODE_XPATH"))).click();
		return stepResult;
	}	
	
	/*
	 * method to verify default composition mode options options in preferences tab
	 */
	public boolean verifyDefaultCompositionViewOptions()throws Exception{

		boolean stepResult = true;
		String[] expectedDefaultCompOptions=null;

		Log.info("Verifying Default Composition view Options Label Names...");

		//xpath of mail view options dropdown
		String defaultCompOptionsXpath = elementLocatorProp.getProperty("DEFAULT_COMP_VIEW_DROPDOWN_OPTIONS_XPATH");
		expectedDefaultCompOptions = otherLangTestData.getProperty("LANG_PREFERENCES_ADVANCED_FORM_COMPOSEVIEW_OPTIONS").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DEFAULT_COMP_VIEW_XPATH"))).click();
	
		if( !verifyOtherLabelOptions(defaultCompOptionsXpath, expectedDefaultCompOptions)){
			Log.info("verifyDefaultCompositionViewOptions not success");
			stepResult = false;
		}
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DEFAULT_COMP_VIEW_XPATH"))).click();
		return stepResult;
	}
	
	/*
	 * method to verify reply forward mode options in preferences tab
	 */
	
	public boolean verifyReplyForwardModeOptions()throws Exception{

		boolean stepResult = true;
		String[] expectedReplyForwardModeOptions=null;

		Log.info("Verifying Reply Forward Mode Options Label Names...");

		//xpath of default reply forward mode options dropdown
		String defaultReplyForwardModeOptionsXpath = elementLocatorProp.getProperty("REPLY_FWD_MODE_OPTIONS_XPATH");
		expectedReplyForwardModeOptions = otherLangTestData.getProperty("LANG_PREFERENCES_ADVANCED_FORM_REPLYFORWARDMODE_OPTIONS").split(",");
		driver.findElement(By.xpath(elementLocatorProp.getProperty("REPLY_FWD_MODE_XPATH"))).click();
	
		if( !verifyOtherLabelOptions(defaultReplyForwardModeOptionsXpath, expectedReplyForwardModeOptions)){
			Log.info("verifyReplyForwardModeOptions not success");
			stepResult = false;
		}
		driver.findElement(By.xpath(elementLocatorProp.getProperty("REPLY_FWD_MODE_XPATH"))).click();
		return stepResult;
	}
	
	/*
	 * method to verify default font type options options in preferences tab
	 */
	
	public boolean verifyDefaultFontTypeOptions()throws Exception{

		boolean stepResult = true;
		String[] expectedDefaultFontTypeOptions=null;

		Log.info("Verifying Default Font Type Options Label Names...");

		//xpath of mail view options dropdown
		String defaultFontTypeOptionsXpath = elementLocatorProp.getProperty("DEFUALT_FONT_TYPE_OPTIONS_XPATH");
		expectedDefaultFontTypeOptions = otherLangTestData.getProperty("DEFAULT_FONT_TYPE_OPTIONS").split(",");
		driver.findElement(By.xpath(elementLocatorProp.getProperty("DEFUALT_FONT_TYPE_XPATH"))).click();
	
		if( !verifyOtherLabelOptions(defaultFontTypeOptionsXpath, expectedDefaultFontTypeOptions)){
			Log.info("verifyDefaultFontTypeOptions not success");
			stepResult = false;
		}
		driver.findElement(By.xpath(elementLocatorProp.getProperty("DEFUALT_FONT_TYPE_XPATH"))).click();
		return stepResult;
	}
	
	/*
	 * method to verify header labels in preferences tab
	 */
	public boolean verifyHeader4Labels()throws Exception{

		boolean stepResult = true;
		String[] expectedH4HeaderLabels=null;
		String[] expectedH4HeaderLabelsOtherVal=null;

		Log.info("Verifying Header4 Label Names...");

		//xpath of mail view options dropdown
		String h4HeaderLabelsXpath = elementLocatorProp.getProperty("H4_HEADER_LABELS_XPATH");
		expectedH4HeaderLabels = otherLangTestData.getProperty("LANG_CALENDAR_MOBILE_GENERAL_HEADER_EMAILSETTINGS_DATE_AND_LANGUAGE").split(",");
		expectedH4HeaderLabelsOtherVal = otherLangTestData.getProperty("LANG_CALENDAR_MOBILE_GENERAL_HEADER_EMAILSETTINGS_DATE_AND_LANGUAGE1").split(",");
		
		List<WebElement> lsVal=driver.findElements(By.xpath(h4HeaderLabelsXpath));
		if(lsVal.size()==expectedH4HeaderLabels.length){
			if( !verifyOtherLabelOptions(h4HeaderLabelsXpath, expectedH4HeaderLabels)){
				Log.info("verifyHeader4Labels not success");
				stepResult = false;
			}
		}
		else{
			if( !verifyOtherLabelOptions(h4HeaderLabelsXpath, expectedH4HeaderLabelsOtherVal)){
				Log.info("verifyHeader4Labels not success");
				stepResult = false;
			}
		}
		return stepResult;
	}
	
	/*
	 * method to verify header labels in preferences tab
	 */
	public boolean verifyHeader3Labels()throws Exception{

		boolean stepResult = true;
		String[] expectedH3HeaderLabels=null;

		Log.info("Verifying Header3 Label Names...");

		//xpath of mail view options dropdown
		String h3HeaderLabelsXpath = elementLocatorProp.getProperty("H3_HEADER_LABELS_XPATH");
		expectedH3HeaderLabels = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL").split(",");
		
		if( !verifyOtherLabelOptions(h3HeaderLabelsXpath, expectedH3HeaderLabels)){
			stepResult = false;
		}
		return stepResult;
	}


	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAdvancedHeadingText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside Mail Prefrences Advanced Page verify Advanced Text");
		String ExpectedAdvancedText = otherLangTestData.getProperty("LANG_PREFERENCES_ADVANCED");
		WebElement Advancedbutton = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_BUTTON_XPATH"), 60);
		if (Advancedbutton == null)
			return false;
		Advancedbutton.click();
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_FOLDER_CONFIG_DROPDOWN_XPATH"), 60);
		WebElement Advance = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_HEADING_LABEL_XPATH")));
		String AdvanceText = Advance.getText();

		if (Verify.compareSingleString(AdvanceText, ExpectedAdvancedText, locale)) {
			Log.info("verifyAdvancedHeadingText IS SUCCESS");
			stepResult = true;

		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAdvancedFormLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Advanced Form labels text ...");
		String[] expectedFormLabels = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_FORM_REPLYTOADDRESS")
				.split(",");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_FOLDER_CONFIG_DROPDOWN_XPATH"), 60);
		List<WebElement> lsFormLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_FORM_LABELS_XPATH")));
		for (WebElement label : lsFormLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
				System.out.println("labels advance :"+label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		System.out.println("actual advance string :"+lsLabelText.toArray(actuals));
		if (Verify.compareMultipleStrings(actuals, expectedFormLabels, locale)) {
			Log.info("verifyAdvancedFormLabels is success");
			stepResult = true;
			Thread.sleep(2000);
		}
		return stepResult;
	}	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAdvancedMesgSettingsText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside Mail Prefrences Advanced Page verify Message Settings Text");
		String ExpectedSettingsText = otherLangTestData.getProperty("LANG_PREFERENCES_ADVANCED_MESSAGE_SETTINGS");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_FOLDER_CONFIG_DROPDOWN_XPATH"), 60);
		WebElement MsgSettings = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_MSG_SETTINGS_LABEL_XPATH")));
		String MsgSettingsText = MsgSettings.getText();

		if (Verify.compareSingleString(MsgSettingsText, ExpectedSettingsText, locale)) {
			Log.info("verifyAdvancedMesgSettingsText is success");
			stepResult = true;

		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAdvancedFormHeadingLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Advanced Form Heading labels text ...");
		String[] expectedFormHeadingLabels = otherLangTestData
				.getProperty("LANG_PREFERENCES_COLLECTED_ADDRESSES_APP_SETTINGS").split(",");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_FOLDER_CONFIG_DROPDOWN_XPATH"), 60);
		List<WebElement> lsFormLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_FORM_LABEL_HEADINGS_XPATH")));
		for (WebElement label : lsFormLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedFormHeadingLabels, locale)) {
			Log.info("verifyAdvancedFormHeadingLabels is success");
			stepResult = true;
			Thread.sleep(2000);

		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMailfolderConfigDropDownLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying Mail Folder Configuration dropdwon labels text in Advanced tab...");
		String[] expectedmailFolders = otherLangTestData
				.getProperty("LANG_PREFERENCES_ADVANCED_FORM_FOLDERCONFIG_DROPDOWN_VALUES").split(",");
		WebElement folderConfigDrpDownBtn = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_FOLDER_CONFIG_DROPDOWN_XPATH"), 60);
		if (folderConfigDrpDownBtn == null)
			return false;
		folderConfigDrpDownBtn.click();
		List<WebElement> lsMailfolderDropdownLabels = driver.findElements(
				By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_FOLDER_CONFIG_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsMailfolderDropdownLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedmailFolders, locale)) {
			Log.info("verifyMailfolderConfigDropDownLabels is success");
			stepResult = true;
			Thread.sleep(2000);

		}
		folderConfigDrpDownBtn.click();
		Thread.sleep(2000);
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMesgDeletedDropDownLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying Message Deleted dropdwon labels text in Advanced tab...");
		String[] expectedMesgDelDropDown = otherLangTestData
				.getProperty("LANG_PREFERENCES_ADVANCED_FORM_ON_DELETE_MOVE_TO_TRASH_PERMANENTLY_DELETE").split(",");
		WebElement msgDelDrpDownBtn = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_MESG_DELETED_DROPDOWN_XPATH"), 60);
		if (msgDelDrpDownBtn == null)
			return false;
		Thread.sleep(2000);
		msgDelDrpDownBtn.click();
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("PREF_ADVANCED_MESG_DELETED_DROPDOWN_VALUES_XPATH"), 60);
		List<WebElement> lsMesgDelDropdownLabels = driver.findElements(
				By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_MESG_DELETED_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsMesgDelDropdownLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedMesgDelDropDown, locale)) {
			Log.info("verifyMesgDeletedDropDownLabels is success");
			stepResult = true;
			Thread.sleep(2000);

		}
		msgDelDrpDownBtn.click();
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMailArrivesDropDownLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		List<String> lsLabelText1 = new ArrayList<String>();
		Log.info("Verfiying Mail Arrives dropdwon labels text in Advanced tab...");
		String[] expectedMailArrivesDropDown = otherLangTestData
				.getProperty("LANG_PREFERENCES_ADVANCED_SOUND_DEFAULT_FILE_UPLOAD_SOUND_FILE").split(",");
		WebElement playSound=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_PLAY_SOUND")));
		if(!playSound.isSelected()){
			playSound.click();
		}
		WebElement mailArrDrpDownBtn = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_MAIL_ARRIVES_DROPDOWN_XPATH")));
		if (mailArrDrpDownBtn == null)
			return false;
		mailArrDrpDownBtn.click();
		List<WebElement> lsMailArrDropdownLabels = driver.findElements(
				By.xpath(elementLocatorProp.getProperty("PREF_ADVANCED_MAIL_ARRIVES_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsMailArrDropdownLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				String playSoundmailArrives = label.getText().trim().replace(otherLangTestData.getProperty("PREF_FILE_UPLOAD_SOUND_FILE_NEG_VALUE"), "");
				lsLabelText.add(playSoundmailArrives);
				System.out.println("advanced values :"+playSoundmailArrives);
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		for (String value:actuals) {
			if (!value.isEmpty()) {
				lsLabelText1.add(value);
				System.out.println("advanced values :"+value);
			}
		}
		String[] actuals1 = new String[lsLabelText1.size()];
		actuals1 = lsLabelText1.toArray(actuals1);

		if (Verify.compareMultipleStrings(actuals1, expectedMailArrivesDropDown, locale)) {
			Log.info("verifyMailArrivesDropDownLabels is success");
			stepResult = true;
			Thread.sleep(2000);

		}
		mailArrDrpDownBtn.click();
		return stepResult;
	}
	
	/*
	 * ACcount Security Tab in Preferences Section
	 */

	public boolean verifyAccountSecurityHeadingText()throws Exception{
		boolean stepResult = false;
		Thread.sleep(1000);
		Log.info("Inside Prefrences Account Security Page Text");
		String ExpectedSecurityText = otherLangTestData.getProperty("LANG_PREFERENCES_ACCOUNT_SECURITY");
		WebElement ASecuritybutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_BUTTON_XPATH"),60);
		if( ASecuritybutton == null)
			return false;
		ASecuritybutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_XPATH")));
		WebElement Security=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_LABEL_TEXT_XPATH")));
		String SecurityText = Security.getText();
		
		if(Verify.compareSingleString(SecurityText, ExpectedSecurityText, locale)){
				
				stepResult=true;
			
		}
		return stepResult;
	}

	public boolean verifyASecurityFormHeadingLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Account Security Heading labels text ...");
		String[] expectedSecurityHeadingLabels = otherLangTestData.getProperty("LANG_PREFERENCES_PASSWORD_FORM_LABELS").split(",");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_XPATH"), 60);
		List<WebElement> lsFormLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_FORM_LABELS_XPATH")));
		for(WebElement label:lsFormLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedSecurityHeadingLabels, locale)){
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	public boolean verifyChangePasswordText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Advanced Page verify Change Password Text");
		String ExpectedChngePwdText = otherLangTestData.getProperty("LANG_PREFERENCES_PASSWORD");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_XPATH"),60);
		WebElement ChngPwd=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_CHANGE_PSWD_TEXT_XPATH")));
		String ChngPwdText = ChngPwd.getText();
		
		if(Verify.compareSingleString(ChngPwdText, ExpectedChngePwdText, locale)){
				
				stepResult=true;
			
		}
		return stepResult;
	}

	public boolean verifyCurrentPasswordText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Advanced Page verify Current Password Text");
		String ExpectedCurrentText = otherLangTestData.getProperty("LANG_PREFERENCES_PASSWORD_FORM_CURRENTPASSWORD");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_XPATH"),60);
		WebElement CurrentPwd=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_CURRENT_PSWD_TEXT_XPATH")));
		String CurrentPwdText = CurrentPwd.getText();
		
		if(Verify.compareSingleString(CurrentPwdText, ExpectedCurrentText, locale)){
				stepResult=true;
			
		}
		return stepResult;
	}

	public boolean verifySecQuesText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Advanced Page verify Security Question Text");
		String ExpectedSecQuesText = otherLangTestData.getProperty("LANG_PREFERENCES_PASSWORD_HEADER_SECURITYQUESTION");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_XPATH"),60);
		WebElement SecQues=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_TEXT_XPATH")));
		String SecQuesText = SecQues.getText();
		
		if(Verify.compareSingleString(SecQuesText, ExpectedSecQuesText, locale)){
				
				stepResult=true;
			
		}
		return stepResult;
	}

	public boolean verifyASecurityAnsInfo()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Account Security Ansewrs Length Information text ...");
		String[] expectedSecAnsInfo = otherLangTestData.getProperty("LANG_PREFERENCES_PASSWORD_PASSWORD_RULES_SEC_QUESTION_ANSWER_LENGTH").split(";");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_XPATH"), 60);
		List<WebElement> lsFormLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_ANSWERS_LENGTH_VALUES_XPATH")));
		for(WebElement label:lsFormLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedSecAnsInfo, locale)){
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	public boolean verifySecQuesDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Thread.sleep(2000);
		Log.info("Verfiying Security Question dropdwon labels text in ACcount Security tab...");
		String[] expectedSecQuesDropDown = otherLangTestData.getProperty("LANG_PREFERENCES_PASSWORD_FORM_SECURITY_QUES_DROPDOWN_VALUES_TEXT").split(",");
		WebElement SecQuesDrpDownBtn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_XPATH"), 60);
		if(SecQuesDrpDownBtn == null)
			return false;
		SecQuesDrpDownBtn.click();
		//waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_VALUES_XPATH"), 60);
		List<WebElement> lsSecQuesDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTSECURITY_SECURITY_QUES_DROPDOWN_VALUES_XPATH")));
		System.out.println("size is :"+lsSecQuesDropdownLabels.size());
		for (int i = 1; i <=lsSecQuesDropdownLabels.size(); i++) {
			String dropDwnValue="(//div[@class='dropdown-options']/div/ng-transclude/span)["+i+"]";
			WebElement value=driver.findElement(By.xpath(dropDwnValue));
			String valueText=value.getText().trim();
			if (!valueText.isEmpty()) {
				lsLabelText.add(value.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedSecQuesDropDown, locale)){
			stepResult=true;
			Thread.sleep(2000);
			
		}
		SecQuesDrpDownBtn.click();
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAccountsHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Accounts Page verify Accounts Text");
		String ExpectedccountsText = otherLangTestData.getProperty("LANG_PREFERENCES_ACCOUNTS");
		WebElement Accountsbutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_ACCOUNTS_BUTTON_XPATH"),60);
		if( Accountsbutton == null)
			return false;
		Accountsbutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTS_YAHOO_RADIO_BUTTON_XPATH")));
		WebElement Accounts=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTS_HEADING_XPATH")));
		String AccountsText = Accounts.getText();
		
		if(Verify.compareSingleString(AccountsText, ExpectedccountsText, locale)){
				Log.info("verifyAccountsHeadingText is success");
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAccountsInfoText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside Mail Prefrences Accounts Page verify Accounts Information Text");
		String ExpectedAccountsInfoText = otherLangTestData.getProperty("LANG_PREFERENCES_ACCOUNTS_TEXT");
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("PREF_ACCOUNTS_YAHOO_RADIO_BUTTON_XPATH")));
		WebElement AccountsInfo = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTS_TEXT_XPATH")));
		String AccountsInfoText = AccountsInfo.getText();

		if (Verify.compareSingleString(AccountsInfoText, ExpectedAccountsInfoText, locale)) {
			Log.info("verifyAccountsInfoText is success");
			stepResult = true;
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAddEmailInfoText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside Mail Prefrences Accounts Page verify Add Email Text");
		String ExpectedAddEmailText = otherLangTestData
				.getProperty("LANG_PREFERENCES_ACCOUNTS_ADD_EMAIL_ANOTHER_PLATFORM");
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("PREF_ACCOUNTS_YAHOO_RADIO_BUTTON_XPATH")));
		WebElement AddEmail = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("PREF_ACCOUNTS_ADDEMAIL_XPATH")));
		String AddEmailText = AddEmail.getText();

		if (Verify.compareSingleString(AddEmailText, ExpectedAddEmailText, locale)) {
			Log.info("verifyAddEmailInfoText is success");
			stepResult = true;
		}
		return stepResult;
	}
	
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySpamsHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Spam Page verify Spam Text");
		String ExpectedspamText = otherLangTestData.getProperty("LANG_PREFERENCES_SPAM");
		WebElement Spambutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_SPAM_BUTTON_XPATH"),60);
		if( Spambutton == null)
			return false;
		Spambutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_HEADING_XPATH")));
		WebElement Spam=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_HEADING_XPATH")));
		String SpamText = Spam.getText();
		
		if(Verify.compareSingleString(SpamText, ExpectedspamText, locale)){
				Log.info("verifySpamsHeadingText is success");
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySpamGenText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Spam Page verify General Text");
		String ExpectedSpamGenText = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL1");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_HEADING_XPATH")));
		WebElement SpamGen=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_GENERAL_HEADING_XPATH")));
		String SpamGenText = SpamGen.getText();
		
		if(Verify.compareSingleString(SpamGenText, ExpectedSpamGenText, locale)){
				Log.info("verifySpamGenText is success");
				stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTrustedPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Trusted placeholder text method");
		String trustedText = otherLangTestData.getProperty("LANG_PREFERENCES_SPAM_DOMAIN_OR_ADDRESS");
		WebElement trustedPlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_LISTING_TRUSTED_PLACEHOLDER_XPATH")));
		if( trustedPlaceHolder == null)
			return false;
		String trustedPlaceHolderText = trustedPlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(trustedPlaceHolderText, trustedText, locale)){
				Log.info("verifyTrustedPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBlacklistPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Blacklist placeholder text method");
		String blacklistText = otherLangTestData.getProperty("LANG_PREFERENCES_SPAM_DOMAIN_OR_ADDRESS");
		WebElement blackPlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_SPAM_LISTING_BLACKLIST_PALCEHOLDER_XPATH"),60);
		if( blackPlaceHolder == null)
			return false;
		String blackPlaceHolderText = blackPlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(blackPlaceHolderText, blacklistText, locale)){
				Log.info("verifyBlacklistPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySpamFilterLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Spam Filters Labels text ...");
		String[] expectedspamfiltlabels = otherLangTestData.getProperty("LANG_PREFERENCES_SPAM_ENABLE_FILTER_FILTER_STRENGTH_FILTER_OUTCOME").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_HEADING_XPATH")));
		List<WebElement> lsFormLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_FORM_LABELS_XPATH")));
		for(WebElement label:lsFormLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedspamfiltlabels, locale)){
			Log.info("verifySpamFilterLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyStrengthDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Thread.sleep(3000);
		if (!waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("spam_checkbox_enable"))).isSelected()) {
			waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("spam_checkbox_enable"))).click();
		}
		Log.info("Verfiying Spam Strength dropdwon labels text in Spam tab...");
		String[] expectedStrengthDropDown = otherLangTestData.getProperty("LANG_PREFERENCES_SPAM_SENSITIVITY_LIGHT_STANDARD_AGGRESSIVE").split(",");
		WebElement StrengthDrpDownBtn = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_FILTER_DROPDOWN_XPATH")));
		if(StrengthDrpDownBtn == null)
			return false;
		StrengthDrpDownBtn.click();
		List<WebElement> lsStrengthDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_FILTER_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsStrengthDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				System.out.println("strength label :"+label.getText().trim());
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedStrengthDropDown, locale)){
			Log.info("verifyStrengthDropDownLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		StrengthDrpDownBtn.click();
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyOutcomeDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Spam Outcome dropdwon labels text in Spam tab...");
		String[] expectedOutcomeDropDown = otherLangTestData.getProperty("LANG_PREFERENCES_SPAM_DELIVERYMODE_DELETE_DELIVER_QUARANTINE").split(",");
		WebElement OutcomeDrpDownBtn = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_OUTCOME_DROPDOWN_XPATH")));
		if(OutcomeDrpDownBtn == null)
			return false;
		OutcomeDrpDownBtn.click();
		List<WebElement> lsOutcomeDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_OUTCOME_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsOutcomeDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				System.out.println("outcome label :"+label.getText().trim());
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedOutcomeDropDown, locale)){
			Log.info("verifyOutcomeDropDownLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		OutcomeDrpDownBtn.click();
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySpamListingLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Spam Listing Labels text ...");
		String[] expectedspamlistlabels = otherLangTestData.getProperty("LANG_PREFERENCES_SPAM_ALLOWLIST_BLOCKLIST").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_FILTER_DROPDOWN_XPATH")));
		WebElement replaceValue=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_INDEX_FILTER")));
		List<WebElement> lsListLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_SPAM_LISTING_LABELS_XPATH")));
		for(WebElement label:lsListLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				String messageFilterLabel = label.getText().trim().replace(replaceValue.getText().trim(), "");
				lsLabelText.add(messageFilterLabel);
			}
		}
		
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedspamlistlabels, locale)){
			Log.info("verifySpamListingLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/*
	 * Auto Reply Tab in Preferences Section
	 */

	public boolean verifyAutoReplyHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Auto Reply Page verify Auto Reply Text");
		String ExpectedAutoText = otherLangTestData.getProperty("LANG_PREFERENCES_AUTOREPLY_MESSAGES");
		WebElement Autobutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_AUTO_REPLY_XPATH"),60);
		if( Autobutton == null)
			return false;
		Autobutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		Thread.sleep(5000);
		WebElement Auto=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		String AutoText = Auto.getText();
		
		if(Verify.compareSingleString(AutoText, ExpectedAutoText, locale)){
			Log.info("verifyAutoReplyHeadingText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAutoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Data Usgae Page verify BreakDown Label Text");
		String ExpectedAutoLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_AUTOREPLY_MESSAGES_TXT");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		WebElement AutoLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_TEXT_XPATH")));
		String AutoLabelText = AutoLabel.getText();
		
		if(Verify.compareSingleString(AutoLabelText, ExpectedAutoLabelText, locale)){
			Log.info("verifyAutoLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTitleLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Data Usgae Page verify BreakDown Label Text");
		String ExpectedTitleLabelText = otherLangTestData.getProperty("LANG_TITLE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		WebElement TitleLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_TITLE_XPATH")));
		String TitleLabelText = TitleLabel.getText();
		
		if(Verify.compareSingleString(TitleLabelText, ExpectedTitleLabelText, locale)){
			Log.info("verifyTitleLabelText is success");
				stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyConditionLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Auto Reply Page verify Condition Label Text");
		String ExpectedConditionLabelText = otherLangTestData.getProperty("LANG_CONDITION");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		WebElement ConditionLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_CONDITION_XPATH")));
		String ConditionLabelText = ConditionLabel.getText();
		
		if(Verify.compareSingleString(ConditionLabelText, ExpectedConditionLabelText, locale)){
			Log.info("verifyConditionLabelText is success");
				stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMessageLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Auto Reply Page verify Message Label Text");
		String ExpectedMessageLabelText = otherLangTestData.getProperty("LANG_MESSAGE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		WebElement MessageLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_MESSAGE_XPATH")));
		String MessageLabelText = MessageLabel.getText();
		
		if(Verify.compareSingleString(MessageLabelText, ExpectedMessageLabelText, locale)){
			Log.info("verifyMessageLabelText is success");
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMainLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Main Labels text ...");
		String[] expectedMainlabels = otherLangTestData.getProperty("LANG_PREFERENCES_AUTOREPLY_CREATE_RULES_LIST").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		List<WebElement> lsMainLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADING_LABELS_XPATH")));
		for(WebElement label:lsMainLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedMainlabels, locale)){
			Log.info("verifyMainLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDateLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Date Labels text ...");
		String[] expectedDatelabels = otherLangTestData.getProperty("LANG_PREFERENCES_AUTOREPLY_START_DATE_END_DATE").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		List<WebElement> lsDateLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_DATE_LABELS_XPATH")));
		for(WebElement label:lsDateLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedDatelabels, locale)){
			Log.info("verifyDateLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTimeLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Time Labels text ...");
		String[] expectedTimelabels = otherLangTestData.getProperty("LANG_PREFERENCES_AUTOREPLY_START_TIME_END_TIME").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_HEADERTEXT")));
		List<WebElement> lsTimeLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_TIME_LABELS_XPATH")));
		for(WebElement label:lsTimeLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedTimelabels, locale)){
			Log.info("verifyTimeLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyConditionDropdownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Condition Dropdown Labels text ...");
		String[] expectedConditionDropdownlabels = otherLangTestData.getProperty("LANG_PREFERENCES_AUTOREPLY_ALL_CONDITIONS_DROPDDOWN_VALUES").split(",");
		WebElement Cond = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_AUTO_RULES_CONDITION_DROPDOWN_XPATH"),60);
		Cond.click();
		List<WebElement> lscondLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_AUTO_RULES_CONDITION_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lscondLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedConditionDropdownlabels, locale)){
			Log.info("verifyConditionDropdownLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 * @Desc : Message Filters Tab in Preferences Section
	 */
	public boolean verifyFiltersHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Message Filters Page verify Auto Reply Text");
		String ExpectedFilterText = otherLangTestData.getProperty("LANG_PREFERENCES_MESSAGE_FILTERS");
		WebElement MesgFilterbutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_MESG_FLTR_XPATH"),60);
		if( MesgFilterbutton == null)
			return false;
		MesgFilterbutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		Thread.sleep(2000);
		WebElement Filter=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		String FilterText = Filter.getText();
		
		if(Verify.compareSingleString(FilterText, ExpectedFilterText, locale)){
			Log.info("verifyFiltersHeadingText is success");
			stepResult=true;			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMessageInfoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Auto Reply Page verify Message Label Text");
		String ExpectedMessageLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MESSAGE_FILTERS_TXT");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		WebElement MessageLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_FLTR_HEAD_XPATH")));
		String MessageLabelText = MessageLabel.getText();
		
		if(Verify.compareSingleString(MessageLabelText, ExpectedMessageLabelText, locale)){
			Log.info("verifyMessageInfoLabelText is success");
			stepResult=true;		
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCreateLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Auto Reply Page verify Create Label Text");
		String ExpectedCreateLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MESSAGE_FILTERS_CREATE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		WebElement CreateLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_CREATE_LABEL_XPATH")));
		String CreateLabelText = CreateLabel.getText();
		
		if(Verify.compareSingleString(CreateLabelText, ExpectedCreateLabelText, locale)){
			Log.info("verifyCreateLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDisplayFiltersLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Auto Reply Page verify DisplayFilters Label Text");
		String ExpectedDisplayFiltersLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MESSAGE_FILTERS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		WebElement DisplayFiltersLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_ADDED_LABEL_XPATH")));
		String DisplayFiltersLabelText = DisplayFiltersLabel.getText(); 
		String messageFilterLabel = DisplayFiltersLabelText.replace(otherLangTestData.getProperty("PREF_MESSAGE_HIDE_DATA_FILTER"), "");
		System.out.println("filter value is : "+messageFilterLabel);
		
		if(Verify.compareSingleString(messageFilterLabel, ExpectedDisplayFiltersLabelText, locale)){
			Log.info("verifyDisplayFiltersLabelText  is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFilterTitleLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Auto Reply Page verify Title Label Text");
		String ExpectedTitleLabelText = otherLangTestData.getProperty("LANG_TITLE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		WebElement TitleLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_TITLE_XPATH")));
		String TitleLabelText = TitleLabel.getText();
		
		if(Verify.compareSingleString(TitleLabelText, ExpectedTitleLabelText, locale)){
			 Log.info("verifyFilterTitleLabelText is success");
				stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCondMetLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Message Filters Page verify CondMet Label Text");
		String ExpectedCondMetLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MESSAGE_FILTERS_COND_MET");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		WebElement CondMetLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_CONDITION_MET_TEXT_XPATH")));
		String CondMetLabelText = CondMetLabel.getText();
		
		if(Verify.compareSingleString(CondMetLabelText, ExpectedCondMetLabelText, locale)){
			Log.info("verifyCondMetLabelText is success");
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPerformLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Message Filters Page verify Perform Label Text");
		String ExpectedPerformLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MESSAGE_FILTERS_PERFORM_ACTION");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		WebElement PerformLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_ACTION_TEXT_XPATH")));
		String PerformLabelText = PerformLabel.getText();
		
		if(Verify.compareSingleString(PerformLabelText, ExpectedPerformLabelText, locale)){
			Log.info("verifyPerformLabelText is success");
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAddCondLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Message Filters Page verify AddCond Label Text");
		String ExpectedAddCondLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MESSAGE_FILTERS_ADD_CONDITION");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		WebElement AddCondLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_ADD_CONDITION_XPATH")));
		String AddCondLabelText = AddCondLabel.getText();
		
		if(Verify.compareSingleString(AddCondLabelText, ExpectedAddCondLabelText, locale)){
			Log.info("verifyAddCondLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFilterConditionDropdownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Condition Dropdown Labels text ...");
		String[] expectedFConditionDropdownlabels = otherLangTestData.getProperty("LANG_CONTAINS_DOESNT_BEGIN_WITH_EQUAL_TO_NOT_EQUAL_TO_BEGINS_WITH_DOESNT_BEGIN_WITH_ENDS_WITH_DOESNT_END_WITH").split(",");
		WebElement Cond = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_MESG_FLTR_CONTAINS_DROPDOWN_XPATH"),60);
		Cond.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MSG_FILTER_HEADERTEXT")));
		List<WebElement> lsFCondLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_MESG_FLTR_CONTAINS_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsFCondLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedFConditionDropdownlabels, locale)){
			Log.info("verifyFilterConditionDropdownLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		Cond.click();
		Thread.sleep(2000);
		return stepResult;
	}
	
	
	
	/**
	 * @return
	 * @throws Exception
	 * @Desc : Signatures Tab in Preferences Section
	 */
	public boolean verifySignaturesHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Signatures Page verify Signature Text");
		String ExpectedSignText = otherLangTestData.getProperty("LANG_PREFERENCES_SIGNATURES");
		WebElement Signaturesbutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_SIGN_BUTTON_XPATH"),60);
		if( Signaturesbutton == null)
			return false;
		Signaturesbutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		Thread.sleep(2000);
		WebElement Sign=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		String SignText = Sign.getText();
		
		if(Verify.compareSingleString(SignText, ExpectedSignText, locale)){
			Log.info("verifySignaturesHeadingText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCreateSignLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Signatures Page verify Create Signature Label Text");
		String ExpectedCreateSignLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_FORM_CREATE_SIGNATURE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		WebElement CreateSignLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_NEW_SIGN_LABEL_XPATH")));
		String CreateSignLabelText = CreateSignLabel.getText();
		
		if(Verify.compareSingleString(CreateSignLabelText, ExpectedCreateSignLabelText, locale)){
			Log.info("verifyCreateSignLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySignTitleLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Signatures Page verify Create Signature Label Text");
		String ExpectedSignTitleLabelText = otherLangTestData.getProperty("LANG_TITLE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		WebElement SignTitleLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_TITLE_XPATH")));
		String SignTitleLabelText = SignTitleLabel.getText();
		
		if(Verify.compareSingleString(SignTitleLabelText, ExpectedSignTitleLabelText, locale)){
			Log.info("verifySignTitleLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyListSignsLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Signatures Page verify List of Signatures Label Text");
		String ExpectedListSignsLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_FORM_SIGNATURE_LIST");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		WebElement ListSignsLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_LIST_OF_SIGNS_LABEL_XPATH")));
		String ListSignsLabelText = ListSignsLabel.getText();
		
		if(Verify.compareSingleString(ListSignsLabelText, ExpectedListSignsLabelText, locale)){
			Log.info("verifyListSignsLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDefaultSignLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Signatures Page verify Default Label Text");
		String ExpectedDefaultSignLabelText = otherLangTestData.getProperty("LANG_DEFAULT");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		WebElement DefaultSignLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_DEFAULT_LABEL_XPATH")));
		String DefaultSignLabelText = DefaultSignLabel.getText();
		
		if(Verify.compareSingleString(DefaultSignLabelText, ExpectedDefaultSignLabelText, locale)){
			Log.info("verifyDefaultSignLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	public boolean verifySignCancelLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Signatures Page verify Default Label Text");
		String ExpectedSignCancelLabelText = otherLangTestData.getProperty("LANG_CANCEL");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		WebElement SignCancelLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_CANCEL_XPATH")));
		String SignCancelLabelText = SignCancelLabel.getText();
		
		if(Verify.compareSingleString(SignCancelLabelText, ExpectedSignCancelLabelText, locale)){
				
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySignAddLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Signatures Page verify Add Button Text");
		String ExpectedSignAddLabelText = otherLangTestData.getProperty("LANG_ADD");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		WebElement SignAddLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREFERENCES_SIGN_ADD_XPATH")));
		String SignAddLabelText = SignAddLabel.getText();
		
		if(Verify.compareSingleString(SignAddLabelText, ExpectedSignAddLabelText, locale)){
			Log.info("verifySignAddLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFormLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Signature Form Labels text ...");
		String[] expectedFormlabels = otherLangTestData.getProperty("LANG_PREFERENCES_GENERAL_FORM_SIGNATUREDASH_SIGNATUREBEFORE").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_XPATH")));
		List<WebElement> lsFormLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_SIGN_FORM_LABELS_XPATH")));
		for(WebElement label:lsFormLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedFormlabels, locale)){
			Log.info("verifyFormLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	
	
	/**
	 * @return
	 * @throws Exception
	 * @Desc : Highlighting Tab in Preferences Section
	 */
	public boolean verifyHighlightingHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Highlighting Page verify Signature Text");
		String ExpectedHighlightingText = otherLangTestData.getProperty("LANG_PREFERENCES_HIGHLIGHTING");
		WebElement Highlightingbutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_HIGHLIGHT_BUTTON_XPATH"),60);
		if( Highlightingbutton == null)
			return false;
		Highlightingbutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		Thread.sleep(2000);
		WebElement Highlighting=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		String HighlightingText = Highlighting.getText();
		
		if(Verify.compareSingleString(HighlightingText, ExpectedHighlightingText, locale)){
			Log.info("verifyHighlightingHeadingText is success");
			stepResult=true;
			
		}
		return stepResult;
	}	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHighlightInfoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify Highlight Info Text");
		String ExpectedHighlightInfoLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_HIGHLIGHTING_TXT");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement HighlightInfoLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_TEXT_XPATH")));
		String HighlightInfoLabelText = HighlightInfoLabel.getText();
		
		if(Verify.compareSingleString(HighlightInfoLabelText, ExpectedHighlightInfoLabelText, locale)){
			Log.info("verifyHighlightInfoLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewHighlightLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify New Highlight Label Text");
		String ExpectedNewHighlightLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_HIGHLIGHTING_CREATE_FILTER");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement NewHighlightLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_NEW_HIGHLIT_XPATH")));
		String NewHighlightLabelText = NewHighlightLabel.getText();
		
		if(Verify.compareSingleString(NewHighlightLabelText, ExpectedNewHighlightLabelText, locale)){
			Log.info("verifyNewHighlightLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyListHightlightsLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify List of Highlights Label Text");
		String ExpectedListHightlightsLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_HIGHLIGHTING_RULES_LIST");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement ListHightlightsLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_LIST_OF_RULES_XPATH")));
		String ListHightlightsLabelText = ListHightlightsLabel.getText();
		if (ListHightlightsLabelText.contains(otherLangTestData.getProperty("LANG_ENABLE"))) {
			ListHightlightsLabelText=ListHightlightsLabelText.replace(otherLangTestData.getProperty("LANG_ENABLE"), "");
		}
		System.out.println("ListHightlightsLabelText is :"+ListHightlightsLabelText);		
		if(Verify.compareSingleString(ListHightlightsLabelText, ExpectedListHightlightsLabelText, locale)){
			Log.info("verifyListHightlightsLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEnableHightlightsLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify Enable Highlights Label Text");
		String ExpectedEnableHightlightsLabelText = otherLangTestData.getProperty("LANG_ENABLE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement EnableHightlightsLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_ENABLE_TEXT_XPATH")));
		String EnableHightlightsLabelText = EnableHightlightsLabel.getText();
		
		if(Verify.compareSingleString(EnableHightlightsLabelText, ExpectedEnableHightlightsLabelText, locale)){
			Log.info("verifyEnableHightlightsLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	public boolean verifyHighlightTitleLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify New Create Highlight Title Label Text");
		String ExpectedHighlightTitleLabelText = otherLangTestData.getProperty("LANG_TITLE");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_HIGHLIGHT_CANCEL_XPATH"),60);
		WebElement HighlightTitleLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_TITLE_XPATH")));
		String HighlightTitleLabelText = HighlightTitleLabel.getText();
		
		if(Verify.compareSingleString(HighlightTitleLabelText, ExpectedHighlightTitleLabelText, locale)){
				
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHighlightCancelButtonText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify Cancel Button Label Text");
		String ExpectedHighlightCancelLabelText = otherLangTestData.getProperty("LANG_CANCEL");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement HighlightCancelLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_CANCEL_XPATH")));
		String HighlightCancelLabelText = HighlightCancelLabel.getText();
		
		if(Verify.compareSingleString(HighlightCancelLabelText, ExpectedHighlightCancelLabelText, locale)){
			Log.info("verifyHighlightCancelButtonText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHighlightAddButtonText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify Add Button Label Text");
		String ExpectedHighlightAddLabelText = otherLangTestData.getProperty("LANG_ADD");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement HighlightAddLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_ADD_XPATH")));
		String HighlightAddLabelText = HighlightAddLabel.getText();
		
		if(Verify.compareSingleString(HighlightAddLabelText, ExpectedHighlightAddLabelText, locale)){
			Log.info("verifyHighlightAddButtonText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHighlightColorLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify Color Label Text");
		String ExpectedHighlightAddLabelText = otherLangTestData.getProperty("LANG_COLOUR");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement HighlightAddLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_COLOR_XPATH")));
		String HighlightAddLabelText = HighlightAddLabel.getText();
		
		if(Verify.compareSingleString(HighlightAddLabelText, ExpectedHighlightAddLabelText, locale)){
			Log.info("verifyHighlightColorLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHighlightConditionContainsLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify Contains Label Text");
		String ExpectedHighlightContainsLabelText = otherLangTestData.getProperty("LANG_CONTAINS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement HighlightContainsLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_CONTAINS_XPATH")));
		String HighlightContainsLabelText = HighlightContainsLabel.getText();
		
		if(Verify.compareSingleString(HighlightContainsLabelText, ExpectedHighlightContainsLabelText, locale)){
			Log.info("verifyHighlightConditionContainsLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHighlightConditionIfLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Highlighting Page verify If Label Text");
		String ExpectedHighlightIfLabelText = otherLangTestData.getProperty("LANG_IF");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		WebElement HighlightIfLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_IF_XPATH")));
		String HighlightIfLabelText = HighlightIfLabel.getText();
		
		if(Verify.compareSingleString(HighlightIfLabelText, ExpectedHighlightIfLabelText, locale)){
			Log.info("verifyHighlightConditionIfLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIFDropdownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Highlighting Page verify IF DropdownLabels text ...");
		String[] expectedFormlabels = otherLangTestData.getProperty("LANG_TO_SUBJECT_FROM").split(",");
		WebElement IfDropDown = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_HIGHLIGHT_IF_DROPDOWN_XPATH"),60);
		IfDropDown.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_HEADING_XPATH")));
		List<WebElement> lsFormLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_HIGHLIGHT_IF_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsFormLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedFormlabels, locale)){
			Log.info("verifyIFDropdownLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		IfDropDown.click();
		Thread.sleep(2000);
		return stepResult;
	}	
	
	/**
	 * @return
	 * @throws Exception
	 * @Desc : Image Rules Tab in Preferences Section
	 */
	public boolean verifyImageRulesHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Image Rules Page verify Image Rules Text");
		String ExpectedImgRuleText = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_RULES");
		WebElement ImgRulebutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_IMAGE_RULE_BUTTON_XPATH"),60);
		if( ImgRulebutton == null)
			return false;
		ImgRulebutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		Thread.sleep(2000);
		WebElement ImgRule=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		String ImgRuleText = ImgRule.getText();
		
		if(Verify.compareSingleString(ImgRuleText, ExpectedImgRuleText, locale)){
			Log.info("verifyImageRulesHeadingText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleInfoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify Rule Info Label Text");
		String ExpectedImgRuleInfoLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_RULES_TXT");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleInfoLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_TEXT_XPATH")));
		String ImgRuleInfoLabelText = ImgRuleInfoLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleInfoLabelText, ExpectedImgRuleInfoLabelText, locale)){
			Log.info("verifyImgRuleInfoLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleSettingsLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify Settings Label Text");
		String ExpectedImgRuleSettingsLabelText = otherLangTestData.getProperty("LANG_SETTINGS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleSettingsLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_SETTINGS_LABEL_XPATH")));
		String ImgRuleSettingsLabelText = ImgRuleSettingsLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleSettingsLabelText, ExpectedImgRuleSettingsLabelText, locale)){
			Log.info("verifyImgRuleSettingsLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleTilteLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify Tilte Label Text");
		String ExpectedImgRuleTilteLabelText = otherLangTestData.getProperty("LANG_TITLE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleTilteLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_TITLE_XPATH")));
		String ImgRuleTilteLabelText = ImgRuleTilteLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleTilteLabelText, ExpectedImgRuleTilteLabelText, locale)){
			Log.info("verifyImgRuleTilteLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleCancelButtonText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify Cancel Label Text");
		String ExpectedImgRuleCancelLabelText = otherLangTestData.getProperty("LANG_CANCEL");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleCancelLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_CANCEL_XPATH")));
		String ImgRuleCancelLabelText = ImgRuleCancelLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleCancelLabelText, ExpectedImgRuleCancelLabelText, locale)){
			Log.info("verifyImgRuleCancelButtonText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleAddButtonText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify Add Label Text");
		String ExpectedImgRuleAddLabelText = otherLangTestData.getProperty("LANG_ADD");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleAddLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_ADD_XPATH")));
		String ImgRuleAddLabelText = ImgRuleAddLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleAddLabelText, ExpectedImgRuleAddLabelText, locale)){
			Log.info("verifyImgRuleAddButtonText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleCreateRuleLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify CreateRule Label Text");
		String ExpectedImgRuleCreateRuleLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_CREATE_IMG_RULE");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleCreateRuleLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_NEW_RULE_LABEL_XPATH")));
		String ImgRuleCreateRuleLabelText = ImgRuleCreateRuleLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleCreateRuleLabelText, ExpectedImgRuleCreateRuleLabelText, locale)){
			Log.info("verifyImgRuleCreateRuleLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleListRulesLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify ListRules Label Text");
		String ExpectedImgRuleListRulesLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_RULES_LIST");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleListRulesLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_LIST_MATCHES_XPATH")));
		String ImgRuleListRulesLabelText = ImgRuleListRulesLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleListRulesLabelText, ExpectedImgRuleListRulesLabelText, locale)){
			Log.info("verifyImgRuleListRulesLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImgRuleIFsLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail ImageRule Page verify IF Label Text");
		String ExpectedImgRuleIFLabelText = otherLangTestData.getProperty("LANG_IF");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		WebElement ImgRuleIFLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_IF_XPATH")));
		String ImgRuleIFLabelText = ImgRuleIFLabel.getText();
		
		if(Verify.compareSingleString(ImgRuleIFLabelText, ExpectedImgRuleIFLabelText, locale)){
			Log.info("verifyImgRuleIFsLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySettingsLabels()throws Exception{
		Thread.sleep(3000);
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Image Rules Page verify Settings Labels text ...");
		String[] expectedSettingslabels;
		String expectedSettingslabels1;
		System.out.println(SUTprop.getProperty("LANGUAGE"));
		if (SUTprop.getProperty("LANGUAGE").equalsIgnoreCase("Spanishforamerica")) {
			expectedSettingslabels1 = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_TRUST_CONTACTS_SOURCES_MY_SENT_DEFINED_SOURCES").replace("A continuación, fuentes definidas como de confianza", "");
			expectedSettingslabels = expectedSettingslabels1.split(",");
		}
		else{
			expectedSettingslabels = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_TRUST_CONTACTS_SOURCES_MY_SENT_DEFINED_SOURCES").split(",");
		}
		//String expectedSettingslabels = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_TRUST_CONTACTS_SOURCES_MY_SENT_DEFINED_SOURCES");
		String expectData=expectedSettingslabels.toString();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		List<WebElement> lsSettingsLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_SETTINGS_LABELS_XPATH")));
		for(WebElement label:lsSettingsLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);	
		//String testData=Arrays.toString(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedSettingslabels, locale)){
			Log.info("verifySettingsLabels is success");
			stepResult=true;
			Thread.sleep(2000);	
		}
		
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySourceLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Image Rules Page verify Source Labels text ...");
		String[] expectedSourcelabels = otherLangTestData.getProperty("LANG_PREFERENCES_IMAGE_TRUST_CONTACTS_SOURCES_INFO_MY_SENT_INFO_DEFINED_SOURCES_INFO").split(";");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_HEADING_XPATH")));
		List<WebElement> lsSourceLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_SETTINGS_SOURCES_INFO_TEXT_XPATH")));
		for(WebElement label:lsSourceLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedSourcelabels, locale)){
			Log.info("verifySourceLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
	
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIFDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Image Rules Page verify IFDropDown Labels text ...");
		String[] expectedIFDropDownlabels = otherLangTestData.getProperty("LANG_FROM_TO_CC_TO_OR_CC_SUBJECT").split(",");
		WebElement IfDropDown = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_IMAGE_RULE_IF_FROM_DROPDOWN_XPATH"),60);
		IfDropDown.click();
		List<WebElement> lsIFDropDownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_IF_FROM_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsIFDropDownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedIFDropDownlabels, locale)){
			Log.info("verifyIFDropDownLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		IfDropDown.click();
		Thread.sleep(2000);
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIFContainsDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Image Rules Page verify IF Contains DropDown Labels text ...");
		String[] expectedIFcontainsDropDownlabels = otherLangTestData.getProperty("LANG_CONTAINS_EQUAL_NOT_EQUAL").split(",");
		WebElement IfcontainsDropDown = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_IMAGE_RULE_IF_CONTAINS_DROPDOWN_XPATH"),60);
		IfcontainsDropDown.click();
		List<WebElement> lsIFContainsDropDownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_IMAGE_RULE_IF_CONTAINS_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsIFContainsDropDownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedIFcontainsDropDownlabels, locale)){
			Log.info("verifyIFContainsDropDownLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		IfcontainsDropDown.click();
		Thread.sleep(2000);
		return stepResult;
	}
	
	

	/**
	 * @return
	 * @throws Exception
	 * @Desc : Data Usage Tab in Preferences Section
	 */
	public boolean verifyDataUsageHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Data Usage Page verify Spam Text");
		String ExpectedUsageText = otherLangTestData.getProperty("LANG_PREFERENCES_USAGE");
		WebElement Usagebutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_DATA_USGAE_BUTTON_XPATH"),60);
		if( Usagebutton == null)
			return false;
		Usagebutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_DATA_USGAE_HEADING_XPATH")));
		Thread.sleep(5000);
		WebElement Usage=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_DATA_USGAE_HEADING_XPATH")));
		String UsageText = Usage.getText();
		
		if(Verify.compareSingleString(UsageText, ExpectedUsageText, locale)){
			Log.info("verifyDataUsageHeadingText is success");
			stepResult=true;		
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyUsageLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Data Usgae Page verify Usage Label Text");
		String ExpectedUsageLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_USAGE_HEADER_USED");
		Thread.sleep(2000);
		WebElement UsageLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_DATA_USGAE_USED_LABEL_XPATH")));
		String UsageLabelText = UsageLabel.getText();
		
		if(Verify.compareSingleString(UsageLabelText, ExpectedUsageLabelText, locale)){
			Log.info("verifyUsageLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBreakdownLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Data Usgae Page verify BreakDown Label Text");
		String ExpectedbreakdownLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_USAGE_HEADER_BREAKDOWN");
		Thread.sleep(2000);
		WebElement breakdownLabel=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_DATA_USGAE_BREAKDOWN_LABEL_XPATH")));
		String breakdownLabelText = breakdownLabel.getText();
		
		if(Verify.compareSingleString(breakdownLabelText, ExpectedbreakdownLabelText, locale)){
			Log.info("verifyBreakdownLabelText is success");
			stepResult=true;			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCoreFoldersLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Core Fore Labels text ...");
		String[] expectedUFolderslabels = otherLangTestData.getProperty("LANG_MAIL_FOLDER_INBOX_MAIL_DRAFTS_SENT_MAIL_SPAM_INCOMING_TRASH").split(",");
		Thread.sleep(2000);
		List<WebElement> lsCFoldersLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_DATA_USGAE_CORE_FOLDERS_XPATH")));
		for(WebElement label:lsCFoldersLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedUFolderslabels, locale)){
			Log.info("verifyCoreFoldersLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 * @Desc : Calendar General Tab in Preferences Section
	 */
	public boolean verifyCalGenHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Calendar General Page verify Calendar Text");
		String ExpectedCalGenText = otherLangTestData.getProperty("LANG_CALENDAR");
		WebElement CalGenbutton = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_BUTTON_XPATH")));
		if( CalGenbutton == null)
			return false;
		CalGenbutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		Thread.sleep(2000);
		WebElement CalGen=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		String CalGenText = CalGen.getText();
		
		if(Verify.compareSingleString(CalGenText, ExpectedCalGenText, locale)){
			Log.info("verifyCalGenHeadingText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyWeekendLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify Weekend Label Text");
		String ExpectedWeekendLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_DEFAULT_SHOW_WEEKEND");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement WeekendLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_WEEKEND_LABEL_XPATH")));
		String WeekendLabelText = WeekendLabel.getText();
		
		if(Verify.compareSingleString(WeekendLabelText, ExpectedWeekendLabelText, locale)){
			Log.info("verifyWeekendLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyWeekendInfoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify WeekendInfo Label Text");
		String ExpectedWeekendInfoLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_DEFAULT_SHOW_WEEKEND_INFO");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement WeekendInfoLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_WEEKEND_INFO_LABEL_XPATH")));
		String WeekendInfoLabelText = WeekendInfoLabel.getText();
		
		if(Verify.compareSingleString(WeekendInfoLabelText, ExpectedWeekendInfoLabelText, locale)){
			Log.info("verifyWeekendInfoLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCustomHoursLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify CustomHours Label Text");
		String ExpectedCustomHoursLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_CUSTOM_HOURS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement CustomHoursLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CUSTOM_HOURS_LABEL_XPATH")));
		String CustomHoursLabelText = CustomHoursLabel.getText();
		
		if(Verify.compareSingleString(CustomHoursLabelText, ExpectedCustomHoursLabelText, locale)){
			Log.info("verifyCustomHoursLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCustomHoursInfoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify CustomHoursInfo Label Text");
		String ExpectedCustomHoursInfoLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_CUSTOM_HOURS_INFO");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement CustomHoursInfoLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CUSTOM_HOURS_INFO_LABEL_XPATH")));
		String CustomHoursInfoLabelText = CustomHoursInfoLabel.getText();
		
		if(Verify.compareSingleString(CustomHoursInfoLabelText, ExpectedCustomHoursInfoLabelText, locale)){
			Log.info("verifyCustomHoursInfoLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyShareCalLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify ShareCal Label Text");
		String ExpectedShareCalLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_CALENDAR_SHARING");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement ShareCalLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_SHARING_LABEL_XPATH")));
		String ShareCalLabelText = ShareCalLabel.getText();
		
		if(Verify.compareSingleString(ShareCalLabelText, ExpectedShareCalLabelText, locale)){
			Log.info("verifyShareCalLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCalLinksLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify CalLinks Label Text");
		String ExpectedCalLinksLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_CALENDAR_LINKS_LABEL");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement CalLinksLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_LINKS_LABEL_XPATH")));
		String CalLinksLabelText = CalLinksLabel.getText();
		
		if(Verify.compareSingleString(CalLinksLabelText, ExpectedCalLinksLabelText, locale)){
			Log.info("verifyCalLinksLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCalLinksDescLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify CalLinksDesc Label Text");
		String ExpectedCalLinksDescLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_CALENDAR_LINKS_DESC");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement CalLinksDescLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_LINKS_DESC_XPATH")));
		String CalLinksDescLabelText = CalLinksDescLabel.getText();
		
		if(Verify.compareSingleString(CalLinksDescLabelText, ExpectedCalLinksDescLabelText, locale)){
			Log.info("verifyCalLinksDescLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyViewLinkLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Calendar General Page verify ViewLink Label Text");
		String ExpectedViewLinkLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_DEFAULT_VIEW_LINKS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		WebElement ViewLinkLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_VIEW_LINKS_BUTTON_XPATH")));
		String ViewLinkLabelText = ViewLinkLabel.getText();
		
		if(Verify.compareSingleString(ViewLinkLabelText, ExpectedViewLinkLabelText, locale)){
			Log.info("verifyViewLinkLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCALFormLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Image Rules Page verify Calendar General Form Labels text ...");
		String[] expectedCALFormlabels = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_DEFAULT_VIEW_EVENT_DURATION_LOCATION_SHOW_DEFAULT_LOCATION_LOCATION_COLLECTION_CLEAR_LOCATION_HISTORY").split(",");
		//String[] expectedCALFormlabelsOtherVal = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_DEFAULT_VIEW_EVENT_DURATION_LOCATION_SHOW_DEFAULT_LOCATION_LOCATION_COLLECTION_CLEAR_LOCATION_HISTORY1").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		List<WebElement> lsCALFormLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_FORM_LABELS_XPATH")));
		for(WebElement label:lsCALFormLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedCALFormlabels, locale)){
			Log.info("verifyCALFormLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCalViewLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Calendar General Page verify Calendar General Cal View Labels text ...");
		String[] expectedCalViewlabels = otherLangTestData.getProperty("LANG_PREFERENCES_CALENDAR_AGENDA_DAY_WEEK_MONTH").split(",");
		WebElement CalViewDropDown = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_VIEW_DROPDOWN_XPATH"),60);
		CalViewDropDown.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_HEADING_XPATH")));
		List<WebElement> lsCalViewLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_CAL_GEN_CAL_VIEW_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsCalViewLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedCalViewlabels, locale)){
			Log.info("verifyCalViewLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 * @Desc : Mobile General Tab in Preferences Section
	 */
	public boolean verifyMobGenHeadingText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Prefrences Mobile General Page verify Mobile Text");
		String ExpectedMobGenText = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE");
		WebElement MobGenbutton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PREF_MOB_GEN_BUTTON_XPATH"),60);
		if( MobGenbutton == null)
			return false;
		MobGenbutton.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_MOBILE_HEADING_XPATH")));
		WebElement MobGen=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_MOBILE_HEADING_XPATH")));
		String MobGenText = MobGen.getText();
		
		if(Verify.compareSingleString(MobGenText, ExpectedMobGenText, locale)){
			Log.info("verifyMobGenHeadingText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGeneralLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Mobile General Page verify General Label Text");
		String ExpectedgeneralLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_GENREAL");
		Thread.sleep(3000);
		WebElement generalLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_GENERAL_LABEL_XPATH")));
		String generalLabelText = generalLabel.getText();
		
		if(Verify.compareSingleString(generalLabelText, ExpectedgeneralLabelText, locale)){
			Log.info("verifyGeneralLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySynSuiteLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Mobile General Page verify SynSuite Label Text");
		String ExpectedSynSuiteLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_SYNCSUITE_SYNCSUITE_VER");
		Thread.sleep(3000);
		WebElement SynSuiteLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_SYNC_LABEL_XPATH")));
		String SynSuiteLabelText = SynSuiteLabel.getText();
		
		if(Verify.compareSingleString(SynSuiteLabelText, ExpectedSynSuiteLabelText, locale)){
			Log.info("verifySynSuiteLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySynSuiteInfoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Mobile General Page verify SynSuiteInfo Label Text");
		String ExpectedSynSuiteInfoLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_SYNCSUITE_SUBTITLE");
		Thread.sleep(3000);
		WebElement SynSuiteInfoLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_SYNC_INFO_XPATH")));
		String SynSuiteInfoLabelText = SynSuiteInfoLabel.getText();
		
		if(Verify.compareSingleString(SynSuiteInfoLabelText, ExpectedSynSuiteInfoLabelText, locale)){
			Log.info("IverifySynSuiteInfoLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGenSynSuiteInfoLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Mobile General Page verify GenSynSuiteInfo Label Text");
		String ExpectedGenSynSuiteInfoLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_WHAT_IS_SYNCSUITE_CONTENT");
		Thread.sleep(3000);
		WebElement GenSynSuiteInfoLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_SYN_SUITE_INFO_XPATH")));
		String GenSynSuiteInfoLabelText = GenSynSuiteInfoLabel.getText();
		
		if(Verify.compareSingleString(GenSynSuiteInfoLabelText, ExpectedGenSynSuiteInfoLabelText, locale)){
			Log.info("verifyGenSynSuiteInfoLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySynSuiteSetUpLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Mobile General Page verify SynSuiteSetUp Label Text");
		String ExpectedSynSuiteSetUpLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_SYNCSUITE_SETUP_CONTENT_1_FOR_BLACKBERRY");
		Thread.sleep(3000);
		WebElement SynSuiteSetUpLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_SYNC_SUITE_SETUP_INFO_XPATH")));
		String SynSuiteSetUpLabelText = SynSuiteSetUpLabel.getText();
		
		if(Verify.compareSingleString(SynSuiteSetUpLabelText, ExpectedSynSuiteSetUpLabelText, locale)){
			Log.info("verifySynSuiteSetUpLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyOutlookHelpLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Mobile General Page verify OutlookHelp Label Text");
		String ExpectedOutlookHelpLabelText = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_NOTE_CONTENT_1_CONTENT_2");
		Thread.sleep(3000);
		WebElement OutlookHelpLabel=driver.findElement(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_OUTLOOK_HELP_INFO_XPATH")));
		String OutlookHelpLabelText = OutlookHelpLabel.getText();
		
		if(Verify.compareSingleString(OutlookHelpLabelText, ExpectedOutlookHelpLabelText, locale)){
			Log.info("verifyOutlookHelpLabelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPageContentLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Mobile General Page verify Page Content Labels text ...");
		String[] expectedPageContentlabels = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_WHAT_IS_SYNCSUITE_SYNCSUITE_SETUP_OUTLOOK_OUTLOOK_SYNC").split(";");
		Thread.sleep(3000);		
		List<WebElement> lsPageContentLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_PAGE_CONTENT_H5_LABEL_XPATH")));
		for(WebElement label:lsPageContentLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedPageContentlabels, locale)){
			Log.info("verifyPageContentLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTableHeadLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Mobile General Page verify Table Head Labels text ...");
		String[] expectedTableHeadlabels = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_SYNCSUITE_TABLE_HEADER_LINK_DOWNLOAD").split(",");
		Thread.sleep(3000);		
		List<WebElement> lsTableHeadLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_SYNC_SUITE_TABLE_H5_XPATH")));
		for(WebElement label:lsTableHeadLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedTableHeadlabels, locale)){
			Log.info("verifyTableHeadLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTableBody1Labels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Mobile General Page verify Table Body1 Labels text ...");
		String[] expectedTableBody1labels = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_SYNCSUITE_TABLE_IOS_ANDROID_BLACKBERRY").split(",");
		Thread.sleep(3000);		
		List<WebElement> lsTableBody1Labels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_SYNC_SUITE_TABLE_BODY_1_XPATH")));
		for(WebElement label:lsTableBody1Labels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedTableBody1labels, locale)){
			Log.info("verifyTableBody1Labels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}	

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTableBody2Labels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Mobile General Page verify Table Body2 Labels text ...");
		String[] expectedTableBody2labels = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_SYNCSUITE_APP_NOT_REQUIRED_TABLE_YES_GET_IT").split(";");
		Thread.sleep(3000);		
		List<WebElement> lsTableBody2Labels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_SYNC_SUITE_TABLE_BODY_2_XPATH")));
		for(WebElement label:lsTableBody2Labels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedTableBody2labels, locale)){
			Log.info("verifyTableBody2Labels is success");
			stepResult=true;
				Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyOutlookBodyLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Mobile General Page verify Outlook Body Labels text ...");
		String[] expectedOutlookBodylabels = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_OUTLOOK_CONTENT_1_CONTENT_2").split(";");
		Thread.sleep(3000);		
		List<WebElement> lsOutlookBodyLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_OUTLOOK_BODY_XPATH")));
		for(WebElement label:lsOutlookBodyLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedOutlookBodylabels, locale)){
			Log.info("verifyOutlookBodyLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyOutlookSynInfoLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Inside Mail Mobile General Page verify Outlook Sync Info Labels text ...");
		String[] expectedOutlookSynInfolabels = otherLangTestData.getProperty("LANG_PREFERENCES_MOBILE_OUTLOOK_SYNC_LIST_1_LIST_2_LIST_3_SYNCSUITE_FOR_BLACKBERRY").split(";");
		Thread.sleep(3000);		
		List<WebElement> lsOutlookSynInfoLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("PREF_MOB_GEN_OUTLOOK_SYNC_INFO_XPATH")));
		for(WebElement label:lsOutlookSynInfoLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedOutlookSynInfolabels, locale)){
			Log.info("verifyOutlookSynInfoLabels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}
	


}