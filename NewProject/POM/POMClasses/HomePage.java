package POMClasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ActionClass;
import Utility.BaseClass;

public class HomePage extends BaseClass {
	
	ActionClass action=new ActionClass();
	
	public HomePage() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Gold Loan') and @class=\"nav-link\"]")
	WebElement ele;
	@FindBy(id = "credit-card-dropdown")
	WebElement creditcard;
	@FindBy(xpath = "//a[@class=\"dropdown-item\" and contains(text(),'HDFC Bank Credit Card')]")
	WebElement hdfc;
		
	public void count() {
	List<WebElement> list=driver.findElements(By.xpath("//li[@class=\"nav-item dropdown\"]"));	
	for (WebElement webElement : list) {
		String val=webElement.getText();
		System.out.println(val);
	}
	
	}
	
	public String getTitle() {
	return driver.getTitle();
	}
	public String getURL() {
	return driver.getCurrentUrl();
	}
	
	public HdfcLenderPage crditCrad() {
	action.hower(creditcard);
	hdfc.click();
	return new HdfcLenderPage();
	}
}
