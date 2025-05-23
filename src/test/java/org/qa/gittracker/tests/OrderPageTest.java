package org.qa.gittracker.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseTest {

	@BeforeClass
	public void doLogin() throws InterruptedException {
		//op = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		lp.doLogin(System.getProperty("username"), System.getProperty("password"));
		// op = lp.doLogin(System.getProperty("username"),
		// System.getProperty("password"));
	}

	@Test(priority = 0)
	public void testCreateOrder() throws InterruptedException {
		op.createOrder();
		Assert.assertEquals(op.getOrderSuccessMessage(), GitTrackerConstants.ORDER_SUCCESS_MESSAGE);
	}

	@Test(priority = 1)
	public void testTruckerLoOut() throws InterruptedException {
		Thread.sleep(3000);
		op.logOut();

	}
}
