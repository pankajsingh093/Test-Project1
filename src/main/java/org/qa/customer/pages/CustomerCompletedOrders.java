package org.qa.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.qa.gittracker.utils.ElementUtil;

public class CustomerCompletedOrders {
	private WebDriver driver;
	private ElementUtil util;
	String txt;
	private By ordrRequestMenuItem = By
			.xpath("//span[@class='mat-list-item-content']//span[text()='Completed Orders']");
	
	/* Filter related locators */
	private By filterXpath = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[1]");
	private By filterdata = By.xpath("//span[contains(text(), 'Yesterday')]");
	private By filterdata1 = By.xpath("//span[contains(text(), 'Last Week')]");
    
	/* Search related locators */
	private By shortxpath = By.xpath("//div[text()=' Container No. ']");
	private By searchOrderNumber = By.xpath("//input[@type='search']");
	private By Containervalue = By.xpath("(//div[contains(@class, 'col-sm-6')])[5]");
	private By openOrder = By.xpath("(//mat-cell[@role='cell'])[1]");
	private By closeXpath = By.xpath("//span[contains(text(), 'Close')]");
	private By rownCount = By.xpath("(//mat-row[@role='row'])[1]");
	
	/* Adv Search related locators */
	private By advfilterXpath = By.xpath("(//span[@class='mat-button-wrapper'])[10]");
	private By ContainerNoXpath = By.xpath("(//input[contains(@id,'mat-input-')])[2]");
	private By advSearchXpath = By.xpath("//button[@type='submit']");
	private By trukerXpath = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[3]");
	private By trukerData = By.xpath("//span[contains(text(), ' D&B Trucking Ltd ')]");
	private By containerSizeXpath= By.xpath("(//input[contains(@id,'mat-input-')])[3]");
	private By originXpath = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[4]");
	private By originData = By.xpath("//span[contains(text(), ' 1 E ASHENHEIM (Pricesmart) ')]");
	private By disXpath = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[5]");
	private By disData = By.xpath("//span[contains(text(), ' 1 E ASHENHEIM (Pricesmart) ')]");
	private By closepopUpXpath= By.xpath("//h2[@id='mat-dialog-title-2']");
	private By containerTypeXpath= By.xpath("(//mat-select[contains(@id, 'mat-select-')])[6]");
	private By containerTypeData = By.xpath("//span[contains(text(), 'Dry')]");
	
	

	public CustomerCompletedOrders(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	public String getOrderPageUrl() throws InterruptedException {
		return driver.getCurrentUrl();
	}

	public void moveCustomerCompletedOrders() throws InterruptedException {
		util.fluentWaitPresenceOfWebElement(ordrRequestMenuItem).click();
		Thread.sleep(2000);
		util.getWebelement(filterXpath).click();
		util.getWebelement(filterdata).click();
		Thread.sleep(2000);
		util.getWebelement(filterXpath).click();
		util.getWebelement(filterdata1).click();
	}

	public int getRowCount() throws InterruptedException {
		WebElement ele = util.fluentWaitPresenceOfWebElement(rownCount);
		return ele.findElements(rownCount).size();
	}

	public void clickOnHeaderAndGetDescOrder() throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			Thread.sleep(3000);
			util.fluentWaitTillElementClickable(shortxpath).click();
		}
	}

	public void searchData() throws InterruptedException {
		clickOnHeaderAndGetDescOrder();
		Thread.sleep(2000);
		util.fluentWaitTillElementClickable(openOrder).click();
		Thread.sleep(1000);
		searchOrderNumber();

	}

	private void searchOrderNumber() throws InterruptedException {
		Thread.sleep(2000);
		util.getWebelement(closeXpath).click();
		txt = getOrderNumber();
		WebElement ele = util.fluentWaitPresenceOfWebElement(searchOrderNumber);
		Thread.sleep(1000);
		ele.sendKeys(txt);
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		ele.clear();
	}

	public String getOrderNumber() {
		String txt = util.fluentWaitPresenceOfWebElement(Containervalue).getText();
		return txt;
	}

	public void advSearch() throws InterruptedException {

		advSearchOrderNumber();
	}

	public void advSearchOrderNumber() throws InterruptedException {
		Thread.sleep(2000);
		util.getWebelement(advfilterXpath).click();
		WebElement ele = util.fluentWaitPresenceOfWebElement(ContainerNoXpath);
		Thread.sleep(1000);
		ele.sendKeys(txt);
		//util.getWebelement(trukerXpath).click();
		//util.getWebelement(trukerData).click();
		 util.getWebelement(containerSizeXpath).sendKeys("20");
		//util.getWebelement(originXpath).click();
		//util.getWebelement(originData).click();
		//Thread.sleep(3000);
		//util.getWebelement(closepopUpXpath).click();
		//util.getWebelement(disXpath).click();
		//util.getWebelement(disData).click();
		//util.getWebelement(containerTypeXpath).click();
		//util.getWebelement(containerTypeData).click();
		util.getWebelement(advSearchXpath).click();

	}
}
