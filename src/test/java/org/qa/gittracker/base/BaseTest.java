package org.qa.gittracker.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.gittracker.Factory.DriverFactory;
import org.qa.gritracker.pages.LoginPage;
import org.qa.gritracker.pages.OrderEditPage;
import org.qa.gritracker.pages.OrderListPage;
import org.qa.gritracker.pages.OrderPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage lp;
	protected DriverFactory df;
	protected OrderPage op;
	protected Properties prop;
	protected OrderListPage olp;
	protected OrderEditPage oep;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		lp = new LoginPage(driver);
		olp = new OrderListPage(driver);
		oep = new OrderEditPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
