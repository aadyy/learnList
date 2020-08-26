package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionClass extends BaseClass{
		
	public void hower(WebElement ele) {
	new Actions(driver).moveToElement(ele).build().perform();
	}
	public void rightCick(WebElement ele) {
	new Actions(driver).contextClick(ele).build().perform();
	}
	public void clickandHold(WebElement source,WebElement target) {
	new Actions(driver).clickAndHold(source).moveToElement(target).release().perform();
	}
	public void type(WebElement ele,String text){
	ele.sendKeys(text);	
	}
	public void takeScreenshot(String filename) {
	String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot screen=(TakesScreenshot) driver;
	File source=screen.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + date + ".png";
	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public void selectClass(WebElement ele,String value) {
	Select sc=new Select(ele);
	sc.selectByValue(value);
	}
	
	public void scrollTill(WebElement tillEle) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollIntoView();",tillEle);
	}
}
