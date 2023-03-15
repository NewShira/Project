package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;
import utils.ReadData;

public class MenuTest extends BaseTest{
	
	//Standard user
	@Test(description="Standard user-open menu")
	public void tc01_OpenMenu(){
		MenuPage mp = new MenuPage(driver);
		mp.openMenu();
		mp.waiting(500);
		Assert.assertEquals(mp.isMenuOpened(), true);
	}
	
	@Test(description="Standard user-close menu")
	public void tc02_CloseMenu(){
		MenuPage mp = new MenuPage(driver);
		mp.closMenu();
		mp.waiting(500);
		Assert.assertEquals(mp.isMenuOpened(), false);
	}
	
	@Test(description="Standard user-from cart to 'ALL ITEMS' button")
	public void tc03_ALLITEMSbtn(){
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		mp.openCart();
		mp.openMenu();
		mp.clickAllItemsBtn();
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Standard user-from Item page to 'ALL ITEMS' button")
	public void tc04_ALLITEMSbtn(){
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProduct("Sauce Labs Onesie");
		mp.waiting(200);
		mp.openMenu();
		mp.waiting(200);
		mp.clickAllItemsBtn();
		Assert.assertEquals(pp.isProductPage(), true);
		mp.waiting(200);
	}

	@Test(description="Standard user-ABOUT button")
	public void tc05_ABOUTbtn() {
		MenuPage mp = new MenuPage(driver);
		mp.openMenu();
		mp.clickAboutBtn();
		Assert.assertEquals(mp.isAboutPageOpened(), true);
		driver.navigate().back();
	}
	
	@Test(description="Standard user-checks if ResetAppState button empty the cart")
	public void tc06_RESETAPPSTATEbtn() {
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		pp.addToCart("Sauce Labs Bike Light");
		mp.openMenu();
		mp.clickResetAppStateBtn();
		Assert.assertEquals(cp.getNumberOfItemsInCart(), "");
        mp.closMenu();
	}
	
	@Test(description="Standard user-bottom links - Twitter")
	public void tc07_TwitterLink() {
		MenuPage mp = new MenuPage(driver);
		mp.clickTwitterBtn();
		mp.moveToNewWindow();
		mp.waiting(7000);
		mp.moveToMainWindow();
	}
	
	@Test(description="Standard user-bottom links - Facebook")
	public void tc08_FacebookLink() {
		MenuPage mp = new MenuPage(driver);
		mp.clickFacebookBtn();
		mp.moveToNewWindow();
		mp.waiting(6000);
		mp.moveToMainWindow();
	}
	
	@Test(description="Standard user-bottom links - Linkedin")
	public void tc09_Linkedin() {
		MenuPage mp = new MenuPage(driver);
		mp.clickLinkedinBtn();
		mp.moveToNewWindow();
		mp.waiting(5000);
		mp.moveToMainWindow();
		mp.logout();
	}
	
	//Problem User
	@Test(description="Problem User login")
	public void tc10_problemUserLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("problemUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Problem User-open menu")
	public void tc11_OpenMenu(){
		MenuPage mp = new MenuPage(driver);
		mp.openMenu();
		mp.waiting(500);
		Assert.assertEquals(mp.isMenuOpened(), true);
	}
	
	@Test(description="Problem User-close menu")
	public void tc12_CloseMenu(){
		MenuPage mp = new MenuPage(driver);
		mp.closMenu();
		mp.waiting(500);
		Assert.assertEquals(mp.isMenuOpened(), false);
	}
	
	@Test(description="Problem User-from cart to 'ALL ITEMS' button")
	public void tc13_ALLITEMSbtn(){
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		mp.openCart();
		mp.openMenu();
		mp.clickAllItemsBtn();
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Problem User-from Item page to 'ALL ITEMS' button")
	public void tc14_ALLITEMSbtn(){
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProduct("Sauce Labs Onesie");
		mp.waiting(200);
		mp.openMenu();
		mp.waiting(200);
		mp.clickAllItemsBtn();
		Assert.assertEquals(pp.isProductPage(), true);
		mp.waiting(200);
	}

	@Test(description="Problem User-ABOUT button")
	public void tc15_ABOUTbtn() {
		MenuPage mp = new MenuPage(driver);
		mp.openMenu();
		mp.clickAboutBtn();
		Assert.assertEquals(mp.isAboutPageOpened(), true);
		driver.navigate().back();
	}
	
	@Test(description="Problem User-checks if ResetAppState button empty the cart")
	public void tc16_RESETAPPSTATEbtn() {
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		pp.addToCart("Sauce Labs Bike Light");
		mp.openMenu();
		mp.clickResetAppStateBtn();
		Assert.assertEquals(cp.getNumberOfItemsInCart(), "");
        mp.closMenu();
	}
	
	@Test(description="Problem User-bottom links - Twitter")
	public void tc17_TwitterLink() {
		MenuPage mp = new MenuPage(driver);
		mp.clickTwitterBtn();
		mp.moveToNewWindow();
		mp.waiting(7000);
		mp.moveToMainWindow();
	}
	
	@Test(description="Problem User-bottom links - Facebook")
	public void tc18_FacebookLink() {
		MenuPage mp = new MenuPage(driver);
		mp.clickFacebookBtn();
		mp.moveToNewWindow();
		mp.waiting(6000);
		mp.moveToMainWindow();
	}
	
	@Test(description="Problem User-bottom links - Linkedin")
	public void tc19_Linkedin() {
		MenuPage mp = new MenuPage(driver);
		mp.clickLinkedinBtn();
		mp.moveToNewWindow();
		mp.waiting(5000);
		mp.moveToMainWindow();
		mp.logout();
	}

	//performance glitch user
	@Test(description="Performance glitch user login")
	public void tc20_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("performanceGlitchUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Performance glitch-open menu")
	public void tc21_OpenMenu(){
		MenuPage mp = new MenuPage(driver);
		mp.openMenu();
		mp.waiting(1000);
		Assert.assertEquals(mp.isMenuOpened(), true);
	}
	
	@Test(description="Performance glitch-close menu")
	public void tc22_CloseMenu(){
		MenuPage mp = new MenuPage(driver);
		mp.closMenu();
		mp.waiting(500);
		Assert.assertEquals(mp.isMenuOpened(), false);
	}
	
	@Test(description="Performance glitch-From cart to 'ALL ITEMS' button")
	public void tc23_ALLITEMSbtn(){
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		mp.openCart();
		mp.openMenu();
		mp.clickAllItemsBtn();
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Performance glitch-from Item page to 'ALL ITEMS' button")
	public void tc24_ALLITEMSbtn(){
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProduct("Sauce Labs Onesie");
		mp.waiting(200);
		mp.openMenu();
		mp.waiting(200);
		mp.clickAllItemsBtn();
		Assert.assertEquals(pp.isProductPage(), true);
		mp.waiting(200);
	}

	@Test(description="Performance glitch-ABOUT button")
	public void tc25_ABOUTbtn() {
		MenuPage mp = new MenuPage(driver);
		mp.openMenu();
		mp.clickAboutBtn();
		Assert.assertEquals(mp.isAboutPageOpened(), true);
		driver.navigate().back();
	}
	
	@Test(description="Performance glitch-checks if ResetAppState button empty the cart")
	public void tc26_RESETAPPSTATEbtn() {
		MenuPage mp = new MenuPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		pp.addToCart("Sauce Labs Bike Light");
		mp.openMenu();
		mp.clickResetAppStateBtn();
		Assert.assertEquals(cp.getNumberOfItemsInCart(), "");
        mp.closMenu();
	}
	
	@Test(description="Performance glitch-bottom links - Twitter")
	public void tc27_TwitterLink() {
		MenuPage mp = new MenuPage(driver);
		mp.clickTwitterBtn();
		mp.moveToNewWindow();
		mp.waiting(7000);
		mp.moveToMainWindow();
	}
	
	@Test(description="Performance glitch-bottom links - Facebook")
	public void tc28_FacebookLink() {
		MenuPage mp = new MenuPage(driver);
		mp.clickFacebookBtn();
		mp.moveToNewWindow();
		mp.waiting(6000);
		mp.moveToMainWindow();
	}
	
	@Test(description="Performance glitch-bottom links - Linkedin")
	public void tc29_Linkedin() {
		MenuPage mp = new MenuPage(driver);
		mp.clickLinkedinBtn();
		mp.moveToNewWindow();
		mp.waiting(5000);
		mp.moveToMainWindow();
		mp.logout();
	}
}
