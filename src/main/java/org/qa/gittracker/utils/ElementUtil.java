package org.qa.gittracker.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForPresenceOfWebElement(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForVisibilityOfWebElement(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public void waitScrollTillWebElementAndClick(WebElement ele) {
		Actions act =new Actions(driver);
		act.pause(3000).scrollToElement(ele);
		ele.click();
	}

}
