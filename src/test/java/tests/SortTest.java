package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.ReadData;

public class SortTest extends BaseTest{

	//Standard user-
	@Test(description="sort products Z to A")
	public void tc01_standardUser_nameZtoA(){
		ProductsPage pp = new ProductsPage(driver);
		boolean b =pp.nameZtoA();
		Assert.assertEquals(b, true);
	}

	@Test(description="sort products A to Z")
	public void tc02_standardUser_nameAtoZ(){
		ProductsPage pp = new ProductsPage(driver);
		pp.nameAtoZ();
		boolean b =pp.nameAtoZ();
		Assert.assertEquals(b, true);
	}

	@Test(description="sort products - price low to high")
	public void tc03_standardUser_priceLowtoHigh(){
		ProductsPage pp = new ProductsPage(driver);
		pp.priceLowtoHigh();
		boolean b =pp.priceLowtoHigh();
		Assert.assertEquals(b, true);
	}

	@Test(description="sort products - price high to low")
	public void tc04_standardUser_priceHightoLow(){
		ProductsPage pp = new ProductsPage(driver);
		pp.priceHightoLow();
		boolean b =pp.priceHightoLow();
		Assert.assertEquals(b, true);
	}

	@Test(description="Logout")
	public void tc05_logout() {
		ProductsPage pp = new ProductsPage(driver);
		pp.logout();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.isLoginPageDisplayed(), true);
	}

	//Performance glitch user-
	@Test(description="Performance glitch user login")
	public void tc06_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("performanceGlitchUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	@Test(description="Performance glitch user-sort products Z to A")
	public void tc07_performanceGlitchUser_nameZtoA(){
		ProductsPage pp = new ProductsPage(driver);
		boolean b =pp.nameZtoA();
		Assert.assertEquals(b, true);
	}

	@Test(description="Performance glitch user-sort products A to Z")
	public void tc08_performanceGlitchUser_nameAtoZ(){
		ProductsPage pp = new ProductsPage(driver);
		pp.nameAtoZ();
		boolean b =pp.nameAtoZ();
		Assert.assertEquals(b, true);
	}

	@Test(description="Performance glitch user-sort products - price low to high")
	public void tc09_performanceGlitchUser_priceLowtoHigh(){
		ProductsPage pp = new ProductsPage(driver);
		pp.priceLowtoHigh();
		boolean b =pp.priceLowtoHigh();
		Assert.assertEquals(b, true);
	}

	@Test(description="Performance glitch user-sort products - price high to low")
	public void tc10_performanceGlitchUser_priceHightoLow(){
		ProductsPage pp = new ProductsPage(driver);
		pp.priceHightoLow();
		boolean b =pp.priceHightoLow();
		Assert.assertEquals(b, true);
	}

	@Test(description="Performance glitch user logout")
	public void tc11_logout() {
		ProductsPage pp = new ProductsPage(driver);
		pp.logout();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.isLoginPageDisplayed(), true);
	}
	//Problem user-
	@Test(description="Mismatched user login issue")
	public void tc12_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("problemUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Mismatched user-sort products Z to A")
	public void tc13_problemUser_nameZtoA(){
		ProductsPage pp = new ProductsPage(driver);
		boolean b =pp.nameZtoA();
		Assert.assertEquals(b, true);
	}

	@Test(description="Mismatched user-sort products A to Z")
	public void tc14_problemUser_nameAtoZ(){
		ProductsPage pp = new ProductsPage(driver);
		pp.nameAtoZ();
		boolean b =pp.nameAtoZ();
		Assert.assertEquals(b, true);
	}

	@Test(description="Mismatched user-sort products - price low to high")
	public void tc15_problemUser_priceLowtoHigh(){
		ProductsPage pp = new ProductsPage(driver);
		pp.priceLowtoHigh();
		boolean b =pp.priceLowtoHigh();
		Assert.assertEquals(b, true);
	}

	@Test(description="Mismatched user-sort products - price high to low")
	public void tc16_problemUser_priceHightoLow(){
		ProductsPage pp = new ProductsPage(driver);
		pp.priceHightoLow();
		boolean b =pp.priceHightoLow();
		Assert.assertEquals(b, true);
	}

	@Test(description="Mismatched user logout")
	public void tc17_logout() {
		ProductsPage pp = new ProductsPage(driver);	
		pp.logout();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.isLoginPageDisplayed(), true);
	}

}
