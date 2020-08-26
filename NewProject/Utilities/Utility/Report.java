package Utility;

import org.testng.annotations.AfterSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	
	public static ExtentReports extentreports;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentTest extentTest;
	
	public static void setExtent() {
	htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"ExtentReport/Myreport.html");
	htmlreport.config().setDocumentTitle("AutomationTestReport");
	htmlreport.config().setReportName("Indialends Test Automation Report");
	htmlreport.config().setTheme(Theme.STANDARD);
	extentreports=new ExtentReports();
	extentreports.attachReporter(htmlreport);
	
	extentreports.setSystemInfo("Hostname","MyHost");
	extentreports.setSystemInfo("ProjectName","Indialends");
	extentreports.setSystemInfo("Tester","Aditya yadav");
	extentreports.setSystemInfo("Os","Wind10");
	extentreports.setSystemInfo("Browser","Chrome");
	}
	
	
	@AfterSuite 
	public static void endeport() {
	extentreports.flush();

	}
}
