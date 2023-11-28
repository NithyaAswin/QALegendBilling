package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.LoginPage1;
import com.qalegendbilling.pages.ResetPage1;
import com.qalegendbilling.utilities.ExcelUtility;

public class ResetTest1 extends Base {
	LoginPage1 login;
	ResetPage1 reset;//object declare
	@Test
	public void tc_003_verifyForgotPassword()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPage");
		String expEmailError = data.get(0).get(1);
		login= new LoginPage1(driver);
		reset=login.clickonForgotPassword();
		reset.enterSubEmailID();//enter a random emailid
		reset.clickonPasswordReset();
		String actEmailError = reset.getInvalidEmailError();
		Assert.assertEquals(actEmailError, expEmailError, ErrorMessages.INVALID_EMAIL_ID);
	}
	
}
