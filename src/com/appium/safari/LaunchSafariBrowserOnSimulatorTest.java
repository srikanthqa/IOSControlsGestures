package com.appium.safari;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchSafariBrowserOnSimulatorTest {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		//capabilities.setCapability("appiumVersion","1.2.4");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone Simulator");
		//capabilities.setCapability("udid","5e66e1067a0afea89be55a2d06322a98344023bb");
		//capabilities.setCapability("app", "/Users/Srikanth/Library/Developer/Xcode/DerivedData/SafariLauncher-bmvpozvewokomzgqzjthoojztxqx/Build/Products/Debug-iphoneos/SafariLauncher.app");
		IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://google.com");
		Thread.sleep(5000);
		driver.quit();
	}

}
