package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
public class LoginFailedTests extends BaseTest {
	
	@Override
	@BeforeClass
	public void setupLogin() {
	}

	@Test(description="Data driven testing- invalid users", dataProvider="getData")
	public void tc01_login(String userName, String password, String error) {
		LoginPage lp= new LoginPage(driver);
		lp.login(userName,password);
		lp.waiting(1000);
		Assert.assertEquals(lp.getErrorMessage(), error);
	}
	@DataProvider
	public Object[][] getData(){
		Object [][] data= {
				{"","","Epic sadface: Username is required"},//Empty fields
				{"Shira","","Epic sadface: Password is required"},//Empty password field
				{"","Shira","Epic sadface: Username is required"},//Empty user name field
				{"Nila","secret_sauce","Epic sadface: Username and password do not match any user in this service"},//Invalid user name
				{"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},//Locked user
				{"Nila","Nil","Epic sadface: Username and password do not match any user in this service"},//User does not exist
				{"standard_user","secret","Epic sadface: Username and password do not match any user in this service"},//Invalid password
				{"%^^*","Mistake","Epic sadface: Username and password do not match any user in this service"},//User does not exist
				{"12345","12345","Epic sadface: Username and password do not match any user in this service"},//User does not exist
		};
		return data;
	}

}
