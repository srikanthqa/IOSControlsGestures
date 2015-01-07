package com.mobile.appium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchIOSApp {
	
	public static void main(String[] args) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("automation","Appium");
		capabilities.setCapability("platformName","iOS");
		capabilities.setCapability("platformVersion","8.1");
		capabilities.setCapability("deviceName","Srikanth Vejendla's iPhone");
		capabilities.setCapability("udid","5e66e1067a0afea89be55a2d06322a98344023bb");
		capabilities.setCapability("bundleId","com.srikanth.plainnote");
		IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Dimension dimension=driver.manage().window().getSize();
		System.out.println(dimension.getWidth());
		System.out.println(dimension.getHeight());
		MobileElement element=(MobileElement)driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"));
		//element.tap(1, 2000);
		element.swipe(SwipeElementDirection.RIGHT,3000);
		
		////UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]
		//414 w, 736 h
		
		
		//driver.SendKeyEvent will send the key , for sending the keys we can use IOSKeyCode,AndroidKeyCode
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
