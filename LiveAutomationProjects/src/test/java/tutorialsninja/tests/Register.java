package tutorialsninja.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utils.CommonUtils;
import listerners.MyListerners;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.ContactUsPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SearchPage;
import pages.ShoppingPage;
import pages.SubscriptionPage;
import pages.forgottenPasswordPage;
import tutorialsninja.base.Base;

@Listeners(MyListerners.class)
public class Register extends Base {

	public WebDriver driver;
	Properties prop;
	RegisterPage registerPage;
	LandingPage landingPang;
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	SubscriptionPage subscription;
	LoginPage login;
	ContactUsPage contactUsPage;
	ShoppingPage ShoppingPage;
	SearchPage searchPage;
	forgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	public void setUp() {

		driver = OpenBrowserAndApplication();
		landingPang = new LandingPage(driver);
		landingPang.clickOnMyAccount();
		registerPage = landingPang.selectRegister();
	}

	@Test(priority = 1)
	public void VerifyRegistringWithMandotoryField() throws InterruptedException {
		prop = CommonUtils.loadProperties();
		registerPage.InputFirstName(prop.getProperty("firstName"));
		registerPage.InputLastName(prop.getProperty("lastName"));
		registerPage.InputEmail(CommonUtils.generateNewEmail());
		registerPage.InputTelephone(prop.getProperty("TelePhone"));
		registerPage.InputPassword(prop.getProperty("Password"));
		registerPage.InputConfirmPassword(prop.getProperty("Password"));
		registerPage.checkButton();
		accountSuccessPage = registerPage.ClickOnubmitButton();
		Assert.assertTrue(accountSuccessPage.UserSuccessFullyLoggedIn());
		accountPage = accountSuccessPage.RedirectToAccountPage();
		Assert.assertTrue(accountPage.SuccessfullRedirect());
	}

