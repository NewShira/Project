package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourInformationPage extends MenuPage{
	
	@FindBy(css="#first-name")
	private WebElement firstNameField;
	@FindBy(css="#last-name")
	private WebElement lastNameField;
	@FindBy(css="#postal-code")
	private WebElement zipPostalCodeField;
	@FindBy(css="#continue")
	private WebElement continueBtn;
	@FindBy(css="#cancel")
	private WebElement cancelBtn; 
	@FindBy(css="#finish")
	private WebElement finishBtn;
	@FindBy(css="div.checkout_info > div.error-message-container.error")
	private WebElement errorMessage;
	
	public YourInformationPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillform(String firstName, String lastName, String zipPostalCode) {
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(zipPostalCodeField, zipPostalCode);
		waiting(500);	
		click(continueBtn);
	}
	
	public void clickContinueCheckOutBtn() {
		click(continueBtn);
	}

	public void clickCancelBtn() {
		click(cancelBtn);
	}

	public String getErrorMessage() {
		return getText(errorMessage);
	}
}
