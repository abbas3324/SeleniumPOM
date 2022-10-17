package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	//HomePage homepage;
	@CacheLookup
	@FindBy(name="email1") 	WebElement email;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginBtn;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage performLogin(String un, String pwd) throws InterruptedException {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(5000);
		return new HomePage();
		
	}
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	
	
	

}
