package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Utility {
	
	
	
	public static AndroidDriver getEmulatorDriver()
	{
		
           return Utility.getAndroidDriver("emulator-5554","Android","9","127.0.0.1","4555","/home/master/Downloads/packagereminder.apk","com.master.packagereminder",
        		   "com.master.packagereminder.ui.MainActivity","UiAutomator2");
	
	
	
	}
	/*
	 * On error returns null
	 */
	
	public static AndroidDriver getRedmi7Driver()
	{
		
           return Utility.getAndroidDriver("Redmi","Android","10","127.0.0.1","4555","/home/master/Downloads/packagereminder.apk","com.master.packagereminder",
        		   "com.master.packagereminder.ui.MainActivity","UiAutomator2");
		
		
			//DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
			//caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			
			//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
			//caps.setCapability("appPackage", "io.appium.android.apis");
			//caps.setCapability("app", "/home/master/Downloads/ApiDemos-debug.apk");
			//caps.setCapability("app", "/home/master/Downloads/packagereminder.apk");
			//caps.setCapability("appPackage", "com.master.packagereminder");
			//caps.setCapability("appActivity", "com.master.packagereminder.ui.MainActivity");
			//caps.setCapability("automationName", "UiAutomator2");
			
			
			/*
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_28");
			caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			*/
			
			
			//caps.setCapability("appPackage", "simple.batttery.alarm");
			//caps.setCapability("appActivity", "simple.battery.alarm.main");
			
			//caps.setCapability("appPackage", "com.master.packagereminder");
			//caps.setCapability("appActivity", "com.master.packagereminder.ui.MainActivity");
			
			
			//URL url = new URL("http://127.0.0.1:4555/wd/hub");
			
			// driver = new AndroidDriver<MobileElement>(url,caps);
			//driver = new AndroidDriver<MobileElement>(url,caps);
		}
		
		
	
	
	/*
	 * On error returns null
	 */
	public static AndroidDriver getAndroidDriver(String deviceName,String platformName,String platformVersion,String ipAddess, String port,String app,String appPackage, String appActivity, String automationName)
	{
		AndroidDriver driver = null;
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			caps.setCapability(CapabilityType.PLATFORM_NAME, platformName);
			//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			//caps.setCapability("appPackage", "io.appium.android.apis");
			//caps.setCapability("app", "/home/master/Downloads/ApiDemos-debug.apk");
			if(app!=null)
			{
			caps.setCapability("app", app);
			}
			
			if(appPackage!=null)
			{
			caps.setCapability("appPackage", appPackage);
			}
			
			if(appActivity!=null)
			{
			caps.setCapability("appActivity", appActivity);
			}
			if(automationName!=null)
			{
			caps.setCapability("automationName", automationName);
			}
			
			
			
			
			URL url = new URL("http://" + ipAddess + ":" + port + "/wd/hub");
			
			 driver = new AndroidDriver<MobileElement>(url,caps);
			
			 return driver;
		}catch (Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}
	}
	
	
	private static String getUDID()
	{
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash","-c","adb devices");
		try {
			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				System.exit(0);
				
				return output.toString();
			} else {
				return "";
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	public static void setDatePicker(AndroidDriver driver, String day, String monthName,String year)
	{
		List<WebElement> datePickerBox = driver.findElements(By.xpath("//*[@class='android.widget.EditText']"));
		
		

		WebElement monthElement = datePickerBox.get(0);
		WebElement dayElement = datePickerBox.get(1);
		WebElement yearElement = datePickerBox.get(2);

		monthElement.click();
		monthElement.sendKeys(monthName);

		dayElement.click();
		dayElement.sendKeys(day);

		yearElement.click();
		yearElement.sendKeys(year);
	}

}
