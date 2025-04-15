package org.qa.customer.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderRequestPageTest extends BaseTest {

	@BeforeClass
	public void doLogin() throws InterruptedException {
		clp.doLogin(prop.getProperty("customerUN"), prop.getProperty("customerPASS"));
		// lp.doLogin(System.getProperty("username"), System.getProperty("password"));
	}

	@Test
	public void verifyCreatingOrderRequest() throws InterruptedException {

		orp.createMoveOrderRequest();
		Thread.sleep(2000);
		Assert.assertEquals(orp.getOrderPageUrl(), GitTrackerConstants.CUST_COMPLETE_OPEN_REQUEST_PAGE_URL);
	}
	@Test (priority = 1, enabled = true)
	public void sendRequest() throws InterruptedException{
		orp.sendRequest();
		//Assert.assertEquals(orp.getSuccessMessage().trim(), "Order Request Submitted Successfully");
	}

}
