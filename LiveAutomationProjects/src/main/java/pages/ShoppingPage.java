package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

	WebDriver driver;
	public ShoppingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Shopping Cart']")
	private WebElement verifyShoppingBreadcrump;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Shopping Cart']")
	private WebElement fafaCheckoutClick;
	
	public boolean fafaShoppingIcon() {
		return verifyShoppingBreadcrump.isDisplayed();
	}
	public boolean fafaCheckoutIcon() {
		return fafaCheckoutClick.isDisplayed();
	}
}
