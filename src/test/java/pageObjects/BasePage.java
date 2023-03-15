package pageObjects;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	JavascriptExecutor js;
	private WebDriverWait wait;
	Actions action;
	String mainWindow;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		action = new Actions(driver);
	}

	protected void fillText(WebElement el, String text) {
		highlightElement(el,"orange");
		waiting(300);
		el.clear();
		waiting(1000);
		el.sendKeys(text);
	}

	protected void click(WebElement el) {
		highlightElement(el,"orange");
		waiting(300);
		el.click();
	}

	protected String getText(WebElement el) {
		waiting(500);
		highlightElement(el, "yellow");
		return el.getText();
	}
	
	String getTitle() {
		highlightElement(driver.findElement(By.cssSelector("title")),"yellow");
		return driver.getTitle();
	}

	//Alert o.k
	public void alertOK(String text) {
		driver.switchTo().alert().accept();
	}

	//Alert
	public void alertText(String text) {
		driver.switchTo().alert().sendKeys(text);
		waiting(500);
		driver.switchTo().alert().accept();
	}

	//Select
	public void selectByValue(WebElement el, String text) {
		Select s = new Select(el);
		s.selectByValue(text);
	}
	
	public void scrollDown(int hLong) {
		//waiting(1000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,"+hLong+")");
		waiting(1500);
	}

	//Wait
	public void waitVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	public void waitInVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}
	
	public void waiting(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Call this method with your element and a color.
	protected void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 2px solid " + color + ";"+"background-color:yellow" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
	
	//Windows
		public void moveToNewWindow() {
			mainWindow = driver.getWindowHandle();
			Set<String> list = driver.getWindowHandles();
			for (String win : list) {
				//
				System.out.println(win);
				driver.switchTo().window(win);
			}
		}
		
	public void moveToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
	}
	
	// Scroll Down on page
	public void scrollDown(WebElement element) {
		System.out.println(element.getLocation().getY());
		for (int i = 0; i < element.getLocation().getY(); i += 20) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + i + ")");
		}
	}
}
