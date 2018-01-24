package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Components.HomePageComponent;
import Components.RegistrationComponent;
import Components.mostPopularTVshowComponent;
import helperClasses.driverSetup;

public class ImdbMainClass {
	WebDriver driver;
	@BeforeMethod
	@Parameters({"browser"})
	public void setBrowsers(String browser){

		driver = driverSetup.initDriver(browser);
		driver.get("http://www.imdb.com/");	
		driver.manage().window().maximize();
	}

	@Test
	public void scenarioOne()
	{
		new HomePageComponent(driver).enterText().verifyText();

	}
	
	@Test
	public void scenarioTwo()
	{
		new HomePageComponent(driver).selectMostPopularTVLink();
		new mostPopularTVshowComponent(driver).clickLink().verifyCreatorName();
	}
	
	@Test
	public void scenarioThree(){
		new HomePageComponent(driver).clickOnSignIn();
		new RegistrationComponent(driver).clickOnCreateNewAcntBtn().createAccount();
		new HomePageComponent(driver).logout();
	}
	
	
	@AfterMethod
	public void teardown(){
//		driver.quit();
	}
}
