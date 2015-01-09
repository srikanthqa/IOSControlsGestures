package com.appium.saucelabs;

import io.appium.java_client.ios.IOSDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class PlainNoteOnsauce {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("appiumVersion", "1.3.4");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("deviceName", "iPhone Simulator");
		caps.setCapability("fullReset",true);
		caps.setCapability("app","sauce-storage:pn.zip");
		IOSDriver driver=new IOSDriver(new URL("http://automation7:07106068-d55d-40bc-b4f6-5f7ccab7d6c9@ondemand.saucelabs.com:80/wd/hub"),caps);
		driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.quit();
	}

}
