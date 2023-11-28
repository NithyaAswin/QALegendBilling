package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddUserPage1;
import com.qalegendbilling.pages.HomePage1;
import com.qalegendbilling.pages.LoginPage1;
import com.qalegendbilling.pages.ResetPage1;
import com.qalegendbilling.pages.UserPage1;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class HomeTest1 extends Base {
	LoginPage1 login;
	HomePage1 home;
	AddUserPage1 adduser;
	UserPage1 user;

	@Test
	public void tc_004_verifyuserNavigationBacktoLoginpage() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		String expLoginPageTitle = data.get(2).get(1);
		login = new LoginPage1(driver);//only first page is declared with object-----
		
		login.enterUsername(expusername);// LoginTest method written
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.clickonSignoutButton();
		
		String actLoginPageTitle = login.getLoginPageTitle();
		Assert.assertEquals(actLoginPageTitle, expLoginPageTitle, ErrorMessages.INVALID_EMAIL_ID);
	}

	@Test
	public void tc_005_verifyUserManagementtabs() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		login = new LoginPage1(driver);

		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.clickonUserManagement();
		Boolean userStatus = home.checkUsersMenuIsDisplayed();
		Boolean roleStatus = home.checkRolesMenuIsDisplayed();
		Boolean scaStatus = home.checkSCAMenuIsDisplayed();
		Assert.assertTrue(userStatus, ErrorMessages.USER_MENU_NOT_FOUND);
		Assert.assertTrue(roleStatus, ErrorMessages.ROLES_MENU_NOT_FOUND);
		Assert.assertTrue(scaStatus, ErrorMessages.SCA_MENU_NOT_FOUND);

	}
	@Test
	public void tc_006_verifyUserSearchwithvaliddata()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		List<ArrayList<String>> userdata = ExcelUtility.excelDataReader("AddUserPage");
		String expPrefix = userdata.get(0).get(1);
		String expscpercent = userdata.get(1).get(1);
		String fName = RandomUtility.getfName();
		String lName = RandomUtility.getlName();
		String uName = fName + lName;
		String password = fName + "@123";
		String confirmPassword = password;
		String eMail = RandomUtility.getRandomEmail();
		login = new LoginPage1(driver);
		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.clickonUserManagement();	
		user = home.clickonUserMgUsers();//going to user page
		adduser = home.clickAddButton();//going to adduser page
		
		adduser.enterPrefix(expPrefix);
		adduser.enterFirstName(fName);
		adduser.enterLastName(lName);
		adduser.enterEmail(eMail);
		adduser.enterUsername(uName);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(confirmPassword);
		
		adduser.enterSCPercent(expscpercent);
		user = adduser.clickonSaveButton();
	    user.searchuser(uName);//Doubt firstname+lastname search
		String acttableUserName = user.getusername();
		Assert.assertEquals(acttableUserName, uName,ErrorMessages.USERNAME_NOT_FOUND);
	}
}