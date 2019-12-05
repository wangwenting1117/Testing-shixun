package com.edu.auto;

import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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

/*12*/

public class GeneralTest extends DataHelper {
	public WebDriver driver = null;

	// 点击到General选项
	@BeforeTest
	public void open() throws Exception {
		System.setProperty("webdriver.gecko.driver", ReadProperties.getPropertyValue("gecko_driver"));
		driver = new FirefoxDriver();
		driver.get(ReadProperties.getPropertyValue("page_url"));
		driver.findElement(By.id("user_login")).sendKeys("baishikele@");
		driver.findElement(By.id("user_pass")).sendKeys("BaiShiKeLe*");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
		driver.findElement(By.linkText("General")).click();
	}

	/**
	 * @throws Exception
	 *************************************************************************************/
	// 测试Site Title
	@Test(dataProvider = "getSiteTitle", dataProviderClass = DataHelper.class)
	public void testSiteTitle(String blogname) throws Exception {
		driver.findElement(By.id("blogname")).clear();
		driver.findElement(By.id("blogname")).sendKeys(blogname);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.id("blogname")).getAttribute("value");
		System.out.println(text);
		Assert.assertEquals(text, blogname);
	}

	/****************************************************************************************/
	// 测试Tagline
	@Test(dataProvider = "getTagline", dataProviderClass = DataHelper.class)
	public void testTagline(String blogdescription) {
		driver.findElement(By.id("blogdescription")).clear();
		driver.findElement(By.id("blogdescription")).sendKeys(blogdescription);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.id("blogdescription")).getAttribute("value");
		Assert.assertEquals(text, blogdescription);
	}

	/**************************************************************************************/
	// 测试EmailAddress
	@Test(dataProvider = "getEmailAddress", dataProviderClass = DataHelper.class)
	public void testEmailAddress(String new_admin_email) {
		driver.findElement(By.id("new_admin_email")).clear();
		driver.findElement(By.id("new_admin_email")).sendKeys(new_admin_email);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.id("new_admin_email")).getAttribute("value");
		Assert.assertEquals(text, new_admin_email);
	}

	/******************************************************************************************/
	// 测试Membership
	@Test
	public void testMembership() {
		driver.findElement(By.id("users_can_register")).click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/******************************************************************************************/
	// 测试New User Default Role(0-4)
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testNewUserDefaultRole(String i) {
		WebElement role = driver.findElement(By.id("default_role"));
		Select r = new Select(role);
		r.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/**********************************************************************************************/
	// 测试Site Language
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testSiteLanguage(String i) {
		WebElement language = driver.findElement(By.id("WPLANG"));
		Select l = new Select(language);
		l.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/**********************************************************************************************/
	// 测试Timezone
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testTimezone(String i) {
		WebElement zone = driver.findElement(By.id("timezone_string"));
		Select z = new Select(zone);
		z.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/**
	 * @throws Exception
	 *********************************************************************************************/
	// 测试Date Format
	@Test
	public void testDateFormat() throws Exception {
		List<WebElement> radios = driver.findElements(By.name("date_format"));
		System.out.println(radios.size());
		for (int i = 0; i < radios.size() - 1; i++) {
			Thread.sleep(3000);
			radios = driver.findElements(By.name("date_format"));
			while (radios.get(i).isSelected() == false) {
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}

	/****************************************************************************************************************/
	// 测试Date Format中的自定义日期格式
	@Test(dataProvider = "getDate", dataProviderClass = DataHelper.class)
	public void testDateCustom(String date) {
		driver.findElement(By.id("date_format_custom_radio")).click();
		driver.findElement(By.id("date_format_custom")).clear();
		driver.findElement(By.id("date_format_custom")).sendKeys(date);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/********************************************************************************************************************/
	// 测试Time Format
	@Test
	public void testTimeFormat() throws Exception {
		List<WebElement> radios = driver.findElements(By.name("time_format"));
		System.out.println(radios.size());
		for (int i = 0; i < radios.size() - 1; i++) {
			Thread.sleep(3000);
			radios = driver.findElements(By.name("time_format"));
			while (radios.get(i).isSelected() == false) {
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}

	/***************************************************************************************************************/
	// 测试Time Format中的自定义时间格式
	@Test(dataProvider = "getTime", dataProviderClass = DataHelper.class)
	public void testTimeCustom(String time) {
		driver.findElement(By.id("time_format_custom_radio")).click();
		driver.findElement(By.id("time_format_custom")).clear();
		driver.findElement(By.id("time_format_custom")).sendKeys(time);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/*****************************************************************************************************************/
	// 测试Week Starts On
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testWeek(String i) {
		WebElement week = driver.findElement(By.id("start_of_week"));
		Select wSelect = new Select(week);
		wSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
}
