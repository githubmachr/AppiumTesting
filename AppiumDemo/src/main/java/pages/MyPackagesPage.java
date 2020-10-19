package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.Page;

public class MyPackagesPage extends Page {

	public MyPackagesPage(AndroidDriver driver) {
		super(driver);
		
	}
	
	
	@AndroidFindBy(id="imgInformation")
	private AndroidElement informationIcon;
	
	
	@AndroidFindBy(id="MyPackages")
	private AndroidElement myPackagesIcon;
	
		
	
	public InformationDialog tapOnPackageInformation()
	{
		informationIcon.click();
		
		return new InformationDialog(driver);
	}
	
	public void tapOnMyPackagesIcon()
	{
		myPackagesIcon.click();
	}
	
	

}
