package com.mobile.appium;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchHybridApp {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.2");
		capabilities.setCapability("deviceName","SAMSUNG-SM-G900A");
		//capabilities.setCapability("app","sauce-storage:selendroid-test-app-0.12.0.apk");
		//capabilities.setCapability("app","http://search.maven.org/remotecontent?filepath=io/selendroid/selendroid-test-app/0.12.0/selendroid-test-app-0.12.0.apk");
		//http://www51.zippyshare.com/d/43788753/46634/com.twitter.android-5.39.0-APK4Fun.com.apk
		capabilities.setCapability("appActivity","activities.login.SplashScreenActivity");
		capabilities.setCapability("appPackage","com.box.android");
		//capabilities.setCapability("name","SauceLabs TestRun");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Appium Automation");
		
		driver.findElement(By.id("com.box.android:id/loginButton")).click();
		Thread.sleep(3000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").description(\"Email Address\")").sendKeys("Hoola");
		driver.quit();
	}

}
