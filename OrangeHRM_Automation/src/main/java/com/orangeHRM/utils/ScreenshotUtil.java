package com.orangeHRM.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {
	
	public static void captureScreenshot(WebDriver driver,String testName) {
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
            Files.copy(src.toPath(),
                    Paths.get("screenshots/" + testName + ".png"));
        } 
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
