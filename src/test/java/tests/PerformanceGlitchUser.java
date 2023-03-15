package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ItemPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.ReadData;

public class PerformanceGlitchUser extends BaseTest{
	
	@Override
	@BeforeClass
	public void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.login(ReadData.readProperty("performanceGlitchUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Add product to cart from product page")
	public void tc01_AddToCartFromProductPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.scrollDown(100);
        pp.addToCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Remove product from product page")
	public void tc02_RemoveProductFromProductPage() {
		ProductsPage pp = new ProductsPage(driver);
        pp.removeItem("fleece-jacket");
        Assert.assertEquals(pp.isAddToCartBtnShow("Sauce Labs Fleece Jacket"), "ADD TO CART");
	}
	
	@Test(description="Add product to cart and open cart")
	public void tc03_AddToCartFromProductPage_AndOpenCart() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		pp.scrollDown(100);
        pp.addToCart("Sauce Labs Bolt T-Shirt");
        pp.openCart();
        Assert.assertEquals(cp.isYourCartPage(), true);
	}
	
	@Test(description="Remove product from cart")
	public void tc04_RemoveProductFromCart() {
		CartPage cp = new CartPage(driver);
		cp.removeItemFromCart("bolt-t-shirt");
		cp.continueShopping();
        Assert.assertEquals(cp.getNumberOfItemsInCart(), "");
	}
	
	@Test(description="Add to cart from ItemPage")
	public void tc05_AddToCartFromItemPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.waiting(500);
		pp.chooseProduct("Sauce Labs Backpack");
		ItemPage ip = new ItemPage(driver);
		ip.addToCart();
		ip.openCart();
		CartPage cp = new CartPage(driver);
        Assert.assertEquals(cp.getNumberOfItemsInCart(), "1");
	}
	
	@Test(description="Remove product from cart")
	public void tc06_RemoveProductFromCart() {
		CartPage cp = new CartPage(driver);
		cp.removeItemFromCart("backpack");
		cp.continueShopping();
        Assert.assertEquals(cp.getNumberOfItemsInCart(), "");
	}
	
	@Test(description="Open empty cart")
	public void tc07_OpenEmptyCart() {
		ProductsPage pp = new ProductsPage(driver);
		pp.openCart();
		CartPage cp = new CartPage(driver);
		Assert.assertEquals(cp.getNumberOfItemsInCart(), "");
		cp.continueShopping();
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@Test(description="Add all products to cart")
	public void tc08_AddAllProductsToCart() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addAllProductsToCart();
		pp.waiting(500);
		pp.openCart();
		CartPage cp = new CartPage(driver);
		Assert.assertEquals(cp.getNumberOfItemsInCart(), "6");
	}
	
	@Test(description="Remove all products from cart")
	public void tc09_RemoveAllProductsFromCart() {
		CartPage cp = new CartPage(driver);
		cp.removeAllItemsFromCart();
		Assert.assertEquals(cp.getNumberOfItemsInCart(), "");
		cp.continueShopping();
	}
}
