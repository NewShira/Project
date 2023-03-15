package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MenuPage{

	@FindBy(css="#continue-shopping")
	private WebElement continueShoppingBtn;
	@FindBy(css="#checkout")
	private WebElement checkOutBtn;
	//@FindBy(css="#cart_contents_container")
	@FindBy(css=".cart_list")
	private List<WebElement> listOfProducts;
	@FindBy(css="#shopping_cart_container")
	private WebElement numberItemsInCart;
	@FindBy(css=".btn.btn_secondary.btn_small.cart_button")
	private WebElement removeBtn;

	//Elements for validation
	@FindBy(css = ".title")
	private WebElement yourCartPageIndication;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public void continueShopping() {
		click(continueShoppingBtn);
	}

	public void goToCheckOut() {
		scrollDown(checkOutBtn);
		click(checkOutBtn);
	}

	public String getNumberOfItemsInCart() {
		String numberOfItemsInCart = numberItemsInCart.getText(); 
		return numberOfItemsInCart;
	}

	public void removeItemFromCart(String itemName) {
		//waiting(2000);
		WebElement removeItemBtn = driver.findElement(By.cssSelector("#remove-sauce-labs-"+itemName+""));
		waiting(500);
		//waitVisibilityOf(removeItemBtn);
		//click(removeItemBtn);
		//WebElement removeItemBtn = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
		click(removeItemBtn);
	}

	//I want to write method that removes all items from cart 
	public void removeAllItemsFromCart() {
		int c=0;
		for(int i=0;i<6;i++) {
			click(removeBtn);
			c++;
			System.out.println(c);
		}
	}

	//Validation
	public void IsSelectedProductAddToCart() {
		click(checkOutBtn);
		waiting(1000);
	}

	//Validations
	public boolean isYourCartPage() {
		return getText(yourCartPageIndication).equalsIgnoreCase("YOUR CART");
	}

}
