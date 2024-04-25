package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	public WebDriver driver;
	
	@FindBy(css= "div#content>p:nth-child(2)")
	private WebElement accountSuccessfullyCreateMassage;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean successPage() {
		boolean success =accountSuccessfullyCreateMassage.isDisplayed();
		return success;
	}
	
	
}
