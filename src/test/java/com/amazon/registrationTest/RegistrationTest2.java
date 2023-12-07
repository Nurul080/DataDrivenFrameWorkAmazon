package com.amazon.registrationTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.registrationPages.RegistrationPage;
import com.amazon.utilities.ExcelReader;

public class RegistrationTest2 extends BaseTest{
	RegistrationPage rPage;
	ExcelReader er;
	String file = "src/test/resources/RegistrationData.xlsx";
	String sheetName = "Sheet2";
	
	@BeforeMethod(groups={"Smoke","Regression"})
	public void openApplication() {
		openApp();
	}
	
	@Test(priority=1,groups="Smoke")
	public void rudelaResgistrtion() {
		rPage = new RegistrationPage(driver);
		er = new ExcelReader(file,sheetName);
		rPage.accountMethod();
		rPage.createAccountMethod();
		rPage.nameMethod(er.getStringCellValue(3, 0));
		rPage.emailMethod(er.getStringCellValue(3, 1));
		rPage.passwordMethpd(er.getStringCellValue(3, 2));
		//rPage.reenterpasswordMethpd(er.getStringCellValue(3, 3));
		rPage.continueButtonMethod();
		String actualTile ="amazon";
		String expentedTitle = driver.getTitle();
		Assert.assertEquals(actualTile, expentedTitle);
	}
	@Test(priority=0,groups="Regression")
	public void porontolResgistrtion() {
		rPage = new RegistrationPage(driver);
		er = new ExcelReader(file,sheetName);
		rPage.accountMethod();
		rPage.createAccountMethod();
		rPage.nameMethod(er.getStringCellValue(4, 0));
		rPage.emailMethod(er.getStringCellValue(4, 1));
		rPage.passwordMethpd(er.getStringCellValue(4, 2));
		//rPage.reenterpasswordMethpd(er.getStringCellValue(4, 3));
		rPage.continueButtonMethod();
	}
	
	@AfterMethod(groups={"Smoke","Regression"})
	public void closeApplication() {
		closeApp();
	}

}
