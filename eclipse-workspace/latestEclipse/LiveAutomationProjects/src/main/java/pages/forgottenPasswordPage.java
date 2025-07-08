package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class forgottenPasswordPage {

	WebDriver driver;
	public forgottenPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Forgotten Password']")
	private WebElement forgottenPasswordPageVerify;
	

	
	public boolean ForgottenPasswordPageVerifyBreadcrum() {
		return forgottenPasswordPageVerify.isDisplayed();
	}
	
}
