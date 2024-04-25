package tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.ProductPage;
import tutorialsNinja.TestBase.TestBase;

public class SearchProduct extends TestBase {

	public SearchProduct() throws Exception {
		super();

	}

	public WebDriver driver;
	public HomePage homepage;
	public ProductPage productpage;

	@BeforeMethod
	public void LoginSetUp() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		
	}

	@Test(priority = 1)
	public void verifySearchValidProduct() {
		homepage = new HomePage(driver);
		/*
		homepage.enterProductName(dataProp.getProperty("validProduct"));
		productpage=homepage.clickOnSearchButton();
		productpage = new ProductPage(driver);
		*/
		productpage=homepage.navigateToProductPage(dataProp.getProperty("validProduct"));
		Assert.assertTrue(productpage.verifyValidProduct());
		
	}

	@Test(priority = 2)
	public void verifySearchInvalidProduct() {
		homepage = new HomePage(driver);
		/*
		homepage.enterProductName(dataProp.getProperty("invalidProduct"));
		homepage.clickOnSearchButton();
		productpage = new ProductPage(driver);
		*/
		productpage=homepage.navigateToProductPage(dataProp.getProperty("invalidProduct"));
		Assert.assertTrue(productpage.verifyinValidProductWarningMassageDisplay());
		
		
	}

	@Test(priority = 3)
	public void verifySearchNoProduct() {
		homepage = new HomePage(driver);
		/*
		homepage.clickOnSearchButton();
		productpage = new ProductPage(driver);
		*/
		productpage=homepage.clickOnSearchButton();
		Assert.assertTrue(productpage.verifyinValidProductWarningMassageDisplay());
		
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
