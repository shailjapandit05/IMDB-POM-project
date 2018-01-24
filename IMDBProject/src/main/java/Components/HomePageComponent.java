package Components;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Locators.HomePageLocators;

public class HomePageComponent extends HomePageLocators {
	public WebDriver driver;
	public RegistrationComponent regComp;
	

	public HomePageComponent(WebDriver driver) {
		this.driver = driver;


		// TODO Auto-generated constructor stub
	}

	public HomePageComponent enterText(){

		WebElement textBox=driver.findElement(SEARCH_TXTBOX);
		textBox.click();
		textBox.sendKeys("Walking Dead");
		driver.findElement(SERCH_BTN).click();
		return this;
	}

	public boolean verifyText(){
		List<WebElement> srchResults=driver.findElements(SEARCH_LSIT);
		boolean flag = false;
		for (WebElement webEle : srchResults) {
			if(webEle.getText().contains("The Walking Dead")){
				System.out.println("Text Present");
				flag = true;
				break;
			}
		}
		return flag;
	}
	public HomePageComponent selectMostPopularTVLink(){
		Actions act=new Actions(driver);
		act.moveToElement(getMOVIES_TAB(driver)).build().perform();
		driver.findElement(MOST_POPULAR_LNK).click();

		return this;
	}

	public RegistrationComponent clickOnSignIn(){
		driver.findElement(OTHER_SGN_IN_LNK).click();
		return regComp;
	}
	public HomePageComponent logout(){
		/*Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(DROPDWN_LST))
			.click()
			.click(driver.findElement(LOGOUTLINK)).build().perform();*/
		driver.findElement(DROPDWN_LST).click();
		driver.findElement(LOGOUTLINK).click();
		return this;
	}

}
