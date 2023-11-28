package com.qalegendbilling.testscript;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddNewProductPage1;
import com.qalegendbilling.pages.AddUserPage1;
import com.qalegendbilling.pages.HomePage1;
import com.qalegendbilling.pages.LoginPage1;
import com.qalegendbilling.pages.UserPage1;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class AddUserTest1 extends Base {
	LoginPage1 login;
	HomePage1 home;
	AddUserPage1 adduser;
	UserPage1 user;
	AddNewProductPage1 addnewproduct;

	@Test

	public void tc_007_verifyValidationMessageinAddUser() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);

		List<ArrayList<String>> userdata = ExcelUtility.excelDataReader("AddUserPage");
		String expFirstNameErr = userdata.get(2).get(1);
		String expEmailErr = userdata.get(3).get(1);
		String expusernameErr = userdata.get(4).get(1);
		String expconfirmPasswordErr = userdata.get(5).get(1);

		login = new LoginPage1(driver);
		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.clickonUserManagement();
		user = home.clickonUserMgUsers();// going to user page
		adduser = home.clickAddButton();// going to adduser page
		adduser.clickonSaveButton();

		String actFNameFieldErrorMessage = adduser.getFNameFieldError();
		String acteMailFieldErrorMessage = adduser.geteMailFieldError();
		// String actUserNameFieldErrorMessage = adduser.getUserNameFieldError();
		String actConfirmPasswordFieldErrorMessage = adduser.getConfirmPasswordFieldError();

		Assert.assertEquals(actFNameFieldErrorMessage, expFirstNameErr, ErrorMessages.FIRSTNAME_NOT_FOUND);
		Assert.assertEquals(acteMailFieldErrorMessage, expEmailErr, ErrorMessages.EMAIL_NOT_FOUND);
		// Assert.assertEquals(actUserNameFieldErrorMessage,
		// expusernameErr,ErrorMessages.USERNAME_NOT_FOUND);
		Assert.assertEquals(actConfirmPasswordFieldErrorMessage, expconfirmPasswordErr,
				ErrorMessages.CONFIRMPASSWORD_NOT_FOUND);
	}

	@Test
	public void tc_008_verifyUserloginwithNewlyaddedUser() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		List<ArrayList<String>> userdata = ExcelUtility.excelDataReader("AddUserPage");
		String expPrefix = userdata.get(0).get(1);
		String expscpercent = userdata.get(1).get(1);
		String exphomepageTitle = userdata.get(6).get(1);
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
		user = home.clickonUserMgUsers();
		adduser = home.clickAddButton();
		adduser.enterPrefix(expPrefix);
		adduser.enterFirstName(fName);
		adduser.enterLastName(lName);
		adduser.enterEmail(eMail);
		adduser.enterUsername(uName);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(confirmPassword);

		adduser.enterSCPercent(expscpercent);
		user = adduser.clickonSaveButton();
		user.searchuser(uName);
		String acttableUserName = user.getusername();
		Assert.assertEquals(acttableUserName, uName, ErrorMessages.USERNAME_NOT_FOUND);
		home = user.clickonHomeMenu();
		login = home.clickonSignoutButton();
		login.enterUsername(uName);
		login.enterUserPassword(password);
		home = login.clickonLoginwithoutEndTourButton();
		// Check if we r in homePage--homepagetitle get
		String acthomeTitle = home.getHomePageTitle();
		Assert.assertEquals(acthomeTitle, exphomepageTitle, ErrorMessages.INVALID_TITLE);

	}

	@Test
	public void verify_009_deleteUser() {
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
		user = home.clickonUserMgUsers();
		adduser = home.clickAddButton();

		adduser.enterPrefix(expPrefix);
		adduser.enterFirstName(fName);
		adduser.enterLastName(lName);
		adduser.enterEmail(eMail);
		adduser.enterUsername(uName);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(confirmPassword);

		adduser.enterSCPercent(expscpercent);
		user = adduser.clickonSaveButton();
		user.searchuser(uName);
		String acttableUserName = user.getusername();
		Assert.assertEquals(acttableUserName, uName, ErrorMessages.USERNAME_NOT_FOUND);
		user.clickonDeleteButton();
		user.clickonokDeleteButton();
		Boolean actDeleteMessage = user.checkDeleteUserErrorIsDisplayed();
		Assert.assertTrue(actDeleteMessage, ErrorMessages.USER_NOT_FOUND);
	}

	@Test
	public void tc_010_verifyAddNewProduct() throws AWTException, InterruptedException {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expusername = data.get(0).get(1);
		String exppassword = data.get(1).get(1);
		login = new LoginPage1(driver);

		login.enterUsername(expusername);
		login.enterUserPassword(exppassword);
		home = login.clickonLoginButton();
		home.ClickonProducts();
		addnewproduct = home.ClickonAddProduct();
		addnewproduct.ClickonBrowse();
		
		

	}
}
