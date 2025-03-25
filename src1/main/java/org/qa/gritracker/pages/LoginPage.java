package org.qa.gritracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By email = By.xpath("(//input[contains(@id, 'mat-input-')])[1]");
	private By pwd = By.xpath("(//input[contains(@id, 'mat-input-')])[2]");
	private By loginBtn = By.xpath("//*[text()='login']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
		//Goods In Transit Tracker
	}
	
	public OrderPage doLogin(String uN, String passwrd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(email).sendKeys(uN);
		driver.findElement(pwd).sendKeys(passwrd);
		driver.findElement(loginBtn).click();
		return new OrderPage(driver);
	}
	
	

}
