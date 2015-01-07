package com.mobile.appium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;



public class LaunchApp {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4");
		capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("app","sauce-storage:selendroid-test-app-0.12.0.apk");
		//capabilities.setCapability("app","http://search.maven.org/remotecontent?filepath=io/selendroid/selendroid-test-app/0.12.0/selendroid-test-app-0.12.0.apk");
		//http://www51.zippyshare.com/d/43788753/46634/com.twitter.android-5.39.0-APK4Fun.com.apk
		capabilities.setCapability("appActivity","HomeScreenActivity");
		capabilities.setCapability("appPackage","io.selendroid.testapp");
		capabilities.setCapability("name","SauceLabs TestRun");
		AndroidDriver driver=new AndroidDriver(new URL("http://qacoders:d0543d50-7b63-4cfc-99fa-f640ef6f135f@ondemand.saucelabs.com:80/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Appium Automation");
		driver.quit();
	}

}
