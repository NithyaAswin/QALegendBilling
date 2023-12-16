package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage1;
import com.qalegendbilling.pages.LoginPage1;
import com.qalegendbilling.pages.RolePage1;
import com.qalegendbilling.utilities.ExcelUtility;

public class RoleTest1 extends Base{
	LoginPage1 login;
	HomePage1 home;
	RolePage1 role;
	
	@Test
	public void tc_10_verifyRolePageTitle()
	{
	List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
	String expusername = data.get(0).get(1);
	String exppassword = data.get(1).get(1);
	
	List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("RolePage");
	String expRoleTitle = data1.get(0).get(1);
	
	login = new LoginPage1(driver);//only first page is declared with object-----
	
	login.enterUsername(expusername);// LoginTest method written
	login.enterUserPassword(exppassword);
	home = login.clickonLoginButton();
	home.clickonUserManagement();
	role = home.ClickRolesunderUserManagement();
	String actRoleTitle = role.getRolePageTitle();
	Assert.assertEquals(actRoleTitle, expRoleTitle, ErrorMessages.INVALID_TITLE);
}
}