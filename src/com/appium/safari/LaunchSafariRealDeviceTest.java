package com.appium.safari;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchSafariRealDeviceTest {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Srikanth Vejendla's iPhone");
		capabilities.setCapability("udid","5e66e1067a0afea89be55a2d06322a98344023bb");
		capabilities.setCapability("app","io.appium.SafariLauncher");
		capabilities.setCapability("safariAllowPopups",false);
		capabilities.setCapability("safariIgnoreFraudWarning",true);
		IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		Thread.sleep(5000);
		Set<String> handles=driver.getContextHandles();
		System.out.println(handles);
		for(String handle:handles){
			System.out.println(handle);
			if(handle.contains("WEBVIEW")){
				driver.context(handle);
			}
		}
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.quit();
	}

}



//Install debug proxy
//brew install ios-webkit-debug-proxy

//Turn Web Inspector of Safari
//Settings->Safari->Advanced->Web Inspector(ON)

//Run Proxy
//ios_webkit_debug_proxy -c 5e66e1067a0afea89b5a2d06322a98344023bb:27753



