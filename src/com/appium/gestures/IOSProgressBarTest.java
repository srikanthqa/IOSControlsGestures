package com.appium.gestures;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSProgressBarTest {
	
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

}
