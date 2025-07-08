package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage {

	WebDriver driver;
	public SubscriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//div[@class='col-sm-9']/h1")
	private WebElement verifySubscription;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement clickOnYesButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	private WebElement clickOnNoButton;
	
	public boolean DisplaySubscription() {
		return verifySubscription.isDisplayed();
	}
	public void ClickOnSubscript() {
		clickOnYesButton.click();
	}
	public void ClickOnUnSubscript() {
		clickOnNoButton.click();
	}
}
