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
	
	private By originDD = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[4]");
	private By originDDData = By.xpath("//span[contains(text(), 'PriceSmart')]");
	

	private By destinationDD = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[5]");
	private By destinationDDData = By.xpath("(//mat-option//span[contains(text(), '')])[1]");
	
	private By shippingLineDD = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[6]");
	private By shippingLineDDData = By.xpath("(//mat-option//span[contains(text(), '')])[2]");
	
	private By contents = By.xpath("//input[@formcontrolname='contents']");
	private By deptCode = By.xpath("//input[@formcontrolname='departmentCode']");
	private By notes = By.xpath("//textarea[@formcontrolname='notes']");
	
	private By submitButton = By.xpath("//span[text()=' Send Request ']");
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
		util.getWebelement(originDD).click();
		util.getWebelement(originDDData).click();
		util.getWebelement(destinationDD).click();
		util.getWebelement(destinationDDData).click();;
		util.getWebelement(shippingLineDD).click();
		util.getWebelement(shippingLineDDData).click();
		
		util.getWebelement(contents).sendKeys("Contents");
		util.getWebelement(deptCode).sendKeys("code1234");
		util.getWebelement(notes).sendKeys("Automation is going on");
		
		//util.getWebelement(submitButton).click();
	}
	
	public String getSuccessMessage() throws InterruptedException {
		Thread.sleep(2000);
		return util.getWebelement(successMessage).getText();
	}

}
