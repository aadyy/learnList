package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.mongodb.diagnostics.logging.Logger;

public class BaseClass {
			
		public static WebDriver driver;
		public static Properties prop;
		public static Logger logger;
		
			
		public BaseClass() {
				
			try {
				FileInputStream fis = new FileInputStream("C:\\Users\\Adityayadav\\eclipse-workspace\\NewProject\\Utilities\\Utility\\config.properties");
				prop = new Properties();
				prop.load(fis);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//@Parameters("browser")
		@BeforeMethod(groups = {"sanity","smoke","regression"})
		public void IntilizeBrowser() {
		String browser = prop.getProperty("browser");
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		    	driver=new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
				driver=new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		
		public static String loadPropertiesFile(String FileName, String Key) {
			String URL_Value = "";
			File file = new File(System.getProperty("user.dir")+"Adityayadav\\eclipse-workspace\\NewProject\\Utilities\\Utility"+ FileName);
			try {
				FileInputStream fis = new FileInputStream(file);
				prop.load(fis);
				URL_Value = prop.getProperty(Key);
			} catch (Exception e) {
				System.out.println("Exception message is " + e.getMessage());
			}
			return URL_Value;
		}

		 public static String randomMobile() {
	
				String numStart = "5354";
		        String numRemainder;
		        String numComplete;
		        String sd5, sd6, sd7, sd8, sd9, sd10;
		 
		        Random rand = new Random();
		        int d5 = rand.nextInt(10);
		        int d6 = rand.nextInt(10);
		        int d7 = rand.nextInt(10);
		        int d8 = rand.nextInt(10);
		        int d9 = rand.nextInt(10);
		        int d10 = rand.nextInt(10);
		 
		        sd5 = Integer.toString(d5);
		        sd6 = Integer.toString(d6);
		        sd7 = Integer.toString(d7);
		        sd8 = Integer.toString(d8);
		        sd9 = Integer.toString(d9);
		        sd10 = Integer.toString(d10);
		 
		        numRemainder= ""+sd5+""+sd6+""+sd7+""+sd8+""+sd9+""+sd10+"";
		        numComplete = ""+numStart+""+numRemainder+"";
		        return numComplete;
		    }

		    public static String randomEmail() {
		        return "random_" +/* UUID.randomUUID().toString() +*/ gen()+ "@gmail.com";
		    }
		    public static String randommPAN() {
		        return "XVBPA" +/* UUID.randomUUID().toString() +*/ gen()+ "G";
		    }
		    private static int gen() {
		    	Random r = new Random( System.currentTimeMillis() );
		        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		    }
		    
		    @DataProvider(name="dataBase")
		    public Object[][] getdata() {
		    	
		    	Object[][] obj=new Object[1][3];
		    	obj[0][0]="admin";
		    	obj[0][1]="248001";
		    	obj[0][2]="Indialends";
				
		    	return obj;
		}
		    
			@AfterMethod(alwaysRun=true)
			public void tearDown() throws InterruptedException {
				Thread.sleep(7000);
			driver.close();
			}
			
			
}


