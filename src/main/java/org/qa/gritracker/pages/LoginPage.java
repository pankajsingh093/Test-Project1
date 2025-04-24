package org.qa.gritracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.gittracker.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil util;

	private By email = By.xpath("(//input[contains(@id, 'mat-input-')])[1]");
	private By pwd = By.xpath("(//input[contains(@id, 'mat-input-')])[2]");
	private By loginBtn = By.xpath("//*[text()='login']");

	private By SettingXml = By.xpath("(//button[contains(@class, 'mat-focus-indicator mat-menu-trigger mat-icon-button mat-button-base')])");
	private By SignOutBtn = By.xpath("(//*[text()='Sign Out'])");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
		// Goods In Transit Tracker
	}

	public OrderPage doLogin(String uN, String passwrd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(email).sendKeys(uN);
		driver.findElement(pwd).sendKeys(passwrd);
		driver.findElement(loginBtn).click();
		return new OrderPage(driver);
	}

	public OrderPage logOut() throws InterruptedException {
		System.out.println("login");
		util.fluentWaitTillElementClickable(SettingXml).click();
		util.fluentWaitPresenceOfWebElement(SignOutBtn).click();
		return new OrderPage(driver);
	}
}