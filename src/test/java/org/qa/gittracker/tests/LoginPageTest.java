package org.qa.gittracker.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority = 1)
	public void testLoginPageTitle() {
		
		Assert.assertEquals(lp.getLoginPageTitle(), GitTrackerConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void testTruckerLogin() throws InterruptedException {
		op = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(op.getOrderPageUrl(), GitTrackerConstants.ORDER_PAGE_URL);
	}
	
	@Test(priority = 3, enabled=true )
	public void testTruckerLoOut() throws InterruptedException {
		op = lp.logOut();
		
	}


}
