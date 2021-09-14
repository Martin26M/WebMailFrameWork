package com.webmailhostopia.testimpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailInboxPage extends AbstractPageObject{
	
	
	
	public boolean SocialMailSection() throws Exception{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!verifySocialText())
			failCounter++;
		if(!verifySocialComposePlaceHolderText())
			failCounter++;
		if(!verifyLinkText())
			failCounter++;
		if(!verifyAddLinkText())
			failCounter++;
		if(!verifyAddlinkPlaceHolderText())
			failCounter++;
		if(!verifyAddText())
			failCounter++;
		if(!verifySocialLoginButtonsLabels())
			failCounter++;
		if(!verifySocialTopButtonsLabels())
			failCounter++;
		
		return (failCounter == 0) ? true : false;
		
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySocialText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Home Page verify Social Text from Compose Dropdown Text");
		String ExpectedSocialText = otherLangTestData.getProperty("LANG_MAIL_SOCIAL");
		WebElement composedropdown = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_DROPDOWN_XPATH")));
		composedropdown.click();
		Thread.sleep(5000);
		//waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIAL_XPATH")));
		WebElement Social=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIAL_XPATH")));
		Thread.sleep(5000);
		String SocialText = Social.getText().trim();
		System.out.println("actual value is :"+SocialText);
		if(Verify.compareSingleString(SocialText, ExpectedSocialText, locale)){		
			Log.info("verify Social Text is success");
			stepResult=true;			
		}
		Social.click();
		Thread.sleep(5000);
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySocialComposePlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Social Compose placeholder text method");
		String SocialComposeText = otherLangTestData.getProperty("LANG_MAIL_SOCIALCOMPOSE_WHATS_NEW");
		WebElement SocialComposePlaceHolder = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_WHATS_NEW_XPATH"),60);
		String SocialComposePlaceHolderText = SocialComposePlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(SocialComposePlaceHolderText, SocialComposeText, locale)){
				Log.info("verifySocialComposePlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLinkText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Home Page verify Link Text from Compose Dropdown Text");
		String ExpectedLinkText = otherLangTestData.getProperty("LANG_MAIL_SOCIALCOMPOSE_LINK");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_LINK_XPATH")));
		WebElement link=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_LINK_XPATH")));
		String linkText = link.getText();
		
		if(Verify.compareSingleString(linkText, ExpectedLinkText, locale)){
			Log.info("verifyLinkText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAddLinkText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Home Page verify Link Text from Compose Dropdown Text");
		String ExpectedAddLinkText = otherLangTestData.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDLINK");
		WebElement Link1 = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_LINK_XPATH")));
		Link1.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDLINK_XPATH")));
		WebElement AddLink=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDLINK_XPATH")));
		String AddLinkText = AddLink.getText();
		
		if(Verify.compareSingleString(AddLinkText, ExpectedAddLinkText, locale)){
			Log.info("verifyAddLinkText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAddlinkPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Email placeholder text method");
		String AddlinkText = otherLangTestData.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDLINK_PLH");
		WebElement AddLink=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDLINK_XPATH")));
		AddLink.click();
		WebElement AddlinkPlaceHolder = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDLINK_PLH_XPATH")));
		String AddlinkPlaceHolderText = AddlinkPlaceHolder.getText();		
			if(Verify.compareSingleString(AddlinkPlaceHolderText, AddlinkText, locale)){
				Log.info("verifyAddlinkPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAddText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Home Page verify Link Text from Compose Dropdown Text");
		String ExpectedAddText = otherLangTestData.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDBUTTON");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDBUTTON_XPATH")));
		WebElement Add=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_ADDBUTTON_XPATH")));
		String AddText = Add.getText();
		
		if(Verify.compareSingleString(AddText, ExpectedAddText, locale)){
			Log.info("verifyAddText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySocialLoginButtonsLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Login Buttons Labels text ...");
		String[] expectedLoginButtonslabels = otherLangTestData.getProperty("LANG_MAIL_SOCIALCOMPOSE_LOGIN").split(",");
		waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_LOGIN_XPATH"), 60);
		List<WebElement> lsButtonLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("LANG_MAIL_SOCIALCOMPOSE_LOGIN_XPATH")));
		for(WebElement label:lsButtonLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedLoginButtonslabels, locale)){
			Log.info("verify Social Login Buttons Labels is success");
			stepResult=true;
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifySocialTopButtonsLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Social Top Buttons Labels text ...");
		String[] expectedTopButtonslabels = otherLangTestData.getProperty("SOCIAL_COMPOSE_TOP_BUTTONS").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("SOCIAL_COMPOSE_TOP_BUTTONS_XPATH")));
		List<WebElement> lsTopButtonLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("SOCIAL_COMPOSE_TOP_BUTTONS_XPATH")));
		for(WebElement label:lsTopButtonLabels){
			System.out.println("Buttons :"+label.getText());
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);
		System.out.println("actuals :"+actuals.toString());

		if(Verify.compareMultipleStrings(actuals, expectedTopButtonslabels, locale)){
			Log.info("verifySocialTopButtonsLabels is success");
			stepResult=true;
			
			Thread.sleep(2000);
			
		}
		
		return stepResult;
	}







}
