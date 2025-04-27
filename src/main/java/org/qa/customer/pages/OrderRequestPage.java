package org.qa.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.qa.gittracker.utils.ElementUtil;

public class OrderRequestPage {

	private WebDriver driver;
	private ElementUtil util;

	private By ordrRequestMenuItem = By.xpath("//span[@class='mat-list-item-content']//span[text()='Order Request']");
	private By typeDD = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[1]");
	private By typeDDData = By.xpath("//span[contains(text(), 'Move')]");

	private By truckDD = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[2]");

	private By chesisDD = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[3]");
	private By chesisDDData = By.xpath("//span[contains(text(), 'Trucker (40 ft)')]");

	private By containerNumber = By.xpath("//section[@class='ng-star-inserted']//input[contains(@id, 'mat-input-')]");

	private By originXpath = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[4]");
	private By originData = By.xpath("//span[contains(text(), '1 E ASHENHEIM (Pricesmart)')]");

	private By shippingLineXpath = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[6]");
	private By shippingLineData = By.xpath("//span[contains(text(), 'CMA CGM')]");

	private By destinationXpath = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[5]");
	private By destinationData = By.xpath("//span[contains(text(), '31 Mannings Hill  (Pricesmart)')]");

	private By contentsXpath = By.xpath("(//input[contains(@id,'mat-input-')])[2]");

	private By deptXpath = By.xpath("(//input[contains(@id,'mat-input-')])[3]");

	private By noteXpath = By.xpath("(//textarea[contains(@id,'mat-input-')])");

	private By SendRequest = By.xpath("//span[normalize-space()='Send Request']");
	private By successMessage = By.xpath("//div[text()=' Order Request Submitted Successfully ']");

	public OrderRequestPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	public void createMoveOrderRequest() throws InterruptedException {

		util.fluentWaitPresenceOfWebElement(ordrRequestMenuItem).click();
		Thread.sleep(2000);

	}

	public String getOrderPageUrl() throws InterruptedException {
		return driver.getCurrentUrl();
	}
	public void sendRequest() throws InterruptedException {
		WebElement dd = util.getWebelement(typeDD);
		if (dd.isDisplayed()) {
			util.clickOnElement(dd);
		}
		util.getWebelement(typeDDData).click();
		util.getWebelement(truckDD).click();
		WebElement ele = util.getWebelement(truckDD);
		ele.sendKeys(Keys.ENTER);
		util.getWebelement(chesisDD).click();
		util.getWebelement(chesisDDData).click();
		util.getWebelement(containerNumber).sendKeys(util.generateRamdomNo(7));
		util.clickOnCB(GitTrackerConstants.customerCBList);

		util.getWebelement(originXpath).click();
		Thread.sleep(5000);
		util.fluentWaitPresenceOfWebElement(originData).click();

		util.getWebelement(destinationXpath).click();
		Thread.sleep(2000);
		util.getWebelement(destinationData).click();

		util.getWebelement(shippingLineXpath).click();
		Thread.sleep(2000);
		util.getWebelement(shippingLineData).click();

		Thread.sleep(2000);
		util.getWebelement(contentsXpath).sendKeys("Mobile Phone");

		Thread.sleep(2000);
		util.getWebelement(deptXpath).sendKeys("TESTDEPT1");

		Thread.sleep(2000);
		util.getWebelement(noteXpath).sendKeys("Order received. Processing now. Will update when shipped.");
		util.getWebelement(SendRequest).click();
	}
	
	public String getSuccessMessage() throws InterruptedException {
		Thread.sleep(2000);
		return util.getWebelement(successMessage).getText();
	}

}
