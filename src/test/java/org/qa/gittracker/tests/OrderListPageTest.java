package org.qa.gittracker.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderListPageTest extends BaseTest {

	@BeforeClass
	public void doLogin() throws InterruptedException {
		lp.doLogin(System.getProperty("username"), System.getProperty("password"));
		

	}

	@Test(priority = 0)
	public void testOrderPageURL() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(olp.getOrderPageUrl(), GitTrackerConstants.ORDER_PAGE_URL);
	}
	
	@Test(priority=1)
	public void testSearchOrder() throws InterruptedException {
		olp.searchData();
		Assert.assertEquals(olp.getRowCount(), 1);
	}
}