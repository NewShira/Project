package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverViewPage extends MenuPage{
	
	@FindBy(css="#cancel")
	private WebElement cancelBtn; 
	@FindBy(css="#finish")
	private WebElement finishBtn;

	public OverViewPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickCancelBtn() {
		scrollDown(cancelBtn);
		click(cancelBtn);
	}
	
	public void clickFinishBtn() {
		scrollDown(finishBtn);
		click(finishBtn);
	}
}
