package com.edu.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.edu.dataProvider.DataHelper;
import com.edu.utils.ReadProperties;

/*7*/

public class MediaTest {
	public WebDriver driver = null;

	// 点击到Media选项
	@BeforeTest
	public void open() throws Exception {
		System.setProperty("webdriver.gecko.driver", ReadProperties.getPropertyValue("gecko_driver"));
		driver = new FirefoxDriver();
		driver.get(ReadProperties.getPropertyValue("page_url"));
		driver.findElement(By.id("user_login")).sendKeys("baishikele@");
		driver.findElement(By.id("user_pass")).sendKeys("BaiShiKeLe*");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
		driver.findElement(By.linkText("Media")).click();
	}
	
	/*********************************************************************************************************************/
	//测试Thumbnail size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testThumbnailSize1(String i){
		WebElement num1 = driver.findElement(By.id("thumbnail_size_w"));
		WebElement check = driver.findElement(By.id("thumbnail_crop"));
		num1.clear();
		num1.sendKeys(i);
		check.click();
		driver.findElement(By.id("submit")).click();
		String text1 = num1.getText();
		Assert.assertEquals(text1, i);
	}
	
	/*********************************************************************************************************************/
	//测试Thumbnail size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testThumbnailSize2(String i){
		WebElement num2 = driver.findElement(By.id("thumbnail_size_h"));
		WebElement check = driver.findElement(By.id("thumbnail_crop"));
		num2.clear();
		num2.sendKeys(i);
		check.click();
		driver.findElement(By.id("submit")).click();
		String text2 = num2.getText();
		Assert.assertEquals(text2, i);
	}
	
	/*********************************************************************************************************************/
	//测试Medium size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testMediumSize1(String i){
		WebElement num = driver.findElement(By.id("medium_size_w"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Medium size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testMediumSize2(String i){
		WebElement num = driver.findElement(By.id("medium_size_h"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Large size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testLargeSize1(String i){
		WebElement num = driver.findElement(By.id("large_size_w"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Large size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testLargeSize2(String i){
		WebElement num = driver.findElement(By.id("large_size_h"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Uploading Files
	@Test
	public void testUpload(){
		WebElement check = driver.findElement(By.id("uploads_use_yearmonth_folders"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
}
