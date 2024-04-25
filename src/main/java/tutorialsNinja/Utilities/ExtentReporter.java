package tutorialsNinja.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() throws Exception {
		//Step 1 : You have to add the maven dependencies of ExtenReports in pom.xml file
		
		//Step 2 : Create the object of ExtentReports class
		         ExtentReports extentReport = new ExtentReports();
		     
		//Step 3 :  Create the object of File class and pass the path of the .html file in the constructor
		         File extentReportFile = new File(System.getProperty("user.dir") + "\\test-ouput\\ExtentReports\\extentreport.html");
		
		//Step 4 : Create the object of ExtentSparkReporter and pass the reference of the File Class in the constructor
		         ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		         
		//Step 5 : Using this sparkReporter we can configure a lot of things inside The ExtentReport.Html File
		         sparkReporter.config().setTheme(Theme.DARK);
		         sparkReporter.config().setReportName("TN Automation RESULTS");
		         sparkReporter.config().setDocumentTitle("TNReportTitle|Automation|Result|April_2024");
		         sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		         
		//Step 6 : We need to attach the ExtentReport with the SparkReporter
		         extentReport.attachReporter(sparkReporter);
		         
		   Properties prop = new Properties();   
		   FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + 
				   "\\src\\main\\java\\tutoriaNinja\\Comfig\\Config.properties");
		   prop.load(ip);
		   
	   // Application url, browserName, validEmail, validPassword, Operating System, Java Version, name of the SDET	
		   extentReport.setSystemInfo("application url", prop.getProperty("url"));  
		   extentReport.setSystemInfo("browser", prop.getProperty("browser"));
		   extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
		   extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		   extentReport.setSystemInfo("operating system", prop.getProperty("os.version"));
		   extentReport.setSystemInfo("ops version detail", System.getProperty("os.version"));
		   extentReport.setSystemInfo("SDET Name", prop.getProperty("user.name"));
		   extentReport.setSystemInfo("java version", prop.getProperty("java.version"));
		   extentReport.setSystemInfo("java vendor", prop.getProperty("java.vendor"));
		  
		   
		   return extentReport;
		   
	}
	
	
}
