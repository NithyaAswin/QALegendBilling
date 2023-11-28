package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage1;
import com.qalegendbilling.pages.LoginPage1;
import com.qalegendbilling.pages.ResetPage1;
import com.qalegendbilling.utilities.ExcelUtility;

public class LoginTest1 extends Base {
	LoginPage1 login;//object declare
	HomePage1 home;
	@Test
	public void tc_001_verifyLoginPage_Credentials()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		login = new LoginPage1(driver);//only first page is declared with object
		login.enterUsername(expusername);//LoginTest method written
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		String actualuserAccountName = home.getUserAccountName();
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("HomePage");
		String expuserAccountName = data1.get(0).get(1);
		Assert.assertEquals(actualuserAccountName, expuserAccountName,ErrorMessages.INVALID_EMAIL_ID);
	}
	/*@Test
	public void tc_002_verifyLoginPage_Credentials()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		login=new LoginPage1(driver);
		login.enterSubEmailID();
		String exppassword = data.get(1).get(1);
		login.enterUserPassword(exppassword);
		login.clickonLoginButton1();
		String actEmailError = reset.getInvalidEmailError();
		String expEmailError = data.get(0).get(1);
		Assert.assertEquals(actEmailError, expEmailError, ErrorMessages.INVALID_EMAIL_ID);
	}*/
	
	}