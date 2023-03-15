package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.ReadData;


public class BaseTest {
	WebDriver driver;

	@BeforeClass()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ReadData.readProperty("url"));
	}

	@BeforeClass
	public void setupLogin(){
		LoginPage lp= new LoginPage(driver);
		lp.login(ReadData.readProperty("standardUser"), ReadData.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(pp.isProductPage(), true);
	}

	@AfterClass(description ="close browser")
	public void tearDown() {
		//driver.quit();
	}

//	@AfterMethod
//	public void failedTest(ITestResult result) {
//		//check if the test failed
//		if (result.getStatus() == ITestResult.FAILURE ){
//			TakesScreenshot ts = (TakesScreenshot)driver;
//			File srcFile = ts.getScreenshotAs(OutputType.FILE);
//			try {
//				FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//result.getname() method will give you current test case name. 
//			//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
//		}
//	}
//


}
