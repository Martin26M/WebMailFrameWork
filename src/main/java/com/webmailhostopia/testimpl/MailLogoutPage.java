package com.webmailhostopia.testimpl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailLogoutPage extends AbstractPageObject{

	public boolean verifyLabelsLangugaeInMailLoginPage()throws Exception{
		int failCounter = 0;
		Thread.sleep(5000);
	//	Log.info("Verifying for Main dropDown labels");
	//	if(!verifyUserGreetingLabelText())
	//		failCounter++;
		if(!navigatetoLoginafterLogout())
		  failCounter++;
			
		return (failCounter==0)?true:false;
	}
	
	public boolean verifyUserGreetingLabelText()throws Exception{
		boolean stepResult = false;
		String nonEnglishText = otherLangTestData.getProperty("LANG_NAVSTATUS_HI");
		Log.info("Inside verify User Greeting Label in Main Page method");
		
		WebElement Greet = driver.findElement(By.xpath(elementLocatorProp.getProperty("USER_MAIN_GREETING_TEXT_XPATH")));
		String GreetText = Greet.getText();
		
				if(Verify.compareSingleString(GreetText, nonEnglishText, locale)){
				stepResult=true;
			}
		

	return stepResult;
	}	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean navigatetoLoginafterLogout()throws Exception{
	
		boolean stepResult = false;
		WebElement Caret = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CLICK_ON_DWN_BTN_CARET")));
		Caret.click();
		List<String> lsLabelText = new ArrayList<String>();
		
		Log.info("Verfiying Event Alert dropdown labels text in Create Event...");
			
		String[] expectedInNonEnglish = otherLangTestData.getProperty("LANG_NAVSTATUS_DROPDOWN_VALUES").split(",");	
		WebElement MainDropdown = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIN_DROP_DROPDOWN_VALUES_XPATH")));
		if(MainDropdown == null)
			return false;
		List<WebElement> lsMaindropdownLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("MAIN_DROP_DROPDOWN_VALUES_XPATH")));
		for(WebElement label:lsMaindropdownLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedInNonEnglish, locale)){
			Log.info("navigatetoLoginafterLogout is success");
			stepResult=true;			
		}
		Thread.sleep(3000);
		WebElement logOutBtnClick = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CLICK_ON_LOGOUTBTN")));
		logOutBtnClick.click();
		Thread.sleep(5000);
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_PAGE_VALIDATION")));
		return stepResult;	
	}
	
}
