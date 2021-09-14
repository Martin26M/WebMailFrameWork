package com.webmailhostopia.testimpl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailContactsPage extends AbstractPageObject{

	public boolean labelsTestInContactsPage() throws Exception
	{
		int failCounter=0;
		Thread.sleep(5000);
		if(!OpenContact())
			failCounter++;
		if(!verifySearchPlaceHolderText())
			failCounter++;
		if(!verifyContactSearchBarDropDownLabels())
			failCounter++;
		if(!verifyContactsWelcomeText())
			failCounter++;
		if(!verifyContactsWelcomeContentText())
			failCounter++;
		/*if(!verifyContactPaginationText())
			failCounter++;*/
		if(!verifyContactMoreText())
			failCounter++;
		if(!verifyMoreDropDownlabels())
			failCounter++;
		if(!verifySideHeaderlabels())
			failCounter++;
		
		
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsTestInCreateContactPage() throws Exception
	{
		int failCounter=0;
		Thread.sleep(5000);
		if(!verifyTopSideHeaderlabels())
			failCounter++;
		if(!verifyNewContactHeaderlabels())
			failCounter++;
		if(!verifyContactSocialText())
			failCounter++;
		if(!verifyAddGroupText())
			failCounter++;
		if(!verifyNewContactCreationMainNamelabels())
			failCounter++;
		if(!verifyBirthdayText())
			failCounter++;
		if(!verifyNotesPlaceHolderText())
			failCounter++;
		if(!verifyNewContactPersonalContactDrpDwnlabels())
			failCounter++;
		
		
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsTestInAddAdressBookPage() throws Exception
	{
		int failCounter=0; 
		Thread.sleep(5000);
		if(!verifyNewAddressBooklabels())
			failCounter++;
		if(!verifyAddEmailText())
			failCounter++;
		return (failCounter==0)?true:false;
	}
	
	public boolean labelsTestInSubsAdressBookPage() throws Exception
	{
		int failCounter=0; 
		Thread.sleep(5000);
		if(!verifySubscribeBookTitleText())
			failCounter++;
		if(!verifySubsSearchPlaceHolderText())
			failCounter++;
		if(!verifySubscribeBackTitleText())
			failCounter++;
		Thread.sleep(5000);
		return (failCounter==0)?true:false;
	}

	public boolean labelsTestInGroupPage() throws Exception
	{
		int failCounter=0; 
		Thread.sleep(10000);
		if(!verifyNewGroupTitleText())
			failCounter++;
		if(!verifyGroupTitleText())
			failCounter++;
		if(!verifyGroupColorText())
			failCounter++;
		if(!verifyGroupEmailText())
			failCounter++;
		return (failCounter==0)?true:false;
	}
	  
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean OpenContact() throws Exception {

		boolean stepResult = false;
		WebElement Cont = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("CONTACT_ICON_XPATH")));
		Cont.click();
		if (waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONATCT_ADD_NEW_CONTACT_BUTTON_XPATH")))
				.isDisplayed()) {
			stepResult = true;
			Log.info("OpenContact is success");
		}
		return stepResult;
	}

public boolean verifySearchPlaceHolderText()throws Exception{
	boolean stepResult = false;
	Log.info("Inside verify search placeholder text method");
	String nonEnglishSearchBarText = otherLangTestData.getProperty("CONTACT_SEARCH_BOX_PLACEHOLDER_TEXT");
	WebElement searchBarPlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CONTACT_SEARCH_BOX_PLACEHOLDER_TEXT_XPATH"), 60);
	if( searchBarPlaceHolder == null)
		return false;
	String searchBarPlaceHolderText = searchBarPlaceHolder.getAttribute("placeholder");
	if(Verify.compareSingleString(searchBarPlaceHolderText, nonEnglishSearchBarText, locale)){
			Log.info("search placeholder");
			stepResult=true;
		}
	
	return stepResult;
}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyContactSearchBarDropDownLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying search bar dropdwon labels text in Task tab...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CONTACTS_SEARCH_BY_EMAIL_NAME").split(",");

		WebElement searchBarDrpDwonBtn = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_SEARCH_BOX_DROPDOWN_XPATH"), 60);

		if (searchBarDrpDwonBtn == null)
			return false;
		searchBarDrpDwonBtn.click();

		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONATCT_SEARCH_BOX_DROPDOWN_VALUES_XPATH")));
		List<WebElement> lsSearchBarDropdownLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("CONATCT_SEARCH_BOX_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsSearchBarDropdownLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("search bar dropdwon labels text in Task tab...");
			stepResult = true;
			Thread.sleep(2000);
		}
		searchBarDrpDwonBtn.click();
		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyContactsWelcomeText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside verify Welcome Message text in Contact Page method");
		String nonEnglishConText = otherLangTestData.getProperty("LANG_CONTACTS_WELCOME_CONTACTS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONATCT_ADD_NEW_CONTACT_BUTTON_XPATH")));
		WebElement Con = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_WELCOME_MESG_XPATH")));
		if (Con == null)
			return false;
		String ConText = Con.getText();

		if (Verify.compareSingleString(ConText, nonEnglishConText, locale)) {
			Log.info("verifyContactsWelcomeText is success");
			stepResult = true;
		}

		return stepResult;
	}

