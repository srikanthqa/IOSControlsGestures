package com.appium.java;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartAppium {
	
	public static void startAppiumonMac() throws Exception{
		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--no-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
		Thread.sleep(3000);
	}
	
	public static void stopAppiumOnMac() throws Exception{
		Runtime.getRuntime().exec("killall node");
	}
	
	public static void main(String[] args) throws Exception{
		stopAppiumOnMac();
		startAppiumonMac();
		DesiredCapabilities caps=new DesiredCapabilities();
	    caps.setCapability("browserName", "");
		caps.setCapability("platformVersion", "8.1");
		caps.setCapability("appiumVersion", "1.3.4");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("deviceName", "iPhone Simulator");
		caps.setCapability("fullReset",true);
		caps.setCapability("app","/Users/Srikanth/Desktop/PlainNote.app");
	    IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.quit();
	    stopAppiumOnMac();
	}

}
