package tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.AccountPage;
import tutorialsNinja.Pages.AccountSuccessPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.RegisterPage;
import tutorialsNinja.TestBase.TestBase;
import tutorialsNinja.TestData.ExcelCode;
import tutorialsNinja.Utilities.Util;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountPage accountpage;
	public AccountSuccessPage accountsuccesspage;

	@BeforeMethod
	public void setup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		registerpage = homepage.combiningTwoActionsToNavigateToRegisterPage();
		

	}

	@Test(priority = 1, dataProvider = "TNRegister", dataProviderClass = ExcelCode.class)
	public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone,
			String passwordR, String confirmPasswordR) throws Exception {
		Thread.sleep(6000);
		
		RegisterPage registerpage = new RegisterPage(driver);
		accountsuccesspage = registerpage.combiningRegisterWithMandatoryDetails(firstname, lastname, Util.emailDateTimeStamp(),
				telephone, passwordR, confirmPasswordR);
	    Assert.assertTrue(accountsuccesspage.successPage());
		
	  /*or
	    registerpage.enterFirst(firstname);
		registerpage.enterLastName(lastname);
		registerpage.enterEmail(Util.emailDateTimeStamp());
		registerpage.enterTelephone(telephone);
		registerpage.enterPassword(passwordR);
		registerpage.enterComfPassword(confirmPasswordR);
		registerpage.subscribeCheckBox();
		registerpage.privatePolice();
		registerpage.contiueButtonCheckBox();
		accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.successPage());
        */
	}

	@Test(priority = 2)
	public void verifyRegisterWithAllDetails() {
		
		accountsuccesspage = registerpage.combiningRegisterWithMandatoryDetails(dataProp.getProperty("firstName"), 
				dataProp.getProperty("lastName"), Util.emailDateTimeStamp(),dataProp.getProperty("telephone"), 
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountsuccesspage.successPage());
		/*
		
		registerpage.enterFirst(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Util.emailDateTimeStamp());
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterComfPassword(prop.getProperty("validPassword"));
		
		registerpage.subscribeCheckBox();
		registerpage.privatePolice();
		registerpage.contiueButtonCheckBox();
		accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.successPage());*/
	}

	@Test(priority = 3)
	public void verifyRegisterWithExistingEmail() {
		
		registerpage.combiningRegisterWithMandatoryDetails(dataProp.getProperty("firstName"), 
				dataProp.getProperty("lastName"), prop.getProperty("validEmail"),dataProp.getProperty("telephone"), 
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(registerpage.retrieveEmailWarningMassage().contains(registerpage.retrieveEmailWarningMassage()));
		/*
		
		registerpage.enterFirst(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmail(prop.getProperty("validEmail"));
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterComfPassword(prop.getProperty("validPassword"));
		registerpage.subscribeCheckBox();
		registerpage.privatePolice();
		registerpage.contiueButtonCheckBox();
		String actualExistingEmailWarningMessage= registerpage.retrieveEmailWarningMassage();
		String expectedExistingEmailWarningMessage = dataProp.getProperty("existingEmailWarning");
		Assert.assertTrue(actualExistingEmailWarningMessage.contains(expectedExistingEmailWarningMessage));
        */
	}

	@Test(priority = 4)
	public void verifyRegisterWithWrongConfirmPassword() {
		
		registerpage.combiningRegisterWithMandatoryDetails(dataProp.getProperty("firstName"), 
				dataProp.getProperty("lastName"), Util.emailDateTimeStamp(),dataProp.getProperty("telephone"), 
				prop.getProperty("validPassword"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(registerpage.retrivePasswordConfirmWarningMassage().contains(dataProp.getProperty("wrongconfirmPasswordWarning")));
		/*
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirst(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Util.emailDateTimeStamp());
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterComfPassword(dataProp.getProperty("invalidPassword"));
		registerpage.subscribeCheckBox();
		registerpage.privatePolice();
		registerpage.contiueButtonCheckBox();
		
		String actualWrongConfirmEmailWarningMessage= registerpage.retrivePasswordConfirmWarningMassage();
		String expectedWrongConfirmEmailWarningMessage = dataProp.getProperty("wrongconfirmPasswordWarning");
		Assert.assertTrue(actualWrongConfirmEmailWarningMessage.contains(expectedWrongConfirmEmailWarningMessage));
        */
	}

	@Test(priority = 5)
	public void verifyRegisterWithNoDetails() {
		
		registerpage.contiueButtonCheckBox();
		
		Assert.assertTrue(registerpage.retrieveAllWarningMassagese(
				dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), 
				dataProp.getProperty("invalidEmailWarning"),dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")));
		/*
		Assert.assertEquals(registerpage.retrivePrivatePolicyWarningMassage(), dataProp.getProperty("privacyPolicyWarning"));
		Assert.assertTrue(registerpage.retriveFirstnameWarningMassage().contains(dataProp.getProperty("firstNameWarning")));
		Assert.assertTrue(registerpage.retriveFirstnameWarningMassage().contains(dataProp.getProperty("lastNameWarning")));
		Assert.assertTrue(registerpage.retriveEmailWarningMassage().contains(dataProp.getProperty("invalidEmailWarning")));
		Assert.assertTrue(registerpage.retriveTelephoneWarningMassage().contains(dataProp.getProperty("telephoneWarning")));
		Assert.assertTrue(registerpage.retrivePasswordConfirmWarningMassage().contains(dataProp.getProperty("passwordWarning")));
		/*
		String actualPrivacyPolicyWarningMessage = registerpage.retrivePrivatePolicyWarningMassage();
		String expectedPrivacyPolicyWarningMessage = dataProp.getProperty("privacyPolicyWarning");
		Assert.assertEquals(actualPrivacyPolicyWarningMessage, expectedPrivacyPolicyWarningMessage);
		
		String actualFirstNameWarningMessage = registerpage.retriveFirstnameWarningMassage();
		String expectedFirstNameWarningMessage = dataProp.getProperty("firstNameWarning");
		Assert.assertTrue(actualFirstNameWarningMessage.contains(expectedFirstNameWarningMessage));
        
		String actualLastNameWarningMessage = registerpage.retriveFirstnameWarningMassage();
		String expectedLastNameWarningMessage = dataProp.getProperty("lastNameWarning");
		Assert.assertTrue(actualLastNameWarningMessage.contains(expectedLastNameWarningMessage));
         
		String actualEmailWarningMessage = registerpage.retriveEmailWarningMassage();
		String expectedEmailWarningMessage = dataProp.getProperty("invalidEmailWarning");
		Assert.assertTrue(actualEmailWarningMessage.contains(expectedEmailWarningMessage));
         
		String actualTelephoneWarningMessage = registerpage.retriveTelephoneWarningMassage();
		String expectedTelephoneWarningMessage = dataProp.getProperty("telephoneWarning");
		Assert.assertTrue(actualTelephoneWarningMessage.contains(expectedTelephoneWarningMessage));
         
		String actualPasswordWarningMessage = registerpage.retrivePasswordConfirmWarningMassage();
		String expectedPasswordWarningMessage = dataProp.getProperty("passwordWarning");
		Assert.assertTrue(actualPasswordWarningMessage.contains(expectedPasswordWarningMessage));
		*/
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
