package POMClasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Utility.ActionClass;
import Utility.BaseClass;

public class HdfcLenderPage extends BaseClass{
	ActionClass action=new ActionClass();
	public HdfcLenderPage() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "li_first_name")
	WebElement elename;
	@FindBy(id = "li_res_pin")
	WebElement elepincode;			
	@FindBy(id = "li_emp_type")
	WebElement eleemptype;
	@FindBy(id ="li_company_name")
	WebElement elecmpnyName;
	@FindBy(xpath ="//p[contains(text(),'Do you file ITR?')]")
	WebElement doUFill;	
	@FindBy(id = "li_submit")
	WebElement button;
	
	@DataProvider(name= "dataBase")
	public void hdfcForm(String name,String pincode,String company ){
	action.type(elename, name);
	action.type(elepincode, pincode);
	action.selectClass(eleemptype,"6");
	action.type(elecmpnyName, company);
	
			
	boolean isdisplay=doUFill.isDisplayed();
	if (isdisplay) {
		System.out.println("user is Self-EMP");
	}
	
	List<WebElement> listItr=driver.findElements(By.xpath("//input[@name=\"is_itr\" and@type=\"radio\"]"));
	for (int i = 0; i < listItr.size(); i++) {
		WebElement localval=listItr.get(i);
		String val=localval.getAttribute("value");
		System.out.println("value is -- "+ val);
		if (val.equalsIgnoreCase("0")) {
			localval.click();
			System.out.println("itr selected is = "+ val);
		}
	}
	
	List<WebElement> card=driver.findElements(By.xpath("//select[@id=\"card_type\"]//option"));
	for (int i = 0; i < card.size(); i++) {
		WebElement internal=card.get(i);
		String printcardtext=internal.getText();
		String printCardsvalue=internal.getAttribute("value");
		System.out.println("cards are ="+ printcardtext);
	}
	System.out.println("number of card"+card.size());
	}
}