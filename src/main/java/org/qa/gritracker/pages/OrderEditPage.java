package org.qa.gritracker.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.utils.ElementUtil;

public class OrderEditPage {
	
	private WebDriver driver;
	
	private By containerNumber = By.xpath("//mat-table[@role='table']//a");
	private By transitContainerNumber = By.xpath("(//mat-table[@role='table']//a)[2]");
	private By drivertransitContainerNumber = By.xpath("(//mat-table[@role='table']//a)[3]");
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
	
	private By editdriverDropdown = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[11]");
	
	private By editdriverSearch = By.xpath("(//div[contains(@id, 'mat-select-')]//input)");
	
	private By editdriverDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option)[1]");
	
	private By editTruckDropdown = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[10]");
	
	private By editTruckSearch = By.xpath("(//div[contains(@id, 'mat-select-')]//input)");
	
	private By editTruckDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option)[1]");
	
	private By editOriginDropdown = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[8]");
	
	private By editOriginSearch = By.xpath("(//div[contains(@id, 'mat-select-')]//input)");
	
	private By editOriginDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option)[1]");
	
	private By editdestinationDropdown = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[9]");
	
	private By editdestinationSearch = By.xpath("(//div[contains(@id, 'mat-select-')]//input)");
	
	private By editdestionationDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option)[1]");
	
	private By inTransitText = By.xpath("//span[@class='mat-simple-snack-bar-content']");
	
	private By editContainerSizeDropdown = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[5]");
	
	private By editContainerDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By editChesisDropdown = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[15]");
	
	private By editChesisSearch = By.xpath("(//div[contains(@id, 'mat-select-')]//input)");
	
	private By editChesisDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option)[1]");
	
	private By editPageHeader = By.xpath("//h2[contains(@id,'mat-dialog-title-')]");
	
	private By searchOrderNumber = By.xpath("(//input[contains(@id,'mat-input-')])[1]");
	
	private By editDispatcherDropdown = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[13]");
	
	private By editDispatcherSearch = By.xpath("(//div[contains(@id, 'mat-select-')]//input)");
	
	private By editDispatcherDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option)[1]");
	
	
	/**
	 * completed tab
	 * @param driver
	 */
	private By completedTab = By.xpath("//span[text()='Completed']");
	private By openTab = By.xpath("//span[text()='Open']");
	
	private ElementUtil eleUtil; //mat-select-14-panel
	
	
	public OrderEditPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public void makingStatuRequested() throws InterruptedException {
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDDRequested).click();
		Thread.sleep(5000);
		eleUtil.fluentWaitTillElementClickable(requestedTxt).click();
		Thread.sleep(2000);
		
		enterTruckDriverData();
		
		Thread.sleep(2000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
		Thread.sleep(2000);
	}
	
	public void makingStatusDispactch() throws InterruptedException {
		
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDD).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(dispatchedTxt).click();
		Thread.sleep(3000);
		enterOrigindestinationData();
		
		Thread.sleep(1000);
		enterTruckDriverData();

		Thread.sleep(1000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
	}
	
	public void makingStatuInTransit() throws InterruptedException {
		
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(statusDDTransit).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(inTransitTxt).click();
		Thread.sleep(2000);
		driver.findElement(editContainerSizeDropdown).click();
		Thread.sleep(2000);
		driver.findElement(editContainerDataList).click();
		Thread.sleep(2000);
		enterOrigindestinationData();
		Thread.sleep(2000);
		enterTruckDriverData();
		Thread.sleep(2000);
		eleUtil.fluentWaitPresenceOfWebElement(editChesisDropdown).click();
		Thread.sleep(2000);
		driver.findElement(editChesisSearch).sendKeys("2001");
		Thread.sleep(2000);
		driver.findElement(editChesisDropDownDataList).click();
		Thread.sleep(2000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
	}
	
	public void makingStatuInDelivered() throws InterruptedException {
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(containerNumber).click();
		Thread.sleep(3000);
		String reText = getEditPageHeaderText();
		Thread.sleep(2000);
		eleUtil.fluentWaitTillElementClickable(statusDDDelivered).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(deliveredTxt).click();
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
		Thread.sleep(3000);
		clickCompleteTab();
		Thread.sleep(2000);
		WebElement ele = eleUtil.fluentWaitPresenceOfWebElement(searchOrderNumber);
		System.out.println(reText);
		ele.sendKeys(reText);
		Thread.sleep(3000);
		ele.sendKeys(Keys.ENTER);
		
	}
	
	public void driverInTransit() throws InterruptedException {
		Thread.sleep(2000);
		clickOpenTab();
		Thread.sleep(2000);
		eleUtil.fluentWaitTillElementClickable(transitContainerNumber).click();
		Thread.sleep(3000);
		enterDeliveredStatusData();
		
		Thread.sleep(2000);
		eleUtil.fluentWaitTillElementClickable(drivertransitContainerNumber).click();
		Thread.sleep(3000);
		enterDeliveredStatusData();
	}
	
	public void vehicleInTransit() throws InterruptedException {
		
		eleUtil.fluentWaitPresenceOfWebElement(editdriverDropdown).click();
			
		driver.findElement(editdriverSearch).sendKeys("Fong");
			
		driver.findElement(editdriverDropDownDataList).click();
			
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(cancelBttn);
	}
	
	public String  getUpdatedStatus() throws InterruptedException {
		 Thread.sleep(3000);
		 String txt = eleUtil.fluentWaitPresenceOfWebElement(dispatchedUpdatedStatus).getText();
		 return txt;
	}
	
	public String getOpenTabCount() throws InterruptedException {
		WebElement ele = eleUtil.fluentWaitPresenceOfWebElement(openCountZero);
		return ele.getText();
	}
	
	public String getEditPageHeaderText() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement ele = eleUtil.fluentWaitPresenceOfWebElement(editPageHeader);
		String text = ele.getText();
		String reText = text.substring(text.indexOf('#')+1, text.indexOf('M')-3);
		return reText;
	}
	
	public void clickCompleteTab() throws InterruptedException {
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(completedTab).click();
		
	}

	public void clickOpenTab() throws InterruptedException {
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(openTab).click();
		
	}
	public String getText() throws InterruptedException {
		 String str = driver.findElement(inTransitText).getText();
		 Thread.sleep(2000);
		 //eleUtil.fluentWaitPresenceOfWebElement(inTransitText).getText();
		 System.out.println(str);
		 return str;
	}
	
	private void enterDeliveredStatusData() throws InterruptedException {
		
		eleUtil.fluentWaitTillElementClickable(statusDDTransit).click();
		Thread.sleep(3000);
		eleUtil.fluentWaitTillElementClickable(inTransitTxt).click();
		Thread.sleep(2000);
		driver.findElement(editContainerSizeDropdown).click();
		Thread.sleep(2000);
		driver.findElement(editContainerDataList).click();
		Thread.sleep(2000);
		enterOrigindestinationData();
		Thread.sleep(2000);
		enterTruckDriverData();
		Thread.sleep(2000);
		
		eleUtil.fluentWaitPresenceOfWebElement(editDispatcherDropdown).click();
		Thread.sleep(2000);
		driver.findElement(editDispatcherSearch).sendKeys("Pankaj");
		Thread.sleep(2000);
		driver.findElement(editDispatcherDropDownDataList).click();
		Thread.sleep(2000);
		eleUtil.fluentWaitPresenceOfWebElement(editChesisDropdown).click();
		Thread.sleep(2000);
		driver.findElement(editChesisSearch).sendKeys("2001");
		Thread.sleep(2000);
		driver.findElement(editChesisDropDownDataList).click();
		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(saveBttn);
		Thread.sleep(1000);
	}
	
	private void enterTruckDriverData() throws InterruptedException {
		String truckData = driver.findElement(By.xpath("//mat-label[text()='Truck']")).getText();
		
		String driverData = driver.findElement(By.xpath("//mat-label[text()='Driver']")).getText();
		
		if(truckData.contains("Truck")) {
		eleUtil.fluentWaitPresenceOfWebElement(editTruckDropdown).click();
		
		driver.findElement(editTruckSearch).sendKeys("Other");
		
		driver.findElement(editTruckDropDownDataList).click();
		}
		Thread.sleep(1000);
		
		if(driverData.contains("Driver")) {
		eleUtil.fluentWaitPresenceOfWebElement(editdriverDropdown).click();
		
		driver.findElement(editdriverSearch).sendKeys("One");
		
		driver.findElement(editdriverDropDownDataList).click();
		}
	}
	
	private void enterOrigindestinationData() throws InterruptedException {
		String orgnData = driver.findElement(By.xpath("//mat-label[text()='Origin']")).getText();
		
		String destiData = driver.findElement(By.xpath("//mat-label[text()='Destination']")).getText();
		
		if(orgnData.contains("Origin")) {
		eleUtil.fluentWaitPresenceOfWebElement(editOriginDropdown).click();
		
		driver.findElement(editOriginSearch).sendKeys("AMG");
		
		driver.findElement(editOriginDropDownDataList).click();
		}
		
		if(destiData.contains("Destination")) {
		eleUtil.fluentWaitPresenceOfWebElement(editdestinationDropdown).click();
		
		Thread.sleep(2000);
		driver.findElement(editdestinationSearch).sendKeys("10");
		
		driver.findElement(editdestionationDropDownDataList).click();
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
	
	
	

}
