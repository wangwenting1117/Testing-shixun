package com.edu.auto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.edu.dataProvider.DataHelper;
import com.edu.utils.ReadProperties;

/*2*/

public class WritingTest extends DataHelper{
	public WebDriver driver=null;
	
	//点击到Writing选项
	@BeforeTest
	public void open() throws Exception{
		System.setProperty("webdriver.gecko.driver", ReadProperties.getPropertyValue("gecko_driver"));
		driver = new FirefoxDriver();
		driver.get(ReadProperties.getPropertyValue("page_url"));
		driver.findElement(By.id("user_login")).sendKeys("baishikele@");
		driver.findElement(By.id("user_pass")).sendKeys("BaiShiKeLe*");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
		driver.findElement(By.linkText("Writing")).click();
	}
	
	/*********************************************************************************************************************/
	//测试Default Post Category
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testCategory(String i){
		WebElement category=driver.findElement(By.id("default_category"));
		Select cate=new Select(category);
		cate.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	
	/*********************************************************************************************************************/
	//测试Default Post Format
	@Test
	public void testFormat(String i){
		WebElement format = driver.findElement(By.id("default_post_format"));
		Select fSelect=new Select(format);
		fSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	
}
