package com.mobile.appium;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HybridAppTest {
	
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.2");
		capabilities.setCapability("deviceName","SAMSUNG-SM-G900A");
		capabilities.setCapability("appActivity","HomeScreenActivity");
		capabilities.setCapability("appPackage","io.selendroid.testapp");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		Thread.sleep(5000);
		Set<String> contextnames=driver.getContextHandles();
		for(String contextname:contextnames){
			System.out.println(contextnames);
		}
		driver.quit();
	}

}
