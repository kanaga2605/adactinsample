package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookConfirm extends BaseClass {
	public BookConfirm() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='my_itinerary']")
	public WebElement Itinerary;

	public WebElement getItinerary() {
	return Itinerary;
	}

}
