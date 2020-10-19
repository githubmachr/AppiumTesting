package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.Page;

public class InformationDialog extends Page {

	public InformationDialog(AndroidDriver driver) {
		super(driver);
		
	}
	
	@AndroidFindBy(id="infoDescription")
	private AndroidElement txtDescription;
	
	@AndroidFindBy(id="infoEshop")
	private AndroidElement infoEshop;
	
	@AndroidFindBy(id="infoAddress")
	private AndroidElement infoAddress;
	
	@AndroidFindBy(id="infoDeliveryDate")
	private AndroidElement infoDeliveryDate;
	
	@AndroidFindBy(id="infoRemindAt")
	private AndroidElement infoRemindAt;
	
	
	public String getDescription()
	{
		return txtDescription.getText();
	}
	
	public String getEshop()
	{
		return infoEshop.getText();
	}
	
	public String getAddress()
	{
		return infoAddress.getText();
	}
	
	
	public String getDeliveryDate()
	{
		return infoDeliveryDate.getText();
	}
	
	public String getRemindAt()
	{
		return  infoRemindAt.getText();
	}
	
	
	
	
	

}
