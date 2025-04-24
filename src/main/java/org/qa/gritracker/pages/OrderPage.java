package org.qa.gritracker.pages;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.qa.gittracker.utils.ElementUtil;

public class OrderPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By orderBtn = By.xpath("//*[text()='add']");
	
	private By customerDropdown = By.xpath("//mat-select[@id='mat-select-10']");
	
	private By customerSearch = By.cssSelector("#mat-input-3");

	private By customerDropDownValue = By.xpath("//mat-option[contains(@id, 'mat-option-')]//span[text()='129 Properties Limited ']");
	
	private By containerName = By.xpath("(//input[contains(@id,'mat-input-')])[2]");
	
	private By saveBtn = By.xpath("//mat-icon[text()='save']");
	
	private By orderSuccessMessage = By.xpath("//*[text()='Order saved successfully']");
	
	private By containerSize = By.xpath("(//mat-select[contains(@id,'mat-select-')])[7]");
	
	private By loadedCB = By.xpath("//span[text()='Loaded']");
	
	private By timeReceived = By.xpath("//input[@id = 'mat-input-4']");
	
	private By appointment = By.xpath("(//input[contains(@id,'mat-input-')])[4]");
	
	private By waitingStartTime = By.xpath("(//input[contains(@id,'mat-input-')])[5]");
	
	private By waitingEndTime = By.xpath("(//input[contains(@id,'mat-input-')])[6]");
	
	private By originDropdown = By.xpath("(//mat-select[contains(@id,'mat-select-')])[8]");
	
	private By originSearch = By.xpath("//input[@placeholder='Search']");
	
	private By originDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By destinationDropdown = By.xpath("(//mat-select[contains(@id,'mat-select-')])[9]");
	
	private By destinationSearch = By.xpath("//input[@placeholder='Search']");
	
	private By destinationDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By contents = By.xpath("(//input[contains(@id,'mat-input-')])[8]");
	
	private By shippingLineDropdown = By.xpath("(//mat-select[contains(@id,'mat-select-')])[10]");
	
	private By shippingLineSearch = By.xpath("//input[@placeholder='Search']");
	
	private By shippingLineDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By truckDropdown = By.xpath("(//mat-select[contains(@id,'mat-select-')])[11]");
	
	private By truckSearch = By.xpath("//input[@placeholder='Search']");
	
	private By truckDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By driverDropdown = By.xpath("(//mat-select[contains(@id,'mat-select-')])[12]");
	
	private By driverSearch = By.xpath("//input[@placeholder='Search']");
	
	private By driverDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By chesisDropdown = By.xpath("(//mat-select[contains(@id,'mat-select-')])[13]");
	
	private By chesisSearch = By.xpath("//input[@placeholder='Search']");
	
	private By chesisDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By brokerDropdown = By.xpath("(//mat-select[contains(@id,'mat-select-')])[15]");
	
	private By brokerSearch = By.xpath("//input[@placeholder='Search']");
	
	private By brokerDropDownDataList = By.xpath("(//div[contains(@id, 'mat-select-')]//mat-option/span)[1]");
	
	private By notesTextArea = By.xpath("(//textarea[contains(@id,'mat-input-')])");
	
	private By attachment = By.xpath("//input[@type='file']");
	
    private By SettingXml = By.xpath("(//button[contains(@class, 'mat-focus-indicator mat-menu-trigger mat-icon-button mat-button-base')])");
	private By SignOutBtn = By.xpath("(//*[text()='Sign Out'])");
	private By cancelBtn = By.xpath("//mat-icon[text()='cancel']");

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
	
		
	public OrderPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public String getOrderSuccessMessage() {
		return eleUtil.waitForVisibilityOfWebElement(orderSuccessMessage).getText();
	}
	
	public String getOrderPageUrl() throws InterruptedException {
		return driver.getCurrentUrl();
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
		eleUtil.fluentWaitPresenceOfWebElement(originSearch).sendKeys("Bell");
		eleUtil.fluentWaitPresenceOfWebElement(originDropDownDataList).click();
		
		Thread.sleep(2000);
		eleUtil.fluentWaitPresenceOfWebElement(destinationDropdown).click();
		eleUtil.fluentWaitPresenceOfWebElement(destinationSearch).sendKeys("Bell");
		eleUtil.fluentWaitPresenceOfWebElement(destinationDropDownDataList).click();
		
		eleUtil.fluentWaitPresenceOfWebElement(contents).sendKeys("testing");
		Thread.sleep(2000);
		eleUtil.fluentWaitPresenceOfWebElement(shippingLineDropdown).click();
		eleUtil.fluentWaitPresenceOfWebElement(shippingLineSearch).sendKeys("CGM");
		eleUtil.fluentWaitPresenceOfWebElement(shippingLineDropDownDataList).click();
		Thread.sleep(2000);
		eleUtil.fluentWaitPresenceOfWebElement(truckDropdown).click();
		eleUtil.fluentWaitPresenceOfWebElement(truckSearch).sendKeys("Other");
		eleUtil.fluentWaitPresenceOfWebElement(truckDropDownDataList).click();
		Thread.sleep(2000);
		eleUtil.fluentWaitPresenceOfWebElement(driverDropdown).click();
		eleUtil.fluentWaitPresenceOfWebElement(driverSearch).sendKeys("Fong");
		eleUtil.fluentWaitPresenceOfWebElement(driverDropDownDataList).click();
		Thread.sleep(2000);
		
		eleUtil.fluentWaitPresenceOfWebElement(chesisDropdown).click();
		eleUtil.fluentWaitPresenceOfWebElement(chesisSearch).sendKeys("2001");
		eleUtil.fluentWaitPresenceOfWebElement(chesisDropDownDataList).click();
		Thread.sleep(2000);
		eleUtil.fluentWaitPresenceOfWebElement(brokerDropdown).click();
		eleUtil.fluentWaitPresenceOfWebElement(brokerSearch).sendKeys("Clive");
		eleUtil.fluentWaitPresenceOfWebElement(brokerDropDownDataList).click();
		
		
		eleUtil.fluentWaitPresenceOfWebElement(notesTextArea).sendKeys("this is automation");
		
		WebElement attach = driver.findElement(attachment);
		File file = new File("./src/test/resources/attachment/Screenshot.png");
		String absPath = file.getAbsolutePath();
	//	eleUtil.waitScrollTillWebElement(attach).sendKeys(absPath);
		
		eleUtil.waitScrollTillWebElementAndClick(saveBtn);

		Thread.sleep(3000);
		eleUtil.waitScrollTillWebElementAndClick(cancelBtn);
		
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
		//System.out.println("ContainerNo" + randomString.toString());
		return randomString.toString();
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
	public void logOut() throws InterruptedException {
		System.out.println("Hi");
		eleUtil.fluentWaitTillElementClickable(SettingXml).click();
		eleUtil.fluentWaitPresenceOfWebElement(SignOutBtn).click();
	}



}
