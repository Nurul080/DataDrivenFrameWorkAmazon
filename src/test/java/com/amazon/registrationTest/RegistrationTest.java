package com.amazon.registrationTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.registrationPages.RegistrationPage;
import com.amazon.utilities.ExcelReader;

public class RegistrationTest extends BaseTest{
	RegistrationPage rPage;
	ExcelReader er;
	String file = "src/test/resources/RegistrationData.xlsx";
	String sheetName = "Sheet2";
	
	@BeforeMethod(groups={"Smoke","Regression"})
	public void openApplication() {
		openApp();
	}
	
	@Test(priority=0,groups="Smoke")
	public void aloResgistrtion() {
		rPage = new RegistrationPage(driver);
		er = new ExcelReader(file,sheetName);
		rPage.accountMethod();
		rPage.createAccountMethod();
		rPage.nameMethod(er.getStringCellValue(1, 0));
		rPage.emailMethod(er.getStringCellValue(1, 1));
		rPage.passwordMethpd(er.getStringCellValue(1, 2));
		//rPage.reenterpasswordMethpd(er.getStringCellValue(1, 3));
		rPage.continueButtonMethod();
	}
	@Test(priority=1,groups="Regression")
	public void sokalResgistrtion() {
		rPage = new RegistrationPage(driver);
		er = new ExcelReader(file,sheetName);
		rPage.accountMethod();
		rPage.createAccountMethod();
		rPage.nameMethod(er.getStringCellValue(2, 0));
		rPage.emailMethod(er.getStringCellValue(2, 1));
		rPage.passwordMethpd(er.getStringCellValue(2, 2));
		//rPage.reenterpasswordMethpd(er.getStringCellValue(2, 3));
		rPage.continueButtonMethod();
	}
	
	@AfterMethod(groups={"Smoke","Regression"})
	public void closeApplication() {
		closeApp();
	}

}
