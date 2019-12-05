package com.edu.freemarker;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class r extends BaseTest {
			
	@Test
		@DataProvider(name="login")
		public Object [][] loginname() throws IOException{
			ExcelDataProvider excelDataProvider = new ExcelDataProvider();
			Object[][] objects = excelDataProvider.getTestDataByExcel("D:\\project-training\\login.xlsx","sheet1");
			return objects;
		}
		@Test(description="��������",dataProvider="login")
		public void login(String name,String psd) {
			webtest.open("http://localhost:8081/wordpress/wp-login.php");
			//�ı�������
			webtest.typeAndClear("name=log", name);
			webtest.typeAndClear("name=pwd", psd);
			webtest.click("xpath=//input[@type='submit']");
			assertTrue(webtest.isTextPresent("�ǳ�"));	
			}
}
