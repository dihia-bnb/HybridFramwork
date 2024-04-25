package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstnameTextBox;

	@FindBy(id = "input-lastname")
	private WebElement lastnametextBox;

	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement subsribeNewsRadioButton;

	@FindBy(css = "a.agree+input")
	private WebElement privatePoliceCheckBox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement contiueButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarningMassage;

	@FindBy(css = "input#input-firstname+div")
	private WebElement firstnameWarningMassage;

	@FindBy(css = "input#input-lastname+div")
	private WebElement lastnameWarningMassage;

	@FindBy(css = "input#input-email+div")
	private WebElement emailWarningMassage;

	@FindBy(css = "input#input-telephone+div")
	private WebElement telephoneWarningMassage;

	@FindBy(css = "input#input-password+div")
	private WebElement passwordWarnigMassage;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarnigMassage;
	
	@FindBy(css="input#input-confirm+div")
	private WebElement wrongConfirmPasswordWarningMassage;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirst(String firstname) {
		firstnameTextBox.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastnametextBox.sendKeys(lastname);
	}

	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public String retrieveEmailWarningMassage() {
		String text = duplicateEmailWarnigMassage.getText();
		return text;
	}
 
	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}

	public void enterComfPassword(String confirmPassText) {
		confirmPasswordTextBox.sendKeys(confirmPassText);
	}

	public void subscribeCheckBox() {
		subsribeNewsRadioButton.click();
	}

	public void privatePolice() {
		privatePoliceCheckBox.click();
	}

	public void contiueButtonCheckBox() {
		contiueButton.click();
	}
	public String retrivePrivatePolicyWarningMassage() {
		String text = privacyPolicyWarningMassage.getText();
		return text;
	}
	
	public String retriveFirstnameWarningMassage() {
		String text = firstnameWarningMassage.getText();
		return text;
	}
	
	public String retriveLastnameWarningMassage() {
		String text = lastnameWarningMassage.getText();
		return text;
	}
	
	public String retriveEmailWarningMassage() {
		String text = emailWarningMassage.getText();
		return text;
	}

	public String retriveTelephoneWarningMassage() {
		String text = telephoneWarningMassage.getText();
		return text;
	}
	
	public String retrivePasswordWarningMassage() {
		String text = passwordWarnigMassage.getText();
		return text;
	}
	public String retrivePasswordConfirmWarningMassage() {
		String text = wrongConfirmPasswordWarningMassage.getText();
		return text;
	}
 
	public AccountSuccessPage combiningRegisterWithMandatoryDetails(String firstnameText , String lastnameText , String emailText ,
			String telephoneText ,String passwordText , String confirmPassText ) {
		firstnameTextBox.sendKeys(firstnameText);
		lastnametextBox.sendKeys(lastnameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		confirmPasswordTextBox.sendKeys(confirmPassText);
		
		privatePoliceCheckBox.click();
		contiueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage combiningAllDetailsToNavigateToAccountSuccessPage(String firstnameText , String lastnameText ,
			String emailText ,String telephoneText ,String passwordText , String confirmPassText ) {
		firstnameTextBox.sendKeys(firstnameText);
		lastnametextBox.sendKeys(lastnameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		confirmPasswordTextBox.sendKeys(confirmPassText);
		subsribeNewsRadioButton.click();
		privatePoliceCheckBox.click();
		contiueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public boolean retrieveAllWarningMassagese(String expectedPrivacyPolicyWarning, String expectedFirstNameWarnig, 
			String expectedLastNameWaring, String expectedEmailWarninig, String expectedTelephoneWarning,
			String expectedPasswordWarning ) {
		boolean privacyPolicyWarningStatus = privacyPolicyWarningMassage.getText().contains(expectedPrivacyPolicyWarning);
		boolean firstNameWaringStatus = firstnameWarningMassage.getText().contains(expectedFirstNameWarnig);
		boolean lastNameWarningStatus = lastnameWarningMassage.getText().contains(expectedLastNameWaring);
		boolean emailWarningStatus =  emailWarningMassage.getText().contains(expectedEmailWarninig);
		boolean telephoneWarningStatus = telephoneWarningMassage.getText().contains(expectedTelephoneWarning);
		boolean passwordWaringStatus = passwordWarnigMassage.getText().contains(expectedPasswordWarning);
		return privacyPolicyWarningStatus && firstNameWaringStatus && lastNameWarningStatus && emailWarningStatus 
				&& telephoneWarningStatus && passwordWaringStatus;
		
	}
}
