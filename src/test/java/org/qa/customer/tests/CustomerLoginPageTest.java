package org.qa.customer.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLoginPageTest extends BaseTest{
	
	
	@Test(priority = 1)
	public void testLoginPageTitle() {
		
		Assert.assertEquals(lp.getLoginPageTitle(), GitTrackerConstants.LOGIN_PAGE_TITLE);
		
	}
	
	
	@Test(priority=2)
	public void testCustomerLogin() throws InterruptedException {
		//op = lp.doLogin(prop.getProperty("customerUN"), prop.getProperty("customerPASS"));
		lp.doLogin(System.getProperty("username"), System.getProperty("password"));
		Thread.sleep(2000);
		Assert.assertEquals(op.getOrderPageUrl(), GitTrackerConstants.CUST_OPEN_ORDER_PAGE_URL);
	}

}
