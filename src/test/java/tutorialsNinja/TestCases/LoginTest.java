package tutorialsNinja.TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.AccountPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.LoginPage;
import tutorialsNinja.TestBase.TestBase;
import tutorialsNinja.TestData.ExcelCode;
import tutorialsNinja.Utilities.Util;

public class LoginTest extends TestBase{
	
	
	public LoginTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	@BeforeMethod
	public void LoginSetUp() {
		driver =  initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		loginpage = homepage.combiningTwoActionsToNavigateToLoginPage();
		
		
	}
	 
	@Test(priority=1, dataProvider= "TNLogin" , dataProviderClass = ExcelCode.class)
	public void verifyLoginWithValidCredentials(String email, String password) {
		
	    accountpage = loginpage.navigateToLoginPageByCombinig3Actions(email, password);
	    Assert.assertTrue(accountpage.validateDisplayStatusOfLogoutLink());
	}

	@Test(priority=2)
	public void verifyLoginWithINValidPassword() {
		
		accountpage = loginpage.navigateToLoginPageByCombinig3Actions(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retrieveLoginMassageText().contains(dataProp.getProperty("LoginWarrnigMassage")));
		/* or
		String actualWarnigMassage = loginpage.retrieveLoginMassageText();
		String expectedWarningMassage = dataProp.getProperty("LoginWarrnigMassage");
		Assert.assertTrue(actualWarnigMassage.contains(expectedWarningMassage));
		*/
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithInValidEmail() {
		
		accountpage = loginpage.navigateToLoginPageByCombinig3Actions(Util.emailDateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginpage.retrieveLoginMassageText().contains(dataProp.getProperty("LoginWarrnigMassage")));
		
		/*or
		loginpage.enterEmail(Util.emailDateTimeStamp());
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLogin();
		String actualWarnigMassage = loginpage.retrieveLoginMassageText();
		String expectedWarningMassage =dataProp.getProperty("LoginWarrnigMassage");
		Assert.assertTrue(actualWarnigMassage.contains(expectedWarningMassage));
		*/
	}
	
	@Test(priority=4)
	public void verifyLoginWithInvalidCredentials() {
		
		accountpage = loginpage.navigateToLoginPageByCombinig3Actions(Util.emailDateTimeStamp(), prop.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retrieveLoginMassageText().contains(dataProp.getProperty("LoginWarrnigMassage")));
		
		/*or
		loginpage.enterEmail(Util.emailDateTimeStamp());
		loginpage.enterPassword(prop.getProperty("invalidPassword"));
		loginpage.clickOnLogin();
		String actualWarnigMassage = loginpage.retrieveLoginMassageText();
		String expectedWarningMassage =dataProp.getProperty("LoginWarrnigMassage");
		Assert.assertTrue(actualWarnigMassage.contains(expectedWarningMassage));
		*/
	}
	
	@Test(priority=5)
	public void verifyLoginWithValidNoCredentials() {
		
		loginpage.clickOnLogin();
		Assert.assertTrue(loginpage.retrieveLoginMassageText().contains(dataProp.getProperty("LoginWarrnigMassage")));
		/*or
		String actualWarnigMassage = loginpage.retrieveLoginMassageText();
		String expectedWarningMassage =dataProp.getProperty("LoginWarrnigMassage");
		Assert.assertTrue(actualWarnigMassage.contains(expectedWarningMassage));
		*/
	}
	
	@AfterMethod
	public void tearDwon() {
		driver.quit();
	}
}
