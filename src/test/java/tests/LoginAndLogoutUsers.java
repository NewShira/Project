package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.ReadData;

public class LoginAndLogoutUsers extends BaseTest{
	
	
	@Test(description="Standard user login")
	public void tc01_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("standardUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Standard user logout")
	public void tc02_logout() {
		ProductsPage pp = new ProductsPage(driver);
		pp.waiting(1000);
		pp.scrollDown(500);
		pp.logout();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.isLoginPageDisplayed(), true);
	}
	
	@Test(description="performance glitch user login")
	public void tc03_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("performanceGlitchUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="performance glitch user logout")
	public void tc04_logout() {
		ProductsPage pp = new ProductsPage(driver);
		pp.waiting(1000);
		pp.scrollDown(500);
		pp.logout();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.isLoginPageDisplayed(), true);
	}
	
	@Test(description="Problem user login")
	public void tc05_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("problemUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Problem user logout")
	public void tc06_logout() {
		ProductsPage pp = new ProductsPage(driver);
		pp.waiting(1000);
		pp.scrollDown(500);	
		pp.logout();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.isLoginPageDisplayed(), true);
	}
}
