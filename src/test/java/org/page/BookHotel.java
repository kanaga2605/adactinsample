package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends BaseClass{
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='first_name']")
	public WebElement Firstname;

	public WebElement getFirstname() {
	return Firstname;
	}
	
	@FindBy(xpath="//input[@name='last_name']")
	public WebElement Lastname;

	public WebElement getLastname() {
	return Lastname;
	}
	
	@FindBy(xpath="//textarea[@name='address']")
	public WebElement Address;

	public WebElement getAddress() {
	return Address;
	}
	
	@FindBy(xpath="//input[@name='cc_num']")
	public WebElement Creditno;

	public WebElement getCreditno() {
	return Creditno;
	}
	
	@FindBy(xpath="//select[@name='cc_type']")
	public WebElement Credittype;

	public WebElement getCredittype() {
	return Credittype;
	}
	
	@FindBy(xpath="//select[@name='cc_exp_month']")
	public WebElement Expmonth;

	public WebElement getExpmonth() {
	return Expmonth;
	}
	
	@FindBy(xpath="//select[@name='cc_exp_year']")
	public WebElement Expyear;

	public WebElement getExpyear() {
	return Expyear;
	}
	
	@FindBy(xpath="//input[@name='cc_cvv']")
	public WebElement Cvvnum;

	public WebElement getCvvnum() {
	return Cvvnum;
	}
	

	@FindBy(xpath="//input[@name='book_now']")
	public WebElement Booknow;

	public WebElement getBooknow() {
	return Booknow;
	}
	
	
	
}
