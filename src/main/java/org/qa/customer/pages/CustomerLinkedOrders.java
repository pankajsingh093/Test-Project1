package org.qa.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.qa.gittracker.utils.ElementUtil;


public class CustomerLinkedOrders {
	private WebDriver driver;
	private ElementUtil util;

	private By linkedOrdersMenuItem = By.xpath("//span[@class='mat-list-item-content']//span[text()='Linked Orders']");
	private By ContainerNoXpath = By.xpath("(//input[contains(@id,'mat-input-')])");
	private By rownCount = By.xpath("(//div[@class='row'])[1]");

	public CustomerLinkedOrders(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	public void createLinkedOrders() throws InterruptedException {

		util.fluentWaitPresenceOfWebElement(linkedOrdersMenuItem).click();
		Thread.sleep(2000);
		// System.out.println(GitTrackerConstants.containerNo);

	}

	public int getRowCount() throws InterruptedException {
		WebElement ele = util.fluentWaitPresenceOfWebElement(rownCount);
		return ele.findElements(rownCount).size();
	}

	public void searchContainerNo() throws InterruptedException {

		util.getWebelement(ContainerNoXpath).sendKeys(GitTrackerConstants.containerNo);
		Thread.sleep(2000);
		WebElement ele = util.getWebelement(ContainerNoXpath);
		ele.sendKeys(Keys.ENTER);
	}
}
