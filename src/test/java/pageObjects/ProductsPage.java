package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends MenuPage{

	@FindBy(css="[id^='add-to-cart']")
	private WebElement addToCartBtn;
	@FindBy(css=".title")
	private WebElement productsTitle;
	@FindBy(css=".shopping_cart_link")
	private WebElement openCartBtn; 
	@FindBy(css=".inventory_item")
	private List<WebElement> itemsList;

	//Elements for sort(drop list)
	@FindBy(css=".product_sort_container")
	private WebElement dropList;
	WebElement el = dropList;
	Select s = new Select(el);
	@FindBy(css=".inventory_item")
	private List<WebElement> listOfProducts;
	@FindBy(css="#item_4_title_link > div")
	private WebElement sortNameAtoZ;
	@FindBy(css="#item_3_title_link > div")
	private WebElement sortNameZtoA;
	@FindBy(css="#item_2_title_link > div")
	private WebElement sortLowToHigh;
	@FindBy(css="#item_5_title_link > div")
	private WebElement sortHighToLow;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void chooseProduct(String productName) {
		for (WebElement el : listOfProducts) {
			WebElement titleEl = el.findElement(By.cssSelector(".inventory_item_name"));
			String name = getText(titleEl);
			if (name.equalsIgnoreCase(productName)) {
				click(titleEl);
				break;
			}
		}
		waiting(500);
	}

	public void addToCart(String productName) {
		for (WebElement el : itemsList) {
			String title = getText(el.findElement(By.cssSelector(".inventory_item_name")));
			if (title.equalsIgnoreCase(productName)) {
				click(el.findElement(By.cssSelector(".btn_inventory.btn_primary")));
				break;
			}
		}
	}

	public void addAllProductsToCart() {
		for (WebElement el : itemsList) {
			click(el.findElement(By.cssSelector(".btn_inventory.btn_primary")));
		}
	}

	public void addToCart() {
		click(addToCartBtn);
		waiting(1000);
	}

	public void removeItem(String itemName) {
		WebElement removeItemBtn = driver.findElement(By.cssSelector("#remove-sauce-labs-"+itemName));
		click(removeItemBtn);
	}

	public void openCart() {
		click(openCartBtn);
		waiting(1000);
	}

	public boolean nameAtoZ() {
		click(dropList);
		s.selectByValue("az");
		waiting(1000);
		String s = sortNameAtoZ.getText();
		if(s.equalsIgnoreCase("Sauce Labs Backpack"))
			return true;
		return false;
	}

	public boolean nameZtoA() {
		click(dropList);
		s.selectByValue("za");
		waiting(2000);
		String s = sortNameZtoA.getText();
		if(s.equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)"))
			return true;
		return false;
		
	}

	public boolean priceLowtoHigh() {
		click(dropList);
		s.selectByValue("lohi");
		waiting(1000);
		String s = sortLowToHigh.getText();
		if(s.equalsIgnoreCase("Sauce Labs Onesie"))
			return true;
		return false;
	}

	public boolean priceHightoLow() {
		click(dropList);
		s.selectByValue("hilo");
		waiting(1000);
		String s = sortHighToLow.getText();
		if(s.equalsIgnoreCase("Sauce Labs Fleece Jacket"))
			return true;
		return false;
	}
	//
	//Validation
	//
	//This method checks if ProductPage display
	public boolean isProductPage () {
		if(productsTitle.isDisplayed())
			return true;
		return false;
	}

	//This method Checks if the product is not in the cart
	public String isAddToCartBtnShow(String productName) {
		String s = null;
		for (WebElement el : itemsList) {
			String title = getText(el.findElement(By.cssSelector(".inventory_item_name")));
			if (title.equalsIgnoreCase(productName)) {
				s = addToCartBtn.getText();
			}
		}
		return s;
	}
}
