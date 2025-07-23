package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheck;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement expectedFirstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement expectedLastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement expectedEmailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement expectedTelephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement expectedPasswordWarning;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement expectedConfirmPasswordWarning;

	@FindBy(xpath = "//div[@class='col-sm-9']/h1")
	private WebElement VerifyToRegistrationHeading;

	@FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div")
	private WebElement VerifyPasswordconfirmMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement verifyDuplicateEmail;
	
	@FindBy(css = "label[for='input-firstname']")
	private WebElement firstNameLabel;
	
	@FindBy(css = "label[for='input-lastname']")
	private WebElement lastNameLabel;
	
	@FindBy(css = "label[for='input-email']")
	private WebElement emailLabel;
	
	@FindBy(css = "label[for='input-telephone']")
	private WebElement telephoneLabel;
	
	@FindBy(css = "label[for='input-password']")
	private WebElement PasswordLabel;
	
	@FindBy(css = "label[for='input-confirm']")
	private WebElement ConfirmPasswordLabel;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement confirmpasswordWarningMessage;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newPaperSelect;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement multiplePasswordWarningMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessageWithoutClickOnPrivacyPolicy;
	
	@FindBy(xpath = "//a/i[@class='fa fa-phone']")
	private WebElement fafaPhone;
	
	@FindBy(xpath = "//a/i[@class='fa fa-heart']")
	private WebElement fafaWishLish;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Login']")
	private WebElement verifyClickOnAtR;
	
	@FindBy(xpath = "//a/i[@class='fa fa-shopping-cart']")
	private WebElement clickOnRegisterShoppingIcon;
	
	@FindBy(xpath = "//a/i[@class='fa fa-share']")
	private WebElement clickOnfafaCheckout;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement clickOnSearchIcon;
	
	@FindBy(linkText = "Register")
	private WebElement LinkOfRegisterAtRegisterPage;
	
	@FindBy(xpath = "//div[@class='col-sm-9']/h1")
	private WebElement RegisterPageHeading;
	
	@FindBy(linkText = "Account")
	private WebElement clickAtAccountBreadcrum;
	
	@FindBy(linkText = "login page")
	private WebElement clickOnloginPageOption;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Login']")
	private WebElement loginOptionIngroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Register']")
	private WebElement registerOptionInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Forgotten Password']")
	private WebElement forgottenPasswordInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='My Account']")
	private WebElement myAccountInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Address Book']")
	private WebElement addresBookInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Wish List']")
	private WebElement wishListInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Order History']")
	private WebElement orderHistoryInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Downloads']")
	private WebElement downloadInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Recurring payments']")
	private WebElement recurringPaymentInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Reward Points']")
	private WebElement rewardPoint;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Returns']")
	private WebElement returnInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Transactions']")
	private WebElement transactionInGroup;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Newsletter']")
	private WebElement newsLetterInGroup;
	
	@FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div")
	private WebElement PasswordAndConfirmPasswordMatch;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Register']")
	private WebElement registerBreadcrum;
	
	public void InputFirstName(String EnterFirstName) {
		firstNameField.sendKeys(EnterFirstName);
	}

	public void InputLastName(String EnterLastName) {
		lastNameField.sendKeys(EnterLastName);
	}

	public void InputEmail(String EnterEmail) {
		emailField.sendKeys(EnterEmail);
	}

	public void InputTelephone(String EnterTelephone) {
		telephoneField.sendKeys(EnterTelephone);
	}

	public void InputPassword(String EnterPassword) {
		passwordField.sendKeys(EnterPassword);
	}

	public void InputConfirmPassword(String EnterConfirmPassword) {
		confirmField.sendKeys(EnterConfirmPassword);
	}

	public void checkButton() {
		privacyPolicyCheck.click();
	}

	public AccountSuccessPage ClickOnubmitButton() {
		submitButton.click();
		return new AccountSuccessPage(driver);
	}

	public String expectedFirstNameWarningResult() {
		return expectedFirstNameWarning.getText();
	}

	public String expectedLastNameWarningResult() {
		return expectedLastNameWarning.getText();
	}

	public String expectedEmailWarningResult() {
		return expectedEmailWarning.getText();
	}

	public String expectedTelephoneWarningResult() {
		return expectedTelephoneWarning.getText();
	}

	public String expectedPasswordWarningResult() {
		return expectedPasswordWarning.getText();
	}

	public String expectedConfirmPasswordWarningResult() {
		return expectedConfirmPasswordWarning.getText();
	}

	public boolean RegistrationHeadingVerification() {
		return VerifyToRegistrationHeading.isDisplayed();
	}

	public String warningMessageOnConfirmPassword() {
		return VerifyPasswordconfirmMessage.getText();
	}
	public String DuplicateEmailWarningMessage() {
		return verifyDuplicateEmail.getText();
	}
	public String FirstNamePlaceholder() {
		return firstNameField.getAttribute("placeholder");
	}
	public String LastNamePlaceholder() {
		return lastNameField.getAttribute("placeholder");
	}
	public String EmailPlaceholder() {
		return emailField.getAttribute("placeholder");
	}
	public String telephonePlaceholder() {
		return telephoneField.getAttribute("placeholder");
	}
	public String passwordPlaceholder() {
		return passwordField.getAttribute("placeholder");
	}
	public String confirmpasswordPlaceholder() {
		return confirmField.getAttribute("placeholder");
	}
	public String getFirstNameLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fnContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstNameLabel);
		return fnContent;
	}
	public String getFirstNameLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fnColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstNameLabel);
				return fnColor;
	}
	public String getlastNameLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String lnContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", lastNameLabel);
		return lnContent;
	}
	public String getlastNameLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String lnColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", lastNameLabel);
				return lnColor;
	}
	public String getEmailLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String emailContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", emailLabel);
		return emailContent;
	}
	public String getEmailLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String emailColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", emailLabel);
				return emailColor;
	}
	public String getTelephoneLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String telephoneContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", telephoneLabel);
		return telephoneContent;
	}
	public String getTelephoneLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String telephoneColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", telephoneLabel);
				return telephoneColor;
	}
	public String getPasswordLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String PasswordContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", PasswordLabel);
		return PasswordContent;
	}
	public String getPasswordLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String PasswordColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", PasswordLabel);
				return PasswordColor;
	}
	public String getConfirmPasswordLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ConfirmPasswordContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", ConfirmPasswordLabel);
		return ConfirmPasswordContent;
	}
	public String getConfirmPasswordLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ConfirmPasswordColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", ConfirmPasswordLabel);
				return ConfirmPasswordColor;
	}
	public String firstNameWarningMessageVerify() {
		return firstNameWarningMessage.getText();
	}
	public String lastNameWarningMessageVerify() {
		return lastNameWarningMessage.getText();
	}
	public String emailWarningMessageVerify() {
		return emailWarningMessage.getText();
	}
	public String telephoneWarningMessageVerify() {
		return telephoneWarningMessage.getText();
	}
	public String passwordWarningMessageVerify() {
		return passwordWarningMessage.getText();
	}
	public void selectNewPagerYesOption() {
		newPaperSelect.click();
	}
	public String MultipasswordWarningMessage() {
		return multiplePasswordWarningMessage.getText();
	}
	public boolean CheckPrivacyPolicyChecked() {
		return privacyPolicyCheck.isSelected();
	}
	public String ClickOnContinueButtonWithoutPrivacyPolicy() {
		return warningMessageWithoutClickOnPrivacyPolicy.getText();
	}
	public String TogglePassword() {
		return passwordField.getAttribute("type");
	}
	public String ToggleConfirm() {
		return confirmField.getAttribute("type");
	}

	public ContactUsPage fafaPhoneClickOnRegister() {
		fafaPhone.click();
		return new ContactUsPage(driver);
	}

	public LoginPage fafaWishListClickOnRegister() {
		fafaWishLish.click();
		return new LoginPage(driver);
	}
	public ShoppingPage fafaShoppingIcon() {
		clickOnRegisterShoppingIcon.click();
		return new ShoppingPage(driver);
	}
	public void fafaCheckoutIcons() {
		clickOnfafaCheckout.click();
	}
	public SearchPage ClickOnSearchButton() {
		clickOnSearchIcon.click();
		return new SearchPage(driver);
	}
	public void ClickAtRegisterLinkAtBreadcrum() {
		LinkOfRegisterAtRegisterPage.click();
	}
	public boolean registerPageHeadingVerify() {
		return RegisterPageHeading.isDisplayed();
	}
	public void clickAtAccountLinkAtRegisterBreadcrum() {
		clickAtAccountBreadcrum.click();
	}
	public void ClickOnLoginpageAtRegisterPage() {
		clickOnloginPageOption.click();
	}
	public void ClickOnLoginOptionAtGroupItem() {
		loginOptionIngroup.click();
	}
	public void ClickOnRegisterOptionAtGroupItem() {
		registerOptionInGroup.click();
	}
	public forgottenPasswordPage ClickOnForgottenOptinAtGroupItem(){
		forgottenPasswordInGroup.click();
		return new forgottenPasswordPage(driver);
	}
	public void ClickMyAccountOptionAtGroupItem() {
		myAccountInGroup.click();
	}
	public void ClickAddressBookOptionAtGroupItem() {
		addresBookInGroup.click();
	}
	public void ClickWishListOptionAtGroupItem() {
		wishListInGroup.click();
	}
	public void ClickOrderHistoryAtGroupItem() {
		orderHistoryInGroup.click();
	}
	public void ClickDownloadAtGroupItem() {
		downloadInGroup.click();
	}
	public void ClickRecurringPaymentGroupItem() {
		recurringPaymentInGroup.click();
	}
	public void ClickRewardPointGroupItem() {
		rewardPoint.click();
	}
	public void ClickReturnGroupItem() {
		returnInGroup.click();
	}
	public void ClickTransactionGroupItem() {
		transactionInGroup.click();
	}
	public void ClickNewsLetterGroupItem() {
		newsLetterInGroup.click();
	}
	public String VerifyMatchPasswordAndConfirmPassword() {
		return PasswordAndConfirmPasswordMatch.getText();
	}
	public String RegisterPageHeadingText() {
		return RegisterPageHeading.getText();
	}
	public boolean registerBreadCrumAtRegisterPage() {
		return registerBreadcrum.isDisplayed();
	}
}