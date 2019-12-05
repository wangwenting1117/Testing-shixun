package com.edu.auto;

import java.util.List;

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

/*21*/

public class DiscussionTest extends DataHelper {
	public WebDriver driver = null;

	// 点击到Discussion选项
	@BeforeTest
	public void open() throws Exception {
		System.setProperty("webdriver.gecko.driver", ReadProperties.getPropertyValue("gecko_driver"));
		driver = new FirefoxDriver();
		driver.get(ReadProperties.getPropertyValue("page_url"));
		driver.findElement(By.id("user_login")).sendKeys("baishikele@");
		driver.findElement(By.id("user_pass")).sendKeys("BaiShiKeLe*");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
		driver.findElement(By.linkText("Discussion")).click();
	}

	/****
	 * @throws Exception
	 **********************************************************/
	// 测试Default article settings
	@Test
	public void testArticleSetting1() throws Exception {
		WebElement check = driver.findElement(By.id("default_pingback_flag"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/****
	 * @throws Exception
	 **********************************************************/
	// 测试Default article settings
	@Test
	public void testArticleSetting2() throws Exception {
		WebElement check = driver.findElement(By.id("default_ping_status"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/****
	 * @throws Exception
	 **********************************************************/
	// 测试Default article settings
	@Test
	public void testArticleSetting3() throws Exception {
		WebElement check = driver.findElement(By.id("default_comment_status"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testOther1(String i) {
		WebElement check = driver.findElement(By.id("close_comments_for_old_posts"));
		while (check.isSelected() == false) {
			check.click();
		}
		driver.findElement(By.name("close_comments_days_old")).clear();
		driver.findElement(By.name("close_comments_days_old")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.name("close_comments_days_old")).getText();
		Assert.assertEquals(text, i);
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testOther2(String i) {
		WebElement check = driver.findElement(By.id("thread_comments"));
		while (check.isSelected() == false) {
			check.click();
		}
		WebElement list = driver.findElement(By.id("thread_comments_depth"));
		Select select = new Select(list);
		select.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testOther3(String i) {
		WebElement check = driver.findElement(By.id("page_comments"));
		while (check.isSelected() == false) {
			check.click();
		}
		driver.findElement(By.id("comments_per_page")).clear();
		driver.findElement(By.id("comments_per_page")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.name("comments_per_page")).getText();
		Assert.assertEquals(text, i);
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testOther4(String i) {
		WebElement check = driver.findElement(By.id("page_comments"));
		while (check.isSelected() == false) {
			check.click();
		}
		WebElement list = driver.findElement(By.id("default_comments_page"));
		Select lSelect = new Select(list);
		lSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testOther5(String i) {
		WebElement list = driver.findElement(By.id("comment_order"));
		Select lSelect = new Select(list);
		lSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test
	public void testOther6() {
		WebElement check = driver.findElement(By.id("require_name_email"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test
	public void testOther7() {
		WebElement check = driver.findElement(By.id("comment_registration"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test
	public void testOther8() {
		WebElement check = driver.findElement(By.id("show_comments_cookies_opt_in"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Email me whenever
	@Test
	public void testEmailMe1() {
		WebElement check = driver.findElement(By.id("comments_notify"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Email me whenever
	@Test
	public void testEmailMe2() {
		WebElement check = driver.findElement(By.id("moderation_notify"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Before a comment appears
	@Test
	public void testAppears1() {
		WebElement check = driver.findElement(By.id("comment_moderation"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Before a comment appears
	@Test
	public void testAppears2() {
		WebElement check = driver.findElement(By.id("comment_whitelist"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Comment Moderation
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testModeration1(String i) {
		WebElement list = driver.findElement(By.id("comment_max_links"));
		Select select = new Select(list);
		select.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Comment Moderation
	@Test(dataProvider = "getText", dataProviderClass = DataHelper.class)
	public void testModeration2(String text) {
		driver.findElement(By.id("moderation_keys")).clear();
		driver.findElement(By.id("moderation_keys")).sendKeys(text);
		driver.findElement(By.id("submit")).click();
		String actual = driver.findElement(By.id("moderation_keys")).getAttribute("value");
		Assert.assertEquals(actual, text);
	}

	/***********************************************************************************************/
	// 测试Comment Blacklist
	@Test(dataProvider = "getText", dataProviderClass = DataHelper.class)
	public void testBlacklist(String text) {
		driver.findElement(By.id("blacklist_keys")).clear();
		driver.findElement(By.id("blacklist_keys")).sendKeys(text);
		driver.findElement(By.id("submit")).click();
		String actual = driver.findElement(By.id("blacklist_keys")).getAttribute("value");
		Assert.assertEquals(actual, text);
	}

	/***********************************************************************************************/
	// 测试Avatar Display
	@Test
	public void testAvatarDisplay() {
		WebElement check = driver.findElement(By.id("show_avatars"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***
	 * @throws Exception
	 *********************************************************************************************/
	// 测试Maximum Rating
	@Test
	public void testRating() throws Exception {
		List<WebElement> list = driver.findElements(By.name("avatar_rating"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			Thread.sleep(3000);
			list = driver.findElements(By.name("avatar_rating"));
			while (list.get(i).isSelected() == false) {
				list.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}

	/***
	 * @throws Exception
	 **************************************************************************************/
	// 测试Default Avatar
	@Test
	public void testAvatar() throws Exception {
		List<WebElement> list = driver.findElements(By.name("avatar_default"));
		List<WebElement> img = driver.findElements(By.className("avatar avatar-32 photo avatar-default"));
		System.out.println(list.size());
		System.out.println(img.size());
		for (int j = 0; j < list.size(); j++) {
			Thread.sleep(3000);
			list = driver.findElements(By.name("avatar_default"));
			while (list.get(j).isSelected() == false) {
				list.get(j).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}
}