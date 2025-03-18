package org.qa.gritracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.utils.ElementUtil;

public class OrderPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By orderBtn = By.xpath("//*[text()='add']");
	
	private By customerDropDownValue = By.xpath("//mat-option[contains(@id, 'mat-option-')]//span[text()='129 Properties Limited ']");
	
	private By customerSearch = By.cssSelector("#mat-input-3");
	
	private By customerDropdown = By.xpath("//mat-select[@id='mat-select-10']");
	
	private By containerName = By.xpath("//input[@id='mat-input-15']");
	
	private By saveBtn = By.xpath("//mat-icon[text()='save']");
	
	private By orderSuccessMessage = By.xpath("//*[text()='Order saved successfully']");
	
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public String getOrderPageUrl() throws InterruptedException {
		return driver.getCurrentUrl();
	}
	
	public String getOrderSuccessMessage() {
		return eleUtil.waitForVisibilityOfWebElement(orderSuccessMessage).getText();
	}
	
	public void createOrder() throws InterruptedException {
		Thread.sleep(7000);
		eleUtil.waitForVisibilityOfWebElement(orderBtn).click();
		
		Thread.sleep(7000);
		
		driver.findElement(customerDropdown).click();
		
		eleUtil.waitForPresenceOfWebElement(customerSearch).sendKeys("129 Properties Limited");
		eleUtil.waitForPresenceOfWebElement(customerDropDownValue).click();
		eleUtil.waitForPresenceOfWebElement(containerName).sendKeys("SLM1234");
		
		WebElement ele = driver.findElement(saveBtn);
		
		eleUtil.waitScrollTillWebElementAndClick(ele);
	}
	
	
	

}
