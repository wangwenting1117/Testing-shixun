package com.edu.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TestCases extends BaseTest{
	@Test
	public void testLogin() {
		//��ҳ��
		webtest.open("http://localhost:8033/wordpress/wp-login.php");
		//�ı�������
		webtest.type("name=log", "admin");
		webtest.type("name=pwd", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
	}
	
	
}
