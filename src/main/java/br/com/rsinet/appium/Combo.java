package br.com.rsinet.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class Combo {
	 AndroidDriver<MobileElement> driver;
	 
	 @Before
		private void inicializarAppium() throws MalformedURLException {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("deviceName", "emulator-5554");
		    desiredCapabilities.setCapability("automationName", "uiautomator2");
		    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/alan.lima/projetos/CursoAppium/src/main/resources/1.1 CTAppium_1_1.apk.apk");

		     URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		     
		     driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}

	@Test
	public void deveInstalarAplicativo() throws MalformedURLException {
		
		
		
		
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	     ///selecionar formulario //class[@att='value']
       //  driver.findElement(By.xpath("//android.widget.TextView[@text'Formulário']")).click();
         List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	     elementosEncontrados.get(1).click();

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     //clicar no combo
	     driver.findElement(MobileBy.AccessibilityId("console")).click();
	     
	     
	     //selecionar a opçao desejada
	     driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	     
	     //verificar opcao selecionada
	       String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	        Assert.assertEquals("Nintendo Switch", text);
	    driver.quit();
	 
	}
	@Test
public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		
		
		
	  
	     //Selecionar Formulario
	     List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	     elementosEncontrados.get(1).click();

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     //clicar no combo
	     driver.findElement(MobileBy.AccessibilityId("console")).click();
	     
	     
	     //selecionar a opçao desejada
	     driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	     
	     //verificar opcao selecionada
	        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	        Assert.assertEquals("Nintendo Switch", text);
	        
	     //Verificar status dos elementos
	        
	        MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	        MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	        check.getAttribute("checked");
	        Assert.assertTrue(check.getAttribute("checked").equals("false"));
	        switc.getAttribute("checked");
	        Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	        
	        
	     // clicar nos elementos
	        check.click();
	        switc.click();
	        
	    //verificar estados alterados
	    
	        Assert.assertTrue(check.getAttribute("checked").equals("true"));
	        
	        Assert.assertTrue(switc.getAttribute("checked").equals("false"));
	        
	    //fechar aplicação
	    driver.quit();
	 
	}
	
	
	
	@Test
	public void salvarCamposEValidar() throws MalformedURLException {
		
	     
	     //clicar no formulario
	    List<MobileElement> elementosClasse = driver.findElements(By.className("android.widget.TextView"));
		elementosClasse.get(1).click();
		
		///preencher campos
		MobileElement cmpNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		cmpNome.sendKeys("Alan");
		
		 driver.findElement(MobileBy.AccessibilityId("console")).click();
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		 
		 
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		
		MobileElement check = driver.findElement(MobileBy.AccessibilityId("check"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		
		
		Assert.assertTrue(check.getAttribute("checked").equals("true"));
		Assert.assertTrue(switc.getAttribute("checked").equals("false"));
		
		
		//salvar
		
		 driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		
		//validar
		 String text = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Alan']")).getAttribute("text");
		 Assert.assertTrue(text.equals("Nome: Alan"));
//        List<MobileElement> combo = driver.findElements(By.className("android.widget.TextView"));
//        String attribute = combo.get(1).getAttribute("text");
		 
        MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        Assert.assertTrue(combo.getText().endsWith("ps4"));
        
         MobileElement switchconf = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
      Assert.assertTrue(switchconf.getText().endsWith("Off"));
      
      MobileElement checkBox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
      Assert.assertTrue(checkBox.getText().endsWith("Marcado"));
        
      
		
		
		 
		
		
	
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
