//package tutorialsninja.register;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.time.Duration;
//
//import javax.imageio.ImageIO;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.io.FileHandler;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import ru.yandex.qatools.ashot.comparison.ImageDiff;
//import ru.yandex.qatools.ashot.comparison.ImageDiffer;
//
//public class TC_RF_008 {
//
//	WebDriver driver;
//
//	@BeforeMethod
//	public void setUp() {
//
//		String browserName = "chorme";
//		if (browserName.equals("chorme")) {
//			driver = new ChromeDriver();
//		} else if (browserName.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.get("https://tutorialsninja.com/demo/");
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Register")).click();
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//
//	@Test
//	public void verifyInvalidEmailMessage() throws InterruptedException, IOException {
//
//		driver.findElement(By.id("input-firstname")).sendKeys("Deepak");
//		driver.findElement(By.id("input-lastname")).sendKeys("baria");
//		driver.findElement(By.id("input-email")).sendKeys("Deepak");
//		driver.findElement(By.id("input-telephone")).sendKeys("123456789");
//		driver.findElement(By.id("input-password")).sendKeys("Deepak@123");
//		driver.findElement(By.id("input-confirm")).sendKeys("Deepak@123");
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		Thread.sleep(3000);
//
//		File ScrShot = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
//				.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(ScrShot, new File(System.getProperty("user.dir") + "\\ScreenShot\\s1Actual.png"));
//
//		BufferedImage ActualImage = ImageIO
//				.read(new File(System.getProperty("user.dir") + "\\ScreenShot\\s1Actual.png"));
//		BufferedImage ExpectedImage = ImageIO
//				.read(new File(System.getProperty("user.dir") + "\\ScreenShot\\s1Expected.png"));
//
//		ImageDiffer imgDiffer = new ImageDiffer();
//		ImageDiff imgDifference = imgDiffer.makeDiff(ExpectedImage, ActualImage);
//
//		Assert.assertFalse(imgDifference.hasDiff());
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.id("input-email")).clear();
//		driver.findElement(By.id("input-email")).sendKeys("Deepak@gmail.");
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		File ScrShot3 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
//				.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(ScrShot3, new File(System.getProperty("user.dir") + "\\ScreenShot\\s3Actual.png"));
//
//		BufferedImage ActualImage3 = ImageIO
//				.read(new File(System.getProperty("user.dir") + "\\ScreenShot\\s3Actual.png"));
//		BufferedImage ExpectedImage3 = ImageIO
//				.read(new File(System.getProperty("user.dir") + "\\ScreenShot\\s3Expected.png"));
//
//		ImageDiffer imgDiffer3 = new ImageDiffer();
//		ImageDiff imgDifference3 = imgDiffer3.makeDiff(ExpectedImage3, ActualImage3);
//		Assert.assertFalse(imgDifference3.hasDiff());
//
//		driver.findElement(By.id("input-email")).clear();
//		driver.findElement(By.id("input-email")).sendKeys("Deepak@gmail");
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		String InvalidMessageEmail = "E-Mail Address does not appear to be valid!";
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),
//				InvalidMessageEmail);
//		Thread.sleep(3000);
//
//	}
//
//}



