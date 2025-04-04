package org.qa.customer.tests;

import org.qa.gittracker.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderRequestPageTest extends BaseTest {

	@BeforeClass
	public void doLogin() throws InterruptedException {
		//clp.doLogin(prop.getProperty("customerUN"), prop.getProperty("customerPASS"));
		 lp.doLogin(System.getProperty("username"), System.getProperty("password"));
	}

	@Test
	public void verifyCreatingOrderRequest() throws InterruptedException {

		orp.createMoveOrderRequest();
	}

}
