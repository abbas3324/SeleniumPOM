package com.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class Screenshot extends TestBase {
	
	public static void takeScreenshot() throws IOException {
		File sfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		
	FileUtils.copyFile(sfile, new File(currentDir+"\\screenshots\\"+"Error.png"));	
	}

}
