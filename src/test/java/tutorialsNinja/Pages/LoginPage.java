package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement loginWarningMassage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AccountPage navigateToLoginPageByCombinig3Actions(String emailText , String passwordText) {
		emailTextBox.sendKeys(emailText);
		passwordTextBox.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	
	public String retrieveLoginMassageText() {
		String text = loginWarningMassage.getText();
		return text;
	}
}
