package com.edu.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class TestCases extends BaseTest{
	@Test(description="����Ա��¼")
	public void adminLogin() {
		//��ҳ��
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//�ı�������
		webtest.type("name=log", "admin");
		webtest.type("name=pwd", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	@Test(description="Ͷ���ߵ�¼")
	public void writerLogin() {
		//��ҳ��
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//�ı�������
		webtest.type("name=log", "admin1");
		webtest.type("name=pwd", "admin1");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	}
	@Test(description="���ߵ�¼")
	public void authorLogin() {
		//��ҳ��
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//�ı�������
		webtest.type("name=log", "admin2");
		webtest.type("name=pwd", "admin2");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	@Test(description="�༭��¼")
	public void editorLogin() {
		//��ҳ��
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//�ı�������
		webtest.type("name=log", "admin3");
		webtest.type("name=pwd", "admin3");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	@Test(description="�����ߵ�¼")
	public void readerLogin() {
		//��ҳ��
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//�ı�������
		webtest.type("name=log", "admin4");
		webtest.type("name=pwd", "admin4");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	} 
	
	@DataProvider(name="login")
	public Object [][] loginname() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] objects = excelDataProvider.getTestDataByExcel("E:\\aaathird\\login.xlsx","sheet1");
		return objects;
	}
	@Test(description="��������",dataProvider="login")
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
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//�ı�������
		webtest.typeAndClear("name=log", name);
		webtest.typeAndClear("name=pwd", psd);
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));	
	}
	
	
}
