package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.AddReminderPage;
import pages.InformationDialog;
import pages.MyPackagesPage;
import pages.SuccessPage;

public class PackageReminderAppTests {
	
	private AndroidDriver<MobileElement> driver;
	
	
	@BeforeMethod
	public void setup()
	{
		
		
		 driver = utilities.Utility.getEmulatorDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		 
		 //emulator-5554
		
	}
	
	@AfterMethod
	
	public void teardown()
	{
		System.out.println("Teardown started");
		if(driver!=null)
		{
			if(driver instanceof AppiumDriver)
			{
			driver.quit();
			}
		}
	}
	
	
	//@Test(priority=2)
	public void landOnAddPackageFragmentTest()
	{
		
		System.out.println("landOnAddPackageFragmentTest started");
		AddReminderPage addReminderPage = new AddReminderPage(driver);
		addReminderPage.clickAddReminderIcon();
		
		Assert.assertEquals(addReminderPage.isOnPage(), true);
		//Assert.assertEquals(informationDialog.getDeliveryDate(), day+"."+monthOut+"."+year);
		
		System.out.println("landOnAddPackageFragmentTest finished");
	}
	
	
	
	//@Test(priority=1)
	public void addReminderTest() throws Exception
	{
		System.out.println("AddReminderTest started");
		
		
		AddReminderPage addReminderPage = new AddReminderPage(driver);
		addReminderPage.clickAddReminderIcon();
						
		addReminderPage.setDescription("Mobil");
		addReminderPage.setEshopName("Alza");
		addReminderPage.setPackageID("92384374754954");
		addReminderPage.setCollectionAddress("Stodulky, Praha");
		addReminderPage.setDatePicker("24", "Dec", "2020");
		addReminderPage.setTimePicker("8", "10", true);
	
				
		
		addReminderPage.slideDown();
	
		
		
		
		SuccessPage successPage = addReminderPage.clickOnAdd();
		
		Assert.assertEquals(successPage.isOnPage(), true);
		
		Thread.sleep(1000);
		System.out.println("AddReminderTest finished");
		
		
		
		
	}
	
	
	@Test(priority=1)
	public void addReminderTestCheckMyPackages() throws Exception
	{
		System.out.println("addReminderTestCheckMyPackages started");
		
		
		AddReminderPage addReminderPage = new AddReminderPage(driver);
		
		addReminderPage.clickAddReminderIcon();
		
		
		
	    String description = "Mobil";
	    String eshop = "Alza";
	    String packageid = "92384374754954";
	    String address = "Stodulky, Praha";
	    
	    
	    //Date must be today or in future otherwise error
	    String day= "25";
	    String month = "Nov";
	    String monthOut = "11";
	    String year = "2020";
	    String hour = "8";
	    String minute = "10";
	    boolean isAm = true;
	    
						
		addReminderPage.setDescription(description);
		addReminderPage.setEshopName(eshop);
		addReminderPage.setPackageID(packageid);
		addReminderPage.setCollectionAddress(address);
		addReminderPage.setDatePicker(day, month, year);
		addReminderPage.setTimePicker(hour, minute, true);
	
				
		
		addReminderPage.slideDown();
	
		
		
		
		SuccessPage successPage = addReminderPage.clickOnAdd();
		
		Assert.assertEquals(successPage.isOnPage(), true);
		
		//wait for the snackbar to disappera //TODO implement wait for element present
		Thread.sleep(3000);
		
		
		
		
		MyPackagesPage myPackagesPage = new MyPackagesPage(driver);
		myPackagesPage.tapOnMyPackagesIcon();
		
		
		InformationDialog informationDialog = myPackagesPage.tapOnPackageInformation();
		
		
		Thread.sleep(5000);
		
		
		Assert.assertEquals(informationDialog.getDescription(), description);
		Assert.assertEquals(informationDialog.getEshop(), eshop);
		Assert.assertEquals(informationDialog.getAddress(), address);
		
		
		System.out.print(informationDialog.getDeliveryDate());
		
		
		System.out.println("addReminderTestCheckMyPackages finished");
		
		
		
		
	}

	
	
	

}
