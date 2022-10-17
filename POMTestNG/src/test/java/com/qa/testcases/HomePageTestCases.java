package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTestCases extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//ContactsPage contactsPage;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialize();
		loginPage = new LoginPage();
		homePage = loginPage.performLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
		
	@Test
	public void movetoContactsPage() throws InterruptedException {
		homePage.navigateToContactsPage();
		Assert.assertTrue(homePage.ContactsPageDisplayed());
				
	}
		
	
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
