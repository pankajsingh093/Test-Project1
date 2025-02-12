package org.qa.gittracker.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qa.gittracker.exception.FrameworkException;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver initDriver(Properties prop) {
		
		//String browserName = prop.getProperty("browser").trim();
		
		String browserName  = System.getProperty("browser").trim();
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions cp =new ChromeOptions();
			cp.addArguments("--headless");
			driver = new ChromeDriver();
			break;
		case "edge":
			
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			new FrameworkException("Please pass the correct browser" + browserName);
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
	public Properties initProp() {
		
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	//mvn clean install -Dbrowser=chrome -Dusername=pankaj.singh@lightwaremedia.com  -Dpassword=pANKAJ123#

}