public boolean verifyContactsWelcomeContentText()throws Exception{
	boolean stepResult = false;
	
	Log.info("Inside verify Welcome Content Message text in Contact Page method");
	String nonEnglishContText = otherLangTestData.getProperty("LANG_CONTACTS_WELCOME_MSG");
	WebElement Cont = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_WELCOME_MESG_CONTACT_XPATH")));
	if( Cont == null)
		return false;
	String ContText = Cont.getText();
	
	if(Verify.compareSingleString(ContText, nonEnglishContText, locale)){
		Log.info("verify Contacts Welcome Content Text is success");
		stepResult=true;
		}
	
	return stepResult;
}

public boolean verifyContactPaginationText()throws Exception{
	boolean stepResult = false;
	
	Log.info("Inside verify Pagination text in Contact Page method");
	String nonEnglishPageText = otherLangTestData.getProperty("LANG_PAGINATION_PAGE_OF_ITEMS");
	waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONATCT_ADD_NEW_CONTACT_BUTTON_XPATH")));
	Thread.sleep(5000);
	WebElement Page = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_PAGINATION_TEXT_XPATH")));
	if( Page == null)
		return false;
	String PageText = Page.getText();
	System.out.println("pagination value is :"+PageText);
	if(Verify.compareSingleString(PageText, nonEnglishPageText, locale)){
			Log.info("verifyContactPaginationText is success");
			stepResult=true;
		}
	
	return stepResult;
}

public boolean verifyContactMoreText()throws Exception{
	boolean stepResult = false;
	
	Log.info("Inside verify More text in Contact Page method");
	String nonEnglishMoreText = otherLangTestData.getProperty("LANG_CONTACTS_MORE");
	waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CONATCT_ADD_NEW_CONTACT_BUTTON_XPATH"), 60);
	WebElement More = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONATCT_MORE_BUTTON_XPATH")));
	if( More == null)
		return false;
	String MoreText = More.getText();
	
	if(Verify.compareSingleString(MoreText, nonEnglishMoreText, locale)){
			Log.info("verifyContactMoreText is success");	
			stepResult=true;
		}
	
	return stepResult;
}

public boolean verifyMoreDropDownlabels()throws Exception{
    boolean stepResult = false;
    List<String> lsLabelText = new ArrayList<String>();
   
    Log.info("Verfiying More Drop Down labels text in Contact Section...");
   
    String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CONTACTS_IMPORT_FIND_DUPLICATES_LANG_EXPORT").split(",");

   WebElement MoredrpDwn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CONATCT_MORE_BUTTON_XPATH"), 60);
   MoredrpDwn.click();
   waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONTACT_MORE_BUTTON_DROPDOWN_VALUES_XPATH")));
    List<WebElement> lsMoreDrpDwnLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("CONTACT_MORE_BUTTON_DROPDOWN_VALUES_XPATH")));
    for(WebElement label:lsMoreDrpDwnLabels){
        String temp = label.getText().trim();
        if( !temp.isEmpty()){
            lsLabelText.add(label.getText().trim());
        }
    }
    String[] actuals = new String[lsLabelText.size()];
    actuals = lsLabelText.toArray(actuals);

    if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
    	Log.info("verifyMoreDropDownlabels is success");
         stepResult=true;
       
    }
   
    return stepResult;
}

