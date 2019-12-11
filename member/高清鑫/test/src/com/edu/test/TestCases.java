package com.edu.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class TestCases extends BaseTest{
	String url = "http://localhost:8081/wp-login.php";
	@Test(description="管理员登录")
	public void adminLogin() {
		//打开页面
		webtest.open(url);
		//文本框输入
		webtest.typeAndClear("name=log", "admin");
		webtest.typeAndClear("name=pwd", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	
	@Test(description="管理员注册")
	public void adminregister() {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", "admin");
		webtest.typeAndClear("name=email", "admin@qq.com");
		webtest.typeAndClear("name=first_name", "admin");
		webtest.typeAndClear("name=last_name", "admin");
		webtest.typeAndClear("name=url", "admin");

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		  
		webtest.typeAndClear("id=pass1-text", "123456");
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='administrator']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	} 
	
	@Test(description="投稿者注册")
	public void writerregister() {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", "admin1");
		webtest.typeAndClear("name=email", "admin1@qq.com");
		webtest.typeAndClear("name=first_name", "admin1");
		webtest.typeAndClear("name=last_name", "admin1");
		webtest.typeAndClear("name=url", "admin1");

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", "admin1");
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='contributor']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@Test(description="作者注册")
	public void authorregister() {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", "admin2");
		webtest.typeAndClear("name=email", "admin2@qq.com");
		webtest.typeAndClear("name=first_name", "admin2");
		webtest.typeAndClear("name=last_name", "admin2");
		webtest.typeAndClear("name=url", "admin2");
		
		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", "admin2");
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='author']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@Test(description="编辑注册")
	public void editorregister() {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", "admin3");
		webtest.typeAndClear("name=email", "admin3@qq.com");
		webtest.typeAndClear("name=first_name", "admin3");
		webtest.typeAndClear("name=last_name", "admin3");
		webtest.typeAndClear("name=url", "admin3");

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", "admin3");
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='editor']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@Test(description="订阅者注册")
	public void readerregister() {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", "admin4");
		webtest.typeAndClear("name=email", "admin4@qq.com");
		webtest.typeAndClear("name=first_name", "admin4");
		webtest.typeAndClear("name=last_name", "admin4");
		webtest.typeAndClear("name=url", "admin4");

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", "admin4");
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='subscriber']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@DataProvider(name="register")
	public Object [][] register() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet1");
		return object;
	}
	@Test(description="数据驱动实现角色为管理员的注册",dataProvider="register")
	/*
	 * 第一行数据不被读取，为各项的名称
	 * 第二行数据为使用注册过的用户名以及注册过的邮箱注册
	 * 第三行数据为未注册的用户名以及注册过的邮箱
	 * 第四行数据为使用注册过的用户名及未注册过的邮箱注册
	 * 第五行数据为使用未注册过的用户名及邮箱注册
	 * 第六行数据为使用空的用户名以及未注册过的邮箱注册
	 * 第七行数据为使用未注册过的用户名以及空的邮箱注册
	 * 第八行数据为使用空的用户名及邮箱注册
	 */
	public void register(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", user_login);
		webtest.typeAndClear("name=email", email);
		webtest.typeAndClear("name=first_name", first_name);
		webtest.typeAndClear("name=last_name", last_name);
		webtest.typeAndClear("name=url", url);
		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", pass1);
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='administrator']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@DataProvider(name="register1")
	public Object [][] regiater1() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet2");
		return object;
	}
	@Test(description="数据驱动实现角色为投稿者的注册",dataProvider="register1")
	/*
	 * 第一行数据不被读取，为各项的名称
	 * 第二行数据为使用注册过的用户名以及注册过的邮箱注册
	 * 第三行数据为未注册的用户名以及注册过的邮箱
	 * 第四行数据为使用注册过的用户名及未注册过的邮箱注册
	 * 第五行数据为使用未注册过的用户名及邮箱注册
	 * 第六行数据为使用空的用户名以及未注册过的邮箱注册
	 * 第七行数据为使用未注册过的用户名以及空的邮箱注册
	 * 第八行数据为使用空的用户名及邮箱注册
	 */
	public void register1(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", user_login);
		webtest.typeAndClear("name=email", email);
		webtest.typeAndClear("name=first_name", first_name);
		webtest.typeAndClear("name=last_name", last_name);
		webtest.typeAndClear("name=url", url);

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", pass1);
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='contributor']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@DataProvider(name="register2")
	public Object [][] register2() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet3");
		return object;
	}
	@Test(description="数据驱动实现角色为作者的注册",dataProvider="register2")
	/*
	 * 第一行数据不被读取，为各项的名称
	 * 第二行数据为使用注册过的用户名以及注册过的邮箱注册
	 * 第三行数据为未注册的用户名以及注册过的邮箱
	 * 第四行数据为使用注册过的用户名及未注册过的邮箱注册
	 * 第五行数据为使用未注册过的用户名及邮箱注册
	 * 第六行数据为使用空的用户名以及未注册过的邮箱注册
	 * 第七行数据为使用未注册过的用户名以及空的邮箱注册
	 * 第八行数据为使用空的用户名及邮箱注册
	 */
	public void register2(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", user_login);
		webtest.typeAndClear("name=email", email);
		webtest.typeAndClear("name=first_name", first_name);
		webtest.typeAndClear("name=last_name", last_name);
		webtest.typeAndClear("name=url", url);

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", pass1);
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='author']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@DataProvider(name="register3")
	public Object [][] register3() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet4");
		return object;
	}
	@Test(description="数据驱动实现角色为编辑的注册",dataProvider="register3")
	/*
	 * 第一行数据不被读取，为各项的名称
	 * 第二行数据为使用注册过的用户名以及注册过的邮箱注册
	 * 第三行数据为未注册的用户名以及注册过的邮箱
	 * 第四行数据为使用注册过的用户名及未注册过的邮箱注册
	 * 第五行数据为使用未注册过的用户名及邮箱注册
	 * 第六行数据为使用空的用户名以及未注册过的邮箱注册
	 * 第七行数据为使用未注册过的用户名以及空的邮箱注册
	 * 第八行数据为使用空的用户名及邮箱注册
	 */
	public void register3(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", user_login);
		webtest.typeAndClear("name=email", email);
		webtest.typeAndClear("name=first_name", first_name);
		webtest.typeAndClear("name=last_name", last_name);
		webtest.typeAndClear("name=url", url);

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", pass1);
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='editor']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	@DataProvider(name="register4")
	public Object [][] register4() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet5");
		return object;
	}
	@Test(description="数据驱动实现角色为订阅者的注册",dataProvider="register4")
	/*
	 * 第一行数据不被读取，为各项的名称
	 * 第二行数据为使用注册过的用户名以及注册过的邮箱注册
	 * 第三行数据为未注册的用户名以及注册过的邮箱
	 * 第四行数据为使用注册过的用户名及未注册过的邮箱注册
	 * 第五行数据为使用未注册过的用户名及邮箱注册
	 * 第六行数据为使用空的用户名以及未注册过的邮箱注册
	 * 第七行数据为使用未注册过的用户名以及空的邮箱注册
	 * 第八行数据为使用空的用户名及邮箱注册
	 */
	public void register4(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//实现登录
		adminLogin();
		//进入用户模块
		webtest.click("id=menu-users");
		webtest.click("class=page-title-action");
		webtest.typeAndClear("name=user_login", user_login);
		webtest.typeAndClear("name=email", email);
		webtest.typeAndClear("name=first_name", first_name);
		webtest.typeAndClear("name=last_name", last_name);
		webtest.typeAndClear("name=url", url);

		webtest.click("xpath=//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
		webtest.typeAndClear("id=pass1-text", pass1);
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("id=role");
		webtest.click("xpath=//option[@value='subscriber']");
		webtest.click("xpath=//input[@type='submit']");
		
		assertTrue(webtest.isTextPresent("新用户已创建"));
	}
	
	
	@Test(description="投稿者登录")
	public void writerLogin() {
		//打开页面
		webtest.open(url);
		//文本框输入
		webtest.type("name=log", "admin1");
		webtest.type("name=pwd", "admin1");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	}
	
	@Test(description="作者登录")
	public void authorLogin() {
		//打开页面
		webtest.open(url);
		//文本框输入
		webtest.type("name=log", "admin2");
		webtest.type("name=pwd", "admin2");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	
	@Test(description="编辑登录")
	public void editorLogin() {
		//打开页面
		webtest.open(url);
		//文本框输入
		webtest.type("name=log", "admin3");
		webtest.type("name=pwd", "admin3");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	
	@Test(description="订阅者登录")
	public void readerLogin() {
		//打开页面
		webtest.open(url);
		//文本框输入
		webtest.type("name=log", "admin4");
		webtest.type("name=pwd", "admin4");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
	} 
	
	@DataProvider(name="login")
	public Object [][] loginname() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] objects = excelDataProvider.getTestDataByExcel("E:\\aaathird\\login1.xlsx","Sheet2");
		return objects;
	}
	@Test(description="数据驱动实现登录",dataProvider="login")
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
		webtest.open(url);
		//文本框输入
		webtest.typeAndClear("name=log", name);
		webtest.typeAndClear("name=pwd", psd);
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));	
	}
	@DataProvider(name="upload")
	public Object [][] upload() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] objects = excelDataProvider.getTestDataByExcel("E:\\aaathird\\login1.xlsx","Sheet3");
		return objects;
	}
	@Test(description="上传图片",dataProvider="upload")
	/*
	 * 表格中第一行不被读取，故第二行数据才开始执行
	 * 第二行数据是不超过100M的音频，以mp3结尾
	 * 第三行数据是不超过100M的音频，以mp3结尾
	 * 第四行数据是不超过100M的音频，以mp3结尾
	 * 第五行数据是不超过100M的压缩包，以zip结尾
	 * 第六行数据是10M多的视频，以mov结尾
	 * 第七行数据是80M多的视频，以mov结尾
	 * 第八行数据是10M多的视频，以mp4结尾
	 * 第九行数据是不超过100M的音频，以flac结尾
	 * 第十行数据是不超过100M的动图，以gif结尾
	 * 第十一行数据是不超过100M的图片，以jpg结尾
	 * 第十二行数据是不超过100M的图片，以jpg结尾
	 * 第十三行数据是不超过100M的图片，以png结尾
	 * 第十四行数据是不超过100M的文档，以txt结尾
	 * 第十五行数据是不超过100M的文档，以jmx结尾
	 * 第十六行数据是不超过100M的文档，以md结尾
	 * 第十七行数据是不超过100M的文件，以war结尾
	 * 第十八行数据是exe文件
	 */
	private void up(String str) {
		adminLogin();
		webtest.click("id=menu-media");
		webtest.click("class=page-title-action");
		webtest.click("link=标准浏览器上传工具");
		webtest.typeAndClear("xpath=//*[@id=\"async-upload\"]",str);
		webtest.click("xpath=//*[@id=\"html-upload\"]");
		assertFalse(webtest.isTextPresent("登出"));
	}
}
