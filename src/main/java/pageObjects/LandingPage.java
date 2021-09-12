package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	//By s=By.xpath("//*[@id=\\'homepage\\']/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button");
	By signin= By.cssSelector("a[href*='sign_in']");
	By title= By.cssSelector(".text-center");
	By navbar= By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	/*public WebElement Popup() {
		return driver.findElement(s);
	}*/
	
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigationBar() {
		return driver.findElement(navbar);
	}
	
}
