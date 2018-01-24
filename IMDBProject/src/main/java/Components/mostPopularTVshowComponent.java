package Components;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import Locators.mostPopularTVShowsPageLoactors;

public class mostPopularTVshowComponent extends mostPopularTVShowsPageLoactors {

	WebDriver driver;
	public mostPopularTVshowComponent(WebDriver driver){
		this.driver=driver;
	}
	
	public mostPopularTVshowComponent clickLink(){
		driver.findElement(THE_WALKING_DEAD_LNK).click();
		return this;
	}
	
	public mostPopularTVshowComponent verifyCreatorName(){
		String CreatorName=driver.findElement(CREATOR_NAME).getText();
		assertEquals(CreatorName, "Frank Darabont", "Creator name is incorrect");
		return this;
	}
	
	
	
}