	@Test(priority = 2)
	public void VerifyRegisterWithoutFillingField() {
		registerPage.ClickOnubmitButton();
		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(registerPage.expectedFirstNameWarningResult(), expectedFirstNameWarning);
		Assert.assertEquals(registerPage.expectedLastNameWarningResult(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.expectedEmailWarningResult(), expectedEmailWarning);
		Assert.assertEquals(registerPage.expectedTelephoneWarningResult(), expectedTelephoneWarning);
		Assert.assertEquals(registerPage.expectedPasswordWarningResult(), expectedPasswordWarning);
		Assert.assertEquals(registerPage.expectedConfirmPasswordWarningResult(), expectedPolicyWarning);
	}

	@Test(priority = 3)
	public void VerifyNewspaper() {
		prop = CommonUtils.loadProperties();
		registerPage.InputFirstName(prop.getProperty("firstName"));
		registerPage.InputLastName(prop.getProperty("lastName"));
		registerPage.InputEmail(CommonUtils.generateNewEmail());
		registerPage.InputTelephone(prop.getProperty("TelePhone"));
		registerPage.InputPassword(prop.getProperty("Password"));
		registerPage.InputConfirmPassword(prop.getProperty("Password"));
		registerPage.checkButton();
		accountSuccessPage = registerPage.ClickOnubmitButton();
		accountPage = accountSuccessPage.RedirectToAccountPage();
		subscription = accountPage.VisibleTextSubscripAndSubscrip();
		Assert.assertTrue(subscription.DisplaySubscription());
		subscription.ClickOnSubscript();
	}

	@Test(priority = 4)
	public void verifyNewspaperByNo() {

		prop = CommonUtils.loadProperties();
		registerPage.InputFirstName(prop.getProperty("firstName"));
		registerPage.InputLastName(prop.getProperty("lastName"));
		registerPage.InputEmail(CommonUtils.generateNewEmail());
		registerPage.InputTelephone(prop.getProperty("TelePhone"));
		registerPage.InputPassword(prop.getProperty("Password"));
		registerPage.InputConfirmPassword(prop.getProperty("Password"));
		registerPage.checkButton();
		accountSuccessPage = registerPage.ClickOnubmitButton();
		accountPage = accountSuccessPage.RedirectToAccountPage();
		subscription = accountPage.VisibleTextSubscripAndSubscrip();
		Assert.assertTrue(subscription.DisplaySubscription());
		subscription.ClickOnSubscript();
	}

	@Test(priority = 5)
	public void verifynavigatingToRegisterAccountUsingMultipleWays() {
		login = new LoginPage(driver);
		login.ClickOnLoginOption();
		Assert.assertTrue(login.VerifyLoginText());
		login.RedicrectRegistration();
		Assert.assertTrue(login.verifyRegistrationPages());
		landingPang.clickOnMyAccount();
		login.ClickOnLoginOption();
		login.clickToRegistrationToNegivate();
		Assert.assertTrue(registerPage.RegistrationHeadingVerification());
	}

	@Test(priority = 6)
	public void verifyWrongPasswordWaringMessage() {
		prop = CommonUtils.loadProperties();

		registerPage.InputFirstName(prop.getProperty("firstName"));
		registerPage.InputLastName(prop.getProperty("lastName"));
		registerPage.InputEmail(CommonUtils.generateNewEmail());
		registerPage.InputTelephone(prop.getProperty("TelePhone"));
		registerPage.InputPassword(prop.getProperty("Password"));
		registerPage.InputConfirmPassword(prop.getProperty("invalidPassword"));
		registerPage.checkButton();
		registerPage.ClickOnubmitButton();
		String verifyPasswordWarningMessage = "Password confirmation does not match password!";
		Assert.assertEquals(registerPage.warningMessageOnConfirmPassword(), verifyPasswordWarningMessage);
	}

	@Test(priority = 7)
	public void verifyDublicateEmailWarningMessage() {

		prop = CommonUtils.loadProperties();
		registerPage.InputFirstName(prop.getProperty("firstName"));
		registerPage.InputLastName(prop.getProperty("lastName"));
		registerPage.InputEmail(prop.getProperty("existEmail"));
		registerPage.InputTelephone(prop.getProperty("TelePhone"));
		registerPage.InputPassword(prop.getProperty("Password"));
		registerPage.InputConfirmPassword(prop.getProperty("Password"));
		registerPage.checkButton();
		registerPage.ClickOnubmitButton();
		String VerifyAlertMessageOfDublicateEmail = "Warning: E-Mail Address is already registered!";
		Assert.assertEquals(registerPage.DuplicateEmailWarningMessage(), VerifyAlertMessageOfDublicateEmail);

	}

	@Test(priority = 8)
	public void VerifyAllPlaceholder() {

		String FirstNamePlaceholder = "First Name";
		Assert.assertEquals(registerPage.FirstNamePlaceholder(), FirstNamePlaceholder);

		String LastNamePlaceholder = "Last Name";
		Assert.assertEquals(registerPage.LastNamePlaceholder(), LastNamePlaceholder);

		String EmailPlaceholder = "E-Mail";
		Assert.assertEquals(registerPage.EmailPlaceholder(), EmailPlaceholder);

		String TelephonePlaceholder = "Telephone";
		Assert.assertEquals(registerPage.telephonePlaceholder(), TelephonePlaceholder);

		String passwordPlaceholder = "Password";
		Assert.assertEquals(registerPage.passwordPlaceholder(), passwordPlaceholder);

		String ConfirmPasswordPlaceholder = "Password Confirm";
		Assert.assertEquals(registerPage.confirmpasswordPlaceholder(), ConfirmPasswordPlaceholder);

	}

	@Test(priority = 9)
	public void VerifyMendatoryField() throws InterruptedException {

		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		Assert.assertEquals(registerPage.getFirstNameLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.getFirstNameLabelColor(driver), expectedColor);
		Assert.assertEquals(registerPage.getlastNameLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.getlastNameLabelColor(driver), expectedColor);
		Assert.assertEquals(registerPage.getEmailLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.getEmailLabelColor(driver), expectedColor);
		Assert.assertEquals(registerPage.getTelephoneLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.getTelephoneLabelColor(driver), expectedColor);
		Assert.assertEquals(registerPage.getPasswordLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.getPasswordLabelColor(driver), expectedColor);
		Assert.assertEquals(registerPage.getConfirmPasswordLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.getConfirmPasswordLabelColor(driver), expectedColor);
	}

	@Test(priority = 10)
	public void verifyWarningMessagesWithSpace() {

		registerPage.InputFirstName(" ");
		registerPage.InputLastName(" ");
		registerPage.InputEmail(" ");
		registerPage.InputTelephone(" ");
		registerPage.InputPassword(" ");
		registerPage.InputConfirmPassword(" ");
		registerPage.checkButton();
		registerPage.ClickOnubmitButton();

		String WarningMessageFirstName = "First Name must be between 1 and 32 characters!";
		String WarningMessageLastName = "Last Name must be between 1 and 32 characters!";
		String WarningMessageEmailName = "E-Mail Address does not appear to be valid!";
		String WarningMessageTelephone = "Telephone must be between 3 and 32 characters!";
		String WarningMessagePasswardName = "Password must be between 4 and 20 characters!";

		Assert.assertEquals(registerPage.firstNameWarningMessageVerify(), WarningMessageFirstName);
		Assert.assertEquals(registerPage.lastNameWarningMessageVerify(), WarningMessageLastName);
		Assert.assertEquals(registerPage.emailWarningMessageVerify(), WarningMessageEmailName);
		Assert.assertEquals(registerPage.telephoneWarningMessageVerify(), WarningMessageTelephone);
		Assert.assertEquals(registerPage.passwordWarningMessageVerify(), WarningMessagePasswardName);
	}

	@Test(dataProvider = "passwordSupplier", priority = 11)
	public void VerifyPasswordFieldCompalacity(String username) {

		prop = CommonUtils.loadProperties();
		registerPage.InputFirstName(prop.getProperty("firstName"));
		registerPage.InputLastName(prop.getProperty("lastName"));
		registerPage.InputEmail(CommonUtils.generateNewEmail());
		registerPage.InputTelephone(prop.getProperty("TelePhone"));
		registerPage.selectNewPagerYesOption();
		registerPage.checkButton();
		registerPage.InputPassword(username);
		registerPage.InputConfirmPassword(username);
		registerPage.ClickOnubmitButton();

		String WarningMessagePassword = "Password entered is not matching the Complexity standards";

		Assert.assertEquals(registerPage.MultipasswordWarningMessage(), WarningMessagePassword);

	}

	@DataProvider(name = "passwordSupplier")
	public Object[][] supplyPasswords() {
		
		
		Object[][] data = null;
		try {
			data = CommonUtils.getTestDataFromExcel("BadPasswords");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Test(priority = 12)
	public void VerifyLeadingAndTrilingSpaceWhileRegistration() {

		prop = CommonUtils.loadProperties();
		registerPage.InputFirstName("     Deepak   ");
		registerPage.InputLastName("     Deepak   ");
		registerPage.InputEmail("   " + CommonUtils.generateNewEmail() + "    ");
		registerPage.InputTelephone("   123456789   ");
		registerPage.InputPassword(prop.getProperty("Password"));
		registerPage.InputConfirmPassword(prop.getProperty("Password"));
		registerPage.checkButton();
		accountSuccessPage = registerPage.ClickOnubmitButton();
		accountPage = accountSuccessPage.RedirectToAccountPage();
		Assert.assertTrue(accountPage.SuccessfullRedirect());
	}

	@Test(priority = 13)
	public void VerifyprivecyPoilicyDefaultChecked() {
		Assert.assertFalse(registerPage.CheckPrivacyPolicyChecked());
	}

	@Test(priority = 14)
	public void VerifyPrivecyPolicyWarningMessage() {

		prop = CommonUtils.loadProperties();
		registerPage.InputFirstName(prop.getProperty("firstName"));
		registerPage.InputLastName(prop.getProperty("lastName"));
		registerPage.InputEmail(CommonUtils.generateNewEmail());
		registerPage.InputTelephone(prop.getProperty("TelePhone"));
		registerPage.InputPassword(prop.getProperty("Password"));
		registerPage.InputConfirmPassword(prop.getProperty("Password"));
		registerPage.ClickOnubmitButton();

		String privecyPolicy = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(registerPage.ClickOnContinueButtonWithoutPrivacyPolicy(), privecyPolicy);
	}

	@Test(priority = 15)
	public void verifyVisibilityTogglineOfPasswordFieldOnRegistredAccount() {

		Assert.assertEquals(registerPage.TogglePassword(), "password");
		Assert.assertEquals(registerPage.ToggleConfirm(), "password");

	}

	@Test(priority = 16)
	public void verifyAllTheLinksOnRegisterPage() throws InterruptedException {

		contactUsPage = registerPage.fafaPhoneClickOnRegister();
		Assert.assertTrue(contactUsPage.fafaPhoneVerifyOnContact());
		driver.navigate().back();

		registerPage = new RegisterPage(driver);
		login = registerPage.fafaWishListClickOnRegister();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		ShoppingPage = registerPage.fafaShoppingIcon();
		Assert.assertTrue(ShoppingPage.fafaShoppingIcon());
		driver.navigate().back();

		registerPage.fafaCheckoutIcons();
		Assert.assertTrue(ShoppingPage.fafaCheckoutIcon());
		driver.navigate().back();

		searchPage = registerPage.ClickOnSearchButton();
		Assert.assertTrue(searchPage.CheckSearchPage());
		driver.navigate().back();

		registerPage.ClickAtRegisterLinkAtBreadcrum();
		Assert.assertTrue(registerPage.registerPageHeadingVerify());

		registerPage.clickAtAccountLinkAtRegisterBreadcrum();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickOnLoginpageAtRegisterPage();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickOnLoginOptionAtGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickOnRegisterOptionAtGroupItem();
		Assert.assertTrue(registerPage.registerPageHeadingVerify());

		forgottenPasswordPage = registerPage.ClickOnForgottenOptinAtGroupItem();
		Assert.assertTrue(forgottenPasswordPage.ForgottenPasswordPageVerifyBreadcrum());
		driver.navigate().back();

		registerPage.ClickMyAccountOptionAtGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickAddressBookOptionAtGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickWishListOptionAtGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickOrderHistoryAtGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickDownloadAtGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickRecurringPaymentGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickRewardPointGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickReturnGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickTransactionGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();

		registerPage.ClickNewsLetterGroupItem();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		driver.navigate().back();
	}



	@Test(priority = 18)
	public void VerifyBreadcurmURLTitleHeading() {

		String PageHeading = "Register Account";
		Assert.assertEquals(registerPage.RegisterPageHeadingText(), PageHeading);

		Assert.assertTrue(registerPage.registerBreadCrumAtRegisterPage());
	}

	@AfterMethod
	public void tearDown() {
		
			driver.quit();
		
	}

}
