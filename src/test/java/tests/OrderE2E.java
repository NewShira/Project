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
import pageObjects.YourInformationPage;
import pageObjects.ItemPage;
import pageObjects.OverViewPage;
import pageObjects.ProductsPage;

public class OrderE2E extends BaseTest{

	@Test(enabled=false,description="Make an order")
	public void tc01() {
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProduct("Sauce Labs Fleece Jacket");
		pp.addToCart();
		ItemPage ip = new ItemPage(driver);
		ip.backToProducts();
		ip.openCart();
		ip.waiting(1000);
		CartPage cp = new CartPage(driver);
		cp.goToCheckOut();
		YourInformationPage yip = new YourInformationPage(driver);
		yip.scrollDown(150);
		//yip.makeAnOrder
		//screen shot in makeAnOrder method
		yip.waiting(1000);
	}

	@Test(description="Standard user-make an order E2E")
	private void tc09_MakeAnOrder() {
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
		Assert.assertEquals(pp.isProductPage(), true);
	}
	
	@AfterMethod
	public void successTestScreenshot(ITestResult result) {
		//check if the test succeed
		if (result.getStatus() == ITestResult.SUCCESS ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//result.getname() method will give you current test case name. 
			//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
		}
	}
}
