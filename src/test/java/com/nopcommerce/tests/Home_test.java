package com.nopcommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.base.BaseClass;
import com.nopcommerce.pages.Desktops_page;
import com.nopcommerce.pages.Home_page;

public class Home_test extends BaseClass {
	
	Home_page homepage;
	Desktops_page desktopspage;
	
	
	@Test(priority = 1)
	public void verifyLogo() throws Throwable {
		
		
		 homepage = new Home_page(driver);
		
		boolean result = homepage.validatingLogo();
		
	     Assert.assertTrue(result);
		
		
	}
	
	
	
	@Test(priority = 2)
	public void searchproduct() throws Throwable {
		
		//homepage = new Home_page(driver);
		
		desktopspage=homepage.searchproduct();
		
	String actualurl =	desktopspage.getcurrentURL();
	String expurl ="https://demo.nopcommerce.com/desktops";
	
	Assert.assertEquals(actualurl, expurl);
		
	}
	
	
	
	
	

}
