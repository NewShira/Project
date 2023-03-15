package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends MenuPage{
	
	@FindBy(css="#back-to-products")
	private WebElement goHomeBtn;
	@FindBy(css="#header_container  span")
	private WebElement title;

	public FinishPage(WebDriver driver) {
		super(driver);
	}
	
	public void title() {
		click(title);
	}
	
	public void goHomeBtn() {
		waiting(1500);
		click(goHomeBtn);
	}

}
