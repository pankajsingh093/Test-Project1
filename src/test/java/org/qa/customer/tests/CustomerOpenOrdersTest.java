package org.qa.customer.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerOpenOrdersTest extends BaseTest {

	@BeforeClass
	public void doLogin() throws InterruptedException {
		//clp.doLogin(prop.getProperty("customerUN"), prop.getProperty("customerPASS"));
		 lp.doLogin(System.getProperty("username"), System.getProperty("password"));
	}

	@Test
	public void verifyOpenOrders() throws InterruptedException {

		coo.createMoveOpenOrders();
		Thread.sleep(3000);
		Assert.assertEquals(coo.getOrderPageUrl(), GitTrackerConstants.CUST_COMPLETE_OPEN_ORDER_PAGE_URL);
	}

	@Test(priority = 1, enabled = true)
	public void testSearchOrder() throws InterruptedException {
		coo.searchData();
		Assert.assertEquals(coo.getRowCount(), 1);
	}

	@Test(priority = 2, enabled = true)
	public void advSearch() throws InterruptedException {
		coo.advSearch();
		Assert.assertEquals(coo.getRowCount(), 1);
	}

}
