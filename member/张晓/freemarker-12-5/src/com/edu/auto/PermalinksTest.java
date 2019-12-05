package com.edu.auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.edu.dataProvider.DataHelper;
import com.edu.utils.ReadProperties;

public class PermalinksTest extends DataHelper{
	public WebDriver driver = null;

	// 点击到Permalinks选项
	@BeforeTest
	public void open() throws Exception {
		System.setProperty("webdriver.gecko.driver", ReadProperties.getPropertyValue("gecko_driver"));
		driver = new FirefoxDriver();
		driver.get(ReadProperties.getPropertyValue("page_url"));
		driver.findElement(By.id("user_login")).sendKeys("baishikele@");
		driver.findElement(By.id("user_pass")).sendKeys("BaiShiKeLe*");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
		driver.findElement(By.linkText("Permalinks")).click();
	}

	/**
	 * @throws Exception ********************************************************************************************/
	// 测试Common Settings---非自定义
	@Test
	public void testCommon() throws Exception{
		List<WebElement> list = driver.findElements(By.name("selection"));
		System.out.println(list.size());
		for(int i=0;i<list.size()-1;i++){
			Thread.sleep(3000);
			list = driver.findElements(By.name("selection"));
			while(list.get(i).isSelected()==false){
				list.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Permalink structure updated."));
			}
		}
	}
	
	/********************************************************************************************************/
	//测试Common Settings---非自定义
	@Test(dataProvider="getUrl",dataProviderClass=DataHelper.class)
	public void testUrl(String url){
		WebElement radio = driver.findElement(By.id("custom_selection"));
		while(radio.isSelected()==false){
			radio.click();
		}
		WebElement put = driver.findElement(By.id("permalink_structure"));
		put.clear();
		put.sendKeys(url);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Permalink structure updated."));
	}
	
}
