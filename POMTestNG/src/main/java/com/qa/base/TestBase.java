package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utils.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventdriver;
	public static WebEventListener eventlistener;
	public TestBase(){
	prop = new Properties();
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\abbas\\eclipse-workspace\\POMTestNG\\"
				+"src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
	}
	@SuppressWarnings("deprecation")
	public static void initialize() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Abbas/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		eventdriver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
				eventdriver.register(eventlistener);
				driver = eventdriver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

}
