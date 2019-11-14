//把测试结果写入测试报告模板

package com.freemarker;

import java.awt.List;
import java.util.ArrayList;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter{
	FreeMarkerUtil ftl=new FreeMarkerUtil();
	
	public Listener(){
		super();
	}
	
	private String writeResultToMailTemplate(){
		ITestNGMethod method[]=this.getAllTestMethods();
		List failedList=this.getFailedTests();
		List passedList=this.getPassedTests();
		List failedList1=new ArrayList();
		List passedList1=new ArrayList();
		
		return null;
		
	}
}
