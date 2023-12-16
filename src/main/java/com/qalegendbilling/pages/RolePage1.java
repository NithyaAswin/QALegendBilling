package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class RolePage1 extends TestHelperUtility {
	public WebDriver driver;

	public RolePage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getRolePageTitle()
	{
		String roleTitle = page.getPageTitle(driver);
		return roleTitle;
	}
}
