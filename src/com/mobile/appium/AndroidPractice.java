package com.mobile.appium;

import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class AndroidPractice {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"SAMSUNG-SM-G900A");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,"HomeScreenActivity");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"io.selendroid.testapp");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).click();
		//Sending Key Codes, We could use the metakeys
		
		System.out.println(MobileCommand.CURRENT_ACTIVITY);
		//Handle Popup
		driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton")).click();
		//Alert dismiss=driver.switchTo().alert();
		//dismiss.accept();
		
//		WebDriverWait wait=new WebDriverWait(driver,20000);
//		wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println("Alert is present");
		//System.out.println("Alert is present");
//		Set<String> windows=driver.getWindowHandles();
//		for(String window:windows){
//			System.out.println(window);
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
