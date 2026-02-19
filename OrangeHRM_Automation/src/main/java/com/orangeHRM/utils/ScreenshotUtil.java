package com.orangeHRM.utils;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	protected WebDriver driver;
	
	public ScreenshotUtil(WebDriver driver) {
		this.driver =driver;
	}	
	public  void TakeScreenshot(String BaseName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String fileName = BaseName + "_" + timestamp + ".jpg";

	    File screenshotDir = new File("./Screenshots");
	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdirs();
	    }
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver; //typecasting the driver as getScreenshotAs method coming from the RemoteDriver not WebDriver.
		File Screenshot = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./Screenshots/"+fileName+".jpg");
		try {
			FileUtils.copyFile(Screenshot, dstFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}