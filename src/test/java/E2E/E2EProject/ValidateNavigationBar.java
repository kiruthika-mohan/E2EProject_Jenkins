package E2E.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basepageNavigation() throws IOException, InterruptedException {
		//driver=initializeDriver();
		//driver.get(prop.getProperty("url"));
		//Thread.sleep(7000L);
		//One is inheritance
		//creating page object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
		//Compare the text from the browser with the actual text.
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		//Assert.assertFalse(false);
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
