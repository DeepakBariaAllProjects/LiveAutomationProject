package tutorialsninja.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;
import pages.AccountSuccessPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.forgottenPasswordPage;
import tutorialsninja.base.Base;

public class Login extends Base {

	public WebDriver driver;
	LandingPage landingPang;
	LoginPage login;
	Properties prop;
	AccountSuccessPage accountSuccessPage;
	forgottenPasswordPage forgottenPasswordPage ;
	LogoutPage logoutPage;
	

	@BeforeMethod
	public void setUp() {
		driver = OpenBrowserAndApplication();
		prop = CommonUtils.loadProperties();

		landingPang = new LandingPage(driver);
		landingPang.clickOnMyAccount();
		login = landingPang.selectLogin();
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCredencials() {
		prop = CommonUtils.loadProperties();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
		login.emailInputField(prop.getProperty("existEmail"));
		login.passwordInputField(prop.getProperty("Password"));
		accountSuccessPage = login.ClickOnLoginButton();
		Assert.assertTrue(accountSuccessPage.UserSuccessFullyLoggedIn());
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredencial() {
		prop = CommonUtils.loadProperties();
		login.emailInputField(CommonUtils.generateNewEmail());
		login.passwordInputField(prop.getProperty("invalidPassword"));
		login.ClickOnLoginButton();
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(login.expectedWarningMessage(), expectedWarning);
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailWithValidPassword() {
		prop = CommonUtils.loadProperties();
		login.emailInputField(prop.getProperty("invalidEmailOne"));
		login.passwordInputField(prop.getProperty("Password"));
		login.ClickOnLoginButton();
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(login.expectedWarningMessage(), expectedWarning);
	}

	@Test(priority = 4)
	public void verifyLoginWithvalidEmailWithInValidPassword() {
		prop = CommonUtils.loadProperties();
		login.emailInputField(prop.getProperty("existEmail"));
		login.passwordInputField(prop.getProperty("invalidPassword"));
		login.ClickOnLoginButton();
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(login.expectedWarningMessage(), expectedWarning);
	}

	@Test(priority = 5)
	public void verifyLoginWithoutCredencial() {

		login.ClickOnLoginButton();
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(login.expectedWarningMessage(), expectedWarning);
	}

	@Test(priority = 6)
	public void verifyForgottenPasswordLinkInLoginPage() {
		Assert.assertTrue(login.verifyForgottenPasswordInLoginPage());	
		forgottenPasswordPage = login.ClickOnForgottenPassword();
		forgottenPasswordPage.ForgottenPasswordPageVerifyBreadcrum();
	}
	@Test(priority = 7)
	public void verifyLoginPlaceholder() {
			String emailPlaceholder = "E-Mail Address";
			String passwordPlaceholder = "Password";
			Assert.assertEquals(login.emailPlaceholder(), emailPlaceholder);
			Assert.assertEquals(login.passwordPlaceholder(), passwordPlaceholder);
	}
	@Test(priority = 8)
	public void verifyBrowserBackAfterLogin() {
		prop = CommonUtils.loadProperties();
		login.emailInputField(prop.getProperty("existEmail"));
		login.passwordInputField(prop.getProperty("Password"));
		login.ClickOnLoginButton();
		driver.navigate().back();
		login = new LoginPage(driver);
		 accountSuccessPage = login.clickOnMyAccountRightSideOption();
		Assert.assertTrue(accountSuccessPage.UserSuccessFullyLoggedIn());
	}
	@Test(priority = 9)
	public void VerifyBrowserBackAfterLogout() {
		prop = CommonUtils.loadProperties();
		login.emailInputField(prop.getProperty("existEmail"));
		login.passwordInputField(prop.getProperty("Password"));
		accountSuccessPage = login.ClickOnLoginButton();
		logoutPage = accountSuccessPage.clickOnLogoutOption();
		driver.navigate().back();
		accountSuccessPage = new AccountSuccessPage(driver);
		login = accountSuccessPage.VerifyEditAccountInformationLinkInAccountPage();
		Assert.assertTrue(login.verifyLoginPageClickOnWishListRegister());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
