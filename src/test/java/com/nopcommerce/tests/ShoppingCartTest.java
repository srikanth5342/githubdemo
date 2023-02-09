package com.nopcommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.base.BaseClass;
import com.nopcommerce.pages.Buildyourown_page;
import com.nopcommerce.pages.Desktops_page;
import com.nopcommerce.pages.Home_page;
import com.nopcommerce.pages.ShoppingCart_page;

public class ShoppingCartTest extends BaseClass {
	
	Home_page homepage;
	Desktops_page desktopspage;
	Buildyourown_page buildpage;
	ShoppingCart_page shoppingcart;
	
	@Test(priority = 4)
	public void updateCartAndCheckout() throws Throwable {
		
		 homepage = new Home_page(driver);
			
		
		
		desktopspage =	homepage.searchproduct();
		
		buildpage =	desktopspage.addProductstocart();
		
		shoppingcart=buildpage.selectyourproductdetails();
		
		shoppingcart.updatecart();
		
		String actualresult =shoppingcart.getcurrentURL();
	
	String expresult ="https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart";
	
	Assert.assertEquals(actualresult, expresult);
		
	}


}
