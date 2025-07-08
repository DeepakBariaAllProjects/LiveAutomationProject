package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Logout")
	private WebElement LogoutDisplay;
	
	@FindBy(linkText="Continue")
	private WebElement AccountPage;

	@FindBy(xpath = "//ul[@class='list-unstyled']//a[text()='Edit your account information']")
	private WebElement EditAccountPage;
	
	public boolean UserSuccessFullyLoggedIn() {
		return LogoutDisplay.isDisplayed();
	}
	
	public AccountPage RedirectToAccountPage() {
		AccountPage.click();
		return new AccountPage(driver);
	}
	public LogoutPage clickOnLogoutOption() {
		LogoutDisplay.click();
		return new LogoutPage(driver);
	}
	public LoginPage VerifyEditAccountInformationLinkInAccountPage() {
		EditAccountPage.click();
		return new LoginPage(driver);
	}
	
}
