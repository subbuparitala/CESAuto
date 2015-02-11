package com.skiff.test;

import static com.skiff.test.DriverScript.APP_LOGS;
import static com.skiff.test.DriverScript.CONFIG;
import static com.skiff.test.DriverScript.OR;
import static com.skiff.test.DriverScript.currentTestSuiteXLS;
import static com.skiff.test.DriverScript.currentTestCaseName;
import static com.skiff.test.DriverScript.currentTestDataSetID;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

//one function per keyword
public class Keywords{
	
	public WebDriver driver;
	
	public String openBrowser(String object,String data){		
		APP_LOGS.debug("Opening browser");
		System.out.println("data is :" + data);
		if(CONFIG.getProperty(data).equals("Mozilla"))
			driver=new FirefoxDriver();
		else if(data.equals("IE"))
			driver=new InternetExplorerDriver();
		else if(data.equals("Chrome"))
			driver=new ChromeDriver();
		return Constants.KEYWORD_PASS;
	}
	public String navigate(String object,String data){		
		APP_LOGS.debug("Navigating to URL");
		try{
			driver.navigate().to(CONFIG.getProperty(data));
		}catch(Exception e){
			return Constants.KEYWORD_FAIL + "--Not able to navigate" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}
	public String clickLink(String object,String data){
        APP_LOGS.debug("Clicking on link ");
        try{
        	driver.findElement(By.xpath(OR.getProperty(object))).click();
        }catch(Exception e){
        	return Constants.KEYWORD_FAIL + "--Not able to click on link"+ e.getMessage();
        }
		return Constants.KEYWORD_PASS;
	}
	public String clickLink_linkText(String object,String data){
        APP_LOGS.debug("Click on the link by text ");
        try{
        	driver.findElement(By.linkText(OR.getProperty(object))).click();
        }catch(Exception e){
        	return Constants.KEYWORD_FAIL + "--Not able to click on link text"+ e.getMessage();
        }
        
		return Constants.KEYWORD_PASS;
	}
	public String verifyLinkText(String object,String data){
		APP_LOGS.debug("Verify the link text ");
		try{
			String actual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected=OR.getProperty(data);
			if(actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + "--Not able to verify the link text";
		}catch(Exception e){
			return Constants.KEYWORD_FAIL + "--Not able to verify the link text"+ e.getMessage();
		}
	}
	public String writelnInput(String object,String data){
        APP_LOGS.debug("writing data into filed");
        try{
        	driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
        }catch(Exception e){
        	return Constants.KEYWORD_FAIL + "Not able to write into field"+ e.getMessage();
        }
        return Constants.KEYWORD_PASS;
	}
	
	public  String verifyTextinInput(String object,String data){
	       APP_LOGS.debug("Verifying the text in input box");
	       try{
	       String actual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected=OR.getProperty(data);
			if(actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + "--Not able to verify the text in input box";
		}catch(Exception e){
			return Constants.KEYWORD_FAIL + "--Not able to verify the text in input box"+ e.getMessage();
		}
	}
	
	public  String clickButton(String object,String data){
        APP_LOGS.debug("Clicking on Button");
        try{
        	driver.findElement(By.xpath(OR.getProperty(object))).click();
        }catch(Exception e){
        	return Constants.KEYWORD_FAIL + "--Not able to click on button"+ e.getMessage();
        }
		return Constants.KEYWORD_PASS;
	}
	
	public  String verifyButtonText(){
		APP_LOGS.debug("Verifying the button text");
		
		return Constants.KEYWORD_PASS;	
	}
	
	public  String selectList(){
		APP_LOGS.debug("Selecting from list");
		
		return Constants.KEYWORD_PASS;	
	}
	
	public  String verifyListSelection(){
		APP_LOGS.debug("Verifying the selection of the list");
		return Constants.KEYWORD_PASS;	
	}
	
	public  String verifyAllListElements(){
		APP_LOGS.debug("Verifying all the list elements");
		return Constants.KEYWORD_PASS;	
	}
	
	public  String selectRadio(){
		APP_LOGS.debug("Selecting a radio button");
		return Constants.KEYWORD_PASS;	
	}
	
	public  String verifyRadioSelected(){
		APP_LOGS.debug("Verify Radio Selected");
		return Constants.KEYWORD_PASS;	
	}
	
	public  String verifyCheckBoxSelected(){
		APP_LOGS.debug("Verifying checkbox selected");
		return Constants.KEYWORD_PASS;
	}
	
	public  String verifyText(){
		APP_LOGS.debug("Verifying the text");
		return Constants.KEYWORD_PASS;
	}
	
	public  String clickImage(){
		APP_LOGS.debug("Clicking the image");
		return Constants.KEYWORD_PASS;
	}
	
	public  String verifyFileName(){
		APP_LOGS.debug("Verifying inage filename");
		return Constants.KEYWORD_PASS;
	}
	
	public  String pause(){
	    APP_LOGS.debug("Waiting");
		return Constants.KEYWORD_PASS;
	}
	
	public  String store(){
		APP_LOGS.debug("Storing value");
		return Constants.KEYWORD_PASS;
	}
	
	public  String verifyTitle(){
		APP_LOGS.debug("Verifying title");
		return Constants.KEYWORD_PASS;
	}
	
	public  String exist(){
		APP_LOGS.debug("Checking existance of element");
		return Constants.KEYWORD_PASS;
	}
	
	public  String click(){
		APP_LOGS.debug("Clicking on any element");
		return Constants.KEYWORD_PASS;
	}
	
	public  String synchronize(){
		APP_LOGS.debug("Waiting for page to load");
		return Constants.KEYWORD_PASS;
	}
	
	public  String waitForElementVisibility(){
		APP_LOGS.debug("Waiting for an elelement to be visible");
		return Constants.KEYWORD_PASS;
	}
	
	public  String closeBroswer(String object,String data){
		APP_LOGS.debug("Closing the browser");
		try{
			Thread.sleep(1000);
			driver.quit();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+"Unable to close browser. Check if its open"+e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}
	
	/************************APPLICATION SPECIFIC KEYWORDS********************************/
	
	public String verifySearchResults(String object,String data){
        APP_LOGS.debug("Verifying the Search Results");
        try{
        	data=data.toLowerCase();
        	for(int i=1;i<=3;i++){
        		String text=driver.findElement(By.xpath(OR.getProperty("search_result_heading_start")+i+OR.getProperty("search_result_heading_end"))).getText();
//        		.toLowerCase()
        		System.out.println("Parent ID: " + text);
        		/*if(text.indexOf(data) == -1){
        			return Constants.KEYWORD_FAIL+" Got the text - "+text;
        		}*/
        	}
        	
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+"Error -->"+e.getMessage();
		}
        
		return Constants.KEYWORD_PASS;
	}

	public void captureScreenshot(String filename, String keyword_execution_result) throws IOException{
		// take screen shots
		if(CONFIG.getProperty("screenshot_everystep").equals("Y")){
			// capturescreen
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
			
		}else if (keyword_execution_result.startsWith(Constants.KEYWORD_FAIL) && CONFIG.getProperty("screenshot_error").equals("Y") ){
		// capture screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
		}
	}
	
}
