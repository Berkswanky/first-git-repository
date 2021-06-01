package utilities;
/*
 * Author name- Harsh Mishra (908330)
 * Date-20/04/2021
 * Description- This class is used to initialize the diver and the web element
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {
	public static WebDriver driver;
	public static WebElement element;
	
	public BaseClass(WebDriver driver, WebElement element) {
		BaseClass.driver=driver;
		BaseClass.element=element;
	}

}
