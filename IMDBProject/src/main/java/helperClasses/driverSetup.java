package helperClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Parameter;

public class driverSetup {

	public static WebDriver driver;
	
	public static WebDriver initDriver(String browserName){
		if(browserName.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(browserName.contains("ie")){

		}
		else if(browserName.contains("firefox")){

		}
		return driver;
	}
}
