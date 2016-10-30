package com.kijiji.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

@Component("screenShot")
public class KijijiScreenShot {
	
	public KijijiScreenShot() {
		
	}

	@Test
	public void takeScreenShot(String screenShotName) throws MalformedURLException {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setCapability("platform", Platform.ANY);
		capability.setCapability("binary", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//WebDriver driver = new FirefoxDriver(capability);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), capability);
		
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		KijijiScreenShot.captureScreenShot(driver, screenShotName);
	}

	public static void captureScreenShot(WebDriver ldriver, String screenShotName){          
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
		try {	 
			FileUtils.copyFile(src, new File(screenShotName+".png"));                              
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

/**
 * Capabilities caps = new DesiredCapabilities();
                ((DesiredCapabilities) caps).setJavascriptEnabled(true);                
                ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);  
                ((DesiredCapabilities) caps).setCapability(
                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        "your custom path\\phantomjs.exe"
                    );
 WebDriver   driver = new  PhantomJSDriver(caps);
 **/
