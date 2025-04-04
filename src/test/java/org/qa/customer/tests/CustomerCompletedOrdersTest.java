package org.qa.customer.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;

public class CustomerCompletedOrdersTest extends BaseTest {
	@BeforeClass
	public void doLogin() throws InterruptedException {
		//clp.doLogin(prop.getProperty("customerUN"), prop.getProperty("customerPASS"));
		 lp.doLogin(System.getProperty("username"), System.getProperty("password"));
	}

	@Test
	public void verifyCompletedOrders() throws InterruptedException {

		cco.moveCustomerCompletedOrders();
		Thread.sleep(3000);
		Assert.assertEquals(cco.getOrderPageUrl(), GitTrackerConstants.CUST_COMPLETE_ORDER_PAGE_URL);
	}

	@Test(priority = 1, enabled = true)
	public void testSearchOrder() throws InterruptedException {
		cco.searchData();
		Assert.assertEquals(cco.getRowCount(), 1);
	}

	@Test(priority = 2, enabled = true)
	public void advSearch() throws InterruptedException {
		cco.advSearch();
		Assert.assertEquals(cco.getRowCount(), 1);
	}
}
