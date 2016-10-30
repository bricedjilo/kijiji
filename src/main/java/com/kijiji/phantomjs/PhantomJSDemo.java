package com.kijiji.phantomjs;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

@Component("phantomjs")
public class PhantomJSDemo {

//	DesiredCapabilities capabilities;
    PhantomJSDriver driver = new PhantomJSDriver(DesiredCapabilities.phantomjs());
	
//    @Autowired
//    public void setCapabilities(DesiredCapbilities capabilities) {
//    	this.capabilities = DesiredCapabilities.phantomjs();
//    }
    
//    @Autowired
//    public void setPhantomJSDriver(PhantomJSDriver driver) {
//    	this.driver = new PhantomJSDriver(DesiredCapabilities.phantomjs());
//    }
    
	@Test
	public String verifyFacebookTitle(){
//		File src = new File("../phantomjs-2.0.0-windows/bin/phantomjs.exe");
//		System.set
//		WebDriver driver = new PhantomJSDriver();
	
	    driver.get("https://www.kijiji.ca/t-login.html");
	    System.out.println("============== " +driver.getTitle() + " ================================");
	    return driver.getTitle();
	}
	
	public void quit(){
		driver.quit();
	}
	
}
