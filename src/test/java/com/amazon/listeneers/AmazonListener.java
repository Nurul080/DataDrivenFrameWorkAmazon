package com.amazon.listeneers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.base.BaseTest;



public class AmazonListener implements ITestListener {
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getName();
		System.out.println(methodName + ">>>>>>method started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		System.out.println(methodName+" >>>>>>method Faill");
		takeScreenShot(methodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		String suitName = context.getName();
		System.out.println(suitName + " >>>>>>>Tests started");
	}

	@Override
	public void onFinish(ITestContext context) {
		String testName = context.getName();
		System.out.println(testName + " >>>>>>>Tests Finished");
	}
	
	
	public void takeScreenShot(String screenShortName) {
		BaseTest b = new BaseTest();
		WebDriver driver = b.openApp();
		TakesScreenshot screenShot=((TakesScreenshot)driver);
		File SrcFile = screenShot.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		String fileWithPath ="ScreenShot/"+time+screenShortName+".png";
		File DestFile = new File(fileWithPath);
		
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}

}
