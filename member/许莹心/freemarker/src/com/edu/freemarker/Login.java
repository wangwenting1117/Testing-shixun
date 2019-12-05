package com.edu.freemarker;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

public class Login extends BaseTest{
	@Test
	public void testLogin() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.quit();
		//��ҳ��
		webtest.open("http://localhost:8081/wordpress/wp-login.php?loggedout=true");
		//�ı�������
		webtest.type("name=log", "baishikele@");
		webtest.type("name=pwd", "BaiShiKeLe*");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("�ǳ�"));
		//�½�ҳ��
		webtest.click("xpath=//*[@id=\"menu-pages\"]/a/div[3]");
		webtest.click("xpath=//*[@id=\"menu-pages\"]/ul/li[3]/a");
		assertTrue(webtest.ifContains("�½�ҳ��"));
		
		//�½�ҳ�����ý��
		webtest.click("xpath=//*[@id=\"insert-media-button\"]");
		assertTrue(webtest.ifContains("���ý��"));
		//����ý���
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-0\"]/div[3]/div/a[2]");
		assertTrue(webtest.ifContains("ý��"));
		webtest.type("xpath=//*[@id=\"media-search-input\"]","����");
		assertTrue(webtest.ifContains("����"));
		Thread.sleep(3000);
		
		//�ϴ��ļ�
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-0\"]/div[3]/div/a[1]");
		assertTrue(webtest.ifContains("�ϴ��ļ�"));
		//С��100m
		webtest.type("xpath=//*[@id=\"__wp-uploader-id-1\"]", "D:\\project-training\\caseTemplate.xlsx");
		//����100m
		//webtest.type("attach[]", "D:\\project-training\\����100M������ƵEP19\\EP19.mp4");
		
		
		//�½�ҳ����������
		
		
		//�ر�ý���
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-2\"]/div[1]/button");
		assertTrue(webtest.ifContains("�ر�"));
		//����ҳ��
		webtest.click("xpath=//*[@id=\"menu-pages\"]/ul/li[2]/a");
		assertTrue(webtest.ifContains("����ҳ��"));
		//ȫѡ
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		//�༭
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("xpath=//*[@id=\"doaction\"]");
		webtest.click("xpath=//*[@id=\"bulk-edit\"]/td/fieldset[2]/div/label[1]/select/option[2]");
		webtest.click("xpath=//*[@id=\"post_parent\"]/option[2]");
		webtest.click("xpath=//*[@id=\"bulk-edit\"]/td/fieldset[2]/div/div[1]/label/select/option[2]");
		webtest.click("xpath=//*[@id=\"bulk_edit\"]");
		assertTrue(webtest.ifContains("�༭"));
		//����
		webtest.type("xpath=//*[@id=\"post-search-input\"]","test1");
		webtest.click("xpath=//*[@id=\"search-submit\"]");
		assertTrue(webtest.ifContains("����"));
		//�ƻ���վ
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("xpath=//*[@id=\"search-submit\"]");
		assertTrue(webtest.ifContains("����վ"));
		//��������
		webtest.click("xpath=//*[@id=\"message\"]/p/a");
		assertTrue(webtest.ifContains("����"));
		//�ݸ�
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[3]/a");
		webtest.click("xpath=//*[@id=\"filter-by-date\"]/option[2]");
		webtest.click("xpath=//*[@id=\"post-query-submit\"]");
		assertTrue(webtest.ifContains("�ݸ�"));
		
		
		//����
		webtest.click("xpath=//*[@id=\"menu-comments\"]/a/div[3]");
		assertTrue(webtest.ifContains("����"));
		//ȫѡ
		webtest.click("id=cb-select-all-1");
		//����
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("����"));
		//��׼
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("��׼"));
		//���Ϊ����
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[4]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("���Ϊ��������"));
		//��������
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[4]/a");
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("������������"));
		//�Ƶ�����վ
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[1]/a");
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[5]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("�Ƶ�����վ"));
		//�ӻ���վ��ԭ
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[5]/a");
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("��ԭ"));

		//��������(д��������)
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[1]/a");
		webtest.type("id=comment-search-input","hh" );
		webtest.click("id=search-submit");
		assertTrue(webtest.ifContains("����"));
		
		//�ظ�
		webtest.click("xpath=//*[@id=\"comment-2\"]/td[2]/div[3]/span[3]/a");
		assertTrue(webtest.ifContains("�ظ�"));
	}
}
