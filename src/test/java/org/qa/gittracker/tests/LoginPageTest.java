package org.qa.gittracker.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority = 1)
	public void testLoginPageTitle() {
		//lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(lp.getLoginPageTitle(), GitTrackerConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void testLogin() throws InterruptedException {
		op = lp.doLogin(System.getProperty("username"), System.getProperty("password"));
		Thread.sleep(5000);
		Assert.assertEquals(op.getOrderPageUrl(), GitTrackerConstants.ORDER_PAGE_URL);
	}

}
