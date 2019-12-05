package com.edu.auto;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.dataProvider.ExcelDataProvider;
import com.edu.dataProvider.DataHelper;
import com.edu.utils.ReadProperties;

/*1*/

public class LoginTest extends DataHelper{
	public WebDriver driver=null;
	
	@BeforeClass
	public void openPage() throws Exception{
		System.setProperty("webdriver.gecko.driver",ReadProperties.getPropertyValue("gecko_driver"));
		driver = new FirefoxDriver();
		driver.get(ReadProperties.getPropertyValue("page_url"));
	}
	
	@Test(dataProvider="getLoginData",dataProviderClass=DataHelper.class)
	public void TestLogin(String username,String password) throws Exception{
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("baishikele@"));
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.id("wp-admin-bar-my-account"))).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement logOut=driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a"));
		js.executeScript("arguments[0].click();",logOut);
	}
	
}
