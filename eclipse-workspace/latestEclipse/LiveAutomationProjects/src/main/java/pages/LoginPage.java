package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Login")
	private WebElement LoginClick; 
	
	@FindBy(xpath = "//div[@class='col-sm-6']/div/h2")
	private WebElement confirmLoginPage;
	
	@FindBy(linkText = "Continue")
	private WebElement clickOnContinueToRedirectRegistration;
	
	@FindBy(xpath = "//div[@class='col-sm-9']/h1")
	private WebElement verifyRegistrationPage;
	
	@FindBy(linkText = "Register")
	private WebElement clickOnRegistration;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Login']")
	private WebElement loginVerifyBreadcrumb;
	
	@FindBy(xpath = "//input[@id = 'input-email']")
	private WebElement emailInput;
	
	@FindBy(xpath = "//input[@id = 'input-password']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidCredencialWarningMessage;
	
	@FindBy(xpath = "//a[text()='Forgotten Password']")
	private WebElement ForgottenPasswordExitVerify;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='My Account']")
	private WebElement MyAccountRightSideOption;

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement LogOutRightSideOption;
	
	public void ClickOnLoginOption() {
		LoginClick.click();
	}
	public boolean VerifyLoginText() {
		return confirmLoginPage.isDisplayed();
	}
	public void RedicrectRegistration() {
		clickOnContinueToRedirectRegistration.click();
	}
	public boolean verifyRegistrationPages() {
		return verifyRegistrationPage.isDisplayed();
	}
	public void clickToRegistrationToNegivate() {
		clickOnRegistration.click();
	}
	public boolean verifyLoginPageClickOnWishListRegister() {
		return loginVerifyBreadcrumb.isDisplayed();
	}
	public void emailInputField(String emailField) {
		emailInput.sendKeys(emailField);
	}
	public void passwordInputField(String passwordField) {
		passwordInput.sendKeys(passwordField);
	}
	public AccountSuccessPage ClickOnLoginButton() {
		loginButton.click();
		return new AccountSuccessPage(driver);
	}
	public String expectedWarningMessage() {
		return invalidCredencialWarningMessage.getText();
	}
	public boolean verifyForgottenPasswordInLoginPage() {
		return ForgottenPasswordExitVerify.isDisplayed();
	}
	public forgottenPasswordPage ClickOnForgottenPassword() {
		ForgottenPasswordExitVerify.click();
		return new forgottenPasswordPage(driver);
	}
	public String emailPlaceholder() {
		return emailInput.getDomAttribute("placeholder");
	}
	public String passwordPlaceholder() {
		return passwordInput.getDomAttribute("placeholder");
	}
	public AccountSuccessPage clickOnMyAccountRightSideOption() {
		MyAccountRightSideOption.click();
		return new AccountSuccessPage(driver);
	}
	public void clickOnLogoutButtonRightSideOption() {
		LogOutRightSideOption.click();
	}
}
