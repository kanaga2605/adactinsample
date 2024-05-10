package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver; 
	public void getDriver(String browserType) {
		
		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
		System.err.println("Invalid Browser Type");
			break;
		}		
	}
	public void accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public void getUrl(String url) {
	    driver.get(url);
	}
	public void winMax() {
        driver.manage().window().maximize();
	}
	public void textSendByJava(WebElement element,String KeysToSend) {
        element.sendKeys(KeysToSend);
	}
	public void textSendByJS(WebElement element,String KeysToSend) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value',"+KeysToSend+")",element);
	}
	public void ScreenCapture(String name) throws IOException {
	     TakesScreenshot ts = (TakesScreenshot)driver;
	     File source = ts.getScreenshotAs(OutputType.FILE);
	     File target = new File("C:\\Users\\Admin\\OneDrive\\Pictures\\framewrk ss"+name+".jpeg");
	     FileUtils.copyFile(source, target);
	}
	public void sleep(long millis) throws InterruptedException {
         Thread.sleep(millis);
	}
	public void SelectByValue(WebElement element,String value) {
         Select s = new Select(element);
         s.selectByValue(value);
	}
	public String readExcel(int rownum, int cellnum) throws IOException {
		File file = new File("C:\\Users\\Admin\\OneDrive\\Pictures\\framewrk xl\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = (Cell) row.getCell(cellnum);
		CellType cellType = cell.getCellType();
	    String value = null;
		
	    switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
			
		case NUMERIC:
			if(DateUtil.isCellDateFormatted((org.apache.poi.ss.usermodel.Cell) cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
			value = simple.format(dateCellValue);
			}
		else {
			double numericCellValue = cell.getNumericCellValue();
		    BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
		    value = valueOf.toString();
			}	
        break;
        
		default:
			System.out.println("Invalid_Cell_Type");
			break;
		}
	    return value;
	
	}
	
}
 