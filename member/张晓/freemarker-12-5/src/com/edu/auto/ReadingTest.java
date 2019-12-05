package com.edu.auto;

import java.sql.Driver;
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

/*5*/

public class ReadingTest extends DataHelper{
	public WebDriver driver =null;
	
	@BeforeTest
	public void open() throws Exception {
		System.setProperty("webdriver.gecko.driver", ReadProperties.getPropertyValue("gecko_driver"));
		driver = new FirefoxDriver();
		driver.get(ReadProperties.getPropertyValue("page_url"));
		driver.findElement(By.id("user_login")).sendKeys("baishikele@");
		driver.findElement(By.id("user_pass")).sendKeys("BaiShiKeLe*");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
		driver.findElement(By.linkText("Reading")).click();
	}
	
	/*** @throws Exception **************************************************************************/
	//测试Your homepage displays
	@Test
	public void testHomepage() throws Exception{
		List<WebElement> radios=driver.findElements(By.name("show_on_front"));
		System.out.println(radios.size());
		for(int i=0;i<radios.size();i++){
			Thread.sleep(3000);
			radios=driver.findElements(By.name("show_on_front"));
			while(radios.get(i).isSelected()==false){
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}
	
	/****************************************************************************************************************/
	//测试Blog pages show at most---手动输入
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testPageShow(String i){
		driver.findElement(By.id("posts_per_page")).clear();
		driver.findElement(By.id("posts_per_page")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	
	/****************************************************************************************************************/
	//测试Syndication feeds show the most recent
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testSyndication(String i){
		driver.findElement(By.id("posts_per_rss")).clear();
		driver.findElement(By.id("posts_per_rss")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	
	/*** @throws Exception **************************************************************************************/
	//测试For each article in a feed, show
	@Test
	public void testArticle() throws Exception{
		List<WebElement> radios=driver.findElements(By.name("rss_use_excerpt"));
		System.out.println(radios.size());
		for(int i=0;i<radios.size();i++){
			Thread.sleep(3000);
			radios=driver.findElements(By.name("rss_use_excerpt"));
			while(radios.get(i).isSelected()==false){
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}
	
	/***********************************************************************************************************/
	//测试Search Engine Visibility
	@Test
	public void testEngine(){
		driver.findElement(By.id("blog_public")).click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
}
