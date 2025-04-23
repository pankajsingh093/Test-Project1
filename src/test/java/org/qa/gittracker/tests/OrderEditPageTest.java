package org.qa.gittracker.tests;

import org.qa.gittracker.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderEditPageTest extends BaseTest {
	
	
	@BeforeClass
	public void doLogin() throws InterruptedException {
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//lp.doLogin(System.getProperty("username"), System.getProperty("password"));

	}
	
	@Test(priority=0, enabled=true)
	public void testRequested() throws InterruptedException {
		oep.makingStatuRequested();
		//Assert.assertEquals(oep.getUpdatedStatus().trim(), "Requested");
	}
	
	@Test(priority=1, enabled=false)
	public void testDispatchEvent() throws InterruptedException {
		oep.makingStatusDispactch();
		Assert.assertEquals(oep.getUpdatedStatus().trim(), "Dispatched");
	}
	
	@Test(priority=2, enabled=false)
	public void testInTransit() throws InterruptedException {
		oep.makingStatuInTransit();
		Assert.assertEquals(oep.getUpdatedStatus().trim(), "In-Transit");
	}
	
	@Test(priority=3, enabled=false)
	public void testDelivered() throws InterruptedException {
		oep.makingStatuInDelivered();
		Assert.assertEquals(oep.getUpdatedStatus().trim(), "Delivered");
	}
	
	@Test(priority=4, enabled=false)
	public void testDriverInTransit() throws InterruptedException {
		oep.driverInTransit();
		//Assert.assertEquals(oep.getText().trim(), "Driver is already in transit");
	}
	
	@Test(priority=5, enabled=false)
	public void testVechileInTransit() throws InterruptedException {
		oep.vehicleInTransit();
		//Assert.assertEquals(oep.getText().trim(), "Vehicle is already in transit");
	}

	@Test(priority = 6)
	public void testTruckerLoOut() throws InterruptedException {
		op = lp.logOut();
		Thread.sleep(3000);
		
	}

}
