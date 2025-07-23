package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	} 
	
	@FindBy(linkText="Edit your account information")
	private WebElement finalAccountPage;
	
	@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
	private WebElement subscriptAndUnSubscriptVisible;

	
	public boolean SuccessfullRedirect() {
		return finalAccountPage.isDisplayed();
	}
	public SubscriptionPage VisibleTextSubscripAndSubscrip() {
		subscriptAndUnSubscriptVisible.click();
		return new SubscriptionPage(driver);
	}
	public void clickOnEditAccount() {
		finalAccountPage.click();
	} 

}
