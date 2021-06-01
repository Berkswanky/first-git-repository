package appModules;

import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * Author name- Harsh Mishra (908330)
 * Date-20/04/2021
 * Description- This class contains the workflow of the project using the help of locators defined in  Alaska cruises class.
 */
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectModel.Alaskacruises;
import utilities.BaseClass;
import utilities.DriverSetup;
import utilities.Excelutilities;

public class Testmodules extends BaseClass {

	public Testmodules(WebDriver driver, WebElement element) {
		super(driver, element);
		// TODO Auto-generated constructor stub
	}
	
	

	static WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 150);
	static String[] result;
	Alaskacruises ac = new Alaskacruises();
	static String screenshotpath = "D:\\WORKSPACE\\MiniProject-Alaska-Cruises\\Screenshots";

	// to scroll down the page and find 'Holiday Cruises'
	public static void scrolldown() {
		wait.until(ExpectedConditions.visibilityOf(Alaskacruises.closebtn()));
		Alaskacruises.closebtn().click();

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Alaskacruises.holidayCruises());
			if (Alaskacruises.holidayCruises().isDisplayed()) {
				System.setOut(new PrintStream(new FileOutputStream("D:\\WORKSPACE\\MiniProject-Alaska-Cruises\\testResult\\output.txt")));
				System.out.println("Holiday Cruises is displayed");
				Excelutilities.setCellData("PASS", 1, 1);
				DriverSetup.takeScreenShot(screenshotpath + "\\test1.png");
				
			} else {
				System.setOut(new PrintStream(new FileOutputStream("D:\\WORKSPACE\\MiniProject-Alaska-Cruises\\testResult\\output.txt")));
				System.out.println("Holiday Cruises is not displayed");
				Excelutilities.setCellData("FAIL", 1, 1);
				DriverSetup.takeScreenShot(screenshotpath + "\\test1.png");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// To click on Holiday cruises
	public static void ElementClick() {
		Alaskacruises.holidayCruises().click();
	}

	// To search for search icon click it and send the input
	public static void Searchicon() throws Exception {
		Alaskacruises.searchicon().click();
		String searchinp = Excelutilities.getCellData(2, 0);
		Alaskacruises.searchinput().sendKeys(searchinp);
		Alaskacruises.searchinput().sendKeys(Keys.ENTER);
		DriverSetup.takeScreenShot(screenshotpath + "\\test2.png");
	}

	// to get the total search result count and compare them if they are greater than 30000
	public static void getTotalSearchResults() throws Exception {
		Alaskacruises.searchresult();
		String result = Alaskacruises.searchresult().getText().split(" ")[1];
		System.out.println(result);
		Integer count = Integer.parseInt(result.replaceAll(",", ""));
		if (count >= 300000) {
			System.out.println("search results are more than 300000");
			Excelutilities.setCellData("PASS", 2, 1);
			DriverSetup.takeScreenShot(screenshotpath + "\\test3.png");
		} else {
			System.out.println("search results are smaller");
			Excelutilities.setCellData("FAIL", 2, 1);
			DriverSetup.takeScreenShot(screenshotpath + "\\test3.png");
		}

		wait.until(ExpectedConditions.elementToBeClickable(Alaskacruises.deck()));
	}

	// to search for Deck plans
	public static void deck() {
		Alaskacruises.deck().click();
	}

	// To verify the presence of  deck image
	public static void getdeckimage() {
		try {
			 
			
			if(Alaskacruises.deckimage()!=null) {
				System.out.println("Deck image is displayed");
				Excelutilities.setCellData("PASS", 3, 1);
				DriverSetup.takeScreenShot(screenshotpath + "\\test4.png");
			}
			else {
				System.out.println("Deck image is not displayed");
				Excelutilities.setCellData("FAIL", 3, 1);
				DriverSetup.takeScreenShot(screenshotpath + "\\test4.png");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
	}

	// To select from drop down of deck options
	public static void selectdropdown() {
		Alaskacruises.deckdropdown();
		Select sel = new Select(Alaskacruises.deckdropdown());
		sel.selectByVisibleText("Deck Eight");
		DriverSetup.takeScreenShot(screenshotpath + "\\test5.png");
		wait.until(ExpectedConditions.visibilityOf(Alaskacruises.royalsuite()));
	}

	// To search for Royal suite if present or not
	public static void royalsuite() {
		try {
			if (Alaskacruises.royalsuite().isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", Alaskacruises.royalsuite());
				System.out.println("Royal suite - 1 Bedroom is displayed");
				Excelutilities.setCellData("PASS", 4, 1);
				DriverSetup.takeScreenShot(screenshotpath + "\\test6.png");
			} else {
				
				System.out.println("Royal suite - 1 Bedroom is not displayed");
				Excelutilities.setCellData("FAIL", 4, 1);
				DriverSetup.takeScreenShot(screenshotpath + "\\test6.png");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
