package com.qalegendbilling.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public String getPageTitle(WebDriver driver){
        String title=driver.getTitle();
        return title;
    }
    public  void clickOnElement(WebElement element){
        element.click();
    }
    public  void enterText(WebElement element,String text){
        element.sendKeys(text);
    }
    public void simpleAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void confirmationAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void promptAlert(WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
    public String getElementText(WebElement element) {
        String text = element.getText();
        return text;
    }
    
    //ScrollBy
    public void scrolldown(WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,350)", "");
    
    }

    //Select By Index
    public void dropdown_SelectByIndex(WebDriver driver, int i) {
    	WebElement ComputersDropdown = driver.findElement(By.xpath("//a[@class='hover']"));
    	Select select = new Select(ComputersDropdown);
    	select.selectByIndex(1);
    }
    //Select By value
    public void dropdown_SelectByValue(WebDriver driver, String compDropdownvalue) {
    	WebElement ComputersDropdown = driver.findElement(By.xpath("//a[@class='hover']"));
    	Select select = new Select(ComputersDropdown);
    	select.selectByValue("Desktops");
    }
  //Select By visibleText
    public void dropdown_SelectByVisibleText(WebDriver driver, String compDropdownvalue) {
    	WebElement ComputersDropdown = driver.findElement(By.xpath("//a[@class='hover']"));
    	Select select = new Select(ComputersDropdown);
    	select.selectByValue("Notebooks");
    }
    public boolean isDisplayed(WebElement target) {
        boolean displayStatus = target.isDisplayed();
        return displayStatus;
    }
    
}
