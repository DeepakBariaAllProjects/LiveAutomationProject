package tutorialsninja.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Utils.CommonUtils;


public class Base {

	public static WebDriver driver;

	
	public WebDriver OpenBrowserAndApplication() {

		Properties prop = CommonUtils.loadProperties();
		
		String browserName = prop.getProperty("browserName");
		if(browserName.equals("chorme")) {
			driver = new ChromeDriver(); 
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
		
		return driver;
	}
	public WebDriver pressKeyMultipleTimes(WebDriver driver, Keys keyname, int count) {
		Actions action = new Actions(driver);
		for(int i=1;i<=count;i++) {
			action.sendKeys(keyname).perform();
		}
		return driver;
	}
	public void failed(String testMethodName) {
		 File Scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(Scr, new File("C://Users//ASUS//eclipse-workspace//latestEclipse//LiveAutomationProjects//ScreenShot//"+testMethodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
