package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookItinerary extends BaseClass{
	public BookItinerary() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	public WebElement Checkbox;

	public WebElement getCheckbox() {
	return Checkbox;
	}
	
	@FindBy(xpath="//input[@name='cancelall']")
	public WebElement Cancel;

	public WebElement getCancel() {
	return Cancel;
	}
	
	@FindBy(id="order_id_text")
	public WebElement Searchid;

	public WebElement getSearchid() {
	return Searchid;
	}
	
	@FindBy(id="search_hotel_id")
	public WebElement Go;

	public WebElement getGo() {
	return Go;
	}
	
	
	@FindBy(xpath="//input[@name='logout']")
	public WebElement Logout;

	public WebElement getLogout() {
	return Logout;
	}
	
	

}
