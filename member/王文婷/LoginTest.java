package com.edu.test;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.core.util.Assert;
import org.apache.poi.poifs.storage.BATBlock.BATBlockAndIndex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	@Test
	public void test1() throws InterruptedException{
		webtest.open("http://localhost:8081/wordpress/wp-login.php");
		webtest.type("name=log","baishikele@");
		webtest.type("name=pwd","BaiShiKeLe*");
		webtest.click("name=wp-submit");
//		webtest.click("class=wp-menu-name");
		webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[9]/a/div[3]");
		//webtest.click("class=wp-first-item current");
		webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[9]/ul/li[2]/a");
		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form[2]/table/tbody/tr[3]/td[1]/div/span[1]/a");
		webtest.mouseoverElement("xpath=/html/body/div/div[2]/div[1]/div/ul[2]/li/a/img");
//		webtest.click("/html/body/div/div[2]/div[1]/div/ul[2]/li/div/ul/li[3]/a");
		webtest.click("class=ab-item");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("Plugin activated."));
	}
	
	
/*	@Test
	public void test2() throws InterruptedException{
		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form[2]/table/tbody/tr[3]/td[1]/div/span[1]/a");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("Plugin deactivated."));
	}
	
	
	@Test
	public void test3() throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/a/div[3]");
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[5]/a");
		webtest.type("name=username_or_email_for_privacy_request","1433837332@qq.com");
		webtest.click("id=cb-select-all-2");
		webtest.click("name=submit");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("Confirmation request initiated successfully."));
	}
	
	
	@Test
	public void test4() throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[2]/a");
		Thread.sleep(3000);
		//assertTrue(webtest.isTextPresent("查看可用工具类"));
	}
	
	
	@Test
	public void test5() throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[4]/a");//导出内容
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[5]/form/fieldset/p[1]/label/input");
		webtest.click("id=submit");
		Thread.sleep(3000);
		//assertTrue(webtest.isTextPresent("查看可用工具类"));
	}
	
	
	@Test
	public void test6(){
		webtest.click("");
	}*/
}
