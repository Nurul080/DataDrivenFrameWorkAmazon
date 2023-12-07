package com.amazon.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;

	
	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "nav-link-accountList-nav-line-1")
	public WebElement accountLocator;

	public WebElement accountMethod() {
		accountLocator.click();
		return accountLocator;
		
	}
	@FindBy(how = How.ID, using ="createAccountSubmit")
	public WebElement createAccountLocator;
	
	public void createAccountMethod() {
		createAccountLocator.click();
	}
	@FindBy(how = How.ID, using = "ap_customer_name")
	public WebElement yourNameLocator;
	
	public WebElement nameMethod(String enterFristandLastName){
		yourNameLocator.sendKeys(enterFristandLastName);
		return createAccountLocator;	
	}
	@FindBy(how = How.ID, using = "ap_email")
	public WebElement emailorphoneNumberLocator;
	
	public WebElement emailMethod(String enteremail) {
		emailorphoneNumberLocator.sendKeys(enteremail);
		return emailorphoneNumberLocator;
	}
	@FindBy(how = How.ID, using = "ap_password")
	public WebElement passwordLocator;
	
	public WebElement passwordMethpd(String enterpassword) {
		passwordLocator.sendKeys(enterpassword);
		return passwordLocator;
	}
	@FindBy(how = How.ID, using = "ap_password_check")
	public WebElement reenterpasswordLocator;
	
	public WebElement reenterpasswordMethpd(String reenterpassword) {
		reenterpasswordLocator.sendKeys(reenterpassword);
		return reenterpasswordLocator;
	}
	@FindBy(how = How.ID, using = "continue")
	public WebElement continuebuttoLocator;
	
	public void continueButtonMethod() {
		continuebuttoLocator.click();
	}

}
