package utilities;
/*
 * Author name- Harsh Mishra(908330)
 * Date- 20/04/2021
 * Description- This class contains the setting up of the driver and its path maximizing the window
 * setting up page load timeout opening the url closing of the browser and setting up of screenshot method for capturing the screenshot.
 */

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.google.common.io.Files;

public class DriverSetup extends BaseClass{
	
	
	public DriverSetup(WebDriver driver, WebElement element) {
		super(driver, element);
		// TODO Auto-generated constructor stub
	}
	//setting driver path

	static String driverpath=System.getProperty("user.id");
	static String chromedriverpath="D:\\WORKSPACE\\MiniProject-Alaska-Cruises\\WebDrivers\\chromedriver.exe ";
    static String firefoxdriverpath="D:\\WORKSPACE\\MiniProject-Alaska-Cruises\\WebDrivers\\geckodriver.exe";
    
    
    public static void invokeBrowser(String browsername){
    	try{
    		
	        if(browsername.equalsIgnoreCase("chrome"))//checking if browser name equals chrome
	        {
	           System.setProperty("webdriver.chrome.driver",chromedriverpath );//setting up the chrome driver path
	           ChromeOptions option=new ChromeOptions();
	           option.addArguments("--disable-notification");
	           driver=new ChromeDriver(option); 
	        
	       	  
	        }
	        else if(browsername.equalsIgnoreCase("firefox"))//checking if browser name equals firefox
	        {
	        	 System.setProperty("webdriver.gecko.driver",firefoxdriverpath);//setting up the firefox driver path
	        	 FirefoxOptions opt=new FirefoxOptions();
		         opt.addArguments("--disable-notification");
	             driver=new FirefoxDriver(opt);
	     
	        }
	        else 
	        {
	        	System.out.println("Select chrome or firefox ");//printing if any other browser name is selected except chrome or firefox
	        }
            }catch(Exception e){
			    e.printStackTrace();
		    }  
    	 driver.manage().window().maximize();//maximizing the window
         driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
         
        

    }
    
    public static void openUrl(){
		driver.get("https://www.royalcaribbean.com/alaska-cruises");
		//moving to the given url
		
	}
    
    public static void closeBrowser(){
		driver.close();//closing the browser
	}
    //setting up of screenshot method along with its file type and path
    public static void takeScreenShot(String filepath){
     	 TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
     	 File srcfile=takeScreenShot.getScreenshotAs(OutputType.FILE);
     	 File destFile=new File(filepath);
     	 try{
     		 Files.copy(srcfile,destFile);
     	 }
     	 catch(IOException e){
     		 e.printStackTrace();
     	 }
      }
   
	
}