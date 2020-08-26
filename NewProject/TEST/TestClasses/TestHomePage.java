package TestClasses;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import POMClasses.HomePage;
import Utility.BaseClass;

public class TestHomePage extends BaseClass {
	HomePage obj;
	
	@Test(priority = 1, groups = {"smoke"})
	public void testCount() {
	obj=new  HomePage();
	obj.count();
	}
	@Test(priority = 2, groups = {"regression"})
	public void testCreditCard() {
	obj=new  HomePage();
	obj.crditCrad();
	String actual=obj.getTitle();
	String expected="HDFC Bank Credit Cards - Apply online for Best HDFC Cards.";
	assertEquals(actual,expected);
	System.out.println(actual);
	}
	

}
