package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MenuPage {
    
	//Elements for login
	@FindBy(css="#user-name")
	private WebElement userField;
	@FindBy(css="#password")
	private WebElement passwordField;
	@FindBy(css="#login-button")
	private WebElement loginBtn;
	@FindBy(css=".form-error")
	private WebElement e;
	
	//Element for validation
	@FindBy(css="[data-test=\"error\"]")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String user,String password) {
		fillText(userField, user);
		fillText(passwordField, password);
		waiting(1000);
		click(loginBtn);
	}
	public void clearField() {
		userField.clear();
		passwordField.clear();
	}
	//Validation login
	public String getErrorMessage() {
		return getText(errorMessage);
	}
	
    public boolean isLoginPageDisplayed() {
   	 waitVisibilityOf(userField);
        return userField.isDisplayed();
   }
}
