package com.edu.freemarker;

import java.awt.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class FreemarkerTestListener extends TestListenerAdapter{
	//所有测试用例执行完再执行
	@Override
	public void onFinish(ITestContext testContext){
		StringBuilder stringBuilder = new StringBuilder();
		ITestNGMethod[] methods = this.getAllTestMethods();
		stringBuilder.append("一共执行了"+methods.length+"条测试用例\n");
//		List<ITestResult> fail = this.getFailedTests();
		
	}
}
