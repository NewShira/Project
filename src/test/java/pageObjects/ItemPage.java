package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class ItemPage extends MenuPage{

	@FindBy(css="[id^='add-to-cart']")
	private WebElement addToCartBtn;
	@FindBy(css="#back-to-products")
	private WebElement backToProductsBtn;
	@FindBy(css=".shopping_cart_badge")
	private WebElement openCartBtn;

	
	public ItemPage(WebDriver driver) {
		super(driver);
	}	
	
	public void backToProducts() {
		click(backToProductsBtn);
		waiting(1000);
	}
	
	public void openCart() {
		click(openCartBtn);
		waiting(1000);
	}
	
	public void addToCart() {
		click(addToCartBtn);
		waiting(1000);
	}
}
