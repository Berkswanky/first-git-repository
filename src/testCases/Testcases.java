package testCases;
/*
 * Author name- Harsh Mishra (908330)
 * Date- 20/04/2021
 * Description- This class invokes the methods from the different classes and the flow of the project is mainted step by step.
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.junit.Test;
import org.testng.annotations.Test;

import appModules.Testmodules;
import org.openqa.selenium.WebDriver;
import utilities.DriverSetup;
import utilities.Excelutilities;

public class Testcases {
	static WebDriver driver=null;
	//public static String baseUrl;
	   @Test
	   public  void main(){
			try
		{
				//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
				 
		        Excelutilities.setExcelFile(Excelutilities.xlFilepath,"Details");
			    Scanner in= new Scanner(System.in);
			    System.out.println("Enter the name of the browser");// asking input for the name of the browser
			    String browser=in.nextLine();
		        DriverSetup.invokeBrowser(browser);//invoking the browser
			    
				//DriverSetup.invokeBrowser("fireFox");
			    DriverSetup.openUrl();//opening the url 
			    Testmodules.scrolldown();//scrolling down until holiday cruises comes to view	    
			    Testmodules.ElementClick();//clicking on holiday cruises
			    Testmodules.Searchicon();//clicking on search icon
			    Testmodules.getTotalSearchResults();//getting the total search result
			    Testmodules.deck();//selecting the specific cruise
			    Testmodules.getdeckimage();// getting the deck image
			    Testmodules.selectdropdown();//selecting the deck drop down option
			    Testmodules.royalsuite();//checking whether royal suite is present or not
			    DriverSetup.closeBrowser();// closing the browser
			    in.close();// closing the scanner class
		 }
	    catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
