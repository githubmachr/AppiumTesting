package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.Page;

public class SuccessPage extends Page {

	public SuccessPage(AndroidDriver driver) {
		super(driver);
		
	}
	
	
	@AndroidFindBy(id="txtSuccess")
	private AndroidElement txtSuccess;
	
	
	
	public boolean isOnPage()
	{
		if(txtSuccess!=null && txtSuccess.isDisplayed())
		{
			return true;
		} else {
			return false;
		}
	}
	
	
	
	

}
