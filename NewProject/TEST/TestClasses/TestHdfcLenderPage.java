package TestClasses;


import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import POMClasses.HdfcLenderPage;
import POMClasses.HomePage;
import Utility.BaseClass;
import Utility.DataProviders;

public class TestHdfcLenderPage extends BaseClass{
	HomePage home;
	HdfcLenderPage hdfcpage;
	
	@Test(priority = 1,groups = {"sanity"}, dataProvider = "dataBase")
	public void testHdfcform(String name,String pincode,String company) {
	home=new HomePage();
	hdfcpage=home.crditCrad();
	hdfcpage.hdfcForm(name, pincode, company);
	String ActualURL=home.getURL();
	String expected="https://indialends.com/hdfc-bank-credit-card";
	assertEquals(ActualURL, expected);
	System.out.println(ActualURL);
	} 
}
