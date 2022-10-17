package com.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.Screenshot;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	Workbook wb;
	Sheet ws;
	public LoginPageTest() {
		super();
		
	}

	@BeforeMethod
	public void setup() {
		System.out.println("Setup");
		initialize();
		loginPage = new LoginPage();
		
	}
	
	@DataProvider(name="Testdata")
	public Object[][] getTestData() throws EncryptedDocumentException, IOException {
		
		
		FileInputStream file = new FileInputStream("src\\test\\resources\\TestData.xlsx");
		wb = WorkbookFactory.create(file);
		ws = wb.getSheetAt(0);
		int totalrows = ws.getLastRowNum();
		int totalcolumns = ws.getRow(0).getLastCellNum();
		System.out.println(totalrows);
		System.out.println(totalcolumns);
		Object[][] data = new Object[totalrows][totalcolumns];
		for (int i =0;i<totalrows;i++) {
			for(int j = 0; j<totalcolumns;j++) {
				data[i][j] = ws.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		
		return data;
	}
	
	@Test(enabled=false)
	public void loginTest1() throws InterruptedException {
		loginPage.performLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(loginPage.getHomePageTitle(),"Cogmento CRM");
	}
	@Test(enabled=true,dataProvider="Testdata")
	public void loginTest2(String un, String pwd) throws InterruptedException {
		System.err.println("START");
		homePage = loginPage.performLogin(un,pwd);
		Assert.assertEquals(loginPage.getHomePageTitle(),"Cogmento CRM");
	}
	
	
	@AfterMethod
	public void tearDown() throws IOException {
		//Screenshot.takeScreenshot();
		driver.quit();
	}

}
