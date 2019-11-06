package br.com.rsinet.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		
		if(driver == null) {
			try {
				createDriver();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return driver;
	}
	
	 @Before
		private static void createDriver() throws MalformedURLException {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("deviceName", "emulator-5554");
		    desiredCapabilities.setCapability("automationName", "uiautomator2");
		    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/alan.lima/projetos/CursoAppium/src/main/resources/1.1 CTAppium_1_1.apk.apk");

		     URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		     
		     driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     
		        
	   
			
		}
	 
	 public static void killDriver() {
		 
		 if(driver != null) {
			 driver.quit();
			 driver = null;
			 
		 }
		
		 
	 }

}
