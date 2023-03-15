package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.FinishPage;
import pageObjects.ItemPage;
import pageObjects.LoginPage;
import pageObjects.OverViewPage;
import pageObjects.ProductsPage;
import pageObjects.YourInformationPage;

public class StandardUser extends BaseTest{

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
		pp.scrollDown(100);
        pp.addToCart("Sauce Labs Bolt T-Shirt");
        pp.openCart();
        Assert.assertEquals(pp.isProductPage(), true);
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
	
	@Test
	private void tc10_MakeAnOrder() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Sauce Labs Bolt T-Shirt");
		pp.addToCart("Sauce Labs Onesie");
		pp.openCart();
		CartPage cp = new CartPage(driver);
		cp.goToCheckOut();
		YourInformationPage yip = new YourInformationPage(driver);
		yip.fillform("Vered", "Doron", "25536");
		yip.clickContinueCheckOutBtn();
		yip.waiting(1000);
		OverViewPage ovp = new OverViewPage(driver);
		ovp.clickFinishBtn();
		FinishPage fp = new FinishPage(driver);
		fp.title();
		//screen shot
		fp.goHomeBtn();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.isLoginPageDisplayed(), true);
	}
	
	@AfterMethod 
	public void tc(ITestResult result) {
		  //check if the test succeed
		if (result.getStatus() == ITestResult.SUCCESS ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
