package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass{
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='radiobutton_0']")
	private WebElement select;

	public WebElement getSelect() {
	return select;
	}
	
	@FindBy(xpath="//input[@name='continue']")
	private WebElement contin;

	public WebElement getContin() {
	return contin;
	}
	
	
	
}
