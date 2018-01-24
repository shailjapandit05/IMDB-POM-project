package Locators;

import org.openqa.selenium.By;

public class RegistrationPageLocators {

	
	
	public final By CREATE_NEW_ACCOUNT_BTN=By.partialLinkText("Create a New Account");
	public final By YOUR_NAME_TXTBOX=By.id("ap_customer_name");
	public final By EMAIL_TXTBOX=By.id("ap_email");
	public final By PASSWORD_TXTBOX=By.id("ap_password");
	public final By RE_PASSWORD_TXTBOX=By.id("ap_password_check");
	public final By CREATE_IMDB_ACNT_BTN=By.id("continue");
}
