package com.webmailhostopia.testimpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;
import java.util.ArrayList;
import java.util.List;

public class MailCalendarSection extends AbstractPageObject {
	
	public boolean verifyLabelsLanguageInCalendarHomePage()throws Exception{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!OpenCalendar())
			failCounter++;
		if(!validateCalendarToolTipText())
            failCounter++;
	   if(!validateAgendaToolTipText())
            failCounter++;
	   	if(!validateDayToolTipText())
            failCounter++;
		if(!validateWeekToolTipText())
            failCounter++;
		if(!validateMonthToolTipText())
            failCounter++;
		/*if(!verifyMonthrowHeaderlabels())
			failCounter++;*/
		if(!validateCalendarToolTipText())
            failCounter++;
		if(!verifySearchPlaceHolderText())
            failCounter++;
		if(!verifyCalSearchBarDropDownLabels())
            failCounter++;
		if(!verifyTodayText())
            failCounter++;
		/*if(!verifyMonthText())
            failCounter++;*/
		if(!verifyMyCalText())
            failCounter++;
		/*if(!verifyShareCalText())
            failCounter++;*/
		Thread.sleep(5000);
		return (failCounter==0)?true:false;
	}
	
	
	public boolean verifyLabelIsLanguageInCreateEventPage() throws Exception
	{
		int failCounter = 0;
		Thread.sleep(7000);
		if(!verifyCreateEventTooltip())
			failCounter++;
		if(!validatecreateAttachmentTootip())
			failCounter++;
		if(!verifyNewEventText())
            failCounter++;
		if(!verifyDatesNTimeLabelText())
            failCounter++;
		if(!verifyEventOtherLabelsText())
            failCounter++;
		if(!verifyEditEventTablabels())
			failCounter++;
		if(!verifyEventToplabels())
			failCounter++;
		if(!verifyAlertDropdownlabels())
			failCounter++;
		if(!verifyAttendeesLabelsText())
            failCounter++;
		
		return (failCounter==0)?true:false;
	}

	public boolean verifyLabelIsLanguageInRepeatEventPage() throws Exception
	{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!verifyRepeatEventLabelText())
            failCounter++;
		if(!verifyRepeatEventDropDownLabels())
           failCounter++;
		if(!DaysVerification())
            failCounter++;			
		return (failCounter==0)?true:false;
	}
	
	
    public boolean OpenCalendar() throws Exception
  {
	  boolean stepResult = false;
	  WebElement Cal= waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_ICON_XPATH"), 60);
	  Cal.click();
	  if(waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("NEW_EVENT_BUTTON_XPATH"), 60).isDisplayed()){
		  Log.info("Calendar Section is Opened");	  
		  stepResult=true;
	  }
	  return stepResult;
  }

	public boolean validateCalendarToolTipText()throws Exception{

        boolean stepResult = false;
        String nonEnglishTooltip = otherLangTestData.getProperty("LANG_CALENDAR");
       
        Actions builder=new Actions(driver);
        WebElement calToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("CALENDAR_ICON_XPATH")));
        builder.moveToElement(calToolTip).perform();
        String Caltooltip_msg=calToolTip.getText();
        Log.info("Tool tip value : " + Caltooltip_msg);
        if(Verify.compareSingleString(Caltooltip_msg, nonEnglishTooltip, locale))
        {
        	Log.info("validateCalendarToolTipText is success");
            stepResult=true;
            
        }
               
        return stepResult;   
    }

	public boolean validateAgendaToolTipText()throws Exception{

        boolean stepResult = false;
        String nonEnglishAgendaTooltip = otherLangTestData.getProperty("LANG_AGENDA_VIEW");
       // String englishAgendaToolTip = engTestData.getProperty("AGENDA_VIEW_TOOLTIP");
        waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("AGENDA_VIEW_BUTTON_XPATH"), 60);
        Actions builder=new Actions(driver);
        WebElement agendaToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("AGENDA_VIEW_BUTTON_XPATH")));
        builder.moveToElement(agendaToolTip).perform();
        String Agendatooltip_msg=agendaToolTip.getAttribute("data-original-title");
        Log.info("Tool tip value : " + Agendatooltip_msg);
        if(Verify.compareSingleString(Agendatooltip_msg, nonEnglishAgendaTooltip, locale))
          {
               stepResult=true;
            }
       
        return stepResult;   
    }

	public boolean validateDayToolTipText()throws Exception{

        boolean stepResult = false;
        String nonEnglishTooltip = otherLangTestData.getProperty("LANG_DAY_VIEW");
        Actions builder=new Actions(driver);
        WebElement dayToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("DAY_VIEW_BUTTON_XPATH")));
        builder.moveToElement(dayToolTip).perform();
        String tooltip_msg=dayToolTip.getAttribute("data-original-title");
        Log.info("Tool tip value : " + tooltip_msg);
       if(Verify.compareSingleString(tooltip_msg, nonEnglishTooltip, locale))
            {
               System.out.println("validateDayToolTipText is success");
                stepResult=true;
            }
        
        return stepResult;   
    }
	
	public boolean validateWeekToolTipText()throws Exception{

        boolean stepResult = false;
        String nonEnglishTooltip1 = otherLangTestData.getProperty("LANG_WEEK_VIEW");
        Actions builder=new Actions(driver);
        WebElement weekToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("WEEK_VIEW_BUTTON_XPATH")));
        builder.moveToElement(weekToolTip).perform();
        String tooltip1_msg=weekToolTip.getAttribute("data-original-title");
       // Log.info("Tool tip value : " + tooltip1_msg);
        if(Verify.compareSingleString(tooltip1_msg, nonEnglishTooltip1, locale))
        {
        	stepResult=true;
            }
        
        return stepResult;   
    }

	public boolean validateMonthToolTipText()throws Exception{

        boolean stepResult = false;
        String nonEnglishTooltip2 = otherLangTestData.getProperty("LANG_MONTH_VIEW");
        Actions builder=new Actions(driver);
        WebElement monthToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("MONTH_VIEW_BUTTON_XPATH")));
        builder.moveToElement(monthToolTip).perform();
        String tooltip2_msg=monthToolTip.getAttribute("data-original-title");
        Log.info("Tool tip value : " + tooltip2_msg);
        if(Verify.compareSingleString(tooltip2_msg, nonEnglishTooltip2, locale))
        	{
             stepResult=true;
            }
       
        return stepResult;   
    }


	public boolean verifyMonthrowHeaderlabels()throws Exception{
        boolean stepResult = false;
      //  driver.navigate().refresh();
        List<String> lsLabelText = new ArrayList<String>();
       
        Log.info("Verfiying Month Row Header labels text in Calendar Section...");
        String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CAL_ROW_HEADINGS_VALUES").split(",");
   
        waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_MONTH_XPATH"), 60);
        List<WebElement> lsmonthHeadernameLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("MONTH_CAL_ROW_HEADINGS_XPATH")));
        for(WebElement label:lsmonthHeadernameLabels){
            String temp = label.getText().trim();
            if( !temp.isEmpty()){
                lsLabelText.add(label.getText().trim());
            }
        }
        String[] actuals = new String[lsLabelText.size()];
        actuals = lsLabelText.toArray(actuals);
        if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale))
        {
            stepResult=true;
         }
       
        return stepResult;
    }

	public boolean validateNewEventToolTipText()throws Exception{

        boolean stepResult = false;
        String nonEnglishTooltip = otherLangTestData.getProperty("LANG_CREATE_A_NEW_EVENT");
        Actions builder=new Actions(driver);
        WebElement NewEventToolTip=driver.findElement(By.xpath(elementLocatorProp.getProperty("NEW_EVENT_BUTTON_XPATH")));
        builder.moveToElement(NewEventToolTip).perform();
        String tooltip_msg=NewEventToolTip.getText();
        Log.info("Tool tip value : " + tooltip_msg);
        if(Verify.compareSingleString(tooltip_msg, nonEnglishTooltip, locale)){
               stepResult=true;
            }
        return stepResult;   
    }

	public boolean verifySearchPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify search placeholder text method");
		String nonEnglishSearchBarText = otherLangTestData.getProperty("CAL_SEARCH_BOX_PLACEHOLDER");
		WebElement searchBarPlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("SEARCH_BAR_PLACE_HOLDER_TEXT"), 60);
		if( searchBarPlaceHolder == null)
			return false;
		String searchBarPlaceHolderText = searchBarPlaceHolder.getAttribute("placeholder");
		if(Verify.compareSingleString(searchBarPlaceHolderText, nonEnglishSearchBarText, locale)){
				stepResult=true;
			}
		
		return stepResult;
	}

	public boolean verifyCalSearchBarDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying search bar dropdwon labels text in Calendar tab...");
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CALENDAR_SEARCH_BY_DROPDOWN_VALUES").split(",");
		WebElement searchBarDrpDwonBtn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_BAR_DROPDWON_BUTTON_XPATH"), 60);
		
		if(searchBarDrpDwonBtn == null)
			return false;
		searchBarDrpDwonBtn.click();
		
		//waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_SEARCH_BAR_DROPDOWN_ITEMS_XPATH"), 60);
		List<WebElement> lsSearchBarDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("CAL_SEARCH_BAR_DROPDOWN_ITEMS_XPATH")));
		for(WebElement label:lsSearchBarDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			stepResult=true;
			Thread.sleep(2000);
		}
		searchBarDrpDwonBtn.click();
		return stepResult;
	}

	public boolean verifyTodayText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Today Button text method");
		String nonEnglishTodayText = otherLangTestData.getProperty("LANG_CALENDAR_TODAY");
		WebElement Today = driver.findElement(By.xpath(elementLocatorProp.getProperty("CAL_TODAY_BUTTON_XPATH")));
		if( Today == null)
			return false;
		String TodayText = Today.getText();
		if(Verify.compareSingleString(TodayText, nonEnglishTodayText, locale)){
				stepResult=true;
			}
		
		return stepResult;
	}

	public boolean verifyMonthText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Month text method");
		String nonEnglishMonthText = otherLangTestData.getProperty("CAL_MONTH_TEXT");
		WebElement Month = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_MONTH_XPATH"), 60);
		if( Month == null)
			return false;
		if(Month.isDisplayed()){
			stepResult=true;
		}
		/*String MonthText = Month.getText();
			if(Verify.compareSingleString(MonthText, nonEnglishMonthText, locale)){
			stepResult=true;
			}*/
		
		return stepResult;
	}

	public boolean verifyMyCalText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify My Calendars text method");
		String nonEnglishMyCalText = otherLangTestData.getProperty("LANG_CALENDAR_MY_CALENDARS");
		
		WebElement MyCal = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_MYCAL_XPATH"), 60);
		if( MyCal == null)
			return false;
		String MyCalText = MyCal.getText();
		
		if(Verify.compareSingleString(MyCalText, nonEnglishMyCalText, locale)){
			stepResult=true;
			}
		
		return stepResult;
	}

	public boolean verifyShareCalText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Share Calendars text method");
		String nonEnglishShareCalText = otherLangTestData.getProperty("LANG_CALENDAR_SHARED_CALENDARS");
		WebElement ShareCal = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_SHARE_XPATH"), 60);
		if( ShareCal == null)
			return false;
		String ShareCalText = ShareCal.getText();
		
		if(Verify.compareSingleString(ShareCalText, nonEnglishShareCalText, locale)){
				stepResult=true;
			}
		
		return stepResult;
	}


	@SuppressWarnings("unused")
	public boolean validatecreateAttachmentTootip()throws Exception{

        boolean stepResult = false;
        String nonEnglishneweventTooltip = otherLangTestData.getProperty("LANG_CALENDAR_ATTACH_FILE");
        WebElement NewEventButton = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CREATE_EVENT_BUTTON_XPATH"), 60);
        NewEventButton.click();
        Thread.sleep(10000);
        WebElement attachmentBtn = waitUntilElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTACHMENT_TOOLTIP_XPATH")));
        WebElement attachmentText = waitUntilElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTACHMENT_TOOLTIP_Text_XPATH")));
        String newEventtooltip_msg=attachmentText.getAttribute("original-title");
        System.out.println("attach file value is :"+newEventtooltip_msg);
        Log.info("Tool tip value : " + newEventtooltip_msg);
        if(Verify.compareSingleString(newEventtooltip_msg, nonEnglishneweventTooltip, locale)){
        	Log.info("validatecreateAttachmentTootip is success");
        	stepResult=true;
        }
                  
        return stepResult;   
    }

	public boolean verifyNewEventText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify NewEvent text method");
		String nonEnglishNewEventText = otherLangTestData.getProperty("LANG_CALENDAR_NEW_EVENT");
		WebElement NewEvent = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_TITLE_TEXT_XPATH"), 60);
		if( NewEvent == null)
			return false;
		String NewEventText = NewEvent.getText();
		if(Verify.compareSingleString(NewEventText, nonEnglishNewEventText, locale)){
			Log.info("verifyNewEventText is success");
			stepResult=true;
		}
		
		
		return stepResult;
	}

	@SuppressWarnings("unused")
	public boolean verifyCreateEventTooltip()throws Exception{
		boolean stepResult = false;
		Thread.sleep(5000);
		Log.info("Inside verify NewEvent tooltip method");
		String nonEnglishNewEventButtonText = otherLangTestData.getProperty("LANG_CREATE_A_NEW_EVENT_TOOLTIP");
		//Actions builder=new Actions(driver);
		WebElement NewEventButtonTip = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CREATE_EVENT_BUTTON_XPATH"), 60);
		//builder.moveToElement(NewEventButtonTip).perform();
		WebElement eventNewEventText = waitUntilElementVisibility(By.xpath(elementLocatorProp.getProperty("CREATE_EVENT_BUTTON_Text_XPATH")));
		String NewEventButtonTipText = eventNewEventText.getAttribute("data-original-title");
		Log.info("New Event Tool tip value : " + NewEventButtonTipText);
		if( NewEventButtonTip == null)
			return false;			
			if(Verify.compareSingleString(NewEventButtonTipText, nonEnglishNewEventButtonText, locale)){
				Log.info("verifyCreateEventTooltip is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	public boolean verifyDatesNTimeLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Date and Time method");
		String nonEnglishSDateText = otherLangTestData.getProperty("LANG_START_DATE");
		WebElement Sdate = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_NEW_START_DATE_LABEL_XPATH")));
		if( Sdate == null)
			return false;
		String SdateText = Sdate.getText();
		
			if(Verify.compareSingleString(SdateText, nonEnglishSDateText, locale)){
				Log.info("verifyDatesNTimeLabelText is success");
				stepResult=true;
			}
		


		String nonEnglishEDateText = otherLangTestData.getProperty("LANG_END_DATE");
		WebElement Edate = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_NEW_END_DATE_LABEL_XPATH")));
		if( Edate == null)
			return false;
		String EdateText = Edate.getText();
		
			if(Verify.compareSingleString(EdateText, nonEnglishEDateText, locale)){
				Log.info("nonEnglishEDateText is success");
				stepResult=true;
			}
		


		String nonEnglishSTimeText = otherLangTestData.getProperty("LANG_START_TIME");
		WebElement STime = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_START_TIME_XPATH")));
		if( STime == null)
			return false;
		String STimeText = STime.getText();
		
		if(Verify.compareSingleString(STimeText, nonEnglishSTimeText, locale)){
			Log.info("nonEnglishSTimeText is success");
			stepResult=true;
		}
		

		String nonEnglishETimeText = otherLangTestData.getProperty("LANG_END_TIME");
		WebElement ETime = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_END_TIME_XPATH"), 60);
		if( ETime == null)
			return false;
		String ETimeText = ETime.getText();
		
			if(Verify.compareSingleString(ETimeText, nonEnglishETimeText, locale)){
				Log.info("nonEnglishETimeText is success");
				stepResult=true;
			}
		

		return stepResult;
	}


	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEventOtherLabelsText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Other Labels in Create Event Page method");
		String nonEnglishAllDayText = otherLangTestData.getProperty("LANG_CALENDAR_NEW_EVENT_ALL_DAY");
		WebElement AllDay = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ALL_DAY_LABEL_XPATH")));
		if( AllDay == null)
			return false;
		String AllDayText = AllDay.getText();
		
		if(Verify.compareSingleString(AllDayText, nonEnglishAllDayText, locale)){
			Log.info("verifyEventOtherLabelsText is success");
				stepResult=true;
		}
		


		String nonEnglishRepeatText = otherLangTestData.getProperty("LANG_CALENDAR_NEW_EVENT_REPEAT");
		WebElement Repeat = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_REPEAT_LABEL_XPATH"), 60);
		if( Repeat == null)
			return false;
		String RepeatText = Repeat.getText();
		
			if(Verify.compareSingleString(RepeatText, nonEnglishRepeatText, locale)){
				stepResult=true;
			}
		


		String nonEnglishlocText = otherLangTestData.getProperty("LANG_LOCATION");
		WebElement loc = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_LOCATION_LABEL_XPATH"), 60);
		if( loc == null)
			return false;
		String locText = loc.getText();
		
			if(Verify.compareSingleString(locText, nonEnglishlocText, locale)){
					stepResult=true;
			}
		

		/*String nonEnglishVmapText = otherLangTestData.getProperty("LANG_VIEW_MAP");
		WebElement Vmap = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_VIEW_MAP_XPATH"), 60);
		if( Vmap == null)
			return false;
		String VmapText = Vmap.getText();
		if(Verify.compareSingleString(VmapText, nonEnglishVmapText, locale)){
				stepResult=true;
			}*/
		

		String nonEnglishCalText = otherLangTestData.getProperty("LANG_CALENDAR");
		WebElement Cal = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_CALANDER_LABEL_XPATH"), 60);
		if( Cal == null)
			return false;
		String CalText = Cal.getText();
		
		if(Verify.compareSingleString(CalText, nonEnglishCalText, locale)){
					stepResult=true;
			}
		


		String nonEnglishAlertsText = otherLangTestData.getProperty("LANG_CALENDAR_NEW_EVENT_ALERTS");
		WebElement Alerts = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_ALERTS_LABEL_XPATH"), 60);
		if( Alerts == null)
			return false;
		String AlertsText = Alerts.getText();
		
			if(Verify.compareSingleString(AlertsText, nonEnglishAlertsText, locale)){
				
				stepResult=true;
			}
		


		String nonEnglishaddruleText = otherLangTestData.getProperty("LANG_ADD_ALERT");
		WebElement addrule = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_ALERTS_NEW_ALERT_LABEL_XPATH"), 60);
		if( addrule == null)
			return false;
		String addruleText = addrule.getText();
		
		if(Verify.compareSingleString(addruleText, nonEnglishaddruleText, locale)){
			
				stepResult=true;
			}
		

		String nonEnglishNotesText = otherLangTestData.getProperty("EVENT_NOTES_LABEL_TEXT");
		WebElement Notes = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_NOTES_LABEL_XPATH"), 60);
		if( Notes == null)
			return false;
		String NotesText = Notes.getText();
		if(Verify.compareSingleString(NotesText, nonEnglishNotesText, locale)){
			
				stepResult=true;
			}
		

		String nonEnglishNotesboxText = otherLangTestData.getProperty("LANG_CALENDAR_EVENT_MESSAGE");
		WebElement Notesbox = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_NOTES_TEXTAREA_PLACEHOLDER_XPATH"), 60);
		if( Notesbox == null)
			return false;
		String NotesboxText = Notesbox.getAttribute("placeholder");
		if(Verify.compareSingleString(NotesboxText, nonEnglishNotesboxText, locale)){
			
				stepResult=true;
			}
		


		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEditEventTablabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Edit Event Tab labels text in Create Event...");
		String[] expectedInNonEnglish = otherLangTestData.getProperty("EVENT_EDITEVENT_TABS_TEXT").split(",");
	
		WebElement editEventTabs = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_EDITEVENT_TABS_XPATH")));
		
		if(editEventTabs == null)
			return false;
				
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_BUTTON_XPATH")));
		List<WebElement> lsediteventLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("EVENT_EDITEVENT_TABS_XPATH")));
		for(WebElement label:lsediteventLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("verifyEditEventTablabels is success");
			stepResult=true;
			
		}
		
		return stepResult;
	}
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEventToplabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Event Top Right labels text in Create Event...");
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_SAVE_CANCEL").split(",");
	
		WebElement EventTTopLabels = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_TOP_RIGHT_BUTTONS_XPATH")));
		
		if(EventTTopLabels == null)
			return false;
				
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_BUTTON_XPATH")));
		List<WebElement> lsEventTTopLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("EVENT_TOP_RIGHT_BUTTONS_XPATH")));
		for(WebElement label:lsEventTTopLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("verifyEventToplabels is success");
			stepResult=true;
			
		}
		
		return stepResult;
	}
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAlertDropdownlabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Event Alert dropdown labels text in Create Event...");
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CALENDAR_AT_TIME_OF_EVENT").split(",");
	
		WebElement AlertDropdown = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ALERTS_DROPDOWN_XPATH")));
		if(AlertDropdown == null)
			return false;
		AlertDropdown.click();
		Thread.sleep(2000);
		List<WebElement> lsAlertdropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("EVENT_ALERTS_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsAlertdropdownLabels){
			Thread.sleep(2000);
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
			
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("verifyAlertDropdownlabels is success");
			stepResult=true;
		
		}
		AlertDropdown.click();
		return stepResult;
	}	
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAttendeesLabelsText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Attendees Labels in Create Event Page method");
		String nonEnglishTodayText = otherLangTestData.getProperty("LANG_CALENDAR_TODAY");
		WebElement Attendees = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_BUTTON_XPATH")));
		if( Attendees == null)
			return false;
		Attendees.click();
		Thread.sleep(3000);
		WebElement Today = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_TODAY_BUTTON_XPATH")));
		String TodayText = Today.getText();
		
		if(Verify.compareSingleString(TodayText, nonEnglishTodayText, locale)){
			Log.info("Today is success");
				stepResult=true;
			}
		


		String nonEnglishNextText = otherLangTestData.getProperty("LANG_CALENDAR_AVAILABILITY_NEXT_AVAILABLE_TIME");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_NEXT_BUTTON_XPATH")));
		WebElement Next = driver.findElement(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_NEXT_BUTTON_XPATH")));
		if( Next == null)
			return false;
		String NextText = Next.getText();
		
			if(Verify.compareSingleString(NextText, nonEnglishNextText, locale)){
				Log.info("nonEnglishNextText is success");
				stepResult=true;
			}
		


	String nonEnglishaddattendeesText = otherLangTestData.getProperty("LANG_ADD_ATTENDEES");
	waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_ADD_LABEL_XPATH")));
		WebElement addattendees = driver.findElement(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_ADD_LABEL_XPATH")));
		if( addattendees == null)
			return false;
		String addattendeesText = addattendees.getText();
		
		if(Verify.compareSingleString(addattendeesText, nonEnglishaddattendeesText, locale)){
			Log.info("nonEnglishaddattendeesText is success");
				stepResult=true;
		}
		

	String nonEnglishattendeesplaceholderText = otherLangTestData.getProperty("LANG_ENTER_NAME_EMAIL_GROUP");
		WebElement attendeesplaceholder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ADD_ATTENDEES_TEXTBOX_PLACEHODER_XPATH")));
		if( attendeesplaceholder == null)
			return false;
		String attendeesplaceholderText = attendeesplaceholder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(attendeesplaceholderText, nonEnglishattendeesplaceholderText, locale)){
				Log.info("nonEnglishattendeesplaceholderText is success");
				stepResult=true;
			}
		

	String nonEnglishInviteOthersText = otherLangTestData.getProperty("LANG_ATTENDEES_CAN_INVITE_OTHERS");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_INVITE_OTHERS_LABEL_XPATH")));
		WebElement InviteOthers = driver.findElement(By.xpath(elementLocatorProp.getProperty("EVENT_ATTENDEES_INVITE_OTHERS_LABEL_XPATH")));
		if( InviteOthers == null)
			return false;
		String InviteOthersText = InviteOthers.getText();
		
			if(Verify.compareSingleString(InviteOthersText, nonEnglishInviteOthersText, locale)){
				Log.info("nonEnglishInviteOthersText is success");
				stepResult=true;
			}
		return stepResult;
	}	
	
	public boolean verifyRepeatEventLabelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Repeat Event Label in Create Event Page method");
		String nonEnglishRepeatText = otherLangTestData.getProperty("LANG_EVENTS_REPLY_TEMPLATE_REPEAT");
		WebElement Repeat = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("EVENT_REPEAT_CHECKBOX_XPATH"), 60);
		if( Repeat == null)
			return false;
		Repeat.click();
		Thread.sleep(2000);
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_XPATH"), 60);
		WebElement RepeatHeading = driver.findElement(By.xpath(elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_HEADING_XPATH")));
		String RepeatHeadingText = RepeatHeading.getText();
		
			if(Verify.compareSingleString(RepeatHeadingText, nonEnglishRepeatText, locale)){
				
				stepResult=true;
			}
		

			return stepResult;
	}	
		
	public boolean verifyRepeatEventDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Repeat Event dropdwon labels text in Calendar tab...");
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_CALENDAR_NEW_EVENT_REPEAT_VALUES").split(",");
		Actions builder=new Actions(driver);
		WebElement repeatsidebar= driver.findElement(By.xpath(elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_XPATH")));
		builder.moveToElement(repeatsidebar).perform();
		WebElement RepeatEventDrpDwonBtn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_XPATH"), 60);
		
		if(RepeatEventDrpDwonBtn == null)
			return false;
		RepeatEventDrpDwonBtn.click();
		Thread.sleep(2000);
		//waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_VALUES_XPATH"), 60);
		/*List<WebElement> lsRepeatEventDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_VALUES_XPATH")));		
		for(WebElement label:lsRepeatEventDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}*/
		List<WebElement> value=driver.findElements(By.xpath("//div[2]/div/ng-transclude/span"));
		for (int i = 7; i <= value.size(); i++) {
			String elemnt="(//div[2]/div/ng-transclude/span)["+i+"]";
			WebElement eventDrp=driver.findElement(By.xpath(elemnt));
			String temp = eventDrp.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(eventDrp.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			stepResult=true;
			Thread.sleep(2000);
		}
		RepeatEventDrpDwonBtn.click();
		return stepResult;
	}	
	
	
	public boolean verifyRepeatEventEndLabels()throws Exception{
		boolean stepResult = false;
	Thread.sleep(2000);
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Repeat Event End labels text in Calendar tab...");
		String[] expectedInEndNonEnglish = otherLangTestData.getProperty("LANG_CALENDAR_NEW_EVENT_REPEAT_ENDS_NEVER").split(",");
		//Actions builder=new Actions(driver);
	//	WebElement repeatsidebar=waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_XPATH"), 60);
			//	driver.findElement(By.xpath(elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_XPATH")));
		//builder.moveToElement(repeatsidebar).perform();
		//repeatsidebar.click();
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_XPATH"), 60);
		List<WebElement> lsRepeatEventEndLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_ENDS_LABEL_XPATH")));
		for(WebElement label:lsRepeatEventEndLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInEndNonEnglish, locale)){
			stepResult=true;
			Thread.sleep(2000);
		}
		
		return stepResult;
	}	
	
	public boolean DaysVerification()throws Exception{
		boolean stepResult = false;
	    List<String> lsLabelText = new ArrayList<String>();
	   
	    Log.info("Verfiying Days Labels in Repeat Event Section...");
	   String[] expectedDaysInNonEnglish = otherLangTestData.getProperty("LANG_CALENDAR_NEW_EVENT_REPEAT_DAY_SUNDAY_SHORT").split(",");
	    waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("CAL_REPEAT_SIDEBAR_DROPDOWN_XPATH"), 60);
	    List<WebElement> lsDaysLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("REPEAT_EVENT_DAYS_XPATH")));
	    for(WebElement label:lsDaysLabels){
	        String temp = label.getText().trim();
	        if( !temp.isEmpty()){
	            lsLabelText.add(label.getText().trim());
	        }
	    }
	    String[] actuals = new String[lsLabelText.size()];
	    actuals = lsLabelText.toArray(actuals);

	    if(Verify.compareMultipleStrings(actuals, expectedDaysInNonEnglish, locale)){
	         stepResult=true;
	       
	    }
	   
	    return stepResult;
	}		
	

}
