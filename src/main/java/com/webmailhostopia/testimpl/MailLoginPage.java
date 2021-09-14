package com.webmailhostopia.testimpl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.webmailhostopia.common.utils.ByLocator;
import com.webmailhostopia.common.utils.Log;
import com.webmailhostopia.common.utils.Verify;
import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

/**
 * This is the actual test implementation file ,contains UI driving code and validations
 * @author Vamsi Malleni
 * 
 *
 */
public class MailLoginPage extends AbstractPageObject{

	
	//this will call the AbstractPageObject C'tor which will initialize driver object
	public MailLoginPage() {
		super();
	}

	/*
	public boolean loginToWebMail(String userName,String password) throws Exception{

		boolean isLoggedIn = false;

		if (!driver.getCurrentUrl().contains(SUTprop.getProperty("URL")) ) {
			driver.get(SUTprop.getProperty("URL"));
			driver.manage().deleteAllCookies();
			isBrowserOpen = true;
		}

		if(isBrowserOpen && driver.getCurrentUrl().contains(SUTprop.getProperty("URL"))){
			try{
				Thread.sleep(5000);
				WebElement loginBtn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("LOGIN_BTN"), 60);
				if( loginBtn != null){
					typeEditBox(elementLocatorProp.getProperty("USERNAME_ID"), userName);
					typeEditBox(elementLocatorProp.getProperty("PASSWORD_ID"), password);
					driver.findElement(By.id(elementLocatorProp.getProperty("PASSWORD_ID"))).sendKeys(Keys.TAB);
					
					if( SUTprop.getProperty("BROWSER").equalsIgnoreCase("iexplorer")){
						loginBtn.sendKeys(Keys.ENTER);
					}else{
						loginBtn.click();
						Thread.sleep(25000);
						WebElement composeBtn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("MAIL_COMPOSE_BUTTON_XPATH"), 60);
						
					}
										
					if( pollDOMUntilElementVisibility(By.xpath(elementLocatorProp.getProperty("NEW_EMAIL_XPATH")), 5) != null){
						Log.info("New email pencil button is present");
						isLoggedIn = true;
					}else{
						Log.error("New email pencil button not present");
					}
				}
			}catch(Exception e){
				Log.error("Exception occured during login" + e.getMessage());
				e.printStackTrace();
			}
		}
		return isLoggedIn;
	}
*/
	
	
	public boolean loginToWebMail() throws Exception{
		//driver.manage().deleteAllCookies();
		Thread.sleep(5000);		
		boolean isLoggedIn = false;
		if (!driver.getCurrentUrl().contains(SUTprop.getProperty("URL")) ) {
			driver.get(SUTprop.getProperty("URL"));
			System.out.println("Language is :"+otherLangTestData.getProperty("LANG_LOGIN_SIGN_IN"));
			isBrowserOpen = true;
		}

		if(isBrowserOpen && driver.getCurrentUrl().contains(SUTprop.getProperty("URL"))){
			try{
				Thread.sleep(5000);
				WebElement loginBtn = waitForElementToBeClickable(ByLocator.xpath, elementLocatorProp.getProperty("LOGIN_BTN"), 60);
				if( loginBtn != null){
					driver.findElement(By.id(elementLocatorProp.getProperty("USERNAME_ID"))).sendKeys(SUTprop.getProperty("USER_NAME"));
					driver.findElement(By.id(elementLocatorProp.getProperty("PASSWORD_ID"))).sendKeys(SUTprop.getProperty("PASSWORD"));
					driver.findElement(By.id(elementLocatorProp.getProperty("PASSWORD_ID"))).sendKeys(Keys.TAB);
					
					if( SUTprop.getProperty("BROWSER").equalsIgnoreCase("iexplorer")){
						loginBtn.sendKeys(Keys.ENTER);
					}else{
						loginBtn.click();
						Thread.sleep(25000);
					}
										
					if( pollDOMUntilElementVisibility(By.xpath(elementLocatorProp.getProperty("NEW_EMAIL_XPATH")), 5) != null){
						System.out.println("validate sonatin text :"+driver.getPageSource().contains(otherLangTestData.getProperty("LANG_MAIL")));
						Log.info("New email pencil button is present");
						isLoggedIn = true;
					}else{
						Log.error("New email pencil button not present");
					}
				}
			}catch(Exception e){
				Log.error("Exception occured during login" + e.getMessage());
				e.printStackTrace();
			}
		}
		return isLoggedIn;
	}
	
