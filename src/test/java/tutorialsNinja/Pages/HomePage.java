package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
 
	//in the Page class, we will define the WebElements, we will initialize the WebElents and we will create actions for those WebElements
	
	@FindBy(linkText = "My Account")
	private WebElement myAccoutDropdow;
	
	@FindBy(linkText = "Login")
	private WebElement LoginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	public LoginPage combiningTwoActionsToNavigateToLoginPage() {
		myAccoutDropdow.click();
		LoginOption.click();
		return new LoginPage(driver);
	}

	public RegisterPage combiningTwoActionsToNavigateToRegisterPage() {
		myAccoutDropdow.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	
	public void enterProductName(String validProductText) {
		searchBox.sendKeys(validProductText);
		
	}
	
	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}
	
	public ProductPage navigateToProductPage(String validProductText) {
		searchBox.sendKeys(validProductText);
		searchButton.click();
		return new ProductPage(driver);
		
	}
	
}
