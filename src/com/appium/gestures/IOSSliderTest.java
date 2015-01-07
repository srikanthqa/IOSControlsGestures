package com.appium.gestures;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSSliderTest {
	
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
		driver.scrollTo("Sliders").click();
		WebElement slider=driver.findElements(By.className("UIASlider")).get(0);
//		while(!slider.getAttribute("value").equals("91%")){
//			slider.sendKeys("0.9"); //Sendkeys on the slider is not very accurate, it is the approx value
//			System.out.println(slider.getAttribute("value"));
//		}
		int percent = 0;
		if(!(percent > 15 && percent < 25)){
			slider.sendKeys("0.20");
			String strPercent=slider.getAttribute("value");
			String[] extractPercent=strPercent.split("%");
			percent=Integer.parseInt(extractPercent[0]);
			System.out.println(slider.getAttribute("value"));
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		Thread.sleep(4000);
		driver.quit();
	}

}