public boolean verifySideHeaderlabels()throws Exception{
    boolean stepResult = false;
    List<String> lsLabelText = new ArrayList<String>();
   
    Log.info("Verfiying Side Header labels text in Contact Section...");
   
      String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CONTACTS_LIST_SUBSCRIBED_BOOKS_GROUPS_LIST").split(",");
   	waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONTACT_SIDE_HEADER_PANEL_XPATH")));
    List<WebElement> lsSidePanelLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("CONTACT_SIDE_HEADER_PANEL_XPATH")));
    for(WebElement label:lsSidePanelLabels){
        String temp = label.getText().trim();
        if( !temp.isEmpty()){
            lsLabelText.add(label.getText().trim());
        }
    }
    String[] actuals = new String[lsLabelText.size()];
    actuals = lsLabelText.toArray(actuals);

    if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
    	Log.info("verifySideHeaderlabels is success");
        stepResult=true;
       
    }
   
    return stepResult;
}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTopSideHeaderlabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying Top Right Side Header labels text in Contact Section...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_SAVE_CANCEL").split(",");
		WebElement AddNew = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONATCT_ADD_NEW_CONTACT_BUTTON_XPATH"), 60);
		AddNew.click();
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_SAVE_BUTTON_XPATH")));
		List<WebElement> lsSidePanelLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_RIGHT_LABELS_XPATH")));
		for (WebElement label : lsSidePanelLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		System.out.println("values is :"+actuals);
		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyTopSideHeaderlabels is success");
			stepResult = true;

		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewContactHeaderlabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying New Contact Page Side Header labels text in Contact Section...");

		String[] expectedInNonEnglish = otherLangTestData
				.getProperty("LANG_CONTACTS_NEW_CONTACT_CONTACT_PERSONAL_DETAILS_ADDRESS_NOTES").split(",");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_SAVE_BUTTON_XPATH"), 60);
		List<WebElement> lsContHeaderLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONATCT_HEADER_LABELS_XPATH")));
		for (WebElement label : lsContHeaderLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyNewContactHeaderlabels is success");
			stepResult = true;

		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyContactSocialText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside verify Manage Social label text in Contact Page method");
		String nonEnglishSocialText = otherLangTestData.getProperty("LANG_CONTACTS_MANAGE_SOCIAL");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_SAVE_BUTTON_XPATH"), 60);
		WebElement Social = driver.findElement(
				By.xpath(elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONATCT_MANAGESOCIAL_LABEL_XPATH")));
		if (Social == null)
			return false;
		String SocialText = Social.getText();

		if (Verify.compareSingleString(SocialText, nonEnglishSocialText, locale)) {
			Log.info("verifyContactSocialText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAddGroupText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside verify AddGroup label text in Contact Page method");
		String nonEnglishAddGroupText = otherLangTestData.getProperty("LANG_CONTACTS_ADD_GROUP");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_SAVE_BUTTON_XPATH")));
		WebElement AddGroup = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONATCT_ADDGROUP_LABEL_XPATH")));
		if (AddGroup == null)
			return false;
		String AddGroupText = AddGroup.getText();

		if (Verify.compareSingleString(AddGroupText, nonEnglishAddGroupText, locale)) {
			Log.info("verifyAddGroupText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewContactCreationMainNamelabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying New Contact Page Main Content labels text in Contact Section...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CONTACTS_NEW_CONTACT_FIRST_LAST_NAME")
				.split(",");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_SAVE_BUTTON_XPATH"), 60);
		List<WebElement> lsContMainLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONATCT_NAME_LABELS_XPATH")));
		for (WebElement label : lsContMainLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyNewContactCreationMainNamelabels is success");
			stepResult = true;

		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBirthdayText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside verify Birthday label text in Contact Page method");
		String nonEnglishBirthdayText = otherLangTestData.getProperty("LANG_CONTACTS_NEW_CONTACT_BIRTHDAY");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_SAVE_BUTTON_XPATH"), 60);
		WebElement Birthday = driver.findElement(
				By.xpath(elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONATCT_PERSONALDETAILS3_LABEL_XPATH")));
		if (Birthday == null)
			return false;
		String BirthdayText = Birthday.getText();

		if (Verify.compareSingleString(BirthdayText, nonEnglishBirthdayText, locale)) {
			Log.info("verifyBirthdayText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNotesPlaceHolderText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside verify Notes placeholder text method");
		String nonEnglishNotesText = otherLangTestData.getProperty("LANG_CONTACTS_NEW_CONTACT_ADD_A_FEW_DETAILS");
		WebElement pageDown = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("CONTACT_PAGE_SCROLL_DOWN")));
		Coordinates movePage=((Locatable)pageDown).getCoordinates();
		movePage.inViewPort();
		WebElement NotesPlaceHolder = waitForElementVisibility(By.xpath(
		elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONATCT_NOTES_PLACEHOLDER_XPATH")));
		if (NotesPlaceHolder == null)
			return false;
		String NotesPlaceHolderText = NotesPlaceHolder.getAttribute("placeholder");
		System.out.println("NotesPlaceHolderText value is :"+NotesPlaceHolderText);
		if (Verify.compareSingleString(NotesPlaceHolderText, nonEnglishNotesText, locale)) {
			Log.info("verifyNotesPlaceHolderText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewContactPersonalContactDrpDwnlabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying New Contact Personal Contact Drop Down labels text in Contact Section...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CONTACTS_CONTACT_FORM_DROPDOWN_VALUES")
				.split(",");
		WebElement PersonalContact = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_ADD_NEW_CONTACT_CONTACTS_PLUS_BUTTON_XPATH"), 60);
		PersonalContact.click();
		List<WebElement> lsPersContLabels = driver.findElements(
				By.xpath(elementLocatorProp.getProperty("CONATCT_ADD_NEW_CONTACT_CONTACT_PLUS_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsPersContLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyNewContactPersonalContactDrpDwnlabels is success");
			stepResult = true;

		}

		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewAddressBooklabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying New AddressBook labels text in Contact Address Book Section...");
		Thread.sleep(2000);
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CONTACTS_ADDRESSBOOKS_NEW_FORM_SHARE_WITH_ALL_DOMAIN_USERS_SPECIFIC_USERS_PERMISSION").split(",");
		WebElement AddressBookPlus = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_ADDRESSBOOK_PLUS_BUTTON_XPATH"), 60);
		AddressBookPlus.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONTACT_ADDRESSBOOK_VALIDATION")));
		List<WebElement> lsAddBookLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("CONTACT_NEW_ADDRESSBOOK_HEADING_XPATH")));
		for (WebElement label : lsAddBookLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		Thread.sleep(2000);
		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyNewAddressBooklabels is success");
			stepResult = true;

		}

		return stepResult;
	}

public boolean verifyAddBookTitleText()throws Exception{
	boolean stepResult = false;
	
	Log.info("Inside verify AddressBook Title label text in Contact Page method");
	String nonEnglishText = otherLangTestData.getProperty("LANG_CONTACTS_ADDRESSBOOKS_NEW");
	waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CONTACT_NEW_ADDRESSBOOK_TOP_RIGHT_LABELS_XPATH"), 60);
	WebElement AddBookTitle = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_NEW_ADDRESSBOOK_TITLE_XPATH")));
	if( AddBookTitle == null)
		return false;
	String AddBookTitleText = AddBookTitle.getText();
	
	if(Verify.compareSingleString(AddBookTitleText, nonEnglishText, locale)){
			
			stepResult=true;
		}
	
	return stepResult;
}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAddEmailText() throws Exception {
		boolean stepResult = false;
		Thread.sleep(3000);
		Log.info("Inside verify Add Email label text in Contact Page method");
		String nonEnglishText = otherLangTestData.getProperty("LANG_ADD1");
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_NEW_ADDRESSBOOK_ADD_XPATH"), 60);
		WebElement AddEmail = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_NEW_ADDRESSBOOK_ADD_XPATH")));
		if (AddEmail == null)
			return false;
		String AddEmailText = AddEmail.getText();
		Thread.sleep(3000);
		if (Verify.compareSingleString(AddEmailText, nonEnglishText, locale)) {
			Log.info("verifyAddEmailText is success");
			stepResult = true;
		}

		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySubscribeBookTitleText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside verify Subscribe Book Title label text in Contact Page method");
		String nonEnglishText = otherLangTestData.getProperty("LANG_CONTACTS_SUBSCRIBE_CONTACTS");
		WebElement SubBook = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_SUBSBOOK_PLUS_BUTTON_XPATH"), 60);
		SubBook.click();
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("CONTACT_SUBSBOOK_BACK_BUTTON_XPATH")));
		WebElement SubBookTitle = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_SUBSBOOK_HEADING_XPATH")));
		if (SubBookTitle == null)
			return false;
		String SubBookTitleText = SubBookTitle.getText();

		if (Verify.compareSingleString(SubBookTitleText, nonEnglishText, locale)) {
			Log.info("verifySubscribeBookTitleText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySubsSearchPlaceHolderText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside verify Search placeholder text method");
		String nonEnglishSubSearchBarText = otherLangTestData.getProperty("CONTACT_SUBSBOOK_SEARCH_PLACEHOLDER_TEXT");
		WebElement SearchSubPlaceHolder = waitForElementToBeClickable(ByLocator.xpath,elementLocatorProp.getProperty("CONTACT_SUBSBOOK_SEARCH_PLACEHOLDER_XPATH"),60);
		if (SearchSubPlaceHolder == null)
			return false;
		String SearchSubPlaceHolderText = SearchSubPlaceHolder.getAttribute("placeholder");
		System.out.println("PlaceHolder Text:" + SearchSubPlaceHolderText);
		Thread.sleep(5000);
		if (Verify.compareSingleString(SearchSubPlaceHolderText, nonEnglishSubSearchBarText, locale)) {
			Log.info("verifySubsSearchPlaceHolderText is success");
			stepResult = true;
		}

		return stepResult;
	}

public boolean verifySubscribeBackTitleText()throws Exception{
	boolean stepResult = false;
	Thread.sleep(5000);
	Log.info("Inside verify Subscribe Book Back label text in Contact Page method");
	String nonEnglishText = otherLangTestData.getProperty("LANG_BACK");
	waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONTACT_SUBSBOOK_BACK_BUTTON_XPATH")));
	WebElement SubBackTitle = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_SUBSBOOK_BACK_BUTTON_XPATH")));
	if( SubBackTitle == null)
		return false;
	String SubBackTitleText = SubBackTitle.getText();
	Thread.sleep(5000);
	if(Verify.compareSingleString(SubBackTitleText, nonEnglishText, locale)){
			
			stepResult=true;
		}
	
	return stepResult;
}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewGroupTitleText() throws Exception {
		boolean stepResult = false;
		Thread.sleep(3000);
		Log.info("Inside verify New Group Title label text in Contact Page method");
		String nonEnglishText = otherLangTestData.getProperty("LANG_CONTACTS_GROUPS_NEW");
		WebElement group = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("CONTACT_GROUPS_PLUS_BUTTON_XPATH"), 60);
		group.click();
		Thread.sleep(3000);
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CONTACT_GROUP_PAGE_VALIDATION")));

		WebElement groupTitle = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_GROUP_PAGE_VALIDATION")));
		if (groupTitle == null)
			return false;
		String groupTitleText = groupTitle.getText();

		if (Verify.compareSingleString(groupTitleText, nonEnglishText, locale)) {
			Log.info("verifyNewGroupTitleText is success");
			stepResult = true;
		}

		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGroupTitleText() throws Exception {
		boolean stepResult = false;
		Thread.sleep(3000);
		Log.info("Inside verify Group Title label text in Contact Page method");
		String nonEnglishText = otherLangTestData.getProperty("LANG_CONTACTS_GROUPS_NEW_FORM_NAME");
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("CONTACT_NEWGROUP_ADDCONTACTS_PLACEHOLDER_XPATH")));

		WebElement Title = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_NEWGROUP_TITLE_XPATH")));
		if (Title == null)
			return false;
		String TitleText = Title.getText();

		if (Verify.compareSingleString(TitleText, nonEnglishText, locale)) {
			Log.info("verifyGroupTitleText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGroupColorText() throws Exception {
		boolean stepResult = false;
		Thread.sleep(3000);
		Log.info("Inside verify color label text in Contact Page method");
		String nonEnglishcolText = otherLangTestData.getProperty("LANG_CONTACTS_GROUPS_NEW_FORM_COLOR");
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("CONTACT_NEWGROUP_ADDCONTACTS_PLACEHOLDER_XPATH")));

		WebElement color = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_NEWGROUP_COLOR_XPATH")));
		if (color == null)
			return false;
		String colorText = color.getText();

		if (Verify.compareSingleString(colorText, nonEnglishcolText, locale)) {
			Log.info("verifyGroupColorText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGroupEmailText() throws Exception {
		boolean stepResult = false;
		Thread.sleep(3000);
		Log.info("Inside verify Email label text in Contact Page method");
		String nonEnglishEmailText = otherLangTestData.getProperty("LANG_CONTACTS_GROUPS_NEW_ADD_CONTACTS");
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("CONTACT_NEWGROUP_ADDCONTACTS_PLACEHOLDER_XPATH")));

		WebElement Email = driver.findElement(By.xpath(elementLocatorProp.getProperty("CONTACT_NEWGROUP_EMAIL_XPATH")));
		if (Email == null)
			return false;
		String EmailText = Email.getText();

		if (Verify.compareSingleString(EmailText, nonEnglishEmailText, locale)) {
			Log.info("verifyGroupEmailText is success");
			stepResult = true;
		}

		return stepResult;
	}


}
