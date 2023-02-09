package com.nopcommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.base.BaseClass;
import com.nopcommerce.pages.Address_page;
import com.nopcommerce.pages.Buildyourown_page;
import com.nopcommerce.pages.Desktops_page;
import com.nopcommerce.pages.Home_page;
import com.nopcommerce.pages.Login_page;
import com.nopcommerce.pages.OrderConfirmation_page;
import com.nopcommerce.pages.PaymentInformation_page;
import com.nopcommerce.pages.PaymentMode_page;
import com.nopcommerce.pages.Registration_page;
import com.nopcommerce.pages.Shipping_page;
import com.nopcommerce.pages.ShoppingCart_page;
import com.nopcommerce.pages.Thankyou_page;

public class NopCommerceTestCase extends BaseClass {

	Home_page homepage;
	Desktops_page desktopspage;
	Buildyourown_page buildpage;
	ShoppingCart_page shoppingcart;
	Registration_page regpage;
	Login_page loginpage;
	Address_page addresspage;
	Shipping_page shippingpage;
	PaymentMode_page paymentmodepage;
	PaymentInformation_page paymentinfopage;
	OrderConfirmation_page orderconfirmpage;
	Thankyou_page thankyoupage;

	@Test(priority = 4)
	public void verifyregistration() throws Throwable {

		homepage = new Home_page(driver);

		desktopspage = homepage.searchproduct();

		buildpage = desktopspage.addProductstocart();

		shoppingcart = buildpage.selectyourproductdetails();

		regpage = shoppingcart.updatecart();

		regpage.enterDetailsinRegistration(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("mail"), prop.getProperty("companyname"), prop.getProperty("password"),
				prop.getProperty("confirmpass"));
		regpage.clickContinue();
		loginpage = regpage.clickonloginbutton();
		shoppingcart = loginpage.login(prop.getProperty("mail"), prop.getProperty("password"));
		addresspage = shoppingcart.afterloginshoppingpage();
		shippingpage =	addresspage.enteringdetailsinAddresspage(prop.getProperty("city"), prop.getProperty("Address1"),
				prop.getProperty("Address2"), prop.getProperty("zip"), prop.getProperty("ph"));
		
		paymentmodepage=shippingpage.chooseShippingmode();
		paymentinfopage=paymentmodepage.choosepaymentMode();
		orderconfirmpage=paymentinfopage.clickContinuebtn();
		thankyoupage=orderconfirmpage.clickingconfirmation();
		boolean flag =thankyoupage.thankyoupage();
		
		Assert.assertTrue(flag);
	}

}
