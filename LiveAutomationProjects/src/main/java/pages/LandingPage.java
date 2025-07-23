package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(name = "search")
	private WebElement SearchBox;
	
	@FindBy(xpath = "//span[@class='input-group-btn']/button")
	private WebElement SearchButton; 
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}

	public RegisterPage selectRegister() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	public LoginPage selectLogin() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public void EnterSearchAnyProduct(String searchProject) {
		SearchBox.sendKeys(searchProject);	
	}
	public SearchPage ClickOnSearchButton() {
		SearchButton.click();
		return new SearchPage(driver);
	}

}
