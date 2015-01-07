package com.appium.gestures;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSDatePickerTest {
	
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
		driver.scrollTo("Date Picker").click();
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("values"));
		driver.findElements(By.className("UIAPickerWheel")).get(0).sendKeys("Jan 9");
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(1).getAttribute("value"));
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(1).getAttribute("values"));
		driver.findElements(By.className("UIAPickerWheel")).get(1).sendKeys("3");
		driver.findElements(By.className("UIAPickerWheel")).get(2).sendKeys("10");
		driver.findElements(By.className("UIAPickerWheel")).get(3).sendKeys("PM");
		Thread.sleep(4000);
		driver.quit();
	}

}







