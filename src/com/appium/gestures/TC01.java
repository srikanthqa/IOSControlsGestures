package com.appium.gestures;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC01 {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone Simulator");
		capabilities.setCapability("app","sauce-storage:uicatalog.zip");
		//capabilities.setCapability("udid","5e66e1067a0afea89be55a2d06322a98344023bb");
		//capabilities.setCapability("bundleId","com.srikanth.uicatlog");
		IOSDriver driver=new IOSDriver(new URL("http://qacoders:d0543d50-7b63-4cfc-99fa-f640ef6f135f@ondemand.saucelabs.com:80/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElements(By.className("UIAButton")).get(0).click();
		driver.scrollTo("Progress View").click();
		WebElement defaultProgress=driver.findElements(By.className("UIAProgressIndicator")).get(0);
		while(!defaultProgress.getAttribute("value").equals("100%")){
			//Wait for progress to be 100%
			System.out.println(defaultProgress.getAttribute("value"));
		}
		//System.out.println(driver.findElements(By.className("UIAProgressIndicator")).size());
		//System.out.println(driver.findElement(By.className("UIAProgressIndicator")).getAttribute("value"));
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.className("UIAProgressIndicator")).getAttribute("value"));
		driver.quit();
	}

	//After
	//Upload-> TM Tool
	//TestLodge API
	//setTestCaseStatus(TestCaseName,passed)
}
