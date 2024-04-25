package tutorialsNinja.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tutorialsNinja.Utilities.Util;

public class TestBase {

	 public WebDriver driver;
	 public ChromeOptions options;
	 public Properties prop ;
	 public FileInputStream ip ;
	 public Properties dataProp;
	
	 
	public TestBase() throws Exception {
		prop = new Properties();
	    ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\tutoriaNinja\\Comfig\\Config.properties" );
	    prop.load(ip);
	    dataProp = new Properties();
	    ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\tutorialsNinja\\TestData\\tsetData.properties");
	    dataProp.load(ip);
	}
	
	public WebDriver initalizeBrowserAndOpenApplication(String browserName) {
		if(browserName.equals("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation","dissable-infobars"));
		    driver = new ChromeDriver(options); 
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
	}
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT));
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGELOAD_TIME));
	   driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
	   driver.get(prop.getProperty("url"));
	   return driver;
	   
	}
}
