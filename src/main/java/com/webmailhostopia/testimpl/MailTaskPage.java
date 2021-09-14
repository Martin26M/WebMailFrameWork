package com.webmailhostopia.testimpl;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;
import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import org.openqa.selenium.interactions.Actions;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailTaskPage extends AbstractPageObject {
	public boolean verifyLabelsLanguageInTaskPage() throws Exception
	{
		Thread.sleep(5000);
		int failCounter = 0;
		if (!OpenTasks())
			failCounter++;
		if (!validateTaskToolTipText())
			failCounter++;
		if (!validateNewTaskToolTipText())
			failCounter++;
		if (!verifySearchPlaceHolderText())
			failCounter++;
		/*if (!verifyTaskSearchBarDropDownLabels())
			failCounter++;*/
		if (!verifyTasksSideLabels())
			failCounter++;
		if (!verifyQuickTaskPlaceHolderText())
			failCounter++;
		if (!verifyTagsText())
			failCounter++;
		if (!verifyAddNewPlaceHolderText())
			failCounter++;
		/*if (!verifyNotifyText())
			failCounter++;*/
				
		return (failCounter==0)?true:false;
	}
	
	public boolean verifyLabelsLanguageInCreateTaskPage() throws Exception
	{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!validatecreateNewTaskAttachmentTootip())
        	failCounter++;
		if(!verifyNewTaskHeadinglabels())
        	failCounter++;
		if(!verifytaskNamePlaceHolderText())
        	failCounter++;
		if(!verifysetDatePlaceHolderText())
        	failCounter++;
		if(!verifysetTimePlaceHolderText())
        	failCounter++;
		if(!verifyTagsPlaceHolderText())
        	failCounter++;
		if(!verifySubTaskPlaceHolderText())
        	failCounter++;
		/*if(!verifyCollabsPlaceHolderText())
        	failCounter++;*/
		/*if(!verifyTaskSetTimeDropDownLabels())
        	failCounter++;*/
		if(!verifyTaskTopRightLabels())
        	failCounter++;
		if(!verifyErrorMesgText())
        	failCounter++;

				
		return (failCounter==0)?true:false;
	}
	
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean OpenTasks() throws Exception
	  {
		  boolean stepResult = false;
		  WebElement Task= waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ICON_XPATH"), 60);
		  Task.click();
		  if(waitUntilElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_BUTTON_XPATH"))).isDisplayed()){
			  Log.info("OpenTasks is success");
			  stepResult=true;
		  }
		  Log.info("Task Section is Opened");
		return stepResult;
		  
	  }
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean validateTaskToolTipText() throws Exception {

		boolean stepResult = false;
		String nonEnglishTooltip = otherLangTestData.getProperty("LANG_TASKBOX");

		Actions builder = new Actions(driver);
		WebElement taskToolTip = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("TASK_ICON_TOOLTIP_XPATH")));
		builder.moveToElement(taskToolTip).perform();
		String taskToolTip_msg = taskToolTip.getAttribute("screen-reader-text");
		Log.info("Tool tip value : " + taskToolTip);

		if (Verify.compareSingleString(taskToolTip_msg, nonEnglishTooltip, locale)) {
			Log.info("validateTaskToolTipText is success");
			stepResult = true;
		}

		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean validateNewTaskToolTipText() throws Exception {

		boolean stepResult = false;
		String nonEnglishTooltip = otherLangTestData.getProperty("LANG_TASKS_ADDNEWTASK");

		Actions builder = new Actions(driver);
		WebElement NewTaskToolTip = driver
				.findElement(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_BUTTON_XPATH")));
		builder.moveToElement(NewTaskToolTip).perform();
		String NewTaskToolTip_msg = NewTaskToolTip.getAttribute("data-original-title");
		Log.info("Tool tip value : " + NewTaskToolTip_msg);

		if (Verify.compareSingleString(NewTaskToolTip_msg, nonEnglishTooltip, locale)) {
			Log.info("validateNewTaskToolTipText is success");
			stepResult = true;
		}

		return stepResult;
	}
	
	
	public boolean verifyWelcomeTasklabels()throws Exception{
        boolean stepResult = false;
        List<String> lsLabelText = new ArrayList<String>();
       
        Log.info("Verfiying Task Welcome labels text in Task Section...");
       
        
        String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_TASK_ZERO_GR").split(",");
   
        waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ADDNEW_TASK_BUTTON_XPATH"), 60);
        List<WebElement> lstaskWelcomeLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("TASK_WELCOME_TEXT_XPATH")));
        for(WebElement label:lstaskWelcomeLabels){
            String temp = label.getText().trim();
            if( !temp.isEmpty()){
                lsLabelText.add(label.getText().trim());
            }
        }
        String[] actuals = new String[lsLabelText.size()];
        actuals = lsLabelText.toArray(actuals);

        if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
            
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
		String nonEnglishSearchBarText = otherLangTestData.getProperty("TASK_SEARCHBOX_PLACEHOLDER_TEXT");
		
		
		WebElement searchBarPlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_SEARCHBOX_XPATH"), 60);
		if( searchBarPlaceHolder == null)
			return false;
		String searchBarPlaceHolderText = searchBarPlaceHolder.getAttribute("placeholder");
		
		
			if(Verify.compareSingleString(searchBarPlaceHolderText, nonEnglishSearchBarText, locale)){
				Log.info("verifySearchPlaceHolderText is success");
				stepResult=true;
			}
		Thread.sleep(5000);
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTaskSearchBarDropDownLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying search bar dropdwon labels text in Task tab...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_TASKS_SEARCH_BY_TITLE_SUBTASKS_NOTES")
				.split(",");
		Thread.sleep(8000);
		/*WebElement searchBarDrpDwonBtn = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("TASK_SEARCHBOX_DROPDOWN_XPATH")));	*/
		WebElement searchBarDrpDwonBtn = waitForElementVisibility(By.xpath(
						elementLocatorProp.getProperty("TASK_SEARCHBOX_XPATH")));
		searchBarDrpDwonBtn.sendKeys(Keys.TAB);
		searchBarDrpDwonBtn.sendKeys(Keys.ENTER);
		System.out.println("tabbbbb");
		Thread.sleep(8000);
		if (searchBarDrpDwonBtn == null)
			return false;
		//searchBarDrpDwonBtn.click();
		List<WebElement> lsSearchBarDropdownLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("TASK_SEARCHBOX_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsSearchBarDropdownLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyTaskSearchBarDropDownLabels is success");
			stepResult = true;

		}
		searchBarDrpDwonBtn.click();
		//executor.executeScript("arguments[0].click()", searchBarDrpDwonBtn);
		Thread.sleep(2000);
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTasksSideLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying All Tasks Side labels text in Task tab...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_TASKS_ALL_TODAY_WEEK_LATER_ARCHIVE").split(",");

		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ADDNEW_TASK_BUTTON_XPATH"),
				60);
		List<WebElement> lsTaskLabels = driver
				.findElements(By.xpath(elementLocatorProp.getProperty("TASK_SIDEPANEL_COREFOLDERS_TEXT_XPATH")));
		for (WebElement label : lsTaskLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyTasksSideLabels is success");
			stepResult = true;

		}

		return stepResult;
	}

	public boolean verifyQuickTaskPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Quick Task placeholder text method");
		String nonEnglishText = otherLangTestData.getProperty("LANG_TASKS_NEWTASK_CREATE");
		
		
		WebElement QuickTaskPlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_QUICKTASK_PLACEHOLDER_XPATH"), 60);
		if(!QuickTaskPlaceHolder.isDisplayed())
			return false;
		String QuickTaskPlaceHolderText = QuickTaskPlaceHolder.getAttribute("placeholder");
		
		
			if(Verify.compareSingleString(QuickTaskPlaceHolderText, nonEnglishText, locale)){
				Log.info("verifyQuickTaskPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTagsText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Tags text method");
		String nonEnglishTagText = otherLangTestData.getProperty("LANG_TASKS_TAGS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_SIDEPANEL_TAGS_PLUS_XPATH")));
		WebElement Tag = driver.findElement(By.xpath(elementLocatorProp.getProperty("TASK_SIDEPANEL_TAGS_TEXT_XPATH")));
		if( Tag == null)
			return false;
		String TagText = Tag.getText();
		
	
			if(Verify.compareSingleString(TagText, nonEnglishTagText, locale)){
				Log.info("verifyTagsText is success");
				stepResult=true;
			
		}
		return stepResult;
	}
	
	public boolean verifyAddNewPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Add new Tag placeholder text method");
		String nonEnglishText = otherLangTestData.getProperty("LANG_TASKS_NEWTAGADD");
		
		
		WebElement TagPlus = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_SIDEPANEL_TAGS_PLUS_XPATH"), 60);
			TagPlus.click();
			Thread.sleep(3000);
			WebElement NewTagPlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_SIDEPANEL_TAGS_INPUTTAG_PLACEHOLDER_XPATH"), 60);
			String NewTagPlaceHolderText = NewTagPlaceHolder.getAttribute("placeholder");
				
		
			if(Verify.compareSingleString(NewTagPlaceHolderText, nonEnglishText, locale)){
				Log.info("verifyAddNewPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNotifyText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Tasks Notification text method");
		String nonEnglishNotificationText = otherLangTestData.getProperty("LANG_TASKS_LISTLOAD");
		
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_SIDEPANEL_TAGS_PLUS_XPATH"), 60);
		WebElement Notification = driver.findElement(By.xpath(elementLocatorProp.getProperty("TASK_SECTION_GROWL_NOTIFICATION_XPATH")));
		if( Notification == null)
			return false;
		String NotificationText = Notification.getText();
		
		
			if(Verify.compareSingleString(NotificationText, nonEnglishNotificationText, locale)){
				Log.info("verifyNotifyText is success");
				stepResult=true;
			
		}
		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean validatecreateNewTaskAttachmentTootip() throws Exception {

		boolean stepResult = false;
		WebElement NewTaskButton = waitForElementVisibility(By.xpath(
				elementLocatorProp.getProperty("TASK_ADDNEW_TASK_BUTTON_XPATH")));
		NewTaskButton.click();
		if(waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ATTACHMENT_TOOLTIP_XPATH"))).isDisplayed()){
			Log.info("validatecreateNewTaskAttachmentTootip is success");
			stepResult = true;
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewTaskHeadinglabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying New Task Heading labels text in Task Section...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_TASKS_TAGS_SUBTASK_COLLABORATORS_NOTES")
				.split(",");

		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_TASKNAME_PLACEHOLDER_XPATH")));
		List<WebElement> lstaskHeadLabels = driver
				.findElements(By.cssSelector(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_CONTENT_XPATH")));
		for (WebElement label : lstaskHeadLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyNewTaskHeadinglabels is success");
			stepResult = true;

		}

		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifytaskNamePlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify TaskName placeholder text method");
		String nonEnglishTaskNameText = otherLangTestData.getProperty("LANG_TASKS_NEWTASK_PLH");
				
		WebElement TaskNamePlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_TASKNAME_PLACEHOLDER_XPATH")));
		if(TaskNamePlaceHolder == null)
			return false;
		String TaskNamePlaceHolderText = TaskNamePlaceHolder.getAttribute("placeholder");
		
		if(Verify.compareSingleString(TaskNamePlaceHolderText, nonEnglishTaskNameText, locale)){
			Log.info("verifytaskNamePlaceHolderText is success");
			stepResult=true;
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifysetDatePlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Set Date placeholder text method");
		String nonEnglishsetDateText = otherLangTestData.getProperty("LANG_TASKS_SETDUEDATE");
			
		WebElement setDatePlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_SETDATE_PLACEHOLDER_XPATH")));
		if(setDatePlaceHolder == null)
			return false;
		String setDatePlaceHolderText = setDatePlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(setDatePlaceHolderText, nonEnglishsetDateText, locale)){
				Log.info("verifysetDatePlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifysetTimePlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Set Time placeholder text method");
		String nonEnglishsetTimeText = otherLangTestData.getProperty("LANG_TASKS_SETDUETIME");
			
		WebElement setTimePlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_SETTIME_PLACEHOLDER_XPATH")));
		if(setTimePlaceHolder == null)
			return false;
		String setTimePlaceHolderText = setTimePlaceHolder.getAttribute("placeholder");
		
		if(Verify.compareSingleString(setTimePlaceHolderText, nonEnglishsetTimeText, locale)){
			Log.info("verifysetTimePlaceHolderText is success");
			stepResult=true;
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTagsPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify tags placeholder text method");
		String nonEnglishTagsText = otherLangTestData.getProperty("LANG_TASKS_ADD_TAGS");
		
		WebElement TagsPlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_TAGS_PLACEHOLDER_XPATH")));
		if(TagsPlaceHolder == null)
			return false;
		String TagsPlaceHolderText = TagsPlaceHolder.getAttribute("placeholder");
		
		
			if(Verify.compareSingleString(TagsPlaceHolderText, nonEnglishTagsText, locale)){
				Log.info("verifyTagsPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySubTaskPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Sub taska placeholder text method");
		String nonEnglishsubTaskText = otherLangTestData.getProperty("LANG_TASKS_ADDNEWSUBTASK");
				
		WebElement subTaskPlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ADDNEW_TASK_SUBTASKS_PLACEHOLDER_XPATH"), 60);
		if(subTaskPlaceHolder == null)
			return false;
		String subTaskPlaceHolderText = subTaskPlaceHolder.getAttribute("placeholder");
		
			System.out.println("sub task :"+subTaskPlaceHolderText);
			if(Verify.compareSingleString(subTaskPlaceHolderText, nonEnglishsubTaskText, locale)){
				Log.info("verifySubTaskPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCollabsPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Collaborators placeholder text method");
		String nonEnglishsetDateText = otherLangTestData.getProperty("LANG_TASKS_ADDCOLAB");
		
		
		WebElement setDatePlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_COLLAB_PLACEHOLDER_XPATH")));
		if(setDatePlaceHolder == null)
			return false;
		String setDatePlaceHolderText = setDatePlaceHolder.getAttribute("placeholder");
		
		
			if(Verify.compareSingleString(setDatePlaceHolderText, nonEnglishsetDateText, locale)){
				Log.info("verifyCollabsPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTaskSetTimeDropDownLabels() throws Exception {
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();

		Log.info("Verfiying SetTime bar dropdwon labels text in Task tab...");

		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_TASKS_DUETIME_DROPDOWN_VALUES_TEXT")
				.split(",");

		WebElement SetTimeDrpDwonBtn = waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("TASK_ADDNEW_TASK_SETTIME_DROPDOWN_XPATH"), 60);

		if (SetTimeDrpDwonBtn == null)
			return false;
		SetTimeDrpDwonBtn.click();

		waitForElementToBeClickable(ByLocator.xpath,
				elementLocatorProp.getProperty("TASK_ADDNEW_TASK_SETTIME_DROPDOWN_VALUES_XPATH"), 60);
		List<WebElement> lsSetTimeDropdownLabels = driver.findElements(
				By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_SETTIME_DROPDOWN_VALUES_XPATH")));
		for (WebElement label : lsSetTimeDropdownLabels) {
			String temp = label.getText().trim();
			if (!temp.isEmpty()) {
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		System.out.println(actuals);

		if (Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)) {
			Log.info("verifyTaskSetTimeDropDownLabels is success");
			stepResult = true;

		}
		SetTimeDrpDwonBtn.click();
		Thread.sleep(2000);
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTaskTopRightLabels()throws Exception{
	boolean stepResult = false;
	List<String> lsLabelText = new ArrayList<String>();
	
	Log.info("Verfiying TopRight bar labels text in Task tab...");
	
	
	String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CANCEL_ADD").split(",");

	WebElement TopRightLabels = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ADDNEW_TASK_SETTIME_DROPDOWN_XPATH"), 60);
	
	if(TopRightLabels == null)
		return false;
			
	List<WebElement> lsTopRightLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_TOP_RIGHT_BUTTON_LABELS_XPATH")));
	for(WebElement label:lsTopRightLabels){
		String temp = label.getText().trim();
		if( !temp.isEmpty()){
			lsLabelText.add(label.getText().trim());
		}
	}
	String[] actuals = new String[lsLabelText.size()];
	actuals = lsLabelText.toArray(actuals);

	if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
		Log.info("verifyTaskTopRightLabels is success");
		stepResult=true;
	
		
	}
	
	return stepResult;
}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyErrorMesgText()throws Exception{
	boolean stepResult = false;
	
	Log.info("Inside verify Error Message text method");
	String nonEnglishErrorText = otherLangTestData.getProperty("LANG_TASKS_ERRORS_NOTASKNAME");
	WebElement Add = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ADDNEW_TASK_ADD_BUTTON_XPATH"), 60);
	Add.click();
	waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ADDNEW_TASK_ERROR_MESG_CLOSE_XPATH"), 60);
	WebElement Error = driver.findElement(By.xpath(elementLocatorProp.getProperty("TASK_ADDNEW_TASK_ERROR_MESSAGE_TEXT_XPATH")));
	if( Error == null)
		return false;
	String ErrorText = Error.getText();
	
	
		if(Verify.compareSingleString(ErrorText, nonEnglishErrorText, locale)){
			
			stepResult=true;
			Log.info("verifyErrorMesgText is success");
		//	Close.click();
		}
		WebElement Close = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("TASK_ADDNEW_TASK_ERROR_MESG_CLOSE_XPATH"), 60);
		Close.click();
		Thread.sleep(2000);
	return stepResult;
}

}
