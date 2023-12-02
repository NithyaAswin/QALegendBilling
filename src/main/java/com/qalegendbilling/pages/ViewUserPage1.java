package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ViewUserPage1 extends TestHelperUtility {
	public WebDriver driver;

	public ViewUserPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _viewuser = "//tr[@class='odd']//following-sibling::td";
	@FindBy(xpath = _viewuser)
	private WebElement viewuser;
	
	public String getviewUser()
	{
		String viewusername = page.getElementText(viewuser);
		return viewusername;
	}
}