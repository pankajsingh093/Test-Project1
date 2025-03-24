package org.qa.gittracker.tests;

import org.qa.gittracker.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderEditPageTest extends BaseTest {
	
	
	@BeforeClass
	public void doLogin() throws InterruptedException {
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority=0)
	public void testRequested() throws InterruptedException {
		oep.makingStatuRequested();
		//Assert.assertEquals(oep.getUpdatedStatus().trim(), "Requested");
	}
	
	@Test(priority=1)
	public void testDispatchEvent() throws InterruptedException {
		oep.makingStatusDispactch();
		Assert.assertEquals(oep.getUpdatedStatus().trim(), "Dispatched");
	}
	
	@Test(priority=2)
	public void testInTransit() throws InterruptedException {
		oep.makingStatuInTransit();
		Assert.assertEquals(oep.getUpdatedStatus().trim(), "In-Transit");
	}
	
	@Test(priority=3)
	public void testDelivered() throws InterruptedException {
		oep.makingStatuInDelivered();
		Assert.assertEquals(oep.getUpdatedStatus().trim(), "Delivered");
	}
	

}
