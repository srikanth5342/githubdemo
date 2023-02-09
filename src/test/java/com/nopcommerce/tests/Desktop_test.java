package com.nopcommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.base.BaseClass;
import com.nopcommerce.pages.Buildyourown_page;
import com.nopcommerce.pages.Desktops_page;
import com.nopcommerce.pages.Home_page;

public class Desktop_test extends BaseClass {
	
	Home_page homepage;
	Desktops_page desktopspage;
	Buildyourown_page buildpage;
	
	@Test(priority = 3)
	public void chooseConfigOfDesktop() throws Throwable {
		
		 homepage = new Home_page(driver);
			
		
		
		desktopspage =	homepage.searchproduct();
		
		buildpage =	desktopspage.addProductstocart();
		
		buildpage.selectyourproductdetails();
		
	String actualresult = buildpage.getcurrentURL();
	String expresult ="https://demo.nopcommerce.com/cart";
	
	Assert.assertEquals(actualresult, expresult);
		
	}

}
