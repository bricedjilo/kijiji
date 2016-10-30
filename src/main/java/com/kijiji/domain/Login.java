package com.kijiji.domain;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kijiji.services.DriverServices;

import net.sourceforge.htmlunit.corejs.javascript.json.JsonParser;

@Component("login")
public class Login {
	
	private WebDriver phantomDriver;

	private DriverServices driverServices;

	public Login() {		
	}
	
	@Autowired
	public void setDriverService(DriverServices driverServices) {
		this.driverServices = driverServices;
	}

//	@Autowired
//	public void setPhantomDriver(WebDriver phantomDriver) {
//		this.phantomDriver = phantomDriver;
//	}
	
	public String accessKijiji(String username, String password, String url) {
		phantomDriver = driverServices.getPhantomJsDriver(url);
		phantomDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement usernameElement = phantomDriver.findElement(By.id("LoginEmailOrNickname"));
		usernameElement.clear();
		usernameElement.sendKeys(username);
		WebElement passwordElement = phantomDriver.findElement(By.id("login-password"));
		passwordElement.clear();
		passwordElement.sendKeys(password);
		WebElement signInElement = phantomDriver.findElement(By.id("SignInButton"));
		signInElement.click();
		WebElement logoElement = phantomDriver.findElement(By.id("Logo"));
		logoElement.click();
		String displayedName = phantomDriver.getTitle(); //findElement(By.className("user-name"));
		System.out.println("========== " +displayedName + " ==============");
		
		phantomDriver.navigate().to("https://www.kijiji.ca/m-my-ads.html");
		
		//List<WebElement> 
		WebElement test2 = null;
//			WebDriverWait wait = new WebDriverWait(phantomDriver, 50);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserLogged")));
//		String test2 = (String)((JavascriptExecutor) phantomDriver)
//				.executeScript("return document.getElementsByClassName('button-header-nav')[0].innerHTML");
		
		//JSONParser json = new JSONParser().parse((String) test2);
	
	//	long end = System.currentTimeMillis() + 15000;
	//	WebDriverWait wait = new WebDriverWait(phantomDriver, 100);
	//	WebElement test = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserLogged")));
//        while (System.currentTimeMillis() < end) {
//        //	displayedName = phantomDriver;//findElement(By.id("HeaderRightBottom"));
//        	test = phantomDriver.findElement(By.id("ChangeLocale"));
        	test2 = phantomDriver.findElement(By.xpath("//*[@id='MainContainer']/div[2]/div/h1"));
//        }
		
		System.out.println("========== " +test2.getText() + " ==============");
	//	System.out.println("========== " +bodyText.contains("waza.tech@yahoo") + " ==============");
		phantomDriver.quit();
		return "Kijiji is opened";
	}
}
