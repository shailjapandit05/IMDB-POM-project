package Components;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Locators.RegistrationPageLocators;
import helperClasses.DataSheetTest;

public class RegistrationComponent extends RegistrationPageLocators {
WebDriver driver;
DataSheetTest dst;
int i, j;
	public RegistrationComponent(WebDriver driver){
		this.driver=driver;
	}
	
	public RegistrationComponent clickOnCreateNewAcntBtn(){
		driver.findElement(CREATE_NEW_ACCOUNT_BTN).click();
		return this;	
	}
	@Test(dataProvider="userData")
	public RegistrationComponent createAccount(String name,String email,String pass,String rePass) throws Exception{
		String str=System.currentTimeMillis()+"";
	
		driver.findElement(YOUR_NAME_TXTBOX).sendKeys(name+str);
		driver.findElement(EMAIL_TXTBOX).sendKeys(email+str+"@gmail.com");
		driver.findElement(PASSWORD_TXTBOX).sendKeys(pass);
		driver.findElement(RE_PASSWORD_TXTBOX).sendKeys(rePass);
		driver.findElement(CREATE_IMDB_ACNT_BTN).click();
		return this;
	}
	
}
