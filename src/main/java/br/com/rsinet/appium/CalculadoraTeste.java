package br.com.rsinet.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {
	
	
	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		
		
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

	     URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
	     
	    AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		
	


	    MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el7.click();
	    MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("equals");
	    el8.click();
	  //  MobileElement el9 = (MobileElement) driver.findElementById("com.android.calculator2:id/formula");
		 System.out.println(el7.getText());
		 Assert.assertEquals("2",el7.getText());
		 
		
	   
	
	    driver.quit();
	 
	}
}
