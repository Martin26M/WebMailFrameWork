package com.webmailhostopia.testimpl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailHomePage extends AbstractPageObject{

	

	public boolean verifyLabelsLangugaeInMailHomePage()throws Exception{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!navigateToMailPage())
			failCounter++;
		if(!validateMailToolTipText())
			failCounter++;
		if(!verifySearchPlaceHolderText())
			failCounter++;
		if(!verifySearchBarDropDownLabels())
			failCounter++;
		if(!verifyVeiwText())
			failCounter++;
		if(!verifyViewDropDownLabels())
			failCounter++;
		if(!verifySortbyText())
			failCounter++;
		if(!verifySortByDropDownlabels())
			failCounter++;
		if(!verifyCoreFoldernamelabels())
			failCounter++;
		/*if(!verifyInboxStatusMessageText())
			failCounter++;*/		
		if(!verifyPFolderText())
			failCounter++;
		if(!validatefolderToolTipText())
            failCounter++; 
		/*if(!verifyfoldertogglelabels())
			failCounter++;
		if(!verifydeletefolderpopup())
			failCounter++;*/
		Thread.sleep(3000);
		if(!verifyDiskUsageText())
			failCounter++;	
		if(!validateComposeMailToolTipText())
			failCounter++;
		if(!verifyComposedropdownenamelabels())
			failCounter++;
		if(!verifycomposeNewMessageText())
			failCounter++;
		if(!verifyComposeTopRightButtonslabels())
			failCounter++;
		if(!verifyComposeHeaderlabels())
			failCounter++;
		if(!verifyAlertTextMessageWhenDiscardNewMail())
			failCounter++;  
			
				
		return (failCounter==0)?true:false;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean navigateToMailPage() throws Exception {

		WebElement mailSection = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_SECTION_XPATH"), 60);
		if (mailSection == null) {
			return false;
		}

		mailSection.click();
		if (waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_LABEL_XPATH"),
				60) == null) {
			return false;
		} else {
			Log.info("navigateToMailPage is success");
			return true;
		}
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean validateMailToolTipText()throws Exception{

		boolean stepResult = false;
		Thread.sleep(3000);
		String nonEnglishTooltip = otherLangTestData.getProperty("LANG_MAIL");
		Actions builder=new Actions(driver);
		WebElement mailToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("MAIL_LABEL_XPATH")));
		builder.moveToElement(mailToolTip).perform();
		String tooltip_msg=mailToolTip.getText();
		Log.info("Mail ICon Tool tip Text is : " + tooltip_msg);		
			if(Verify.compareSingleString(tooltip_msg, nonEnglishTooltip, locale)){
				Log.info("validateMailToolTipText is success");
				stepResult=true;
			
		}
		return stepResult;	
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySearchPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify search placeholder text method");
		String nonEnglishSearchBarText = otherLangTestData.getProperty("LANG_MAIL_SEARCH_PLACEHOLDER");
		WebElement searchBarPlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("SEARCH_BAR_PLACE_HOLDER_TEXT")));
		if( searchBarPlaceHolder == null)
			return false;
		String searchBarPlaceHolderText = searchBarPlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(searchBarPlaceHolderText, nonEnglishSearchBarText, locale)){
				Log.info("verifySearchPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySearchBarDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying search bar dropdwon labels text in mail tab...");
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_SEARCH_BY_LANG_MAIL_FILTER_DROPDOWN_VALUES").split(",");
		WebElement searchBarDrpDwonBtn = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("SEARCH_BAR_DROPDWON_BUTTON_XPATH")));
		if(searchBarDrpDwonBtn == null)
			return false;
		searchBarDrpDwonBtn.click();
		Thread.sleep(5000);
		List<WebElement> lsSearchBarDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("SEARCH_BAR_DROPDOWN_ITEMS_XPATH")));
		for(WebElement label:lsSearchBarDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				System.out.println("search mail text :"+label.getText().trim());
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("verifySearchBarDropDownLabels is success");
			stepResult=true;
			Thread.sleep(2000);			
		}
		searchBarDrpDwonBtn.click();
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAlertTextMessageWhenDiscardNewMail()throws Exception{
	
		boolean stepResult = false;
		Log.info("Verifying POP UP For Discrad mail Text");

		
		String alertHeaderTextInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_COMPOSE_ALERT_DISCARD_HEADER");  
        WebElement discardBtn = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DISCARD_BTN_XPATH")));
		if( discardBtn == null)
			return false;
		discardBtn.click();
		
		
        WebElement PopUpHeader = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DISCRAD_MAIL_POPUP_HEADER")));
        String PopUpHeaderText = PopUpHeader.getText();
       
        
            if(Verify.compareSingleString(PopUpHeaderText, alertHeaderTextInNonEnglish, locale)){
            	Log.info("alertHeaderTextInNonEnglish is success");
                stepResult=true;
            }

            String bodynonEnglishText = otherLangTestData.getProperty("LANG_MAIL_COMPOSE_ALERT_DISCARD_BODY");
            
            WebElement PopUpBody = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DISCRAD_MAIL_POPUP_BODY")));
            String PopUpBodyText = PopUpBody.getText();
             if(Verify.compareSingleString(PopUpBodyText, bodynonEnglishText, locale)){
            	  Log.info("bodynonEnglishText is success");
                  stepResult=true;
                  Thread.sleep(5000);
                }  
        
    	
    	String nonEnglishTextDraft = otherLangTestData.getProperty("LANG_MAIL_COMPOSE_ALERT_DISCARD_SAVEDRAFT");
       
        WebElement PopUpDraftButton = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("DISCRAD_MAIL_POPUP_SAVEDRAFT")));
        String PopUpDraftButtonText = PopUpDraftButton.getText();
       
            if(Verify.compareSingleString(PopUpDraftButtonText, nonEnglishTextDraft, locale)){
            	Log.info("nonEnglishTextDraft is success");
                stepResult=true;
            }  
    
        String nonEnglishTextOk = otherLangTestData.getProperty("LANG_MAIL_COMPOSE_ALERT_DISCARD_CONFIRM");
       
        WebElement PopUpOkButton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("DISCRAD_MAIL_POPUP_OK"),60);
        String PopUpOkButtonText = PopUpOkButton.getText();
        
            if(Verify.compareSingleString(PopUpOkButtonText, nonEnglishTextOk, locale)){
            	Log.info("nonEnglishTextOk is success");
                stepResult=true;
                
            }  
           
            Thread.sleep(8000);
            PopUpOkButton.click();

		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyVeiwText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Home Page verify View Button Text");
		String nonEnglishViewButtonText = otherLangTestData.getProperty("LANG_MAIL_LIST_VIEW");
		Thread.sleep(10000);
		WebElement Viewbutton = driver.findElement(By.xpath(elementLocatorProp.getProperty("MAIL_SECTION_VIEW_BUTTON")));
		if( Viewbutton == null)
			return false;
		String ViewbuttonText = Viewbutton.getText().trim();
		System.out.println("ViewbuttonText : "+ViewbuttonText);
		if(Verify.compareSingleString(ViewbuttonText, nonEnglishViewButtonText, locale)){
			Log.info("verifyVeiwText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyViewDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Thread.sleep(5000);
		Log.info("Verfiying View dropdwon labels text in mail tab...");
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_LIST_VIEW_DROPDOWN_VALUES").split(",");
		WebElement ViewDrpDwonBtn = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_SECTION_VIEW_BUTTON1")));
		if(ViewDrpDwonBtn == null)
			return false;
		ViewDrpDwonBtn.click();
		Thread.sleep(3000);
		//waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_VIEW_DROPDOWN_ITEMS_XPATH")));
		List<WebElement> lsViewDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("MAIL_VIEW_DROPDOWN_ITEMS_XPATH")));
		//String viewValue="(//ng-transclude/span)["+i+"]";
		for(WebElement label:lsViewDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		/*for (int j = 7; j < 10; j++) {
			String viewValue="(//ng-transclude/span)["+j+"]";
			WebElement element=driver.findElement(By.xpath(viewValue));
			String temp = element.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(element.getText().trim());
			}
		}*/
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("verifyViewDropDownLabels is success");
			stepResult=true;
						
		}
		ViewDrpDwonBtn.click();
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySortbyText()throws Exception{
		boolean stepResult = false;
		Thread.sleep(3000);
		Log.info("Inside Mail Home Page verify Sort By Text");
		String nonEnglishSortByText = otherLangTestData.getProperty("LANG_MAIL_LIST_SORT_BY_UID"); 
		WebElement SortBy = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_SORTBY_TEXT_XPATH")));  
		//WebElement IDFilter = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_SORTBY_TEXT_FILTER_XPATH")));
		if( SortBy == null)
			return false;
		WebElement sortByxpath=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_SORTBY_TEXT_XPATH1"))); 
		String SortByText1 = SortBy.getText();
		System.out.println("values are :"+SortByText1);
		String SortByText=SortByText1.replace(sortByxpath.getText().trim(), "");
		System.out.println(" ID value is :"+SortByText+"Test");
		if(Verify.compareSingleString(SortByText.trim(), nonEnglishSortByText, locale)){
			Log.info("verifySortbyText is success");
			stepResult=true;
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySortByDropDownlabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();		
		Log.info("Verfiying SortBy labels text in mail tab...");	
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_LIST_SORT_BY_DROPDOWN_VALUES").split(",");
	
		WebElement SortbyDrpDownBtn = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_SORTBY_DROPDOWN_XPATH")));
		Thread.sleep(5000);
		if(SortbyDrpDownBtn == null)
			return false;
		SortbyDrpDownBtn.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_SORTBY_DROPDOWN_VALUES_XPATH")));
		List<WebElement> lsSortByDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("MAIL_SORTBY_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsSortByDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("verifySortByDropDownlabels is success");
			stepResult=true;
			
		}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCoreFoldernamelabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying Folder Name labels text in mail tab...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("FOLDER_NAME_VALUES").split(",");

		WebElement Corefolders = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("FOLDER_NAMES_TEXT_XPATH")));

		if (Corefolders == null)
			return false;

		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("FOLDER_SPAM_CLICKABLE_XPATH")));
		List<WebElement> lsFoldernameLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("FOLDER_NAMES_TEXT_XPATH")));
		for (WebElement label : lsFoldernameLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyCoreFoldernamelabels is success");
			stepResult = true;

		}
		
		return stepResult;
	}
	
	public boolean verifyPaginationText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Home Page verify Pagination Text");
		String nonEnglishSortByText = otherLangTestData.getProperty("LANG_MAIL_LIST_ITEMS_OF");
	
		
		WebElement PaginationText = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("PAGINATION_TEXT_XPATH"),60);
		if( PaginationText == null)
			return false;
		String PageCount = PaginationText.getText();
		
		
			if(Verify.compareSingleString(PageCount, nonEnglishSortByText, locale)){
				System.out.println("verifyPaginationText :"+true);
				stepResult=true;
			}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean validateComposeMailToolTipText() throws Exception {

		boolean stepResult = false;
		String nonEnglishTooltip = otherLangTestData.getProperty("LANG_COMPOSE_A_NEW_MESSAGE");

		Actions builder = new Actions(driver);
		WebElement composeMailToolTip = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_XPATH")));
		builder.moveToElement(composeMailToolTip).perform();
		String tooltip_msg = composeMailToolTip.getAttribute("data-original-title");
		Log.info("Compose Mail Tool tip value : " + tooltip_msg);

		if (Verify.compareSingleString(tooltip_msg, nonEnglishTooltip, locale)) {
			Log.info("validateComposeMailToolTipText is success");
			stepResult = true;
			Thread.sleep(3000);
		}

		return stepResult;

	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyComposedropdownenamelabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying Compose Dropdown Name labels text in mail tab...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_SOCIAL_DROPDOWN_VALUES").split(",");

		WebElement Composedropdownvalues = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_DROPDOWN_XPATH"), 60);

		if (Composedropdownvalues == null)
			return false;
		Composedropdownvalues.click();

		/*waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_DROPDOWN_VALUES_XPATH"), 60);
		List<WebElement> lsComposedrpdwnnameLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsComposedrpdwnnameLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}*/
		for (int j = 5; j < 7; j++) {
			String viewValue="(//ng-transclude/span)["+j+"]";
			WebElement element=driver.findElement(By.xpath(viewValue));
			String temp = element.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(element.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyComposedropdownenamelabels is success");
			stepResult = true;

		}
		Composedropdownvalues.click();
		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_XPATH"), 60);
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifycomposeNewMessageText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside Mail Compose Page verify New Message Text");
		String nonEnglishNewMessageText = otherLangTestData.getProperty("LANG_MAIL_COMPOSE_NEW_MESSAGE");
	
		WebElement Composemail = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_XPATH"), 60);
		if (Composemail == null)
			return false;
		Composemail.click();
		Thread.sleep(25000);
		WebElement NewMessage = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_COMPOSE_NEW_MESSAGE_XPATH"), 120);
		String NewMessageText = NewMessage.getText();

		if (Verify.compareSingleString(NewMessageText, nonEnglishNewMessageText, locale)) {
			Log.info("verifycomposeNewMessageText is success");
			stepResult = true;
		}

		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyComposeTopRightButtonslabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying Composing Mail  top right buttons labels text in composemail tab...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_COMPOSE_TOP_RIGHT_SIDE_BUTTONS_VALUES")
				.split(",");

		WebElement ComposeTopRightvalues = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_COMPOSE_TOP_RIGHT_SIDE_BUTTONS_XPATH"), 60);

		if (ComposeTopRightvalues == null)
			return false;

		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_COMPOSE_TOP_RIGHT_SIDE_BUTTONS_XPATH"), 60);
		List<WebElement> lsComposeRightTopnameLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("MAIL_COMPOSE_TOP_RIGHT_SIDE_BUTTONS_XPATH")));
		for (WebElement label : lsComposeRightTopnameLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyComposeTopRightButtonslabels is success");
			stepResult = true;

		}

		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyComposeHeaderlabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Composing Mail  Hearder labels text in composemail tab...");
		
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_COMPOSE_HEADERS_VALUES").split(",");
	
		WebElement ComposeHeaderLabelsText = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_COMPOSE_HEADERS_TEXT_XPATH"), 60);
		
		if(ComposeHeaderLabelsText == null)
			return false;
				
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_COMPOSE_HEADERS_TEXT_XPATH"), 60);
		List<WebElement> lsComposeHeadernameLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("MAIL_COMPOSE_HEADERS_TEXT_XPATH")));
		for(WebElement label:lsComposeHeadernameLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("verifyComposeHeaderlabels is success");
			stepResult=true;
			
		}
		Thread.sleep(5000);
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyInboxStatusMessageText()throws Exception{
        boolean stepResult = false;
       
        Log.info("Inside Mail Home Page verify Emails Text message");
        String nonEnglishText = otherLangTestData.getProperty("LANG_MAIL_LIST_MSG_NONE_SELECTED_HEADER");
              
        WebElement InboxMsgText = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_INBOX_CURRENT_MSG_TEXT_XPATH")));
        if( InboxMsgText == null)
            return false;
        String InboxMailStatus = InboxMsgText.getText();
       
            if(Verify.compareSingleString(InboxMailStatus, nonEnglishText, locale)){
            	Log.info("verifyInboxStatusMessageText is success");
                stepResult=true;
            }
            if (!InboxMailStatus.isEmpty()) {
            	Log.info("verifyInboxStatusMessageText is success");
                stepResult=true;
			}
       
        return stepResult;
    }
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPFolderText()throws Exception{
        boolean stepResult = false;
       
        Log.info("Inside Mail Home Page verify Default Personal Folder Name Text message");
        String nonEnglishText = otherLangTestData.getProperty("LANG_MAIL_FOLDERS");
        WebElement PfolderText = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_INBOX_DEFAULT_FOLDER_TEXT_XPATH")));
        if( PfolderText == null)
            return false;
          String FolderText = PfolderText.getText();     
       
            if(Verify.compareSingleString(FolderText, nonEnglishText, locale)){
            	Log.info("verifyPFolderText is success");
                stepResult=true;
            }
       
        return stepResult;
    }
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean validatefolderToolTipText()throws Exception{

        boolean stepResult = false;
        String nonEnglishTooltip = otherLangTestData.getProperty("LANG_MAIL_BUTTON_CREATE_NEW_FOLDER");     
        Actions builder=new Actions(driver);
        WebElement folderlToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("MAIL_PFOLDER_TOOLTIP_XPATH")));
        builder.moveToElement(folderlToolTip).perform();
        String tooltip_msg=folderlToolTip.getAttribute("data-original-title");
        Log.info("Tool tip value : " + tooltip_msg);       
            if(Verify.compareSingleString(tooltip_msg, nonEnglishTooltip, locale)){
            	Log.info("validatefolderToolTipText is success");
                stepResult=true;
            }
       
        return stepResult;   
    }

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyfoldertogglelabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying First Folder toggle labels text in folder section...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_MAIL_FOLDER_TOGGLE_VALUES").split(",");
		Actions builder = new Actions(driver);
		WebElement fistfolder = driver.findElement(By.xpath(elementLocatorProp.getProperty("MAIL_FIRST_FOLDR_XPATH")));
		builder.moveToElement(fistfolder).perform();

		WebElement folderToggle = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("MAIL_FIRST_FOLDR_TOGGLE_XPATH")));

		if (folderToggle == null)
			return false;
		folderToggle.click();
		waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("MAIL_FOLDER_TOGGLE_VALUES_XPATH")));
		List<WebElement> lsFolderToggeleLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("MAIL_FOLDER_TOGGLE_VALUES_XPATH")));
		for (WebElement label : lsFolderToggeleLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyfoldertogglelabels is success");
			stepResult = true;

		}
		Thread.sleep(8000);
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPfolderMailStatusText() throws Exception {
		boolean stepResult = false;

		Log.info("Inside Mail Page verify first folder Status Text");
		String nonEnglishNewMessageText = otherLangTestData.getProperty("LANG_MAIL_LIST_MSG_NO_MAIL");

		WebElement firstfolder = waitForElementVisibility(
				By.xpath(elementLocatorProp.getProperty("MAIL_FIRST_FOLDR_XPATH")));
		if (firstfolder == null)
			return false;
		firstfolder.click();
		WebElement NewMessage = waitForElementVisibility(
				By.xpath(elementLocatorProp.getProperty("MAIL_FIRST_FOLDR_MAIL_STATUS_XPATH")));
		String NewMessageText = NewMessage.getText();

		if (Verify.compareSingleString(NewMessageText, nonEnglishNewMessageText, locale)) {
			Log.info("verifyPfolderMailStatusText is success");
			stepResult = true;
		}

		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifydeletefolderpopup() throws Exception {
		boolean stepResult = false;

		Log.info("Verifying POP UP For Delete Folder Text");
		String headernonEnglishText = otherLangTestData.getProperty("LANG_MAIL_FOLDER_CONFIRM_DELETE_TITLE");
		WebElement Deletefolder = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("MAIL_FOLDER_TOGGLE_DELETE_XPATH")));
		Deletefolder.click();
		Thread.sleep(8000);
		WebElement PopUpHeader = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_HEADER")));
		String PopUpHeaderText = PopUpHeader.getText();

		if (Verify.compareSingleString(PopUpHeaderText, headernonEnglishText, locale)) {
			Log.info("PopUpHeader is success");
			stepResult = true;
		}
		String bodynonEnglishText = otherLangTestData.getProperty("LANG_MAIL_FOLDER_CONFIRM_DELETE_TEXT");

		WebElement PopUpBody = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_BODY")));
		String PopUpBodyText = PopUpBody.getText();

		if (Verify.compareSingleString(PopUpBodyText, bodynonEnglishText, locale)) {
			Log.info("PopUpBody is success");
			stepResult = true;
		}

		String nonEnglishTextNo = otherLangTestData.getProperty("LANG_NO");

		WebElement PopUpNoButton = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_NO"), 60);
		String PopUpNoButtonText = PopUpNoButton.getText();

		if (Verify.compareSingleString(PopUpNoButtonText, nonEnglishTextNo, locale)) {
			Log.info("nonEnglishTextNo is success");
			stepResult = true;
		}

		String nonEnglishTextYes = otherLangTestData.getProperty("LANG_YES");

		WebElement PopUpYesButton = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_YES"), 60);
		String PopUpYesButtonText = PopUpYesButton.getText();

		if (Verify.compareSingleString(PopUpYesButtonText, nonEnglishTextYes, locale)) {
			Log.info("nonEnglishTextYes is success");
			stepResult = true;
		}

		WebElement CloseButton = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("DELETE_FOLDER_POPUP_CLOSE_XPATH"), 60);
		CloseButton.click();
		Thread.sleep(10000);
		System.out.println("deletefolder is :"+stepResult);
		return stepResult;
	}

	public boolean verifyEmptyfolderpopup()throws Exception{
        boolean stepResult = false;
       
        Log.info("Verifying POP UP For Empty Folder Text");
        String headernonEnglishText = otherLangTestData.getProperty("LANG_MAIL_FOLDER_EMPTY");
        WebElement folderfirst = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_FIRST_FOLDR_XPATH"), 60);
        Actions builder=new Actions(driver);
        WebElement fistfolder=driver.findElement(By.xpath(elementLocatorProp.getProperty("MAIL_FIRST_FOLDR_XPATH")));
        builder.moveToElement(fistfolder).perform();
        WebElement folderToggle = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_FIRST_FOLDR_TOGGLE_XPATH"), 60);
        if(folderToggle == null)
            return false;
        folderToggle.click();
        WebElement Emptyfolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_FOLDER_TOGGLE_EMPTY_XPATH"),60);
        Emptyfolder.click();
        WebElement Popwindow = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP"),60);
        WebElement PopUpHeader = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_HEADER"),60);
        String PopUpHeaderText = PopUpHeader.getText();
       
           if(Verify.compareSingleString(PopUpHeaderText, headernonEnglishText, locale)){
               
                stepResult=true;
            }
            String bodynonEnglishText = otherLangTestData.getProperty("LANG_MAIL_FOLDER_EMPTY_MODAL_BODY");
          
    	WebElement PopUpBody = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_BODY"),60);
    	String PopUpBodyText = PopUpBody.getText();
    	
                if(Verify.compareSingleString(PopUpBodyText, bodynonEnglishText, locale)){
                    
                    stepResult=true;
                }  
       
    	
String labelnonEnglishText = otherLangTestData.getProperty("LANG_MAIL_FOLDER_EMPTY_MODAL_DONOTSHOW");
           
    	WebElement PopUplabel = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_NOT_SHOW_AGAIN"),60);
    	String PopUplabelText = PopUplabel.getText();
    	
                if(Verify.compareSingleString(PopUplabelText, labelnonEnglishText, locale)){
                    stepResult=true;
                }  
       

    	String nonEnglishTextCancel = otherLangTestData.getProperty("LANG_CANCEL");
         WebElement PopUpCancelButton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_NO"),60);
        String PopUpCancelButtonText = PopUpCancelButton.getText();
                   if(Verify.compareSingleString(PopUpCancelButtonText, nonEnglishTextCancel, locale)){
               
                stepResult=true;
            }  
    
        String nonEnglishTextEmpty = otherLangTestData.getProperty("LANG_MAIL_FOLDER_EMPTY_MODAL_HEADER");
        
	WebElement PopUpEmptyButton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_CONTENT_POP_UP_YES"),60);
	String PopUpEmptyButtonText = PopUpEmptyButton.getText();
	
            if(Verify.compareSingleString(PopUpEmptyButtonText, nonEnglishTextEmpty, locale)){
              
                stepResult=true;
            }  
   
	WebElement CloseButton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EMPTY_FOLDER_POPUP_CLOSE_XPATH"),60);
	CloseButton.click();
	Thread.sleep(3000);
       
        return stepResult;
}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDiskUsageText() throws Exception {
		boolean stepResult = false;

		Log.info("Verifying DiskUsage Text");
		String usagenonEnglishText = otherLangTestData.getProperty("LANG_MAIL_DATAUSAGE_DISPLAY");

		WebElement Usage = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("MAIL_DISK_USAGE_TEXT_XPATH"), 60);

		if (Usage == null)
			return false;

		String UsageText = Usage.getText();

		if (Verify.compareSingleString(UsageText, usagenonEnglishText, locale)) {
			Log.info("verifyDiskUsageText is success");
			stepResult = true;
		}
		Thread.sleep(5000);
		return stepResult;

	}
}
