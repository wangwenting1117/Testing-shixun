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
		//打开页面
		webtest.open("http://localhost:8081/wordpress/wp-login.php?loggedout=true");
		//文本框输入
		webtest.type("name=log", "baishikele@");
		webtest.type("name=pwd", "BaiShiKeLe*");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("登出"));
		//新建页面
		webtest.click("xpath=//*[@id=\"menu-pages\"]/a/div[3]");
		webtest.click("xpath=//*[@id=\"menu-pages\"]/ul/li[3]/a");
		assertTrue(webtest.ifContains("新建页面"));
		
		//新建页面添加媒体
		webtest.click("xpath=//*[@id=\"insert-media-button\"]");
		assertTrue(webtest.ifContains("添加媒体"));
		//搜索媒体库
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-0\"]/div[3]/div/a[2]");
		assertTrue(webtest.ifContains("媒体"));
		webtest.type("xpath=//*[@id=\"media-search-input\"]","测试");
		assertTrue(webtest.ifContains("搜索"));
		Thread.sleep(3000);
		
		//上传文件
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-0\"]/div[3]/div/a[1]");
		assertTrue(webtest.ifContains("上传文件"));
		//小于100m
		webtest.type("xpath=//*[@id=\"__wp-uploader-id-1\"]", "D:\\project-training\\caseTemplate.xlsx");
		//大于100m
		//webtest.type("attach[]", "D:\\project-training\\大于100M测试视频EP19\\EP19.mp4");
		
		
		//新建页面数据驱动
		
		
		//关闭媒体库
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-2\"]/div[1]/button");
		assertTrue(webtest.ifContains("关闭"));
		//所有页面
		webtest.click("xpath=//*[@id=\"menu-pages\"]/ul/li[2]/a");
		assertTrue(webtest.ifContains("所有页面"));
		//全选
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		//编辑
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("xpath=//*[@id=\"doaction\"]");
		webtest.click("xpath=//*[@id=\"bulk-edit\"]/td/fieldset[2]/div/label[1]/select/option[2]");
		webtest.click("xpath=//*[@id=\"post_parent\"]/option[2]");
		webtest.click("xpath=//*[@id=\"bulk-edit\"]/td/fieldset[2]/div/div[1]/label/select/option[2]");
		webtest.click("xpath=//*[@id=\"bulk_edit\"]");
		assertTrue(webtest.ifContains("编辑"));
		//搜索
		webtest.type("xpath=//*[@id=\"post-search-input\"]","test1");
		webtest.click("xpath=//*[@id=\"search-submit\"]");
		assertTrue(webtest.ifContains("搜索"));
		//移回收站
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("xpath=//*[@id=\"search-submit\"]");
		assertTrue(webtest.ifContains("回收站"));
		//撤销操作
		webtest.click("xpath=//*[@id=\"message\"]/p/a");
		assertTrue(webtest.ifContains("撤销"));
		//草稿
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[3]/a");
		webtest.click("xpath=//*[@id=\"filter-by-date\"]/option[2]");
		webtest.click("xpath=//*[@id=\"post-query-submit\"]");
		assertTrue(webtest.ifContains("草稿"));
		
		
		//评论
		webtest.click("xpath=//*[@id=\"menu-comments\"]/a/div[3]");
		assertTrue(webtest.ifContains("评论"));
		//全选
		webtest.click("id=cb-select-all-1");
		//驳回
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("驳回"));
		//批准
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("批准"));
		//标记为垃圾
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[4]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("标记为垃圾评论"));
		//不是垃圾
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[4]/a");
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("不是垃圾评论"));
		//移到回收站
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[1]/a");
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[5]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("移到回收站"));
		//从回收站还原
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[5]/a");
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("id=doaction");
		assertTrue(webtest.ifContains("还原"));

		//搜索评论(写数据驱动)
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[1]/a");
		webtest.type("id=comment-search-input","hh" );
		webtest.click("id=search-submit");
		assertTrue(webtest.ifContains("搜索"));
		
		//回复
		webtest.click("xpath=//*[@id=\"comment-2\"]/td[2]/div[3]/span[3]/a");
		assertTrue(webtest.ifContains("回复"));
	}
}
