package com.edu.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestsListener.class)
public class TestCases {
	@Test
	public void test1(){
		System.out.println("hello");
	}
	
}
