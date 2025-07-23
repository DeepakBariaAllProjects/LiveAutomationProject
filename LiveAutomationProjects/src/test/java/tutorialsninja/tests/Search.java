package tutorialsninja.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;
import pages.LandingPage;
import pages.SearchPage;
import tutorialsninja.base.Base;

public class Search extends Base {

	WebDriver driver;
	LandingPage landingPang;
	SearchPage searchPage;
	Properties prop;

	@BeforeMethod
	public void setUp() {
		driver = OpenBrowserAndApplication();
		landingPang = new LandingPage(driver);
	}
	@Test
	public void VerifySearchProductWithValid() throws InterruptedException {
		prop = CommonUtils.loadProperties();
		landingPang.EnterSearchAnyProduct(prop.getProperty("Product1"));
		searchPage = landingPang.ClickOnSearchButton();
		Assert.assertTrue(searchPage.CheckSearchPage());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