	public boolean verifyLabelsLanguageInLoginPage()throws Exception{
		int failCounter = 0;
		Thread.sleep(5000);
		if(!verifyUsernamePlaceHolderText())
	           failCounter++;
		if(!verifyPasswordPlaceHolderText())
	           failCounter++;
		if(!verifyLoginText())
	           failCounter++;
		if(!verifyForgotText())
	           failCounter++;
		if(!verifyAlertStrongText())
	           failCounter++;
		if(!verifyErrorMesgText())
	           failCounter++;
		if(!verifyPassWordErrorMesgText())
	           failCounter++;
		if(!verifyIncorrectLoginDetailsMesgText())
	           failCounter++;
			
			return (failCounter==0)?true:false;
		}
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyUsernamePlaceHolderText()throws Exception{
		boolean stepResult = false;
		Thread.sleep(2000);
		Log.info("Inside verify Username placeholder text method");
		String UsernameText = otherLangTestData.getProperty("LANG_LOGIN_USERNAME");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_PAGE_VALIDATION")));
		WebElement EmailPlaceHolder = waitForElementVisibility(By.id(elementLocatorProp.getProperty("USERNAME_ID")));
		if( EmailPlaceHolder == null)
			return false;
		String EmailPlaceHolderText = EmailPlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(EmailPlaceHolderText, UsernameText, locale)){
				Log.info("verifyUsernamePlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPasswordPlaceHolderText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside verify Password placeholder text method");
		String PasswordText = otherLangTestData.getProperty("LANG_LOGIN_PASSWORD");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_PAGE_VALIDATION")));
		WebElement PasswordPlaceHolder = waitForElementVisibility(By.id(elementLocatorProp.getProperty("PASSWORD_ID")));
		if( PasswordPlaceHolder == null)
			return false;
		String PasswordPlaceHolderText = PasswordPlaceHolder.getAttribute("placeholder");
		
			if(Verify.compareSingleString(PasswordPlaceHolderText, PasswordText, locale)){
				Log.info("verifyPasswordPlaceHolderText is success");
				stepResult=true;
			}
		
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLoginText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Login Page verify Login Button Text");
		String loginButtonText = otherLangTestData.getProperty("LANG_LOGIN_SIGN_IN");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_PAGE_VALIDATION")));
		WebElement login=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_BTN")));
		String loginText = login.getText();
		
		if(Verify.compareSingleString(loginText, loginButtonText, locale)){
			Log.info("verifyLoginText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyForgotText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Login Page verify Forgot Passowrd Text");
		String forgotlinkText = otherLangTestData.getProperty("LANG_LOGIN_FORGOT_PASSWORD");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("FORGOT_PWD_LINK")));
		WebElement forgot=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("FORGOT_PWD_LINK")));
		String forgotText = forgot.getText();
		
		if(Verify.compareSingleString(forgotText, forgotlinkText, locale)){
			Log.info("verifyForgotText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAlertStrongText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Login Page verify Strong Text");
		String AlertStrongText = otherLangTestData.getProperty("LANG_ERROR");
		WebElement login = waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_BTN")));
		login.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CLOSE_BUTTON_XPATH")));
		WebElement strong=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_ALERT_STRONG")));
		String strongText = strong.getText();
		
		if(Verify.compareSingleString(strongText, AlertStrongText, locale)){
			Log.info("verifyAlertStrongText is success");
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
		
		Log.info("Inside Mail Login Page verify Error Message Text");
		String ExpectederrorText = otherLangTestData.getProperty("LANG_LOGIN_ERROR_EMPTY_USERNAME");
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CLOSE_BUTTON_XPATH")));
		WebElement ErrorMesg=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_ALERT_AREA")));
		String ErrorMesgText = ErrorMesg.getText();
		
		if(Verify.compareSingleString(ErrorMesgText, ExpectederrorText, locale)){
			Log.info("verifyErrorMesgText is successt");
			stepResult=true;
			
		}
		return stepResult;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPassWordErrorMesgText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Login Page verify Password Error Message Text");
		String ExpectederrorText1 = otherLangTestData.getProperty("LANG_LOGIN_ERROR_EMPTY_PASSWORD");
		waitForElementVisibility(By.id(elementLocatorProp.getProperty("USERNAME_ID")));
		waitForElementVisibility(By.id(elementLocatorProp.getProperty("USERNAME_ID"))).sendKeys(SUTprop.getProperty("USER_NAME"));
		WebElement login1 =waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_BTN")));
		login1.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CLOSE_BUTTON_XPATH")));
		WebElement ErrorMesg1=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_ALERT_AREA")));
		String ErrorMesg1Text = ErrorMesg1.getText();
		
		if(Verify.compareSingleString(ErrorMesg1Text, ExpectederrorText1, locale)){
			Log.info("verifyPassWordErrorMesgText is success");
			stepResult=true;
			
		}
		return stepResult;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIncorrectLoginDetailsMesgText()throws Exception{
		boolean stepResult = false;
		
		Log.info("Inside Mail Login Page verify Incorrect login details Error Message Text");
		String ExpectederrorText2 = otherLangTestData.getProperty("LANG_LOGIN_ERROR_INVALID");
		waitForElementVisibility(By.id(elementLocatorProp.getProperty("PASSWORD_ID"))).sendKeys("123456");
		WebElement login2 =waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_BTN")));
		login2.click();
		waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("CLOSE_BUTTON_XPATH")));
		WebElement ErrorMesg2=waitForElementVisibility(By.xpath(elementLocatorProp.getProperty("LOGIN_ALERT_AREA")));
		String ErrorMesg2Text = ErrorMesg2.getText();
		
		if(Verify.compareSingleString(ErrorMesg2Text, ExpectederrorText2, locale)){
			Log.info("verifyIncorrectLoginDetailsMesgText is success");
			stepResult=true;
			
		}
		return stepResult;
	}

	

	//close all open browser instances
	public void quit(){
		try{
			driver.quit();
			Log.info("closing all browser instances");
		}catch(Exception e){
			Log.error("exception occured while closing the browser");
		}
	}
} //End of the main class
