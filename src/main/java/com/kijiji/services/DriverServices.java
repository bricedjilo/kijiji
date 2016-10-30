package com.kijiji.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

@Service("driverService")
public class DriverServices {
	
	private WebDriver driver;

	@Autowired
	public WebDriver setDriver() {
		return driver;
	}

	public WebDriver getPhantomJsDriver(String url){
		driver = new PhantomJSDriver();
		driver.get(url);
		return driver;
	}
	
	public void quitDriver(){
		driver.quit();
	}

}
