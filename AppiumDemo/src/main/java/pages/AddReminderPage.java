package pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.base.Page;

public class AddReminderPage extends Page{

	public AddReminderPage(AndroidDriver driver) {
		super(driver);
		
	}
	
	@AndroidFindBy(id="Add")
	private AndroidElement addReminderIcon;
	
	@AndroidFindBy(id="edtDescription")
	private AndroidElement editTextDescription;
	
	@AndroidFindBy(id="edtEshop")
	private AndroidElement editTextEshop;
		
	@AndroidFindBy(id="edtPackageID")
	private AndroidElement edtPackageID;
	
	@AndroidFindBy(id="edtAddress")
	private AndroidElement edtAddress;
	

	@AndroidFindBy(id="btnAdd")
	private AndroidElement btnAdd;
	
	@AndroidFindBy(id="datePicker1")
	private AndroidElement datePicker;
	
	@AndroidFindBy(id="timePicker")
	private AndroidElement timePicker;
	
	
	
	
	
	
	
	
	
	
	@AndroidFindBy(id="txtDescription")
	private AndroidElement textViewDescription;
	
	
	
	public void setDescription(String description)
	{
		editTextDescription.clear();
		editTextDescription.sendKeys(description);
	}
	
	public void setEshopName(String eshop)
	{
		editTextEshop.clear();
		editTextEshop.sendKeys(eshop);
	}
	
	public void setPackageID(String id)
	{
		edtPackageID.clear();
		edtPackageID.sendKeys(id);
	}
	
	public void setCollectionAddress(String address)
	{
		edtAddress.clear();
		edtAddress.sendKeys(address);
	}
	
	
	public String getDescription()
	{
		return editTextDescription.getText();
	}
	
	public void clickAddReminderIcon()
	{
		addReminderIcon.click();
	}
	
	public boolean isOnPage()
	{
		if(textViewDescription!=null)
		{
			return true;
		} else {
			return false;
		}
	}
	
	public SuccessPage clickOnAdd()
	{
		btnAdd.click();
		return new SuccessPage(driver);
	}
	
	public void setDatePicker(String day, String monthName,String year)
	{
		
	    List<MobileElement> elements = datePicker.findElementsByClassName("android.widget.EditText");
	    
	    System.out.println(elements.size());
	    
	    
	    //emulator has switch
	    MobileElement dayElement = elements.get(1);
	    
	    MobileElement monthNameElement = elements.get(0);
	    MobileElement yearElement = elements.get(2);
	    
	    
	    dayElement.clear();
	   monthNameElement.clear();
	   yearElement.clear();
	    
	    
	    
	    
	    dayElement.sendKeys(day);
	    monthNameElement.sendKeys(monthName);
	    yearElement.sendKeys(year);
	    
	    
	    
		
	}
	
	public void setTimePicker(String minute, String hour, boolean isAm)
	{
		
	    List<MobileElement> elements = timePicker.findElementsByClassName("android.widget.EditText");
	    
	    //System.out.println(elements.size());
	    
	    MobileElement minuteElement = elements.get(0);
	    MobileElement hourElement = elements.get(1);
	    MobileElement amPmElement = elements.get(2);
	    
	    
	    minuteElement.clear();
	    hourElement.clear();
	    amPmElement.clear();
	  
	    
	   minuteElement.sendKeys(minute);
	   hourElement.sendKeys(hour);
	   if(isAm)
	   {
		   
		   amPmElement.sendKeys("am");
	   } else {
		   amPmElement.sendKeys("pm");
	   }
	   
	    
	    
	    
		
	}
	
	public void slideDown()
	{
		
		Dimension screen = driver.manage().window().getSize();
		int screenX = screen.getWidth();
		int screenY = screen.getHeight();
		
		System.out.println("Screen " + "x=" + Integer.toString(screenX) +  " y=" + Integer.toString(screenY));
		
		
		int x = (int)Math.round(0.85*screenX);
		int yFrom = (int)Math.round(0.56*screenY);
		int yTo = (int)Math.round(0.73*screenY);
		
		System.out.println("After " + "x=" + Integer.toString(x) +  " yTo=" + Integer.toString(yTo));
		
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(x,yTo))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(x,yFrom)).release().perform();
	}
	
	
	
	public String monthToString(int monthh)
	{
		String month="";
		switch(monthh)
		{
		case 1:
			month = "Jan";
			break;
		case 10:
			month = "Oct";
			break;
			
		}
		
		return month;
	}
	
	

	
	

}
