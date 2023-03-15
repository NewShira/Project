package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductsPage;
import pageObjects.YourInformationPage;

public class TestsWithDDTYourInformationForm extends BaseTest{
    @Test(description="Make an order")
    public void tc01_Order(){
    	ProductsPage pp = new ProductsPage(driver);
    	pp.addToCart("Sauce Labs Bike Light");
    	pp.openCart();
    	CartPage cp = new CartPage(driver);
    	cp.goToCheckOut();
    	cp.waiting(500);
    }
	@Test(description="Data driven testing- order form", dataProvider="getData")
	public void tc02_Fill(String firstName, String lastName, String code, String error) {
		YourInformationPage yip = new YourInformationPage(driver);
        yip.fillform(firstName, lastName, code);
        yip.waiting(1000);
		Assert.assertEquals(yip.getErrorMessage(), error);
	}
	
	@DataProvider
	public Object [][] getData(){
		Object[][] data = {
				
				{"","zilber","453435","Error: First Name is required"},//Empty first name field
				{"","","","Tali: First Name is required"},//Empty fields
				{"dsff","dsfdf","","Error: Postal Code is required"},//Empty zip / postal code field
				{"4eff3redfdfsd","","dsf","Error: Last Name is required"},//Empty last name field

		};
		return data;	
	}
	
    @Test(enabled=false,description="Back to ProductPage without purchase")
    public void tc03_BackToProductPage(){
    	YourInformationPage yip = new YourInformationPage(driver);
    	yip.clickCancelBtn();
    	CartPage cp = new CartPage(driver);
    	cp.continueShopping();
    	ProductsPage pp = new ProductsPage(driver);
    	pp.isProductPage();
    }
}
