package tutorialsninja.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendars {

	public static void main(String[] args) {
		WebDriver driver;
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		
		String cMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		String cYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		while(!cMonth.equals("December") && cYear.equals("2028")) {
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			cMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			cYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='27']")).click();
		driver.quit();
	} 

}
