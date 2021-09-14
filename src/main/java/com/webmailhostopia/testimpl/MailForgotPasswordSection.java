package com.webmailhostopia.testimpl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class MailForgotPasswordSection extends AbstractPageObject{
	
	
	
	public boolean verifyLabelsLangugaeInMailForgotPage()throws Exception{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!verifyFEmailPlaceHolderText())
		  failCounter++;
		if(!verifycaptchaPlaceHolderText())
			  failCounter++;
		if(!verifyCancelText())
			  failCounter++;
		if(!verifyNextText())
			  failCounter++;
		if(!verifyCaptchaButtonsLabels())
			  failCounter++;
			
		return (failCounter==0)?true:false;
	}
	
	public boolean clickCancelInForgotPwdScreen() throws Exception{
		boolean stepResult = false;
		clickCancel();
		WebElement forgotLink = waitUntilElementVisibility(By.xpath(elementLocatorProp.getProperty("FORGOT_PWD_LINK")));
		if( forgotLink != null){
			forgotLink.click();
			stepResult = true;
		}
		return stepResult;
	}



	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFEmailPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Email placeholder text method");
		String fEmailText = otherLangTestData.getProperty("LANG_EMAIL");
		WebElement forgotPassword = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("FORGOT_PWD_LINK")));
		if( forgotPassword == null)
			return false;
		forgotPassword.click();
		WebElement EmailPlaceHolder = waitForElementVisibility(By.id(elementLocatorProp.getProperty("FORGOT_PSWD_EMAIL_PLACEHOLDER_ID")));
		String EmailPlaceHolderText = EmailPlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(EmailPlaceHolderText, fEmailText, locale)){
				Log.info("verifyFEmailPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifycaptchaPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Email placeholder text method");
		String captchaText = otherLangTestData.getProperty("LANG_PASSWORD_RECOVERY_CHARACTERS");
		WebElement captchaPlaceHolder = waitForElementVisibility(By.id(elementLocatorProp.getProperty("FORGOT_PSWD_CAPTCHA_PLACEHOLDER_ID")));
		String captchaPlaceHolderText = captchaPlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(captchaPlaceHolderText, captchaText, locale)){
				Log.info("verifycaptchaPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCancelText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Forgot Password Page verify Cancel Text");
		String FcancelText = otherLangTestData.getProperty("LANG_CANCEL");
		WebElement Cancel = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("FORGOT_PSWD_CANCEL_BUTTON_XPATH")));
		String CancelText = Cancel.getText();
		
		if(Verify.compareSingleString(CancelText, FcancelText, locale)){
			Log.info("verifyCancelText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNextText()throws Exception{
		boolean stepResult = false;
		Log.info("Inside Mail Forgot Password Page verify Next Text");
		String FNextText = otherLangTestData.getProperty("LANG_NEXT");
		WebElement Next = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("FORGOT_PSWD_NEXT_BUTTON_XPATH"),60);
		String NextText = Next.getText();
		if(Verify.compareSingleString(NextText, FNextText, locale)){
			Log.info("verifyNextText is success");
			stepResult=true;
		
		}
		return stepResult;
	}

	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCaptchaButtonsLabels()throws Exception{
		boolean stepResult = false;
		List<String> lsLabelText = new ArrayList<String>();
		Log.info("Verfiying Captcha Buttons Labels text ...");
		String[] expectedCaptchaButtonslabels = otherLangTestData.getProperty("FORGOT_PSWD_CAPTCHA_BUTTONS").split(",");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("FORGOT_PSWD_NEXT_BUTTON_XPATH")));
		List<WebElement> lsButtonLabels = driver.findElements(By.xpath(elementLocatorProp.getProperty("FORGOT_PSWD_CAPTCHA_BUTTONS_XPATH")));
		for(WebElement label:lsButtonLabels){
			String temp = label.getText().trim();
			if( !temp.isEmpty()){
				lsLabelText.add(label.getText().trim());
			}
		}
		String[] actuals = new String[lsLabelText.size()];
		actuals = lsLabelText.toArray(actuals);

		if(Verify.compareMultipleStrings(actuals, expectedCaptchaButtonslabels, locale)){
			Log.info("verifyCaptchaButtonsLabels is success");
			stepResult=true;		
			Thread.sleep(2000);
			
		}
		WebElement Cancel = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("FORGOT_PSWD_CANCEL_BUTTON_XPATH"),60);
		Cancel.click();
		Thread.sleep(2000);
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_BTN")));
		return stepResult;
	}

}
