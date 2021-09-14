package com.webmailhostopia.testimpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import org.openqa.selenium.interactions.Actions;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailBriefCaseSection extends AbstractPageObject{


	public boolean BreifCaseSectionLabels() throws Exception{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!verifyBreifCaseHeadingText()){
			failCounter++;
		}
		if(!verifyBreifCaseMainFolderText()){
			failCounter++;
		}
		if(!verifyBreifCaseMainFolderBreadCumText()){
			failCounter++;
		}
		if(!verifyBreifCaseUploadButtonText()){
			failCounter++;
		}
		if(!verifyBreifCaseDownloadButtonText()){
			failCounter++;
		}
		if(!verifyRefreshTitleText()){
			failCounter++;
		}
		if(!verifyDownloadTitleText()){
			failCounter++;
		}
		if(!verifyDeleteTitleText()){
			failCounter++;
		}
		if(!verifyToggleTitleText()){
			failCounter++;
		}
		if(!verifyListViewTitleText()){
			failCounter++;
		}
		if(!verifyThumbnailTitleText()){
			failCounter++;
		}
		if(!verifySortByDropDownLabels()){
			failCounter++;
		}
		/*if(!verifyFolderDropDownLabels()){
			failCounter++;
		}*/
			
	return (failCounter == 0) ? true : false;
		
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBreifCaseHeadingText()throws Exception{
		boolean stepResult = false;	
		Log.info("Inside Mail BriefCase Page verify Heading Text");
		String ExpectedHeadText = otherLangTestData.getProperty("LANG_BRIEFCASE");
		WebElement BriefCaseIcon = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_ICON_XPATH"),60);
		BriefCaseIcon.click();
		Thread.sleep(2000);
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_UPLOAD_BUTTON_XPATH"),60);
		WebElement Head=driver.findElement(By.xpath(elementLocatorProp.getProperty("LANG_BRIEFCASE_XPATH")));
		String HeadText = Head.getText().trim();
		
		if(Verify.compareSingleString(HeadText, ExpectedHeadText, locale)){
			Log.info("verifyBreifCaseHeadingText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBreifCaseMainFolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail BriefCase Page verify Heading Text");
		String ExpectedMainText = otherLangTestData.getProperty("LANG_BRIEFCASE_MAIN_FOLDER");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_MAINFOLDER_PLUS_XPATH"),60);
		WebElement Main=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_MAINFOLDER_TEXT_XPATH")));
		String MainText = Main.getText().trim();
		
		if(Verify.compareSingleString(MainText, ExpectedMainText, locale)){
			Log.info("verifyBreifCaseMainFolderText is success");
				stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBreifCaseMainFolderBreadCumText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail BriefCase Page verify Mainfolder Text in Breadcrum");
		String ExpectedBreadText = otherLangTestData.getProperty("LANG_BRIEFCASE_MAIN_FOLDER");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_UPLOAD_BUTTON_XPATH"),60);
		WebElement Bread=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_MAINFOLDER_BREADCUM_HEADING_TEXT_XPATH")));
		String BreadText = Bread.getText().trim();
		
		if(Verify.compareSingleString(BreadText, ExpectedBreadText, locale)){
			Log.info("verifyBreifCaseMainFolderBreadCumText is success"); 
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBreifCaseUploadButtonText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail BriefCase Page verify Mainfolder Text in Breadcrum");
		String ExpectedUploadText = otherLangTestData.getProperty("LANG_BRIEFCASE_UPLOAD");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_UPLOAD_BUTTON_XPATH"),60);
		WebElement Upload=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_UPLOAD_BUTTON_XPATH1")));
		String UploadText = Upload.getText();		
		if(Verify.compareSingleString(UploadText, ExpectedUploadText, locale)){
			Log.info("verifyBreifCaseUploadButtonText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBreifCaseDownloadButtonText()throws Exception{
		boolean stepResult = false;
		Thread.sleep(3000);
		Log.info("Inside Mail BriefCase Page verify Mainfolder Text in Breadcrum");
		String ExpectedDownloadText = otherLangTestData.getProperty("LANG_BRIEFCASE_DOWNLOAD");
		//waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_DOWNLOAD_BUTTON_XPATH"),60);
		WebElement Download=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_DOWNLOAD_BUTTON_XPATH1")));
		String DownloadText = Download.getText().trim();
		System.out.println("DownloadText : "+DownloadText);
		if(Verify.compareSingleString(DownloadText, ExpectedDownloadText, locale)){
			Log.info("verifyBreifCaseDownloadButtonText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	public boolean verifyBreifCaseShareFolderButtonText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail BriefCase Page verify Mainfolder Text in Breadcrum");
		String ExpectedShareFolderText = otherLangTestData.getProperty("LANG_BRIEFCASE_SHARE_FOLDER");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_SHAREFOLDER_BUTTON_XPATH"),60);
		WebElement ShareFolder=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_SHAREFOLDER_BUTTON_XPATH")));
		String ShareFolderText = ShareFolder.getText();
		
		if(Verify.compareSingleString(ShareFolderText, ExpectedShareFolderText, locale)){
			//	Log.info("BriefCase Heading text is displaying in" + SUTprop.getProperty("LANGUAGE")+  "Language");
				stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyRefreshTitleText()throws Exception{
		boolean stepResult = false;
		Log.info("Inside verify Refresh Title text method");
		String RefreshText = otherLangTestData.getProperty("LANG_BRIEFCASE_REFRESH_BUTTON_TOOLTIP");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_REFRESH_BUTTON_XPATH"),60);
		WebElement Refresh=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_REFRESH_BUTTON_XPATH")));
		String RefreshTitleText = Refresh.getAttribute("data-original-title").trim();
		System.out.println("RefreshTitleText : "+RefreshTitleText);
		if(Verify.compareSingleString(RefreshTitleText, RefreshText, locale)){
			Log.info("verifyRefreshTitleText is success");
			Log.info("successfully validated refresh button");
			stepResult=true;
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDownloadTitleText()throws Exception{
		boolean stepResult = false;
		Log.info("Inside verify Download Title text method");
		String DownloadText = otherLangTestData.getProperty("LANG_BRIEFCASE_DOWNLOAD_BUTTON_TOOLTIP");
		//waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_DOWNLOAD_BUTTON_XPATH"),60);
		WebElement Download=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_DOWNLOAD_BUTTON_XPATH")));
		String DownloadTitleText = Download.getAttribute("data-original-title").trim();
		System.out.println("DownloadTitleText :"+DownloadTitleText);
		if(Verify.compareSingleString(DownloadTitleText, DownloadText, locale)){
			Log.info("verifyDownloadTitleText is success");
			Log.info("briefcase download button validate is success");
				stepResult=true;
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDeleteTitleText()throws Exception{
		boolean stepResult = false;
		Log.info("Inside verify Delete Title text method");
		String DeleteText = otherLangTestData.getProperty("LANG_DELETE_BUTTON_TOOLTIP");
		WebElement Delete=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_DELETE_BUTTON_XPATH")));
		String DeleteTitleText = Delete.getAttribute("data-original-title").trim();
		if(Verify.compareSingleString(DeleteTitleText, DeleteText, locale)){
			Log.info("verifyDeleteTitleText is success");
			Log.info("validated delete button tooltip ");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyToggleTitleText()throws Exception{
		boolean stepResult = false;
		Log.info("Inside verify Toggle Title text method");
		String ToggleText = otherLangTestData.getProperty("LANG_BRIEFCASE_TOGGLE_SORT");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_TOGGLE_SORT_BUTTON_XPATH"),60);
		WebElement Toggle=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_TOGGLE_SORT_BUTTON_XPATH")));
		String ToggleTitleText = Toggle.getAttribute("data-original-title").trim();
		if(Verify.compareSingleString(ToggleTitleText, ToggleText, locale)){
			Log.info("verifyToggleTitleText is success");
			Log.info("toggle sort button is validated");
			stepResult=true;
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyListViewTitleText()throws Exception{
		boolean stepResult = false;
		Log.info("Inside verify ListView Title text method");
		String ListViewText = otherLangTestData.getProperty("LANG_BRIEFCASE_LIST_VIEW");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_LIST_VIEW_BUTTON_XPATH"),60);
		WebElement ListView=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_LIST_VIEW_BUTTON_XPATH")));
		String ListViewTitleText = ListView.getAttribute("data-original-title").trim();
		System.out.println("ListViewTitleText : "+ListViewTitleText);
		if(Verify.compareSingleString(ListViewTitleText, ListViewText, locale)){
				Log.info("verifyListViewTitleText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyThumbnailTitleText()throws Exception{
		boolean stepResult = false;
		Log.info("Inside verify Thumbnail Title text method");
		String ThumbnailText = otherLangTestData.getProperty("LANG_BRIEFCASE_THUMBNAIL_VIEW");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_THUMBNAIL_VIEW_BUTTON_XPATH"),60);
		WebElement Thumbnail=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_THUMBNAIL_VIEW_BUTTON_XPATH")));
		String ThumbnailTitleText = Thumbnail.getAttribute("data-original-title");
		if(Verify.compareSingleString(ThumbnailTitleText, ThumbnailText, locale)){
			Log.info("verifyThumbnailTitleText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySortByDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying SortBy dropdwon labels text in BreifCase Section...");
		String[] expectedSortByDropDown = otherLangTestData.getProperty("LANG_BRIEFCASE_SORT_BY_VALUES").split(",");
		Thread.sleep(3000);
		WebElement SortByBtn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_SORTBY_BUTTON_XPATH"), 60);
		if(SortByBtn == null)
			return false;
		SortByBtn.click();
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_SORTBY_VALUES_XPATH"), 60);
		List<WebElement> lsSortByDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_SORTBY_VALUES_XPATH")));
		for(WebElement label:lsSortByDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if( Verify.compareMultipleStrings(actuals, expectedSortByDropDown, locale)){
			Log.info("verifySortByDropDownLabels is success");
			stepResult=true;
			Log.info("SortBy dropdown labels are in" + SUTprop.getProperty("LANGUAGE") +  "Language");
			Thread.sleep(2000);
			SortByBtn.click();
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFolderDropDownLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Folder dropdwon labels text in BreifCase Section...");
		String[] expectedFolderDropDown = otherLangTestData.getProperty("LANG_BRIEFCASE_FOLDER_DROPDOWN_VALUES").split(",");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_FIRSTFOLDER_XPATH"), 60);
		Actions builder=new Actions(driver);
		WebElement Folder=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_FIRSTFOLDER_XPATH")));
		builder.moveToElement(Folder).perform();
		WebElement FolderToggle=driver.findElement(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_FIRSTFOLDER_TOGGLE_XPATH")));		
		FolderToggle.click();
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("BRIEFCASE_FIRSTFOLDER_DROPDOWN_VALUES_XPATH"), 60);
		List<WebElement> lsFolderDropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("BRIEFCASE_FIRSTFOLDER_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsFolderDropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if( Verify.compareMultipleStrings(actuals, expectedFolderDropDown, locale)){
			Log.info("verifyFolderDropDownLabels is success");
			stepResult=true;
			Log.info("Folder dropdown labels are in" + SUTprop.getProperty("LANGUAGE") +  "Language");
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}




















}
