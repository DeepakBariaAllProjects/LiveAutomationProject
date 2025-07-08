//package tutorialsninja.tests;
//
//import java.time.Duration;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.google.common.base.Objects;
//
//import Base.Base;
//import Utils.CommonUtils;
//
//public class TC_RF_020 extends Base{
//
//	WebDriver driver;
//	Properties prop;
//	@BeforeMethod
//	public void setUp() {
//
//		driver = OpenBrowserAndApplication();
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Register")).click();
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//
//	@Test(dataProvider = "environmentSupplier")
//	public void VerifyMultipleBrowserApplicationWorking(String envs) {
//
//		prop = CommonUtils.loadProperties();
//		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateNewEmail());
//		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("TelePhone"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("Password"));
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
//		String expectedResultOnRegistrationSuccessPage = "Your Account Has Been Created!";
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(),
//				expectedResultOnRegistrationSuccessPage);
//		driver.findElement(By.linkText("Continue")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
//		driver.quit();
//		
//
//	}
//
//	@DataProvider(name = "environmentSupplier")
//	public Object[][] passTestEnviornments() {
//		Object[][] envs = { { "chrome" }, { "firefox" }, { "edge" } };
//		return envs;
//	}
//
//}
