package org.qa.gritracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.utils.ElementUtil;

public class OrderListPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	/**
	 * Search related locators
	 * 
	 * @param driver
	 */

	private By recivedOnHeader = By.xpath("//div[text()=' Received On ']");
	private By searchOrderNumber = By.xpath("//input[@id='mat-input-2']");
	private By openIcon = By.xpath("(//mat-icon[text()='chevron_right'])[2]");
	private By ordernumber = By.xpath("(//p[starts-with(text(), 'GT')])[1]");
	private By rownCount = By.xpath("(//mat-row[@role='row'])[1]");
	private By containerNumber = By.xpath("//mat-table[@role='table']//a");

	public OrderListPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public String getOrderPageUrl() throws InterruptedException {
		return driver.getCurrentUrl();
	}
	
	public int getRowCount() throws InterruptedException {
		WebElement ele = eleUtil.fluentWaitPresenceOfWebElement(rownCount);
		return ele.findElements(rownCount).size();
	}
	
	public void searchData() throws InterruptedException {
		
		clickOnHeaderAndGetDescOrder();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(openIcon).click();
		Thread.sleep(3000);
		searchOrderNumber();
	}
	
	public void clickOnHeaderAndGetDescOrder() throws InterruptedException {
		for(int i=0;i<2;i++) {
			Thread.sleep(3000);
			eleUtil.fluentWaitTillElementClickable(recivedOnHeader).click();
		}
	}
	
	private void searchOrderNumber() throws InterruptedException {
		String txt = getOrderNumber();
		//System.out.println(txt);
		Thread.sleep(3000);
		WebElement ele = eleUtil.fluentWaitPresenceOfWebElement(searchOrderNumber);
		Thread.sleep(3000); 
		ele.sendKeys(txt);
		ele.sendKeys(Keys.ENTER);
	}
	
	public String getOrderNumber() {
		String txt = eleUtil.fluentWaitPresenceOfWebElement(ordernumber).getText();
		return txt;
	}
	
	public void clickOnContainerNumber() {
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		
	}
}
