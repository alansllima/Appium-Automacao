package br.com.rsinet.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.rsinet.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RefatorandoCodigo {
	
 AndroidDriver<MobileElement> driver;

 
	 
	 @Before
		public void inicializarAppium() throws MalformedURLException {
			
		    driver= DriverFactory.getDriver(); 
		   
		        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		     
	   
			
		}

	@Test
	public void deveInstalarAplicativo() throws MalformedURLException {
		
		
		
		
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     //clicar no combo
	     driver.findElement(MobileBy.AccessibilityId("console")).click();
	     
	     
	     //selecionar a opçao desejada
	     driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	     
	     //verificar opcao selecionada
	       String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	      assertEquals("Nintendo Switch", text);
	    
	 
	}
	@Test
public void deveInteragirSwitchCheckBox() throws MalformedURLException {
					  
	   

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     //clicar no combo
	     driver.findElement(MobileBy.AccessibilityId("console")).click();
	     
	     
	     //selecionar a opçao desejada
	     driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	     
	     //verificar opcao selecionada
	        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	        assertEquals("Nintendo Switch", text);
	        
	     //Verificar status dos elementos
	        
	        MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	        MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	        check.getAttribute("checked");
	        assertTrue(check.getAttribute("checked").equals("false"));
	        switc.getAttribute("checked");
	        assertTrue(switc.getAttribute("checked").equals("true"));
	        
	        
	     // clicar nos elementos
	        check.click();
	        switc.click();
	        
	    //verificar estados alterados
	    
	        assertTrue(check.getAttribute("checked").equals("true"));
	        
	        assertTrue(switc.getAttribute("checked").equals("false"));
	        
	    //fechar aplicação
	 
	 
	}
	
	@Test
	public void salvarCamposEValidar() throws MalformedURLException {
		
	     
	 
		
		///preencher campos
		MobileElement cmpNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		cmpNome.sendKeys("Alan");
		
		 driver.findElement(MobileBy.AccessibilityId("console")).click();
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		 
		 
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		
		MobileElement check = driver.findElement(MobileBy.AccessibilityId("check"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		
		
		assertTrue(check.getAttribute("checked").equals("true"));
		assertTrue(switc.getAttribute("checked").equals("false"));
		
		
		//salvar
		
		 driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		
		//validar
		 String text = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Alan']")).getAttribute("text");
		 assertTrue(text.equals("Nome: Alan"));
//        List<MobileElement> combo = driver.findElements(By.className("android.widget.TextView"));
//        String attribute = combo.get(1).getAttribute("text");
		 
        MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        assertTrue(combo.getText().endsWith("ps4"));
        
         MobileElement switchconf = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
      assertTrue(switchconf.getText().endsWith("Off"));
      
      MobileElement checkBox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
      assertTrue(checkBox.getText().endsWith("Marcado"));
        

    }
	
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
}
