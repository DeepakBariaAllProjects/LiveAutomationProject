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
import tutorialsninja.base.Base;

public class Logout extends Base {

	WebDriver driver;
	Properties prop;
	LandingPage landingPang;
	LoginPage login;
	AccountSuccessPage accountSuccessPage;
	LogoutPage logout;

	@BeforeMethod
	public void setUp() {
		driver = OpenBrowserAndApplication();
		prop = CommonUtils.loadProperties();

		landingPang = new LandingPage(driver);
		landingPang.clickOnMyAccount();
		login = landingPang.selectLogin();
	}

	@Test
	public void verifyLoggingOutWithUsingMyAccountDropDoown() {
		login.emailInputField(prop.getProperty("existEmail"));
		login.passwordInputField(prop.getProperty("Password"));
		accountSuccessPage = login.ClickOnLoginButton();
		accountSuccessPage.ClickAtMyAccountDropDown();
		logout = accountSuccessPage.clickLogoutFromMyAccountDropDown();
		Assert.assertTrue(logout.verifyLogoutBreadcrum());

	}
	@Test
	public void verifylogoutFunctionalityFromSelectingRightSideOptions() {
		login.emailInputField(prop.getProperty("existEmail"));
		login.passwordInputField(prop.getProperty("Password"));
		accountSuccessPage = login.ClickOnLoginButton();
		accountSuccessPage.ClickRightSideLogoutOption();
		logout = accountSuccessPage.clickLogoutFromMyAccountDropDown();
		Assert.assertTrue(logout.verifyLogoutBreadcrum()); 
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
