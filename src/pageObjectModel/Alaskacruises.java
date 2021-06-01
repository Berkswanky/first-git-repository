package pageObjectModel;
/*
 * Author name- Harsh Mishra (908330)
 * Date- 20/04/2021
 * Description- This class is POM for the Alaska cruises website
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BaseClass;

public class Alaskacruises extends BaseClass{

	public Alaskacruises() {
		super(driver, element);
		// TODO Auto-generated constructor stub
	}
	//describing the web elements according to DOM structure
	static By holidayCruises=By.linkText("Holiday Cruises");//describing the holiday cruises web element according to DOM structure
	static By searchicon=By.xpath("//*[@id='rciSearchHeaderIcon']");//describing the Search button web element according to DOM structure
	static By searchinput=By.id("rciSearchInput");//describing the search input textbox web element according to DOM structure
	static By searchresult=By.xpath("//*[@id='siteSearchApp']/div[1]/div/div[2]/div");//describing the search result web element according to DOM structure
	static By deck= By.linkText("Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises");//describing the cruise to be selected web element according to DOM structure
	static By deckimage=By.xpath("//img[@class='deck-image']");//describing the deck image web element according to DOM structure
	static By deckdropdown=By.xpath("//select[@id='deckDropdown']");//describing the deck drop down menu web element according to DOM structure
	static By royalsuite=By.xpath("//h4[text()='Royal Suite - 1 Bedroom']");//describing the royal suite bedroom  web element according to DOM structure
	static By closebtn=By.cssSelector("svg.email-capture__close");//describing the advertisement close button web element according to DOM structure
	
	public static WebElement holidayCruises(){
		element=driver.findElement(holidayCruises);//Using the holiday cruises locator creating the method and returning it
		return element;
	}

	public static WebElement searchicon(){
		element=driver.findElement(searchicon);//Using the search icon locator creating the method and returning it
		return element;
	}
	public static WebElement searchinput(){
		element=driver.findElement(searchinput);//Using the search textbox  locator creating the method and returning it
		return element;
	}
	
	public static WebElement deck(){
		element=driver.findElement(deck);//Using the specified cruise  locator creating the method and returning it
		return element;
	}
	
	public static WebElement deckimage(){
		element=driver.findElement(deckimage);//Using the deck image locator creating the method and returning it
		return element;
	}
	public static WebElement deckdropdown(){
		element=driver.findElement(deckdropdown);//Using the deck drop down locator creating the method and returning it
		return element;
	}
	
	public static WebElement royalsuite(){
		element=driver.findElement(royalsuite);//Using the royal suite locator creating the method and returning it
		return element;
	}
	 public static WebElement searchresult(){
		 element=driver.findElement(searchresult);//Using the search result locator creating the method and returning it
		 return element;
	 }
	 public static WebElement closebtn(){
		 element=driver.findElement(closebtn);//Using the close button locator creating the method and returning it
		 return element;
	 }

}
