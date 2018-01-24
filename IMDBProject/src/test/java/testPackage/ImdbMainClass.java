package testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Components.HomePageComponent;
import Components.RegistrationComponent;
import Components.mostPopularTVshowComponent;
import helperClasses.DataSheetTest;
import helperClasses.driverSetup;

public class ImdbMainClass {
	WebDriver driver;
	@BeforeMethod
	@Parameters({"browser"})
	public void setBrowsers(String browser){

		driver = driverSetup.initDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/");	
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
	
	@Test(dataProviderClass=DataSheetTest.class,dataProvider="userData")
	public void scenarioThree(String name,String email,String pass,String rePass) throws Exception{
		new HomePageComponent(driver).clickOnSignIn();
		new RegistrationComponent(driver).clickOnCreateNewAcntBtn().createAccount(name,email,pass,rePass);
		new HomePageComponent(driver).logout();
	}
	
	
	@AfterMethod
	public void teardown(){
//		driver.quit();
	}
}
