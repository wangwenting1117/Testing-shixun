package com.edu.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class TestCases extends BaseTest{
	@Test(description="管理员登录")
	public void adminLogin() {
		//打开页面
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//文本框输入
		webtest.type("name=log", "admin");
		webtest.type("name=pwd", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	@Test(description="投稿者登录")
	public void writerLogin() {
		//打开页面
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//文本框输入
		webtest.type("name=log", "admin1");
		webtest.type("name=pwd", "admin1");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	}
	@Test(description="作者登录")
	public void authorLogin() {
		//打开页面
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//文本框输入
		webtest.type("name=log", "admin2");
		webtest.type("name=pwd", "admin2");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	@Test(description="编辑登录")
	public void editorLogin() {
		//打开页面
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//文本框输入
		webtest.type("name=log", "admin3");
		webtest.type("name=pwd", "admin3");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	@Test(description="订阅者登录")
	public void readerLogin() {
		//打开页面
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//文本框输入
		webtest.type("name=log", "admin4");
		webtest.type("name=pwd", "admin4");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	
	@DataProvider(name="login")
	public Object [][] loginname() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] objects = excelDataProvider.getTestDataByExcel("E:\\aaathird\\login.xlsx","sheet1");
		return objects;
	}
	@Test(description="数据驱动",dataProvider="login")
	/*
	 * 表格中第一行不被读取，故第二行数据才开始执行
	 * 第二行数据是角色为投稿者的正确登录
	 * 第三行数据是角色为作者的正确登录
	 * 第四行数据是角色为编辑的正确登录
	 * 第五行数据是角色为订阅者的角色登录
	 * 第六行数据是登录名正确，密码为空的情况
	 * 第七行数据是登录名为空，密码不为空的情况
	 * 第八行数据是登录名密码均为空的情况
	 * 第九行数据是角色为管理员的正确登录
	 * 第十行数据是登录名正确，密码错误的情况
	 * 第十一行数据是登录名为未注册的用户登录
	 */
	public void login(String name,String psd) {
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//文本框输入
		webtest.typeAndClear("name=log", name);
		webtest.typeAndClear("name=pwd", psd);
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));	
	}
	
	
}
