package com.mobile.appium;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchTwitter {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4");
		//capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("deviceName","SAMSUNG-SM-G900A");
		//capabilities.setCapability("app","com.twitter.android-5.39.0-APK4Fun.com.apk");
		//capabilities.setCapability("app","http://www51.zippyshare.com/d/43788753/46634/com.twitter.android-5.39.0-APK4Fun.com.apk");
		//capabilities.setCapability("app","http://search.maven.org/remotecontent?filepath=io/selendroid/selendroid-test-app/0.12.0/selendroid-test-app-0.12.0.apk");
		//http://www51.zippyshare.com/d/43788753/46634/com.twitter.android-5.39.0-APK4Fun.com.apk
		capabilities.setCapability("appActivity","MainActivity");
		capabilities.setCapability("appPackage","com.twitter.android");
		//capabilities.setCapability("name","SauceLabs TestRun");
		//AndroidDriver driver=new AndroidDriver(new URL("http://qacoders:d0543d50-7b63-4cfc-99fa-f640ef6f135f@ondemand.saucelabs.com:80/wd/hub"),capabilities);
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("com.twitter.android:id/log_in")).click();
		driver.findElement(By.id("com.twitter.android:id/login_identifier")).sendKeys("mobile.automation7@gmail.com");
		driver.findElement(By.id("com.twitter.android:id/login_password")).sendKeys("training123");
		driver.findElement(By.id("com.twitter.android:id/login_login")).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
