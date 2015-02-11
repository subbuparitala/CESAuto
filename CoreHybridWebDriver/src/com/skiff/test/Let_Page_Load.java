package com.skiff.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Let_Page_Load {
	public static void main(String args[]){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.flipkart.com/");
		 
		Object result = ((JavascriptExecutor) driver).executeScript("function pageloadingtime()"+
		"{" +
				"return 'page has completely loaded'" +	
		"}" +
				"return (window.onload=pageloadingtime());");
		System.out.println(result);
		
		driver.close();
	}

}
