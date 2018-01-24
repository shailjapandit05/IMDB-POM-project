package Components;

import org.openqa.selenium.WebDriver;

import Locators.RegistrationPageLocators;

public class RegistrationComponent extends RegistrationPageLocators {
WebDriver driver;
	
	public RegistrationComponent(WebDriver driver){
		this.driver=driver;
	}
	
	public RegistrationComponent clickOnCreateNewAcntBtn(){
		driver.findElement(CREATE_NEW_ACCOUNT_BTN).click();
		return this;	
	}
	
	public RegistrationComponent createAccount(){
		driver.findElement(YOUR_NAME_TXTBOX).sendKeys("Shailja");
		driver.findElement(EMAIL_TXTBOX).sendKeys("priyashr273@gmail.com");
		driver.findElement(PASSWORD_TXTBOX).sendKeys("123456@saM");
		driver.findElement(RE_PASSWORD_TXTBOX).sendKeys("123456@saM");
		driver.findElement(CREATE_IMDB_ACNT_BTN).click();
		return this;
	}
}
