package org.excute;

import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.page.BookConfirm;
import org.page.BookHotel;
import org.page.BookItinerary;
import org.page.LoginPage;
import org.page.SearchHotelPage;
import org.page.SelectHotelPage;

public class TestScript extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass b = new BaseClass();
		
		b.getDriver(b.readExcel(4, 7));
		b.getUrl(b.readExcel(4, 3));
		b.winMax();
		b.ScreenCapture("Home");

		LoginPage l = new LoginPage();
		l.getUsername().sendKeys(b.readExcel(4, 0));
		l.getPassword().sendKeys(b.readExcel(4, 1));
		l.getLogin().click();

		SearchHotelPage s = new SearchHotelPage();
		WebElement location = s.getLocation();
		b.SelectByValue(location, b.readExcel(4, 2));
		WebElement hotels = s.getHotels();
		b.SelectByValue(hotels, b.readExcel(4, 4));
		WebElement roomType = s.getRoomType();
		b.SelectByValue(roomType, b.readExcel(4, 5));
		s.getSubmit().click();

		SelectHotelPage s1 = new SelectHotelPage();
		s1.getSelect().click();
		s1.getContin().click();

		BookHotel s2 = new BookHotel();
        s2.getFirstname().sendKeys(b.readExcel(10, 0));
        s2.getLastname().sendKeys(b.readExcel(10, 1));
        s2.getAddress().sendKeys(b.readExcel(10, 2));
        s2.getCreditno().sendKeys(b.readExcel(10, 3));
        s2.getCredittype().sendKeys(b.readExcel(10, 4));
        s2.getExpmonth().sendKeys(b.readExcel(10, 5));
        s2.getExpyear().sendKeys(b.readExcel(10, 6));
        s2.getCvvnum().sendKeys(b.readExcel(10, 7));
        s2.getBooknow().click();
		b.sleep(5000);

		BookConfirm s3 = new BookConfirm();
		s3.getItinerary().click();

		BookItinerary s4 = new BookItinerary();
		s4.getCheckbox().click();
		s4.getCancel().click();
        Alert a = driver.switchTo().alert();
		b.accept();
		s4.getSearchid().sendKeys(b.readExcel(10, 8));
		s4.getGo().click();
		s4.getLogout().click();


	}

}
