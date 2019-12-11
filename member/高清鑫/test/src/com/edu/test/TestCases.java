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
	@Test(description="����Ա��¼")
	public void adminLogin() {
		//��ҳ��
		webtest.open(url);
		//�ı�������
		webtest.typeAndClear("name=log", "admin");
		webtest.typeAndClear("name=pwd", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	
	@Test(description="����Աע��")
	public void adminregister() {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	} 
	
	@Test(description="Ͷ����ע��")
	public void writerregister() {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@Test(description="����ע��")
	public void authorregister() {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@Test(description="�༭ע��")
	public void editorregister() {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@Test(description="������ע��")
	public void readerregister() {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@DataProvider(name="register")
	public Object [][] register() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet1");
		return object;
	}
	@Test(description="��������ʵ�ֽ�ɫΪ����Ա��ע��",dataProvider="register")
	/*
	 * ��һ�����ݲ�����ȡ��Ϊ���������
	 * �ڶ�������Ϊʹ��ע������û����Լ�ע���������ע��
	 * ����������Ϊδע����û����Լ�ע���������
	 * ����������Ϊʹ��ע������û�����δע���������ע��
	 * ����������Ϊʹ��δע������û���������ע��
	 * ����������Ϊʹ�ÿյ��û����Լ�δע���������ע��
	 * ����������Ϊʹ��δע������û����Լ��յ�����ע��
	 * �ڰ�������Ϊʹ�ÿյ��û���������ע��
	 */
	public void register(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@DataProvider(name="register1")
	public Object [][] regiater1() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet2");
		return object;
	}
	@Test(description="��������ʵ�ֽ�ɫΪͶ���ߵ�ע��",dataProvider="register1")
	/*
	 * ��һ�����ݲ�����ȡ��Ϊ���������
	 * �ڶ�������Ϊʹ��ע������û����Լ�ע���������ע��
	 * ����������Ϊδע����û����Լ�ע���������
	 * ����������Ϊʹ��ע������û�����δע���������ע��
	 * ����������Ϊʹ��δע������û���������ע��
	 * ����������Ϊʹ�ÿյ��û����Լ�δע���������ע��
	 * ����������Ϊʹ��δע������û����Լ��յ�����ע��
	 * �ڰ�������Ϊʹ�ÿյ��û���������ע��
	 */
	public void register1(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@DataProvider(name="register2")
	public Object [][] register2() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet3");
		return object;
	}
	@Test(description="��������ʵ�ֽ�ɫΪ���ߵ�ע��",dataProvider="register2")
	/*
	 * ��һ�����ݲ�����ȡ��Ϊ���������
	 * �ڶ�������Ϊʹ��ע������û����Լ�ע���������ע��
	 * ����������Ϊδע����û����Լ�ע���������
	 * ����������Ϊʹ��ע������û�����δע���������ע��
	 * ����������Ϊʹ��δע������û���������ע��
	 * ����������Ϊʹ�ÿյ��û����Լ�δע���������ע��
	 * ����������Ϊʹ��δע������û����Լ��յ�����ע��
	 * �ڰ�������Ϊʹ�ÿյ��û���������ע��
	 */
	public void register2(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@DataProvider(name="register3")
	public Object [][] register3() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet4");
		return object;
	}
	@Test(description="��������ʵ�ֽ�ɫΪ�༭��ע��",dataProvider="register3")
	/*
	 * ��һ�����ݲ�����ȡ��Ϊ���������
	 * �ڶ�������Ϊʹ��ע������û����Լ�ע���������ע��
	 * ����������Ϊδע����û����Լ�ע���������
	 * ����������Ϊʹ��ע������û�����δע���������ע��
	 * ����������Ϊʹ��δע������û���������ע��
	 * ����������Ϊʹ�ÿյ��û����Լ�δע���������ע��
	 * ����������Ϊʹ��δע������û����Լ��յ�����ע��
	 * �ڰ�������Ϊʹ�ÿյ��û���������ע��
	 */
	public void register3(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	@DataProvider(name="register4")
	public Object [][] register4() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] object = excelDataProvider.getTestDataByExcel("E:\\aaathird\\register.xlsx","sheet5");
		return object;
	}
	@Test(description="��������ʵ�ֽ�ɫΪ�����ߵ�ע��",dataProvider="register4")
	/*
	 * ��һ�����ݲ�����ȡ��Ϊ���������
	 * �ڶ�������Ϊʹ��ע������û����Լ�ע���������ע��
	 * ����������Ϊδע����û����Լ�ע���������
	 * ����������Ϊʹ��ע������û�����δע���������ע��
	 * ����������Ϊʹ��δע������û���������ע��
	 * ����������Ϊʹ�ÿյ��û����Լ�δע���������ע��
	 * ����������Ϊʹ��δע������û����Լ��յ�����ע��
	 * �ڰ�������Ϊʹ�ÿյ��û���������ע��
	 */
	public void register4(String user_login,String email,String first_name,String last_name,String url,String pass1) {
		//ʵ�ֵ�¼
		adminLogin();
		//�����û�ģ��
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
		
		assertTrue(webtest.isTextPresent("���û��Ѵ���"));
	}
	
	
	@Test(description="Ͷ���ߵ�¼")
	public void writerLogin() {
		//��ҳ��
		webtest.open(url);
		//�ı�������
		webtest.type("name=log", "admin1");
		webtest.type("name=pwd", "admin1");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	}
	
	@Test(description="���ߵ�¼")
	public void authorLogin() {
		//��ҳ��
		webtest.open(url);
		//�ı�������
		webtest.type("name=log", "admin2");
		webtest.type("name=pwd", "admin2");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	
	@Test(description="�༭��¼")
	public void editorLogin() {
		//��ҳ��
		webtest.open(url);
		//�ı�������
		webtest.type("name=log", "admin3");
		webtest.type("name=pwd", "admin3");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	
	@Test(description="�����ߵ�¼")
	public void readerLogin() {
		//��ҳ��
		webtest.open(url);
		//�ı�������
		webtest.type("name=log", "admin4");
		webtest.type("name=pwd", "admin4");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	
	@DataProvider(name="login")
	public Object [][] loginname() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] objects = excelDataProvider.getTestDataByExcel("E:\\aaathird\\login1.xlsx","Sheet2");
		return objects;
	}
	@Test(description="��������ʵ�ֵ�¼",dataProvider="login")
	/*
	 * ����е�һ�в�����ȡ���ʵڶ������ݲſ�ʼִ��
	 * �ڶ��������ǽ�ɫΪͶ���ߵ���ȷ��¼
	 * �����������ǽ�ɫΪ���ߵ���ȷ��¼
	 * �����������ǽ�ɫΪ�༭����ȷ��¼
	 * �����������ǽ�ɫΪ�����ߵĽ�ɫ��¼
	 * �����������ǵ�¼����ȷ������Ϊ�յ����
	 * �����������ǵ�¼��Ϊ�գ����벻Ϊ�յ����
	 * �ڰ��������ǵ�¼�������Ϊ�յ����
	 * �ھ��������ǽ�ɫΪ����Ա����ȷ��¼
	 * ��ʮ�������ǵ�¼����ȷ�������������
	 * ��ʮһ�������ǵ�¼��Ϊδע����û���¼
	 */
	public void login(String name,String psd) {
		webtest.open(url);
		//�ı�������
		webtest.typeAndClear("name=log", name);
		webtest.typeAndClear("name=pwd", psd);
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));	
	}
	@DataProvider(name="upload")
	public Object [][] upload() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] objects = excelDataProvider.getTestDataByExcel("E:\\aaathird\\login1.xlsx","Sheet3");
		return objects;
	}
	@Test(description="�ϴ�ͼƬ",dataProvider="upload")
	/*
	 * ����е�һ�в�����ȡ���ʵڶ������ݲſ�ʼִ��
	 * �ڶ��������ǲ�����100M����Ƶ����mp3��β
	 * �����������ǲ�����100M����Ƶ����mp3��β
	 * �����������ǲ�����100M����Ƶ����mp3��β
	 * �����������ǲ�����100M��ѹ��������zip��β
	 * ������������10M�����Ƶ����mov��β
	 * ������������80M�����Ƶ����mov��β
	 * �ڰ���������10M�����Ƶ����mp4��β
	 * �ھ��������ǲ�����100M����Ƶ����flac��β
	 * ��ʮ�������ǲ�����100M�Ķ�ͼ����gif��β
	 * ��ʮһ�������ǲ�����100M��ͼƬ����jpg��β
	 * ��ʮ���������ǲ�����100M��ͼƬ����jpg��β
	 * ��ʮ���������ǲ�����100M��ͼƬ����png��β
	 * ��ʮ���������ǲ�����100M���ĵ�����txt��β
	 * ��ʮ���������ǲ�����100M���ĵ�����jmx��β
	 * ��ʮ���������ǲ�����100M���ĵ�����md��β
	 * ��ʮ���������ǲ�����100M���ļ�����war��β
	 * ��ʮ����������exe�ļ�
	 */
	private void up(String str) {
		adminLogin();
		webtest.click("id=menu-media");
		webtest.click("class=page-title-action");
		webtest.click("link=��׼������ϴ�����");
		webtest.typeAndClear("xpath=//*[@id=\"async-upload\"]",str);
		webtest.click("xpath=//*[@id=\"html-upload\"]");
		assertFalse(webtest.isTextPresent("�ǳ�"));
	}
}
