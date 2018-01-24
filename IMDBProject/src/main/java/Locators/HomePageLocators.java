package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageLocators {
	public static WebDriver driver;
	
	

	public final By SEARCH_TXTBOX=By.id("navbar-query");
	public final By SERCH_BTN=By.id("navbar-submit-button");
	public final By SEARCH_LSIT=By.xpath("(//table[@class='findList'])[1]/tbody/tr");
	public final By MOVIES_TAB=By.id("navTitleMenu");
	public final By MOST_POPULAR_LNK=By.xpath("//a[text()='Most Popular TV Shows']");
    public final By OTHER_SGN_IN_LNK=By.partialLinkText("Other Sign in options");
    public final By DROPDWN_LST=By.xpath("//li[@id='navUserMenu']/span[@class='downArrow']");
    public final By LOGOUTLINK=By.partialLinkText("Log Out");
	
	public WebElement getMOVIES_TAB(WebDriver driver) {
		return driver.findElement(MOVIES_TAB);
	}
	public By getDRPDWN_LST() {
		return SERCH_BTN;
	}



}
