package org.qa.gittracker.tests;

import org.qa.gittracker.base.BaseTest;
import org.qa.gittracker.constants.GitTrackerConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseTest {
	
	@BeforeClass
	public void doLogin() throws InterruptedException {
		//lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		op = lp.doLogin(System.getProperty("username"), System.getProperty("password"));
	}
	
	
	@Test
	public void testCreateOrder() throws InterruptedException {
		op.createOrder();
		Assert.assertEquals(op.getOrderSuccessMessage(), GitTrackerConstants.ORDER_SUCCESS_MESSAGE);
	}

}
