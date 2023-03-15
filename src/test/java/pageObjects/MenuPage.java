package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css=".shopping_cart_link")
	private WebElement cartBtn;

	//Elements burger menu
	@FindBy(css="#react-burger-menu-btn")
	WebElement  burgerMenu;
	@FindBy(css="#inventory_sidebar_link")
	WebElement  allItemsBtn;
	@FindBy(css="#about_sidebar_link")
	WebElement  aboutBtn;
	@FindBy(css="#logout_sidebar_link")
	WebElement  logoutBtn;
	@FindBy(css="#reset_sidebar_link")
	WebElement  resetAppStateBtn;
	@FindBy(css="#react-burger-cross-btn")
	WebElement  closeMenuBtn;

	//Button Links
	@FindBy(css="li.social_twitter > a")
	WebElement twitterBtn;
	@FindBy(css="li.social_facebook > a")
	WebElement facebookBtn;
	@FindBy(css="li.social_linkedin > a")
	WebElement linkedinBtn;

	//Validation
	@FindBy(css="#headerMainNav")
	WebElement  isAboutPage;

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public void openMenu() {
		click(burgerMenu);
		waiting(200);
	}

	public void openCart() {
		click(cartBtn);
		waiting(200);
	}

	public void closMenu() {
		click(closeMenuBtn);
		waiting(200);
	}

	public void clickAllItemsBtn() {
		click(allItemsBtn);
		waiting(200);
	}

	public void clickAboutBtn() {
		click(aboutBtn);
		waiting(200);
	}

	public void clickLogoutBtn() {
		click(logoutBtn);
	}

	public void logout() {
		openMenu();
		waiting(1000);
		click(logoutBtn);
	}

	public void clickResetAppStateBtn() {
		click(resetAppStateBtn);
		waiting(200);
	}

	public void clickTwitterBtn() {
		scrollDown(twitterBtn);
		click(twitterBtn);
	}

	public void clickFacebookBtn() {
		scrollDown(facebookBtn);
		click(facebookBtn);
	}

	public void clickLinkedinBtn() {
		scrollDown(linkedinBtn);
		click(linkedinBtn);
	}
	
	//Validation
	public boolean isMenuOpened() {
		return allItemsBtn.isDisplayed();
	}

	public boolean isAboutPageOpened() {
		return isAboutPage.isDisplayed();
	}
}
