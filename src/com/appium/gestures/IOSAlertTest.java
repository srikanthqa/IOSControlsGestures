package com.appium.gestures;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSAlertTest {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Srikanth Vejendla's iPhone");
		capabilities.setCapability("udid","5e66e1067a0afea89be55a2d06322a98344023bb");
		capabilities.setCapability("bundleId","com.srikanth.uicatlog");
		IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElements(By.className("UIAButton")).get(0).click();
		driver.scrollTo("Alert Controller").click();
		driver.findElement(By.name("Simple")).click();
		//Accepting the alert
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		//Verify the alert title, then click on OK button
		if(driver.findElement(By.className("UIAAlert")).getAttribute("label").equals("A Short Title Is Best")){
			driver.findElement(By.name("OK")).click();
		}
		Thread.sleep(5000);
		driver.quit();
	}

}








