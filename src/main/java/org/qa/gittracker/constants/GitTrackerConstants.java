package org.qa.gittracker.constants;

import java.util.Arrays;
import java.util.List;

public class GitTrackerConstants {
	
	public static final String LOGIN_PAGE_TITLE = "Goods In Transit Tracker";
	
	public static final String ORDER_PAGE_URL = "https://git-tracker-web-dev.herokuapp.com/dispatch/open";
	
	public static final String CUST_OPEN_ORDER_PAGE_URL = "https://git-tracker-web-dev.herokuapp.com/customer/open-orders";
	
	public static final String CUST_COMPLETE_OPEN_REQUEST_PAGE_URL = "https://git-tracker-web-dev.herokuapp.com/customer/request-order";
	
	public static final String ORDER_SUCCESS_MESSAGE = "Order saved successfully";
	
	
	public static final List<String> cBList =  Arrays.asList("OT ","Site Inspection ", "R&D ");
	
	public static final String ORIGIN_DROPDOWN_DATA = "22";
	
	public static final String DESTINATION_DROPDOWN_DATA = "10";
	
	public static final List<String> customerCBList =  Arrays.asList("Loaded","Site Inspection ", "R&D ");
	public static String containerNo="";
}
