package com.appium.saucelabs;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSOnSauce {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("appiumVersion", "1.3.4");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("deviceName", "iPhone Simulator");
		caps.setCapability("fullReset",true);
		caps.setCapability("app","sauce-storage:uc.zip");
		IOSDriver driver=new IOSDriver(new URL("http://automation7:07106068-d55d-40bc-b4f6-5f7ccab7d6c9@ondemand.saucelabs.com:80/wd/hub"),caps);
		driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
		driver.findElements(By.className("UIAButton")).get(0).click();
		driver.scrollTo("Page Control").click();
		driver.findElement(By.className("UIAPageIndicator")).sendKeys("5");
		Thread.sleep(4000);
		driver.quit();
	}

}
