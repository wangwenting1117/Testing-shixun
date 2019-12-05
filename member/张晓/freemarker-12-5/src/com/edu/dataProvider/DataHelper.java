package com.edu.dataProvider;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freemarker.core.ReturnInstruction.Return;

public class DataHelper {
	@DataProvider(name="getLoginData")
	public Object[][] getLoginData() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/LoginData.xlsx", "sheet1",2);
	}
	@DataProvider(name="getSiteTitle")
	public Object[][] getSiteTitle() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/SiteTitleData.xlsx", "sheet1",1);
	}
	@DataProvider(name="getTagline")
	public Object[][] getTagline() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/TaglineData.xlsx", "sheet1",1);
	}
	@DataProvider(name="getEmailAddress")
	public Object[][] getEmailAddress() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/EmailAddressData.xlsx", "sheet1",1);
	}
	@DataProvider(name="getIndex")
	public Object[][] getIndex() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/Index.xlsx", "sheet1",1);
	}
	@DataProvider(name="getDate")
	public Object[][] getDate() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/Date.xlsx", "sheet1",1);
	}
	@DataProvider(name="getTime")
	public Object[][] getTime() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/Time.xlsx", "sheet1",1);
	}
	@DataProvider(name="getPage")
	public Object[][] getPage() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/PageShow.xlsx", "sheet1",1);
	}
	@DataProvider(name="getText")
	public Object[][] getText() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/TextData.xlsx", "sheet1",1);
	}
	@DataProvider(name="getUrl")
	public Object[][] getUrl() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("E:/zhangxiao/TestData/UrlData.xlsx", "sheet1",1);
	}
}