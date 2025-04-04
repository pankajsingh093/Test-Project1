package org.qa.customer.tests;

import org.qa.gittracker.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerLinkedOrdersTest extends BaseTest {

	@BeforeClass
	public void doLogin() throws InterruptedException {
		//clp.doLogin(prop.getProperty("customerUN"), prop.getProperty("customerPASS"));
		 lp.doLogin(System.getProperty("username"), System.getProperty("password"));
	}

	@Test
	public void verifyLinkedOrders() throws InterruptedException {

		clo.createLinkedOrders();
	}
	@Test(priority=1)
	public void testSearchOrder() throws InterruptedException {
		clo.searchContainerNo();
		Assert.assertEquals(clo.getRowCount(), 1);
	}

}