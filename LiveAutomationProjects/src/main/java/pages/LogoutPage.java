package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//ul[@class = 'breadcrumb']//li/a[text()='Logout']")
	private WebElement verifyLogoutPageBreadcrum;
	
	public boolean verifyLogoutBreadcrum() {
		return verifyLogoutPageBreadcrum.isDisplayed();
	}
}
