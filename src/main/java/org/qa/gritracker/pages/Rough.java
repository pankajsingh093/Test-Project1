package org.qa.gritracker.pages;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.qa.gittracker.utils.ElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rough {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	/**
	 * Search related locators
	 * @param driver
	 */
	
	private By recivedOnHeader = By.xpath("//div[text()=' Received On ']");
	private By searchOrderNumber = By.xpath("//input[@id='mat-input-0']");
	private By openIcon = By.xpath("(//mat-icon[text()='chevron_right'])[2]");
	private By ordernumber = By.xpath("(//p[starts-with(text(), 'GT')])[1]");
	private By rownCount = By.xpath("(//mat-row[@role='row'])[1]");
	
	/**
	 * Edit related Locator
	 * @param driver
	 */
	
	private By containerNumber = By.xpath("//mat-table[@role='table']//a");
	private By statusDD = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[7]");
	
	private By dispatchedTxt = By.xpath("//span[text()='Dispatched ']");
	private By inTransitTxt = By.xpath("//span[text()='In-Transit ']");
	private By deliveredTxt = By.xpath("//span[text()='Delivered ']");
	
	private By saveBttn = By.xpath("//mat-icon[text()='save']");
	private By cancelBttn = By.xpath("//mat-icon[text()='cancel']");
	private By dispatchedUpdatedStatus = By.xpath("//mat-table[@role='table']//mat-cell[6]");
	
	private By statusDDTransit = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[7]");
	
	private By statusDDDelivered = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[7]");
	private By openCountZero = By.xpath("//span[@id='mat-badge-content-0']");
	
	private By statusDDRequested = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[7]");
	private By requestedTxt = By.xpath("//mat-option//span[text()='Requested ']");
	
	private By editdriverDropdown = By.xpath("//mat-select[@id='mat-select-16']");
	
	private By editdriverSearch = By.cssSelector("#mat-input-12");
	
	private By editdriverDropDownDataList = By.cssSelector("#mat-select-16-panel mat-option");
	
	private By editTruckDropdown = By.xpath("//mat-select[@id='mat-select-14']");
	
	private By editTruckSearch = By.cssSelector("#mat-input-11");
	
	private By editTruckDropDownDataList = By.cssSelector("#mat-select-14-panel mat-option");
	
	private By inTransitText = By.xpath("//span[@class='mat-simple-snack-bar-content']");
	
	/**
	 * completed tab
	 * @param driver
	 */
	private By completedTab = By.xpath("//span[text()='Completed']");
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public String  getUpdatedStatus() throws InterruptedException {
		Thread.sleep(2000);
		 String txt = eleUtil.fluentWaitPresenceOfWebElement(dispatchedUpdatedStatus).getText();
		 return txt;
	}
	
	
	public void makingStatuRequested() throws InterruptedException {
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDDRequested).click();
		Thread.sleep(5000);
		eleUtil.fluentWaitTillElementClickable(requestedTxt).click();
		Thread.sleep(1000);
		eleUtil.fluentWaitPresenceOfWebElement(editTruckDropdown).click();
		
		searchDropDownTextAndClick("Other", editTruckSearch, editTruckDropDownDataList);
		Thread.sleep(1000);
		eleUtil.fluentWaitPresenceOfWebElement(editdriverDropdown).click();
		
		searchDropDownTextAndClick("One", editdriverSearch, editdriverDropDownDataList);
		Thread.sleep(2000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
	}

	
	public void makingStatusDispactch() throws InterruptedException {
		
		//searchData();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDD).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(dispatchedTxt).click();
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
	}
	
	public void makingStatuInTransit() throws InterruptedException {
		
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDDTransit).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(inTransitTxt).click();
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
	}
	
	public void checkDriverInTransit() throws InterruptedException {
		
		makingStatuInTransit();
		Thread.sleep(2000);
		eleUtil.waitScrollTillWebElementAndClick(cancelBttn);
	}
	
	private By editdriverSearchForVechileInTransit = By.xpath("//input[@id='mat-input-78']");
	
	private By editdriverDropDownDataListForVechileInTransit = By.cssSelector("#mat-select-94-panel mat-option span");
	
	public void checkVehicleInTransit() throws InterruptedException {
		
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDDTransit).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(inTransitTxt).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//mat-select[contains(@id, 'mat-select-')])[11]")).click();
		Thread.sleep(1500);
		driver.findElement(editdriverSearchForVechileInTransit).sendKeys("fong");
		Thread.sleep(1500);
		driver.findElement(editdriverDropDownDataListForVechileInTransit).click();
		//Thread.sleep(2000);
		//searchDropDownTextAndClick("fong", editdriverSearchForVechileInTransit, editdriverDropDownDataListForVechileInTransit);
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
		Thread.sleep(2000);
		eleUtil.waitScrollTillWebElementAndClick(cancelBttn);
	}
	
	public void makingStatuInDelivered() throws InterruptedException {
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDDDelivered).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(deliveredTxt).click();
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
		Thread.sleep(2000);
	}
	
	public void clickCompleteTab() throws InterruptedException {
		eleUtil.fluentWaitTillElementClickable(completedTab).click();
		searchData();
	}
	

	
	public String getText() {
		return eleUtil.fluentWaitPresenceOfWebElement(inTransitText).getText();
	}
	
	public String getOrderSuccessMessage() {
		return eleUtil.waitForVisibilityOfWebElement(orderSuccessMessage).getText();
	}
	
	public void createOrder() throws InterruptedException {
		
		eleUtil.fluentWaitPresenceOfWebElement(orderBtn).click();
		
		Thread.sleep(4000);
		eleUtil.fluentWaitTillElementClickable(customerDropdown).click();
		eleUtil.waitForPresenceOfWebElement(customerSearch).sendKeys("129 Properties Limited");
		eleUtil.waitForPresenceOfWebElement(customerDropDownValue).click();
		eleUtil.waitForVisibilityOfWebElement(containerName).sendKeys(generateRamdomNo(10));
		
		eleUtil.fluentWaitPresenceOfWebElement(containerSize).click();
		selectContaineSizeValue(2);
		
		eleUtil.fluentWaitPresenceOfWebElement(loadedCB).click();
		
		clickOnCB(GitTrackerConstants.cBList);
		
		WebElement tymreceived = eleUtil.fluentWaitPresenceOfWebElement(timeReceived);
		
		//tymreceived.sendKeys(Keys.CONTROL+ "a");
		
		//tymreceived.sendKeys(Keys.BACK_SPACE);
		
		//tymreceived.sendKeys("Feb 25, 2025 13:05 PM");
		
		eleUtil.fluentWaitPresenceOfWebElement(appointment).sendKeys("Feb 25, 2025 13:05 PM");
		
		eleUtil.fluentWaitPresenceOfWebElement(waitingStartTime).sendKeys("12:00 PM");
		eleUtil.fluentWaitPresenceOfWebElement(waitingEndTime).sendKeys("14:00 PM");
		
		eleUtil.fluentWaitPresenceOfWebElement(originDropdown).click();
		
		searchDropDownTextAndClick(GitTrackerConstants.ORIGIN_DROPDOWN_DATA.trim(), originSearch, originDropDownDataList);
		
		eleUtil.fluentWaitPresenceOfWebElement(destinationDropdown).click();
		
		searchDropDownTextAndClick(GitTrackerConstants.DESTINATION_DROPDOWN_DATA.trim(), destinationSearch, destinationDropDownDataList);
		eleUtil.fluentWaitPresenceOfWebElement(contents).sendKeys("testing");
		
		eleUtil.fluentWaitPresenceOfWebElement(shippingLineDropdown).click();
		
		searchDropDownTextAndClick("CMA", shippingLineSearch, shippingLineDropDownDataList);
		eleUtil.fluentWaitPresenceOfWebElement(truckDropdown).click();
		
		searchDropDownTextAndClick("Other", truckSearch, truckDropDownDataList);
		eleUtil.fluentWaitPresenceOfWebElement(driverDropdown).click();
		
		searchDropDownTextAndClick("One", driverSearch, driverDropDownDataList);
		
		eleUtil.fluentWaitPresenceOfWebElement(chesisDropdown).click();
		
		searchDropDownTextAndClick("2001", chesisSearch, chesisDropDownDataList);
		
		eleUtil.fluentWaitPresenceOfWebElement(brokerDropdown).click();
		
		searchDropDownTextAndClick("Clive", brokerSearch, brokerDropDownDataList);
		
		eleUtil.fluentWaitPresenceOfWebElement(notesTextArea).sendKeys("this is automation");
		
		WebElement attach = driver.findElement(attachment);
		File file = new File("./src/test/resources/attachment/Screenshot.png");
		String absPath = file.getAbsolutePath();
	//	eleUtil.waitScrollTillWebElement(attach).sendKeys(absPath);
		
		eleUtil.waitScrollTillWebElementAndClick(saveBtn);
		
	}
	
	
	
	
	
	
	
	
	
	public int getRowCount() throws InterruptedException {
		WebElement ele = eleUtil.fluentWaitPresenceOfWebElement(rownCount);
		return ele.findElements(rownCount).size();
	}
	
	public String getOpenTabCount() throws InterruptedException {
		WebElement ele = eleUtil.fluentWaitPresenceOfWebElement(openCountZero);
		return ele.getText();
	}
	
	/**
	 * All PRIVATE method for this class only
	 * @param lenght
	 * @return
	 */
	
	private String generateRamdomNo(int lenght) {
		String ContainerNo ="TEST##1$$234a";
		Random randomSrting =new Random();
		StringBuilder randomString=new StringBuilder();
		for (int i=0; i < lenght; i++)
		{
			int randomIndex=randomSrting.nextInt(ContainerNo.length());
			randomString.append(ContainerNo.charAt(randomIndex));
		}
		System.out.println("ContainerNo" + randomString.toString());
		return randomString.toString();
	}
	
	private void clickOnHeaderAndGetDescOrder() throws InterruptedException {
		for(int i=0;i<2;i++) {
			Thread.sleep(3000);
			eleUtil.fluentWaitTillElementClickable(recivedOnHeader).click();
		}
	}
	
	
	private void selectContaineSizeValue(int num) {
		eleUtil.waitForPresenceOfWebElement(By.xpath("(//span[@class='mat-option-text'])["+ num +"]")).click();
	}
	
	private void clickOnCB(List<String> listCB) {
		
		for(int i=0;i<listCB.size();i++) {
			eleUtil.fluentWaitPresenceOfWebElement(By.xpath("//span[text()='"+ listCB.get(i) +"']")).click();
		}
		
	}
	
	private void searchDropDownTextAndClick(String searchData, By searchLocator, By listLocator) throws InterruptedException {
		WebElement origniData = eleUtil.fluentWaitPresenceOfWebElement(searchLocator);
		//Thread.sleep(3000);
		List<WebElement> orgnList = driver.findElements(listLocator);
		
		for(WebElement list : orgnList) {
			String text = list.getText();
			
			if(text.contains(searchData)) {
				origniData.sendKeys(text);
				list.click();
				break;
			}
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority = 1)
	public void testSearchOrder() throws InterruptedException {
		//op.searchData();
		Assert.assertEquals(op.getRowCount(), 1);
	}

	@Test(priority = 2)
	public void testRequested() throws InterruptedException {
		op.makingStatuRequested();
		Assert.assertEquals(op.getUpdatedStatus().trim(), "Requested");
	}

	@Test(priority = 3)
	public void testDispatchEvent() throws InterruptedException {
		op.makingStatusDispactch();
		Assert.assertEquals(op.getUpdatedStatus().trim(), "Dispatched");
	}
	

	@Test(priority = 4)
	public void testDriverInTransit() throws InterruptedException {
		op.checkDriverInTransit();
		 Assert.assertEquals(op.getText().trim(), "Driver is already in transit");
		//Assert.assertEquals(op.getText().trim(), "Vehicle is already in transit");
	}

	@Test(priority = 5)
	public void testVehicleInTransit() throws InterruptedException {
		op.checkVehicleInTransit();
		 Assert.assertEquals(op.getText().trim(), "Vehicle is already in transit");
		//Assert.assertEquals(op.getText().trim(), "Driver is already in transit");
	}

	@Test(priority = 6, enabled = false)
	public void testInTransit() throws InterruptedException {
		op.makingStatuInTransit();
		Assert.assertEquals(op.getUpdatedStatus().trim(), "In-Transit");
	}


	@Test(priority = 7)
	public void testDelivered() throws InterruptedException {
		op.makingStatuInDelivered();
		Assert.assertEquals(op.getOpenTabCount(), "0");
	}

	@Test(priority = 8)
	public void testItemMoveToDeliveredTab() throws InterruptedException {
		op.clickCompleteTab();
		Assert.assertEquals(op.getUpdatedStatus().trim(), "Delivered");
	}

}
