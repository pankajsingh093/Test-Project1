package org.qa.gittracker.utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
	
	
	public void waitScrollTillWebElementAndClick(By locator) {
		WebElement ele = fluentWaitPresenceOfWebElement(locator);
		Actions act =new Actions(driver);
		act.pause(3000).scrollToElement(ele);
		ele.click();
	}
	
	public WebElement waitScrollTillWebElement(WebElement ele) {
		Actions act =new Actions(driver);
		act.pause(3000).scrollToElement(ele);
		return ele;
	}
	
	
	public WebElement fluentWaitPresenceOfWebElement(By locator) {
		
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5));
		return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
		
	}
	
	public WebElement fluentWaitPresenceOfWebElement(WebElement ele) {
		
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1));
		return fluentWait.until(ExpectedConditions.visibilityOf(ele));	
		
	}
	
	public WebElement fluentWaitTillElementClickable(By ele) {
		
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1));
		return fluentWait.until(ExpectedConditions.elementToBeClickable(ele));	
		
	}
	public WebElement fluentWaitTillElementClickable(WebElement ele) {
		
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5));
		return fluentWait.until(ExpectedConditions.elementToBeClickable(ele));	
		
	}
	
	public boolean elementDisplayed(WebElement ele) {
		return fluentWaitPresenceOfWebElement(ele).isDisplayed();
	}
	
	public WebElement getWebelement(By locator) {
		return fluentWaitPresenceOfWebElement(locator).findElement(locator);
	}
	
	public void clickOnElement(WebElement ele) {
		fluentWaitTillElementClickable(ele).click();
	}
	
	public void implicitWait(int second) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
	}
	
	public String generateRamdomNo(int lenght) {
		String ContainerNo ="TEST##$$12345";
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
	
	public void clickOnCB(List<String> listCB) {
		
		for(int i=0;i<listCB.size();i++) {
			fluentWaitPresenceOfWebElement(By.xpath("//span[text()='"+ listCB.get(i) +"']")).click();
		}
		
	}
}
