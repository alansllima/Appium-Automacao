package br.com.rsinet.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class InstalarAplicativo {
	
	@Test
	public void deveInstalarAplicativo() throws MalformedURLException {
		
		
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	  //  desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	 //   desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/alan.lima/projetos/CursoAppium/src/main/resources/1.1 CTAppium_1_1.apk.apk");

	     URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
	     
	    AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	     ///selecionar formulario
	     
	     List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	     for(MobileElement elemento : elementosEncontrados) {
//	    	 System.out.println(elemento.getText());
//	    	 
//	     }
	     elementosEncontrados.get(1).click();
	     
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     
	     //escrever nome
	     
	     MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	     campoNome.sendKeys("Alan");
	     
	     // checar nome escrito
	     String text = campoNome.getText();
	     Assert.assertEquals("Alan", text);
	       
	    driver.quit();
	 
	}

}
