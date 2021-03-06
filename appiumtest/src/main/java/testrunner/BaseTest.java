package testrunner;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.UtilityTests;

public class BaseTest {

	UtilityTests ut = new UtilityTests();
	public static RemoteWebDriver driver;
	
	@BeforeMethod
	public void setAppium(){
		try
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			setDesiredCapabilitiesForAndroid(cap);
			BaseTest.driver = new RemoteWebDriver(new URL(ut.loadpropertyfile("appium.server.url")), cap);
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	protected void setDesiredCapabilitiesForAndroid(DesiredCapabilities desiredCapabilities) {
		  String PLATFORM_NAME = ut.loadpropertyfile("android.platform");
		  String PLATFORM_VERSION = ut.loadpropertyfile("android.platform.version");
		  String BROWSER_NAME = ut.loadpropertyfile("android.browser.name");
		  String DEVICE_NAME = ut.loadpropertyfile("android.device.name");
		  String UDID = ut.loadpropertyfile("android.udid");
		  String Chrome_Path = ut.loadpropertyfile("chromepath")+"//chromedriver.exe";
		  desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		  desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		  desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		  desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		  desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BROWSER_NAME);
		  desiredCapabilities.setCapability(MobileCapabilityType.UDID, UDID);
		  desiredCapabilities.setCapability("chromedriverExecutable",Chrome_Path);
		  desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		  desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	}
	
	@AfterMethod
	public void teardown(){
		BaseTest.driver.quit();
	}
	
	public void pressKey(int code) throws AWTException{
		Robot r = new Robot();
		r.keyPress(code);
		r.keyRelease(code);
	}
}
